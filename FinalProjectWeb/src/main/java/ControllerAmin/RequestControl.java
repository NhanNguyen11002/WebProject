package ControllerAmin;

import entity.Request;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.RequestServices;
import ServicesImpl.RequestServicesImpl;

@WebServlet(name = "RequestControl", urlPatterns = { "/admin/request" })
public class RequestControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		RequestServices requestServices = new RequestServicesImpl();

		int requestStatus = Integer.parseInt(request.getParameter("rq"));

		String hienThi = "Tất cả";

		List<Request> listRequests = requestServices.getAllRequest();

		if (requestStatus == 0) {
			hienThi = "Đã xử lí";
			listRequests = requestServices.getAllRequestByStatus(requestStatus);
		} else if (requestStatus == 1) {
			hienThi = "Chưa xử lí";
			listRequests = requestServices.getAllRequestByStatus(requestStatus);
		}

		request.setAttribute("listRequests", listRequests);
		request.setAttribute("hienThi", hienThi);

		request.getRequestDispatcher("/views/admin/YeuCau.jsp").forward(request, response);
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
