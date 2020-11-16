package com.example.ezyfoody;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder>{

    Context ctx;
    ArrayList <Food> listOrders;

    public MyOrderAdapter(Context ctx, ArrayList<Food> listOrders){
        this.ctx = ctx;
        this.listOrders = listOrders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.order_food, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food myOrder = listOrders.get(position);

    holder.myorderquantity.setText(myOrder.quantity + "");
    holder.myordername.setText(myOrder.name);

    holder.hapusbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((OrderList) ctx.getApplicationContext()).changeQuantity(myOrder.id, 0);
            holder.itemView.setVisibility(View.GONE);
        }
    });
    }

    @Override
    public int getItemCount() {
        return listOrders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView myordername;
        TextView myorderquantity;
        Button hapusbutton;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hapusbutton = itemView.findViewById(R.id.hapusbutton);
            myordername = itemView.findViewById(R.id.myordernamenew);
            myorderquantity = itemView.findViewById(R.id.myorderquantitynew);
        }
    }
}
