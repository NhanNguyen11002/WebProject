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
import entity.Invoice;
import entity.InvoiceShop;

@WebServlet(urlPatterns = { "/shipper/receiveShipper" })
public class ReceiveShipperControler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		AccountServices accountServices = new AccountServicesImpl();

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

		List<InvoiceShop> listAllInvoice = invoiceShopServices.getAllRequestInvoiceShop(3);

		request.setAttribute("listAllInvoice", listAllInvoice);

		request.getRequestDispatcher("/views/shipper/InvoiceReceive.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
