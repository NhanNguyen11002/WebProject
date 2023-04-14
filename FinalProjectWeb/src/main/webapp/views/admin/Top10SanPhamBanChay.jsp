<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!--Main layout-->
<main>
	<div class="container pt-4">




		<!--Section: Top 10 san pham ban chay-->
		<section class="mb-4">
			<div class="card">
				<div class="card-header py-3">
					<h5 class="mb-0 text-center">
						<strong>Top 10 sản phẩm bán chạy nhất</strong>
					</h5>
				</div>

				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-hover text-nowrap">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Name</th>
									<th scope="col">Image</th>
									<th scope="col">Giá</th>
									<th scope="col">Số lượng đã bán</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listTop10Product}" var="t">
									<c:forEach items="${listAllProduct}" var="o">
										<c:if test="${t.productID==o.id }">
											<tr>
												<td>${o.id}</td>
												<td>${o.name}</td>
												<td><img src="${o.image}"></td>
												<td><fmt:formatNumber type="number" groupingUsed="true"
														value="${o.price}"></fmt:formatNumber> VNĐ</td>
												<td>${t.soLuongDaBan }</td>
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

