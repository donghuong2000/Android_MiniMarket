package hcmute.edu.vn.mssv18110299.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.mssv18110299.HomeActivity;
import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.adapter.ItemAdapter;
import hcmute.edu.vn.mssv18110299.adapter.StoreAdapter;
import hcmute.edu.vn.mssv18110299.data.Category;
import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.Store;
import hcmute.edu.vn.mssv18110299.data.repository.CategoryRepository;
import hcmute.edu.vn.mssv18110299.data.repository.ItemRepository;
import hcmute.edu.vn.mssv18110299.data.repository.StoreRepository;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerItem;
    private ItemAdapter itemAdapter;
    private ArrayList<Item> items;
    private ItemRepository itemRepository;
    private int currentTab = -1;
    private ArrayList<Store> stores;
    private RecyclerView recyclerStore;
    private StoreAdapter storeAdapter;
    private StoreRepository storeRepository;
    private TabLayout tabLayoutCategory;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemRepository = new ItemRepository();
        storeRepository = new StoreRepository();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        recyclerItem = view.findViewById(R.id.itemRecycle);
        items = itemRepository.GetAll();
        itemAdapter = new ItemAdapter(getContext(),items);
        LinearLayoutManager llm2 = new LinearLayoutManager(getContext());
        llm2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerItem.setLayoutManager(llm2);
        recyclerItem.setAdapter(itemAdapter);

        recyclerStore = view.findViewById(R.id.storeRecycle);
        stores = storeRepository.GetAll();
        storeAdapter = new StoreAdapter(getContext(),stores);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerStore.setLayoutManager(llm);
        recyclerStore.setAdapter(storeAdapter);
        TabLayoutSetting(view);


        return view;
    }

    private void TabLayoutSetting(View view){
        tabLayoutCategory = view.findViewById(R.id.tab_category);
        ArrayList<Category> categories = new CategoryRepository().GetAll();

        TabLayout.Tab tabInit = tabLayoutCategory.newTab().setText("ALL");
        tabInit.setTag(-1);
        tabLayoutCategory.addTab(tabInit);// init tab all
        categories.forEach(item -> {
            TabLayout.Tab tab = tabLayoutCategory.newTab();
            tab.setText(item.getName());
            tab.setTag(item.getId());
            tabLayoutCategory.addTab(tab);
            tabLayoutCategory.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {

                    int tabId =(int) tab.getTag();
                    if(tabId != currentTab)
                    {
                        currentTab = tabId;
                        items = itemRepository.GetAll(tabId);
                        itemAdapter = new ItemAdapter(getContext(),items);
                        recyclerItem.swapAdapter(itemAdapter,false);
                    }

                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }

            });
        });
    }
}