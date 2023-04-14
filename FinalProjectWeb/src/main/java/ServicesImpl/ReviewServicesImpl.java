package ServicesImpl;

import java.util.List;

import DAO.IReviewDAO;
import DAOImpl.ReviewDAOImpl;
import Services.ReviewServices;
import entity.Review;

public class ReviewServicesImpl implements ReviewServices {
	IReviewDAO reviewDAO = new ReviewDAOImpl();

	@Override
	public int countAllReview() {
		return reviewDAO.countAllReview();
	}

	@Override
	public List<Review> getAllReviewByProductID(String productId) {
		return reviewDAO.getAllReviewByProductID(productId);
	}

	@Override
	public Review getNewReview(int accountID, int productID) {
		return reviewDAO.getNewReview(accountID, productID);
	}

	@Override
	public void deleteReviewByProductID(String productID) {
		reviewDAO.deleteReviewByProductID(productID);
	}

	@Override
	public void deleteReviewByAccountID(String id) {
		reviewDAO.deleteReviewByAccountID(id);
	}

	public void deleteReview(String maRV) {
		reviewDAO.deleteReview(maRV);
	}

	@Override
	public void insertReview(int accountID, int productID, String contentReview) {
		reviewDAO.insertReview(accountID, productID, contentReview);
	}

}
