$(function () { 
	var chart = $('#preguntasResumen').highcharts({
        	chart: {
                	type: 'column'
                },          
	        credits: {
	               	text: '',
	              	href: ''
	        },
                title: {
                    	text: 'Preguntas'
                },
               	colors: ['#00b33c', '#cc2900'],
                xAxis: {
                    	categories: ['Acertadas', 'Erroneas']
                },
                yAxis: {
                    	title: {
                        	text: 'Cantidad de Preguntas'
                    	}
                },
                series: [{
                    	name: 'Preguntas',
                    	type: 'column',
       		 	colorByPoint: true,
                    	data: [132, 60], 
                }]
	});
});