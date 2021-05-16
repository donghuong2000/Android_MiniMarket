package hcmute.edu.vn.mssv18110299.data.repository;

import java.util.ArrayList;

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
}
