package ControllerWeb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ReviewServices;
import ServicesImpl.ReviewServicesImpl;

@WebServlet(urlPatterns = { "/deleteReview" })
public class DeleteReview extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String mid = request.getParameter("mid");

		ReviewServices reviewServices = new ReviewServicesImpl();

		reviewServices.deleteReview(mid);
		request.setAttribute("mess", "Đã xóa bình luận thành công!!");
		response.sendRedirect("shop?cid=0");
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
