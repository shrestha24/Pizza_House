package com.example.pizza_house.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.pizza_house.repository.CartRepo;

public class DeliveryActivityViewModel extends AndroidViewModel {
    CartRepo cartRepo;
    public DeliveryActivityViewModel(@NonNull Application application) {
        super(application);
        cartRepo=new CartRepo(application);
    }
    public void deleteAll(){
        cartRepo.deleteall();
    }
}
