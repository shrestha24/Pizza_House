package com.example.pizza_house.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.pizza_house.Model.User;
import com.example.pizza_house.repository.FirebaseRepo;

public class SignupActivityViewModel extends AndroidViewModel {
    FirebaseRepo fireBaseRepo;
    public SignupActivityViewModel(@NonNull Application application) {
        super(application);
        fireBaseRepo=new FirebaseRepo(application);

    }
    public void UploadUsers(User user){
        fireBaseRepo.uploadProfile(user);
    }
}
