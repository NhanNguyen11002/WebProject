<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<section class="home" id="home">
	<div class="slide-container active">
		<div class="slide">
			<div class="content">
				<span>nike red shoes</span>
				<h3>nike metcon shoes</h3>
				<p>JUST DO IT</p>
				<a href="shop?cid=0" class="primary-btn">Mua ngay</a>
			</div>
			<div class="image">
				<img src="template/images/home-shoe-1.png" class="shoe" alt="" /> <img
					src="template/images/home-text-1.png" class="text" alt="" />
			</div>
		</div>
	</div>
	<div class="slide-container">
		<div class="slide">
			<div class="content">
				<span>nike blue shoes</span>
				<h3>nike metcon shoes</h3>
				<p>JUST DO IT</p>
				<a href="shop?cid=0" class="primary-btn">Mua ngay</a>
			</div>
			<div class="image">
				<img src="template/images/home-shoe-2.png" class="shoe" alt="" /> <img
					src="template/images/home-text-2.png" class="text" alt="" />
			</div>
		</div>
	</div>
	<div class="slide-container">
		<div class="slide">
			<div class="content">
				<span>nike yellow shoes</span>
				<h3>nike metcon shoes</h3>
				<p>JUST DO IT</p>
				<a href="shop?cid=0" class="primary-btn">Mua ngay</a>
			</div>
			<div class="image">
				<img src="template/images/home-shoe-3.png" class="shoe" alt="" /> <img
					src="template/images/home-text-3.png" class="text" alt="" />
			</div>
		</div>
	</div>
	<div id="prev" class="fas fa-chevron-left" onclick="prev()"></div>
	<div id="next" class="fas fa-chevron-right" onclick="next()"></div>
</section>

