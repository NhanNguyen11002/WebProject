package ControllerShipper;

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

@WebServlet(urlPatterns = { "/shipper/successInvoice" })
public class InvoiceSuccessControler extends HttpServlet {

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
		int checkIsShipper = accountServices.checkAccountShipper(uID);
		if (checkIsShipper == 0) {
			response.sendRedirect("login");
			return;
		}

		invoiceShopServices.updateInvoice(iID, 4);

		request.setAttribute("mess", "Đã giao hàng thành công");

		response.sendRedirect(request.getContextPath() + "/shipper/receiveShipper");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
