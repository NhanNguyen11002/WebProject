package Services;

import java.util.List;

import entity.TongChiTieuBanHang;

public interface TongChiTieuBanHangServices {
	List<TongChiTieuBanHang> getTop5KhachHang();

	List<TongChiTieuBanHang> getTop5NhanVien();

	TongChiTieuBanHang checkTongChiTieuBanHangExist(int userID);

	void deleteTongChiTieuBanHangByUserID(String id);

	void insertTongChiTieuBanHang(int userID, double tongChiTieu, double tongBanHang);

	void editTongBanHang(int sell_ID, double tongTienBanHangThem);

	void editTongChiTieu(int accountID, double totalMoneyVAT);
}
