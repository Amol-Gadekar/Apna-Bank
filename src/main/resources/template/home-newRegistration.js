alert("!");

// fetch('http://localhost:8080/addAccountHolder',);

const form = document.getElementById('submit-new-registration');

form.addEventListener('submit', e=> {
    e.preventDefault();

const payload = new FormData(form);
const temp = Object.fromEntries(payload);

fetch('http://localhost:8080/addAccountHolder',{
    method: 'post',
    mode: 'same-origin',
    headers: {
        'content-type': 'application/x-www-form-urlencoded',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'POST, GET'
    },
    body: JSON.stringify(temp)
}).then(res => res.json())
  .then(data=> console.log(data))
  .catch(err=> (console.error(err)));
})