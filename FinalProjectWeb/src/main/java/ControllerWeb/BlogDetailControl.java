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

import Services.AccountServices;
import Services.BlogReviewServices;
import Services.BlogServices;
import Services.CartServices;
import Services.ProductServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.BlogReviewServiesImpl;
import ServicesImpl.BlogServicesImpl;
import ServicesImpl.CartServicesImpl;
import ServicesImpl.ProductServicesImpl;
import entity.Account;
import entity.Blog;
import entity.Cart;
import entity.Product;
import entity.ReviewBlog;

@WebServlet(name = "DetailControl", urlPatterns = { "/detailBlog" })
public class BlogDetailControl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("bid");

		BlogServices blogServices = new BlogServicesImpl();
		BlogReviewServices reviewServices = new BlogReviewServiesImpl();
		AccountServices accountServices = new AccountServicesImpl();

		List<ReviewBlog> listAllReview = reviewServices.getAllReviewByBlogID(id);
		int countAllReview = listAllReview.size();

		List<Account> listAllAcount = accountServices.getAllAccount();

		Blog p = blogServices.getBlogByID(id);

		// ----------------------- xử lý cart --------------------------------
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		List<Cart> list2 = new ArrayList<>();
		List<Product> list3 = new ArrayList<>();
		double totalMoney = 0;
		if (a != null) {
			int accountID = a.getId();
			CartServices cartServices = new CartServicesImpl();
			ProductServices productServices = new ProductServicesImpl();
			list2 = cartServices.getCartByAccountID(accountID);
			list3 = productServices.getAllProduct();
			for (Cart o : list2) {
				for (Product b : list3) {
					if (o.getProductID() == b.getId()) {
						totalMoney = totalMoney + (b.getPrice() * o.getAmount());
					}
				}
			}
			request.setAttribute("listCart", list2);
			request.setAttribute("listProduct", list3);
			request.setAttribute("totalMoney", Double.toString(totalMoney));
		}
		/*------------------------------------------------------------------------------*/

		request.setAttribute("detail", p);
		request.setAttribute("listAllReview", listAllReview);
		request.setAttribute("listAllAcount", listAllAcount);
		request.setAttribute("countAllReview", countAllReview);

		request.getRequestDispatcher("/views/web/BlogDetail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
