package ControllerSeller;

import entity.Account;
import entity.Invoice;
import entity.InvoiceShop;

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
import Services.SellerServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.InvoiceShopServicesImpl;
import ServicesImpl.SellerServicesImpl;

@WebServlet(urlPatterns = { "/seller/hoaDon" })
public class HoaDonControler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		AccountServices accountServices = new AccountServicesImpl();
		SellerServices sellerServices = new SellerServicesImpl();

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uID = a.getId();
		int sellID = sellerServices.getSellerByUID(uID).getSell_ID();

		double sumAllInvoice = invoiceShopServices.sumAllInvoiceBySellID(sellID);

		List<InvoiceShop> listAllInvoice = invoiceShopServices.getAllInvoiceConfirmed(sellID);
		List<Account> listAllAccount = accountServices.getAllAccount();

		request.setAttribute("listAllInvoice", listAllInvoice);
		request.setAttribute("listAllAccount", listAllAccount);
		request.setAttribute("sumAllInvoice", sumAllInvoice);

		request.getRequestDispatcher("/views/seller/HoaDon.jsp").forward(request, response);
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
