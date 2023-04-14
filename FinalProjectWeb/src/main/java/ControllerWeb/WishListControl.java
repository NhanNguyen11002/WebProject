package ControllerWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.ProductServices;
import Services.WishListServices;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.WishListServicesImpl;
import entity.Account;
import entity.Product;
import entity.WishList;

@WebServlet(urlPatterns = { "/wishlist" })
public class WishListControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			response.sendRedirect("login");
			return;
		}
		int accountID = a.getId();

		WishListServices wishListServices = new WishListServicesImpl();
		ProductServices productServices = new ProductServicesImpl();

		List<WishList> list = wishListServices.getWishListByAccountID(accountID);
		List<Product> list2 = productServices.getAllProduct();

		request.setAttribute("listWishList", list);
		request.setAttribute("listProduct", list2);


		request.getRequestDispatcher("/views/web/WishList.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	};

	public static void main(String[] args) {
		WishListServices wishListServices = new WishListServicesImpl();
		List<WishList> list = wishListServices.getWishListByAccountID(1036);
		System.out.println(list);
	}

}
