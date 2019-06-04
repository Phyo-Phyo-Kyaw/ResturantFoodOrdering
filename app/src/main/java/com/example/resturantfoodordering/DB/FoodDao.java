package com.example.resturantfoodordering.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class FoodDao {
    private FoodDbHelper dbHelper;
    private Context context;
    public FoodDao(Context context){
        this.context=context;
        dbHelper=new FoodDbHelper(context);
    }


    public long Insert(String name,String price,int image,String type,String cate){
        // Gets the data repository in write mode

        SQLiteDatabase db = dbHelper.getWritableDatabase();


// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FoodContract.FoodEntry.item_Name,name);
        values.put(FoodContract.FoodEntry.item_Price,price);
        values.put(FoodContract.FoodEntry.item_Image, image);
        //values.put(FoodContract.FoodEntry.Table_Number,TbNumber);
       // values.put(FoodContract.FoodEntry.item_Average,"23");
        values.put(FoodContract.FoodEntry.item_Type,type);
        values.put(FoodContract.FoodEntry.item_Category,cate);


// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FoodContract.FoodEntry.Table_Name, null, values);
        return newRowId;

    }

    public Cursor Select(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                FoodContract.FoodEntry.item_Name,
                FoodContract.FoodEntry.item_Price,
                FoodContract.FoodEntry.item_Image,
                //FoodContract.FoodEntry.Table_Number,
                FoodContract.FoodEntry.item_Type,
                FoodContract.FoodEntry.item_Category
        };

// Filter results WHERE "title" = 'My Title'
        //String selection = FoodContract.FoodEntry.item_Name + " = ?";


        Cursor cursor = db.query(
                FoodContract.FoodEntry.Table_Name,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        return cursor;
    }

    public Cursor Select(String Item_Type,String Item_categories){


        SQLiteDatabase db = dbHelper.getReadableDatabase();


// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                FoodContract.FoodEntry.item_id,
                FoodContract.FoodEntry.item_Name,
                FoodContract.FoodEntry.item_Price,
                FoodContract.FoodEntry.item_Image,
                //FoodContract.FoodEntry.Table_Number,
                FoodContract.FoodEntry.item_Type,
                FoodContract.FoodEntry.item_Category
        };

// Filter results WHERE "title" = 'My Title'
        String selection = FoodContract.FoodEntry.item_Type + " = ? AND "+FoodContract.FoodEntry.item_Category + " = ?";

        String selectionArgs[]={Item_Type,Item_categories};


        Cursor cursor = db.query(
                FoodContract.FoodEntry.Table_Name,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        return cursor;

    }
    public Cursor Select(String Item_types){


        SQLiteDatabase db = dbHelper.getReadableDatabase();


// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                FoodContract.FoodEntry.item_id,
                FoodContract.FoodEntry.item_Name,
                FoodContract.FoodEntry.item_Price,
                FoodContract.FoodEntry.item_Image,
                //FoodContract.FoodEntry.Table_Number,
                FoodContract.FoodEntry.item_Type,
                FoodContract.FoodEntry.item_Category
        };

// Filter results WHERE "title" = 'My Title'
        String selection = FoodContract.FoodEntry.item_Type + " = ?";

        String selectionArgs[]={Item_types};


        Cursor cursor = db.query(
                FoodContract.FoodEntry.Table_Name,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        return cursor;

    }

    public long Delete(String name){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        // Define 'where' part of query.
        String selection = FoodContract.FoodEntry.item_Name + " LIKE ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = { name };
// Issue SQL statement.
        long deletedRows = db.delete(FoodContract.FoodEntry.Table_Name, selection, selectionArgs);
        return deletedRows;
    }

    public long Update(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

// New value for one column
        String title = "MyNewTitle";
        ContentValues values = new ContentValues();
        values.put(FoodContract.FoodEntry.item_Name, title);

// Which row to update, based on the title
        String selection = FoodContract.FoodEntry.item_Type + " LIKE ?";
        String[] selectionArgs = { "MyOldTitle" };

        return db.update(
                FoodContract.FoodEntry.Table_Name,
                values,
                selection,
                selectionArgs);
    }
}
