package DAO;

import java.util.List;

import entity.Review;

public interface IReviewDAO {
	int countAllReview();

	List<Review> getAllReviewByProductID(String productId);

	Review getNewReview(int accountID, int productID);

	void deleteReviewByProductID(String productID);

	void deleteReviewByAccountID(String id);
	
	public void deleteReview(String maRV);

	void insertReview(int accountID, int productID, String contentReview);

}
