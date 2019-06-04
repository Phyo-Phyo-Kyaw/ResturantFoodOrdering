package com.example.resturantfoodordering.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.resturantfoodordering.R;

public class MenuDetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tvName,tvPrice,tvCount;
    private Button btnMinus,btnPlus,btnOrder,btnAddOrder;
    private Toolbar toolbar;
    private Intent intent;
    private String name,price;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        intView();
        intent=getIntent();
        name=intent.getStringExtra("name");
        price=intent.getStringExtra("price");
        TVSetText();

    }

    private void TVSetText() {
        tvName.setText(name);
        tvPrice.setText(price);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>=0)
                    tvCount.setText(++count+"");
                else if(count<0)
                    tvCount.setText("");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count>0)
                    tvCount.setText(--count+"");
                else if(count<=0)
                    tvCount.setText("");
            }
        });
    }

    private void intView(){
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView=findViewById(R.id.image);
        tvName=findViewById(R.id.name);
        tvPrice=findViewById(R.id.price);
        tvCount=findViewById(R.id.tvCount);
        btnMinus=findViewById(R.id.BtnMinus);
        btnPlus=findViewById(R.id.btnPlus);
        btnOrder=findViewById(R.id.Order);
        btnAddOrder=findViewById(R.id.AddOrder);

    }

}
