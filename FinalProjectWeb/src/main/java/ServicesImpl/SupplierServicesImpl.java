package ServicesImpl;

import java.util.List;

import DAO.ISupplierDAO;
import DAOImpl.SupplierDAOImpl;
import Services.SupplierServices;
import entity.Supplier;

public class SupplierServicesImpl implements SupplierServices{
	ISupplierDAO supplierDAO = new SupplierDAOImpl();

	@Override
	public List<Supplier> getAllSupplier() {
		return supplierDAO.getAllSupplier();
	}

	@Override
	public void deleteSupplier(String idSupplier) {
		supplierDAO.deleteSupplier(idSupplier);
	}

	@Override
	public void insertSupplier(String nameSupplier, String phoneSupplier, String emailSupplier, String addressSupplier,
			String cateID) {
		supplierDAO.insertSupplier(nameSupplier, phoneSupplier, emailSupplier, addressSupplier, cateID);
	}

}
