package ControllerWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.InvoiceShopDetailServices;
import Services.InvoiceShopServices;
import Services.ProductServices;
import ServicesImpl.InvoiceShopDetailServicesImpl;
import ServicesImpl.InvoiceShopServicesImpl;
import ServicesImpl.ProductServicesImpl;
import entity.InvoiceShop;
import entity.InvoiceShopDetail;
import entity.Product;

@WebServlet(urlPatterns = { "/ajax/detailShopInvoice" })
public class DetailInvoiceShopAjax extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));

		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		InvoiceShopDetailServices invoiceShopDetailServices = new InvoiceShopDetailServicesImpl();
		ProductServices productServices = new ProductServicesImpl();

		List<InvoiceShopDetail> list = invoiceShopDetailServices.getAllInvoiceShopDetailsByOrderId(invoiceId);
		InvoiceShop invoice = invoiceShopServices.getInvoiceShopBymaHD(invoiceId);

		PrintWriter out = response.getWriter();

		out.println("<div style=\"position: absolute; bottom: -130px;\">\r\n" + "							<p>Tên: "
				+ invoice.getName() + "</p>\r\n" + "							<p>Email: " + invoice.getEmail()
				+ "</p>\r\n" + "							<p>SĐT: " + invoice.getPhone() + "</p>\r\n"
				+ "							<p>Địa chỉ: " + invoice.getDeliveryAddress() + "</p>\r\n"
				+ "						</div>");

		for (InvoiceShopDetail o : list) {
			Product product = productServices.getProductByID(o.getProId());
			out.println("<tr>\r\n" + "				<th scope=\"row\" style=\"font-size: 15px;\">" + o.getId()
					+ "</th>\r\n" + "				<td style=\"font-size: 15px;\">" + product.getName() + "</td>\r\n"
					+ "				<td><img src=\"" + product.getImage() + "\"\r\n"
					+ "					width=\"150px\" heigh=\"150\" /></td>\r\n"
					+ "				<td style=\"font-size: 15px;\">" + o.getProQuantity() + "</td>\r\n"
					+ "				<td style=\"font-size: 15px;\">" + o.getProSize() + "</td>\r\n" + "			</tr>");
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

	public static void main(String[] args) {
		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		InvoiceShopDetailServices invoiceShopDetailServices = new InvoiceShopDetailServicesImpl();
		List<InvoiceShopDetail> list = invoiceShopDetailServices.getAllInvoiceShopDetailsByOrderId(40);
		InvoiceShop invoice = invoiceShopServices.getInvoiceShopBymaHD(40);
		System.out.println(list);
	}

}
