const express = require('express');
const http = require('http');
const app = express();
const port = 8080;

// don't cache responses, we want to trigger a new request to the name-generator with each call to /suggestion
app.set('etag', false)

// terminate on ctrl-c
process.on('SIGINT', function() {
    process.exit();
});

// Serve static files from the /static/ directory
app.use(express.static('static'));

app.get('/', function (req, res) {
    res.sendFile('/static/index.html');
});

// usage: GET /suggestion?language=english&gender=boy
// This will make a call to the name-generator to get a name, and return a JSON with the name, gender, and language
app.get('/suggestion', (req, res) => {

    const language = req.query.language;
    const gender = req.query.gender;

    const options = {
        protocol: 'http:',
        host: process.env.NAME_GENERATOR_HOST || 'localhost',
        port: 8081,
        path: '/names/' + language + '/' + gender
    };

    const fullUrl = options.protocol + '//' + options.host + ':' + options.port + options.path;
    console.log("-> GET " + fullUrl);

    http.get(options, function (nameServiceResponse) {
        let bodyChunks = [];
        nameServiceResponse
            .on('data', function (chunk) {
                bodyChunks.push(chunk);
            })
            .on('end', function () {
                const body = Buffer.concat(bodyChunks);
                console.log('<- ' + body);
                res.send({
                    'language': language,
                    'gender': gender,
                    'name': body.toString().trim()
                })
            })
            .on('error', function (err) {
                res.status(500).send(err.message)
            })
    }).on('error', function(err) {
        if (err.code === 'ENOTFOUND') {
            res.status(500).send('The frontend service failed to call to the name-generator service on ' + fullUrl)
        } else {
            res.status(500).send(err.message)
        }
    });
});

app.listen(port, () => {
    console.log(`Listening on http://localhost:${port}`);
});