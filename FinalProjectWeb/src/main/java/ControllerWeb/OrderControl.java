package ControllerWeb;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.CartServices;
import Services.InvoiceDetailServices;
import Services.InvoiceServices;
import Services.InvoiceShopDetailServices;
import Services.InvoiceShopServices;
import Services.ProductServices;
import Services.SellerServices;
import Services.SoLuongDaBanServices;
import Services.TongChiTieuBanHangServices;
import Services.TongChiTieuShopServices;
import ServicesImpl.CartServicesImpl;
import ServicesImpl.InvoiceDetailServicesImpl;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.InvoiceShopDetailServicesImpl;
import ServicesImpl.InvoiceShopServicesImpl;
import ServicesImpl.ProductServicesImpl;
import ServicesImpl.SellerServicesImpl;
import ServicesImpl.SoLuongDaBanServicesImpl;
import ServicesImpl.TongChiTieuBanHangServicesImpl;
import ServicesImpl.TongChiTieuShopServicesImpl;
import entity.Account;
import entity.Email;
import entity.EmailUtils;
import entity.Invoice;
import entity.InvoiceDetail;
import entity.InvoiceShop;
import entity.Cart;
import entity.Product;
import entity.Seller;
import entity.SoLuongDaBan;
import entity.TongChiTieuBanHang;
import entity.TongChiTieuShop;

