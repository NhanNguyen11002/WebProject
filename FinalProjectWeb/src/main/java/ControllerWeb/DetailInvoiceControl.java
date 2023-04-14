package ControllerWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOImpl.InvoiceStatusDAOImpl;
import Services.InvoiceDetailServices;
import Services.InvoiceServices;
import Services.InvoiceShopDetailServices;
import Services.InvoiceShopServices;
import Services.ProductServices;
import ServicesImpl.InvoiceDetailServicesImpl;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.InvoiceShopDetailServicesImpl;
import ServicesImpl.InvoiceShopServicesImpl;
import ServicesImpl.ProductServicesImpl;
import entity.Invoice;
import entity.InvoiceDetail;
import entity.InvoiceShop;
import entity.InvoiceShopDetail;
import entity.InvoiceStatus;
import entity.Product;

@WebServlet(urlPatterns = { "/ajax/detailInvoice" })
public class DetailInvoiceControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));

		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		InvoiceShopDetailServices invoiceShopDetailServices = new InvoiceShopDetailServicesImpl();
		InvoiceStatusDAOImpl invoiceStatusDAOImpl = new InvoiceStatusDAOImpl();
		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		ProductServices productServices = new ProductServicesImpl();

		List<InvoiceShop> listShops = invoiceShopServices.getAllInvoiceShopByOrderID(invoiceId);
		Invoice invoice = invoiceServices.getInvoiceBymaHD(invoiceId);

		PrintWriter out = response.getWriter();

		out.println("<div style=\"position: absolute; bottom: -130px;\">\r\n" + "							<p>Tên: "
				+ invoice.getName() + "</p>\r\n" + "							<p>Email: " + invoice.getEmail()
				+ "</p>\r\n" + "							<p>SĐT: " + invoice.getPhone() + "</p>\r\n"
				+ "							<p>Địa chỉ: " + invoice.getDeliveryAddress() + "</p>\r\n"
				+ "						</div>");

		for (InvoiceShop o : listShops) {
			InvoiceShopDetail invoiceShopDetail = invoiceShopDetailServices.getInvoiceShopDetailsByOrderId(o.getMaHD());
			String status = invoiceStatusDAOImpl.getOne(o.getStatus()).getName();
			Product product = productServices.getProductByID(invoiceShopDetail.getProId());
			out.println("	<tr>\r\n" + "	<th scope=\"row\" style=\"font-size: 15px;\">" + invoiceShopDetail.getId()
					+ "</th>\r\n" + "	<td style=\"font-size: 15px;\"><a style=\"color: black;\" href=\"detail?pid="
					+ invoiceShopDetail.getProId() + "\">" + product.getName() + "</a></td>\r\n"
					+ "	<td><a href=\"detail?pid=" + invoiceShopDetail.getProId() + "\"><img src=\""
					+ product.getImage() + "\"\r\n" + "			width=\"150px\" heigh=\"150px\" /></a></td>\r\n"
					+ "	<td style=\"font-size: 15px;\">" + invoiceShopDetail.getProQuantity() + "</td>\r\n"
					+ "	<td style=\"font-size: 15px\">" + invoiceShopDetail.getProSize() + "</td>\r\n"
					+ "	<td style=\"font-size: 15px;\">" + status + "</td>\r\n" + "</tr>");
		}

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
