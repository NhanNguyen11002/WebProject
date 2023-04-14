package ControllerWeb;

import entity.Account;
import entity.Cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.CartServices;
import ServicesImpl.CartServicesImpl;

@WebServlet(name = "AddCartControl", urlPatterns = { "/addCart" })
public class AddCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		int productID = Integer.parseInt(request.getParameter("pid"));
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			response.sendRedirect("login");
			return;
		}
		int accountID = a.getId();
		int amount = Integer.parseInt(request.getParameter("quantity"));
		String size = request.getParameter("size");

		CartServices cartServices = new CartServicesImpl();
		Cart cartExisted = cartServices.checkCartExist(accountID, productID,size);
		int amountExisted;

		if (cartExisted != null) {
			amountExisted = cartExisted.getAmount();
			cartServices.editAmountAndSizeCart(accountID, productID, (amountExisted + amount), size);
			request.setAttribute("mess", "Đã tăng số lượng sản phẩm!");
			request.getRequestDispatcher("managerCart").forward(request, response);
		} else {
			cartServices.insertCart(accountID, productID, amount, size);
			request.setAttribute("mess", "Đã thêm sản phẩm vào giỏ hàng!");
			request.getRequestDispatcher("managerCart").forward(request, response);
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
