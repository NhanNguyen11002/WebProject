package entity;

public class Account {
	private int id;
	private String user;
	private String pass;
	private int isSell;
	private int isAdmin;
	private int isShipper;
	private String email;
	private String image;
	private String code;

	public Account() {
		super();
	}

	public Account(int id, String user, String pass, int isSell, int isAdmin, int isShipper, String email, String image,
			String code) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
		this.isShipper = isShipper;
		this.email = email;
		this.image = image;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIsSell() {
		return isSell;
	}

	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getIsShipper() {
		return isShipper;
	}

	public void setIsShipper(int isShipper) {
		this.isShipper = isShipper;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", pass=" + pass + ", isSell=" + isSell + ", isAdmin=" + isAdmin
				+ ", isShipper=" + isShipper + ", email=" + email + ", image=" + image + ", code=" + code + "]";
	}

}
