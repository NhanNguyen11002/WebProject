package entity;

public class Seller {
	private int sell_ID;
	private String name_Shop;
	private String phone_Shop;
	private String email_Shop;
	private int uID;

	public Seller() {
		super();
	}

	public Seller(int sell_ID, String name_Shop, String phone_Shop, String email_Shop, int uID) {
		super();
		this.sell_ID = sell_ID;
		this.name_Shop = name_Shop;
		this.phone_Shop = phone_Shop;
		this.email_Shop = email_Shop;
		this.uID = uID;
	}

	public int getSell_ID() {
		return sell_ID;
	}

	public void setSell_ID(int sell_ID) {
		this.sell_ID = sell_ID;
	}

	public String getName_Shop() {
		return name_Shop;
	}

	public void setName_Shop(String name_Shop) {
		this.name_Shop = name_Shop;
	}

	public String getPhone_Shop() {
		return phone_Shop;
	}

	public void setPhone_Shop(String phone_Shop) {
		this.phone_Shop = phone_Shop;
	}

	public String getEmail_Shop() {
		return email_Shop;
	}

	public void setEmail_Shop(String email_Shop) {
		this.email_Shop = email_Shop;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	@Override
	public String toString() {
		return "Seller [sell_ID=" + sell_ID + ", name_Shop=" + name_Shop + ", phone_Shop=" + phone_Shop
				+ ", email_Shop=" + email_Shop + ", uID=" + uID + "]";
	}

}
