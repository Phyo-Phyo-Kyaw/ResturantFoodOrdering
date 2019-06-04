package com.example.resturantfoodordering.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.resturantfoodordering.DB.FoodDao;
import com.example.resturantfoodordering.R;

public class InsertActivity extends AppCompatActivity {
    private EditText etName,etPrice,etType,etCategory;
    private FoodDao foodDao;
    private Intent intent;
    private String tableNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        etName=findViewById(R.id.etName);
        etPrice=findViewById(R.id.etPrice);
        etType=findViewById(R.id.etType);
        etCategory=findViewById(R.id.etCategory);
        foodDao=new FoodDao(InsertActivity.this);
        intent=getIntent();
        tableNumber=intent.getStringExtra("name");
    }

    public void ClickSave(View view) {
        long row=foodDao.Insert((etName.getText()).toString(),(etPrice.getText()).toString(),R.drawable.food,etType.getText().toString(),etCategory.getText().toString());
        if(row>0){
            Log.i("Phyo","Found");
        }else
            Log.i("Phyo","Not Found");
    }
}
