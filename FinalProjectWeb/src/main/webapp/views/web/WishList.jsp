<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="shopping-cart" style="margin-top: 1rem; font-size: 15px">
	<div class="px-4 px-lg-0">
		<div class="pb-5" style="min-height: 353px;">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

						<!-- Shopping cart table -->
						<div class="table-responsive">
							<table class="table">
								<thead>
									<c:if test="${error!=null }">
										<div class="alert alert-danger" role="alert">${error}</div>
									</c:if>
									<c:if test="${mess!=null }">
										<div class="alert alert-success" role="alert">${mess}</div>
									</c:if>
									<tr>
										<th scope="col" class="border-0 bg-light">
											<div class="p-2 px-3 text-uppercase"
												style="font-size: 12px; font-weight: bold;">Sản Phẩm</div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase"
												style="font-size: 12px; font-weight: bold;">Đơn Giá</div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase"
												style="font-size: 12px; font-weight: bold;">Màu Sắc</div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase"
												style="font-size: 12px; font-weight: bold;">Delivery</div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase"
												style="font-size: 12px; font-weight: bold;">Actions</div>
										</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listWishList}" var="o">
										<c:forEach items="${listProduct}" var="p">
											<c:if test="${o.proID == p.id}">
												<tr>
													<th scope="row" style="width: 450px">
														<div class="p-2"
															style="display: flex; align-items: center">

															<img src="${p.image}" alt="" width="70"
																class="img-fluid rounded shadow-sm">

															<div class="ml-3 d-inline-block align-middle">
																<h5 class="mb-0">
																	<a href="#" class="text-dark d-inline-block"
																		style="font-size: 15px">${p.name}</a>
																</h5>
																<span class="text-muted font-weight-normal font-italic"></span>
															</div>
														</div>
													</th>
													<td class="align-middle"><strong
														style="font-size: 15px">${p.price}$</strong></td>
													<td class="align-middle"><strong
														style="font-size: 15px">${p.color}</strong></td>
													<td class="align-middle"><strong
														style="font-size: 15px">${p.delivery}</strong></td>
													<td class="align-middle"><a
														href="deleteWishList?productID=${o.proID }"
														class="text-dark">
															<button type="button" style="backgroud: red"
																class="site-btn-delete">Delete</button>
													</a></td>
												</tr>
											</c:if>
										</c:forEach>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- End -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


