package hcmute.edu.vn.mssv18110299.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.mssv18110299.data.CartItem;
import hcmute.edu.vn.mssv18110299.data.ItemCategory;


@Dao
public interface ItemCategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddItemCategory(ItemCategory ItemCategory);

    @Query(value = "SELECT * FROM ItemCategory")
    List<ItemCategory> GetAllItemCategory();

    @Query(value = "SELECT * FROM ItemCategory WHERE ItemId =:ItemId")
    ItemCategory GetItemCategory(int ItemId);

    @Update
    void updateItemCategory(ItemCategory... ItemCategory);

    @Delete
    void DeleteItemCategory(ItemCategory ItemCategory);
}
