package ControllerWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.AccountServices;
import ServicesImpl.AccountServicesImpl;
import entity.Account;
import entity.Email;
import entity.EmailUtils;

@WebServlet(urlPatterns = { "/login/verifyEmail" })
public class VerifyEmailControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/web/VerifyForm.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String code = request.getParameter("authcode");

		AccountServices accountServices = new AccountServicesImpl();
		Account account = accountServices.checkCode(code);

		if (account == null) {
			request.setAttribute("error", "Mã xác thực sai!");
		}
		if (account != null) {
			request.setAttribute("mess", "Xác thực thành công!");
		}

		request.getRequestDispatcher("/views/web/VerifyForm.jsp").forward(request, response);

	}

}
