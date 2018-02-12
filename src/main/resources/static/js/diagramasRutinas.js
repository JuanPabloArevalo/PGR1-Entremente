var diagramaRutinas = (function () {
    return{
        cargarAcertadas(datos, fechas) {
            var chart = $('#preguntasAcertadasRutinas').highcharts({
                chart: {
                    type: 'column'
                },
                credits: {
                    text: '',
                    href: ''
                },
                title: {
                    text: 'Preguntas acertadas'
                },
                colors: ['#00b33c'],
                xAxis: {
                    categories: fechas
                },
                yAxis: {
                    title: {
                        text: 'Cantida Preguntas'
                    }
                },
                series: [{
                        name: 'Preguntas Acertadas',
                        data: datos
                    }]
            });
        },
        cargarErroneas(datos, fechas) {
            var chart = $('#preguntasErroneasRutinas').highcharts({
                chart: {
                    type: 'column'
                },
                credits: {
                    text: '',
                    href: ''
                },
                title: {
                    text: 'Preguntas Erroneas'
                },
                colors: ['#cc2900'],
                xAxis: {
                    categories: fechas
                },
                yAxis: {
                    title: {
                        text: 'Cantida Preguntas'
                    }
                },
                series: [{
                        name: 'Preguntas Erroneas',
                        data: datos
                    }]
            });
        },
        cargarTiempo(datos, fechas) {
            var chart = $('#tiempoJugadoRutinas').highcharts({
                chart: {
                    type: 'column'
                },
                credits: {
                    text: '',
                    href: ''
                },
                title: {
                    text: 'Tiempo jugado'
                },
                colors: ['#4d4dff'],
                xAxis: {
                    categories: fechas
                },
                yAxis: {
                    title: {
                        text: 'Minutos'
                    }
                },
                series: [{
                        name: 'Tiempo Jugado',
                        data: datos
                    }]
            });
        },
        cargarNivelMaximo(datos, fechas) {
            var chart = $('#nivelMaximoRutinas').highcharts({
                chart: {
                    type: 'column'
                },
                credits: {
                    text: '',
                    href: ''
                },
                title: {
                    text: 'Nivel máximo alcanzado'
                },
                colors: ['#b3b300'],
                xAxis: {
                    categories: fechas
                },
                yAxis: {
                    title: {
                        text: 'Nivel'
                    }
                },
                series: [{
                        name: 'Nivel Alcanzado',
                        data: datos
                    }]
            });
        }
    };
}());
