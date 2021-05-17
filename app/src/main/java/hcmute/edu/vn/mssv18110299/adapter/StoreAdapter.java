package hcmute.edu.vn.mssv18110299.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.data.Store;
import hcmute.edu.vn.mssv18110299.data.repository.ItemRepository;
import hcmute.edu.vn.mssv18110299.data.repository.StoreRepository;
import hcmute.edu.vn.mssv18110299.fragment.StoreFragment;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Store> stores;

    public  StoreAdapter(Context context,ArrayList<Store> stores){
        this.context = context;
        this.stores = stores;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
        View bigCartItem = inflater.inflate(R.layout.big_card_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(bigCartItem);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Store store = stores.get(position);
        //ToDO load image for Recycle View
        holder.name.setText(store.getName());
        holder.voteScore.setText(String.valueOf(store.getVotedScore()));
        holder.location.setText("1");
        holder.itemView.setOnClickListener(v->{
            AppCompatActivity appCompatActivity =(AppCompatActivity)v.getContext();
            store.setItems(new StoreRepository().GetItemsAll(store.getId()));
            StoreFragment storeFragment = new StoreFragment(store);
            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.replace,storeFragment).addToBackStack(null).commit();
        });

    }

    @Override
    public int getItemCount() {
        return stores.size();
    }


}
