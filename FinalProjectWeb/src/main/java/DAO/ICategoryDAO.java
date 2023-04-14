package DAO;

import java.util.List;

import entity.Category;

public interface ICategoryDAO {
	List<Category> getAllCategory();
	int getCateIDByProductID(String id);
}
