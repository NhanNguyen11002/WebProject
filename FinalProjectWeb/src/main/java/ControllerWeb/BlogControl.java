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
import Services.ProductServices;
import ServicesImpl.BlogServicesImpl;
import ServicesImpl.CartServicesImpl;
import ServicesImpl.ProductServicesImpl;
import entity.Account;
import entity.Blog;
import entity.Cart;
import entity.Product;

@WebServlet(urlPatterns = { "/blog" })
public class BlogControl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		BlogServices blogServices = new BlogServicesImpl();
		ProductServices productServices = new ProductServicesImpl();

		List<Blog> listBlog = blogServices.getAllBlog();

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

		request.setAttribute("listBlog", listBlog);

		request.getRequestDispatcher("/views/web/Blog.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