<section class="features section_gap">
	<div class="container">
		<div class="row features-inner">
			<!-- single features -->
			<div class="col-lg-3 col-md-6 col-sm-6">
				<div class="single-features">
					<div class="f-icon">
						<img src="template/images/features/f-icon1.png" alt="" />
					</div>
					<h6>Giao hàng miễn phí</h6>
				</div>
			</div>
			<!-- single features -->
			<div class="col-lg-3 col-md-6 col-sm-6">
				<div class="single-features">
					<div class="f-icon">
						<img src="template/images/features/f-icon2.png" alt="" />
					</div>
					<h6>Chính sách hoàn tiền</h6>
				</div>
			</div>
			<!-- single features -->
			<div class="col-lg-3 col-md-6 col-sm-6">
				<div class="single-features">
					<div class="f-icon">
						<img src="template/images/features/f-icon3.png" alt="" />
					</div>
					<h6>Hỗ trợ 24/7</h6>
				</div>
			</div>
			<!-- single features -->
			<div class="col-lg-3 col-md-6 col-sm-6">
				<div class="single-features">
					<div class="f-icon">
						<img src="template/images/features/f-icon4.png" alt="" />
					</div>
					<h6>Thanh toán an toàn</h6>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="category-area">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-12">
				<div class="row">
					<div class="col-lg-8 col-md-8">
						<div class="single-deal">
							<div class="overlay"></div>
							<img class="img-fluid w-100"
								src="template/images/category/c1.jpg" alt="" /> <a
								href="template/images/category/c1.jpg" class="img-pop-up"
								target="_blank">
								<div class="deal-details">
									<h6 class="deal-title">Giày cho cặp đôi</h6>
								</div>
							</a>
						</div>
					</div>
					<div class="col-lg-4 col-md-4">
						<div class="single-deal">
							<div class="overlay"></div>
							<img class="img-fluid w-100"
								src="template/images/category/c2.jpg" alt="" /> <a
								href="template/images/category/c2.jpg" class="img-pop-up"
								target="_blank">
								<div class="deal-details">
									<h6 class="deal-title">Giày chính hãng</h6>
								</div>
							</a>
						</div>
					</div>
					<div class="col-lg-4 col-md-4">
						<div class="single-deal">
							<div class="overlay"></div>
							<img class="img-fluid w-100"
								src="template/images/category/c3.jpg" alt="" /> <a
								href="template/images/category/c3.jpg" class="img-pop-up"
								target="_blank">
								<div class="deal-details">
									<h6 class="deal-title">Giày thời trang</h6>
								</div>
							</a>
						</div>
					</div>
					<div class="col-lg-8 col-md-8">
						<div class="single-deal">
							<div class="overlay"></div>
							<img class="img-fluid w-100"
								src="template/images/category/c4.jpg" alt="" /> <a
								href="template/images/category/c4.jpg" class="img-pop-up"
								target="_blank">
								<div class="deal-details">
									<h6 class="deal-title">Giày thể thao</h6>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="single-deal">
					<div class="overlay"></div>
					<img class="img-fluid w-100" src="template/images/category/c5.jpg"
						alt="" /> <a href="template/images/category/c5.jpg"
						class="img-pop-up" target="_blank">
						<div class="deal-details">
							<h6 class="deal-title">Giảm giá sốc</h6>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="product">
	<div class="container">
		<!-- Tab items -->
		<div class="tabs d-flex justify-content-center">
			<div class="tab-item active">Sản phẩm bán chạy</div>
			<div class="tab-item">Giày Nike</div>
			<div class="tab-item">Giày Adidas</div>
			<div class="tab-item">Giày Bitis</div>
			<div class="tab-item">Giày Converse</div>
			<div class="line"></div>
		</div>
		<!-- Tab content -->
		<div class="tab-content">
			<div class="tab-pane active">
				<div class="row" id="content">
					<c:forEach items="${list4Last}" var="o">
						<!-- single product -->
						<div class="product col-lg-3 col-md-6">
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
				<button onclick="loadMore()" class="site-btn">Xem thêm</button>
			</div>
			<div class="tab-pane">
				<div class="row" id="contentNike">
					<c:forEach items="${list4NikeLast}" var="o">
						<!-- single product -->
						<div class="product col-lg-3 col-md-6">
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
				<button onclick="loadMoreNike()" class="site-btn">Xem thêm</button>
			</div>
			<div class="tab-pane">
				<div class="row" id="contentAdidas">
					<c:forEach items="${list4AdidasLast}" var="o">
						<!-- single product -->
						<div class="product col-lg-3 col-md-6">
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
										</a><a href="detail?pid=${o.id}" title="View Product"
											class="social-info"> <span class="lnr lnr-move"></span>
											<p class="hover-text">view more</p>
										</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<button onclick="loadMoreAdidas()" class="site-btn">Xem
					thêm</button>
			</div>
			<div class="tab-pane">
				<div class="row">
					<c:forEach items="${list4BitisLast}" var="o">
						<!-- single product -->
						<div class="product col-lg-3 col-md-6">
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
				<button onclick="loadMoreAdidas()" class="site-btn">Xem
					thêm</button>
			</div>
			<div class="tab-pane">
				<div class="row">
					<c:forEach items="${list4ConverseLast}" var="o">
						<!-- single product -->
						<div class="product col-lg-3 col-md-6">
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
										</a><a href="detail?pid=${o.id}" title="View Product"
											class="social-info"> <span class="lnr lnr-move"></span>
											<p class="hover-text">view more</p>
										</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<button onclick="loadMoreAdidas()" class="site-btn">Xem
					thêm</button>
			</div>

		</div>
	</div>
</section>

<section class="discount">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 p-0">
				<div class="discount__pic">
					<img src="template/images/discountShoe.jpg" alt="" />
				</div>
			</div>
			<div class="col-lg-6 p-0">
				<div class="discount__text">
					<div class="discount__text__title">
						<span>Giảm giá</span>
						<h2>Mùa hè 2022</h2>
						<h5>
							<span>Sale</span> 50%
						</h5>
					</div>
					<div class="discount__countdown" id="countdown-time">
						<div class="countdown__item">
							<span id="days"></span>
						</div>
						<div class="countdown__item">
							<span id="hours"></span>
						</div>
						<div class="countdown__item">
							<span id="mitunes"></span>
						</div>
						<div class="countdown__item">
							<span id="seconds"></span>
						</div>
					</div>
					<a href="shop?cid=0">Mua ngay</a>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="latest">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title">
					<span>Tin tức mới nhất</span>
					<h2>Xu hướng thời trang mới</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${listB}" var="o">
				<div class="col-lg-4 col-md-6 col-sm-6">
					<div class="blog__item">
						<div class="blog__item__pic"
							style="background-image: url('${o.image}')"></div>
						<div class="blog__item__text">
							<span><img src="img/icon/calendar.png" alt="" />
								${o.date}</span>
							<h5>${o.title}</h5>
							<a href="detailBlog?bid=${o.blog_id}" title="View Blog">Đọc
								ngay</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
