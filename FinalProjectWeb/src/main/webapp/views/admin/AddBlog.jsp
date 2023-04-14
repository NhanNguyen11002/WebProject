<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<main>
	<div class="container">
		<div id="addEmployeeModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="addBlog" method="post" enctype="multipart/form-data">
						<div class="modal-header">
							<h4 class="modal-title">Thêm bài viết</h4>
							<a href="managerBlog"
								style="padding: 10px; border: 1px solid #333; background-color: red; color: white;">&times;
							</a>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Title</label> <input name="title" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Content1</label> <input name="ct1" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Content2</label> <input name="ct2" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Content3</label> <input name="ct3" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Content4</label> <input name="ct4" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Image</label> <input name="image" type="file"
									class="form-control">
							</div>

						</div>
						<div class="modal-footer">
							<a type="button" class="btn btn-default" href="managerBlog">Cancel</a>
							<button class="site-btn-edit" type="submit">Add</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</main>