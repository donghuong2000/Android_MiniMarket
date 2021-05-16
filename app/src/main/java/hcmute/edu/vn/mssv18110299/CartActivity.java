package hcmute.edu.vn.mssv18110299;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.adapter.CartItemAdapter;
import hcmute.edu.vn.mssv18110299.data.CartItem;
import hcmute.edu.vn.mssv18110299.data.Item;

public class CartActivity extends AppCompatActivity {
    private ArrayList<CartItem> cartItems;
    private RecyclerView cartItemRecycle;
    private CartItemAdapter cartItemAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cartItems = new ArrayList<>();
        CreateCartItemList();
        cartItemRecycle = findViewById(R.id.cart_items_recycle);
        cartItemAdapter = new CartItemAdapter(this,cartItems);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        cartItemRecycle.setLayoutManager(llm);
        cartItemRecycle.setAdapter(cartItemAdapter);

    }

    private void CreateCartItemList(){

        Item a = new Item("A",1,1,1,"A","1",1,1);
        cartItems.add( new CartItem(1,1,1, a));
        Item b = new Item("B",1,1,1,"A","1",1,1);
        cartItems.add( new CartItem(1,1,10, b));
    }
}
