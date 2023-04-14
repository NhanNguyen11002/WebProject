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
						<strong>Top 5 khách hàng mua nhiều nhất</strong>
					</h5>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-hover text-nowrap">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Username</th>
									<th scope="col">Email</th>
									<th scope="col">Tổng chi tiêu</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listTop5KhachHang}" var="t">
									<c:forEach items="${listAllAccount}" var="o">
										<c:if test="${t.userID==o.id }">
											<tr>
												<td>${o.id}</td>
												<td>${o.user}</td>
												<td>${o.email}</td>
												<td><fmt:formatNumber type="number" groupingUsed="true"
														value="${t.tongChiTieu }"></fmt:formatNumber> VNĐ</td>
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

