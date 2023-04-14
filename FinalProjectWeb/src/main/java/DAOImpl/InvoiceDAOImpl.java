package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IInvoiceDAO;
import context.DBContext;
import entity.Invoice;
import entity.InvoiceDetail;

public class InvoiceDAOImpl extends DBContext implements IInvoiceDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	@Override
	public List<Invoice> getAllInvoice() {
		List<Invoice> list = new ArrayList<>();
		String query = "select * from Invoice ORDER BY maHD DESC";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Invoice(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Invoice> getRequestInvoice(int status) {
		List<Invoice> list = new ArrayList<>();
		String query = "select * from Invoice where status = ? ORDER BY maHD DESC ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Invoice(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Invoice getLastedInvoice() {
		String sql = "Select Top 1 * from Invoice ORDER BY maHD DESC ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Invoice(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Invoice getInvoiceBymaHD(int maHD) {
		String query = "Select * from Invoice where maHD = ? ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, maHD);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Invoice(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Invoice> getInvoiceByAccountID(int id) {
		List<Invoice> list = new ArrayList<>();
		String query = "select * from Invoice where accountID = ? ORDER BY maHD DESC";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Invoice(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public double totalMoneyDay(int day) {
		String query = "select \r\n" + "	SUM(tongGia) \r\n" + "from Invoice\r\n"
				+ "where DATEPART(dw,[ngayXuat]) = ?\r\n" + "Group by ngayXuat ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, day);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public double totalMoneyMonth(int month) {
		String query = "select SUM(tongGia) from Invoice\r\n" + "where MONTH(ngayXuat)=?\r\n"
				+ "Group by MONTH(ngayXuat)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, month);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public double sumAllInvoice() {
		String query = "select SUM(tongGia) from Invoice";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public List<Invoice> searchByNgayXuat(String ngayXuat) {
		List<Invoice> list = new ArrayList<>();
		String query = "select * from Invoice\r\n" + "where [ngayXuat] ='" + ngayXuat + "'";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
//	            ps.setString(1,ngayXuat);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Invoice(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public void deleteInvoiceByAccountId(String id) {
		String query = "delete from Invoice\n" + "where [accountID] = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void insertInvoice(int accountID, double tongGia, String email, String name, String phone,
			String deliveryAddress) {
		String query = "insert Invoice(accountID,tongGia,ngayXuat,status,email,name,phone,deliveryAddress)\r\n"
				+ "values(?,?,?,1,?,?,?,?)";

		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setDouble(2, tongGia);
			ps.setDate(3, getCurrentDate());
			ps.setString(4, email);
			ps.setString(5, name);
			ps.setString(6, phone);
			ps.setString(7, deliveryAddress);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	public void updateInvoice(int maHD, int status) {
		String query = "UPDATE Invoice SET status = ? WHERE maHD = ?";

		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			ps.setInt(2, maHD);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	public void updateInvoiceProfile(String name, String email, String phone, String deliveryAddress, int maHD) {
		String query = "UPDATE Invoice SET name = ?, email = ?, phone = ?, deliveryAddress = ? where maHD = ?";

		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, deliveryAddress);
			ps.setInt(5, maHD);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

}
