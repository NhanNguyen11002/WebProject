<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!--Main layout-->
<main>
	<div class="container">
		<!--Section: Block Content-->
		<div class="mb-5 mt-5">
			<div class="row">
				<div class="col-md-6 mb-4 mb-md-0">

					<div id="mdb-lightbox-ui"></div>

					<div class="mdb-lightbox">

						<div class="row product-gallery mx-1">

							<div class="col-12 mb-0">
								<figure class="view overlay rounded z-depth-1 main-img"
									style="max-height: 450px;">
									<c:choose>
										<c:when test="${detail.image.substring(0,4) == 'http' }">
											<a
												href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15a.jpg"
												data-size="710x823"> <img src="${detail.image}"
												class="img-fluid z-depth-1" style="margin-top: -90px;">
											</a>
										</c:when>
										<c:otherwise>
											<c:url value="/image?fname=${detail.image }" var="imgUrl"></c:url>
											<a
												href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15a.jpg"
												data-size="710x823"> <img src="${imgUrl}"
												class="img-fluid z-depth-1" style="margin-top: -90px;">
											</a>
										</c:otherwise>
									</c:choose>
								</figure>
								<figure class="view overlay rounded z-depth-1"
									style="visibility: hidden;">
									<c:choose>
										<c:when test="${detail.image2.substring(0,4) == 'http' }">
											<a
												href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
												data-size="710x823"> <img src="${detail.image2}"
												class="img-fluid z-depth-1">
											</a>
										</c:when>
										<c:otherwise>
											<c:url value="/image?fname=${detail.image2 }" var="imgUrl"></c:url>
											<a
												href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
												data-size="710x823"> <img src="${imgUrl}"
												class="img-fluid z-depth-1">
											</a>
										</c:otherwise>
									</c:choose>
								</figure>
								<figure class="view overlay rounded z-depth-1"
									style="visibility: hidden;">
									<c:choose>
										<c:when test="${detail.image3.substring(0,4) == 'http' }">
											<a
												href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13a.jpg"
												data-size="710x823"> <img src="${detail.image3}"
												class="img-fluid z-depth-1">
											</a>
										</c:when>
										<c:otherwise>
											<c:url value="/image?fname=${detail.image3 }" var="imgUrl"></c:url>
											<a
												href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
												data-size="710x823"> <img src="${imgUrl}"
												class="img-fluid z-depth-1">
											</a>
										</c:otherwise>
									</c:choose>
								</figure>
								<figure class="view overlay rounded z-depth-1"
									style="visibility: hidden;">
									<c:choose>
										<c:when test="${detail.image4.substring(0,4) == 'http' }">
											<a
												href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/14a.jpg"
												data-size="710x823"> <img src="${detail.image4}"
												class="img-fluid z-depth-1">
											</a>
										</c:when>
										<c:otherwise>
											<c:url value="/image?fname=${detail.image4 }" var="imgUrl"></c:url>
											<a
												href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
												data-size="710x823"> <img src="${imgUrl}"
												class="img-fluid z-depth-1">
											</a>
										</c:otherwise>
									</c:choose>
								</figure>
							</div>
							<div class="col-12">
								<div class="row">
									<div class="col-3">
										<div
											class="view overlay rounded z-depth-1 gallery-item hoverable">
											<c:choose>
												<c:when test="${detail.image.substring(0,4) == 'http' }">
													<img src="${detail.image}" class="img-fluid">
												</c:when>
												<c:otherwise>
													<c:url value="/image?fname=${detail.image }" var="imgUrl"></c:url>
													<a
														href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
														data-size="710x823"> <img src="${imgUrl}"
														class="img-fluid z-depth-1">
													</a>
												</c:otherwise>
											</c:choose>
											<div class="mask rgba-white-slight"></div>
										</div>
									</div>
									<div class="col-3">
										<div
											class="view overlay rounded z-depth-1 gallery-item hoverable">
											<c:choose>
												<c:when test="${detail.image2.substring(0,4) == 'http' }">
													<img src="${detail.image2}" class="img-fluid">
												</c:when>
												<c:otherwise>
													<c:url value="/image?fname=${detail.image2 }" var="imgUrl"></c:url>
													<a
														href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
														data-size="710x823"> <img src="${imgUrl}"
														class="img-fluid z-depth-1">
													</a>
												</c:otherwise>
											</c:choose>

											<div class="mask rgba-white-slight"></div>
										</div>
									</div>
									<div class="col-3">
										<div
											class="view overlay rounded z-depth-1 gallery-item hoverable">
											<c:choose>
												<c:when test="${detail.image3.substring(0,4) == 'http' }">
													<img src="${detail.image3}" class="img-fluid">
												</c:when>
												<c:otherwise>
													<c:url value="/image?fname=${detail.image3 }" var="imgUrl"></c:url>
													<a
														href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
														data-size="710x823"> <img src="${imgUrl}"
														class="img-fluid z-depth-1">
													</a>
												</c:otherwise>
											</c:choose>
											<div class="mask rgba-white-slight"></div>
										</div>
									</div>
									<div class="col-3">
										<div
											class="view overlay rounded z-depth-1 gallery-item hoverable">
											<c:choose>
												<c:when test="${detail.image4.substring(0,4) == 'http' }">
													<img src="${detail.image4}" class="img-fluid">
												</c:when>
												<c:otherwise>
													<c:url value="/image?fname=${detail.image4 }" var="imgUrl"></c:url>
													<a
														href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
														data-size="710x823"> <img src="${imgUrl}"
														class="img-fluid z-depth-1">
													</a>
												</c:otherwise>
											</c:choose>
											<div class="mask rgba-white-slight"></div>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>

				</div>
				<div class="col-md-6" style="font-size: 15px">
					<h5 style="font-size: 15px; font-weight: 700">${detail.name}</h5>
					<p>
						<span class="mr-1"><strong><fmt:formatNumber
									type="number" groupingUsed="true" value="${detail.price}"></fmt:formatNumber>
								VNĐ</strong></span> <span class="text-grey"
							style="text-decoration: line-through;"><strong><fmt:formatNumber
									type="number" groupingUsed="true" value="${detail.price * 1.1}"></fmt:formatNumber>
								VNĐ</strong></span>
					</p>


					<p class="pt-1" style="text-transform: none;">${detail.description}</p>
					<div class="table-responsive">
						<table class="table table-sm table-borderless mb-0">
							<tbody>
								<tr>
									<th class="pl-0 w-25" scope="row" style="font-size: 18px"><strong>Cửa
											hàng</strong></th>
									<td style="font-size: 18px">${nameShop}</td>
								</tr>
								<tr>
									<th class="pl-0 w-25" scope="row" style="font-size: 18px"><strong>Mã
											sản phẩm</strong></th>
									<td style="font-size: 18px">${detail.model }</td>
								</tr>
								<tr>
									<th class="pl-0 w-25" scope="row" style="font-size: 18px"><strong>Màu
											sắc</strong></th>
									<td style="font-size: 18px">${detail.color }</td>
								</tr>
								<tr>
									<th class="pl-0 w-25" scope="row" style="font-size: 18px"><strong>Xuất
											sứ</strong></th>
									<td style="font-size: 18px">${detail.delivery }</td>
								</tr>
							</tbody>
						</table>
					</div>
					<hr>

					<form action="addCart?pid=${detail.id }" method="post">
						<div class="table-responsive mb-2">
							<table class="table table-sm table-borderless">
								<tbody>
									<tr>
										<td class="pl-0 pb-0 w-25" style="font-size: 20px">Số
											lượng</td>
										<td class="pb-0" style="font-size: 20px">Kích cỡ</td>
									</tr>
									<tr>
										<td class="pl-0">
											<div class="mt-1">
												<div class="def-number-input number-input safari_only mb-0"
													style="display: flex; align-items: center;">
													<button type="button"
														onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
														class="minus"></button>
													<input class="quantity" min="0" name="quantity" value="1"
														type="number">
													<button type="button"
														onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
														class="plus"></button>
												</div>
											</div>
										</td>
										<td>
											<div class="mt-1">
												<div class="form-check form-check-inline pl-0">
													<input type="radio" class="form-check-input" id="small"
														value="small" name="size" checked> <label
														class="form-check-label small text-uppercase card-link-secondary"
														for="small" style="font-size: 10px">Small</label>
												</div>
												<div class="form-check form-check-inline pl-0">
													<input type="radio" class="form-check-input" id="medium"
														value="medium" name="size"> <label
														class="form-check-label small text-uppercase card-link-secondary"
														for="medium" style="font-size: 10px">Medium</label>
												</div>
												<div class="form-check form-check-inline pl-0">
													<input type="radio" class="form-check-input" id="large"
														value="large" name="size"> <label
														class="form-check-label small text-uppercase card-link-secondary"
														for="large" style="font-size: 10px">Large</label>
												</div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="mt-1">
							<button type="submit" class="site-btn-add">Mua ngay</button>
							<button type="submit" class="site-btn">
								<i class="fas fa-shopping-cart pr-2"></i>Thêm vào giỏ hàng
							</button>
						</div>
					</form>

				</div>
			</div>

		</div>
		<!--Section: Block Content-->

		<!-- Classic tabs -->
		<div class="classic-tabs">

			<ul class="nav tabs-primary nav-justified" id="advancedTab"
				role="tablist">
				<li class="nav-item"><a class="nav-link active show"
					id="description-tab" data-toggle="tab" href="#description"
					role="tab" aria-controls="description" aria-selected="true">Mô
						tả</a></li>
				<li class="nav-item"><a class="nav-link" id="info-tab"
					data-toggle="tab" href="#info" role="tab" aria-controls="info"
					aria-selected="false">Thông tin</a></li>
				<li class="nav-item"><a class="nav-link" id="reviews-tab"
					data-toggle="tab" href="#reviews" role="tab"
					aria-controls="reviews" aria-selected="false">Đánh giá
						(${countAllReview })</a></li>
			</ul>
			<div class="tab-content" id="advancedTabContent">
				<div class="tab-pane fade show active" id="description"
					role="tabpanel" aria-labelledby="description-tab">
					<h5 style="font-size: 15px">Mô tả sản phẩm</h5>

					<h6 style="font-size: 15px">
						<fmt:formatNumber type="number" groupingUsed="true"
							value="${detail.price}"></fmt:formatNumber>
						VNĐ
					</h6>
					<p class="pt-1" style="font-size: 15px; text-transform: none;">${detail.description}</p>
				</div>
				<div class="tab-pane fade" id="info" role="tabpanel"
					aria-labelledby="info-tab">
					<h5 style="font-size: 15px">Thông tin thêm</h5>
					<table class="table table-striped table-bordered mt-3">
						<thead>
							<tr>
								<th scope="row" class="w-150 dark-grey-text h6"
									style="font-size: 15px">Nặng</th>
								<td style="font-size: 15px; font-weight: bold;"><em>0.3
										kg</em></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row" class="w-150 dark-grey-text h6"
									style="font-size: 15px">Kích thước</th>
								<td style="font-size: 15px; font-weight: bold;"><em>50
										× 60 cm</em></td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="tab-pane fade" id="reviews" role="tabpanel"
					aria-labelledby="reviews-tab" style="font-size: 15px;">
					<h5 style="font-size: 15px">
						<span>${countAllReview }</span> review for <span>${detail.name }</span>
					</h5>
					<h5 class="mt-4" style="font-size: 15px">Nhận xét về sản
						phẩm</h5>
					<p></p>

					<div>
						<!-- Your review -->
						<c:if test="${listInvoiceShopDetails != null}">
							<c:forEach items="${listInvoiceShopDetails}" var="o">
								<c:if test="${o.proId == detail.id}">
									<div class="md-form md-outline">
										<textarea id="form76" class="md-textarea form-control pr-6"
											rows="4" style="font-size: 15px; text-transform: none;"></textarea>
										<label for="form76" style="font-size: 15px">Nhận xét
											của bạn</label>
									</div>
									<div class="text-right pb-2">
										<button type="button" class="site-btn-add"
											onclick="addReview(${detail.id})">Thêm</button>
									</div>
								</c:if>
							</c:forEach>
						</c:if>
					</div>
					<c:forEach items="${listAllReview}" var="r">
						<div class="media mt-3 mb-4">
							<c:forEach items="${listAllAcount}" var="a">
								<c:if test="${r.accountID == a.id }">
									<c:if test="${a.image == null }">
										<img class="d-flex mr-3 z-depth-1"
											src="https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg"
											width="62" height="62" style="border-radius: 50%"
											alt="Generic placeholder image">
									</c:if>
									<c:if test="${a.image != null }">
										<c:url value="/image?fname=${a.image }" var="imgUrl"></c:url>
										<c:choose>
											<c:when test="${a.image.substring(0,4) == 'http' }">
												<img class="d-flex mr-3 z-depth-1" src="${a.image}"
													width="62" height="62" style="border-radius: 50%"
													alt="Generic placeholder image">
											</c:when>
											<c:otherwise>
												<img class="d-flex mr-3 z-depth-1" src="${imgUrl}"
													width="62" height="62" style="border-radius: 50%"
													alt="Generic placeholder image">
											</c:otherwise>
										</c:choose>
									</c:if>
								</c:if>
							</c:forEach>
							<div class="media-body">
								<div class="d-flex justify-content-between">
									<p class="mt-1 mb-2">
										<c:forEach items="${listAllAcount}" var="a">
											<c:if test="${r.accountID == a.id }">
												<strong>${a.user } </strong>
											</c:if>
										</c:forEach>
										<span>– </span><span>${r.dateReview }</span>
									</p>
									<c:if test="${r.accountID == sessionScope.acc.id }">
										<a class="site-btn-delete" style="color: white"
											href="deleteReview?mid=${r.maReview}"> <i
											class="fa-solid fa-trash"></i>
										</a>
									</c:if>
								</div>
								<p class="mb-0" style="text-transform: none;">${r.contentReview }</p>
							</div>
						</div>
						<hr>
					</c:forEach>
				</div>

			</div>
		</div>
		<!-- Classic tabs -->

		<hr>

		<!--Section: Block Content-->
		<div class="related">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<h3 class="related-title">Sản phẩm liên quan</h3>
					</div>
				</div>
				<div class="row">
					<c:forEach items="${listRelatedProduct}" var="o">
						<div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
							<div class="single-product">
								<c:choose>
									<c:when test="${o.image.substring(0,4) == 'http' }">
										<a href="detail?pid=${o.id}" title="View Product"><img
											class="img-fluid" src="${o.image}" alt="" /></a>
									</c:when>
									<c:otherwise>
										<c:url value="/image?fname=${o.image }" var="imgUrl"></c:url>
										<a href="detail?pid=${o.id}" title="View Product"><img
											class="img-fluid" src="${imgUrl}" alt="" /></a>
									</c:otherwise>
								</c:choose>

								<div class="product-details">
									<h6>${o.name}</h6>
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
			</div>
		</div>
		<!--Section: Block Content-->

	</div>
</main>