package com.example.pizza_house.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.itemsdata.Items;
import com.example.pizza_house.Model.CartItem;
import com.example.pizza_house.repository.CartRepo;

import java.util.List;

public class ItemListActivityViewModel extends AndroidViewModel {
    private CartRepo cartRepo;
    private Context context;
    LiveData<List<Items>> mLivedata;
    public ItemListActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
        this.cartRepo=new CartRepo(application);


    }
    public void insert(CartItem cartItem){
        cartRepo.insert(cartItem);
    }
    public LiveData<List<Items>> getItemList1(String category){
        mLivedata=cartRepo.getItemList(context,category);
        return mLivedata;
    }

}
