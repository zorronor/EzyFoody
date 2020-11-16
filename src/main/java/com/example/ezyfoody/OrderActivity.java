package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class OrderActivity extends AppCompatActivity {
    TextView textView;
    int quantity = 0;
    Food food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("EzyFoody: Order");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView OrderFoodName =findViewById(R.id.orderfoodname);
        TextView OrderFoodPrice =findViewById(R.id.orderfoodprice);

        Bundle bundle = getIntent().getBundleExtra("food");
        food = (Food)bundle.getSerializable("food");

        OrderFoodName.setText("Food: " + food.getName());
        OrderFoodPrice.setText("Price" + food.getPrice());

        Button ButtonMyOrder = findViewById(R.id.myorderbutton);
        Button ButtonOrderMore = findViewById(R.id.ordermorebutton);

        ButtonMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((OrderList) getApplication()).changeQuantity(getIntent().getIntExtra("position", 0), quantity);
                Intent intent = new Intent(OrderActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });

        ButtonOrderMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((OrderList) getApplication()).changeQuantity(getIntent().getIntExtra("position", 0), quantity);
                Intent intent = new Intent(OrderActivity.this, FoodActivity.class);

                Bundle bundle = new Bundle();

                startActivity(intent);
            }
        });
    }

    public void increment(View view) {
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1;
        display(quantity);
        food.setQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
        food.setQuantity(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityview);
        quantityTextView.setText("" + number);
    }

}