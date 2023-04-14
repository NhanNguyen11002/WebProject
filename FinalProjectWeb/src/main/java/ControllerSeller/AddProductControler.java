package ControllerSeller;

import entity.Account;
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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Services.CategoryServices;
import Services.ProductServices;
import Services.SellerServices;
import ServicesImpl.CategoryServicesImpl;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.SellerServicesImpl;
import Util.Constant;

@WebServlet(urlPatterns = { "/seller/add" })
public class AddProductControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductServices productServices = new ProductServicesImpl();
	CategoryServices categoryServices = new CategoryServicesImpl();
	SellerServices sellerServices = new SellerServicesImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCC = categoryServices.getAllCategory();
		request.setAttribute("listCC", listCC);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/seller/AddProduct.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Product();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uID = a.getId();
		int sellID = sellerServices.getSellerByUID(uID).getSell_ID();

		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);

			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					product.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("image")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/product/" + fileName);
					item.write(file);
					product.setImage("product/" + fileName);
				} else if (item.getFieldName().equals("image2")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/product/" + fileName);
					item.write(file);
					product.setImage2("product/" + fileName);
				} else if (item.getFieldName().equals("image3")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/product/" + fileName);
					item.write(file);
					product.setImage3("product/" + fileName);
				} else if (item.getFieldName().equals("image4")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/product/" + fileName);
					item.write(file);
					product.setImage4("product/" + fileName);
				} else if (item.getFieldName().equals("price")) {
					product.setPrice(Double.parseDouble(item.getString()));
				} else if (item.getFieldName().equals("title")) {
					product.setTitle(item.getString());
				} else if (item.getFieldName().equals("model")) {
					product.setModel(item.getString());
				} else if (item.getFieldName().equals("color")) {
					product.setColor(item.getString());
				} else if (item.getFieldName().equals("delivery")) {
					product.setDelivery(item.getString());
				} else if (item.getFieldName().equals("description")) {
					product.setDescription(item.getString());
				} else if (item.getFieldName().equals("category")) {
					product.setCateID(Integer.parseInt(item.getString()));
				}
			}

			productServices.insertProductBySellID(product, sellID);

			request.setAttribute("mess", "Product Added!");

			response.sendRedirect(request.getContextPath() + "/seller/manager");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
