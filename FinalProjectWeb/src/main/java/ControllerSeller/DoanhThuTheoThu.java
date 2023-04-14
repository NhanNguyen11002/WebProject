package ControllerSeller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.InvoiceShopServices;
import Services.SellerServices;
import ServicesImpl.InvoiceShopServicesImpl;
import ServicesImpl.SellerServicesImpl;
import entity.Account;

@WebServlet(urlPatterns = { "/seller/doanhThuTheoThu" })
public class DoanhThuTheoThu extends HttpServlet {

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

		double totalMoney1 = invoiceShopServices.totalMoneyDayBySellID(1, sellID);
		double totalMoney2 = invoiceShopServices.totalMoneyDayBySellID(2, sellID);
		double totalMoney3 = invoiceShopServices.totalMoneyDayBySellID(3, sellID);
		double totalMoney4 = invoiceShopServices.totalMoneyDayBySellID(4, sellID);
		double totalMoney5 = invoiceShopServices.totalMoneyDayBySellID(5, sellID);
		double totalMoney6 = invoiceShopServices.totalMoneyDayBySellID(6, sellID);
		double totalMoney7 = invoiceShopServices.totalMoneyDayBySellID(7, sellID);

		request.setAttribute("totalMoney1", totalMoney1);
		request.setAttribute("totalMoney2", totalMoney2);
		request.setAttribute("totalMoney3", totalMoney3);
		request.setAttribute("totalMoney4", totalMoney4);
		request.setAttribute("totalMoney5", totalMoney5);
		request.setAttribute("totalMoney6", totalMoney6);
		request.setAttribute("totalMoney7", totalMoney7);

		request.getRequestDispatcher("/views/seller/DoanhThuTheoThu.jsp").forward(request, response);
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
