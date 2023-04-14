package Services;

import java.util.List;

import entity.TongChiTieuShop;

public interface TongChiTieuShopServices {
	void insertTongChiTieuShop(int sellID, double tongBanHang);

	void editChiTieuShop(int sellID, double tongBanHang);

	TongChiTieuShop checkTongChiTieuShopExist(int sellID);

	double tongChiTieu(int sellID);

	List<TongChiTieuShop> getTop5Shop();
}
