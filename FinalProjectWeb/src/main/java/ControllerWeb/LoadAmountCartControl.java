package ControllerWeb;

import entity.Account;
import entity.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.CartServices;
import ServicesImpl.CartServicesImpl;

@WebServlet(name = "LoadAmountCartControl", urlPatterns = { "/ajax/loadAllAmountCart" })
public class LoadAmountCartControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int totalAmountCart = 0;
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			PrintWriter out = response.getWriter();
			out.println(totalAmountCart);
			return;
		}
		int accountID = a.getId();

		CartServices cartServices = new CartServicesImpl();
		List<Cart> list = cartServices.getCartByAccountID(accountID);
		totalAmountCart = list.size();

		// in list p day
		PrintWriter out = response.getWriter();
		out.println(totalAmountCart);
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
