<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<main>
	<div class="container">
		<div id="editEmployeeModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="edit" method="post" enctype="multipart/form-data">
						<div class="modal-header">
							<h4 class="modal-title">Edit Product</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<!--                          <label>ID</label> -->
								<input value="${detail.id}" name="id" type="hidden"
									class="form-control" readonly required>
							</div>
							<div class="form-group">
								<label>Name</label> <input value="${detail.name}" name="name"
									type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Image</label> <input value="${detail.image}" name="image"
									type="file" class="form-control">
							</div>
							<div class="form-group">
								<label>Image 2</label> <input value="${detail.image2}"
									name="image2" type="file" class="form-control">
							</div>
							<div class="form-group">
								<label>Image 3</label> <input value="${detail.image3}"
									name="image3" type="file" class="form-control">
							</div>
							<div class="form-group">
								<label>Image 4</label> <input value="${detail.image4}"
									name="image4" type="file" class="form-control">
							</div>
							<div class="form-group">
								<label>Price</label> <input value="${detail.price}" name="price"
									type="text" class="form-control">
							</div>
							<div class="form-group">
								<label>Title</label>
								<textarea name="title" class="form-control" required>${detail.title}</textarea>
							</div>
							<div class="form-group">
								<label>Model</label>
								<textarea name="model" class="form-control" required>${detail.model}</textarea>
							</div>
							<div class="form-group">
								<label>Color</label>
								<textarea name="color" class="form-control" required>${detail.color}</textarea>
							</div>
							<div class="form-group">
								<label>Delivery</label>
								<textarea name="delivery" class="form-control" required>${detail.delivery}</textarea>
							</div>
							<div class="form-group">
								<label>Description</label>
								<textarea name="description" class="form-control">${detail.description}</textarea>
							</div>
							<div class="form-group">
								<label>Category</label> <select name="category"
									class="form-select" aria-label="Default select example">
									<c:forEach items="${listCC}" var="o">
										<option value="${o.cid}">${o.cname}</option>
									</c:forEach>
								</select>
							</div>

						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-success" value="Edit">
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</main>