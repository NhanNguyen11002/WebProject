package ControllerWeb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.AccountServices;
import Services.SellerServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.SellerServicesImpl;
import entity.Account;
import entity.Email;
import entity.EmailUtils;

@WebServlet(urlPatterns = { "/login/signupSeller" })
public class AddSellerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uID = a.getId();
		String nameShop = request.getParameter("nameShop");
		String phoneShop = request.getParameter("phoneShop");
		String emailShop = request.getParameter("emailShop");

		SellerServices sellerServices = new SellerServicesImpl();
		AccountServices accountServices = new AccountServicesImpl();

		accountServices.updateSeller(uID);
		sellerServices.singup(nameShop, phoneShop, emailShop, uID);

		response.sendRedirect(request.getContextPath() + "/home");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

}
