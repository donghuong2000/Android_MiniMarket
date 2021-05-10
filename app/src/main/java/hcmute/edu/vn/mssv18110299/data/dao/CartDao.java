package hcmute.edu.vn.mssv18110299.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.mssv18110299.data.Cart;


public interface CartDao {
    // insert Cart
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddCart(Cart cart);
    // get all Cart
    @Query(value = "SELECT * FROM Cart ORDER BY Id")
    LiveData<List<Cart>> GetAllCarts();
    // get Cart by id
    @Query(value = "SELECT * FROM Cart WHERE Id =:id")
    Cart GetCart(int id);
    // Cart Cart
    @Update
    void updateCart(Cart... cart);
    // delete Cart
    @Delete
    void DeleteCart(Cart cart);
}
