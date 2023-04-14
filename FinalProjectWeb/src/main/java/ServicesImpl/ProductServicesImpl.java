package ServicesImpl;

import java.io.File;
import java.util.List;

import DAO.IProductDAO;
import DAOImpl.ProductDAOImpl;
import Services.ProductServices;
import entity.Product;

public class ProductServicesImpl implements ProductServices {
	IProductDAO productDAO = new ProductDAOImpl();

	@Override
	public List<Product> getAllProduct() {
		return productDAO.getAllProduct();
	}

	@Override
	public int countAllProductBySellID(int sell_ID) {
		return productDAO.countAllProductBySellID(sell_ID);
	}

	@Override
	public int getSellIDByProductID(int productID) {
		return productDAO.getSellIDByProductID(productID);
	}

	public List<Product> getProductBySellId(int sellID) {
		return productDAO.getProductBySellId(sellID);
	}

	@Override
	public int countAllProduct() {
		return productDAO.countAllProduct();
	}

	@Override
	public List<Product> getTop3() {
		return productDAO.getTop3();
	}

	@Override
	public List<Product> getNext4Product(int amount) {
		return productDAO.getNext4Product(amount);
	}

	@Override
	public List<Product> getNext4NikeProduct(int amount) {
		return productDAO.getNext4NikeProduct(amount);
	}

	@Override
	public List<Product> getNext4AdidasProduct(int amount) {
		return productDAO.getNext4AdidasProduct(amount);
	}

	@Override
	public List<Product> getProductByCID(String cid) {
		return productDAO.getProductByCID(cid);
	}

	@Override
	public List<Product> getProductBySellIDAndIndex(int id, int indexPage) {
		return productDAO.getProductBySellIDAndIndex(id, indexPage);
	}

	@Override
	public List<Product> getProductByIndex(int indexPage) {
		return productDAO.getProductByIndex(indexPage);
	}

	@Override
	public List<Product> searchPriceUnder100() {
		return productDAO.searchPriceUnder100();
	}

	@Override
	public List<Product> searchPrice100To200() {
		return productDAO.searchPrice100To200();
	}

	@Override
	public List<Product> searchColorWhite() {
		return productDAO.searchColorWhite();
	}

	@Override
	public List<Product> searchColorGray() {
		return productDAO.searchColorGray();
	}

	@Override
	public List<Product> searchColorBlack() {
		return productDAO.searchColorBlack();
	}

	@Override
	public List<Product> searchColorYellow() {
		return productDAO.searchColorYellow();
	}

	@Override
	public List<Product> searchByPriceMinToMax(String priceMin, String priceMax) {
		return productDAO.searchByPriceMinToMax(priceMin, priceMax);
	}

	@Override
	public List<Product> searchPriceAbove200() {
		return productDAO.searchPriceAbove200();
	}

	@Override
	public List<Product> getRelatedProduct(int cateIDProductDetail) {
		return productDAO.getRelatedProduct(cateIDProductDetail);
	}

	@Override
	public Product getProductByID(String id) {
		return productDAO.getProductByID(id);
	}

	@Override
	public Product getLast() {
		return productDAO.getLast();
	}

	@Override
	public List<Product> get4Last() {
		return productDAO.get4Last();
	}

	@Override
	public List<Product> get4NikeLast() {
		return productDAO.get4NikeLast();
	}

	@Override
	public List<Product> get4AdidasLast() {
		return productDAO.get4AdidasLast();
	}

	@Override
	public List<Product> get4BitisLast() {
		return productDAO.get4BitisLast();
	}

	@Override
	public List<Product> get4ConverseLast() {
		return productDAO.get4ConverseLast();
	}

	@Override
	public void deleteProduct(String pid) {
		productDAO.deleteProduct(pid);
	}

	@Override
	public void deleteProductBySellID(String id) {
		productDAO.deleteProductBySellID(id);
	}

	public void insertProduct(Product product) {
		productDAO.insertProduct(product);
	}

	@Override
	public void editProduct(Product newProduct) {
		Product oldProduct = productDAO.getProductByID(newProduct.getId());
		oldProduct.setName(newProduct.getName());
		oldProduct.setPrice(newProduct.getPrice());
		oldProduct.setTitle(newProduct.getTitle());
		oldProduct.setModel(newProduct.getModel());
		oldProduct.setColor(newProduct.getColor());
		oldProduct.setDelivery(newProduct.getDelivery());
		oldProduct.setDescription(newProduct.getDescription());
		oldProduct.setCateID(newProduct.getCateID());
		if (newProduct.getImage() != null) {
			// XOA ANH CU DI
			String fileName = oldProduct.getImage();
			final String dir = "D:\\FinalProjectWeb";
			File file = new File(dir + "/product" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldProduct.setImage(newProduct.getImage());
		}
		if (newProduct.getImage2() != null) {
			// XOA ANH CU DI
			String fileName = oldProduct.getImage2();
			final String dir = "D:\\FinalProjectWeb";
			File file = new File(dir + "/product" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldProduct.setImage2(newProduct.getImage2());
		}
		if (newProduct.getImage3() != null) {
			// XOA ANH CU DI
			String fileName = oldProduct.getImage3();
			final String dir = "D:\\FinalProjectWeb";
			File file = new File(dir + "/product" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldProduct.setImage3(newProduct.getImage3());
		}
		if (newProduct.getImage4() != null) {
			// XOA ANH CU DI
			String fileName = oldProduct.getImage4();
			final String dir = "D:\\FinalProjectWeb";
			File file = new File(dir + "/product" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldProduct.setImage4(newProduct.getImage4());
		}

		productDAO.editProduct(oldProduct);
	}

	public void insertProductBySellID(Product product, int sellID) {
		productDAO.insertProductBySellID(product, sellID);
	}

	@Override
	public int countCid(Integer cid) {
		return productDAO.countCid(cid);
	}

	@Override
	public List<Product> pagingProduct(int index) {
		return productDAO.pagingProduct(index);
	}

	@Override
	public List<Product> pagingProductByCID(int index, String cid) {
		return productDAO.pagingProductByCID(index, cid);
	}

	@Override
	public Product getProductByID(int id) {
		return productDAO.getProductByID(id);
	}

	public List<Product> pagingProductBySellerID(int index, int sellID) {
		return productDAO.pagingProductBySellerID(index, sellID);
	}

	@Override
	public List<Product> searchByNameAll(String txtSearch) {
		// TODO Auto-generated method stub
		return productDAO.searchByNameAll(txtSearch);
	}

	@Override
	public List<Product> searchByNameSellID(String txtSearch, int sID) {
		// TODO Auto-generated method stub
		return productDAO.searchByNameSellID(txtSearch, sID);
	}

	@Override
	public int countSearch(String txtSearch) {
		// TODO Auto-generated method stub
		return productDAO.countSearch(txtSearch);
	}

	@Override
	public List<Product> pagingSearch(String txtSearch, int index) {
		// TODO Auto-generated method stub
		return productDAO.pagingSearch(txtSearch, index);
	}

}
