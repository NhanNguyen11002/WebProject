<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--begin of menu-->
<header class="header">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3">
				<div class="header__logo">
					<a href="home"> <img src="template/images/logo.png" alt="" />
					</a>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<nav class="header__menu mobile-menu">
					<ul>
						<li class="itemHeader active"><a
							href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
						<li class="itemHeader"><a
							href="${pageContext.request.contextPath}/shop?cid=0">Sản
								phẩm</a></li>
						<li><a href="#">Pages</a>
							<ul class="dropdown">
								<li><a
									href="${pageContext.request.contextPath}/managerCart">Giỏ
										hàng</a></li>
								<li><a href="${pageContext.request.contextPath}/order">Thanh
										toán</a></li>
							</ul></li>
						<li class="itemHeader"><a
							href="${pageContext.request.contextPath}/blog">Bài viết</a></li>
						<c:if test="${sessionScope.acc.isSell == 1}">
							<li class="itemHeader"><a
								href="${pageContext.request.contextPath}/seller">Kênh bán
									hàng</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3 col-md-3" style="padding: 0;">
				<div class="header__nav__option">
					<c:if test="${sessionScope.acc != null}">
						<a class="nav-link"
							href="${pageContext.request.contextPath}/editProfile"
							style="font-size: 15px; color: black;">Chào <strong>${sessionScope.acc.user}</strong></a>
					</c:if>
					<c:if test="${sessionScope.acc == null}">
						<a href="${pageContext.request.contextPath}/login"><i
							class="fa-solid fa-user"></i></a>
					</c:if>
					<a href="wishlist"><i class="fa-solid fa-heart"></i></a> <a
						href="#cart" class="js-show-cart"><i
						class="fa-solid fa-cart-shopping"></i> </a>
				</div>
			</div>
		</div>

		<div class="canvas__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>

<div class="wrap-header-cart js-panel-cart" id="cart">
	<div class="header-cart flex-col-l p-l-65 p-r-25">
		<div class="header-cart-title flex-w flex-sb-m p-b-8">
			<span class="mtext-103 cl2"> giỏ hàng </span>

			<div class="iconCart">
				<i class="fa-solid fa-xmark"></i>
			</div>
		</div>

		<div class="header-cart-content flex-w js-pscroll">
			<ul class="header-cart-wrapitem w-full">
				<c:forEach items="${listCart}" var="o">
					<c:forEach items="${listProduct}" var="p">
						<c:if test="${o.productID == p.id}">
							<li class="header-cart-item flex-w flex-t m-b-12">
								<div class="header-cart-item-img">
									<img src="${p.image}" alt="IMG" />
								</div>
								<div class="header-cart-item-txt p-t-8">
									<a href="detail?pid=${p.id}"
										class="header-cart-item-name m-b-18 hov-cl1 trans-04">
										${p.name} </a> <span class="header-cart-item-info">
										${o.amount} x $${p.price} </span>
								</div>
							</li>
						</c:if>
					</c:forEach>
				</c:forEach>
			</ul>
			<div class="w-full totalCart">
				<div class="header-cart-buttons flex-w w-full">
					<div class="header-cart-total w-full p-tb-40">Total:
						${totalMoney} đ</div>
					<a href="managerCart" class="site-btn"> Xem giỏ hàng </a> <a
						href="order" class="site-btn"> Thanh toán </a>
				</div>
			</div>
		</div>
	</div>
</div>
<!--end of menu-->
