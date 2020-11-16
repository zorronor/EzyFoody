package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MyOrderActivity extends AppCompatActivity {
    ArrayList<Food> listOrder;
    RecyclerView rvMyOrders;
    MyOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("EzyFoody: My Order");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        rvMyOrders = findViewById(R.id.rvorderfood);
        rvMyOrders.setLayoutManager(new LinearLayoutManager(this));

        Button PayNowButton = findViewById(R.id.paynowbutton);
        TextView TotalPrice = findViewById(R.id.viewtotalprice);

        TotalPrice.setText(((OrderList) this.getApplication()).calculatePrice() + "");

        PayNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyOrderActivity.this, OrderCompleteActivity.class);
                startActivity(intent);
            }
        });

        adapter = new MyOrderAdapter(this, ((OrderList) this.getApplication()).getQuantityFood());
        rvMyOrders.setAdapter(adapter);
    }
}