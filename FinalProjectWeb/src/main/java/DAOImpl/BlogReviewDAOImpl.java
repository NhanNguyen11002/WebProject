package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IBlogReviewDAO;
import context.DBContext;
import entity.ReviewBlog;

public class BlogReviewDAOImpl extends DBContext implements IBlogReviewDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	@Override
	public int countAllReview() {
		String query = "select count(*) from BlogReview";
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
	public List<ReviewBlog> getAllReviewByBlogID(String blogId) {
		List<ReviewBlog> list = new ArrayList<>();
		String query = "select * from BlogReview where blogID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, blogId);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ReviewBlog(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4),rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public ReviewBlog getNewReview(int accountID, int productID) {
		String query = "select top 1 * from BlogReview where accountID = ? and blogID = ? order by maReview desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setInt(2, productID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new ReviewBlog(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4),rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void deleteBlogReview(String maRV) {
		String query = "delete from BlogReview where maReview = ? ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, maRV);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void insertReview(int accountID, int blogID, String contentReview) {
		String query = "insert BlogReview(accountID, blogID, contentReview, dateReview)\r\n" + "values(?,?,?,?)";

		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountID);
			ps.setInt(2, blogID);
			ps.setString(3, contentReview);
			ps.setDate(4, getCurrentDate());
			ps.executeUpdate();

		} catch (Exception e) {
		}
	}

}
