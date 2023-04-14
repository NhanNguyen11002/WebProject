package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IInvoiceShopDAO;
import context.DBContext;
import entity.Invoice;
import entity.InvoiceShop;
import entity.Product;

public class InvoiceShopDAOImpl extends DBContext implements IInvoiceShopDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	@Override
	public List<InvoiceShop> getAllInvoiceShop() {
		List<InvoiceShop> list = new ArrayList<>();
		String query = "select * from InvoiceShop ORDER BY maHD DESC";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public List<InvoiceShop> getAllInvoiceShopBySellID(int sellID) {
		List<InvoiceShop> list = new ArrayList<>();
		String query = "select * from InvoiceShop where sellID = ? ORDER BY maHD DESC";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<InvoiceShop> getAllInvoiceConfirmed(int sellID) {
		List<InvoiceShop> list = new ArrayList<>();
		String query = "select * from InvoiceShop where sellID = ? and status != 1 ORDER BY maHD DESC";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public List<InvoiceShop> getRequestInvoiceShop(int status, int sellID) {
		List<InvoiceShop> list = new ArrayList<>();
		String query = "select * from InvoiceShop where status = ? and sellID = ?  ORDER BY maHD DESC";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			ps.setInt(2, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public List<InvoiceShop> getAllRequestInvoiceShop(int status) {
		List<InvoiceShop> list = new ArrayList<>();
		String query = "select * from InvoiceShop where status = ? ORDER BY maHD DESC";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<InvoiceShop> getAllInvoiceShopByOrderID(int orderID) {
		List<InvoiceShop> list = new ArrayList<>();
		String query = "select * from InvoiceShop where OrderID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public InvoiceShop getInvoiceShopBymaHD(int maHD) {
		String query = "Select * from InvoiceShop where maHD = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, maHD);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<InvoiceShop> getInvoiceShopByAccountID(int id) {
		List<InvoiceShop> list = new ArrayList<>();
		String query = "select * from InvoiceShop where accountID = ? ORDER BY maHD DESC";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public double totalMoneyDayBySellID(int day, int sellID) {
		String query = "select SUM(tongGia) from InvoiceShop where DATEPART(dw,[ngayXuat]) = ? and sellID = ? Group by ngayXuat  ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, day);
			ps.setInt(2, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public double totalMoneyMonth(int month, int sellID) {
		String query = "select SUM(tongGia) from InvoiceShop where MONTH(ngayXuat)=? and sellID = ? Group by MONTH(ngayXuat)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, month);
			ps.setInt(2, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public double sumAllInvoiceBySellID(int sellID) {
		String query = "select SUM(tongGia) from InvoiceShop where sellID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public List<InvoiceShop> searchByNgayXuatBySellID(String ngayXuat, int sellID) {
		List<InvoiceShop> list = new ArrayList<>();
		String query = "select * from InvoiceShop\r\n" + "where [ngayXuat] ='" + ngayXuat + "' and sellID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
//	            ps.setString(1,ngayXuat);
			ps.setInt(1, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public void deleteInvoiceShopByAccountId(String id) {
		String query = "delete from InvoiceShop\n" + "where [accountID] = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void insertInvoiceShop(int accountID, int sellID, double tongGia, String email, String name, String phone,
			String deliveryAddress, int orderID) {
		String query = "insert InvoiceShop(accountID,sellID,tongGia,ngayXuat,status,email,name,phone,deliveryAddress,OrderID)\r\n"
				+ "values(?,?,?,?,1,?,?,?,?,?)";

		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setInt(2, sellID);
			ps.setDouble(3, tongGia);
			ps.setDate(4, getCurrentDate());
			ps.setString(5, email);
			ps.setString(6, name);
			ps.setString(7, phone);
			ps.setString(8, deliveryAddress);
			ps.setInt(9, orderID);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	@Override
	public void updateInvoice(int maHD, int status) {
		String query = "UPDATE InvoiceShop SET status = ? WHERE maHD = ?";

		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			ps.setInt(2, maHD);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	@Override
	public void updateInvoiceProfile(String name, String email, String phone, String deliveryAddress, int maHD) {
		String query = "UPDATE InvoiceShop SET name = ?, email = ?, phone = ?, deliveryAddress = ? where maHD = ?";

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

	@Override
	public List<InvoiceShop> getListInvoiceShopByOrderID(int orderID) {
		List<InvoiceShop> list = new ArrayList<>();
		String query = "select * from InvoiceShop where OrderID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public InvoiceShop getLastedInvoice() {
		String sql = "Select Top 1 * from InvoiceShop ORDER BY maHD DESC ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new InvoiceShop(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int countInvoiceShopCompleted(int orderID) {
		String query = "select count(*) from InvoiceShop where OrderID = ? and status = 4 ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public int countAllInvoiceShopByOrderID(int orderID) {
		String query = "select count(*) from InvoiceShop where OrderID = ? ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;

	}

}
