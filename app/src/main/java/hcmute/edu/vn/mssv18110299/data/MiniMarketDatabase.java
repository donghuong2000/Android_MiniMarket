package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import hcmute.edu.vn.mssv18110299.data.dao.CartDao;
import hcmute.edu.vn.mssv18110299.data.dao.ItemDao;
import hcmute.edu.vn.mssv18110299.data.dao.StoreDao;
import hcmute.edu.vn.mssv18110299.data.dao.UserDao;

@Database(entities={User.class,
        Item.class,
        Store.class,
        Cart.class,
        CartItem.class},
        version=1)
public abstract class MiniMarketDatabase extends RoomDatabase {
    // Database name to be used
    public static final String NAME = "MiniMarketDatabase";
    // Declare your data access objects as abstract
    public abstract UserDao userDao();
    public abstract ItemDao itemDao();
    public abstract StoreDao storeDao();
    public abstract CartDao cartDao();


}
