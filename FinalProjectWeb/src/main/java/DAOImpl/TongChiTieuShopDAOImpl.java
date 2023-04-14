package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.ITongChiTieuShopDAO;
import context.DBContext;
import entity.TongChiTieuBanHang;
import entity.TongChiTieuShop;

public class TongChiTieuShopDAOImpl extends DBContext implements ITongChiTieuShopDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insertTongChiTieuShop(int sellID, double tongBanHang) {
		String query = "insert TongChiTieuShop(sellID,TongBanHang) values(?,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			ps.setDouble(2, tongBanHang);

			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void editChiTieuShop(int sellID, double tongBanHang) {
		String query = "update TongChiTieuShop set TongBanHang = ? where sellID = ? ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setDouble(1, tongBanHang);
			ps.setInt(2, sellID);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	public TongChiTieuShop checkTongChiTieuShopExist(int sellID) {
		String query = "select * from TongChiTieuShop where sellID=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);

			rs = ps.executeQuery();
			while (rs.next()) {
				return new TongChiTieuShop(rs.getInt(1), rs.getDouble(2));
			}
		} catch (Exception e) {
		}
		return null;

	}

	@Override
	public double tongChiTieu(int sellID) {
		String query = "select SUM(TongBanHang) from TongChiTieuShop where sellID = ?";
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

	public List<TongChiTieuShop> getTop5Shop() {
		List<TongChiTieuShop> list = new ArrayList<>();
		String query = "select top 5 * from TongChiTieuShop order by TongBanHang desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new TongChiTieuShop(rs.getInt(1), rs.getDouble(2)));
			}
		} catch (Exception e) {
		}
		return list;

	}

}
