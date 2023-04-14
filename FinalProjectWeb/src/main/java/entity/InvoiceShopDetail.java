package entity;

public class InvoiceShopDetail {
	private int id;
	private int AccountId;
	private int proId;
	private int sellID;
	private int proQuantity;
	private String proSize;
	private int orderId;

	public InvoiceShopDetail() {
		super();
	}

	public InvoiceShopDetail(int id, int accountId, int proId, int sellID, int proQuantity, String proSize,
			int orderId) {
		super();
		this.id = id;
		AccountId = accountId;
		this.proId = proId;
		this.sellID = sellID;
		this.proQuantity = proQuantity;
		this.proSize = proSize;
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return AccountId;
	}

	public void setAccountId(int accountId) {
		AccountId = accountId;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getSellID() {
		return sellID;
	}

	public void setSellID(int sellID) {
		this.sellID = sellID;
	}

	public int getProQuantity() {
		return proQuantity;
	}

	public void setProQuantity(int proQuantity) {
		this.proQuantity = proQuantity;
	}

	public String getProSize() {
		return proSize;
	}

	public void setProSize(String proSize) {
		this.proSize = proSize;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "InvoiceShopDetail [id=" + id + ", AccountId=" + AccountId + ", proId=" + proId + ", sellID=" + sellID
				+ ", proQuantity=" + proQuantity + ", proSize=" + proSize + ", orderId=" + orderId + "]";
	}

}
