package hcmute.edu.vn.mssv18110299.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.data.CartItem;
import hcmute.edu.vn.mssv18110299.data.repository.CartRepository;
import hcmute.edu.vn.mssv18110299.utilities.ImageSaver;
import hcmute.edu.vn.mssv18110299.utilities.Session;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CartItem> cartItems;
    private TextView subTotal,Total;

    public CartItemAdapter(Context context, ArrayList<CartItem> cartItems, TextView subTotal, TextView total) {
        this.context = context;
        this.cartItems = cartItems;
        this.subTotal = subTotal;
        Total = total;
    }

    public CartItemAdapter(Context context, ArrayList<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemPrice,itemNum,itemName;
        ImageView btnMinus,btnPlus;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemNum = itemView.findViewById(R.id.number_of_item);
            itemName = itemView.findViewById(R.id.item_name);
            btnMinus = itemView.findViewById(R.id.btn_item_minus);
            btnPlus = itemView.findViewById(R.id.btn_item_plus);

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
         holder.itemImage.setImageBitmap(new ImageSaver(context).load(cartItem.getItem().getImgUrl()));
         holder.btnMinus.setOnClickListener(v->{
             CartItem ci = cartItems.get(position);


             int number = ci.getNum()-1;
             if(number<1){
                 //remove cart
                 //alert
                 new MaterialAlertDialogBuilder(context,R.style.ThemeOverlay_MaterialComponents_Dialog_Alert)
                         .setTitle("Remove this item from cart")
                         .setMessage("Do you want remove this item from your Cart")
                         .setNegativeButton("Cancel",((dialog, which) -> {
                             //do nothing
                         }))
                         .setPositiveButton("Remove", (dialog, which) -> {
                             cartItems.remove(position);
                             new CartRepository().deleteFromCart(ci);
                             this.notifyItemRemoved(position);
                             this.notifyItemRangeChanged(position, cartItems.size());
                         })
                         .show();
             }
             else {
                 ci.setNum(number);
                 new CartRepository().updateCart(ci);
                 this.notifyDataSetChanged();
             }
             UpdateCart();

         });
         holder.btnPlus.setOnClickListener(v->{
             CartItem ci = cartItems.get(position);
             ci.setNum(ci.getNum()+1);
             new CartRepository().updateCart(ci);
             this.notifyDataSetChanged();
             UpdateCart();
         });
         holder.itemPrice.setText(String.valueOf(cartItem.getItem().getPrice()));
    }



    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    private void UpdateCart(){
        double s = cartItems.stream().mapToDouble(o-> o.getItem().getPrice()*o.getNum()).sum();
        subTotal.setText(s + " $");
        Total.setText((s + 3) +" $");
    }
}
