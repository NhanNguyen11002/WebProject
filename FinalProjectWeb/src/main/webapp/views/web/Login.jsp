<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="container" id="container">
	<div class="form-container sign-up-container">
		<!-- 	đăng kí  -->
		<form action="signup" method="post" class="form-signup" name="myform"
			onsubmit="return validateform()">
			<h1>Tạo tài khoản</h1>
			<div class="social-container">
				<button class="other-method-btn other-method-btn-gg"
					onclick="location.href='https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/FinalProjectWeb/LoginGoogleHandler&response_type=code&client_id=850885901229-u1ebsjghsmk663n94bd28igle10l5i84.apps.googleusercontent.com&approval_prompt=force'">
					<i class="fab fa-google-plus-g"></i>
				</button>
			</div>
			<span>hoặc sử dụng email để đăng kí</span> <input name="user"
				type="text" id="user-name" class="form-control"
				placeholder="Tên đăng nhập" required="" autofocus="" /> <input
				name="pass" type="password" id="user-pass" class="form-control"
				placeholder="Mật khẩu" required autofocus="" /> <input
				name="repass" type="password" id="user-repeatpass"
				class="form-control" placeholder="Nhập lại mật khẩu" required
				autofocus="" /> <input name="email" type="email" id="email"
				class="form-control" placeholder="Email" required="" autofocus="" />
			<button type="submit">Đăng kí</button>
		</form>
	</div>

	<!-- đăng nhập -->
	<div class="form-container sign-in-container">
		<form action="login" method="post">
			<h1>Đăng nhập</h1>
			<div class="social-container">
				<button class="other-method-btn other-method-btn-gg"
					onclick="location.href='https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/FinalProjectWeb/LoginGoogleHandler&response_type=code&client_id=850885901229-u1ebsjghsmk663n94bd28igle10l5i84.apps.googleusercontent.com&approval_prompt=force'">
					<i class="fab fa-google-plus-g"></i>
				</button>
			</div>
			<span>hoặc sử dụng tài khoản của bạn</span>
			<c:if test="${error!=null }">
				<div class="alert alert-danger" role="alert">${error}</div>
			</c:if>
			<c:if test="${mess!=null }">
				<div class="alert alert-success" role="alert">${mess}</div>
			</c:if>
			<input name="user" value="${username }" type="text" id="inputEmail"
				class="form-control" placeholder="Tên đăng nhập" required=""
				autofocus=""> <input name="pass" value="${password }"
				type="password" id="inputPassword" class="form-control"
				placeholder="Mật khẩu" required="">
			<div style="margin-top: 10px">
				<input name="remember" value="1" type="checkbox"
					class="form-check-input" id="exampleCheck1"> <label
					class="form-check-label" for="exampleCheck1">Nhớ tôi</label>
			</div>
			<a href="login/forgotPassword">Quên mật khẩu</a>
			<button type="submit" id="btn-signup">Đăng nhập</button>
		</form>
	</div>

	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Xin chào</h1>
				<p>Đăng kí tài khoản để có những trải nghiệm tốt nhất
					nhé</p>
				<button class="ghost" id="signIn">Đăng nhập</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Xin chào</h1>
				<p>Để có thể mua hàng, vui lòng đăng nhập bằng tài
					khoản của bạn</p>
				<button class="ghost" id="signUp">Đăng kí</button>
			</div>
		</div>
	</div>
</div>