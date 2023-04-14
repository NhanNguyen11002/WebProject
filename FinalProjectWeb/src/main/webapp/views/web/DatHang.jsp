<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>



<section class="breadcrumb-option">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="breadcrumb__text">
					<h4>Thanh toán</h4>
					<div class="breadcrumb__links">
						<a href="home">Trang chủ</a> <a href="shop">Cửa hàng</a> <span>Thanh
							toán</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="checkout">
	<div class="container">
		<div class="checkout__form">
			<form class="form-signin" action="order" method="post">
				<div class="row">
					<div class="col-lg-8 col-md-6">
						<h6 class="checkout__title">Chi tiết hóa đơn</h6>
						<c:if test="${error!=null }">
							<div class="alert alert-danger" role="alert">${error}</div>
						</c:if>
						<c:if test="${mess!=null }">
							<div class="alert alert-success" role="alert">${mess}</div>
						</c:if>
						<div class="row">
							<div class="col-lg-12">
								<div class="checkout__input">
									<label for="name">Tên</label> <input
										style="text-transform: none;" name="name" type="text"
										id="name" class="form-control" placeholder="Name" required=""
										autofocus="">
								</div>
							</div>

						</div>
						<div class="checkout__input">
							<label for="phoneNumber">Số điện thoại</label> <input
								style="text-transform: none;" name="phoneNumber" type="text"
								id="phoneNumber" class="form-control" placeholder="Phone number"
								required="" autofocus="">
						</div>
						<div class="checkout__input">
							<label for="email">Địa chỉ email</label> <input name="email"
								style="text-transform: none;" type="text" id="email"
								class="form-control" placeholder="email" required=""
								autofocus="">
						</div>
						<div class="checkout__input">
							<label for="deliveryAddress">Địa chỉ nhận hàng</label> <input
								style="text-transform: none;" name="deliveryAddress" type="text"
								id="deliveryAddress" class="form-control"
								placeholder="Delivery Address" required="" autofocus="">
						</div>
					</div>


					<div class="col-lg-4 col-md-6">
						<div class="checkout__order">
							<h4 class="order__title">Đơn hàng của bạn</h4>
							<div class="checkout__order__products">
								Sản phẩm <span>Thành tiền</span>
							</div>
							<ul class="checkout__total__products">
								<c:forEach items="${listCart}" var="o">
									<c:forEach items="${listProduct}" var="p">
										<c:if test="${o.productID == p.id}">
											<li>${p.name}<span><fmt:formatNumber
														type="number" groupingUsed="true" value="${p.price}"></fmt:formatNumber>
											</span></li>
										</c:if>
									</c:forEach>
								</c:forEach>
							</ul>
							<ul class="checkout__total__all">
								<li>Tổng tiền <span>${totalMoney} VNĐ</span></li>
							</ul>
							<button type="submit" class="site-btn">Đặt hàng</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
