package com.example.itemsdata;

public class Items {
    String imageUrl;
    String description;
    String itemName;
    float price;

    public Items() {
    }

    public Items(String imageUrl, String description, String itemName, float price) {
        this.imageUrl = imageUrl;
        this.description = description;
        this.itemName = itemName;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
