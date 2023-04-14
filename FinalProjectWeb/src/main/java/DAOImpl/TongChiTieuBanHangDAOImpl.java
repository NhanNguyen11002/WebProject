package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.ITongChiTieuBanHangDAO;
import context.DBContext;
import entity.TongChiTieuBanHang;

public class TongChiTieuBanHangDAOImpl extends DBContext implements ITongChiTieuBanHangDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<TongChiTieuBanHang> getTop5KhachHang() {
		List<TongChiTieuBanHang> list = new ArrayList<>();
		String query = "select top(5) *\r\n" + "from TongChiTieuBanHang\r\n" + "order by TongChiTieu desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new TongChiTieuBanHang(rs.getInt(1), rs.getDouble(2), rs.getDouble(3)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<TongChiTieuBanHang> getTop5NhanVien() {
		List<TongChiTieuBanHang> list = new ArrayList<>();
		String query = "select top(5) *\r\n" + "from TongChiTieuBanHang\r\n" + "order by TongBanHang desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new TongChiTieuBanHang(rs.getInt(1), rs.getDouble(2), rs.getDouble(3)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public TongChiTieuBanHang checkTongChiTieuBanHangExist(int userID) {
		String query = "select * from TongChiTieuBanHang where [userID]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, userID);

			rs = ps.executeQuery();
			while (rs.next()) {
				return new TongChiTieuBanHang(rs.getInt(1), rs.getDouble(2), rs.getDouble(3));
			}
		} catch (Exception e) {
		}
		return null;

	}

	@Override
	public void deleteTongChiTieuBanHangByUserID(String id) {
		String query = "delete from TongChiTieuBanHang\n" + "where [userID] = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void insertTongChiTieuBanHang(int userID, double tongChiTieu, double tongBanHang) {
		String query = "insert TongChiTieuBanHang(userID,TongChiTieu,TongBanHang)\r\n" + "values(?,?,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, userID);
			ps.setDouble(2, tongChiTieu);
			ps.setDouble(3, tongBanHang);

			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void editTongChiTieu(int accountID, double totalMoneyVAT) {
		String query = "exec dbo.proc_CapNhatTongChiTieu ?,?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setDouble(2, totalMoneyVAT);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	@Override
	public void editTongBanHang(int sell_ID, double tongTienBanHangThem) {
		String query = "exec dbo.proc_CapNhatTongBanHang ?,?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sell_ID);
			ps.setDouble(2, tongTienBanHangThem);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

}
