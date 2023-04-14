package ControllerAmin;

import entity.Product;
import entity.Seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
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

@WebServlet(name = "SearchProduct", urlPatterns = { "/admin/search" })
public class SearchProduct extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		request.setCharacterEncoding("UTF-8");

		ProductServices productServices = new ProductServicesImpl();
		SellerServices sellerServices = new SellerServicesImpl();

		String nameShop = "---Chọn---";

		String txtSearch = request.getParameter("txt");

		String index = request.getParameter("index");

		if (index == null) {
			index = "1";
		}

		int indexPage = Integer.parseInt(index);

		int endPage = 1;

		List<Product> listAll = null;

		int count = productServices.countSearch(txtSearch);
		endPage = count / 6;

		if (count % 6 != 0) {
			endPage++;
		}

		listAll = productServices.pagingSearch(txtSearch, indexPage);

		List<Seller> listSellers = sellerServices.getAllSeller();

		request.setAttribute("listSellers", listSellers);
		request.setAttribute("tag", indexPage);
		request.setAttribute("listAll", listAll);
		request.setAttribute("nameShop", nameShop);
		request.setAttribute("endPage", endPage);
		request.setAttribute("txtS", txtSearch);

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
	}// </editor-fold>

}
