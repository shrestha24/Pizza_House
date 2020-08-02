package com.example.pizza_house.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.itemsdata.Items;
import com.example.pizza_house.Model.CartItem;
import com.example.pizza_house.Model.Order;
import com.example.pizza_house.R;
import com.example.pizza_house.adapter.ItemListAdapter;
import com.example.pizza_house.viewModel.ItemListActivityViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.pizza_house.utils.Constant.CATEGORY;

public class ItemListActivity extends AppCompatActivity implements ItemListAdapter.ListItemClickListener {


    @BindView(R.id.listItemrecycler)
    RecyclerView listItemrecycler;
    ItemListAdapter listItemAdapter;
    List<Items> mlists = new ArrayList<>();
    ItemListActivityViewModel itemListActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String category=intent.getStringExtra(CATEGORY);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        listItemrecycler.setLayoutManager(linearLayoutManager);
        listItemrecycler.setHasFixedSize(true);
        listItemAdapter=new ItemListAdapter(this,this);
        listItemrecycler.setAdapter(listItemAdapter);
        itemListActivityViewModel= ViewModelProviders.of(this).get(ItemListActivityViewModel.class);
        itemListActivityViewModel.getItemList1(category).observe(this,new Observer<List<Items>>() {
            @Override
            public void onChanged(List<Items> items) {
                listItemAdapter.setmList(items);
                mlists.addAll(items);
            }
        });

    }
    public void fabButton(View view) {
        Intent intent=new Intent(ItemListActivity.this,LoginActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setSharedElementEnterTransition(new Explode());
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }else{
            startActivity(intent);
        }
        startActivity(intent);
    }

    @Override
    public void onListItemClick(int clickedIndex, int subIndex) {
        Items object=mlists.get(clickedIndex);
        float price=0;
        price=object.getPrice()*subIndex;
        CartItem cartItem=new CartItem(object.getItemName(),object.getPrice(),subIndex,price);
        itemListActivityViewModel.insert(cartItem);
        Toast.makeText(this, "SUccess", Toast.LENGTH_SHORT).show();
    }
}