package ControllerAmin;

import entity.Account;
import entity.Blog;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.AccountServices;
import Services.BlogServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.BlogServicesImpl;

@WebServlet(name = "ManagerAccountControl", urlPatterns = { "/admin/managerAccount" })
public class ManagerAccountControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		AccountServices accountServices = new AccountServicesImpl();

		List<Account> list = accountServices.getAllAccount();

		request.setAttribute("listA", list);
		request.getRequestDispatcher("/views/admin/QuanLyTaiKhoan.jsp").forward(request, response);
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
