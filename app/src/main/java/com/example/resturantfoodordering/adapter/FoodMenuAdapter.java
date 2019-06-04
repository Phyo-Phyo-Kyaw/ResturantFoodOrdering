package com.example.resturantfoodordering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.resturantfoodordering.R;
import com.example.resturantfoodordering.models.Food;

import java.util.List;

public class FoodMenuAdapter extends ArrayAdapter {
    private Context context;
    private List<Food> foodList;
    public FoodMenuAdapter(Context context, int resource, List<Food> foodList) {
        super(context, resource);
        this.context=context;
        this.foodList=foodList;
    }
    @Override
    public int getCount() {
        if(foodList!=null)
            return foodList.size();
        else
            return 0;
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
        convertView=inflater.inflate(R.layout.food_row,parent,false);
        Food food=foodList.get(position);
        TextView name=convertView.findViewById(R.id.name);
        name.setText(food.itemName);
        TextView price=convertView.findViewById(R.id.price);
        price.setText(food.itemPrice);
        ImageView imageView=convertView.findViewById(R.id.image);
        imageView.setImageResource(R.drawable.food);

        return convertView;
    }
}
