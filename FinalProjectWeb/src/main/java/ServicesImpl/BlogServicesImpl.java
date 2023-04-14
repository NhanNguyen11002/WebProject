package ServicesImpl;

import java.util.List;

import DAO.IBlogDAO;
import DAOImpl.BlogDAOImpl;
import Services.BlogServices;
import entity.Blog;

public class BlogServicesImpl implements BlogServices {
	IBlogDAO blogDAO = new BlogDAOImpl();

	@Override
	public List<Blog> getAllBlog() {
		return blogDAO.getAllBlog();
	}

	@Override
	public Blog getBlogByID(String id) {
		return blogDAO.getBlogByID(id);
	}

	@Override
	public List<Blog> getTop3() {
		return blogDAO.getTop3();
	}

	@Override
	public void insertBlog(Blog blog) {
		blogDAO.insertBlog(blog);
	}

	@Override
	public void deleteBlog(String idBlog) {
		blogDAO.deleteBlog(idBlog);
	}

}
