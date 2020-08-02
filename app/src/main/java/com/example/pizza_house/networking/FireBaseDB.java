package com.example.pizza_house.networking;

import android.os.AsyncTask;

import androidx.loader.content.AsyncTaskLoader;

import com.example.pizza_house.Model.Order;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.channels.AsynchronousChannelGroup;

public class FireBaseDB extends AsyncTask<Order,Void,Boolean> {


    private static final String TAG=FireBaseDB.class.getSimpleName();


    @Override
    protected Boolean doInBackground(Order... orders) {
        Order order=orders[0];
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("USER").child("ORDER");
        return myRef.child(order.getZip()).push().setValue(order).isSuccessful();
    }
}
