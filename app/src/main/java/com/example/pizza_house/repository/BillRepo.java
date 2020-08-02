package com.example.pizza_house.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.pizza_house.Model.CartItem;
import com.example.pizza_house.room.AddtoCartDAO;
import com.example.pizza_house.room.CartDB;

import java.util.List;

public class BillRepo {
    private AddtoCartDAO addtoCartDao;
    private LiveData<List<CartItem>> mlist;

    public BillRepo(Application application) {
        CartDB cartDatabase= CartDB.getDatabase(application);
        addtoCartDao=cartDatabase.addtoCartDao();
        mlist=addtoCartDao.getCartItems();
    }

    public LiveData<List<CartItem>> getMlist() {
        return mlist;
    }
    public void remove(final CartItem cartItem){
        CartDB.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                addtoCartDao.delete(cartItem);
            }
        });
    }
}
