package hcmute.edu.vn.mssv18110299.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.mssv18110299.data.Store;


@Dao
public interface StoreDao {
    // insert Store
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddStore(Store store);
    // get all Store
    @Query(value = "SELECT * FROM Store ORDER BY Id")
    List<Store> GetAllStores();
    // get Store by id
    @Query(value = "SELECT * FROM Store WHERE Id =:id")
    Store GetStore(int id);
    // update Store
    @Update
    void updateStore(Store... store);
    // delete Store
    @Delete
    void DeleteStore(Store store);
}
