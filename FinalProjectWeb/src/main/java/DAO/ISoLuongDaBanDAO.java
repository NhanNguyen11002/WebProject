package DAO;

import java.util.List;

import entity.SoLuongDaBan;

public interface ISoLuongDaBanDAO {
	List<SoLuongDaBan> getTop10SanPhamBanChay();

	SoLuongDaBan checkSoLuongDaBanExist(int productID);

	void insertSoLuongDaBan(int productID, int soLuongDaBan);

	void editSoLuongDaBan(int productID, int soLuongBanThem);
}
