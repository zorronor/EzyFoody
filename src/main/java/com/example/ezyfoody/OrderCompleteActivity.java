package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
        setTitle("EzyFoody: Order Complete");

        TextView viewTotalPrice = findViewById(R.id.viewtotalprice);

        viewTotalPrice.setText(((OrderList) this.getApplication()).calculatePrice() + "");

        Button HomeButton = findViewById(R.id.myorderbutton);

        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompleteActivity.this, MainActivity.class   );
                ((OrderList) getApplication()).resetData();
                startActivity(intent);
            }
        });
    }
}