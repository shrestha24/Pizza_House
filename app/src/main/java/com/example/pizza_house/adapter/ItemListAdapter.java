package com.example.pizza_house.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.itemsdata.Items;
import com.example.pizza_house.R;

import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ListItemHolder> {
    public static final String TAG=ItemListAdapter.class.getSimpleName();
    private Context context;
    private List<Items> mList;
    private ArrayAdapter<Integer> a1;
    private Integer ar[]={1,2,3,4,5};
    int pos=1;
    final private ListItemClickListener mOnClickListener;

    public ItemListAdapter(Context context, ListItemClickListener mOnClickListener1) {
        this.context = context;
        this.mList = new ArrayList<>();
        this.a1 = new ArrayAdapter<Integer>(context,android.R.layout.simple_spinner_item,ar);
        this.mOnClickListener = mOnClickListener1;
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }

    public void setmList(List<Items> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.items_detail_activity, parent, false);
        return new ListItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder holder, int position) {
        Items obj=mList.get(position);
        Glide.with(context).load(obj.getImageUrl()).into(holder.imageView);
        holder.imageView.setContentDescription(obj.getDescription());
        holder.textView.setText(obj.getItemName());
        holder.textView1.setText(Float.toString(obj.getPrice()));
        holder.textView2.setText(obj.getDescription());
        holder.spinner.setAdapter(a1);


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public interface ListItemClickListener {
        void onListItemClick(int clickedIndex,int subIndex);

    }

    public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        Spinner spinner;
        TextView textView;
        TextView textView2;
        Button button;
        TextView textView1;

        public ListItemHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageMain);
            spinner=itemView.findViewById(R.id.spinner);
            textView=itemView.findViewById(R.id.item_detail_title);
            button=itemView.findViewById(R.id.btnitemdetail);
            textView1=itemView.findViewById(R.id.price);
            textView2=itemView.findViewById(R.id.description);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    pos= (int) adapterView.getItemAtPosition(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            button.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int clicked=getAdapterPosition();
            mOnClickListener.onListItemClick(clicked,pos);

        }
    }

}
