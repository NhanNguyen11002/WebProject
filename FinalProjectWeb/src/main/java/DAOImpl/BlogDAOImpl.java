package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IBlogDAO;
import context.DBContext;
import entity.Blog;

public class BlogDAOImpl extends DBContext implements IBlogDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	@Override
	public List<Blog> getAllBlog() {
		List<Blog> list = new ArrayList<Blog>();
		String query = "select * from Blog";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Blog getBlogByID(String id) {
		String query = "select * from Blog where blog_id = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<Blog> getTop3() {
		List<Blog> list = new ArrayList<>();
		String query = "select top 3 * from Blog";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public void deleteBlog(String idBlog) {
		String query = "delete from Blog where blog_id=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, idBlog);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void insertBlog(Blog blog) {
		String query = "insert Blog(title, content1, content2, content3, content4,image,date) values(?,?,?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, blog.getTitle());
			ps.setString(2, blog.getContent1());
			ps.setString(3, blog.getContent2());
			ps.setString(4, blog.getContent3());
			ps.setString(5, blog.getContent4());
			ps.setString(6, blog.getImage());
			ps.setDate(7, getCurrentDate());
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

}
