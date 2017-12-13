//OPERACIONES
$(function () { 
	var chart = $('#preguntasAcertadasOperaciones').highcharts({
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
                    	data: [10,50,15,24,35,17,2,28,30,11,12,14]
                }]
        });
});
        
$(function () { 
	var chart = $('#preguntasErroneasOperaciones').highcharts({
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
                        	text: 'Cantida Preguntas'
                    	}
                },
                series: [{
                    	name: 'Preguntas Erroneas',
                    	data: [1,12,4,6,8,1,2,3,4,5,1,12]
                }]
	});
});

$(function () { 
	var chart = $('#tiempoJugadoOperaciones').highcharts({
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
                    	data: [16,25,10,4,5,9,27,8,12,11,35,29]
                }]
	});
});

$(function () { 
	var chart = $('#nivelMaximoOperaciones').highcharts({
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
                    	data: [1,4,2,2,2,5,1,1,3,4,1,2]
                }]
	});
});