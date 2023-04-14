package Services;

import java.util.List;

import entity.Cart;

public interface CartServices {
	List<Cart> getCartByAccountID(int accountID);

	Cart checkCartExist(int accountID, int productID,String size);

	void deleteCartByAccountID(int accountID);

	void deleteCartByProductID(String productID);

	void deleteCart(int productID,String size);

	void insertCart(int accountID, int productID, int amount, String size);

	void editAmountAndSizeCart(int accountID, int productID, int amount, String size);

	void editAmountCart(int accountID, int productID, int amount);
}
