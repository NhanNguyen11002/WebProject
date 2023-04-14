package DAO;

import java.util.List;

import entity.Supplier;

public interface ISupplierDAO {
	List<Supplier> getAllSupplier();

	void deleteSupplier(String idSupplier);

	void insertSupplier(String nameSupplier, String phoneSupplier, String emailSupplier, String addressSupplier,
			String cateID);

}
