package hcmute.edu.vn.mssv18110299.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.BitSet;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.adapter.BillItemAdapter;
import hcmute.edu.vn.mssv18110299.data.Bill;
import hcmute.edu.vn.mssv18110299.data.repository.BillRepository;
import hcmute.edu.vn.mssv18110299.utilities.Session;


public class TrackingFragment extends Fragment {

    private ArrayList<Bill> bills;
    private BillItemAdapter adapter;
    private RecyclerView recyclerView;
    public TrackingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tracking, container, false);
        recyclerView = view.findViewById(R.id.order_view_item);
        bills = new BillRepository().GetAllBillByUserName(new Session(getContext()).getUsername());
        adapter = new BillItemAdapter(getContext(),bills);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        return view;
    }
}