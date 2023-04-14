package ControllerWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.BlogServices;
import Services.CartServices;
import Services.CategoryServices;
import Services.ProductServices;
import ServicesImpl.BlogServicesImpl;
import ServicesImpl.CartServicesImpl;
import ServicesImpl.CategoryServicesImpl;
import ServicesImpl.ProductServicesImpl;
import entity.Account;
import entity.Blog;
import entity.Cart;
import entity.Category;
import entity.Product;

@WebServlet(urlPatterns = { "/home" })
public class Home extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// b1: get data from dao
		CategoryServices categoryServices = new CategoryServicesImpl();
		ProductServices productServices = new ProductServicesImpl();
		BlogServices blogServices = new BlogServicesImpl();

		List<Category> listC = categoryServices.getAllCategory();
		List<Product> list = productServices.getTop3();
		List<Blog> listB = blogServices.getTop3();

		List<Product> list4Last = productServices.get4Last();
		List<Product> list4NikeLast = productServices.get4NikeLast();
		List<Product> list4AdidasLast = productServices.get4AdidasLast();
		List<Product> list4BitisLast = productServices.get4BitisLast();
		List<Product> list4ConverseLast = productServices.get4ConverseLast();

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

		Product last = productServices.getLast();
		// b2: set data to jsp
		request.setAttribute("listP", list);
		request.setAttribute("listCC", listC);
		request.setAttribute("list4Last", list4Last);
		request.setAttribute("list4NikeLast", list4NikeLast);
		request.setAttribute("list4AdidasLast", list4AdidasLast);
		request.setAttribute("list4BitisLast", list4BitisLast);
		request.setAttribute("list4ConverseLast", list4ConverseLast);
		request.setAttribute("p", last);
		request.setAttribute("listB", listB);
		request.getRequestDispatcher("/views/web/Home.jsp").forward(request, response);
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
