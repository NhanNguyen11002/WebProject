package Services;

import java.util.List;

import entity.SoLuongDaBan;

public interface SoLuongDaBanServices {
	List<SoLuongDaBan> getTop10SanPhamBanChay();

	SoLuongDaBan checkSoLuongDaBanExist(int productID);

	void insertSoLuongDaBan(int productID, int soLuongDaBan);

	void editSoLuongDaBan(int productID, int soLuongBanThem);
}
