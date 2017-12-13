//OPERACIONES
$(function () { 
	var chart = $('#preguntasAcertadasPercepciones').highcharts({
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
                    	categories: ['1','2','3','4','5','6','7','8','9','10','11','12']
                },
                yAxis: {
                    	title: {
                        	text: 'Cantida Preguntas'
                    	}
                },
                series: [{
                    	name: 'Preguntas Acertadas',
                    	data: [0,12,45,25,14,36,22,15,2,10,11,36]
                }]
        });
});
        
$(function () { 
	var chart = $('#preguntasErroneasPercepciones').highcharts({
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
                    	categories: ['1','2','3','4','5','6','7','8','9','10','11','12']
                },
                yAxis: {
                    	title: {
                        	text: 'Cantidad Preguntas'
                    	}
                },
                series: [{
                    	name: 'Preguntas Erroneas',
                    	data: [8,15,14,6,10,25,11,3,14,28,11,1]
                }]
	});
});

$(function () { 
	var chart = $('#tiempoJugadoPercepciones').highcharts({
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
                    	categories: ['1','2','3','4','5','6','7','8','9','10','11','12']
                },
                yAxis: {
                    	title: {
                        	text: 'Minutos'
                    	}
                },
                series: [{
                    	name: 'Tiempo Jugado',
                    	data: [4,8,24,14,12,5,28,31,14,2,36,1]
                }]
	});
});

$(function () { 
	var chart = $('#nivelMaximoPercepciones').highcharts({
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
                    	categories: ['1','2','3','4','5','6','7','8','9','10','11','12']
                },
                yAxis: {
                    	title: {
                        	text: 'Nivel'
                    	}
                },
                series: [{
                    	name: 'Nivel Alcanzado',
                    	data: [1,2,4,1,1,2,4,4,1,1,1,2],
                    	colorByPoint: true
                }]
	});
});