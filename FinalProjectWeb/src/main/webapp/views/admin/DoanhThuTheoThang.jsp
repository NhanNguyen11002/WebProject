<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!--Main layout-->
<main>
	<div class="container pt-4">
		<div class="header"
			style="margin-bottom: 20px; display: flex; justify-content: space-around; align-items: center">
			<h5>
				Tổng doanh thu:
				<fmt:formatNumber type="number" groupingUsed="true"
					value="${sumAllInvoice}"></fmt:formatNumber>
				VNĐ
			</h5>
			<div class="dropdown"
				style="display: flex; align-items: center; justify-content: center;">
				<h5>Chọn shop muốn theo dõi số liệu:</h5>
				<button class="nut_dropdown">${nameShop}</button>
				<div class="noidung_dropdown">
					<c:forEach items="${listSellers}" var="t">
						<a href="doanhThuTheoThang?sID=${t.sell_ID}">${t.name_Shop}</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- Section: Main chart 2 -->
		<section class="mb-4" id="doanhThuThang">
			<div class="card">
				<div class="card-header py-3">
					<h5 class="mb-0 text-center">
						<strong>Doanh thu theo tháng</strong>
					</h5>
				</div>
				<div class="card-body">
					<canvas id="horizontalBar"></canvas>
				</div>
			</div>
		</section>
		<!-- Section: Main chart 2 -->

	</div>
</main>

