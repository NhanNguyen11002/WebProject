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
import Services.ProductServices;
import Services.RequestServices;
import Services.ReviewServices;
import Services.SellerServices;
import Services.TongChiTieuShopServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.InvoiceShopServicesImpl;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.RequestServicesImpl;
import ServicesImpl.ReviewServicesImpl;
import ServicesImpl.SellerServicesImpl;
import ServicesImpl.TongChiTieuShopServicesImpl;
import entity.Account;
import entity.Invoice;
import entity.TongChiTieuShop;

@WebServlet(urlPatterns = { "/seller" })
public class HomeSeller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uID;

		AccountServices accountServices = new AccountServicesImpl();
		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		ProductServices productServices = new ProductServicesImpl();
		SellerServices sellerServices = new SellerServicesImpl();
		TongChiTieuShopServices tongChiTieuShopServices = new TongChiTieuShopServicesImpl();
		RequestServices requestServices = new RequestServicesImpl();

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

		int sellID = sellerServices.getSellerByUID(uID).getSell_ID();

		int allProduct = productServices.countAllProductBySellID(sellID);
		double sumAllInvoice = tongChiTieuShopServices.tongChiTieu(sellID);
		int countRequest = requestServices.countRequestBySellID(sellID);

		double totalMoney1 = invoiceShopServices.totalMoneyDayBySellID(1, sellID);
		double totalMoney2 = invoiceShopServices.totalMoneyDayBySellID(2, sellID);
		double totalMoney3 = invoiceShopServices.totalMoneyDayBySellID(3, sellID);
		double totalMoney4 = invoiceShopServices.totalMoneyDayBySellID(4, sellID);
		double totalMoney5 = invoiceShopServices.totalMoneyDayBySellID(5, sellID);
		double totalMoney6 = invoiceShopServices.totalMoneyDayBySellID(6, sellID);
		double totalMoney7 = invoiceShopServices.totalMoneyDayBySellID(7, sellID);

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

		request.setAttribute("totalMoney1", totalMoney1);
		request.setAttribute("totalMoney2", totalMoney2);
		request.setAttribute("totalMoney3", totalMoney3);
		request.setAttribute("totalMoney4", totalMoney4);
		request.setAttribute("totalMoney5", totalMoney5);
		request.setAttribute("totalMoney6", totalMoney6);
		request.setAttribute("totalMoney7", totalMoney7);

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

		request.setAttribute("sumAllInvoice", sumAllInvoice);

		request.setAttribute("allProduct", allProduct);

		request.setAttribute("countRequest", countRequest);

		request.getRequestDispatcher("/views/seller/Statistic.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

}
