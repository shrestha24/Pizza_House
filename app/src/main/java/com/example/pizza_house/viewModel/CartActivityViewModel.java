package com.example.pizza_house.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pizza_house.Model.CartItem;
import com.example.pizza_house.Model.CartItem;
import com.example.pizza_house.Model.Order;
import com.example.pizza_house.repository.BillRepo;
import com.example.pizza_house.repository.FirebaseRepo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class CartActivityViewModel extends AndroidViewModel {
    private BillRepo billingRepo;
    private FirebaseRepo fireBaseRepo;
    private LiveData<List<CartItem>> mList;
    private FirebaseAuth mAuth;
    public CartActivityViewModel(@NonNull Application application) {
        super(application);
        billingRepo=new BillRepo(application);
        fireBaseRepo=new FirebaseRepo(application);
        mList=billingRepo.getMlist();
        mAuth = FirebaseAuth.getInstance();
    }
    public void remove(CartItem cartItem){

        billingRepo.remove(cartItem);
    }

    public LiveData<List<CartItem>> getmList() {
        mList=billingRepo.getMlist();
        return mList;
    }
    public  void upload(Order order){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String uid = currentUser.getUid();
        fireBaseRepo.uploadOrder(order,uid);
    }


}
