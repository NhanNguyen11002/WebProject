package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IInvoiceDetailDAO;
import context.DBContext;
import entity.Account;
import entity.InvoiceDetail;

public class InvoiceDetailDAOImpl extends DBContext implements IInvoiceDetailDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void add(int accId, int proId, int quantity, String size, int invoiceId) {
		String query = "insert into InvoiceDetail values (?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accId);
			ps.setInt(2, proId);
			ps.setInt(3, quantity);
			ps.setString(4, size);
			ps.setInt(5, invoiceId);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public List<InvoiceDetail> getAllInvoiceDetailsByOrderId(int orderid) {
		List<InvoiceDetail> list = new ArrayList<>();
		String query = "select * from InvoiceDetail where OrderId = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public InvoiceDetail getInvoiceDetailsById(int id) {
		String query = "select * from InvoiceDetail where id = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new InvoiceDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6));
			}
		} catch (Exception e) {
		}
		return null;
	}

}
