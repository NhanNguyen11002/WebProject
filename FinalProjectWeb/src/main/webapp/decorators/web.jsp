<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="description" content="Male_Fashion Template" />
<meta name="keywords" content="Male_Fashion, unica, creative, html" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>MY SHOP</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
	rel="stylesheet" />

<!-- FONT AWNSOME  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- linearicons -->
<link rel="stylesheet"
	href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css" />

<!-- LINK BOOTSTRAP  -->
<link rel="stylesheet" href="template/css/bootstrap.min.css"
	type="text/css" />
<!-- Material Design Bootstrap -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
<!-- Material Design Bootstrap Ecommerce -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
<!-- Css Styles -->
<link rel="stylesheet" href="<c:url value="/template/css/main.css"/>"
	type="text/css" />
<style>
.gallery-wrap .img-big-wrap img {
	height: 450px;
	width: auto;
	display: inline-block;
	cursor: zoom-in;
}

.gallery-wrap .img-small-wrap .item-gallery {
	width: 60px;
	height: 60px;
	border: 1px solid #ddd;
	margin: 7px 2px;
	display: inline-block;
	overflow: hidden;
}

.gallery-wrap .img-small-wrap {
	text-align: center;
}

.gallery-wrap .img-small-wrap img {
	max-width: 100%;
	max-height: 100%;
	object-fit: cover;
	border-radius: 4px;
	cursor: zoom-in;
}

