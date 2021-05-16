package hcmute.edu.vn.mssv18110299.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import hcmute.edu.vn.mssv18110299.data.Item;
@Dao
public interface ItemDao {
    //get all
    @Query(value = "SELECT * FROM item ")
    List<Item> GetAllItems();
    //Get
    @Query(value = "SELECT * FROM item WHERE Id = :id")
    Item GetItem(int id);
    // create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddItem(Item item);
    // update
    @Update
    void UpdateItem(Item...item);
    @Delete
    void DeleteItem(Item item);
}
