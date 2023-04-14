package Services;

import java.util.List;

import entity.Blog;

public interface BlogServices {
	List<Blog> getAllBlog();

	public Blog getBlogByID(String id);

	public List<Blog> getTop3();

	void insertBlog(Blog blog);

	void deleteBlog(String idBlog);
}
