package com.example.pizza_house.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pizza_house.Model.CartItem;

import java.util.List;


    @Dao
    public interface AddtoCartDAO {
        @Insert
        void insert(CartItem cartItem);

        @Delete
        void delete(CartItem cartItem);

        @Query("DELETE FROM cart")
        void deleteAll();

        @Query("SELECT * FROM  cart ORDER BY id")
        LiveData<List<CartItem>> getCartItems();

    }
