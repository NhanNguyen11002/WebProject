package entity;

import java.util.Date;

public class Invoice {
	private int maHD;
	private int accountID;
	private double tongGia;
	Date ngayXuat;
	private int status;
	private String email;
	private String name;
	private String phone;
	private String deliveryAddress;

	public Invoice() {
		super();
	}

	public Invoice(int maHD, int accountID, double tongGia, Date ngayXuat, int status, String email, String name,
			String phone, String deliveryAddress) {
		super();
		this.maHD = maHD;
		this.accountID = accountID;
		this.tongGia = tongGia;
		this.ngayXuat = ngayXuat;
		this.status = status;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.deliveryAddress = deliveryAddress;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getTongGia() {
		return tongGia;
	}

	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}

	public Date getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString() {
		return "Invoice [maHD=" + maHD + ", accountID=" + accountID + ", tongGia=" + tongGia + ", ngayXuat=" + ngayXuat
				+ ", status=" + status + ", email=" + email + ", name=" + name + ", phone=" + phone
				+ ", deliveryAddress=" + deliveryAddress + "]";
	}

}
