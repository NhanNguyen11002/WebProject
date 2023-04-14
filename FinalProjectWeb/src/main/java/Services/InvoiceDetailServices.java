package Services;

import java.util.List;

import entity.InvoiceDetail;

public interface InvoiceDetailServices {
	void add(int accId, int proId, int quantity, String size, int invoiceId);

	List<InvoiceDetail> getAllInvoiceDetailsByOrderId(int orderid);
	
	InvoiceDetail getInvoiceDetailsById(int id);
}
