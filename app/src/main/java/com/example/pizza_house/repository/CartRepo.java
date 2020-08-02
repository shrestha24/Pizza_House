package com.example.pizza_house.repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.itemsdata.Items;
import com.example.itemsdata.ItemsData;
import com.example.pizza_house.Model.CartItem;
import com.example.pizza_house.room.AddtoCartDAO;
import com.example.pizza_house.room.CartDB;

import java.util.List;

public class CartRepo {
    private AddtoCartDAO addtoCartDao;
    private LiveData<List<Items>> mList;

    public CartRepo(Application application) {
        CartDB db=CartDB.getDatabase(application);
        this.addtoCartDao = db.addtoCartDao();

    }
    public void insert(final CartItem cartItem){
        CartDB.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                addtoCartDao.insert(cartItem);
            }
        });


    }
    public LiveData<List<Items>> getItemList(Context context, String category) {
        final MutableLiveData<List<Items>> data=new MutableLiveData<>();
        ItemsData itemData=new ItemsData(category);
        data.setValue(itemData.getItemList());
        return data;
    }
    public void deleteall(){
        new deleteAllAsyncTask(addtoCartDao).execute();
    }
    private static class deleteAllAsyncTask extends AsyncTask<Void,Void,Void> {

        private AddtoCartDAO addtoCartDao;
        deleteAllAsyncTask(AddtoCartDAO addtoCartDao){
            this.addtoCartDao=addtoCartDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            addtoCartDao.deleteAll();
            return null;

        }
    }
}

