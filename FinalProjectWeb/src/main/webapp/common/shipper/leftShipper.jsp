<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Sidebar -->
<div class="sidenav">
	<h3 style="text-align: center; font-size: 20px; color: #566787">Shipper
		: ${sessionScope.acc.user}</h3>
	<a href="${pageContext.request.contextPath}/shipper"
		aria-current="true"> <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>Tất
			cả đơn hàng </span>
	</a> <a href="${pageContext.request.contextPath}/shipper/receiveShipper"
		aria-current="true"> <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>Đơn
			hàng đã nhận </span>
	</a> <a href="${pageContext.request.contextPath}/shipper/successShipper"
		aria-current="true"> <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>Đơn
			hàng đã giao </span>
	</a><a href="${pageContext.request.contextPath}/logout"> <i
		class='fas fa-house-user'></i><span>Đăng xuất</span>
	</a>
</div>