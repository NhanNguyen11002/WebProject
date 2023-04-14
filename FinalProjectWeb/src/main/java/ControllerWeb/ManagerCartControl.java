package ControllerWeb;

import entity.Account;
import entity.Cart;
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
import javax.servlet.http.HttpSession;

import Services.CartServices;
import Services.ProductServices;
import ServicesImpl.CartServicesImpl;
import ServicesImpl.ProductServicesImpl;

@WebServlet(name = "ManagerCartControl", urlPatterns = { "/managerCart" })
public class ManagerCartControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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

		CartServices cartServices = new CartServicesImpl();
		ProductServices productServices = new ProductServicesImpl();

		List<Cart> list = cartServices.getCartByAccountID(accountID);
		List<Product> list2 = productServices.getAllProduct();

		request.setAttribute("listCart", list);
		request.setAttribute("listProduct", list2);
		request.getRequestDispatcher("/views/web/Cart.jsp").forward(request, response);

		double totalMoney = 0;
		for (Cart o : list) {
			for (Product p : list2) {
				if (o.getProductID() == p.getId()) {
					totalMoney = totalMoney + (p.getPrice() * o.getAmount());
				}
			}
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
	}

}
