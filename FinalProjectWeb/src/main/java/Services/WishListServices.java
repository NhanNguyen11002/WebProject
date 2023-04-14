package Services;

import java.util.List;

import entity.WishList;

public interface WishListServices {
	void insertCart(int accountID, int productID);

	void deleteCart(int productID);

	void deleteWishListByProductID(String productID);

	void deleteWishListByAccountID(int accountID);

	WishList checkCartExist(int accountID, int productID);

	List<WishList> getWishListByAccountID(int accountID);
}
