/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function login() {
    const usuario = document.getElementById("usuario").value;
    const password = document.getElementById("password").value;
    const error = document.getElementById("error");

    // Validar campos vacíos
    if (usuario === "" || password === "") {
        error.textContent = "Todos los campos son obligatorios";
        return;
    }

    // Simulación de login
    if (usuario === "Juan" && password === "buenanota5") {
        window.location.href = "dashboard.html";
    } else {
        error.textContent = "Usuario o contraseña incorrectos";
    }
}

/*cargar la vista del dashboard*/

function cargarVista(vista) {
    const contenido = document.getElementById("contenido");

    if (vista === "mascotas") {
        contenido.innerHTML = `
            <h2>Gestión de Mascotas</h2>
            
        <input type="text" id="nombre" placeholder="Nombre">
        <input type="number" id="edad" placeholder="Edad">
        <input type="text" id="tipo" placeholder="Tipo">
        <input type="text" id="propietario" placeholder="Propietario">

        <button onclick="agregarMascota()">Agregar</button>

        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Tipo</th>
                    <th>Propietario</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody id="tabla-mascotas"></tbody>
        </table>

        <!-- TEMPLATE -->
        <template id="fila-mascota">
            <tr>
                <td class="nombre"></td>
                <td class="edad"></td>
                <td class="tipo"></td>
                <td class="propietario"></td>
                <td>
                    <button class="eliminar">Eliminar</button>
                    <button class="editar">Editar</button>
                </td>
            </tr>
        </template>
        `;
        renderMascotas();
        
        }

    if (vista === "propietarios") {
        contenido.innerHTML = `
            <h2>Gestión de Propietarios</h2>
            
            <input type="text" id="nombreP" placeholder="Nombre">
        <input type="text" id="telefonoP" placeholder="Teléfono">
        <input type="text" id="direccionP" placeholder="Dirección">

        <button onclick="agregarPropietario()">Agregar</button>

        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Teléfono</th>
                    <th>Dirección</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody id="tabla-propietarios"></tbody>
        </table>

        <template id="fila-propietario">
            <tr>
                <td class="nombre"></td>
                <td class="telefono"></td>
                <td class="direccion"></td>
                <td>
                    <button class="editar">Editar</button>
                    <button class="eliminar">Eliminar</button>
                </td>
            </tr>
        </template>
        `;
        renderPropietarios();
        
        }
    

    if (vista === "veterinarios") {
        contenido.innerHTML = `
            <h2>Gestión de Veterinarios</h2>
            
            <input type="text" id="nombreV" placeholder="Nombre">
        <input type="text" id="especialidadV" placeholder="Especialidad">
        <input type="text" id="contactoV" placeholder="Contacto">

        <button onclick="agregarVeterinario()">Agregar</button>

        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Especialidad</th>
                    <th>Contacto</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody id="tabla-veterinarios"></tbody>
        </table>

        <template id="fila-veterinario">
            <tr>
                <td class="nombre"></td>
                <td class="especialidad"></td>
                <td class="contacto"></td>
                <td>
                    <button class="editar">Editar</button>
                    <button class="eliminar">Eliminar</button>
                </td>
            </tr>
        </template>
        `;
        renderVeterinarios();
    }
}

/*logica respectiva a mascota */
let mascotas = [];
let indiceEditar = null;

