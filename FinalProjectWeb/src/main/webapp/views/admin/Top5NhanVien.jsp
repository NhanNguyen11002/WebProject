<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!--Main layout-->
<main>
	<div class="container pt-4">
		<!--Section: Quan Ly tai Khoan-->
		<section class="mb-4">
			<div class="card">
				<div class="card-header py-3">
					<h5 class="mb-0 text-center">
						<strong>Top 5 nhân viên bán hàng xuất sắc</strong>
					</h5>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-hover text-nowrap">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Tên Shop</th>
									<th scope="col">SĐT</th>
									<th scope="col">Email</th>
									<th scope="col">Tổng bán hàng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listTop5NhanVien}" var="t">
									<c:forEach items="${listSeller}" var="o">
										<c:if test="${t.sellID==o.sell_ID }">
											<tr>
												<td>${o.sell_ID}</td>
												<td>${o.name_Shop}</td>
												<td>${o.phone_Shop}</td>
												<td>${o.email_Shop}</td>
												<td><fmt:formatNumber type="number" groupingUsed="true"
														value="${t.tongBanHang}"></fmt:formatNumber> VNĐ</td>
											</tr>
										</c:if>
									</c:forEach>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
		<!--Section: Quan Ly tai Khoan-->
	</div>
</main>

