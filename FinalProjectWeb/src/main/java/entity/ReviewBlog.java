package entity;

import java.util.Date;

public class ReviewBlog {
	private int accountID;
	private int blogID;
	private String contentReview;
	private Date dateReview;
	private int maReview;

	public ReviewBlog() {
		super();
	}

	public ReviewBlog(int accountID, int blogID, String contentReview, Date dateReview, int maReview) {
		super();
		this.accountID = accountID;
		this.blogID = blogID;
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

	public int getBlogID() {
		return blogID;
	}

	public void setBlogID(int blogID) {
		this.blogID = blogID;
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
		return "ReviewBlog [accountID=" + accountID + ", blogID=" + blogID + ", contentReview=" + contentReview
				+ ", dateReview=" + dateReview + ", maReview=" + maReview + "]";
	}

}
