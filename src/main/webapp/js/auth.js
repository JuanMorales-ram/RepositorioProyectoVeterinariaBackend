/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const API = '/veterinaria/api';

document.getElementById('loginForm')?.addEventListener('submit', e => {
  e.preventDefault();

  fetch(`${API}/login`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      username: username.value,
      password: password.value
    })
  })
  .then(r => {
    if (!r.ok) throw 'Credenciales inválidas';
    return r.json();
  })
  .then(() => window.location.href = 'dashboard.html')
  .catch(err => document.getElementById('error').innerText = err);
});

function logout () {
    fetch(`${API}/logout`, {method: 'POST'})
            .then(() => window.location.href = 'index.html');
}