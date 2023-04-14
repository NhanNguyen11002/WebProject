<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!--Main layout-->
<section class="breadcrumb-option">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="breadcrumb__text">
					<h4>Sản phẩm</h4>
					<div class="breadcrumb__links">
						<a href="./index.html">Trang chủ</a> <span>Sản phẩm</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shop Section Begin -->
<section class="shop">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="shop__sidebar">
					<div class="shop__sidebar__search">
						<form action="#">
							<input oninput="searchByName(this)" value="${txtS}" name="txt"
								type="text" placeholder="Tìm kiếm ngay..." />
						</form>
					</div>
					<div class="shop__sidebar__accordion">
						<div class="accordion" id="accordionExample">
							<div class="cardShop">
								<div class="card-heading">
									<a data-toggle="collapse" data-target="#collapseOne">Loại
										giày <i class="fa-solid fa-chevron-down"></i>
									</a>
								</div>
								<div id="collapseOne" class="collapse show"
									data-parent="#accordionExample">
									<div class="card-body">
										<div class="shop__sidebar__categories">
											<ul class="nice-scroll">
												<c:forEach items="${listCC}" var="o">
													<li><a href="shop?cid=${o.cid}"
														class="card-link-secondary ${tagactive == o.cid ? "active" : ""}"" >${o.cname}</a></li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="cardShop" style="font-size: 20px">
								<div class="card-heading">
									<a data-toggle="collapse" data-target="#collapseThree">Giá
										tiền <i class="fa-solid fa-chevron-down"></i>
									</a>
								</div>
								<div id="collapseThree" class="collapse show"
									data-parent="#accordionExample">
									<div class="card-body">
										<div class="shop__sidebar__price">
											<div class="form-check pl-0 mb-3">
												<input onchange="searchByPriceUnder100()" type="radio"
													class="form-check-input" id="under100"
													name="materialExampleRadios"> <label
													class="form-check-label small text-uppercase card-link-secondary"
													for="under100">Dưới 100.000</label>
											</div>
											<div class="form-check pl-0 mb-3">
												<input onchange="searchByPrice100To200()" type="radio"
													class="form-check-input" id="100200"
													name="materialExampleRadios"> <label
													class="form-check-label small text-uppercase card-link-secondary"
													for="100200">100.000 đến 200.000</label>
											</div>
											<div class="form-check pl-0 mb-3">
												<input onchange="searchByPriceAbove200()" type="radio"
													class="form-check-input" id="200above"
													name="materialExampleRadios"> <label
													class="form-check-label small text-uppercase card-link-secondary"
													for="200above">200.000 trở lên</label>
											</div>
											<form>
												<div class="d-flex align-items-center mt-4 pb-1">
													<div class="md-form md-outline my-0">
														<input oninput="searchByPriceMinToMax()" id="priceMin"
															type="text" class="form-control mb-0"> <label
															for="priceMin">Min</label>
													</div>
													<p class="px-2 mb-0 text-muted">-</p>
													<div class="md-form md-outline my-0">
														<input oninput="searchByPriceMinToMax()" id="priceMax"
															type="text" class="form-control mb-0"> <label
															for="priceMax">Max</label>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<div class="cardShop">
								<div class="card-heading">
									<a data-toggle="collapse" data-target="#collapseFive">Màu
										sắc <i class="fa-solid fa-chevron-down"></i>
									</a>
								</div>
								<div id="collapseFive" class="collapse show"
									data-parent="#accordionExample">
									<div class="card-body">
										<div class="shop__sidebar__color">
											<label
												class="btn rounded-circle bg-white border-inset-grey p-3 m-2">
												<input onchange="searchByColorWhite()" type="checkbox"
												autocomplete="off">
											</label> <label class="btn rounded-circle bg-secondary p-3 m-2">
												<input onchange="searchByColorGray()" type="checkbox"
												autocomplete="off">
											</label> <label class="btn rounded-circle bg-dark p-3 m-2"> <input
												onchange="searchByColorBlack()" type="checkbox"
												autocomplete="off">
											</label> <label class="btn rounded-circle bg-warning p-3 m-2">
												<input onchange="searchByColorYellow()" type="checkbox"
												autocomplete="off">
											</label> <label class="btn rounded-circle bg-success p-3 m-2">
												<input type="checkbox" autocomplete="off">
											</label> <label class="btn rounded-circle bg-primary p-3 m-2">
												<input type="checkbox" autocomplete="off">
											</label><label class="btn rounded-circle bg-danger p-3 m-2">
												<input type="checkbox" autocomplete="off">

											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="row" id="content">
					<c:forEach items="${listAll}" var="o">

						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="single-product">
								<c:choose>
									<c:when test="${o.image.substring(0,4) == 'http' }">
										<a href="detail?pid=${o.id}" title="View Product"> <img
											class="img-fluid" src="${o.image }" alt="" />
										</a>
									</c:when>
									<c:otherwise>
										<c:url value="/image?fname=${o.image }" var="imgUrl"></c:url>
										<a href="detail?pid=${o.id}" title="View Product"> <img
											class="img-fluid" src="${imgUrl }" alt="" />
										</a>
									</c:otherwise>
								</c:choose>
								<div class="product-details">
									<h6>${o.name }</h6>
									<div class="price">
										<h6>
											<fmt:formatNumber type="number" groupingUsed="true"
												value="${o.price}"></fmt:formatNumber>
											VNĐ
										</h6>
										<h6 class="l-through">
											<fmt:formatNumber type="number" groupingUsed="true"
												value="${o.price * 1.1}"></fmt:formatNumber>
											VNĐ
										</h6>
									</div>
									<div class="prd-bottom">
										<a href="addCart?pid=${o.id }&quantity=1&size=small"
											class="social-info"> <span class="lnr lnr-cart"></span>
											<p class="hover-text">add to bag</p>
										</a> <a href="addWishList?pid=${o.id }" class="social-info"> <span
											class="lnr lnr-heart"></span>
											<p class="hover-text">Wishlist</p>
										</a> <a href="detail?pid=${o.id}" title="View Product"
											class="social-info"> <span class="lnr lnr-move"></span>
											<p class="hover-text">view more</p>
										</a>
									</div>
								</div>
							</div>
						</div>

					</c:forEach>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="product__pagination">
							<c:forEach begin="1" end="${endPage }" var="i">
								<a class="${tag==i?"
									active":"" }"
										href="shop?cid=${tagactive}&index=${i}"
									class="page-link">${i }</a>
							</c:forEach>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</section>