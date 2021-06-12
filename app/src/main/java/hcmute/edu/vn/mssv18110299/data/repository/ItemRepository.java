package hcmute.edu.vn.mssv18110299.data.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.ItemCategory;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabase;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabaseApplication;
import hcmute.edu.vn.mssv18110299.data.dao.ItemDao;

public class ItemRepository {
    private ItemDao itemDao;
    private MiniMarketDatabase db;

    public ItemRepository(){
        db = MiniMarketDatabaseApplication.GetDatabase();
        itemDao = db.itemDao();
    }



    public ArrayList<Item> GetAll(){
        return new ArrayList<>(itemDao.GetAllItems());
    }
    public ArrayList<Item> GetAll(int categoryId)
    {
        if(categoryId<0)
            return GetAll();

        List<ItemCategory> itemCategoryList= db.itemCategoryDao().GetAllItemCategory();
        itemCategoryList = itemCategoryList.stream().filter(x->x.getCategoryId() == categoryId).collect(Collectors.toList());
        ArrayList<Item> result = new ArrayList<>();
        itemCategoryList.forEach(x-> result.add(db.itemDao().GetItem(x.getItemId())));
        return result;
    }

}
