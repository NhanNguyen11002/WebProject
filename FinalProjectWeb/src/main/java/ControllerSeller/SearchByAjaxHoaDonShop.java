package ControllerSeller;

import entity.Account;
import entity.Invoice;
import entity.InvoiceShop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOImpl.InvoiceStatusDAOImpl;
import Services.AccountServices;
import Services.InvoiceServices;
import Services.InvoiceShopServices;
import Services.SellerServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.InvoiceShopServicesImpl;
import ServicesImpl.SellerServicesImpl;

@WebServlet(urlPatterns = { "/ajax/searchAjaxHoaDonShop" })
public class SearchByAjaxHoaDonShop extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		AccountServices accountServices = new AccountServicesImpl();
		InvoiceStatusDAOImpl invoiceStatus = new InvoiceStatusDAOImpl();
		SellerServices sellerServices = new SellerServicesImpl();

		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");
		int uID = acc.getId();
		int sellID = sellerServices.getSellerByUID(uID).getSell_ID();
		String ngayXuat = request.getParameter("ngayXuat");

		List<InvoiceShop> listInvoiceByDate = invoiceShopServices.searchByNgayXuatBySellID(ngayXuat, sellID);
		List<Account> listAllAccount = accountServices.getAllAccount();
		PrintWriter out = response.getWriter();
		double tongGia;

		for (InvoiceShop o : listInvoiceByDate) {
			for (Account a : listAllAccount) {
				if (o.getAccountID() == a.getId()) {

					tongGia = Math.round((o.getTongGia()) * 100.0) / 100.0;
					out.println("<tr>\r\n" + "										<th scope=\"row\"></th>\r\n"
							+ "										<td>" + o.getMaHD() + "</td>\r\n"
							+ "										<td>" + a.getUser() + "</td>\r\n"
							+ "										<td>" + tongGia + "</td>\r\n"
							+ "										<td>" + o.getNgayXuat() + "</td>\r\n"
							+ "										<td>"
							+ invoiceStatus.getOne(o.getStatus()).getName() + "</td>\r\n"
							+ "										<td><button onclick=\"invoiceDetailSeller("
							+ o.getMaHD() + ")\"\r\n"
							+ "												data-toggle=\"modal\" data-target=\"#exampleModalCenter\">Xem\r\n"
							+ "												chi tiết</button></td>\r\n"
							+ "									</tr>");
				}
			}
		}

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
