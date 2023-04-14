/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerWeb;

import entity.Account;
import entity.Cart;
import entity.Category;
import entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.CartServices;
import Services.CategoryServices;
import Services.ProductServices;
import ServicesImpl.CartServicesImpl;
import ServicesImpl.CategoryServicesImpl;
import ServicesImpl.ProductServicesImpl;

@WebServlet(name = "ShopControl", urlPatterns = { "/shop" })
public class ShopControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		// b1: get data from dao
		CategoryServices categoryServices = new CategoryServicesImpl();
		ProductServices productServices = new ProductServicesImpl();
//        List<Product> list = dao.getAllProduct();
		List<Category> listC = categoryServices.getAllCategory();

		// ----------------------- xử lý cart --------------------------------
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		List<Cart> list2 = new ArrayList<>();
		List<Product> list3 = new ArrayList<>();
		double totalMoney = 0;
		if (a != null) {
			int accountID = a.getId();
			CartServices cartServices = new CartServicesImpl();
			list2 = cartServices.getCartByAccountID(accountID);
			list3 = productServices.getAllProduct();
			for (Cart o : list2) {
				for (Product p : list3) {
					if (o.getProductID() == p.getId()) {
						totalMoney = totalMoney + (p.getPrice() * o.getAmount());
					}
				}
			}
			request.setAttribute("listCart", list2);
			request.setAttribute("listProduct", list3);
			request.setAttribute("totalMoney", Double.toString(totalMoney));
		}
		/*------------------------------------------------------------------------------*/
		
		String cid = request.getParameter("cid");

		String indexPage = request.getParameter("index");

		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int cd1 = Integer.parseInt(cid);

		if ("0".equals(cid)) {
			int count = productServices.countAllProduct();
			int endPage = count / 6;
			if (count % 6 != 0) {
				endPage++;
			}
			List<Product> listAll = productServices.pagingProduct(index);
			request.setAttribute("listAll", listAll);
			request.setAttribute("endPage", endPage);
		} else {
			int count = productServices.countCid(cd1);
			int endPage = count / 6;
			if (count % 6 == 0) {
				endPage++;
			}
			List<Product> listPC = productServices.pagingProductByCID(index, cid);
			request.setAttribute("listAll", listPC);
			request.setAttribute("endPage", endPage);
		}

		request.setAttribute("tag", index);

		request.setAttribute("listCC", listC);
		request.setAttribute("tagactive", cid);

		request.getRequestDispatcher("/views/web/Shop.jsp").forward(request, response);
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
