package hcmute.edu.vn.mssv18110299.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.data.CartItem;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CartItem> cartItems;

    public CartItemAdapter(Context context, ArrayList<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemPrice,itemNum,itemName;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemNum = itemView.findViewById(R.id.number_of_item);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View ItemCart = inflater.inflate(R.layout.view_cart_item,parent,false);
        CartItemAdapter.ViewHolder viewHolder = new CartItemAdapter.ViewHolder(ItemCart);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         CartItem cartItem = cartItems.get(position);
         holder.itemName.setText(cartItem.getItem().getName());
         holder.itemNum.setText(String.valueOf(cartItem.getNum()));
         //TODO load image
         holder.itemPrice.setText(String.valueOf(cartItem.getItem().getPrice()));
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
