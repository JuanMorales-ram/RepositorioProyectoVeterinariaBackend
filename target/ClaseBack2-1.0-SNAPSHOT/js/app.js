/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const API = '/veterinaria/api';

 // Logout funcion
function logout() {
    fetch('/veterinaria/api/logout', {
        method: 'POST'
    })
    .then(response => {
        if (response.status === 200) {
            window.location.href = 'index.html'; // Redirige al inicio
        }
    })
    .catch(error => {
        console.error('Error durante el cierre de sesión:', error);
    });
}

function cargarMascotas() {
  document.getElementById('titulo').innerText = 'Mascotas';

  fetch(`${API}/mascotas`)
    .then(r => {
      if (r.status === 401) window.location.href = 'index.html';
      return r.json();
    })
    .then(data => {
      let html = `
        <button class="btn btn-success mb-3" onclick="mostrarFormularioMascota()">Nueva Mascota</button>

        <table class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Especie</th>
            <th>Raza</th>
            <th>Propietario</th>
        </tr>
        </thead>
        <tbody>`;

      data.forEach(m => {
        html += `<tr>
          <td>${m.nombre}</td>
          <td>${m.especie}</td>
          <td>${m.raza}</td>
          <td>${m.propietario}</td>
          <td>
            <button class="btn btn-sm btn-warning" onclick='editarMascota'(${JSON.stringify(m)})'>Editar</button>
            <button class="btn btn-sm btn-danger" onclick='eliminarMascota(${m.id})'>Eliminar</button> 
          </td>
        </tr>`;
      });

      html += `</tbody></table>`;
      document.getElementById('contenido').innerHTML = html;
    });
}

function mostrarFormularioMascota() {
    const template = document.getElementById('formMascotaTemplate');

    if (!template) {
        console.error('Template formMascotaTemplate no encontrado');
        return;
    }

    const clone = template.content.cloneNode(true);

    const contenido = document.getElementById('contenido');
    contenido.innerHTML = '';
    contenido.appendChild(clone);

    cargarSelectPropietarios();
}

function cargarSelectPropietarios(){
    fetch('/veterinaria/api/propietarios')
            .then(r=> r.json())
            .then(data => {
                
                const select = document.getElementById('idPropietario');
        
                if (!select){
                    console.error('Select idPropietario no existe en el DOM');
                    return;
                }
                
                select.innerHTML = '<option value="">Seleccione propietario</option>';
                
                data.forEach(p=>{
                    const option = document.createElement('option');
                    option.value = p.id;
                    option.textContent =  `${p.nombres} ${p.apellidos}`;
                    select.appendChild(option);
                });
    })
            .catch(err=> console.error('Error cargando propietarios', err));
    
}

function guardarMascota(e) {
    e.preventDefault();

    const idProp = document.getElementById('idPropietario').value;

    if (!idProp) {
        alert('Debe seleccionar un propietario');
        return;
    }

    const mascota = {
        nombre: document.getElementById('nombre').value,
        especie: document.getElementById('especie').value,
        raza: document.getElementById('raza').value,
        sexo: document.getElementById('sexo').value,
        fechaNacimiento: document.getElementById('fechaNacimiento').value,
        color: document.getElementById('color').value,
        pesoActual: document.getElementById('pesoActual').value,
        propietario: {
            idPropietario: Number(idProp) // conversión explícita
        }
    };
    
    fetch('/veterinaria/api/mascotas', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(mascota)
    }).then(() => cargarMascotas());
}


function editarMascota(m) {
    mostrarFormularioMascota();

    document.getElementById('idMascota').value = m.id;
    document.getElementById('nombre').value = m.nombre;
    document.getElementById('especie').value = m.especie;
    document.getElementById('raza').value = m.raza;
    document.getElementById('sexo').value = m.sexo; // Asignar el sexo correctamente
    document.getElementById('fechaNacimiento').value = m.fechaNacimiento; // Asegúrate que el formato es correcto
    document.getElementById('color').value = m.color;
    document.getElementById('pesoActual').value = m.pesoActual;

    // Asignar el propietario en el select (idPropietario)
    setTimeout(() => {
        console.log(m.idPropietario);
        const selectPropietario = document.getElementById('idPropietario');
        selectPropietario.value = m.idPropietario; // Usar el idPropietario de m.propietario
    }, 300); // Espera un poco para asegurarse que el select haya cargado antes de asignar el valor
}


