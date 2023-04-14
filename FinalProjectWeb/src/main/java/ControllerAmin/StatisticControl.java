package ControllerAmin;

import entity.Account;
import entity.Invoice;
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
import Services.ProductServices;
import Services.ReviewServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.ReviewServicesImpl;

@WebServlet(name = "StatisticControl", urlPatterns = { "/admin" })
public class StatisticControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uID;

		AccountServices accountServices = new AccountServicesImpl();
		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		ReviewServices reviewServices = new ReviewServicesImpl();
		ProductServices productServices = new ProductServicesImpl();

		if (a == null) {
			response.sendRedirect("login");
			return;
		}
		uID = a.getId();
		int checkIsAdmin = accountServices.checkAccountAdmin(uID);
		if (checkIsAdmin == 0) {
			response.sendRedirect("login");
			return;
		}

		double totalMoney1 = invoiceServices.totalMoneyDay(1);
		double totalMoney2 = invoiceServices.totalMoneyDay(2);
		double totalMoney3 = invoiceServices.totalMoneyDay(3);
		double totalMoney4 = invoiceServices.totalMoneyDay(4);
		double totalMoney5 = invoiceServices.totalMoneyDay(5);
		double totalMoney6 = invoiceServices.totalMoneyDay(6);
		double totalMoney7 = invoiceServices.totalMoneyDay(7);

		double totalMoneyMonth1 = invoiceServices.totalMoneyMonth(1);
		double totalMoneyMonth2 = invoiceServices.totalMoneyMonth(2);
		double totalMoneyMonth3 = invoiceServices.totalMoneyMonth(3);
		double totalMoneyMonth4 = invoiceServices.totalMoneyMonth(4);
		double totalMoneyMonth5 = invoiceServices.totalMoneyMonth(5);
		double totalMoneyMonth6 = invoiceServices.totalMoneyMonth(6);
		double totalMoneyMonth7 = invoiceServices.totalMoneyMonth(7);
		double totalMoneyMonth8 = invoiceServices.totalMoneyMonth(8);
		double totalMoneyMonth9 = invoiceServices.totalMoneyMonth(9);
		double totalMoneyMonth10 = invoiceServices.totalMoneyMonth(10);
		double totalMoneyMonth11 = invoiceServices.totalMoneyMonth(11);
		double totalMoneyMonth12 = invoiceServices.totalMoneyMonth(12);

		int allReview = reviewServices.countAllReview();
		int allProduct = productServices.countAllProduct();
		double sumAllInvoice = invoiceServices.sumAllInvoice();

		List<Invoice> listAllInvoice = invoiceServices.getAllInvoice();
		List<Account> listAllAccount = accountServices.getAllAccount();

		request.setAttribute("listAllInvoice", listAllInvoice);
		request.setAttribute("listAllAccount", listAllAccount);
		request.setAttribute("sumAllInvoice", sumAllInvoice);

		request.setAttribute("allReview", allReview);
		request.setAttribute("allProduct", allProduct);

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

		request.getRequestDispatcher("/views/admin/Statistic.jsp").forward(request, response);

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
