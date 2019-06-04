package com.example.resturantfoodordering.models;

public class Food {
    public String itemName,itemType,itemCategory;
    public String  itemPrice,itemQuantity;
    public int itemImage;
    public String  itemAverage;

    public Food(String itemName, String  itemPrice, int itemImage, String itemType, String itemCategory) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.itemType = itemType;
        this.itemCategory = itemCategory;


    }
}
