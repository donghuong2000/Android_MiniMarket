package hcmute.edu.vn.mssv18110299.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.adapter.CartItemAdapter;
import hcmute.edu.vn.mssv18110299.data.CartItem;
import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.repository.CartRepository;
import hcmute.edu.vn.mssv18110299.utilities.Session;

public class CartFragment extends Fragment {


    private ArrayList<CartItem> cartItems;
    private RecyclerView cartItemRecycle;
    private CartItemAdapter cartItemAdapter;
    private CartRepository cartRepository;
    private TextView subtotal,deliveryFee,total;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cartRepository = new CartRepository();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);
        cartItems = cartRepository.GetCartUser(new Session(getContext()).getUsername());

        subtotal = view.findViewById(R.id.sub_total);
        double s = cartItems.stream().mapToDouble(o-> o.getItem().getPrice()*o.getNum()).sum();
        subtotal.setText(s + " $");
        deliveryFee = view.findViewById(R.id.delivery_fee);
        total = view.findViewById(R.id.total);
        total.setText((s + 3) +" $");
        cartItemRecycle = view.findViewById(R.id.cart_items_recycle);
        cartItemAdapter = new CartItemAdapter(getContext(),cartItems,subtotal,total);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        cartItemRecycle.setLayoutManager(llm);
        cartItemRecycle.setAdapter(cartItemAdapter);
        return view;
    }

}