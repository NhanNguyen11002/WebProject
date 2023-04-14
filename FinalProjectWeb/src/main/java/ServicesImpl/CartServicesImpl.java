package ServicesImpl;

import java.util.List;

import DAO.ICartDAO;
import DAOImpl.CartDAOImpl;
import Services.CartServices;
import entity.Cart;

public class CartServicesImpl implements CartServices{
	ICartDAO cartDAO = new CartDAOImpl();

	@Override
	public List<Cart> getCartByAccountID(int accountID) {
		return cartDAO.getCartByAccountID(accountID);
	}

	@Override
	public Cart checkCartExist(int accountID, int productID,String size) {
		return cartDAO.checkCartExist(accountID, productID,size);
	}

	@Override
	public void deleteCartByAccountID(int accountID) {
		cartDAO.deleteCartByAccountID(accountID);
	}

	@Override
	public void deleteCartByProductID(String productID) {
		cartDAO.deleteCartByProductID(productID);
	}

	@Override
	public void deleteCart(int productID, String size) {
		cartDAO.deleteCart(productID, size);
	}

	@Override
	public void insertCart(int accountID, int productID, int amount, String size) {
		cartDAO.insertCart(accountID, productID, amount, size);
	}

	@Override
	public void editAmountAndSizeCart(int accountID, int productID, int amount, String size) {
		cartDAO.editAmountAndSizeCart(accountID, productID, amount, size);
	}

	@Override
	public void editAmountCart(int accountID, int productID, int amount) {
		cartDAO.editAmountCart(accountID, productID, amount);
	}
}
