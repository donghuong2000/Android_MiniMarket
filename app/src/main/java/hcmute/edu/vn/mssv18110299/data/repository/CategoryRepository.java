package hcmute.edu.vn.mssv18110299.data.repository;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.data.Category;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabaseApplication;
import hcmute.edu.vn.mssv18110299.data.dao.CategoryDao;

public class CategoryRepository {
    private CategoryDao categoryDao;

    public CategoryRepository() {
        categoryDao = MiniMarketDatabaseApplication.GetDatabase().categoryDao();
    }

    public ArrayList<Category> GetAll(){
        return new ArrayList<>(categoryDao.GetAllCategories());
    }
}
