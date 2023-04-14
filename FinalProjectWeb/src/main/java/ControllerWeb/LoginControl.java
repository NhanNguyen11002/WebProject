package ControllerWeb;

import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.AccountServices;
import ServicesImpl.AccountServicesImpl;

@WebServlet(name = "LoginControl", urlPatterns = { "/login" })
public class LoginControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// b1 get user,pass from cookie
		Cookie arr[] = request.getCookies();
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("userC")) {
					request.setAttribute("username", o.getValue());
				}
				if (o.getName().equals("passC")) {
					request.setAttribute("password", o.getValue());
				}
			}
		}
		// b2: set user,pass to login form
		request.getRequestDispatcher("/views/web/Login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String remember = request.getParameter("remember");

		AccountServices accountServices = new AccountServicesImpl();
		Account a = accountServices.login(username, password);

		if (a == null) {
			request.setAttribute("error", "Sai username hoặc password!");
			request.getRequestDispatcher("/views/web/Login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("acc", a);
			session.setMaxInactiveInterval(60 * 60 * 24);
			// luu account len tren cookie
			Cookie u = new Cookie("userC", username);
			Cookie p = new Cookie("passC", password);
			if (remember != null) {
				p.setMaxAge(60 * 60 * 24);
			} else {
				p.setMaxAge(0);
			}

			u.setMaxAge(60 * 60 * 24 * 365);// 1 nam

			response.addCookie(u);// luu u va p len Chrome
			response.addCookie(p);

			if (a.getIsAdmin() == 1) {
				response.sendRedirect("admin");
			} else if (a.getIsShipper() == 1) {
				response.sendRedirect("shipper");
			} else {
				response.sendRedirect("home");
			}
		}
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
