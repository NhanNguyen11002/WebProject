package ControllerWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.BlogReviewServices;
import ServicesImpl.BlogReviewServiesImpl;
import entity.Account;
import entity.ReviewBlog;

@WebServlet(urlPatterns = { "/ajax/addBlogReview" })
public class BlogReviewControl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			/* response.sendRedirect("login"); */
			request.setAttribute("error", "Đăng nhập để có thể để lại bình luận!");
			return;
		} else {
			int accountID = a.getId();
			String contentReview = request.getParameter("contentReview");
			int blogID = Integer.parseInt(request.getParameter("blogID"));

			BlogReviewServices reviewServices = new BlogReviewServiesImpl();
			reviewServices.insertReview(accountID, blogID, contentReview);

			ReviewBlog newReview = new ReviewBlog();
			newReview = reviewServices.getNewReview(accountID, blogID);
			PrintWriter out = response.getWriter();

			out.println("<div class=\"media mt-3 mb-4\">\r\n"
					+ "								<img class=\"d-flex mr-3 z-depth-1\"\r\n"
					+ "												src=\"https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg\"\r\n"
					+ "												width=\"62\" height=\"62\" style=\"border-radius: 50%\"\r\n"
					+ "												alt=\"Generic placeholder image\">"
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
