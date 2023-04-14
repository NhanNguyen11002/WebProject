package ServicesImpl;

import java.util.List;

import DAO.IWishListDAO;
import DAOImpl.WishListDAOImpl;
import Services.WishListServices;
import entity.WishList;

public class WishListServicesImpl implements WishListServices {
	IWishListDAO wishListDAO = new WishListDAOImpl();

	@Override
	public void insertCart(int accountID, int productID) {
		wishListDAO.insertCart(accountID, productID);
	}

	@Override
	public void deleteCart(int productID) {
		wishListDAO.deleteCart(productID);
	}

	@Override
	public void deleteWishListByProductID(String productID) {
		wishListDAO.deleteWishListByProductID(productID);
	}

	@Override
	public void deleteWishListByAccountID(int accountID) {
		wishListDAO.deleteWishListByAccountID(accountID);
	}

	@Override
	public WishList checkCartExist(int accountID, int productID) {
		return wishListDAO.checkCartExist(accountID, productID);
	}

	@Override
	public List<WishList> getWishListByAccountID(int accountID) {
		return wishListDAO.getWishListByAccountID(accountID);
	}

}
