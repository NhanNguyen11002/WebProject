package ControllerSeller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.AccountServices;
import Services.InvoiceServices;
import Services.InvoiceShopServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.InvoiceShopServicesImpl;
import entity.Account;
import entity.InvoiceShop;

@WebServlet(urlPatterns = { "/seller/orderConfirm" })
public class OrderConfirmEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		AccountServices accountServices = new AccountServicesImpl();

		String invoiceID = request.getParameter("iID");

		int iID = Integer.parseInt(invoiceID);

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uID;

		if (a == null) {
			response.sendRedirect("login");
			return;
		}
		uID = a.getId();
		int checkIsSeller = accountServices.checkAccountSeller(uID);
		if (checkIsSeller == 0) {
			response.sendRedirect("login");
			return;
		}

		invoiceShopServices.updateInvoice(iID, 2);

		response.sendRedirect(request.getContextPath() + "/seller/hoaDon");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
