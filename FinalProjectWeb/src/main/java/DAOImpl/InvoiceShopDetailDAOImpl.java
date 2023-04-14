package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IInvoiceShopDetailDAO;
import context.DBContext;
import entity.InvoiceShopDetail;

public class InvoiceShopDetailDAOImpl implements IInvoiceShopDetailDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void addInvoiceShopDetail(int accId, int proId, int sellID, int quantity, String size, int invoiceId) {
		String query = "insert into InvoiceShopDetail values (?,?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accId);
			ps.setInt(2, proId);
			ps.setInt(3, sellID);
			ps.setInt(4, quantity);
			ps.setString(5, size);
			ps.setInt(6, invoiceId);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public List<InvoiceShopDetail> getAllInvoiceShopDetailsByOrderId(int orderid) {
		List<InvoiceShopDetail> list = new ArrayList<>();
		String query = "select * from InvoiceShopDetail where OrderShopId = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShopDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<InvoiceShopDetail> getAllInvoiceShopDetailByAccountID(int accID) {
		List<InvoiceShopDetail> list = new ArrayList<>();
		String query = "select * from InvoiceShopDetail where AccountId = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShopDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public InvoiceShopDetail getInvoiceShopDetailsByOrderId(int id) {
		String query = "select * from InvoiceShopDetail where OrderShopId = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new InvoiceShopDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public InvoiceShopDetail getInvoiceShopDetailsById(int id) {
		String query = "select * from InvoiceShopDetail where id = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new InvoiceShopDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7));
			}
		} catch (Exception e) {
		}
		return null;
	}

}
