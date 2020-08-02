package com.example.itemsdata;

public class Category {
    private String description;
    private String imageUrl;
    private String itemName;

    public Category(String description, String imageUrl, String itemName) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.itemName = itemName;
    }

    public Category() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}