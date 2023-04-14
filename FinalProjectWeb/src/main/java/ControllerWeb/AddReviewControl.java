package ControllerWeb;

import entity.Account;
import entity.Review;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.ReviewServices;
import ServicesImpl.ReviewServicesImpl;

@WebServlet(name = "AddReviewControl", urlPatterns = { "/ajax/addReview" })
public class AddReviewControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			response.sendRedirect("login");
			return;
		} else {
			int accountID = a.getId();
			String contentReview = request.getParameter("contentReview");
			int productID = Integer.parseInt(request.getParameter("productID"));

			ReviewServices reviewServices = new ReviewServicesImpl();
			reviewServices.insertReview(accountID, productID, contentReview);

			Review newReview = new Review();
			newReview = reviewServices.getNewReview(accountID, productID);
			PrintWriter out = response.getWriter();

			out.println("<div class=\"media mt-3 mb-4\">\r\n"
					+ "								<img  style=\"border-radius: 50%;\" class=\"d-flex mr-3 z-depth-1\"\r\n"
					+ "									src=\"https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg\"\r\n"
					+ "									width=\"62\" alt=\"Generic placeholder image\">\r\n"
					+ "								<div class=\"media-body\">\r\n"
					+ "									<div class=\"d-flex justify-content-between\">\r\n"
					+ "										<p class=\"mt-1 mb-2\">\r\n"
					+ "											<strong>" + a.getUser() + " </strong>\r\n"
					+ "											<span>– </span><span>" + newReview.getDateReview()
					+ "</span>\r\n" + "										</p>\r\n"
					+ "										\r\n"
					+ "											<a class=\"site-btn-delete\" style=\"color: white\"\r\n"
					+ "												> <i\r\n"
					+ "												class=\"fa-solid fa-trash\"></i>\r\n"
					+ "											</a>\r\n"
					+ "									</div>\r\n"
					+ "									<p style=\"text-transform: none;\" class=\"mb-0\">"
					+ newReview.getContentReview() + "</p>\r\n" + "\r\n" + "								</div>\r\n"
					+ "							</div>\r\n" + "							<hr>");

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

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
