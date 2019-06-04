package com.example.resturantfoodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.resturantfoodordering.adapter.GridAdapter;
import com.example.resturantfoodordering.ui.MenuActivity;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private String[] name={"Table1","Table2","Table3","Table4","Table5"};
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intView();
        gridView=findViewById(R.id.gridView);
        gridView.setAdapter(new GridAdapter(MainActivity.this,R.layout.table_name_row,name));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("name", name[position]);
                startActivity(intent);
            }
        });
    }

    private void intView() {

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
