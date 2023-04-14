package ServicesImpl;

import java.util.List;

import DAO.IInvoiceShopDetailDAO;
import DAOImpl.InvoiceShopDetailDAOImpl;
import Services.InvoiceShopDetailServices;
import entity.InvoiceShopDetail;

public class InvoiceShopDetailServicesImpl implements InvoiceShopDetailServices {

	IInvoiceShopDetailDAO invoiceShopDetailDAO = new InvoiceShopDetailDAOImpl();

	@Override
	public InvoiceShopDetail getInvoiceShopDetailsById(int id) {
		return invoiceShopDetailDAO.getInvoiceShopDetailsById(id);
	}

	@Override
	public List<InvoiceShopDetail> getAllInvoiceShopDetailsByOrderId(int orderid) {
		return invoiceShopDetailDAO.getAllInvoiceShopDetailsByOrderId(orderid);
	}

	@Override
	public void addInvoiceShopDetail(int accId, int proId, int sellID, int quantity, String size, int invoiceId) {
		invoiceShopDetailDAO.addInvoiceShopDetail(accId, proId, sellID, quantity, size, invoiceId);
		;
	}

	@Override
	public InvoiceShopDetail getInvoiceShopDetailsByOrderId(int id) {
		return invoiceShopDetailDAO.getInvoiceShopDetailsByOrderId(id);
	}

	@Override
	public List<InvoiceShopDetail> getAllInvoiceShopDetailByAccountID(int accID) {
		return invoiceShopDetailDAO.getAllInvoiceShopDetailByAccountID(accID);
	}

}
