package ControllerAmin;

import entity.Product;
import entity.SoLuongDaBan;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ProductServices;
import Services.SoLuongDaBanServices;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.SoLuongDaBanServicesImpl;

@WebServlet(name = "Top10SanPhamControl", urlPatterns = { "/admin/top10" })
public class Top10SanPhamControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		ProductServices productServices = new ProductServicesImpl();
		SoLuongDaBanServices soLuongDaBanServices = new SoLuongDaBanServicesImpl();

		List<Product> listAllProduct = productServices.getAllProduct();
		List<SoLuongDaBan> listTop10Product = soLuongDaBanServices.getTop10SanPhamBanChay();

		request.setAttribute("listAllProduct", listAllProduct);
		request.setAttribute("listTop10Product", listTop10Product);

		request.getRequestDispatcher("/views/admin/Top10SanPhamBanChay.jsp").forward(request, response);
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
