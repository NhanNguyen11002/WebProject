<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="d-flex justify-content-center align-items-center">
	<div class="card py-5 px-3">
		<h3 class="m-0">Xác nhận email</h3>
		<span class="mobile-text">Nhập code mà chúng tôi đã gửi
			đến email của bạn </span>
		<c:if test="${error != null}">
			<h5 class="text-danger text-center mt-5">${error}</h5>
		</c:if>
		<c:if test="${mess != null}">
			<div class="mt-5 text-center">
				<h5 class="text-success">${mess}</h5>
				<a class="font-weight-bold text-danger cursor text-center"
					href="${pageContext.request.contextPath}/login">Đăng nhập</a>
			</div>
		</c:if>
		<c:url value="/login/verifyEmail" var="verify"></c:url>
		<form method="post" action="${verify}">
			<div class="d-flex flex-row mt-5">
				<input type="text" class="form-control" autofocus="" name="authcode">
			</div>
			<button class="site-btn-add">Xác nhận</button>
		</form>

		<div class="text-center mt-5">
			<span class="d-block mobile-text">Chưa nhận được code?</span><a
				class="font-weight-bold text-danger cursor">Gửi lại</a>
		</div>
	</div>
</div>