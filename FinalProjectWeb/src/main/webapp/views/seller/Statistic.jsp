<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<main>
	<div class="container pt-4">
		<section>
			<div class="row" id="total">
				<div class="col-xl-6 col-md-12 mb-4">
					<div class="card">
						<div class="card-body">
							<div class="d-flex justify-content-between p-md-1">
								<div class="d-flex flex-row">
									<div class="align-self-center">
										<i class="fas fa-pencil-alt text-info fa-3x me-4"></i>
									</div>
									<div>
										<h4>Tổng sản phẩm</h4>
										<p class="mb-0"></p>
									</div>
								</div>
								<div class="align-self-center">
									<h2 class="h1 mb-0">${allProduct }</h2>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-md-12 mb-4">
					<div class="card">
						<div class="card-body">
							<div class="d-flex justify-content-between p-md-1">
								<div class="d-flex flex-row">
									<div class="align-self-center">
										<i class="far fa-heart text-danger fa-3x"></i>
									</div>
									<div>
										<h4>Tổng doanh thu</h4>
										<p class="mb-0"></p>
									</div>
								</div>
								<div class="align-self-center">
									<h2 class="h1 mb-0 me-4">
										<fmt:formatNumber type="number" groupingUsed="true"
											value="${sumAllInvoice }"></fmt:formatNumber>
									</h2>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xl-6 col-md-12 mb-4">
					<div class="card">
						<div class="card-body">
							<div class="d-flex justify-content-between p-md-1">
								<div class="d-flex flex-row">
									<div class="align-self-center">
										<i class="far fa-comment-alt text-warning fa-3x me-4"></i>
									</div>
									<div>
										<h4>Yêu cầu từ ADMIN</h4>
										<p class="mb-0"></p>
									</div>
								</div>
								<div class="align-self-center">
									<h2 class="h1 mb-0 me-4">
										<fmt:formatNumber type="number" groupingUsed="true"
											value="${countRequest }"></fmt:formatNumber>
									</h2>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--Section: Statistics with subtitles-->
	</div>
</main>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!--Main layout-->
<!-- SCRIPTS -->
<!-- JQuery -->
<script
	src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript"
	src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript"
	src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript"
	src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
<!-- MDB Ecommerce JavaScript -->
<script type="text/javascript"
	src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
<!-- MDB -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript" src="js/script.js"></script>
<script
	src="https://mdbootstrap.com/api/snippets/static/download/MDB5-Free_3.8.1/js/mdb.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
<script>// Graph
  //pie
    var ctxP = document.getElementById("pieChart").getContext('2d');

    var myPieChart = new Chart(ctxP, {
    type: 'pie',
    data: {
    labels: ["Sunday", "Saturday", "Friday", "Thursday", "Wednesday", "Tuesday", "Monday"],
    datasets: [{
    data: [${totalMoney1}, ${totalMoney7}, ${totalMoney6}, ${totalMoney5}, ${totalMoney4}, ${totalMoney3}, ${totalMoney2}],
    backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360", "#1874CD", "#CDB5CD"],
    hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774", "#1E90FF", "#FFE1FF"]
    }]
    },
    options: {
    responsive: true
    }
    });
    function loadAmountCart(){
   	 $.ajax({
            url: "/WebsiteBanGiay/loadAllAmountCart",
            type: "get", //send it through get method
            data: {
                
            },
            success: function (responseData) {
                document.getElementById("amountCart").innerHTML = responseData;
            }
        });
   }         
</script>
<script>// Graph
  //Horizontal Bar Chart
   new Chart(document.getElementById("horizontalBar"), {
"type": "horizontalBar",
"data": {
"labels": ["Tháng 12", "Tháng 11", "Tháng 10", "Tháng 9", "Tháng 8", "Tháng 7", "Tháng 6", "Tháng 5", "Tháng 4", "Tháng 3", "Tháng 2", "Tháng 1"],
"datasets": [{
"label": "Doanh thu",
"data": [${totalMoneyMonth12}, ${totalMoneyMonth11}, ${totalMoneyMonth10}, ${totalMoneyMonth9}, ${totalMoneyMonth8}, ${totalMoneyMonth7}, ${totalMoneyMonth6}, ${totalMoneyMonth5}, ${totalMoneyMonth4}, ${totalMoneyMonth3}, ${totalMoneyMonth2}, ${totalMoneyMonth1}],
"fill": false,
"backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)",
"rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(54, 162, 235, 0.2)",
"rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)", "#99FF99", "#FFFF99", "#FFC1C1", "#FFB5C5", "#DDC488"
],
"borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
"rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)", "rgb(201, 203, 207)", "	#66FF99", "#FFFF66", "#EEB4B4", "#EEA9B8", "#ECAB53"
],
"borderWidth": 1
}]
},
"options": {
"scales": {
"xAxes": [{
"ticks": {
"beginAtZero": true
}
}]
}
}
});
</script>
<script type="text/javascript"
	src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>
<!-- MDB -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript" src="js/script.js"></script>
</body>
</html>