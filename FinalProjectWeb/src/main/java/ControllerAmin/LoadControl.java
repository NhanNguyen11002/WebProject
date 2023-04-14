package ControllerAmin;

import entity.Category;
import entity.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.CategoryServices;
import Services.ProductServices;
import ServicesImpl.CategoryServicesImpl;
import ServicesImpl.ProductServicesImpl;

@WebServlet(name = "LoadControl", urlPatterns = { "/admin/loadProduct" })
public class LoadControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("pid");

		ProductServices productServices = new ProductServicesImpl();
		CategoryServices categoryServices = new CategoryServicesImpl();

		Product p = productServices.getProductByID(id);
		List<Category> listC = categoryServices.getAllCategory();

		request.setAttribute("detail", p);
		request.setAttribute("listCC", listC);
		request.getRequestDispatcher("/views/admin/Edit.jsp").forward(request, response);
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
