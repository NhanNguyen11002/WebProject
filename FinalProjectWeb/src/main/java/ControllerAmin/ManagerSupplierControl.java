package ControllerAmin;

import entity.Category;
import entity.Supplier;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.CategoryServices;
import Services.SupplierServices;
import ServicesImpl.CategoryServicesImpl;
import ServicesImpl.SupplierServicesImpl;

@WebServlet(name = "ManagerSupplierControl", urlPatterns = { "/admin/managerSupplier" })
public class ManagerSupplierControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		SupplierServices supplierServices = new SupplierServicesImpl();
		CategoryServices categoryServices = new CategoryServicesImpl();

		List<Supplier> listAllSupplier = supplierServices.getAllSupplier();
		List<Category> listAllCategory = categoryServices.getAllCategory();

		request.setAttribute("listAllSupplier", listAllSupplier);
		request.setAttribute("listAllCategory", listAllCategory);

		request.getRequestDispatcher("/views/admin/NhaPhanPhoi.jsp").forward(request, response);
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
