package entity;

public class InvoiceDetail {
	private int id;
	private int AccountId;
	private int proId;
	private int proQuantity;
	private String proSize;
	private int orderId;

	public InvoiceDetail() {
		super();
	}

	public InvoiceDetail(int id, int accountId, int proId, int proQuantity, String proSize, int orderId) {
		super();
		this.id = id;
		AccountId = accountId;
		this.proId = proId;
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
		return "InvoiceDetail [id=" + id + ", AccountId=" + AccountId + ", proId=" + proId + ", proQuantity="
				+ proQuantity + ", proSize=" + proSize + ", orderId=" + orderId + "]";
	}

}
