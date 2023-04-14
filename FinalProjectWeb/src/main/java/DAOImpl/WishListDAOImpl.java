package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IWishListDAO;
import context.DBContext;
import entity.WishList;

public class WishListDAOImpl extends DBContext implements IWishListDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<WishList> getWishListByAccountID(int accountID) {
		List<WishList> list = new ArrayList<>();
		String query = "select * from WishList where accountID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new WishList(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public WishList checkCartExist(int accountID, int productID) {
		String query = "select * from WishList\r\n" + "where [accountID] = ? and [productID] = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setInt(2, productID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new WishList(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}
		} catch (Exception e) {
		}
		return null;

	}

	@Override
	public void deleteWishListByAccountID(int accountID) {
		String query = "delete from WishList \r\n" + "where [accountID]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void deleteWishListByProductID(String productID) {
		String query = "delete from WishList where [productID]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, productID);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void deleteCart(int productID) {
		String query = "delete from WishList where productID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, productID);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void insertCart(int accountID, int productID) {
		String query = "insert WishList(accountID, productID)\r\n" + "values(?,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setInt(2, productID);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}
}
