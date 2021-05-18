package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import hcmute.edu.vn.mssv18110299.data.dao.BillDao;
import hcmute.edu.vn.mssv18110299.data.dao.BillItemDao;
import hcmute.edu.vn.mssv18110299.data.dao.BrandDao;
import hcmute.edu.vn.mssv18110299.data.dao.CartDao;
import hcmute.edu.vn.mssv18110299.data.dao.CartItemDao;
import hcmute.edu.vn.mssv18110299.data.dao.CategoryDao;
import hcmute.edu.vn.mssv18110299.data.dao.ItemCategoryDao;
import hcmute.edu.vn.mssv18110299.data.dao.ItemDao;
import hcmute.edu.vn.mssv18110299.data.dao.RoleDao;
import hcmute.edu.vn.mssv18110299.data.dao.StoreDao;
import hcmute.edu.vn.mssv18110299.data.dao.UserDao;

@Database(entities={User.class,
        Item.class,
        Store.class,
        Cart.class,
        Bill.class,
        BillItem.class,
        Brand.class,
        Category.class,
        ItemCategory.class,
        Role.class,
        CartItem.class},
        version=3)
public abstract class MiniMarketDatabase extends RoomDatabase {
    // Database name to be used
    public static final String NAME = "MiniMarketDatabase.db";
    // Declare your data access objects as abstract
    public abstract BillDao billDao();
    public abstract BillItemDao billItemDao();
    public abstract BrandDao brandDao();
    public abstract CartItemDao cartItemDao();
    public abstract CategoryDao categoryDao();
    public abstract ItemCategoryDao itemCategoryDao();
    public abstract RoleDao roleDao();
    public abstract UserDao userDao();
    public abstract ItemDao itemDao();
    public abstract StoreDao storeDao();
    public abstract CartDao cartDao();


}
