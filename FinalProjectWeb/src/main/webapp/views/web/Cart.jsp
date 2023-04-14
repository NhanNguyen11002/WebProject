<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="shopping-cart" style="margin-top: 1rem; font-size: 15px">
	<div class="px-4 px-lg-0">

		<div class="pb-5">
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
												style="font-size: 12px; font-weight: bold;">Kích Thước</div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase"
												style="font-size: 12px; font-weight: bold;">Số Lượng</div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase"
												style="font-size: 12px; font-weight: bold;">Xóa</div>
										</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listCart}" var="o">
										<c:forEach items="${listProduct}" var="p">
											<c:if test="${o.productID == p.id}">
												<tr>
													<th scope="row" style="width: 450px">
														<div class="p-2"
															style="display: flex; align-items: center">
															<c:choose>
																<c:when test="${p.image.substring(0,4) == 'http' }">
																	<img src="${p.image}" alt="" width="70"
																		class="img-fluid rounded shadow-sm">
																</c:when>
																<c:otherwise>
																	<c:url value="/image?fname=${p.image }" var="imgUrl"></c:url>
																	<img src="${imgUrl}" alt="" width="70"
																		class="img-fluid rounded shadow-sm">
																</c:otherwise>
															</c:choose>
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
														style="font-size: 15px"><fmt:formatNumber
																type="number" groupingUsed="true" value="${p.price}"></fmt:formatNumber>
															VNĐ</strong></td>
													<td class="align-middle"><strong
														style="font-size: 15px">${p.color}</strong></td>
													<td class="align-middle"><strong
														style="font-size: 15px">${p.delivery}</strong></td>

													<td class="align-middle"><strong
														style="font-size: 15px">${o.size}</strong></td>

													<td class="align-middle"><a
														href="subAmountCart?productID=${o.productID}&amount=${o.amount}"
														style="font-size: 15px]"><button class="btnSub"
																style="padding: 12px">
																<i class="fa-solid fa-minus"></i>
															</button></a> <strong style="font-size: 15px">${o.amount}</strong> <a
														href="addAmountCart?productID=${o.productID}&amount=${o.amount}"><button
																class="btnAdd" style="padding: 12px">
																<i class="fa-solid fa-plus"></i>
															</button></a></td>
													<td class="align-middle"><a
														href="deleteCart?productID=${o.productID }&size=${o.size}"
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

				<div class="row py-5 p-4 bg-white rounded shadow-sm">

					<div class="col-lg-6">
						<div
							class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành
							tiền</div>

						<div class="p-4">
							<ul class="list-unstyled mb-4" id="contentTotalMoney">
								<!-- <li class="d-flex justify-content-between py-3 border-bottom"><strong
									class="text-muted">Tổng tiền hàng</strong><strong>100
										$</strong></li>
								<li class="d-flex justify-content-between py-3 border-bottom"><strong
									class="text-muted">Phí vận chuyển</strong><strong>Free
										ship</strong></li>
								<li class="d-flex justify-content-between py-3 border-bottom"><strong
									class="text-muted">Tổng thanh toán</strong>
									<h5 class="font-weight-bold">110 $</h5></li> -->
							</ul>
							<a href="order" class="primary-btn">Thanh Toán</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
