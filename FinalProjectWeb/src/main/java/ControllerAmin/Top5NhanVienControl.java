package ControllerAmin;

import entity.Account;
import entity.Seller;
import entity.TongChiTieuBanHang;
import entity.TongChiTieuShop;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.AccountServices;
import Services.SellerServices;
import Services.TongChiTieuBanHangServices;
import Services.TongChiTieuShopServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.SellerServicesImpl;
import ServicesImpl.TongChiTieuBanHangServicesImpl;
import ServicesImpl.TongChiTieuShopServicesImpl;

@WebServlet(name = "Top5NhanVienControl", urlPatterns = { "/admin/top5nhanvien" })
public class Top5NhanVienControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		SellerServices sellerServices = new SellerServicesImpl();
		TongChiTieuShopServices tongChiTieuShopServices = new TongChiTieuShopServicesImpl();

		List<Seller> listSeller = sellerServices.getAllSeller();
		List<TongChiTieuShop> listTop5NhanVien = tongChiTieuShopServices.getTop5Shop();

		request.setAttribute("listSeller", listSeller);
		request.setAttribute("listTop5NhanVien", listTop5NhanVien);

		request.getRequestDispatcher("/views/admin/Top5NhanVien.jsp").forward(request, response);
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
