new Chart(document.getElementById('ingresosChart'), {
    type: 'bar',
    data: {
        labels: ['Enero', 'Febrero'],
        datasets: [{
            label: 'Ingresos',
            data: [150, 180],
            backgroundColor: 'green'
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        interaction: {
            mode: 'index',
            intersect: false
        },
        plugins: {
            tooltip: {enabled: true}
        }
    }
});

// SALIDAS
new Chart(document.getElementById('salidasChart'), {
    type: 'bar',
    data: {
        labels: ['Enero', 'Febrero'],
        datasets: [{
            label: 'Salidas',
            data: [100, 120],
            backgroundColor: 'red'
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        interaction: {
            mode: 'index',
            intersect: false
        },
        plugins: {
            tooltip: {enabled: true}
        }
    }
});

// STOCK
new Chart(document.getElementById('stockChart'), {
    type: 'line',
    data: {
        labels: ['Enero', 'Febrero'],
        datasets: [{
            label: 'Stock',
            data: [50, 60],
            borderColor: 'blue',
            fill: false
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        interaction: {
            mode: 'index',
            intersect: false
        },
        plugins: {
            tooltip: {enabled: true}
        }
    }
});

// USUARIOS
new Chart(document.getElementById('usuariosChart'), {
    type: 'doughnut',
    data: {
        labels: ['Registrados', 'Activos'],
        datasets: [{
            data: [35, 28],
            backgroundColor: ['purple', 'orange']
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        interaction: {
            mode: 'index',
            intersect: false
        },
        plugins: {
            tooltip: {enabled: true}
        }
    }
});

// PROVEEDORES
new Chart(document.getElementById('proveedoresChart'), {
    type: 'bar',
    data: {
        labels: ['Chip', 'Router', 'Celulares', 'Modem'],
        datasets: [
            {
                label: 'Movistar',
                data: [100, 50, 80, 40],
                backgroundColor: 'blue'
            },
            {
                label: 'Entel',
                data: [90, 60, 70, 30],
                backgroundColor: 'orange'
            }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        interaction: {
            mode: 'index',
            intersect: false
        },
        plugins: {
            tooltip: {enabled: true}
        }
    }
});

/// GRÁFICO 2: MOVIMIENTOS
new Chart(document.getElementById('movimientosChart'), {
    type: 'line',
    data: {
        labels: ['Enero', 'Febrero'],
        datasets: [
            {
                label: 'Entrada',
                data: [150, 180],
                borderColor: 'green',
                fill: false
            },
            {
                label: 'Salida',
                data: [100, 120],
                borderColor: 'red',
                fill: false
            },
            {
                label: 'Stock',
                data: [200, 260],
                borderColor: 'blue',
                fill: false
            }
        ]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        interaction: {
            mode: 'index',
            intersect: false
        },
        plugins: {
            tooltip: {enabled: true}
        }
    }
});