package com.example.pizza_house.repository;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.pizza_house.Model.Order;
import com.example.pizza_house.Model.User;
import com.example.pizza_house.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseRepo {
    Context context;
    public FirebaseRepo(Application application) {
        context=application.getApplicationContext();
    }

    public void uploadProfile(User user){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("USER");
        myRef.child(user.getUid()).child("Profile").setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(context, "SUCCESSFULLY UPLOADED", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void uploadOrder(Order order, String uid){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("USER").child(uid).child("ORDER");
        myRef.push().child(Integer.toString(order.getOrderNo())).setValue(order).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(context, "Successfully Uploaded", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
