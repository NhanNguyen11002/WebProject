package ControllerAmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.CartServices;
import Services.ProductServices;
import Services.ReviewServices;
import ServicesImpl.CartServicesImpl;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.ReviewServicesImpl;

@WebServlet(name = "DeleteControl", urlPatterns = { "/admin/delete" })
public class DeleteControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String pid = request.getParameter("pid");

		CartServices cartServices = new CartServicesImpl();
		ReviewServices reviewServices = new ReviewServicesImpl();
		ProductServices productServices = new ProductServicesImpl();

		cartServices.deleteCartByProductID(pid);
		reviewServices.deleteReviewByProductID(pid);
		productServices.deleteProduct(pid);

		request.setAttribute("mess", "Deleted!");
		request.getRequestDispatcher("manager").forward(request, response);
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
