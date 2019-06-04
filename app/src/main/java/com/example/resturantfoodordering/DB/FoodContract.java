package com.example.resturantfoodordering.DB;

import android.provider.BaseColumns;

public class FoodContract  {
    private FoodContract(){}

    public class FoodEntry implements BaseColumns{

        public static final String item_id ="_id";
        public static final String Table_Name="food";
        public static final String item_Name="name";
        public static final String  item_Price="Price";
        public static final String item_Image="Image";
        //public static final String  Table_Number="TableNumber";
        public static final String item_Type="Type";
        public static final String item_Category="Category";

    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FoodEntry.Table_Name + " (" +
                    FoodEntry.item_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FoodEntry.item_Name+" TEXT,"+ FoodEntry.item_Price+
                    " TEXT, "+ FoodEntry.item_Image+" INTEGER, "+
                    FoodEntry.item_Type+" TEXT, "+
                    FoodEntry.item_Category+" TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FoodEntry.Table_Name;
}
