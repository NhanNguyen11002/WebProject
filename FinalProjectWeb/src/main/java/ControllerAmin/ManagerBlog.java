package ControllerAmin;

import entity.Account;
import entity.Blog;
import entity.Category;
import entity.Product;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.AccountServices;
import Services.BlogServices;
import Services.CategoryServices;
import Services.ProductServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.BlogServicesImpl;
import ServicesImpl.CategoryServicesImpl;
import ServicesImpl.ProductServicesImpl;

@WebServlet(name = "ManagerBlog", urlPatterns = { "/admin/managerBlog" })
public class ManagerBlog extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		BlogServices blogServices = new BlogServicesImpl();

		List<Blog> list = blogServices.getAllBlog();

		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/admin/QuanLyBaiViet.jsp").forward(request, response);
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