.img-big-wrap img {
	width: 100% !important;
	height: auto !important;
}
</style>
</head>
<body class="skin-light" onload="loadTotalMoney()">


	<!-- header  -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- end header  -->

	<!-- 	content -->
	<dec:body />
	<!-- end content -->

	<!-- footer  -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- end footer  -->


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- MDB -->
	<script type="text/javascript" src="template/js/mdb.min.js"></script>
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
	<script src="template/js/main.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>

	<script>
	$(document).ready( function () {
	    $('#myTable').DataTable();
	} );

		// HOME 
		function loadMore() {
			var amount = document.getElementsByClassName("product").length;
			$.ajax({
				url : "/FinalProjectWeb/ajax/load",
				type : "get", //send it through get method
				data : {
					exits : amount
				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML += data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		
		function loadMoreNike() {
			var amountNike = document.getElementsByClassName("productNike").length;
			$
					.ajax({
						url : "/FinalProjectWeb/ajax/loadNike",
						type : "get", //send it through get method
						data : {
							exitsNike : amountNike
						},
						success : function(dataNike) {
							document.getElementById("contentNike").innerHTML += dataNike;

						},
						error : function(xhr) {
							//Do Something to handle error
						}
					});
		}
		
		function loadMoreAdidas() {
			var amountAdidas = document.getElementsByClassName("productAdidas").length;
			$
					.ajax({
						url : "/FinalProjectWeb/ajax/loadAdidas",
						type : "get", //send it through get method
						data : {
							exitsAdidas : amountAdidas
						},
						success : function(dataAdidas) {
							document.getElementById("contentAdidas").innerHTML += dataAdidas;

						},
						error : function(xhr) {
							//Do Something to handle error
						}
					});
		}
		
		function searchByName(param) {
			var txtSearch = param.value;
			$.ajax({
				url : "/FinalProjectWeb/ajax/searchAjax",
				type : "get", //send it through get method
				data : {
					txt : txtSearch
				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		
		
		function invoiceDetail(invoiceId) {
			$.ajax({
				url : "/FinalProjectWeb/ajax/detailInvoice",
				type : "get", //send it through get method
				data : {
					invoiceId : invoiceId
				},
				success : function(data) {
					var row = document.getElementById("contentInvoice");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			}); 
		}
		
		function load(cateid) {
			$
					.ajax({
						url : "/WebsiteBanGiay/category",
						type : "get", //send it through get method
						data : {
							cid : cateid
						},
						success : function(responseData) {
							document.getElementById("content").innerHTML = responseData;
						}
					});
		}
		
		function loadAmountCart() {
			$
					.ajax({
						url : "/WebsiteBanGiay/loadAllAmountCart",
						type : "get", //send it through get method
						data : {

						},
						success : function(responseData) {
							document.getElementById("amountCart").innerHTML = responseData;
						}
					});
		}

		// SHOP 
		$('#multi').mdbRange({
			single : {
				active : true,
				multi : {
					active : true,
					rangeLength : 1
				},
			}
		});

		$(document)
				.ready(
						function() {
							$('.mdb-select').materialSelect();
							$(
									'.select-wrapper.md-form.md-outline input.select-dropdown')
									.bind(
											'focus blur',
											function() {
												$(this).closest(
														'.select-outline')
														.find('label')
														.toggleClass('active');
												$(this).closest(
														'.select-outline')
														.find('.caret')
														.toggleClass('active');
											});
						});
		/* 	function load(cateid) {
				$
						.ajax({
							url : "/WebsiteBanGiay/categoryShop",
							type : "get", //send it through get method
							data : {
								cid : cateid
							},
							success : function(responseData) {
								document.getElementById("content").innerHTML = responseData;
							}
						});
			} */
		function searchByName(param) {
			var txtSearch = param.value;
			$.ajax({
				url : "/FinalProjectWeb/ajax/searchAjaxShop",
				type : "get", //send it through get method
				data : {
					txt : txtSearch
				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
			
		function searchByPriceMinToMax() {
			var numMin = document.getElementById("priceMin").value;
			var numMax = document.getElementById("priceMax").value;
			$.ajax({
				url : "/FinalProjectWeb/ajax/searchAjaxPriceMinToMax",
				type : "get", //send it through get method
				data : {
					priceMin : numMin,
					priceMax : numMax
				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		
		function searchByPriceUnder100() {
			$.ajax({
				url : "/FinalProjectWeb/ajax/searchAjaxPriceUnder100Shop",
				type : "get", //send it through get method
				data : {

				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		function searchByPrice100To200() {
			$.ajax({
				url : "/FinalProjectWeb/ajax/searchAjaxPrice100To200Shop",
				type : "get", //send it through get method
				data : {

				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		function searchByPriceAbove200() {
			$.ajax({
				url : "/FinalProjectWeb/ajax/searchAjaxPriceAbove200Shop",
				type : "get", //send it through get method
				data : {

				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		
		function searchByColorWhite() {
			$.ajax({
				url : "/FinalProjectWeb/ajax/searchAjaxColorWhite",
				type : "get", //send it through get method
				data : {

				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		function searchByColorGray() {
			$.ajax({
				url : "/FinalProjectWeb/ajax/searchAjaxColorGray",
				type : "get", //send it through get method
				data : {

				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		
		function searchByColorBlack() {
			$.ajax({
				url : "/FinalProjectWeb/ajax/searchAjaxColorBlack",
				type : "get", //send it through get method
				data : {

				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		
		function searchByColorYellow() {
			$.ajax({
				url : "/FinalProjectWeb/ajax/searchAjaxColorYellow",
				type : "get", //send it through get method
				data : {

				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		function loadAmountCart() {
			$
					.ajax({
						url : "/FinalProjectWeb/ajax/loadAllAmountCart",
						type : "get", //send it through get method
						data : {

						},
						success : function(responseData) {
							document.getElementById("amountCart").innerHTML = responseData;
						}
					});
		}

		// DETAIL PRODUT
		window
				.addEventListener(
						"load",
						function loadAmountCart() {
							$
									.ajax({
										url : "/FinalProjectWeb/ajax/loadAllAmountCart",
										type : "get", //send it through get method
										data : {

										},
										success : function(responseData) {
											document
													.getElementById("amountCart").innerHTML = responseData;
										}
									});
						}, false);

		function addReview(pID) {
			var cntReview = document.getElementById("form76").value;
			$.ajax({
				url : "/FinalProjectWeb/ajax/addReview",
				type : "get", //send it through get method
				data : {
					productID : pID,
					contentReview : cntReview
				},
				success : function(data) {
					var row = document.getElementById("reviews");
					row.innerHTML += data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		
		//EDIT PROFILE
		    function toggleResetPswd(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle() // display:block or none
                $('#logreg-forms .form-reset').toggle() // display:block or none
            }

            function toggleSignUp(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle(); // display:block or none
                $('#logreg-forms .form-signup').toggle(); // display:block or none
            }

            $(() => {
                // Login Register Form
                $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                $('#logreg-forms #btn-signup').click(toggleSignUp);
                $('#logreg-forms #cancel_signup').click(toggleSignUp);
            })
            
            window.addEventListener("load",function loadAmountCart(){
                        	 $.ajax({
                                 url: "/FinalProjectWeb/ajax/loadAllAmountCart",
                                 type: "get", //send it through get method
                                 data: {
                                     
                                 },
                                 success: function (responseData) {
                                     document.getElementById("amountCart").innerHTML = responseData;
                                 }
                             });
                        },false);    
            
            // BLOG DETAIL
           function addBlogReview(bID){
        var cntReview = document.getElementById("form76").value;
         $.ajax({
             url: "/FinalProjectWeb/ajax/addBlogReview",
             type: "get", //send it through get method
             data: {
             	blogID: bID,
             	contentReview: cntReview
             },
             success: function (data) {
                 var row = document.getElementById("reviews");
                 row.innerHTML += data;
             },
             error: function (xhr) {
                 //Do Something to handle error
             }
         });
     }
            
            // CART 

            function loadTotalMoney() {
							$
									.ajax({
										url : "/FinalProjectWeb/ajax/totalMoneyCart",
										type : "get", //send it through get method
										data : {
										},
										success : function(responseData) {
											document.getElementById("contentTotalMoney").innerHTML = responseData;
										}
									});
						}

		window
				.addEventListener(
						"load",
						function loadAmountCart() {
							$
									.ajax({
										url : "/FinalProjectWeb/ajax/loadAllAmountCart",
										type : "get", //send it through get method
										data : {

										},
										success : function(responseData) {
											document
													.getElementById("amountCart").innerHTML = responseData;
										}
									});
						}, false);
		
		// ĐẶT HÀNG 
		 function toggleResetPswd(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle() // display:block or none
                $('#logreg-forms .form-reset').toggle() // display:block or none
            }

            function toggleSignUp(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle(); // display:block or none
                $('#logreg-forms .form-signup').toggle(); // display:block or none
            }

            $(() => {
                // Login Register Form
                $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                $('#logreg-forms #btn-signup').click(toggleSignUp);
                $('#logreg-forms #cancel_signup').click(toggleSignUp);
            })
            
            window.addEventListener("load",function loadAmountCart(){
                        	 $.ajax({
                                 url: "/FinalProjectWeb/ajax/loadAllAmountCart",
                                 type: "get", //send it through get method
                                 data: {
                                     
                                 },
                                 success: function (responseData) {
                                     document.getElementById("amountCart").innerHTML = responseData;
                                 }
                             });
                        },false);                 
        </script>

</body>
</html>
