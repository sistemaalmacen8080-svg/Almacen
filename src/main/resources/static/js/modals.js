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

    const nuevaFila = document.createElement("tr");

    nuevaFila.innerHTML = `
        <td class="indice">${index + 1}</td>

        <td>
            <select name="detalles[${index}].idProducto" required>
                ${filas[0].querySelector("select").innerHTML}
            </select>
        </td>

        <td>
            <input type="number"
                   name="detalles[${index}].cantidad"
                   required>
        </td>

        <td>
            <button type="button"
                    class="btn-eliminar"
                    onclick="eliminarFila(this)">
                X
            </button>
        </td>
    `;

    tbody.appendChild(nuevaFila);
}
function eliminarFila(btn) {

    const tbody = document.getElementById("detalleProductos");
    const filas = tbody.getElementsByTagName("tr");

    // no eliminar primera fila
    if (filas.length <= 1) {
        return;
    }

    const fila = btn.closest("tr");
    fila.remove();

    // reindexar
    const nuevasFilas = tbody.getElementsByTagName("tr");

    for (let i = 0; i < nuevasFilas.length; i++) {

        nuevasFilas[i].querySelector(".indice").textContent = i + 1;

        const select = nuevasFilas[i].querySelector("select");
        const input = nuevasFilas[i].querySelector("input");

        select.name = `detalles[${i}].idProducto`;
        input.name = `detalles[${i}].cantidad`;
    }
}