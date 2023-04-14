<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!--Main layout-->
<main>
	<div class="container pt-4">
		<!--Section: Sales Performance KPIs-->
		<section class="mb-4">
			<c:if test="${error!=null }">
				<div class="alert alert-danger" role="alert">${error}</div>
			</c:if>
			<c:if test="${mess!=null }">
				<div class="alert alert-success" role="alert">${mess}</div>
			</c:if>

			<div class="card">
				<div class="card-header py-3 row">
					<div class="col-sm-6">
						<h5 class="mb-0 text-left" id="">
							<strong>Hóa Đơn</strong>
						</h5>
					</div>
					<div class="col-sm-6">
						<h5 class="mb-0 text-right" id="">
							<form action="xuatExcelShopControl" method="get">
								<input oninput="searchByDate(this)" type="date" id="dateHoaDon"
									name="dateHoaDon" class="form-control mb-0" style="width: 30%">
								<button type="submit" class="btn-green">Xuất file Excel</button>
							</form>
						</h5>
					</div>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-hover text-nowrap">
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col">Mã Hóa Đơn</th>
									<th scope="col">Account</th>
									<th scope="col">Tổng Giá(VNĐ)</th>
									<th scope="col">Ngày Xuất</th>
									<th scope="col">Trạng thái</th>
									<th scope="col">Xem chi tiết</th>
								</tr>
							</thead>

							<tbody id="content">
								<jsp:useBean id="orderStatus" scope="page"
									class="DAOImpl.InvoiceStatusDAOImpl"></jsp:useBean>
								<c:forEach items="${listAllInvoice}" var="i">
									<tr>
										<th scope="row"></th>
										<td>${i.maHD }</td>
										<c:forEach items="${listAllAccount}" var="a">
											<c:if test="${i.accountID==a.id }">
												<td>${a.user }</td>
											</c:if>
										</c:forEach>
										<td><fmt:formatNumber type="number" groupingUsed="true"
												value="${i.tongGia}"></fmt:formatNumber> VNĐ</td>
										<td>${i.ngayXuat }</td>
										<td>${orderStatus.getOne(i.status).name}</td>
										<td><button onclick="invoiceDetailSeller(${i.maHD})"
												data-toggle="modal" data-target="#exampleModalCenter">Xem
												chi tiết</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</section>
		<!--Section: Sales Performance KPIs-->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content"
					style="min-width: 800px; margin-left: -20%;">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Chi tiết
							đơn hàng</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col" style="font-size: 15px">ID</th>
									<th scope="col" style="font-size: 15px;">Tên sản phẩm</th>
									<th scope="col" style="font-size: 15px;">Hình ảnh</th>
									<th scope="col" style="font-size: 15px;">Số lượng</th>
									<th scope="col" style="font-size: 15px;">Kích thước</th>
								</tr>
							</thead>
							<tbody id="contentInvoiceSeller">
							</tbody>
						</table>
					</div>
					<div class="modal-footer" style="height: 130px;"></div>
				</div>
			</div>
		</div>

	</div>
</main>
