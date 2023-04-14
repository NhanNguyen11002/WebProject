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
							<strong>Danh sách yêu cầu</strong>
						</h5>
					</div>
				</div>
				<div class="dropdown"
					style="display: flex; align-items: center; justify-content: space-between; width: 100%; margin: 15px;">
					<div class="chooseShop" style="display: flex; align-items: center;">
						<h5 style="font-weight: bold;">Chọn hiển thị</h5>
						<button class="nut_dropdown">${hienThi}</button>
						<div class="noidung_dropdown" style="left: 17%;">
							<a
								href="${pageContext.request.contextPath}/seller/requestList?rq=0">Đã
								xử lí</a> <a
								href="${pageContext.request.contextPath}/seller/requestList?rq=1">Chưa
								xử lí</a>
						</div>
					</div>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-hover text-nowrap">
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col">ID</th>
									<th scope="col">Tên cửa hàng</th>
									<th scope="col">Tên sản phẩm</th>
									<th scope="col">Trạng thái</th>
									<th scope="col">Xem chi tiết</th>
									<th scope="col">Hành động</th>
								</tr>
							</thead>

							<tbody id="content">
								<jsp:useBean id="productHandle" scope="page"
									class="DAOImpl.ProductDAOImpl"></jsp:useBean>
								<jsp:useBean id="sellerHandle" scope="page"
									class="DAOImpl.SellerDAOImpl"></jsp:useBean>
								<c:forEach items="${listRequests}" var="i">
									<tr>
										<th scope="row"></th>
										<td>${i.id }</td>
										<td>${sellerHandle.getSellerBySellID(i.sellID).getName_Shop()}</td>
										<td>${productHandle.getProductByID(i.proID).getName()}</td>
										<td><c:if test="${i.status  == 1 }">Chưa xử lí</c:if> <c:if
												test="${i.status  == 0 }">Đã xử lí</c:if></td>
										<td><button onclick="detailRequest(${i.id})"
												data-toggle="modal" data-target="#exampleModalCenter">Xem
												chi tiết</button></td>
										<c:if test="${i.status  == 1 }">
											<td><a
												href="${pageContext.request.contextPath}/seller/confirmRequest?rID=${i.id}">Xử
													lí</a></td>
										</c:if>
										<c:if test="${i.status  == 0 }">
											<td>Đã xử lí</td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</section>


		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content"
					style="min-width: 800px; margin-left: -20%;">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Chi tiết
							yêu cầu</h5>
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
									<th scope="col" style="font-size: 15px;">Tên cửa hàng</th>
									<th scope="col" style="font-size: 15px;">Tên sản phẩm</th>
									<th scope="col" style="font-size: 15px;">Hình ảnh</th>
									<th scope="col" style="font-size: 15px;">Nội dung</th>
									<th scope="col" style="font-size: 15px;">Trạng thái</th>
								</tr>
							</thead>
							<tbody id="contentRequest">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>

</main>

