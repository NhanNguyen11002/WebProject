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
							<strong>Quản lý sản phẩm</strong>
						</h5>
					</div>
					<div class="col-sm-6">
						<h5 class="mb-0 text-right" id="">
							<a href="add" class="text-end"><button type="button"
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
									<th scope="col">Name</th>
									<th scope="col">Image</th>
									<th scope="col">Price</th>
									<th scope="col">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listProductSellID}" var="o">
									<tr>
										<td>${o.id}</td>
										<td>${o.name}</td>

										<c:choose>
											<c:when test="${o.image.substring(0,4) == 'http' }">
												<td><img src="${o.image}"></td>
											</c:when>
											<c:otherwise>
												<c:url value="/image?fname=${o.image }" var="imgUrl"></c:url>
												<td><img src="${imgUrl}"></td>
											</c:otherwise>
										</c:choose>

										<td><fmt:formatNumber type="number" groupingUsed="true"
												value="${o.price}"></fmt:formatNumber> VNĐ</td>
										<td><a href="loadProduct?pid=${o.id}"><button
													type="button" class="btn btn-warning">
													<i class="material-icons" data-toggle="tooltip"
														title="Edit">&#xE254;</i>
												</button></a> <a href="delete?pid=${o.id}"><button type="button"
													class="btn btn-danger">
													<i class="material-icons" data-toggle="tooltip"
														title="Delete">&#xE872;</i>
												</button></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<div class="clearfix">
							<ul class="pagination">
								<c:if test="${tag != 1}">
									<li class="page-item"><a href="manager?index=${tag-1 }">Previous</a></li>
								</c:if>
								<c:forEach begin="1" end="${endPage }" var="i">
									<li class=" page-item ${tag==i?"active":"" }"><a
										href="manager?index=${i }" class="page-link">${i }</a></li>
								</c:forEach>
								<c:if test="${tag != endPage}">
									<li class="page-item"><a href="manager?index=${tag+1 }"
										class="page-link">Next</a></li>
								</c:if>
							</ul>
						</div>

					</div>
				</div>
			</div>
		</section>
		<!--Section: Quan Ly tai Khoan-->
	</div>


</main>
