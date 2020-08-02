package com.example.pizza_house.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza_house.Model.CartItem;
import com.example.pizza_house.Model.CartItem;
import com.example.pizza_house.R;
import com.example.pizza_house.utils.ItemListClickListener;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartAdapterViewHolder> {
    public static final String TAG=CartAdapter.class.getSimpleName();
    private Context context;

    private List<CartItem> mList;
    final private ItemListClickListener mOnClickListener;

    public CartAdapter(Context context, ItemListClickListener mOnClickListener) {
        this.context = context;
        this.mList = new ArrayList<>();
        this.mOnClickListener = mOnClickListener;

    }
    public void setmList(List<CartItem> mList){
        this.mList=mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.cart_items_details, parent, false);
        return new CartAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapterViewHolder holder, int position) {
        CartItem object=mList.get(position);
        holder.name.setText(object.getName());
        holder.qty.setText(Integer.toString(object.getQty()));
        holder.rate.setText("$"+Float.toString(object.getRate()));
        Float total=object.getQty()*object.getRate();
        holder.total.setText("$"+Float.toString(total));


    }

    @Override
    public int getItemCount() {
        Log.e(TAG,Integer.toString(mList.size()));
        try {
            return mList.size();
        }catch (Exception e){
            return  0;
        }
    }

    public class CartAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name,qty,rate,total;
        Button remove;
        public CartAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.itemName);
            qty=itemView.findViewById(R.id.qty);
            rate=itemView.findViewById(R.id.rate);
            total=itemView.findViewById(R.id.total);
            remove=itemView.findViewById(R.id.removeitem);
            remove.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int clickedposition=getAdapterPosition();
            mOnClickListener.onListItemClick(clickedposition);
        }
    }
}
