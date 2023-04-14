package entity;

import java.util.Date;

public class Review {
	private int accountID;
	private int productID;
	private String contentReview;
	private Date dateReview;
	private int maReview;

	public Review() {
		super();
	}

	public Review(int accountID, int productID, String contentReview, Date dateReview, int maReview) {
		super();
		this.accountID = accountID;
		this.productID = productID;
		this.contentReview = contentReview;
		this.dateReview = dateReview;
		this.maReview = maReview;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getContentReview() {
		return contentReview;
	}

	public void setContentReview(String contentReview) {
		this.contentReview = contentReview;
	}

	public Date getDateReview() {
		return dateReview;
	}

	public void setDateReview(Date dateReview) {
		this.dateReview = dateReview;
	}

	public int getMaReview() {
		return maReview;
	}

	public void setMaReview(int maReview) {
		this.maReview = maReview;
	}

	@Override
	public String toString() {
		return "Review [accountID=" + accountID + ", productID=" + productID + ", contentReview=" + contentReview
				+ ", dateReview=" + dateReview + ", maReview=" + maReview + "]";
	}

}
