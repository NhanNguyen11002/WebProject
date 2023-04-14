package ControllerSeller;

import entity.Account;
import entity.Request;

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

@WebServlet(urlPatterns = { "/seller/requestList" })
public class RequestControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		RequestServices requestServices = new RequestServicesImpl();
		SellerServices sellerServices = new SellerServicesImpl();

		int requestStatus = Integer.parseInt(request.getParameter("rq"));

		String hienThi = "Tất cả";

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uID = a.getId();
		int sellID = sellerServices.getSellerByUID(uID).getSell_ID();

		List<Request> listRequests = requestServices.getAllRequestBySellID(sellID);

		if (requestStatus == 0) {
			hienThi = "Đã xử lí";
			listRequests = requestServices.getAllRequestBySellIDvStatus(sellID, requestStatus);
		} else if (requestStatus == 1) {
			hienThi = "Chưa xử lí";
			listRequests = requestServices.getAllRequestBySellIDvStatus(sellID, requestStatus);
		}

		request.setAttribute("listRequests", listRequests);
		request.setAttribute("hienThi", hienThi);

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
