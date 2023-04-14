<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


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
						<a href="doanhThuTheoThu?sID=${t.sell_ID}">${t.name_Shop}</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<section class="mb-4" id="doanhThuThu">
			<div class="card">
				<div class="card-header py-3">
					<h5 class="mb-0 text-center">
						<strong>Doanh thu theo thứ</strong>
					</h5>
				</div>
				<div class="card-body">
					<canvas class="my-4 w-100" id="pieChart" height="380"></canvas>
				</div>
			</div>
		</section>
	</div>
</main>
