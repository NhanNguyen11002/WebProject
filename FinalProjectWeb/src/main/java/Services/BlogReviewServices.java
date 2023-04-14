package Services;

import java.util.List;

import entity.ReviewBlog;

public interface BlogReviewServices {
	int countAllReview();

	List<ReviewBlog> getAllReviewByBlogID(String blogId);

	ReviewBlog getNewReview(int accountID, int productID);

	public void deleteBlogReview(String maRV);

	void insertReview(int accountID, int blogID, String contentReview);
}
