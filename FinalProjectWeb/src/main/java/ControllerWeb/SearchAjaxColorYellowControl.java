package ControllerWeb;

import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ProductServices;
import ServicesImpl.ProductServicesImpl;

@WebServlet(name = "SearchAjaxColorYellowControl", urlPatterns = { "/ajax/searchAjaxColorYellow" })
public class SearchAjaxColorYellowControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		request.setCharacterEncoding("UTF-8");

		ProductServices productServices = new ProductServicesImpl();

		List<Product> list = productServices.searchColorYellow();

		PrintWriter out = response.getWriter();
		
		NumberFormat currentLocale = NumberFormat.getInstance();
		for (Product o : list) {
			String newPrice = currentLocale.format(o.getPrice());
			String oldPrice = currentLocale.format(o.getPrice() * 1.1);
			out.println("<div class=\"product col-lg-4 col-md-6 col-sm-6\">\r\n"
					+ "							<div class=\"single-product\">\r\n"
					+ "								<c:choose>\r\n"
					+ "									<c:when test=\"${o.image.substring(0,4) == 'http' }\">\r\n"
					+ "										<a href=\"detail?pid="+o.getId()+"\" title=\"View Product\"> <img\r\n"
					+ "											class=\"img-fluid\" src=\""+o.getImage()+"\" alt=\"\" />\r\n"
					+ "										</a>\r\n"
					+ "									</c:when>\r\n"
					+ "									<c:otherwise>\r\n"
					+ "										<c:url value=\"/image?fname="+o.getImage()+"\" var=\"imgUrl\"></c:url>\r\n"
					+ "										<a href=\"detail?pid="+o.getId()+"\" title=\"View Product\"> <img\r\n"
					+ "											class=\"img-fluid\" src=\"${imgUrl }\" alt=\"\" />\r\n"
					+ "										</a>\r\n"
					+ "									</c:otherwise>\r\n"
					+ "								</c:choose>\r\n"
					+ "								<div class=\"product-details\">\r\n"
					+ "									<h6>"+o.getName()+"</h6>\r\n"
					+ "									<div class=\"price\">\r\n"
					+ "										<h6>"+newPrice+" VNĐ</h6>\r\n"
					+ "										<h6 class=\"l-through\">"+oldPrice+" VNĐ</h6>\r\n"
					+ "									</div>\r\n"
					+ "									<div class=\"prd-bottom\">\r\n"
					+ "										<a href=\"addCart?pid="+o.getId()+"&quantity=1&size=small\"\r\n"
					+ "											class=\"social-info\"> <span class=\"lnr lnr-cart\"></span>\r\n"
					+ "											<p class=\"hover-text\">add to bag</p>\r\n"
					+ "										</a> <a href=\"addWishList?pid="+o.getId()+"\" class=\"social-info\"> <span\r\n"
					+ "											class=\"lnr lnr-heart\"></span>\r\n"
					+ "											<p class=\"hover-text\">Wishlist</p>\r\n"
					+ "										</a> <a href=\"detail?pid="+o.getId()+"\" title=\"View Product\"\r\n"
					+ "											class=\"social-info\"> <span class=\"lnr lnr-move\"></span>\r\n"
					+ "											<p class=\"hover-text\">view more</p>\r\n"
					+ "										</a>\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "							</div>\r\n"
					+ "						</div>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
