<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="container" id="container">
	<div class="form-container sign-in-container">
		<!-- 	đăng kí  -->
		<form action="signupSeller" method="post" class="form-signup">
			<h1>Tạo cửa hàng của bạn</h1>
			<input name="nameShop" type="text" id="user-name"
				class="form-control" placeholder="Tên cửa hàng" required=""
				autofocus="" /> <input name="phoneShop" type="text" id="user-pass"
				class="form-control" placeholder="Số điện thoại" required
				autofocus="" /> <input name="emailShop" type="text" id="email"
				class="form-control" placeholder="Email" required="" autofocus="" />
			<button type="submit">Đăng kí</button>
		</form>
	</div>

	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-right">
				<h1>Xin chào</h1>
				<p>Đăng kí tài khoản bán hàng để có thể bán hàng hiệu
					quả nhé</p>
			</div>
		</div>
	</div>
</div>