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

@WebServlet(urlPatterns = { "/seller/donHang" })
public class DonHangControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

		int checkIsSeller = accountServices.checkAccountSeller(uID);
		if (checkIsSeller == 0) {
			response.sendRedirect("login");
			return;
		}

		List<InvoiceShop> listAllInvoice = invoiceShopServices.getRequestInvoiceShop(1, sellID);
		List<Account> listAllAccount = accountServices.getAllAccount();

		request.setAttribute("listAllInvoice", listAllInvoice);
		request.setAttribute("listAllAccount", listAllAccount);

		request.getRequestDispatcher("/views/seller/DonHang.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
