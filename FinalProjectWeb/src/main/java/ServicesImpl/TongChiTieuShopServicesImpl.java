package ServicesImpl;

import java.util.List;

import DAO.ITongChiTieuShopDAO;
import DAOImpl.TongChiTieuShopDAOImpl;
import Services.TongChiTieuShopServices;
import entity.TongChiTieuShop;

public class TongChiTieuShopServicesImpl implements TongChiTieuShopServices {

	ITongChiTieuShopDAO tongChiTieuShopDAO = new TongChiTieuShopDAOImpl();

	@Override
	public void editChiTieuShop(int sellID, double tongBanHang) {
		tongChiTieuShopDAO.editChiTieuShop(sellID, tongBanHang);
	}

	@Override
	public void insertTongChiTieuShop(int sellID, double tongBanHang) {
		tongChiTieuShopDAO.insertTongChiTieuShop(sellID, tongBanHang);
	}

	@Override
	public TongChiTieuShop checkTongChiTieuShopExist(int sellID) {
		return tongChiTieuShopDAO.checkTongChiTieuShopExist(sellID);
	}

	@Override
	public double tongChiTieu(int sellID) {
		return tongChiTieuShopDAO.tongChiTieu(sellID);
	}

	@Override
	public List<TongChiTieuShop> getTop5Shop() {
		return tongChiTieuShopDAO.getTop5Shop();
	}

}
