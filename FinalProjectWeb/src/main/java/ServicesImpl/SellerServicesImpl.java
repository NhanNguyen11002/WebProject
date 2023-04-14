package ServicesImpl;

import java.util.List;

import DAO.ISellerDAO;
import DAOImpl.SellerDAOImpl;
import Services.SellerServices;
import entity.Seller;

public class SellerServicesImpl implements SellerServices {
	ISellerDAO sellerDAO = new SellerDAOImpl();

	@Override
	public void singup(String name, String phone, String email, int uID) {
		sellerDAO.singup(name, phone, email, uID);
	}

	@Override
	public Seller getSellerByUID(int uid) {
		return sellerDAO.getSellerByUID(uid);
	}

	@Override
	public List<Seller> getAllSeller() {
		return sellerDAO.getAllSeller();
	}

	@Override
	public Seller getSellerBySellID(int sellID) {
		return sellerDAO.getSellerBySellID(sellID);
	}

}
