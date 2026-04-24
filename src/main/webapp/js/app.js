/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const API = '/veterinaria/api';

function cargarMascotas() {
  document.getElementById('titulo').innerText = 'Mascotas';

  fetch(`${API}/mascotas`)
    .then(r => {
      if (r.status === 401) window.location.href = 'index.html';
      return r.json();
    })
    .then(data => {
      let html = `<table class="table table-striped">
        <tr><th>Nombre</th><th>Especie</th><th>Raza</th><th>Propietario</th></tr>`;

      data.forEach(m => {
        html += `<tr>
          <td>${m.nombre}</td>
          <td>${m.especie}</td>
          <td>${m.raza}</td>
          <td>${m.propietario}</td>
        </tr>`;
      });

      html += `</table>`;
      document.getElementById('contenido').innerHTML = html;
    });
}

function cargarPropietarios() {
  document.getElementById('titulo').innerText = 'Propietarios';

  fetch(`${API}/propietarios`)
    .then(r => r.json())
    .then(data => {
      let html = `<ul class="list-group">`;
      data.forEach(p => {
        html += `<li class="list-group-item">
          ${p.nombres} ${p.apellidos} <b>Teléfono:</b> ${p.telefono} <b>Correo:</b> ${p.email}
        </li>`;
      });
      html += `</ul>`;
      document.getElementById('contenido').innerHTML = html;
    });
}

function cargarVeterinarios() {
  document.getElementById('titulo').innerText = 'Veterinarios';

  fetch(`${API}/veterinarios`)
    .then(r => r.json())
    .then(data => {
      let html = `<ul class="list-group">`;
      data.forEach(v => {
        html += `<li class="list-group-item">
          ${v.nombres} ${v.apellidos} - ${v.especialidad}
        </li>`;
      });
      html += `</ul>`;
      document.getElementById('contenido').innerHTML = html;
    });
}