package entity;

import java.util.Date;

public class InvoiceShop {
	private int maHD;
	private int accountID;
	private int sellID;
	private double tongGia;
	Date ngayXuat;
	private int status;
	private String email;
	private String name;
	private String phone;
	private String deliveryAddress;
	private int OrderID;

	public InvoiceShop() {
		super();
	}

	public InvoiceShop(int maHD, int accountID, int sellID, double tongGia, Date ngayXuat, int status, String email,
			String name, String phone, String deliveryAddress, int orderID) {
		super();
		this.maHD = maHD;
		this.accountID = accountID;
		this.sellID = sellID;
		this.tongGia = tongGia;
		this.ngayXuat = ngayXuat;
		this.status = status;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.deliveryAddress = deliveryAddress;
		OrderID = orderID;
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

	public int getSellID() {
		return sellID;
	}

	public void setSellID(int sellID) {
		this.sellID = sellID;
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

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	@Override
	public String toString() {
		return "InvoiceShop [maHD=" + maHD + ", accountID=" + accountID + ", sellID=" + sellID + ", tongGia=" + tongGia
				+ ", ngayXuat=" + ngayXuat + ", status=" + status + ", email=" + email + ", name=" + name + ", phone="
				+ phone + ", deliveryAddress=" + deliveryAddress + ", OrderID=" + OrderID + "]";
	}

}
