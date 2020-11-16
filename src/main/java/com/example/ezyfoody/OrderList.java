package com.example.ezyfoody;

import android.app.Application;
import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;

//global variable
public class OrderList extends Application {
    ArrayList<Food> listFood = new ArrayList<Food>(){{
        add(new Food("Indomie", 123, R.drawable.imageindomie, 0,0));
        add(new Food("Sandwich", 123, R.drawable.imagesandwich, 0,1));
        add(new Food("Donuts", 123, R.drawable.imagedonut, 0,2));
        add(new Food("French Fries", 123, R.drawable.imagefrenchfries, 0,3));
        add(new Food("Burger", 123, R.drawable.imageburger, 0,4));
        add(new Food("Onigiri", 123, R.drawable.imageonigiri, 0,5));
    }};

    public ArrayList<Food> getListFood() {
        return listFood;
    }
    public ArrayList<Food> getQuantityFood() {
        ArrayList<Food> quantityfood = new ArrayList<Food>();

        for(Food food: listFood){
            if(food.quantity > 0) quantityfood.add(food);
        }
        return quantityfood;
    }

    public int calculatePrice(){
        int price = 123;
        int totalPrice = 0;

        for(Food food: listFood) {
            if(food.quantity > 0)
                totalPrice += food.quantity * food.price;
        } return totalPrice;
    }

    public void changeQuantity(int position, int quantity){
        listFood.get(position).setQuantity(quantity);
    }

    public void resetData(){
        for(Food food: listFood){
            food.quantity = 0;
        }
    }
}
