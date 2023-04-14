package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import entity.InvoiceStatus;

public class InvoiceStatusDAOImpl extends DBContext {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public InvoiceStatus getOne(int id) {
		String sql = "SELECT * FROM invoiceStatus WHERE id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new InvoiceStatus(rs.getInt(1), rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
