package ControllerWeb;

import entity.Account;
import entity.Email;
import entity.EmailUtils;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.AccountServices;
import ServicesImpl.AccountServicesImpl;

@WebServlet(name = "SignUpControl", urlPatterns = { "/signup" })
public class SignUpControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static String getRamdom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}

	@SuppressWarnings("null")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String re_pass = request.getParameter("repass");
		String emailAddress = request.getParameter("email");

		AccountServices accountServices = new AccountServicesImpl();

		if (!pass.equals(re_pass)) {
			response.sendRedirect("login");
		} else {
			Account a = accountServices.checkAccountExist(user);
			if (a == null) {
				try {
					// dc signup
					String code = getRamdom();
					accountServices.singup(user, pass, emailAddress, code);

					Email email = new Email();
					email.setFrom("20110754@student.hcmute.edu.vn");
					email.setFromPassword("huutrong110102");
					email.setTo(emailAddress);
					email.setSubject("User Email Verification");
					StringBuilder sb = new StringBuilder();
					sb.append("Đăng kí thành công tài khoản. <br> ");
					sb.append("Mã xác nhận của bạn là:  <b>").append(code).append(" </b> <br>");
					email.setContent(sb.toString());
					EmailUtils.send(email);

				} catch (Exception e) {
					// TODO: handle exception
				}
				response.sendRedirect(request.getContextPath() + "/login/verifyEmail");
			} else {
				// day ve trang login.jsp;
				response.sendRedirect("login");
			}

		}

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
