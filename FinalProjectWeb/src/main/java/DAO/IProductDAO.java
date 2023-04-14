package DAO;

import java.util.List;

import entity.Product;

public interface IProductDAO {
	List<Product> getAllProduct();

	int countAllProductBySellID(int sell_ID);

	int getSellIDByProductID(int productID);

	List<Product> getProductBySellId(int sellID);

	int countAllProduct();

	List<Product> getTop3();

	List<Product> getNext4Product(int amount);

	List<Product> getNext4NikeProduct(int amount);

	List<Product> getNext4AdidasProduct(int amount);

	List<Product> getProductByCID(String cid);

	List<Product> getProductBySellIDAndIndex(int id, int indexPage);

	List<Product> getProductByIndex(int indexPage);

	List<Product> searchByNameAll(String txtSearch);

	List<Product> searchByNameSellID(String txtSearch, int sID);

	List<Product> searchPriceUnder100();

	List<Product> searchPrice100To200();

	List<Product> searchColorWhite();

	List<Product> searchColorGray();

	List<Product> searchColorBlack();

	List<Product> searchColorYellow();

	List<Product> searchByPriceMinToMax(String priceMin, String priceMax);

	List<Product> searchPriceAbove200();

	List<Product> getRelatedProduct(int cateIDProductDetail);

	Product getProductByID(String id);

	Product getProductByID(int id);

	Product getLast();

	List<Product> get4Last();

	List<Product> get4NikeLast();

	List<Product> get4AdidasLast();

	List<Product> get4BitisLast();

	List<Product> get4ConverseLast();

	void deleteProduct(String pid);

	void deleteProductBySellID(String id);

	void insertProduct(Product product);

	void editProduct(Product product);

	void insertProductBySellID(Product product, int sellID);

	int countCid(Integer cid);

	int countSearch(String txtSearch);

	List<Product> pagingProduct(int index);

	List<Product> pagingProductByCID(int index, String cid);

	List<Product> pagingProductBySellerID(int index, int sellID);

	List<Product> pagingSearch(String txtSearch, int index);

}
