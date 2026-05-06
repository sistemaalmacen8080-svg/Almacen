function mostrarGuardar() {
    document.getElementById("modalGuardar").style.display = "flex";
}

function cerrarGuardar() {
    document.getElementById("modalGuardar").style.display = "none";
}

function mostrarEliminar() {
    document.getElementById("modalEliminar").style.display = "flex";
}

function cerrarEliminar() {
    document.getElementById("modalEliminar").style.display = "none";
}


///... 
function agregarFila() {
    const tbody = document.getElementById("detalleProductos");

    const filas = tbody.getElementsByTagName("tr");
    const index = filas.length;

    const filaBase = filas[0]; // clonamos la primera fila
    const nuevaFila = filaBase.cloneNode(true);

    // actualizar índice visual
    nuevaFila.querySelector(".indice").textContent = index + 1;

    // actualizar select
    const select = nuevaFila.querySelector("select");
    select.name = `detalles[${index}].idProducto`;
    select.value = "";

    // actualizar input cantidad
    const cantidad = nuevaFila.querySelector("input");
    cantidad.name = `detalles[${index}].cantidad`;
    cantidad.value = "";

    tbody.appendChild(nuevaFila);
}

function eliminarFila(btn) {
    const fila = btn.closest("tr");
    const tbody = document.getElementById("detalleProductos");

    fila.remove();

    // reindexar todo
    const filas = tbody.getElementsByTagName("tr");

    for (let i = 0; i < filas.length; i++) {
        filas[i].querySelector(".indice").textContent = i + 1;

        const select = filas[i].querySelector("select");
        const input = filas[i].querySelector("input");

        select.name = `detalles[${i}].idProducto`;
        input.name = `detalles[${i}].cantidad`;
    }
}

function actualizarNumeracion() {
     let filas = document.querySelectorAll("#detalleProductos tr");
     filas.forEach((fila, index) => {
    fila.cells[0].innerText = index + 1;
    });
}