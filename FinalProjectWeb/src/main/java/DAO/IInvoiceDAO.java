package DAO;

import java.util.List;

import entity.Invoice;
import entity.InvoiceDetail;

public interface IInvoiceDAO {
	List<Invoice> getAllInvoice();

	List<Invoice> getRequestInvoice(int status);

	Invoice getLastedInvoice();

	Invoice getInvoiceBymaHD(int maHD);

	List<Invoice> getInvoiceByAccountID(int id);

	double totalMoneyDay(int day);

	double totalMoneyMonth(int month);

	double sumAllInvoice();

	List<Invoice> searchByNgayXuat(String ngayXuat);

	void deleteInvoiceByAccountId(String id);

	void insertInvoice(int accountID, double tongGia, String email, String name, String phone, String deliveryAddress);

	void updateInvoice(int maHD, int status);
	
	void updateInvoiceProfile(String name, String email, String phone, String deliveryAddress, int maHD);

}
