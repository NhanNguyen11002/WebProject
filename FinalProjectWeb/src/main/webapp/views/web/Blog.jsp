<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<section class="breadcrumb-blog"
	style="background-image: url('template/images/breadcrumb-bg.jpg')">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>Bài viết</h2>
			</div>
		</div>
	</div>
</section>

<section class="blog">
	<div class="container">
		<div class="row">
			<c:forEach items="${listBlog}" var="o">
				<div class="col-lg-4 col-md-6 col-sm-6">
					<div class="blog__item">
						<c:choose>
							<c:when test="${o.image.substring(0,4) == 'http' }">
								<div class="blog__item__pic"
									style="background-image: url('${o.image}')"></div>
							</c:when>
							<c:otherwise>
								<c:url value="/image?fname=${o.image}" var="imgUrl"></c:url>
								<div class="blog__item__pic"
									style="background-image: url('${imgUrl}')"></div>
							</c:otherwise>
						</c:choose>
						<div class="blog__item__text">
							<span><img src="images/icon/calendar.png" alt="" />
								${o.date} </span>
							<h5>${o.title}</h5>
							<a href="detailBlog?bid=${o.blog_id}" title="View Blog">Đọc ngay</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>

