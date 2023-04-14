<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Tên sản phẩm</th>
			<th scope="cold">Hình ảnh</th>
			<th scope="col">Số lượng</th>
			<th scope="col">Kích thước</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="o">
			<jsp:useBean id="product" scope="page" class="DAOImpl.ProductDAOImpl"></jsp:useBean>
			<tr>
				<th scope="row" style="font-size: 15px;">${o.id}</th>
				<td style="font-size: 15px;">${product.getProductByID(o.proId).name}</td>
				<td><img src="${product.getProductByID(o.proId).image}"
					width="150px" heigh="150" /></td>
				<td style="font-size: 15px;">${o.proQuantity}</td>
				<td style="font-size: 15px;">${o.proSize}</td>
				<td style="font-size: 15px;">${o.proSize}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>