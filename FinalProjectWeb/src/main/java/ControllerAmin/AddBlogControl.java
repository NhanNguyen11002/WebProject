package ControllerAmin;

import entity.Blog;
import entity.Category;
import entity.Product;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Services.BlogServices;
import ServicesImpl.BlogServicesImpl;
import Util.Constant;

@WebServlet(name = "AddBlogControl", urlPatterns = { "/admin/addBlog" })
public class AddBlogControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BlogServices blogServices = new BlogServicesImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/AddBlog.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Blog blog = new Blog();

		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");

		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);

			for (FileItem item : items) {
				if (item.getFieldName().equals("title")) {
					blog.setTitle(item.getString());
				} else if (item.getFieldName().equals("image")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/blog/" + fileName);
					item.write(file);
					blog.setImage("blog/" + fileName);
				} else if (item.getFieldName().equals("ct1")) {
					blog.setContent1(item.getString());
				} else if (item.getFieldName().equals("ct2")) {
					blog.setContent2(item.getString());
				} else if (item.getFieldName().equals("ct3")) {
					blog.setContent3(item.getString());
				} else if (item.getFieldName().equals("ct4")) {
					blog.setContent4(item.getString());
				}
			}

			blogServices.insertBlog(blog);

			request.setAttribute("mess", "Blog Added!");

			response.sendRedirect(request.getContextPath() + "/admin/managerBlog");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
