package ServicesImpl;

import java.util.List;

import DAO.ICategoryDAO;
import DAOImpl.CategoryDAOImpl;
import Services.CategoryServices;
import entity.Category;

public class CategoryServicesImpl implements CategoryServices {
	ICategoryDAO categoryDAO = new CategoryDAOImpl();

	@Override
	public List<Category> getAllCategory() {
		return categoryDAO.getAllCategory();
	}

	@Override
	public int getCateIDByProductID(String id) {
		return categoryDAO.getCateIDByProductID(id);
	}

}
