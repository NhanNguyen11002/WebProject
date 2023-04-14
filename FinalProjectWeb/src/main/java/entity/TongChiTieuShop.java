package entity;

public class TongChiTieuShop {
	private int sellID;
	private double tongBanHang;

	public TongChiTieuShop() {
		super();
	}

	public TongChiTieuShop(int sellID, double tongBanHang) {
		super();
		this.sellID = sellID;
		this.tongBanHang = tongBanHang;
	}

	public int getSellID() {
		return sellID;
	}

	public void setSellID(int sellID) {
		this.sellID = sellID;
	}

	public double getTongBanHang() {
		return tongBanHang;
	}

	public void setTongBanHang(double tongBanHang) {
		this.tongBanHang = tongBanHang;
	}

	@Override
	public String toString() {
		return "TongChiTieuShop [sellID=" + sellID + ", tongBanHang=" + tongBanHang + "]";
	}

}
