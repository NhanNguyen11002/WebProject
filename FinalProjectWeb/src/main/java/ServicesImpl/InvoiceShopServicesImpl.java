package ServicesImpl;

import java.util.List;

import DAO.IInvoiceShopDAO;
import DAOImpl.InvoiceShopDAOImpl;
import Services.InvoiceShopServices;
import entity.Invoice;
import entity.InvoiceShop;

public class InvoiceShopServicesImpl implements InvoiceShopServices {
	IInvoiceShopDAO invoiceShopDAO = new InvoiceShopDAOImpl();

	@Override
	public void updateInvoiceProfile(String name, String email, String phone, String deliveryAddress, int maHD) {
		invoiceShopDAO.updateInvoiceProfile(name, email, phone, deliveryAddress, maHD);
	}

	@Override
	public void updateInvoice(int maHD, int status) {
		invoiceShopDAO.updateInvoice(maHD, status);
	}

	@Override
	public void insertInvoiceShop(int accountID, int sellID, double tongGia, String email, String name, String phone,
			String deliveryAddress, int orderID) {
		invoiceShopDAO.insertInvoiceShop(accountID, sellID, tongGia, email, name, phone, deliveryAddress, orderID);
		;
	}

	@Override
	public void deleteInvoiceShopByAccountId(String id) {
		invoiceShopDAO.deleteInvoiceShopByAccountId(id);
	}

	@Override
	public List<InvoiceShop> searchByNgayXuatBySellID(String ngayXuat, int sellID) {
		return invoiceShopDAO.searchByNgayXuatBySellID(ngayXuat, sellID);
	}

	@Override
	public double sumAllInvoiceBySellID(int sellID) {
		return invoiceShopDAO.sumAllInvoiceBySellID(sellID);
	}

	@Override
	public double totalMoneyMonth(int month, int sellID) {
		return invoiceShopDAO.totalMoneyMonth(month, sellID);
	}

	@Override
	public double totalMoneyDayBySellID(int day, int sellID) {
		return invoiceShopDAO.totalMoneyDayBySellID(day, sellID);
	}

	@Override
	public List<InvoiceShop> getInvoiceShopByAccountID(int id) {
		return invoiceShopDAO.getInvoiceShopByAccountID(id);
	}

	@Override
	public InvoiceShop getInvoiceShopBymaHD(int maHD) {
		return invoiceShopDAO.getInvoiceShopBymaHD(maHD);
	}

	@Override
	public List<InvoiceShop> getRequestInvoiceShop(int status, int sellID) {
		return invoiceShopDAO.getRequestInvoiceShop(status, sellID);
	}

	@Override
	public List<InvoiceShop> getAllInvoiceShopBySellID(int sellID) {
		return invoiceShopDAO.getAllInvoiceShopBySellID(sellID);
	}

	@Override
	public List<InvoiceShop> getAllInvoiceShop() {
		return invoiceShopDAO.getAllInvoiceShop();
	}

	@Override
	public List<InvoiceShop> getListInvoiceShopByOrderID(int orderID) {
		return invoiceShopDAO.getListInvoiceShopByOrderID(orderID);
	}

	public InvoiceShop getLastedInvoice() {
		return invoiceShopDAO.getLastedInvoice();
	}

	@Override
	public List<InvoiceShop> getAllRequestInvoiceShop(int status) {
		return invoiceShopDAO.getAllRequestInvoiceShop(status);
	}

	@Override
	public int countInvoiceShopCompleted(int orderID) {
		return invoiceShopDAO.countInvoiceShopCompleted(orderID);
	}

	@Override
	public int countAllInvoiceShopByOrderID(int orderID) {
		return invoiceShopDAO.countAllInvoiceShopByOrderID(orderID);
	}

	@Override
	public List<InvoiceShop> getAllInvoiceShopByOrderID(int orderID) {
		return invoiceShopDAO.getAllInvoiceShopByOrderID(orderID);
	}

	@Override
	public List<InvoiceShop> getAllInvoiceConfirmed(int sellID) {
		return invoiceShopDAO.getAllInvoiceConfirmed(sellID);
	}

}
