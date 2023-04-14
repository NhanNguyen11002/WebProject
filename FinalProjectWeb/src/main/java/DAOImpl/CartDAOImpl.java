package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.OS;

import DAO.ICartDAO;
import context.DBContext;
import entity.Cart;

public class CartDAOImpl extends DBContext implements ICartDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Cart> getCartByAccountID(int accountID) {
		List<Cart> list = new ArrayList<>();
		String query = "select * from Cart where accountID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public Cart checkCartExist(int accountID, int productID,String size) {
		String query = "select * from Cart where [accountID] = ? and [productID] = ? and size = ? ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setInt(2, productID);
			ps.setString(3, size);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
		} catch (Exception e) {
		}
		return null;

	}

	@Override
	public void deleteCartByAccountID(int accountID) {
		String query = "delete from Cart \r\n" + "where [accountID]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void deleteCartByProductID(String productID) {
		String query = "delete from Cart where [productID]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, productID);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void deleteCart(int productID,String size) {
		String query = "delete from Cart where productID = ? and size = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, productID);
			ps.setString(2, size);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void insertCart(int accountID, int productID, int amount, String size) {
		String query = "insert Cart(accountID, productID, amount,size)\r\n" + "values(?,?,?,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setInt(2, productID);
			ps.setInt(3, amount);
			ps.setString(4, size);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void editAmountAndSizeCart(int accountID, int productID, int amount, String size) {
		String query = "update Cart set [amount]=?,\r\n" + "[size]=?\r\n" + "where [accountID]=? and [productID]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setString(2, size);
			ps.setInt(3, accountID);
			ps.setInt(4, productID);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void editAmountCart(int accountID, int productID, int amount) {
		String query = "update Cart set [amount]=?\r\n" + "where [accountID]=? and [productID]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setInt(2, accountID);
			ps.setInt(3, productID);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

}
