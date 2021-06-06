package hcmute.edu.vn.mssv18110299.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.adapter.CartItemAdapter;
import hcmute.edu.vn.mssv18110299.data.CartItem;
import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.model.ResponseModel;
import hcmute.edu.vn.mssv18110299.data.repository.CartRepository;
import hcmute.edu.vn.mssv18110299.utilities.Session;

public class CartFragment extends Fragment {


    private ArrayList<CartItem> cartItems;
    private RecyclerView cartItemRecycle;
    private CartItemAdapter cartItemAdapter;
    private CartRepository cartRepository;
    private TextView subtotal,deliveryFee,total;
    private MaterialButton btn_checkout;
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
        btn_checkout = view.findViewById(R.id.btn_checkout);
        btn_checkout.setOnClickListener(v->new MaterialAlertDialogBuilder(getContext(),R.style.ThemeOverlay_MaterialComponents_Dialog_Alert)
                .setTitle("Pay an order")
                .setMessage("Do you want pay this bill")
                .setNegativeButton("Cancel",((dialog, which) -> {
                    //do
                }))
                .setPositiveButton("CheckOut", (dialog, which) -> {
                    //CheckOut
                    ResponseModel md = new CartRepository().checkout(new Session(getContext()).getUsername());
                    Toast.makeText(getContext(),md.message,Toast.LENGTH_LONG).show();
                    if(md.isSuccess){
                       //todo: redirect bill
                        cartItems.clear();
                        cartItemAdapter.notifyDataSetChanged();
                    }
                    else {
                        // do nothing
                    }

                })
                .show());


        return view;
    }

}