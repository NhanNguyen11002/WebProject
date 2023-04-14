package ControllerAmin;

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
import org.apache.http.auth.NTCredentials;

import Services.ProductServices;
import Services.RequestServices;
import Services.SellerServices;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.RequestServicesImpl;
import ServicesImpl.SellerServicesImpl;
import entity.Category;
import entity.Product;
import entity.Request;
import entity.Seller;

@WebServlet(urlPatterns = { "/admin/sendRequest" })
public class SendRequestControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ProductServices productServices = new ProductServicesImpl();
	RequestServices requestServices = new RequestServicesImpl();
	SellerServices sellerServices = new SellerServicesImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		ProductServices productServices = new ProductServicesImpl();

		int pID = Integer.parseInt(request.getParameter("pid"));

		Product itemProduct = productServices.getProductByID(pID);

		request.setAttribute("itemProduct", itemProduct);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/SendRequest.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Request itemRequest = new Request();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");

		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);

			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					int pID = Integer.parseInt(item.getString());
					int sID = productServices.getSellIDByProductID(pID);
					itemRequest.setId(pID);
					itemRequest.setSellID(sID);
				} else if (item.getFieldName().equals("content")) {
					itemRequest.setContent(item.getString("UTF-8"));
				}
			}
			requestServices.insertRequest(itemRequest.getSellID(), itemRequest.getId(), itemRequest.getContent(), 1);
			
			String nameShop = "---Chọn---";

			List<Seller> listSellers = sellerServices.getAllSeller();

			request.setAttribute("mess", "Gửi yêu cầu thành công!");
			request.setAttribute("listSellers", listSellers);
			request.setAttribute("nameShop", nameShop);

			request.getRequestDispatcher("/views/admin/QuanLySanPham.jsp").forward(request, response);

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
