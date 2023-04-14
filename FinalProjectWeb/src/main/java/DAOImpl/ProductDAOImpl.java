package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IProductDAO;
import context.DBContext;
import entity.Product;

public class ProductDAOImpl extends DBContext implements IProductDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		String query = "select * from Product";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public int getSellIDByProductID(int productID) {
		String query = "select sell_ID\r\n" + "from Product\r\n" + "where [id]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, productID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;

	}

	public List<Product> getProductBySellId(int sellID) {
		List<Product> list = new ArrayList<Product>();
		String query = "Select * from Product where sell_ID = ? ";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public int countAllProduct() {
		String query = "select count(*) from Product";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;

	}

	@Override
	public int countAllProductBySellID(int sell_ID) {
		String query = "select count(*) from Product where sell_ID=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, sell_ID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;

	}

	@Override
	public List<Product> getTop3() {
		List<Product> list = new ArrayList<>();
		String query = "select top 3 * from Product";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> getNext4Product(int amount) {
		List<Product> list = new ArrayList<>();
		String query = "SELECT *\n" + "  FROM Product\n" + " ORDER BY id\n" + "OFFSET ? ROWS\n"
				+ " FETCH NEXT 4 ROWS ONLY";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> getNext4NikeProduct(int amount) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\r\n" + "where cateID=2\r\n" + "order by id desc\r\n" + "offset ? rows\r\n"
				+ "fetch next 4 rows only";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> getNext4AdidasProduct(int amount) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\r\n" + "where cateID=1\r\n" + "order by id desc\r\n" + "offset ? rows\r\n"
				+ "fetch next 4 rows only";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> getProductByCID(String cid) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\n" + "where cateID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> getProductBySellIDAndIndex(int id, int indexPage) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product \r\n" + "where sell_ID = ?\r\n" + "order by [id]\r\n"
				+ "offset ? rows\r\n" + "fetch next 5 rows only";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, (indexPage - 1) * 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public List<Product> getProductByIndex(int indexPage) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product \r\n" + "order by [id]\r\n" + "offset ? rows\r\n"
				+ "fetch next 9 rows only";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, (indexPage - 1) * 9);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> searchByNameAll(String txtSearch) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\n" + "where [name] like ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txtSearch + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> searchByNameSellID(String txtSearch, int sID) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\n" + "where [name] like ? and sell_ID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, sID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public List<Product> searchPriceUnder100() {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\r\n" + "where [price] < 100000";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> searchPrice100To200() {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\r\n" + "where [price] >= 100000 and [price]<=200000";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> searchColorWhite() {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\r\n" + "where color = 'White'";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> searchColorGray() {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\r\n" + "where color = 'Gray'";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> searchColorBlack() {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\r\n" + "where color = 'Black'";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public List<Product> searchColorYellow() {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\r\n" + "where color = 'Yellow'";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> searchByPriceMinToMax(String priceMin, String priceMax) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\r\n" + "where [price] >= ? and [price]<=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, priceMin);
			ps.setString(2, priceMax);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> searchPriceAbove200() {
		List<Product> list = new ArrayList<>();
		String query = "select * from Product\r\n" + "where [price] > 200000";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> getRelatedProduct(int cateIDProductDetail) {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from product\r\n" + "where [cateID] =?\r\n" + "order by id desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, cateIDProductDetail);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public Product getProductByID(String id) {
		String query = "select * from Product\n" + "where id = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public Product getProductByID(int id) {
		String query = "select * from Product\n" + "where id = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public Product getLast() {
		String query = "select top 1 * from Product\n" + "order by id desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
			}
		} catch (Exception e) {
		}
		return null;

	}

	@Override
	public List<Product> get4Last() {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from Product order by price desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> get4NikeLast() {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from Product\r\n" + "where cateID = 2\r\n" + "order by id desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public List<Product> get4AdidasLast() {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from Product\r\n" + "where cateID = 1\r\n" + "order by id desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	public List<Product> get4BitisLast() {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from Product\r\n" + "where cateID = 3\r\n" + "order by id desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	public List<Product> get4ConverseLast() {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from Product\r\n" + "where cateID = 4\r\n" + "order by id desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
		}
		return list;

	}

	@Override
	public void deleteProduct(String pid) {
		String query = "delete from Product\n" + "where [id] = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, pid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void deleteProductBySellID(String id) {
		String query = "delete from Product\n" + "where [sell_ID] = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void insertProduct(Product product) {
		String query = "insert Product(name,image,price,title,description,cateID,sell_ID,model,color,delivery,image2,image3,image4)\r\n"
				+ "values(?,?,?,?,?,?,1,?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getImage());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getTitle());
			ps.setString(5, product.getDescription());
			ps.setInt(6, product.getCateID());
			ps.setString(7, product.getModel());
			ps.setString(8, product.getColor());
			ps.setString(9, product.getDelivery());
			ps.setString(10, product.getImage2());
			ps.setString(11, product.getImage3());
			ps.setString(12, product.getImage4());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editProduct(Product product) {
		String query = "update Product set name = ?,image = ?,price = ?,title = ?,description =? ,cateID = ?,model= ?, color= ?,\r\n"
				+ "delivery= ?,image2=?,image3= ?,image4= ? where id = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getImage());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getTitle());
			ps.setString(5, product.getDescription());
			ps.setInt(6, product.getCateID());
			ps.setString(7, product.getModel());
			ps.setString(8, product.getColor());
			ps.setString(9, product.getDelivery());
			ps.setString(10, product.getImage2());
			ps.setString(11, product.getImage3());
			ps.setString(12, product.getImage4());
			ps.setInt(13, product.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertProductBySellID(Product product, int sellID) {
		String query = "insert Product(name,image,price,title,description,cateID,sell_ID,model,color,delivery,image2,image3,image4)\r\n"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getImage());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getTitle());
			ps.setString(5, product.getDescription());
			ps.setInt(6, product.getCateID());
			ps.setInt(7, sellID);
			ps.setString(8, product.getModel());
			ps.setString(9, product.getColor());
			ps.setString(10, product.getDelivery());
			ps.setString(11, product.getImage2());
			ps.setString(12, product.getImage3());
			ps.setString(13, product.getImage4());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*----- PAGING ---- */

	public int countCid(Integer cid) {
		String sql = "SELECT count(*) from Product Where cateID = ?";

		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<Product> pagingProduct(int index) {
		List<Product> list = new ArrayList<Product>();
		String sql = "Select * from Product order by id OFFSET ? ROW fetch next 6 row only";
		try {
			// mỏ kết nối database
			conn = new DBContext().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);

			ps.setInt(1, (index - 1) * 6);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();

			// lấy ResultSet đổ vào list
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Product> pagingSearch(String txtSearch, int index) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from Product where [name] like ? order by id OFFSET ? ROW fetch next 6 row only";
		try {
			// mỏ kết nối database
			conn = new DBContext().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, (index - 1) * 6);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();

			// lấy ResultSet đổ vào list
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Product> pagingProductByCID(int index, String cid) {
		List<Product> list = new ArrayList<Product>();
		String sql = "Select * from Product where cateID = ? order by id OFFSET ? ROW fetch next 6 row only ";
		try {
			// mỏ kết nối database
			conn = new DBContext().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);

			ps.setString(1, cid);
			ps.setInt(2, (index - 1) * 6);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();

			// lấy ResultSet đổ vào list
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Product> pagingProductBySellerID(int index, int sellID) {
		List<Product> list = new ArrayList<Product>();
		String sql = "Select * from Product where sell_ID = ? order by id OFFSET ? ROW fetch next 6 row only ";
		try {
			// mỏ kết nối database
			conn = new DBContext().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);

			ps.setInt(1, sellID);
			ps.setInt(2, (index - 1) * 6);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();

			// lấy ResultSet đổ vào list
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public int countSearch(String txtSearch) {
		String sql = "select count(*) from Product where [name] like ?";

		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + txtSearch + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
