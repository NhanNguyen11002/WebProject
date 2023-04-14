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

import Services.AccountServices;
import Services.InvoiceServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.InvoiceServicesImpl;

@WebServlet(name = "HoaDonControl", urlPatterns = { "/admin/hoaDon" })
public class HoaDonControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		AccountServices accountServices = new AccountServicesImpl();

		double sumAllInvoice = invoiceServices.sumAllInvoice();

		List<Invoice> listAllInvoice = invoiceServices.getAllInvoice();
		List<Account> listAllAccount = accountServices.getAllAccount();

		request.setAttribute("listAllInvoice", listAllInvoice);
		request.setAttribute("listAllAccount", listAllAccount);
		request.setAttribute("sumAllInvoice", sumAllInvoice);

		request.getRequestDispatcher("/views/admin/HoaDon.jsp").forward(request, response);
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
