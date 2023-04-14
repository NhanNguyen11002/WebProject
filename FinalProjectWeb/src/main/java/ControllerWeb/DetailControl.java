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
import Services.CartServices;
import Services.CategoryServices;
import Services.InvoiceShopDetailServices;
import Services.ProductServices;
import Services.ReviewServices;
import Services.SellerServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.CartServicesImpl;
import ServicesImpl.CategoryServicesImpl;
import ServicesImpl.InvoiceShopDetailServicesImpl;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.ReviewServicesImpl;
import ServicesImpl.SellerServicesImpl;
import entity.Account;
import entity.Cart;
import entity.InvoiceShopDetail;
import entity.Product;
import entity.Review;

@WebServlet(urlPatterns = { "/detail" })
public class DetailControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String id = request.getParameter("pid");
		int index = Integer.parseInt(id);

		ProductServices productServices = new ProductServicesImpl();
		CategoryServices categoryServices = new CategoryServicesImpl();
		ReviewServices reviewServices = new ReviewServicesImpl();
		AccountServices accountServices = new AccountServicesImpl();
		SellerServices sellerServices = new SellerServicesImpl();
		InvoiceShopDetailServices invoiceShopDetailServices = new InvoiceShopDetailServicesImpl();

		// xác định tên shop
		int sellID = productServices.getSellIDByProductID(index);
		String nameShop = sellerServices.getSellerBySellID(sellID).getName_Shop();

		Product p = productServices.getProductByID(id);

		int cateIDProductDetail = categoryServices.getCateIDByProductID(id);
		List<Product> listRelatedProduct = productServices.getRelatedProduct(cateIDProductDetail);

		List<Review> listAllReview = reviewServices.getAllReviewByProductID(id);
		int countAllReview = listAllReview.size();

		List<Account> listAllAcount = accountServices.getAllAccount();

		Product last = productServices.getLast();

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
				for (Product s : list3) {
					if (o.getProductID() == s.getId()) {
						totalMoney = totalMoney + (s.getPrice() * o.getAmount());
					}
				}
			}

			// xử lí nhận xét
			List<InvoiceShopDetail> listInvoiceShopDetails = invoiceShopDetailServices
					.getAllInvoiceShopDetailByAccountID(accountID);

			request.setAttribute("listInvoiceShopDetails", listInvoiceShopDetails);
			request.setAttribute("listCart", list2);
			request.setAttribute("listProduct", list3);
			request.setAttribute("totalMoney", Double.toString(totalMoney));
		}
		/*------------------------------------------------------------------------------*/

		request.setAttribute("detail", p);
		request.setAttribute("listRelatedProduct", listRelatedProduct);
		request.setAttribute("listAllReview", listAllReview);
		request.setAttribute("listAllAcount", listAllAcount);
		request.setAttribute("countAllReview", countAllReview);
		request.setAttribute("p", last);
		request.setAttribute("nameShop", nameShop);

		request.getRequestDispatcher("/views/web/DetailProduct.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	public static void main(String[] args) {
		InvoiceShopDetailServices invoiceShopDetailServices = new InvoiceShopDetailServicesImpl();
		List<InvoiceShopDetail> listInvoiceShopDetails = invoiceShopDetailServices
				.getAllInvoiceShopDetailByAccountID(1053);
		System.out.println(listInvoiceShopDetails);
	}
}
