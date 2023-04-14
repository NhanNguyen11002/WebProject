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

@WebServlet(name = "DoanhThuTheoThangControl", urlPatterns = { "/admin/doanhThuTheoThang" })
public class DoanhThuTheoThangControl extends HttpServlet {

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

		double totalMoneyMonth1 = 0;
		double totalMoneyMonth2 = 0;
		double totalMoneyMonth3 = 0;
		double totalMoneyMonth4 = 0;
		double totalMoneyMonth5 = 0;
		double totalMoneyMonth6 = 0;
		double totalMoneyMonth7 = 0;
		double totalMoneyMonth8 = 0;
		double totalMoneyMonth9 = 0;
		double totalMoneyMonth10 = 0;
		double totalMoneyMonth11 = 0;
		double totalMoneyMonth12 = 0;

		if (sID != -1) {
			totalMoneyMonth1 = invoiceShopServices.totalMoneyMonth(1, sID);
			totalMoneyMonth2 = invoiceShopServices.totalMoneyMonth(2, sID);
			totalMoneyMonth3 = invoiceShopServices.totalMoneyMonth(3, sID);
			totalMoneyMonth4 = invoiceShopServices.totalMoneyMonth(4, sID);
			totalMoneyMonth5 = invoiceShopServices.totalMoneyMonth(5, sID);
			totalMoneyMonth6 = invoiceShopServices.totalMoneyMonth(6, sID);
			totalMoneyMonth7 = invoiceShopServices.totalMoneyMonth(7, sID);
			totalMoneyMonth8 = invoiceShopServices.totalMoneyMonth(8, sID);
			totalMoneyMonth9 = invoiceShopServices.totalMoneyMonth(9, sID);
			totalMoneyMonth10 = invoiceShopServices.totalMoneyMonth(10, sID);
			totalMoneyMonth11 = invoiceShopServices.totalMoneyMonth(11, sID);
			totalMoneyMonth12 = invoiceShopServices.totalMoneyMonth(12, sID);

			nameShop = sellerServices.getSellerBySellID(sID).getName_Shop();
		}

		double sumAllInvoice = invoiceServices.sumAllInvoice();

		List<Seller> listSellers = sellerServices.getAllSeller();

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
		request.setAttribute("listSellers", listSellers);
		request.setAttribute("nameShop", nameShop);

		request.getRequestDispatcher("/views/admin/DoanhThuTheoThang.jsp").forward(request, response);
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
