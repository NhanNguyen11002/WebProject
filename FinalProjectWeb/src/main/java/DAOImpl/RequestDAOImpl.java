package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IRequestDAO;
import context.DBContext;
import entity.Request;

public class RequestDAOImpl implements IRequestDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public int countRequest() {
		String query = "select count(*) from Request";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int countRequestBySellID(int sellID) {
		String query = "select count(*) from Request where sell_ID = ? and status = 1 ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public List<Request> getAllRequest() {
		List<Request> list = new ArrayList<>();
		String query = "select * from Request";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Request(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public List<Request> getAllRequestBySellID(int sellID) {
		List<Request> list = new ArrayList<>();
		String query = "select * from Request where sell_ID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Request(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Request> getAllRequestByStatus(int status) {
		List<Request> list = new ArrayList<>();
		String query = "select * from Request where status = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Request(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Request> getAllRequestBySellIDvStatus(int sID, int status) {
		List<Request> list = new ArrayList<>();
		String query = "select * from Request where sell_ID = ? and  status = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sID);
			ps.setInt(2, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Request(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Request getRequestByID(int id) {
		String query = "select * from Request where id = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Request(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public Request getRequestByProID(int proID) {
		String query = "select * from Request where productID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, proID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Request(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insertRequest(int sellID, int proID, String content, int status) {
		String query = "insert into Request values(?,?,?,?)";

		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			ps.setInt(2, proID);
			ps.setString(3, content);
			ps.setInt(4, status);
			ps.executeUpdate();

		} catch (Exception e) {
		}
	}

	@Override
	public void handleStatus(int rID) {
		String query = "UPDATE Request SET status = 0 WHERE id = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, rID);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
}
