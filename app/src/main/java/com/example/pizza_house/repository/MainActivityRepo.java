package com.example.pizza_house.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.itemsdata.CategoriesData;
import com.example.itemsdata.Category;

import java.util.List;

public class MainActivityRepo {
    public LiveData<List<Category>> getCategoryResult(Context context) {
        final MutableLiveData<List<Category>> data=new MutableLiveData<>();
        CategoriesData categoryData=new CategoriesData();
        data.setValue(categoryData.getListCategories());
        return data;
    }
}
