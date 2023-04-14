package ServicesImpl;

import java.util.List;

import DAO.ISoLuongDaBanDAO;
import DAOImpl.SoLuongDaBanDAOImpl;
import Services.SoLuongDaBanServices;
import entity.SoLuongDaBan;

public class SoLuongDaBanServicesImpl implements SoLuongDaBanServices{
	ISoLuongDaBanDAO soLuongDaBanDAO = new SoLuongDaBanDAOImpl();

	@Override
	public List<SoLuongDaBan> getTop10SanPhamBanChay() {
		return soLuongDaBanDAO.getTop10SanPhamBanChay();
	}

	@Override
	public SoLuongDaBan checkSoLuongDaBanExist(int productID) {
		return soLuongDaBanDAO.checkSoLuongDaBanExist(productID);
	}

	@Override
	public void insertSoLuongDaBan(int productID, int soLuongDaBan) {
		soLuongDaBanDAO.insertSoLuongDaBan(productID, soLuongDaBan);
	}

	@Override
	public void editSoLuongDaBan(int productID, int soLuongBanThem) {
		soLuongDaBanDAO.editSoLuongDaBan(productID, soLuongBanThem);
	}

}
