package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.ISoLuongDaBanDAO;
import context.DBContext;
import entity.SoLuongDaBan;

public class SoLuongDaBanDAOImpl extends DBContext implements ISoLuongDaBanDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<SoLuongDaBan> getTop10SanPhamBanChay() {
		List<SoLuongDaBan> list = new ArrayList<>();
		String query = "select top(10) *\r\n" + "from SoLuongDaBan\r\n" + "order by soLuongDaBan desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new SoLuongDaBan(rs.getInt(1), rs.getInt(2)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public SoLuongDaBan checkSoLuongDaBanExist(int productID) {
		String query = "select * from SoLuongDaBan where productID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, productID);

			rs = ps.executeQuery();
			while (rs.next()) {
				return new SoLuongDaBan(rs.getInt(1), rs.getInt(2));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insertSoLuongDaBan(int productID, int soLuongDaBan) {
		String query = "insert SoLuongDaBan(productID,soLuongDaBan)\r\n" + "values(?,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, productID);
			ps.setInt(2, soLuongDaBan);

			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void editSoLuongDaBan(int productID, int soLuongBanThem) {
		String query = "exec dbo.proc_CapNhatSoLuongDaBan ?,?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, productID);
			ps.setInt(2, soLuongBanThem);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

}
