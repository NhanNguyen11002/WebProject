<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<main>
	<div class="container">
		<div id="editEmployeeModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="sendRequest" method="post"
						enctype="multipart/form-data">
						<div class="modal-header">
							<h4 class="modal-title">GỬI YÊU CẦU</h4>
							<a href="${pageContext.request.contextPath}/admin/manager?sID=-1"
								type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</a>
						</div>
						<div class="modal-body">
							<div class="info_item">
								<h5>Thông tin sản phẩm</h5>
								<p>
									<span style="font-weight: bold">Tên</span>: ${itemProduct.name}
								</p>
								<p>
									<span style="font-weight: bold">Model</span>:
									${itemProduct.model}
								</p>
								<p>
									<span style="font-weight: bold">Màu sắc</span>:
									${itemProduct.color}
								</p>
							</div>
							<div class="form-group">
								<!--                          <label>ID</label> -->
								<input value="${itemProduct.id}" name="id" type="hidden"
									class="form-control" readonly required>
							</div>
							<div class="form-group">
								<label>Nội dung yêu cầu</label> <input name="content"
									type="text" id="user-name" class="form-control" required=""
									autofocus="" />
							</div>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-success" value="Gửi">
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</main>