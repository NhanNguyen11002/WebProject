package ControllerWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.CartServices;
import ServicesImpl.CartServicesImpl;

@WebServlet(name = "DeleteCartControl", urlPatterns = { "/deleteCart" })
public class DeleteCartControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int productID = Integer.parseInt(request.getParameter("productID"));
		String size = request.getParameter("size");

		CartServices cartServices = new CartServicesImpl();

		cartServices.deleteCart(productID,size);
		
		request.setAttribute("mess", "Đã xóa sản phẩm khỏi giỏ hàng!!");
		request.getRequestDispatcher("managerCart").forward(request, response);
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
	}// </editor-fold>

}
