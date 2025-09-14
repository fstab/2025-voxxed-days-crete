import http from 'k6/http';

export const options = {
  // run 40 requests in parallel
  vus: 40,
  iterations: 40,
};

const genders = ['boy', 'girl'];
const languages = ['english', 'french', 'spanish', 'german'];

export default function () {
  let gender = genders[Math.floor(Math.random() * genders.length)];
  let language = languages[Math.floor(Math.random() * languages.length)];
  http.get("http://frontend:8080/suggestion?language=" + language + "&gender=" + gender);
}
