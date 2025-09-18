import http from 'k6/http';

export const options = {
  // run 5 requests in parallel
  vus: 5,
  iterations: 5,
  noConnectionReuse: true,
};

const genders = ['boy', 'girl'];
const languages = ['english', 'french', 'spanish', 'german'];

export default function () {
  let gender = genders[Math.floor(Math.random() * genders.length)];
  let language = languages[Math.floor(Math.random() * languages.length)];
  http.get("http://frontend:8080/suggestion?language=" + language + "&gender=" + gender);
}
