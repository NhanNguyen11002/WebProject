<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<section class="spad">
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-lg-8">
				<div class="blog__details__content">
					<div class="blog__details__share">
						<span>Chia sẻ</span>
						<ul>
							<li><a href="#"><i class="fa-brands fa-facebook-f"></i></a>
							</li>
							<li><a href="#" class="twitter"><i
									class="fa-brands fa-twitter"></i></a></li>
							<li><a href="#" class="youtube"><i
									class="fa-brands fa-youtube"></i></a></li>
							<li><a href="#" class="linkedin"><i
									class="fa-brands fa-linkedin-in"></i></a></li>
						</ul>
					</div>
					<div>

						<div class="blog__hero__text">
							<h2>${detail.title}</h2>
							<ul>
								<li>By Deercreative</li>
								<li>${detail.date}</li>
								<li>${countAllReview }bìnhluận</li>
							</ul>
						</div>
						<div class="col-lg-12">
							<div class="blog__details__pic">
								<c:choose>
									<c:when test="${detail.image.substring(0,4) == 'http' }">
										<img src="${detail.image}" alt="" />
									</c:when>
									<c:otherwise>
										<c:url value="/image?fname=${detail.image}" var="imgUrl"></c:url>
										<img src="${imgUrl}" alt="" />
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="blog__details__text">
							<p>${detail.content1}</p>
							<p>${detail.content2}</p>
						</div>
						<div class="blog__details__quote">
							<i class="fa fa-quote-left"></i>
							<p>"Hãy mang những giấc mơ của bạn lên đôi chân để dẫn lối
								giấc mơ đó thành hiện thực."</p>
							<h6>_ Roger Vivier _</h6>
						</div>
						<div class="blog__details__text">
							<p>${detail.content3}</p>
							<p>${detail.content4}</p>
						</div>
					</div>

					<div class="blog__details__option">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6">
								<div class="blog__details__author">
									<div class="blog__details__author__pic">
										<img src="template/images/blog/details/blog-author.jpg" alt="" />
									</div>
									<div class="blog__details__author__text">
										<h5>Aiden Blair</h5>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div id="reviews" style="font-size: 15px">
						<c:if test="${error!=null }">
							<div class="alert alert-danger" role="alert">${error}</div>
						</c:if>
						<h5 style="font-size: 15px">
							<span>${countAllReview }</span> bình luận
						</h5>
						<div>
							<!-- Your review -->
							<div class="md-form md-outline">
								<label for="form76" style="font-size: 15px">Thêm bình
									luận của bạn</label>

								<textarea id="form76" class="md-textarea form-control pr-6"
									rows="4" style="font-size: 15px; text-transform: none;"></textarea>
							</div>
							<div class="text-right pb-2" style="margin-top: 20px">
								<button style="padding: 15px; font-size: 12px;" type="button"
									class="site-btn-add" onclick="addBlogReview(${detail.blog_id})">Thêm
									bình luận</button>
							</div>
						</div>
						<c:forEach items="${listAllReview}" var="r">
							<div class="media mt-3 mb-4">
								<c:forEach items="${listAllAcount}" var="a">
									<c:if test="${r.accountID == a.id }">
										<c:if test="${a.image == null }">
											<img class="d-flex mr-3 z-depth-1"
												src="https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg"
												width="62" height="62" style="border-radius: 50%"
												alt="Generic placeholder image">
										</c:if>
										<c:if test="${a.image != null }">
											<c:url value="/image?fname=${a.image }" var="imgUrl"></c:url>
											<c:choose>
												<c:when test="${a.image.substring(0,4) == 'http' }">
													<img class="d-flex mr-3 z-depth-1" src="${a.image}"
														width="62" height="62" style="border-radius: 50%"
														alt="Generic placeholder image">
												</c:when>
												<c:otherwise>
													<img class="d-flex mr-3 z-depth-1" src="${imgUrl}"
														width="62" height="62" style="border-radius: 50%"
														alt="Generic placeholder image">
												</c:otherwise>
											</c:choose>
										</c:if>
									</c:if>
								</c:forEach>
								<div class="media-body">
									<div class="d-flex justify-content-between">
										<p class="mt-1 mb-2">
											<c:forEach items="${listAllAcount}" var="a">
												<c:if test="${r.accountID == a.id }">
													<strong>${a.user } </strong>
												</c:if>
											</c:forEach>
											<span>– </span><span>${r.dateReview }</span>
										</p>
										<c:if test="${r.accountID == sessionScope.acc.id }">
											<a class="site-btn-delete" style="color: white"
												href="deleteBlogReview?mid=${r.maReview}"> <i
												class="fa-solid fa-trash"></i>
											</a>
										</c:if>
									</div>
									<p class="mb-0" style="text-transform: none;">${r.contentReview }</p>

								</div>
							</div>
							<hr>
						</c:forEach>
					</div>

				</div>
			</div>
		</div>
	</div>
</section>


