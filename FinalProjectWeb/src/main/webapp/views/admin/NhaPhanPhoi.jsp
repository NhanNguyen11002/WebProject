<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!--Main layout-->
<main>
	<div class="container pt-4">
		<!--Section: Quan Ly tai Khoan-->
		<section class="mb-4">
			<div class="card">
				<div class="card-header py-3 row">
					<div class="col-sm-6">
						<h5 class="mb-0 text-left" id="">
							<strong>Quản lý nhà cung cấp</strong>
						</h5>
					</div>
					<div class="col-sm-6">
						<h5 class="mb-0 text-right" id="">
							<a href="#addEmployeeModal" class="btn btn-success"
								data-toggle="modal"><i class="material-icons">&#xE147;</i></a>
						</h5>
					</div>
				</div>
				<c:if test="${error!=null }">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<c:if test="${mess!=null }">
					<div class="alert alert-success" role="alert">${mess}</div>
				</c:if>

				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-hover text-nowrap">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Tên nhà cung cấp</th>
									<th scope="col">Số điện thoại</th>
									<th scope="col">Email</th>
									<th scope="col">Địa chỉ</th>
									<th scope="col">Phân phối cho</th>
									<th scope="col">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listAllSupplier}" var="o">

									<tr>
										<td>${o.idSupplier}</td>
										<td>${o.nameSupplier}</td>
										<td>${o.phoneSupplier}</td>
										<td>${o.emailSupplier}</td>
										<td>${o.addressSupplier}</td>
										<c:forEach items="${listAllCategory}" var="t">
											<c:if test="${o.cateID==t.cid }">
												<td>${t.cname }</td>
											</c:if>
										</c:forEach>
										<td><a href="deleteSupplier?id=${o.idSupplier}"><button
													type="button" class="btn btn-danger">
													<i class="material-icons" data-toggle="tooltip"
														title="Delete">&#xE872;</i>
												</button></a></td>
									</tr>
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
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="addSupplier" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Thêm nhà cung cấp</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Tên nhà cung cấp</label> <input name="nameSupplier"
							type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Số điện thoại</label> <input name="phoneSupplier"
							type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Email</label> <input name="emailSupplier" type="text"
							class="form-control" required>
					</div>
					<div class="form-group">
						<label>Địa chỉ</label> <input name="addressSupplier" type="text"
							class="form-control" required>
					</div>
					<div class="form-group">
						<label>Cung cấp cho</label> <select name="cateID"
							class="form-select" aria-label="Default select example">
							<c:forEach items="${listAllCategory}" var="t">
								<option value="${t.cid}">${t.cname}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal"
						value="Cancel"> <input type="submit"
						class="btn btn-success" value="Add">
				</div>
			</form>
		</div>
	</div>
</div>