function agregarMascota() {
    const nombre = document.getElementById("nombre").value;
    const edad = document.getElementById("edad").value;
    const tipo = document.getElementById("tipo").value;
    const propietario = document.getElementById("propietario").value;
    
    const soloLetras = /^[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+$/;

    if (nombre === "" || edad === "" || tipo === "") {
        alert("Todos los campos son obligatorios");
        return;
    }
    
    if (!soloLetras.test(nombre)) {
        alert("El nombre solo debe contener letras");
        return;
    }
    
    if (!soloLetras.test(tipo)) {
        alert("El tipo solo debe contener letras");
        return;
    }
    
    if (!soloLetras.test(propietario)) {
    alert("El propietario solo debe contener letras");
    return;
    }
    
   
    
     if (isNaN(edad) || edad <= 0) {
        alert("La edad debe ser un número válido");
        return;
    }


    if (indiceEditar === null) {
        // CREAR
        mascotas.push({ nombre, edad, tipo, propietario });
    } else {
        // EDITAR
        mascotas[indiceEditar] = { nombre, edad, tipo, propietario };
        indiceEditar = null;
    }

    limpiarFormulario();
    renderMascotas();
}

function renderMascotas() {
    const tabla = document.getElementById("tabla-mascotas");
    const templateBase = document.querySelector("#contenido #fila-mascota");

    if (!tabla || !templateBase) return;
    
    tabla.innerHTML = "";

    mascotas.forEach((m, index) => {
        const template = templateBase.content.cloneNode(true);

        template.querySelector(".nombre").textContent = m.nombre;
        template.querySelector(".edad").textContent = m.edad;
        template.querySelector(".tipo").textContent = m.tipo;
        template.querySelector(".propietario").textContent = m.propietario;
        

        template.querySelector(".eliminar").onclick = () => {
            eliminarMascota(index);
        };
        
        template.querySelector(".editar").onclick = () => {
            editarMascota(index);
        };

        tabla.appendChild(template);
    });
}

function limpiarFormulario() {
    document.getElementById("nombre").value = "";
    document.getElementById("edad").value = "";
    document.getElementById("tipo").value = "";
    document.getElementById("propietario").value = "";
    
}

function eliminarMascota(index) {
    mascotas.splice(index, 1);
    renderMascotas();
}

function editarMascota(index) {
    const mascota = mascotas[index];

    document.getElementById("nombre").value = mascota.nombre;
    document.getElementById("edad").value = mascota.edad;
    document.getElementById("tipo").value = mascota.tipo;
    document.getElementById("propietario").value = mascota.propietario;
    

    indiceEditar = index;
}


/*LOGICA PROPIETARIOS*/
let propietarios = [];
let indiceEditarProp = null;

function agregarPropietario() {
    const nombre = document.getElementById("nombreP").value;
    const telefono = document.getElementById("telefonoP").value;
    const direccion = document.getElementById("direccionP").value;
    
    const soloLetras = /^[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+$/;
    const soloNumeros = /^[0-9]+$/;

    if (nombre === "" || telefono === "" || direccion === "") {
        alert("Todos los campos son obligatorios");
        return;
    }
    
    if (!soloLetras.test(nombre)) {
        alert("El nombre solo debe contener letras");
        return;
    }
    
    if (!soloNumeros.test(telefono)) {
    alert("El teléfono solo debe contener números");
    return;
    }

    if (indiceEditarProp === null) {
        propietarios.push({ nombre, telefono, direccion });
    } else {
        propietarios[indiceEditarProp] = { nombre, telefono, direccion };
        indiceEditarProp = null;
    }

    limpiarFormularioProp();
    renderPropietarios();
}

function renderPropietarios() {
    const tabla = document.getElementById("tabla-propietarios");
    tabla.innerHTML = "";

    propietarios.forEach((p, index) => {
        const template = document
            .getElementById("fila-propietario")
            .content.cloneNode(true);

        template.querySelector(".nombre").textContent = p.nombre;
        template.querySelector(".telefono").textContent = p.telefono;
        template.querySelector(".direccion").textContent = p.direccion;

        template.querySelector(".editar").onclick = () => {
            editarPropietario(index);
        };

        template.querySelector(".eliminar").onclick = () => {
            eliminarPropietario(index);
        };

        tabla.appendChild(template);
    });
}

function editarPropietario(index) {
    const p = propietarios[index];

    document.getElementById("nombreP").value = p.nombre;
    document.getElementById("telefonoP").value = p.telefono;
    document.getElementById("direccionP").value = p.direccion;

    indiceEditarProp = index;
}

function eliminarPropietario(index) {
    propietarios.splice(index, 1);
    renderPropietarios();
}

function limpiarFormularioProp() {
    document.getElementById("nombreP").value = "";
    document.getElementById("telefonoP").value = "";
    document.getElementById("direccionP").value = "";
}

/*LOGICA VETERINARIOS*/
let veterinarios = [];
let indiceEditarVet = null;

function agregarVeterinario() {
    const nombre = document.getElementById("nombreV").value;
    const especialidad = document.getElementById("especialidadV").value;
    const contacto = document.getElementById("contactoV").value;
    
    const soloLetras = /^[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+$/;
    

    if (nombre === "" || especialidad === "" || contacto === "") {
        alert("Todos los campos son obligatorios");
        return;
    }
    
    if (!soloLetras.test(nombre)) {
        alert("El nombre solo debe contener letras");
        return;
    }
    
    if (!soloLetras.test(especialidad)) {
        alert("La especialidad solo debe contener letras");
        return;
    }
    
    

    if (indiceEditarVet === null) {
        veterinarios.push({ nombre, especialidad, contacto });
    } else {
        veterinarios[indiceEditarVet] = { nombre, especialidad, contacto };
        indiceEditarVet = null;
    }

    limpiarFormularioVet();
    renderVeterinarios();
}

function renderVeterinarios() {
    const tabla = document.getElementById("tabla-veterinarios");
    tabla.innerHTML = "";

    veterinarios.forEach((v, index) => {
        const template = document
            .getElementById("fila-veterinario")
            .content.cloneNode(true);

        template.querySelector(".nombre").textContent = v.nombre;
        template.querySelector(".especialidad").textContent = v.especialidad;
        template.querySelector(".contacto").textContent = v.contacto;

        template.querySelector(".editar").onclick = () => {
            editarVeterinario(index);
        };

        template.querySelector(".eliminar").onclick = () => {
            eliminarVeterinario(index);
        };

        tabla.appendChild(template);
    });
}

function editarVeterinario(index) {
    const v = veterinarios[index];

    document.getElementById("nombreV").value = v.nombre;
    document.getElementById("especialidadV").value = v.especialidad;
    document.getElementById("contactoV").value = v.contacto;

    indiceEditarVet = index;
}

function eliminarVeterinario(index) {
    veterinarios.splice(index, 1);
    renderVeterinarios();
}

function limpiarFormularioVet() {
    document.getElementById("nombreV").value = "";
    document.getElementById("especialidadV").value = "";
    document.getElementById("contactoV").value = "";
}