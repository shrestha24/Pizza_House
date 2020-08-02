package com.example.pizza_house.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.pizza_house.Model.CartItem;
import com.example.pizza_house.Model.CartItem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

    @Database(entities = {CartItem.class}, version = 2, exportSchema = false)
    public abstract class CartDB extends RoomDatabase {

        public abstract AddtoCartDAO addtoCartDao();

        protected static volatile CartDB INSTANCE;
        private static final int NUMBER_OF_THREADS = 4;

        public static ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        public static CartDB getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (CartItem.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                CartDB.class, "cart_db").
                                fallbackToDestructiveMigration().build();

                    }
                }
            }
            return INSTANCE;
        }

        private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);

            }
        };
    }

