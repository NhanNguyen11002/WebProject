package ControllerAmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.AccountServices;
import ServicesImpl.AccountServicesImpl;

@WebServlet(name = "AddAccountControl", urlPatterns = { "/admin/addAccount" })
public class AddAccountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String isSell = request.getParameter("isSell");
		String isAdmin = request.getParameter("isAdmin");
		String isShipper = request.getParameter("isShipper");
		String email = request.getParameter("email");

		AccountServices accountServices = new AccountServicesImpl();
		accountServices.insertAccount(user, pass, isSell, isAdmin, isShipper, email);
		request.setAttribute("mess", "Account Added!");

		request.getRequestDispatcher("managerAccount").forward(request, response);
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
}
