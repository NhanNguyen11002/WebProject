package ControllerAmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.BlogServices;
import Services.SupplierServices;
import ServicesImpl.BlogServicesImpl;
import ServicesImpl.SupplierServicesImpl;

@WebServlet(name = "DeleteBlogControl", urlPatterns = { "/admin/deleteBlog" })
public class DeleteBlogControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String idBlog = request.getParameter("id");
		BlogServices blogServices = new BlogServicesImpl();
		blogServices.deleteBlog(idBlog);
		request.setAttribute("mess", "Blog Deleted!");
		request.getRequestDispatcher("managerBlog").forward(request, response);
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
