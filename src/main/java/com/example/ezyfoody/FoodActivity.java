package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    ArrayList<Food> listFood;
    RecyclerView rvFoods;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("EzyFoody: Food List");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Button MyOrderButton = findViewById(R.id.myorderbutton);
        MyOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });

        rvFoods = findViewById(R.id.rvfood);
        rvFoods.setLayoutManager(new GridLayoutManager(this, 2));

        adapter = new FoodAdapter(this, ((OrderList) this.getApplication()).getListFood());
        rvFoods.setAdapter(adapter);
    }
}