@WebServlet(name = "OrderControl", urlPatterns = { "/order" })
public class OrderControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		SellerServices sellerServices = new SellerServicesImpl();
		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();
		CartServices cartServices = new CartServicesImpl();
		ProductServices productServices = new ProductServicesImpl();
		TongChiTieuBanHangServices tongChiTieuBanHangServices = new TongChiTieuBanHangServicesImpl();
		TongChiTieuShopServices tongChiTieuShopServices = new TongChiTieuShopServicesImpl();
		SoLuongDaBanServices soLuongDaBanServices = new SoLuongDaBanServicesImpl();
		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		InvoiceDetailServices invoiceDetailServices = new InvoiceDetailServicesImpl();
		InvoiceShopDetailServices invoiceShopDetailServices = new InvoiceShopDetailServicesImpl();

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			response.sendRedirect("login");
			return;
		}
		int accountID = a.getId();

		List<Cart> list = cartServices.getCartByAccountID(accountID);
		List<Product> list2 = productServices.getAllProduct();
		double totalMoney = 0;
		for (Cart c : list) {
			for (Product p : list2) {
				if (c.getProductID() == p.getId()) {
					totalMoney = totalMoney + (p.getPrice() * c.getAmount());
				}
			}
		}
		double totalMoneyVAT = totalMoney + totalMoney * 0.1;

		NumberFormat currentLocale = NumberFormat.getInstance();
		request.setAttribute("listCart", list);
		request.setAttribute("listProduct", list2);
		request.setAttribute("totalMoney", currentLocale.format(totalMoney));
		request.setAttribute("totalMoneyVAT", Double.toString(totalMoneyVAT));

		double tongTienBanHangThem = 0;
		int sell_ID;
		for (Cart c : list) {
			for (Product p : list2) {
				if (c.getProductID() == p.getId()) {
					tongTienBanHangThem = 0;
					sell_ID = productServices.getSellIDByProductID(p.getId());
					tongTienBanHangThem = tongTienBanHangThem + (p.getPrice() * c.getAmount());
					TongChiTieuBanHang t2 = tongChiTieuBanHangServices.checkTongChiTieuBanHangExist(accountID);
					if (t2 == null) {
						tongChiTieuBanHangServices.insertTongChiTieuBanHang(accountID, 0, tongTienBanHangThem);
					} else {
						tongChiTieuBanHangServices.editTongBanHang(sell_ID, tongTienBanHangThem);
					}
				}
			}
		}

		for (Cart c : list) {
			for (Product p : list2) {
				if (c.getProductID() == p.getId()) {
					SoLuongDaBan s = soLuongDaBanServices.checkSoLuongDaBanExist(p.getId());
					if (s == null) {
						soLuongDaBanServices.insertSoLuongDaBan(p.getId(), c.getAmount());
					} else {
						soLuongDaBanServices.editSoLuongDaBan(p.getId(), c.getAmount());
					}
				}
			}
		}

		invoiceServices.insertInvoice(accountID, totalMoney, "", "", "", "");

		Invoice invoiceDetailId = invoiceServices.getLastedInvoice();
		for (Cart c : list) {
			for (Product p : list2) {
				if (c.getProductID() == p.getId()) {
					invoiceDetailServices.add(accountID, p.getId(), c.getAmount(), c.getSize(),
							invoiceDetailId.getMaHD());
				}
			}
		}

		TongChiTieuBanHang t = tongChiTieuBanHangServices.checkTongChiTieuBanHangExist(accountID);
		if (t == null) {
			tongChiTieuBanHangServices.insertTongChiTieuBanHang(accountID, totalMoney, 0);
		} else {
			tongChiTieuBanHangServices.editTongChiTieu(accountID, totalMoney);
		}

		/*-------------------------------------------XỬ LÍ SELLER-----------------------------------------------*/
		List<Seller> list3 = sellerServices.getAllSeller();
		double totalMoneySellID = 0;
		for (Cart c : list) {
			for (Product p : list2) {
				if (c.getProductID() == p.getId()) {
					for (Seller s : list3) {
						if (s.getSell_ID() == p.getSell_ID()) {
							totalMoneySellID = p.getPrice() * c.getAmount();
						}
					}
					int sellID = productServices.getSellIDByProductID(p.getId());

					// thêm dữ liệu vào chi tiêu của từng shop
					TongChiTieuShop check = tongChiTieuShopServices.checkTongChiTieuShopExist(sellID);
					if (check == null) {
						tongChiTieuShopServices.insertTongChiTieuShop(sellID, totalMoneySellID);
					} else {
						tongChiTieuShopServices.editChiTieuShop(sellID,
								tongChiTieuShopServices.tongChiTieu(sellID) + totalMoneySellID);
					}

					// thêm hóa đơn vào từng shop
					invoiceShopServices.insertInvoiceShop(accountID, sellID, p.getPrice() * c.getAmount(), "", "", "",
							"", invoiceDetailId.getMaHD());

					// thêm vào shop detail
					int orderID = invoiceShopServices.getLastedInvoice().getMaHD();
					invoiceShopDetailServices.addInvoiceShopDetail(accountID, p.getId(), sellID, c.getAmount(),
							c.getSize(), orderID);
				}
			}
		}

		request.getRequestDispatcher("/views/web/DatHang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		try {
			String emailAddress = request.getParameter("email");
			String name = request.getParameter("name");
			String phoneNumber = request.getParameter("phoneNumber");
			String deliveryAddress = request.getParameter("deliveryAddress");

			HttpSession session = request.getSession();
			Account a = (Account) session.getAttribute("acc");
			if (a == null) {
				response.sendRedirect("login");
				return;
			}
			int accountID = a.getId();

			ProductServices productServices = new ProductServicesImpl();
			CartServices cartServices = new CartServicesImpl();
			InvoiceServices invoiceServices = new InvoiceServicesImpl();
			InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();

			List<Cart> list = cartServices.getCartByAccountID(accountID);
			List<Product> list2 = productServices.getAllProduct();
			Invoice invoiceDetailId = invoiceServices.getLastedInvoice();

			double totalMoney = 0;
			for (Cart c : list) {
				for (Product p : list2) {
					if (c.getProductID() == p.getId()) {
						totalMoney = totalMoney + (p.getPrice() * c.getAmount());
					}
				}
			}

			// xủ lí cập nhật profile invoice của từng seller
			List<InvoiceShop> listInvoiceShops = invoiceShopServices
					.getListInvoiceShopByOrderID(invoiceDetailId.getMaHD());
			for (InvoiceShop c : listInvoiceShops) {
				invoiceShopServices.updateInvoiceProfile(name, emailAddress, phoneNumber, deliveryAddress, c.getMaHD());
			}

			// xử lí cập nhật profile invoice của admin
			invoiceServices.updateInvoiceProfile(name, emailAddress, phoneNumber, deliveryAddress,
					invoiceDetailId.getMaHD());

			NumberFormat currentLocale = NumberFormat.getInstance();

			// old code
			Email email = new Email();
			email.setFrom("20110754@student.hcmute.edu.vn"); // chinh lai email quan tri tai day [chu y dung email con
																// hoat dong]
			email.setFromPassword("huutrong110102"); // mat khau email tren
			email.setTo(emailAddress);
			email.setSubject("Đặt hàng thành công từ Shoes Family");
			StringBuilder sb = new StringBuilder();
			sb.append("Dear ").append(name).append("<br>");
			sb.append("Bạn vừa đặt hàng từ Shoes Family. <br> ");
			sb.append("Địa chỉ nhận hàng của bạn là: <b>").append(deliveryAddress).append(" </b> <br>");
			sb.append("Số điện thoại khi nhận hàng của bạn là: <b>").append(phoneNumber).append(" </b> <br>");
			sb.append("Các sản phẩm bạn đặt bao gồm: <br>");
			for (Cart c : list) {
				for (Product p : list2) {
					if (c.getProductID() == p.getId()) {
						sb.append(p.getName()).append(" | ").append("Giá:").append(currentLocale.format(p.getPrice()))
								.append("VNĐ").append(" | ").append("Số lượng:").append(c.getAmount()).append(" | ")
								.append("Size:").append(c.getSize()).append("<br>");
					}
				}
			}
			sb.append("Tổng tiền: ").append(currentLocale.format(totalMoney)).append("VNĐ").append("<br>");
			sb.append("Cảm ơn bạn đã đặt hàng tại Shoes Family<br>");
			sb.append("Chủ cửa hàng <br>");
			email.setContent(sb.toString());
			EmailUtils.send(email);
			request.setAttribute("mess", "Đặt hàng thành công!");

			cartServices.deleteCartByAccountID(accountID);

		} catch (Exception e) {
			request.setAttribute("error", "Đặt hàng thất bại!");
			e.printStackTrace();
		}

		request.getRequestDispatcher("/views/web/DatHang.jsp").forward(request, response);
	}

}
