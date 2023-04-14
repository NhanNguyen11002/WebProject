package ControllerWeb;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Services.AccountServices;
import ServicesImpl.AccountServicesImpl;
import Util.Constant;
import entity.Account;
import entity.UserGoogleDto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;

@WebServlet(urlPatterns = { "/LoginGoogleHandler" })
public class LoginGoogleHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String accessToken = getToken(code);
		UserGoogleDto user = getUserInfo(accessToken);

		AccountServices accountServices = new AccountServicesImpl();
		accountServices.loginGoogle(user.getFamily_name(), "123456", user.getEmail(), user.getPicture());
		System.out.println(user);

		response.sendRedirect("home");
	}

	public static String getToken(String code) throws ClientProtocolException, IOException {
		// call api to get token
		String response = Request.Post(Constant.GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id", Constant.GOOGLE_CLIENT_ID)
						.add("client_secret", Constant.GOOGLE_CLIENT_SECRET)
						.add("redirect_uri", Constant.GOOGLE_REDIRECT_URI).add("code", code)
						.add("grant_type", Constant.GOOGLE_GRANT_TYPE).build())
				.execute().returnContent().asString();

		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}

	public static UserGoogleDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = Constant.GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();

		UserGoogleDto googlePojo = new Gson().fromJson(response, UserGoogleDto.class);

		return googlePojo;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String code = request.getParameter("code");
		String accessToken = getToken(code);
		UserGoogleDto user = getUserInfo(accessToken);

		String username = user.getFamily_name();
		String password = "123456";

		AccountServices accountServices = new AccountServicesImpl();
		Account accountExist = accountServices.checkAccountExist(username);

		if (accountExist == null) {
			accountServices.loginGoogle(username, password, user.getEmail(), user.getPicture());
		}

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

			p.setMaxAge(60 * 60 * 24);

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}