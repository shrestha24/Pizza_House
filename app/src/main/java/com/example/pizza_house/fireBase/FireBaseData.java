package com.example.pizza_house.fireBase;

import android.os.AsyncTask;

import com.example.pizza_house.Model.Order;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseData extends AsyncTask<Order,Void,Boolean> {
    private static final String TAG=FireBaseData.class.getSimpleName();
    @Override
    protected Boolean doInBackground(Order... orders) {
        Order order=orders[0];
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("USER").child("ORDER");
        return myRef.child(order.getZip()).push().setValue(order).isSuccessful();
    }
}
