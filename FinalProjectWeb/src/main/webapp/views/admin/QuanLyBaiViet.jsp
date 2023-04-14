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
							<strong>Quản lý bài viết</strong>
						</h5>
					</div>
					<div class="col-sm-6">
						<h5 class="mb-0 text-right" id="">
							<a href="addBlog" class="text-end"><button type="button"
									style="height: 50px; width: 50px; border-radius: 50%; background-color: green; color: white;">
									<i class="material-icons" data-toggle="tooltip" title="Add">&#xe145;</i>
								</button></a>
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
									<th scope="col">Title</th>
									<th scope="col">Image</th>
									<th scope="col">Date</th>
									<th scope="col">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="o">
									<tr>
										<td>${o.blog_id}</td>
										<td>${o.title}</td>
										<c:choose>
											<c:when test="${o.image.substring(0,4) == 'http' }">
												<td><img src="${o.image}"></td>
											</c:when>
											<c:otherwise>
												<c:url value="/image?fname=${o.image }" var="imgUrl"></c:url>
												<td><img src="${imgUrl}"></td>
											</c:otherwise>
										</c:choose>
										<td>${o.date}</td>
										<td><a href="deleteBlog?id=${o.blog_id}"><button
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


