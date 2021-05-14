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
import hcmute.edu.vn.mssv18110299.data.CartItem;


@Dao
public interface CartItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddCartItem(CartItem CartItem);

    @Query(value = "SELECT * FROM CartItem")
    List<CartItem> GetAllBrands();

    @Query(value = "SELECT * FROM CartItem WHERE CartId =:CartId")
    CartItem GetCartItem(int CartId);

    @Update
    void updateCartItem(CartItem... CartItem);

    @Delete
    void DeleteCartItem(CartItem CartItem);
}
