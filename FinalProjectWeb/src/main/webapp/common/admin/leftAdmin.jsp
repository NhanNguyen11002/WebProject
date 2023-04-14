<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Sidebar -->
<div class="sidenav">
	<h3 style="text-align: center">Admin : ${sessionScope.acc.user}</h3>
	<a href="${pageContext.request.contextPath}/admin" aria-current="true">
		<i class="fas fa-tachometer-alt fa-fw me-3"></i><span>Main
			dashboard</span>
	</a>
	<button class="dropdown-btn">
		Doanh thu <i class="fa fa-caret-down"></i>
	</button>
	<div class="dropdown-container">
		<a
			href="${pageContext.request.contextPath}/admin/doanhThuTheoThu?sID=-1">
			<i class="fas fa-chart-pie fa-fw me-3"></i><span>Danh thu thứ</span>
		</a><a
			href="${pageContext.request.contextPath}/admin/doanhThuTheoThang?sID=-1">
			<i class="fas fa-chart-bar fa-fw me-3"></i><span>Doanh thu
				tháng</span>
		</a>
	</div>
	<button class="dropdown-btn">
		Quản lí <i class="fa fa-caret-down"></i>
	</button>
	<div class="dropdown-container">
		<a href="${pageContext.request.contextPath}/admin/managerAccount">
			<i class="fas fa-user-circle fa-fw me-3"></i><span>Quản lý tài
				khoản</span>
		</a> <a href="${pageContext.request.contextPath}/admin/manager?sID=-1">
			<i class="fas fa-shoe-prints fa-fw me-3"></i><span>Quản lý sản
				phẩm</span>
		</a> <a href="${pageContext.request.contextPath}/admin/managerBlog"> <i
			class="fas fa-user-circle fa-fw me-3"></i><span>Quản lý bài
				viết</span>
		</a><a href="${pageContext.request.contextPath}/admin/managerSupplier">
			<i class="fas fa-parachute-box fa-fw me-3"></i><span>Quản lý
				nhà cung cấp</span>
		</a>
	</div>
	<button class="dropdown-btn">
		Bảng xếp hạng <i class="fa fa-caret-down"></i>
	</button>
	<div class="dropdown-container">
		<a href="${pageContext.request.contextPath}/admin/top10"> <i
			class="fas fa-shoe-prints fa-fw me-3"></i><span>Top 10 sản
				phẩm</span>
		</a> <a href="${pageContext.request.contextPath}/admin/top5khachhang">
			<i class="fas fa-user-circle fa-fw me-3"></i><span>Top 5 khách
				hàng</span>
		</a> <a href="${pageContext.request.contextPath}/admin/top5nhanvien">
			<i class="fas fa-user-circle fa-fw me-3"></i><span>Top 5 cửa
				hàng</span>
		</a>
	</div>
	<a href="${pageContext.request.contextPath}/admin/hoaDon"><i
		class="fas fa-file-invoice-dollar fa-fw me-3"></i><span>Hóa Đơn</span></a>
	<a href="${pageContext.request.contextPath}/admin/request?rq=-1"> <i
		class='fas fa-house-user'></i><span>Danh sách yêu cầu</span>
	</a><a href="${pageContext.request.contextPath}/logout"> <i
		class='fas fa-house-user'></i><span>Đăng xuất</span>
	</a>
</div>