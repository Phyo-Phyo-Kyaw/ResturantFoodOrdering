package com.example.resturantfoodordering.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resturantfoodordering.R;

public class MenuActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private String tableNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();




    }

    private void initView() {
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent=getIntent();
        tableNumber=intent.getStringExtra("name");
    }

    public void foodDetail(View view) {
        Intent intent=new Intent(MenuActivity.this,FoodActivity.class);
        intent.putExtra("TNo",tableNumber);
        intent.putExtra("type",((TextView)findViewById(R.id.food)).getText().toString());
        startActivity(intent);
    }

    public void drinkDetail(View view) {
        Intent intent=new Intent(MenuActivity.this,FoodActivity.class);
        intent.putExtra("TNo",tableNumber);
        intent.putExtra("type",((TextView)findViewById(R.id.drink)).getText().toString());
        startActivity(intent);
    }

    public void Click(View view) {
        Intent intent=new Intent(MenuActivity.this,InsertActivity.class);
        intent.putExtra("TNo",tableNumber);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:this.finish();break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate();
        return super.onCreateOptionsMenu(menu);
    }
}
