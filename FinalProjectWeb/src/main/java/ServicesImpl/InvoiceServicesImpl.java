package ServicesImpl;

import java.util.List;

import DAO.IInvoiceDAO;
import DAOImpl.InvoiceDAOImpl;
import Services.InvoiceServices;
import entity.Invoice;

public class InvoiceServicesImpl implements InvoiceServices {
	IInvoiceDAO invoiceDAO = new InvoiceDAOImpl();

	@Override
	public List<Invoice> getAllInvoice() {
		return invoiceDAO.getAllInvoice();
	}

	public List<Invoice> getRequestInvoice(int status) {
		return invoiceDAO.getRequestInvoice(status);
	}

	public List<Invoice> getInvoiceByAccountID(int id) {
		return invoiceDAO.getInvoiceByAccountID(id);
	}

	@Override
	public double totalMoneyDay(int day) {
		return invoiceDAO.totalMoneyDay(day);
	}

	@Override
	public double totalMoneyMonth(int month) {
		return invoiceDAO.totalMoneyMonth(month);
	}

	@Override
	public double sumAllInvoice() {
		return invoiceDAO.sumAllInvoice();
	}

	@Override
	public List<Invoice> searchByNgayXuat(String ngayXuat) {
		return invoiceDAO.searchByNgayXuat(ngayXuat);
	}

	@Override
	public void deleteInvoiceByAccountId(String id) {
		invoiceDAO.deleteInvoiceByAccountId(id);
	}

	@Override
	public void insertInvoice(int accountID, double tongGia, String email, String name, String phone,
			String deliveryAddress) {
		invoiceDAO.insertInvoice(accountID, tongGia, email, name, phone, deliveryAddress);
	}

	@Override
	public Invoice getLastedInvoice() {
		return invoiceDAO.getLastedInvoice();
	}

	@Override
	public void updateInvoice(int maHD, int status) {
		invoiceDAO.updateInvoice(maHD, status);
	}

	@Override
	public Invoice getInvoiceBymaHD(int maHD) {
		return invoiceDAO.getInvoiceBymaHD(maHD);
	}

	@Override
	public void updateInvoiceProfile(String name, String email, String phone, String deliveryAddress, int maHD) {
		invoiceDAO.updateInvoiceProfile(name, email, phone, deliveryAddress, maHD);
	}
}