function cargarPropietarios() {
  document.getElementById('titulo').innerText = 'Propietarios';

  fetch(`${API}/propietarios`)
    .then(r => {
        if(r.status === 401) window.location.href = 'index.html';
        return r.json();
  })
          .the(data=>{
              let html = `
                <button class="btn btn-success mb-3" onclick="mostrarFormularioPropietario()">Nuevo</button>
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Documento</th>
                            <th>Teléfono</th>
                            <th>Correo</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>    
                    <tbody>`;
        
                    data.forEach(p=>{
                        html += `
                        <tr>
                            <td>${p.nombres} ${p.apellidos}</td>
                            <td>${p.numeroDocumento}</td>
                            <td>${p.telefono}</td>
                            <td>${p.email}</td>
                            <td>
                                <button class="btn btn-sm btn-warning" onclick='editarPropietario(${JSON.stringify(p)})'>Editar</button>
                                 <button class="btn btn-sm btn-danger" onclick="eliminarPropietario(${p.id})">Eliminar</button>
                            </td>
                        </tr>`;
                        
                    });
                    
                    html += `</tbody></table>`;
                    document.getElementById('contenido').innerHTML = html;        
  });
                
}

function mostrarFormularioPropietario() {
    const template = document.getElementById('formPropietarioTemplate');

    if (!template) {
        console.error('Template formPropietarioTemplate no encontrado');
        return;
    }

    const clone = template.content.cloneNode(true);

    const contenido = document.getElementById('contenido');
    contenido.innerHTML = '';
    contenido.appendChild(clone);
}


function guardarPropietario(e) {
    e.preventDefault();

    const propietario = {
        tipoDocumento: document.getElementById('tipoDocumento').value,
        numeroDocumento: document.getElementById('numeroDocumento').value,
        nombres: document.getElementById('nombres').value,
        apellidos: document.getElementById('apellidos').value,
        telefono: document.getElementById('telefono').value,
        email: document.getElementById('email').value,
        direccion: document.getElementById('direccion').value
    };

    fetch('/veterinaria/api/propietarios', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(propietario)
    }).then(() => cargarPropietarios());
}


function editarPropietario(p) {
    mostrarFormularioPropietario();

    document.getElementById('idPropietario').value = p.id;
    document.getElementById('tipoDocumento').value = p.tipoDocumento;
    document.getElementById('numeroDocumento').value = p.numeroDocumento;
    document.getElementById('nombres').value = p.nombres;
    document.getElementById('apellidos').value = p.apellidos;
    document.getElementById('telefono').value = p.telefono;
    document.getElementById('email').value = p.email;
    document.getElementById('direccion').value = p.direccion;
}

function eliminarPropietario(id) {
    if (!confirm('¿Está seguro de que desea eliminar este propietario?')) {
        return;
    }

    fetch(`/veterinaria/api/propietarios?id=${id}`, {
        method: 'DELETE'
    }).then(() => cargarPropietarios());
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

function cargarEstadisticas() {
    fetch('/veterinaria/api/estadisticas')
        .then(r => r.json())
        .then(data => {
            document.getElementById('mascotas-count').textContent = data.mascotas;
            document.getElementById('propietarios-count').textContent = data.propietarios;
            document.getElementById('veterinarios-count').textContent = data.veterinarios;
        })
        .catch(err => {
            console.error('Error al cargar las estadísticas:', err);
        });
}

// Llamar a la función al cargar la página del dashboard
document.addEventListener('DOMContentLoaded', cargarEstadisticas);