package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.ISupplierDAO;
import context.DBContext;
import entity.Supplier;

public class SupplierDAOImpl extends DBContext implements ISupplierDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Supplier> getAllSupplier() {
		List<Supplier> list = new ArrayList<>();
		String query = "select * from Supplier";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public void deleteSupplier(String idSupplier) {
		String query = "delete from Supplier\r\n" + "where idSupplier=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, idSupplier);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void insertSupplier(String nameSupplier, String phoneSupplier, String emailSupplier, String addressSupplier,
			String cateID) {
		String query = "insert Supplier(nameSupplier, phoneSupplier, emailSupplier, addressSupplier, cateID) \r\n"
				+ "values(?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, nameSupplier);
			ps.setString(2, phoneSupplier);
			ps.setString(3, emailSupplier);
			ps.setString(4, addressSupplier);
			ps.setString(5, cateID);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

}
