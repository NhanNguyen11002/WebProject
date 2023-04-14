package ServicesImpl;

import java.util.List;

import DAO.IBlogReviewDAO;
import DAOImpl.BlogReviewDAOImpl;
import Services.BlogReviewServices;
import entity.ReviewBlog;

public class BlogReviewServiesImpl implements BlogReviewServices {

	IBlogReviewDAO blogReviewDAO = new BlogReviewDAOImpl();

	@Override
	public int countAllReview() {
		return blogReviewDAO.countAllReview();
	}

	@Override
	public List<ReviewBlog> getAllReviewByBlogID(String blogId) {
		return blogReviewDAO.getAllReviewByBlogID(blogId);
	}

	@Override
	public ReviewBlog getNewReview(int accountID, int productID) {
		return blogReviewDAO.getNewReview(accountID, productID);
	}

	public void deleteBlogReview(String maRV) {
		blogReviewDAO.deleteBlogReview(maRV);
	}

	@Override
	public void insertReview(int accountID, int blogID, String contentReview) {
		blogReviewDAO.insertReview(accountID, blogID, contentReview);
	}

}
