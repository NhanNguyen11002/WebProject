package ControllerWeb;

import entity.Account;
import entity.Cart;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.CartServices;
import Services.ProductServices;
import ServicesImpl.CartServicesImpl;
import ServicesImpl.ProductServicesImpl;

@WebServlet(name = "TotalMoneyCartControl", urlPatterns = { "/ajax/totalMoneyCart" })
public class TotalMoneyCartControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int accountID = a.getId();

		CartServices cartServices = new CartServicesImpl();
		ProductServices productServices = new ProductServicesImpl();

		List<Cart> list = cartServices.getCartByAccountID(accountID);
		List<Product> list2 = productServices.getAllProduct();

		double totalMoney = 0;
		for (Cart o : list) {
			for (Product p : list2) {
				if (o.getProductID() == p.getId()) {
					totalMoney = totalMoney + p.getPrice() * o.getAmount();
				}
			}
		}

		NumberFormat currentLocale = NumberFormat.getInstance();
		String totalMoneyFormat = currentLocale.format(totalMoney);

		PrintWriter out = response.getWriter();
		out.println("<li class=\"d-flex justify-content-between py-3 border-bottom\"><strong\r\n"
				+ "									class=\"text-muted\">Tổng tiền hàng</strong><strong>"
				+ totalMoneyFormat + "\r\n" + "										VNĐ</strong></li>\r\n"
				+ "								<li class=\"d-flex justify-content-between py-3 border-bottom\"><strong\r\n"
				+ "									class=\"text-muted\">Phí vận chuyển</strong><strong>Free\r\n"
				+ "										ship</strong></li>\r\n"
				+ "								<li class=\"d-flex justify-content-between py-3 border-bottom\"><strong\r\n"
				+ "									class=\"text-muted\">Tổng thanh toán</strong>\r\n"
				+ "									<h5 class=\"font-weight-bold\">" + totalMoneyFormat
				+ " VNĐ</h5></li>");

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
