package hcmute.edu.vn.mssv18110299.data.repository;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabaseApplication;
import hcmute.edu.vn.mssv18110299.data.Store;
import hcmute.edu.vn.mssv18110299.data.dao.StoreDao;

public class StoreRepository {

    private StoreDao storeDao;
    public StoreRepository(){
        storeDao = MiniMarketDatabaseApplication.GetDatabase().storeDao();
    }

    public ArrayList<Store> GetAll()
    {
        return new ArrayList<>(storeDao.GetAllStores());
    }

    public List<Item> GetItemsAll(int id)
    {
        return MiniMarketDatabaseApplication.GetDatabase().itemDao().GetAllItemsById(id);
    }
}
