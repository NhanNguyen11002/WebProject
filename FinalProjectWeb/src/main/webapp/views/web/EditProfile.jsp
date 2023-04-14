<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!-- Tab items -->
<div class="tabs d-flex justify-content-center mt-5">
	<div class="tab-item active">Thông tin tài khoản</div>
	<div class="tab-item">Lịch sử giao dịch</div>
	<div class="line"></div>
</div>
<!-- Tab content -->
<div class="tab-content">
	<div class="tab-pane active">
		<div class="container bootstrap snippets bootdey"
			style="margin-top: 25px; font-size: 20px;">
			<h1 class="text-primary">Chỉnh sửa thông tin</h1>
			<p>${mess}</p>
			<hr>
			<div class="row">
				<div class="col-md-12 personal-info">
					<p class="text-success">${mess}</p>
					<p class="text-danger">${error}</p>
					<h3>
						Thông tin cá nhân | <a style="color: #007bff;"
							href="${pageContext.request.contextPath}/login/sellerSignup">Đăng
							kí tại khoản bán hàng tại đây</a>
					</h3>
					<c:url value="/editProfile" var="edit"></c:url>
					<form class="form-signin d-flex" action="${edit}" method="post"
						enctype="multipart/form-data">
						<div class="col-md-3">
							<div class="text-center">
								<c:url value="/image?fname=${sessionScope.acc.image }"
									var="imgUrl"></c:url>

								<c:choose>
									<c:when test="${sessionScope.acc.image == null }">
										<img
											src="https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg"
											class="avatar img-circle img-thumbnail" alt="avatar"
											style="width: 200px; height: 200px; border-radius: 50%;">
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when
												test="${sessionScope.acc.image.substring(0,4) == 'http' }">
												<img src="${sessionScope.acc.image}"
													class="avatar img-circle img-thumbnail" alt="avatar"
													style="width: 200px; height: 200px; border-radius: 50%;">
											</c:when>
											<c:otherwise>
												<img src="${imgUrl}" class="avatar img-circle img-thumbnail"
													alt="avatar"
													style="width: 200px; height: 200px; border-radius: 50%;">
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
								<h6>Ảnh đại diện</h6>

								<input type="file" class="form-control" name="images"
									style="height: 40px; font-size: 15px;"
									value="${sessionScope.acc.image}">
							</div>
						</div>
						<div class="col-md-9">
							<div class="form-group">
								<input name="id" value="${sessionScope.acc.id}" hidden="">
								<label class="col-lg-3 control-label">Tên đăng nhập:</label>
								<div class="col-lg-8">
									<input name="username" type="text" id="username"
										class="form-control" value="${sessionScope.acc.user }"
										required="" autofocus=""
										style="height: 45px; font-size: 15px; text-transform: none">
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Mật khẩu:</label>
								<div class="col-lg-8">
									<input name="password" type="password" id="password"
										class="form-control" value="${sessionScope.acc.pass }"
										required="" autofocus=""
										style="height: 45px; font-size: 15px; text-transform: none">
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Email:</label>
								<div class="col-lg-8">
									<input name="email" type="text" id="email" class="form-control"
										value="${sessionScope.acc.email }" required="" autofocus=""
										style="height: 45px; font-size: 15px; text-transform: none">
								</div>
							</div>
							<div class="form-group">
								<button class="site-btn-edit" type="submit">Edit</button>
								<button class="site-btn-delete" type="submit">
									<a href="${pageContext.request.contextPath}/logout"
										class="text-white">Đăng xuất</a>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="tab-pane">
		<div class="container bootstrap snippets bootdey"
			style="margin-top: 25px; font-size: 20px; min-height: 250px;">
			<h1 class="text-primary">Lịch sử giao dịch</h1>
			<div class="row">
				<table class="table table-bordered" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th scope="col" style="font-size: 18px; font-weight: bold;">ID</th>
							<th scope="col" style="font-size: 18px; font-weight: bold;">Tổng
								tiền (VNĐ)</th>
							<th scope="col" style="font-size: 18px; font-weight: bold;">Ngày
								mua</th>
							<th scope="col" style="font-size: 18px; font-weight: bold;">Trạng
								thái</th>
							<th scope="col" style="font-size: 18px; font-weight: bold;">Xem
								chi tiết</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listInvoices}" var="o">
							<jsp:useBean id="orderStatus" scope="page"
								class="DAOImpl.InvoiceStatusDAOImpl"></jsp:useBean>
							<jsp:useBean id="invoiceShop" scope="page"
								class="DAOImpl.InvoiceShopDAOImpl"></jsp:useBean>
							<tr>
								<td style="font-size: 15px">${o.maHD}</td>
								<td style="font-size: 15px"><fmt:formatNumber type="number"
										groupingUsed="true" value="${o.tongGia}"></fmt:formatNumber>
									VNĐ</td>
								<td style="font-size: 15px">${o.ngayXuat}</td>
								<td style="font-size: 15px">Đã giao (
									${invoiceShop.countInvoiceShopCompleted(o.maHD)} /
									${invoiceShop.countAllInvoiceShopByOrderID(o.maHD)} sản phẩm)
								</td>
								<td style="font-size: 15px">
									<button onclick="invoiceDetail(${o.maHD})" data-toggle="modal"
										data-target="#exampleModalCenter">Xem chi tiết</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>

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
							<th scope="col" style="font-size: 15px;">Trạng thái</th>
						</tr>
					</thead>
					<tbody id="contentInvoice">
					</tbody>
				</table>
			</div>
			<div class="modal-footer" style="height: 130px;"></div>
		</div>
	</div>
</div>


