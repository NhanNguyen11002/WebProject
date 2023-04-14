package ControllerSeller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.RequestServices;
import Services.SellerServices;
import ServicesImpl.RequestServicesImpl;
import ServicesImpl.SellerServicesImpl;
import entity.Account;
import entity.Request;

@WebServlet(urlPatterns = { "/seller/confirmRequest" })
public class ConfirmRequest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		RequestServices requestServices = new RequestServicesImpl();
		SellerServices sellerServices = new SellerServicesImpl();

		String requesID = request.getParameter("rID");

		String hienThi = "Tất cả";

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uID = a.getId();
		int sellID = sellerServices.getSellerByUID(uID).getSell_ID();

		int rID = Integer.parseInt(requesID);

		List<Request> listRequests = requestServices.getAllRequestBySellID(sellID);

		requestServices.handleStatus(rID);

		request.setAttribute("hienThi", hienThi);
		request.setAttribute("listRequests", listRequests);

		request.getRequestDispatcher("/views/seller/YeuCau.jsp").forward(request, response);
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
