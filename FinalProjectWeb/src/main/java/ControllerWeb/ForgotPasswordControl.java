package ControllerWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.AccountServices;
import ServicesImpl.AccountServicesImpl;
import entity.Account;
import entity.Email;
import entity.EmailUtils;

@WebServlet(name = "ForgotPasswordControl", urlPatterns = { "/login/forgotPassword" })
public class ForgotPasswordControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/web/forgot-password.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String emailAddress = request.getParameter("email");
		String username = request.getParameter("username");

		AccountServices accountServices = new AccountServicesImpl();
		Account account = accountServices.checkAccountExistByUsernameAndEmail(username, emailAddress);
		// TODO Auto-generated method stub
		try {
			if (account == null) {
				request.setAttribute("error", "Email hoặc username sai!");
			}
			if (account != null) {
				Email email = new Email();
				email.setFrom("20110754@student.hcmute.edu.vn");
				email.setFromPassword("huutrong110102");
				email.setTo(emailAddress);
				email.setSubject("Forgot Password Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br>");
				sb.append("You are used the forgot password. <br> ");
				sb.append("Your password is <b>").append(account.getPass()).append(" </b> <br>");
				sb.append("Regards<br>");
				sb.append("Administrator");

				email.setContent(sb.toString());
				EmailUtils.send(email);

				request.setAttribute("mess", "Mật khẩu mới đã được gửi đến email của bạn!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/views/web/forgot-password.jsp").forward(request, response);
	}

}
