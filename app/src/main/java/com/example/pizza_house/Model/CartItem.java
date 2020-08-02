package com.example.pizza_house.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

    @Entity(tableName = "cart")
    public class CartItem implements Parcelable {

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        private int id;
        @NonNull
        private String name;
        @NonNull
        private float rate;
        @NonNull
        private int qty;
        @NonNull
        private float price;

        public CartItem(int id, String name, float rate, int qty, float price) {
            this.id = id;
            this.name = name;
            this.rate = rate;
            this.qty = qty;
            this.price = price;
        }

        @Ignore
        public CartItem() {
        }

        @Ignore
        public CartItem(@NonNull String name, float rate, int qty, float price) {
            this.name = name;
            this.rate = rate;
            this.qty = qty;
            this.price = price;
        }

        @Ignore
        protected CartItem(Parcel in) {
            id = in.readInt();
            name = in.readString();
            rate = in.readFloat();
            qty = in.readInt();
            price = in.readFloat();
        }

        @Ignore
        public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
            @Override
            public CartItem createFromParcel(Parcel in) {
                return new CartItem(in);
            }

            @Override
            public CartItem[] newArray(int size) {
                return new CartItem[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @NonNull
        public String getName() {
            return name;
        }

        public void setName(@NonNull String name) {
            this.name = name;
        }

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        @Ignore
        @Override
        public int describeContents() {
            return 0;
        }

        @Ignore
        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(name);
            parcel.writeFloat(rate);
            parcel.writeInt(qty);
            parcel.writeFloat(price);
        }
    }
