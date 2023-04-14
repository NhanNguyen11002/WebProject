package Services;

import java.util.List;

import entity.InvoiceShopDetail;

public interface InvoiceShopDetailServices {
	InvoiceShopDetail getInvoiceShopDetailsById(int id);

	List<InvoiceShopDetail> getAllInvoiceShopDetailsByOrderId(int orderid);

	void addInvoiceShopDetail(int accId, int proId, int sellID, int quantity, String size, int invoiceId);

	InvoiceShopDetail getInvoiceShopDetailsByOrderId(int id);

	List<InvoiceShopDetail> getAllInvoiceShopDetailByAccountID(int accID);
}
