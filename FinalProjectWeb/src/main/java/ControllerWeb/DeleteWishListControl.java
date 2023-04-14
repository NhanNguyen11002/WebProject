package ControllerWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.WishListServices;
import ServicesImpl.WishListServicesImpl;

@WebServlet(name = "DeleteWishListControl", urlPatterns = { "/deleteWishList" })
public class DeleteWishListControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int productID = Integer.parseInt(request.getParameter("productID"));

		WishListServices wishListServices = new WishListServicesImpl();

		wishListServices.deleteCart(productID);

		request.setAttribute("mess", "Đã xóa sản phẩm khỏi danh sách!!");
		request.getRequestDispatcher("wishlist").forward(request, response);
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
	}

}
