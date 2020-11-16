package com.example.ezyfoody;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Food> listFoods;

    public FoodAdapter(Context ctx, ArrayList<Food> listFoods){
        this.ctx = ctx;
        this.listFoods = listFoods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.grid_food, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = listFoods.get(position);

        holder.imageviewfood.setImageResource(food.thumbnail);
        holder.textviewname.setText(food.name);
//        holder.textviewprice.setText(food.price);

        holder.imageviewfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, OrderActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("food", food);

                intent.putExtra("food", bundle);
                intent.putExtra("position", position);
                intent.putExtra("foodname", food.name);
                intent.putExtra("foodprice", food.price);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFoods.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageviewfood;
        TextView textviewname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageviewfood = itemView.findViewById(R.id.imageviewfood);
            textviewname = itemView.findViewById(R.id.textviewname);
        }
    }
}
