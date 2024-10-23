package com.sky.eatmore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView recyclerCategory, recyclerFoodItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerCategory = findViewById(R.id.recyclerCategory);
        recyclerFoodItem = findViewById(R.id.recyclerFoodItem);

        setCategories();
        setFoodItems(0);
    }



    private void setCategories(){
        List<foodCategory> data = new ArrayList<>();
        foodCategory foodCategory2= new foodCategory("Pizza",R.drawable.ic_pizza);
        foodCategory foodCategory1 = new foodCategory("Burger",R.drawable.ic_burger);
        foodCategory foodCategory0 = new foodCategory("Chicken",R.drawable.ic_chicken);
        foodCategory foodCategory3 = new foodCategory("chicken",R.drawable.ic_chicken);
        foodCategory foodCategory4 = new foodCategory("chicken",R.drawable.ic_chicken);

        data.add(foodCategory2);
        data.add(foodCategory1);
        data.add(foodCategory0);
        data.add(foodCategory3);
        data.add(foodCategory4);


        FoodCategoryAdapter foodCategoryAdapter = new FoodCategoryAdapter(data, Home.this, new FoodCategoryAdapter.onCategoryClickedListener() {
            @Override
            public void onCategoryClicked(int position) {
                //category changed
                setFoodItems(position);

            }
        });

        recyclerCategory.setLayoutManager(new LinearLayoutManager(Home.this,RecyclerView.HORIZONTAL,false));
        recyclerCategory.setAdapter(foodCategoryAdapter);

        foodCategoryAdapter.notifyDataSetChanged();
    }


    private void setFoodItems(int categoryPosition){
        List<FoodItem> data = new ArrayList<>();
        switch (categoryPosition){
            case 0:
                FoodItem foodItem1 = new FoodItem("margherita",3.5f,10,R.drawable.pizza_1);
                FoodItem foodItem2 = new FoodItem("chicken pizza",4.7f,18,R.drawable.pizza_2);
                FoodItem foodItem3 = new FoodItem("sausage pizza",4.5f,16,R.drawable.pizza_3);
                FoodItem foodItem4 = new FoodItem("vegetarian pizza ",4f,15,R.drawable.pizza_4);

                data.add(foodItem1);
                data.add(foodItem2);
                data.add(foodItem3);
                data.add(foodItem4);
                break;
            case 1:
                FoodItem foodItem5 = new FoodItem("Cheese Burger",4.2f,12,R.drawable.chicken_burger);
                FoodItem foodItem6 = new FoodItem("Menu Cheese Burger",4.7f,15,R.drawable.zinger);

                data.add(foodItem5);
                data.add(foodItem6);
                 break;
            case 2:
                FoodItem foodItem7 = new FoodItem("Grilled Chicken",4.5f,19,R.drawable.grill_chicken_1);
                FoodItem foodItem8 = new FoodItem("Grilled Chicken And Rice",4.8f,23,R.drawable.grill_chicken_2);
                FoodItem foodItem9 = new FoodItem("Grilled Chicken And Salad",4.6f,20,R.drawable.grill_chicken_3);

                data.add(foodItem7);
                data.add(foodItem8);
                data.add(foodItem9);
             break;
            case 3:
                FoodItem foodItem10 = new FoodItem("Grilled Chicken",4.5f,19,R.drawable.grill_chicken_1);
                FoodItem foodItem11 = new FoodItem("Grilled Chicken And Rice",4.8f,23,R.drawable.grill_chicken_2);
                FoodItem foodItem12 = new FoodItem("Grilled Chicken And Salad",4.6f,20,R.drawable.grill_chicken_3);

                data.add(foodItem10);
                data.add(foodItem11);
                data.add(foodItem12);
                break;
            case 4:
                FoodItem foodItem13 = new FoodItem("Grilled Chicken",4.5f,19,R.drawable.grill_chicken_1);
                FoodItem foodItem14 = new FoodItem("Grilled Chicken And Rice",4.8f,23,R.drawable.grill_chicken_2);
                FoodItem foodItem15 = new FoodItem("Grilled Chicken And Salad",4.6f,20,R.drawable.grill_chicken_3);

                data.add(foodItem13);
                data.add(foodItem14);
                data.add(foodItem15);
                break;

        }




        FoodItemAdapter foodItemAdapter = new FoodItemAdapter(data,Home.this);
        recyclerFoodItem.setLayoutManager(new LinearLayoutManager(Home.this,RecyclerView.HORIZONTAL,false));
        recyclerFoodItem.setAdapter(foodItemAdapter);
        foodItemAdapter.notifyDataSetChanged();


    }
}