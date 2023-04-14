package entity;

public class WishList {
	private int accID;
	private int proID;
	private int maWishlist;

	public WishList() {
		super();
	}

	public WishList(int accID, int proID, int maWishlist) {
		super();
		this.accID = accID;
		this.proID = proID;
		this.maWishlist = maWishlist;
	}

	public int getAccID() {
		return accID;
	}

	public void setAccID(int accID) {
		this.accID = accID;
	}

	public int getProID() {
		return proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}

	public int getMaWishlist() {
		return maWishlist;
	}

	public void setMaWishlist(int maWishlist) {
		this.maWishlist = maWishlist;
	}

	@Override
	public String toString() {
		return "WishList [accID=" + accID + ", proID=" + proID + ", maWishlist=" + maWishlist + "]";
	}

}
