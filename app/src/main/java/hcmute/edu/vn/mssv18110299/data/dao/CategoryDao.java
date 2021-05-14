package hcmute.edu.vn.mssv18110299.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.mssv18110299.data.BillItem;
import hcmute.edu.vn.mssv18110299.data.Brand;
import hcmute.edu.vn.mssv18110299.data.Category;


@Dao
public interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddCategory(Category Category);

    @Query(value = "SELECT * FROM Category")
    List<Category> GetAllCategories();

    @Query(value = "SELECT * FROM Category WHERE Id =:Id")
    Category GetCategory(int Id);

    @Update
    void updateCategory(Category... Category);

    @Delete
    void DeleteCategory(Category Category);
}
