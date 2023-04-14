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
							<strong>Quản lý tài khoản</strong>
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
									<th scope="col">Username</th>
									<th scope="col">Là người bán hàng</th>
									<th scope="col">Là Admin</th>
									<th scope="col">Là Shipper</th>
									<th scope="col">Email</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listA}" var="o">
									<tr>

										<td>${o.id}</td>
										<td>${o.user}</td>
										<td>${o.isSell}</td>
										<td>${o.isAdmin}</td>
										<td>${o.isShipper}</td>
										<td>${o.email}</td>
										<td><a href="deleteAccount?id=${o.id}"><button
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
			<form action="addAccount" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Thêm tài khoản</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Username</label> <input name="user" type="text"
							class="form-control" required>
					</div>

					<div class="form-group">
						<label>Password</label> <input name="pass" type="password"
							class="form-control" required>
					</div>
					<div class="form-group form-check">
						<input name="isSell" value="1" type="checkbox"
							class="form-check-input" id="isSell"> <label
							class="form-check-label" for="isSell">Là người bán</label>
					</div>

					<div class="form-group form-check">
						<input name="isAdmin" value="1" type="checkbox"
							class="form-check-input" id="isAdmin"> <label
							class="form-check-label" for="isAdmin">Là Admin</label>
					</div>
					<div class="form-group form-check">
						<input name="isShipper" value="1" type="checkbox"
							class="form-check-input" id="isShipper"> <label
							class="form-check-label" for="isShipper">Là Shipper</label>
					</div>
					<div class="form-group">
						<label>Email</label> <input name="email" type="text"
							class="form-control" required>
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

