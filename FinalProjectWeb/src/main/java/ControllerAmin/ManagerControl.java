package ControllerAmin;

import entity.Product;
import entity.Seller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ProductServices;
import Services.SellerServices;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.SellerServicesImpl;

@WebServlet(name = "ManagerControl", urlPatterns = { "/admin/manager" })
public class ManagerControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String index = request.getParameter("index");

		String nameShop = "---Chọn---";

		if (index == null) {
			index = "1";
		}

		int indexPage = Integer.parseInt(index);

		int sID = Integer.parseInt(request.getParameter("sID"));

		ProductServices productServices = new ProductServicesImpl();
		SellerServices sellerServices = new SellerServicesImpl();

		int endPage = 1;
		List<Product> listAll = null;

		if (sID != -1) {
			int count = productServices.countAllProductBySellID(sID);
			endPage = count / 6;

			if (count % 6 != 0) {
				endPage++;
			}

			listAll = productServices.pagingProductBySellerID(indexPage, sID);
			nameShop = sellerServices.getSellerBySellID(sID).getName_Shop();

		}

		List<Seller> listSellers = sellerServices.getAllSeller();

		request.setAttribute("tag", indexPage);
		request.setAttribute("sellIndex", sID);
		request.setAttribute("listSellers", listSellers);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listAll", listAll);
		request.setAttribute("nameShop", nameShop);

		request.getRequestDispatcher("/views/admin/QuanLySanPham.jsp").forward(request, response);
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
