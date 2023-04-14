package ControllerSeller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.InvoiceServices;
import Services.InvoiceShopServices;
import Services.SellerServices;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.InvoiceShopServicesImpl;
import ServicesImpl.SellerServicesImpl;
import entity.Account;

@WebServlet(urlPatterns = { "/seller/doanhThuTheoThang" })
public class DoanhThuTheoThang extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		SellerServices sellerServices = new SellerServicesImpl();

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uID = a.getId();
		int sellID = sellerServices.getSellerByUID(uID).getSell_ID();

		double totalMoneyMonth1 = invoiceShopServices.totalMoneyMonth(1, sellID);
		double totalMoneyMonth2 = invoiceShopServices.totalMoneyMonth(2, sellID);
		double totalMoneyMonth3 = invoiceShopServices.totalMoneyMonth(3, sellID);
		double totalMoneyMonth4 = invoiceShopServices.totalMoneyMonth(4, sellID);
		double totalMoneyMonth5 = invoiceShopServices.totalMoneyMonth(5, sellID);
		double totalMoneyMonth6 = invoiceShopServices.totalMoneyMonth(6, sellID);
		double totalMoneyMonth7 = invoiceShopServices.totalMoneyMonth(7, sellID);
		double totalMoneyMonth8 = invoiceShopServices.totalMoneyMonth(8, sellID);
		double totalMoneyMonth9 = invoiceShopServices.totalMoneyMonth(9, sellID);
		double totalMoneyMonth10 = invoiceShopServices.totalMoneyMonth(10, sellID);
		double totalMoneyMonth11 = invoiceShopServices.totalMoneyMonth(11, sellID);
		double totalMoneyMonth12 = invoiceShopServices.totalMoneyMonth(12, sellID);

		request.setAttribute("totalMoneyMonth1", totalMoneyMonth1);
		request.setAttribute("totalMoneyMonth2", totalMoneyMonth2);
		request.setAttribute("totalMoneyMonth3", totalMoneyMonth3);
		request.setAttribute("totalMoneyMonth4", totalMoneyMonth4);
		request.setAttribute("totalMoneyMonth5", totalMoneyMonth5);
		request.setAttribute("totalMoneyMonth6", totalMoneyMonth6);
		request.setAttribute("totalMoneyMonth7", totalMoneyMonth7);
		request.setAttribute("totalMoneyMonth8", totalMoneyMonth8);
		request.setAttribute("totalMoneyMonth9", totalMoneyMonth9);
		request.setAttribute("totalMoneyMonth10", totalMoneyMonth10);
		request.setAttribute("totalMoneyMonth11", totalMoneyMonth11);
		request.setAttribute("totalMoneyMonth12", totalMoneyMonth12);

		request.getRequestDispatcher("/views/seller/DoanhThuTheoThang.jsp").forward(request, response);
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
