google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawUsingServiceChart);
		
				function drawUsingServiceChart(){
					var dataChart = document.getElementById('usingService_Chart').innerHTML;
					var dataChartArr = dataChart.split('#');
					document.getElementById('usingService_Chart').innerHTML = "";
			
					var data = new google.visualization.DataTable();
				  	data.addColumn('string', 'Using Service');
				  	data.addColumn('number', 'Total');
		  	
		  			data.addRows([
				  		['Using service', parseInt(dataChartArr[0])],
				  		['Dont use', parseInt(dataChartArr[1])]
				  	]);
		  		
				  	var options = {
				  	    	title: 'Using Service',
				  	    	'width':600,
		                    'height':300,'backgroundColor':"#F1F3EF"
				  	  	};

		  			var chart = new google.visualization.PieChart(document.getElementById('usingService_Chart_div'));
		  			chart.draw(data, options);
				}
				
				
				google.setOnLoadCallback(drawUploadServiceChart);
				function drawUploadServiceChart(){
					
					var dataNameChart = document.getElementById('uploadServiceName_Chart').innerHTML;
					var dataNameChartArr = dataNameChart.split('#');
					document.getElementById('uploadServiceName_Chart').innerHTML = "";
				
					var dataChart = document.getElementById('uploadServiceTotal_Chart').innerHTML;
					var dataChartArr = dataChart.split('#');
					document.getElementById('uploadServiceTotal_Chart').innerHTML = "";
				
					var data = new google.visualization.DataTable();
			        data.addColumn('string', 'Upload Service Package');
		    	    data.addColumn('number', 'total');
		        
		        	var array = new Array();
			        for ( var i = 0; i < (dataChartArr.length - 1); i++) {
						array[i] = ([dataNameChartArr[i], parseInt(dataChartArr[i])]);
					}
		        
		    	    data.addRows(array);
		        
		        	var options = {
			  		    	title: 'Upload package service',
			  		    	'width':600,
		                    'height':300,'backgroundColor':"#F1F3EF"
			  	  		};
		        
			        var chart = new google.visualization.PieChart(document.getElementById('uploadService_Chart_div'));
			  		chart.draw(data, options);
				}