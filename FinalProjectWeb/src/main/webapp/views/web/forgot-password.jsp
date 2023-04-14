<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<div id="logreg-forms">
	<form class="form-signin" action="forgotPassword" method="post"
		style="padding: 80px; background-color: cyan;">
		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
			Forgot Password</h1>
		<c:if test="${mess!=null}">
			<p class="text-success">${mess}</p>
		</c:if>
		<c:if test="${error!=null}">
			<p class="text-danger">${error}</p>
		</c:if>

		<label for="username">Username</label> <input name="username"
			type="text" id="username" class="form-control" placeholder="Username"
			required="" autofocus=""> <label for="email">Email</label> <input
			name="email" type="text" id="email" class="form-control"
			placeholder="Email" required="" autofocus="">
		<button class="btn btn-success btn-block" type="submit">
			<i class="fas fa-sign-in-alt"></i> Retrieve
		</button>

		<span style="margin-top: 10px">Do you have an account?<a
			href="${pageContext.request.contextPath}/login"> Sign In</a>
		</span>
	</form>
</div>


