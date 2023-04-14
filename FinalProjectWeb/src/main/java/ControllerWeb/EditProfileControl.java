package ControllerWeb;

import entity.Account;
import entity.Invoice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Services.AccountServices;
import Services.InvoiceServices;
import ServicesImpl.AccountServicesImpl;
import ServicesImpl.InvoiceServicesImpl;
import Util.Constant;

@WebServlet(name = "EditProfileControl", urlPatterns = { "/editProfile" })
public class EditProfileControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	AccountServices accountServices = new AccountServicesImpl();
	InvoiceServices invoiceServices = new InvoiceServicesImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int accID = a.getId();

		List<Invoice> listInvoices = invoiceServices.getInvoiceByAccountID(accID);
		request.setAttribute("listInvoices", listInvoices);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/EditProfile.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Account account = new Account();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);

			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					account.setId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("username")) {
					account.setUser(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("password")) {
					account.setPass(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("email")) {
					account.setEmail(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("images")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/account/" + fileName);
						item.write(file);
						account.setImage("account/" + fileName);
					} else {
						account.setImage(null);
					}
				}
			}
			accountServices.editProfile(account);

			response.sendRedirect(request.getContextPath() + "/login");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}