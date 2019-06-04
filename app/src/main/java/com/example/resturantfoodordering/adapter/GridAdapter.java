package com.example.resturantfoodordering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.resturantfoodordering.R;

public class GridAdapter extends ArrayAdapter {

    private Context context;
    private String[] tablerow;



    public GridAdapter(Context context,int ResourceId, String[] tablerow) {
        super(context,ResourceId,tablerow);
        this.context = context;
        this.tablerow = tablerow;
    }


    @Override
    public int getCount() {
        return tablerow.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.table_name_row,parent,false);
        TextView textView=convertView.findViewById(R.id.textView);
        textView.setText(tablerow[position]);
        return convertView;
    }
}
