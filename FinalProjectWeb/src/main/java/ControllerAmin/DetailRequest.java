package ControllerAmin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ProductServices;
import Services.RequestServices;
import Services.SellerServices;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.RequestServicesImpl;
import ServicesImpl.SellerServicesImpl;
import entity.Product;
import entity.Request;

@WebServlet(urlPatterns = { "/ajax/detailRequest" })
public class DetailRequest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		int requestID = Integer.parseInt(request.getParameter("requestID"));

		ProductServices productServices = new ProductServicesImpl();
		SellerServices sellerServices = new SellerServicesImpl();
		RequestServices requestServices = new RequestServicesImpl();

		Request itemRequest = requestServices.getRequestByID(requestID);

		PrintWriter out = response.getWriter();

		Product product = productServices.getProductByID(itemRequest.getProID());
		String nameShop = sellerServices.getSellerBySellID(itemRequest.getSellID()).getName_Shop();

		String status = "";

		if (itemRequest.getStatus() == 1) {
			status = "Chưa xử lí";
		} else {
			status = "Đã xử lí";
		}

		out.println("<tr>\r\n" + "	<th scope=\"row\" style=\"font-size: 15px;\">" + itemRequest.getId() + "</th>\r\n"
				+ "	<td style=\"font-size: 15px;\">" + nameShop + "</td>\r\n" + "	<td style=\"font-size: 15px;\">"
				+ product.getName() + "</td>\r\n" + "	<td><img src=\"" + product.getImage()
				+ "\" width=\"150px\" heigh=\"150\" /></td>\r\n" + "	<td style=\"font-size: 15px;\">"
				+ itemRequest.getContent() + "</td>\r\n" + "	<td style=\"font-size: 15px;\">" + status + "</td>\r\n"
				+ "</tr>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

}
