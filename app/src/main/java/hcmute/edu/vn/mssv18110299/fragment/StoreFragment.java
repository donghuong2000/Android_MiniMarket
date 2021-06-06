package hcmute.edu.vn.mssv18110299.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.adapter.StoreItemAdapter;
import hcmute.edu.vn.mssv18110299.data.Store;
import hcmute.edu.vn.mssv18110299.utilities.ImageSaver;

public class StoreFragment extends Fragment {

    private Store store;
    private StoreItemAdapter storeItemAdapter;
    private RecyclerView recyclerView;
    public StoreFragment() {
        // Required empty public constructor
    }
    public StoreFragment(Store store) {
        // Required empty public constructor
        this.store = store;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_store, container, false);
        TextView teview= view.findViewById(R.id.store_name);
        ImageView image=  view.findViewById(R.id.image_shop);
        image.setImageBitmap(new ImageSaver(getContext()).load(store.getImgUrl()));
        teview.setText(store.getName());
        recyclerView = view.findViewById(R.id.recycle_store_item);
        storeItemAdapter = new StoreItemAdapter(getContext(),new ArrayList<>(store.getItems()));
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(storeItemAdapter);
        return view;
    }
}