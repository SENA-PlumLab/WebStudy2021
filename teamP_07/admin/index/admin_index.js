var ctx = document.getElementById('myChart'); 
var myChart = new Chart(ctx, 
	{ type: 'bar', data: 
		{ 
			labels: ['2월', '3월', '4월', '5월', '6월', '7월'], 
			datasets: [
				{ label: '신규 가입자', 
					data: [12, 19, 3, 5, 2, 3], 
					backgroundColor: [
						'rgba(255, 99, 132, 0.2)', 
						'rgba(54, 162, 235, 0.2)', 
						'rgba(255, 206, 86, 0.2)', 
						'rgba(75, 192, 192, 0.2)', 
						'rgba(153, 102, 255, 0.2)', 
						'rgba(255, 159, 64, 0.2)'], 
					borderColor: [
						'rgba(255, 99, 132, 1)', 
						'rgba(54, 162, 235, 1)', 
						'rgba(255, 206, 86, 1)', 
						'rgba(75, 192, 192, 1)', 
						'rgba(153, 102, 255, 1)', 
						'rgba(255, 159, 64, 1)'], 
					orderWidth: 1 
				}] 
		}, 
		options: 
		{ scales: { yAxes: [{ ticks: { beginAtZero: true } }] } } });
