package hcmute.edu.vn.mssv18110299.data.repository;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabase;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabaseApplication;
import hcmute.edu.vn.mssv18110299.data.dao.ItemDao;

public class ItemRepository {
    private ItemDao itemDao;

    public ItemRepository(){
        itemDao = MiniMarketDatabaseApplication.GetDatabase().itemDao();
    }



    public ArrayList<Item> GetAll(){
        return new ArrayList<>(itemDao.GetAllItems());
    }

}
