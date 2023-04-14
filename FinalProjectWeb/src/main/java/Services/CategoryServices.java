package Services;

import java.util.List;

import entity.Category;

public interface CategoryServices {
	List<Category> getAllCategory();
	int getCateIDByProductID(String id);
}
