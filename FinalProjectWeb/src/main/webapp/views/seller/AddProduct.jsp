<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<main>
	<div class="container">
		<div id="addEmployeeModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="add" method="post" enctype="multipart/form-data">
						<div class="modal-header">
							<h4 class="modal-title">Add Product</h4>
							<a href="manager"
								style="padding: 10px; border: 1px solid #333; background-color: red; color: white;">&times;
							</a>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Name</label> <input name="name" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Image</label> <input name="image" type="file"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Image 2</label> <input name="image2" type="file"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Image 3</label> <input name="image3" type="file"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Image 4</label> <input name="image4" type="file"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Price</label> <input name="price" type="text"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Title</label>
								<textarea name="title" class="form-control" required></textarea>
							</div>
							<div class="form-group">
								<label>Model</label> <input name="model" type="text"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Color</label> <input name="color" type="text"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Delivery</label> <input name="delivery" type="text"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Description</label>
								<textarea name="description" class="form-control"></textarea>
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
							<a type="button" class="btn btn-default" href="manager">Cancel</a>
							<button class="site-btn-edit" type="submit">Add</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</main>