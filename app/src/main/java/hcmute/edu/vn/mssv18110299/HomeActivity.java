package hcmute.edu.vn.mssv18110299;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.adapter.ItemAdapter;
import hcmute.edu.vn.mssv18110299.adapter.StoreAdapter;
import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.Store;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<Store> stores;
    private ArrayList<Item> items;
    private RecyclerView recyclerStore;
    private StoreAdapter storeAdapter;
    private RecyclerView recyclerItem;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        //set recycle store
        recyclerStore = findViewById(R.id.storeRecycle);
        stores = new ArrayList<>();
        CreateStoreList();
        storeAdapter = new StoreAdapter(this,stores);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerStore.setLayoutManager(llm);
        recyclerStore.setAdapter(storeAdapter);
        //set recycle Item
        recyclerItem = findViewById(R.id.itemRecycle);
        items = new ArrayList<>();
        CreateItemList();
        itemAdapter = new ItemAdapter(this,items);
        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        llm2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerItem.setLayoutManager(llm2);
        recyclerItem.setAdapter(itemAdapter);
        // set toolbar action
        ImageView toolbar = findViewById(R.id.btnSideBar);







    }
    private void CreateStoreList(){
        stores.add(new Store("A",1,"A","A"));
        stores.add(new Store("B",2,"B","B"));
        stores.add(new Store("C",3,"C","C"));
        stores.add(new Store("D",4,"D","D"));
        stores.add(new Store("E",5,"E","E"));
    }
    private void CreateItemList(){
        items.add(new Item("A",1,1,1,"A","A",1,1));
        items.add(new Item("A",1,1,1,"A","A",1,1));
        items.add(new Item("A",1,1,1,"A","A",1,1));
        items.add(new Item("A",1,1,1,"A","A",1,1));
        items.add(new Item("A",1,1,1,"A","A",1,1));
    }
}
