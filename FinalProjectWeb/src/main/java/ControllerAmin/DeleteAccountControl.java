/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerAmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.AccountServices;
import Services.CartServices;
import Services.InvoiceServices;
import Services.ProductServices;
import Services.ReviewServices;
import Services.TongChiTieuBanHangServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.CartServicesImpl;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.ReviewServicesImpl;
import ServicesImpl.TongChiTieuBanHangServicesImpl;

@WebServlet(name = "DeleteAccountControl", urlPatterns = { "/admin/deleteAccount" })
public class DeleteAccountControl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		System.out.println("id: " + id);

		CartServices cartServices = new CartServicesImpl();
		ProductServices productServices = new ProductServicesImpl();
		ReviewServices reviewServices = new ReviewServicesImpl();
		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		TongChiTieuBanHangServices tongChiTieuBanHangServices = new TongChiTieuBanHangServicesImpl();
		AccountServices accountServices = new AccountServicesImpl();

		cartServices.deleteCartByAccountID(Integer.parseInt(id));
		productServices.deleteProductBySellID(id);
		reviewServices.deleteReviewByAccountID(id);
		invoiceServices.deleteInvoiceByAccountId(id);
		tongChiTieuBanHangServices.deleteTongChiTieuBanHangByUserID(id);
		accountServices.deleteAccount(id);

		request.setAttribute("mess", "Account Deleted!");
		request.getRequestDispatcher("managerAccount").forward(request, response);
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
