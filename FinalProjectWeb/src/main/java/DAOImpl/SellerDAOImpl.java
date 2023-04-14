package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.ISellerDAO;
import context.DBContext;
import entity.InvoiceShop;
import entity.Product;
import entity.Seller;

public class SellerDAOImpl extends DBContext implements ISellerDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void singup(String name, String phone, String email, int uID) {
		String query = "insert into Seller values(?,?,?,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setInt(4, uID);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public Seller getSellerByUID(int uid) {
		String query = "select * from Seller where uID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Seller(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public Seller getSellerBySellID(int sellID) {
		String query = "select * from Seller where sell_ID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Seller(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<Seller> getAllSeller() {
		List<Seller> list = new ArrayList<>();
		String query = "select * from Seller";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Seller(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

}
