package ServicesImpl;

import java.util.List;

import DAO.ITongChiTieuBanHangDAO;
import DAOImpl.TongChiTieuBanHangDAOImpl;
import Services.TongChiTieuBanHangServices;
import entity.TongChiTieuBanHang;

public class TongChiTieuBanHangServicesImpl implements TongChiTieuBanHangServices{
	ITongChiTieuBanHangDAO  chiTieuBanHangDAO = new TongChiTieuBanHangDAOImpl();

	@Override
	public List<TongChiTieuBanHang> getTop5KhachHang() {
		return chiTieuBanHangDAO.getTop5KhachHang();
	}

	@Override
	public List<TongChiTieuBanHang> getTop5NhanVien() {
		return chiTieuBanHangDAO.getTop5NhanVien();
	}

	@Override
	public TongChiTieuBanHang checkTongChiTieuBanHangExist(int userID) {
		return chiTieuBanHangDAO.checkTongChiTieuBanHangExist(userID);
	}

	@Override
	public void deleteTongChiTieuBanHangByUserID(String id) {
		chiTieuBanHangDAO.deleteTongChiTieuBanHangByUserID(id);
	}

	@Override
	public void insertTongChiTieuBanHang(int userID, double tongChiTieu, double tongBanHang) {
		chiTieuBanHangDAO.insertTongChiTieuBanHang(userID, tongChiTieu, tongBanHang);
	}

	@Override
	public void editTongBanHang(int sell_ID, double tongTienBanHangThem) {
		chiTieuBanHangDAO.editTongBanHang(sell_ID, tongTienBanHangThem);
	}

	@Override
	public void editTongChiTieu(int accountID, double totalMoneyVAT) {
		chiTieuBanHangDAO.editTongChiTieu(accountID, totalMoneyVAT);
	}

}
