package ControllerSeller;

import entity.Account;
import entity.Product;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.ProductServices;
import Services.SellerServices;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.SellerServicesImpl;

@WebServlet(urlPatterns = { "/seller/manager" })
public class ProductManagerControler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		SellerServices sellerServices = new SellerServicesImpl();
		ProductServices productServices = new ProductServicesImpl();

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uID = a.getId();
		int sellID = sellerServices.getSellerByUID(uID).getSell_ID();

		String index = request.getParameter("index");
		if (index == null) {
			index = "1";
		}
		int indexPage = Integer.parseInt(index);

		int count = productServices.countAllProductBySellID(sellID);
		int endPage = count / 5;
		if (count % 5 != 0) {
			endPage++;
		}
		List<Product> listProductSellID = productServices.getProductBySellIDAndIndex(sellID, indexPage);

		request.setAttribute("listProductSellID", listProductSellID);
		request.setAttribute("endPage", endPage);
		request.setAttribute("tag", indexPage);

		request.getRequestDispatcher("/views/seller/QuanLySanPham.jsp").forward(request, response);
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
