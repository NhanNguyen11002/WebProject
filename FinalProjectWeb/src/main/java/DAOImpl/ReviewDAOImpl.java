package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IReviewDAO;
import context.DBContext;
import entity.Review;

public class ReviewDAOImpl extends DBContext implements IReviewDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	@Override
	public int countAllReview() {
		String query = "select count(*) from Review";
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
	public List<Review> getAllReviewByProductID(String productId) {
		List<Review> list = new ArrayList<>();
		String query = "select * from Review\r\n" + "where [productID] =?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, productId);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public Review getNewReview(int accountID, int productID) {
		String query = "select top 1 * from Review\r\n" + "where accountID = ? and productID = ?\r\n"
				+ "order by maReview desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setInt(2, productID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void deleteReviewByProductID(String productID) {
		String query = "delete from Review where [productID] = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, productID);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void deleteReviewByAccountID(String id) {
		String query = "delete from Review where [accountID] = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void deleteReview(String maRV) {
		String query = "delete from Review where maReview = ? ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, maRV);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void insertReview(int accountID, int productID, String contentReview) {
		String query = "insert Review(accountID, productID, contentReview, dateReview)\r\n" + "values(?,?,?,?)";

		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setInt(2, productID);
			ps.setString(3, contentReview);
			ps.setDate(4, getCurrentDate());
			ps.executeUpdate();

		} catch (Exception e) {
		}
	}

}
