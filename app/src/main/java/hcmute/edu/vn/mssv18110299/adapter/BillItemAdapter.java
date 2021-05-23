package hcmute.edu.vn.mssv18110299.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.data.Bill;
import hcmute.edu.vn.mssv18110299.data.BillItem;

public class BillItemAdapter extends RecyclerView.Adapter<BillItemAdapter.ViewHolder> {
        private Context context;
        private ArrayList<Bill> bills;

    public BillItemAdapter(Context context, ArrayList<Bill> bills) {
        this.context = context;
        this.bills = bills;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView orderId,dateCreate,totalPrice;

        public ViewHolder( @NotNull View itemView) {
            super(itemView);
            orderId = itemView.findViewById(R.id.order_view_id);
            dateCreate = itemView.findViewById(R.id.order_view_date_create);
            totalPrice = itemView.findViewById(R.id.order_view_total_price);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View order_item = inflater.inflate(R.layout.view_store_item,parent,false);
            ViewHolder viewHolder = new ViewHolder(order_item);
            return viewHolder;
    }

    @Override
    public void onBindViewHolder( @NotNull BillItemAdapter.ViewHolder holder, int position) {
            Bill item = bills.get(position);
            holder.orderId.setText(item.Id);
            holder.dateCreate.setText(item.DateCreate.toString());
            holder.totalPrice.setText(String.valueOf(item.Total));
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }


}

