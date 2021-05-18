package hcmute.edu.vn.mssv18110299.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.model.ResponseModel;
import hcmute.edu.vn.mssv18110299.data.repository.CartRepository;
import hcmute.edu.vn.mssv18110299.utilities.Session;

public class StoreItemAdapter extends RecyclerView.Adapter<StoreItemAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Item> items;

    public StoreItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView itemImage;
        TextView itemPrice,itemName;
        ImageView btnPlus;

        public ViewHolder(@NotNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemName = itemView.findViewById(R.id.item_name);
            btnPlus = itemView.findViewById(R.id.btn_item_plus);
        }
    }
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View ItemStore = inflater.inflate(R.layout.view_store_item,parent,false);

        StoreItemAdapter.ViewHolder viewHolder = new StoreItemAdapter.ViewHolder(ItemStore);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( @NotNull StoreItemAdapter.ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText(String.valueOf(item.getPrice()));
        //todo: Load image
        holder.btnPlus.setOnClickListener(v-> {
            //addToCart
            String username =  new Session(context).getUsername();
            ResponseModel md =  new CartRepository().addToCart(username,item);
            Toast.makeText(context,md.message,Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
