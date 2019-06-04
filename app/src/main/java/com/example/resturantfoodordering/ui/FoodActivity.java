package com.example.resturantfoodordering.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.resturantfoodordering.DB.FoodContract;
import com.example.resturantfoodordering.DB.FoodDao;
import com.example.resturantfoodordering.R;
import com.example.resturantfoodordering.adapter.FoodMenuAdapter;
import com.example.resturantfoodordering.models.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private GridView gridView;
    private FoodDao foodDao;
    private List<Food> foodList=new ArrayList<>();
    private String tableNo,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        initView();

    }
    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gridView=findViewById(R.id.gridView);
        Intent intent=getIntent();
        tableNo=intent.getStringExtra("TNo");
        type=intent.getStringExtra("type");
        foodDao=new FoodDao(FoodActivity.this);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(FoodActivity.this,MenuDetailActivity.class);
                i.putExtra("name",foodList.get(position).itemName);
                i.putExtra("price",foodList.get(position).itemPrice);
                startActivity(i);
            }
        });


    }

    public void Select(){

        Cursor cursor=foodDao.Select(type);


        while(cursor.moveToNext()) {
            String itemName = cursor.getString(
                    cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.item_Name));
            String itemPrice = cursor.getString(
                    cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.item_Price));
            int itemImage = cursor.getInt(
                    cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.item_Image));
           /* String itemQty = cursor.getString(
                    cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.item_Quantity));
            String itemAvg = cursor.getString(
                    cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.item_Average));
            String itemType = cursor.getString(
                    cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.item_Type));
            String itemCategory = cursor.getString(
                    cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.item_Category));*/
            foodList.add(new Food(itemName,itemPrice,itemImage,null,null));
        }

       gridView.setAdapter(new FoodMenuAdapter(FoodActivity.this,R.layout.food_row,foodList));

    }

    @Override
    protected void onResume() {
        super.onResume();
        Select();


    }
}
