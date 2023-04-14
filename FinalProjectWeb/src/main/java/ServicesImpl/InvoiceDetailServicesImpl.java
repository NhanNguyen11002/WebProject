package ServicesImpl;

import java.util.List;

import DAO.IInvoiceDetailDAO;
import DAOImpl.InvoiceDetailDAOImpl;
import Services.InvoiceDetailServices;
import entity.InvoiceDetail;

public class InvoiceDetailServicesImpl implements InvoiceDetailServices {

	IInvoiceDetailDAO invoiceDetailDAO = new InvoiceDetailDAOImpl();

	@Override
	public void add(int accId, int proId, int quantity, String size, int invoiceId) {
		invoiceDetailDAO.add(accId, proId, quantity, size, invoiceId);
	}

	@Override
	public List<InvoiceDetail> getAllInvoiceDetailsByOrderId(int orderid) {
		return invoiceDetailDAO.getAllInvoiceDetailsByOrderId(orderid);
	}

	@Override
	public InvoiceDetail getInvoiceDetailsById(int id) {
		return invoiceDetailDAO.getInvoiceDetailsById(id);
	}

}
