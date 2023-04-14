package ControllerAmin;

import entity.Account;
import entity.TongChiTieuBanHang;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.AccountServices;
import Services.TongChiTieuBanHangServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.TongChiTieuBanHangServicesImpl;

@WebServlet(name = "Top5KhachHangControl", urlPatterns = { "/admin/top5khachhang" })
public class Top5KhachHangControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		AccountServices accountServices = new AccountServicesImpl();
		TongChiTieuBanHangServices tongChiTieuBanHangServices = new TongChiTieuBanHangServicesImpl();

		List<Account> listAllAccount = accountServices.getAllAccount();
		List<TongChiTieuBanHang> listTop5KhachHang = tongChiTieuBanHangServices.getTop5KhachHang();

		request.setAttribute("listAllAccount", listAllAccount);
		request.setAttribute("listTop5KhachHang", listTop5KhachHang);
		request.getRequestDispatcher("/views/admin/Top5KhachHang.jsp").forward(request, response);
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
