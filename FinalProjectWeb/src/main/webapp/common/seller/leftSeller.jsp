<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Sidebar -->
<div class="sidenav">
	<h3 style="text-align: center">Seller : ${sessionScope.acc.user}</h3>
	<a href="${pageContext.request.contextPath}/seller" aria-current="true">
		<i class="fas fa-tachometer-alt fa-fw me-3"></i><span>Main
			dashboard</span>
	</a>
	<button class="dropdown-btn">
		Doanh thu <i class="fa fa-caret-down"></i>
	</button>
	<div class="dropdown-container">
		<a href="${pageContext.request.contextPath}/seller/doanhThuTheoThu">
			<i class="fas fa-chart-pie fa-fw me-3"></i><span>Danh thu thứ</span>
		</a><a href="${pageContext.request.contextPath}/seller/doanhThuTheoThang">
			<i class="fas fa-chart-bar fa-fw me-3"></i><span>Doanh thu
				tháng</span>
		</a>
	</div>
	<a href="${pageContext.request.contextPath}/seller/manager"> <i
		class="fas fa-shoe-prints fa-fw me-3"></i><span>Quản lý sản
			phẩm</span>
	</a> <a href="${pageContext.request.contextPath}/seller/donHang"><i
		class="fas fa-file-invoice-dollar fa-fw me-3"></i><span>Đơn
			hàng</span></a><a href="${pageContext.request.contextPath}/seller/hoaDon"><i
		class="fas fa-file-invoice-dollar fa-fw me-3"></i><span>Hóa Đơn</span></a>
	<a href="${pageContext.request.contextPath}/seller/requestList?rq=-1">
		<i class="fas fa-shoe-prints fa-fw me-3"></i><span>Danh sách
			yêu cầu</span>
	</a> <a href="${pageContext.request.contextPath}/logout"> <i
		class='fas fa-house-user'></i><span>Đăng xuất</span>
	</a>
</div>