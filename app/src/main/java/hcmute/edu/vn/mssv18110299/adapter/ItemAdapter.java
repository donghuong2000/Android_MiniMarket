package hcmute.edu.vn.mssv18110299.adapter;

import android.content.Context;
import android.content.DialogInterface;
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
import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.Store;
import hcmute.edu.vn.mssv18110299.data.model.ResponseModel;
import hcmute.edu.vn.mssv18110299.data.repository.CartRepository;
import hcmute.edu.vn.mssv18110299.utilities.Session;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Item> items;
    public ItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView location;
        TextView voteScore;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.storeName);
            location = itemView.findViewById(R.id.location);
            voteScore = itemView.findViewById(R.id.voteScore);
        }

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View smallCartItem = inflater.inflate(R.layout.small_card_item,parent,false);

        ViewHolder viewHolder = new ViewHolder(smallCartItem);

        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        //ToDO load image for Recycle View

        // add event
        holder.name.setText(item.getName());
        holder.voteScore.setText(String.valueOf(item.getVotedScore()));
        holder.location.setText("1");
        holder.itemView.setOnClickListener(v-> new MaterialAlertDialogBuilder(context,R.style.ThemeOverlay_MaterialComponents_Dialog_Alert)
                .setTitle("Add to Cart")
                .setMessage("Do you want add this item in your Cart")
                .setNegativeButton("Cancel",((dialog, which) -> {
                    //do
                }))
                .setPositiveButton("Add to Cart", (dialog, which) -> {
                    //addToCart
                    String username =  new Session(context).getUsername();
                    ResponseModel md =  new CartRepository().addToCart(username,item);
                    Toast.makeText(context,md.message,Toast.LENGTH_SHORT).show();
                })
                .show());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
