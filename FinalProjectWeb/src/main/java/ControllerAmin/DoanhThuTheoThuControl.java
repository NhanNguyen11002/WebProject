package ControllerAmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.InvoiceServices;
import Services.InvoiceShopServices;
import Services.SellerServices;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.InvoiceShopServicesImpl;
import ServicesImpl.SellerServicesImpl;
import entity.Seller;

@WebServlet(name = "DoanhThuTheoThuControl", urlPatterns = { "/admin/doanhThuTheoThu" })
public class DoanhThuTheoThuControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		int sID = Integer.parseInt(request.getParameter("sID"));

		String nameShop = "---Chọn---";

		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		SellerServices sellerServices = new SellerServicesImpl();

		double totalMoney1 = 0;
		double totalMoney2 = 0;
		double totalMoney3 = 0;
		double totalMoney4 = 0;
		double totalMoney5 = 0;
		double totalMoney6 = 0;
		double totalMoney7 = 0;

		if (sID != -1) {
			totalMoney1 = invoiceShopServices.totalMoneyDayBySellID(1, sID);
			totalMoney2 = invoiceShopServices.totalMoneyDayBySellID(2, sID);
			totalMoney3 = invoiceShopServices.totalMoneyDayBySellID(3, sID);
			totalMoney4 = invoiceShopServices.totalMoneyDayBySellID(4, sID);
			totalMoney5 = invoiceShopServices.totalMoneyDayBySellID(5, sID);
			totalMoney6 = invoiceShopServices.totalMoneyDayBySellID(6, sID);
			totalMoney7 = invoiceShopServices.totalMoneyDayBySellID(7, sID);

			nameShop = sellerServices.getSellerBySellID(sID).getName_Shop();
		}

		double sumAllInvoice = invoiceServices.sumAllInvoice();

		List<Seller> listSellers = sellerServices.getAllSeller();

		request.setAttribute("totalMoney1", totalMoney1);
		request.setAttribute("totalMoney2", totalMoney2);
		request.setAttribute("totalMoney3", totalMoney3);
		request.setAttribute("totalMoney4", totalMoney4);
		request.setAttribute("totalMoney5", totalMoney5);
		request.setAttribute("totalMoney6", totalMoney6);
		request.setAttribute("totalMoney7", totalMoney7);

		request.setAttribute("sumAllInvoice", sumAllInvoice);
		request.setAttribute("listSellers", listSellers);
		request.setAttribute("nameShop", nameShop);

		request.getRequestDispatcher("/views/admin/DoanhThuTheoThu.jsp").forward(request, response);
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
