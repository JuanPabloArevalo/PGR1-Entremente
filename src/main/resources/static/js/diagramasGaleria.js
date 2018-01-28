//GALERIA
$(function () {
    var chart = $('#preguntasAcertadasGaleria').highcharts({
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
            categories: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {
            title: {
                text: 'Cantida Preguntas'
            }
        },
        series: [{
                name: 'Preguntas Acertadas',
                data: [5, 10, 7, 7, 7, 7, 2, 8, 5, 6, 1, 9]
            }]
    });
});

$(function () {
    var chart = $('#preguntasErroneasGaleria').highcharts({
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
            categories: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {
            title: {
                text: 'Cantida Preguntas'
            }
        },
        series: [{
                name: 'Preguntas Erroneas',
                data: [8, 2, 7, 7, 3, 0, 25, 12, 18, 32, 11, 4]
            }]
    });
});

$(function () {
    var chart = $('#tiempoJugadoGaleria').highcharts({
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
            categories: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {
            title: {
                text: 'Minutos'
            }
        },
        series: [{
                name: 'Tiempo Jugado',
                data: [11, 21, 15, 5, 38, 45, 36, 11, 22, 36, 11, 21]
            }]
    });
});

$(function () {
    var chart = $('#nivelMaximoGaleria').highcharts({
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
            categories: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {
            title: {
                text: 'Nivel'
            }
        },
        series: [{
                name: 'Nivel Alcanzado',
                data: [2, 5, 2, 1, 1, 2, 5, 5, 4, 4, 2, 3]
            }]
    });
});