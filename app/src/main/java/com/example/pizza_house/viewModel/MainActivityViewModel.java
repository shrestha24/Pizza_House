package com.example.pizza_house.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.itemsdata.Category;
import com.example.pizza_house.repository.MainActivityRepo;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MainActivityRepo mainActivityRepo;
    private Context context;
    LiveData<List<Category>> mLivedata;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mainActivityRepo=new MainActivityRepo();
        this.context=application.getApplicationContext();
        this.mLivedata=mainActivityRepo.getCategoryResult(context);
    }

    public LiveData<List<Category>> getmLivedata() {
        this.mLivedata=mainActivityRepo.getCategoryResult(context);
        return mLivedata;
    }
}

