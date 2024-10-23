package com.sky.eatmore;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.foodHolder> {

    List<FoodItem> data;
    Context context;
    int selectedFoodItemPosition =0;


    public FoodItemAdapter(List<FoodItem> data,Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public foodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.food_view_holder,parent,false);
        return new foodHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull foodHolder holder, int position) {
        holder.txtPrice.setText(String.format("$%d",data.get(position).getPrice()));
        holder.txtName.setText(data.get(position).getName());
        holder.imgFood.setBackgroundResource(data.get(position).getImage());
        holder.ratingBar.setRating(data.get(position).getRating());

        if (selectedFoodItemPosition == position){
            holder.txtName.setTextColor(Color.WHITE);
            holder.txtPrice.setTextColor(Color.WHITE);
            holder.cardFood.animate().scaleX(1.1f);
            holder.cardFood.animate().scaleY(1.1f);
            holder.ll.setBackgroundResource(R.drawable.launcher_image);

        }else{
            holder.txtName.setTextColor(Color.BLACK);
            holder.txtPrice.setTextColor(Color.BLACK);
            holder.cardFood.animate().scaleX(1f);
            holder.cardFood.animate().scaleY(1f);
            holder.ll.setBackgroundResource(R.color.white);

        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class foodHolder extends RecyclerView.ViewHolder{
        ImageView imgFood;
        TextView txtPrice,txtName;
        RatingBar ratingBar;
        CardView cardFood;
        LinearLayout ll;

        public foodHolder(@NonNull View itemView) {
            super(itemView);

            imgFood = itemView.findViewById(R.id.imgFood);
            txtName = itemView.findViewById(R.id.txtFoodTitle);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            ratingBar = itemView.findViewById(R.id.rating);
            cardFood = itemView.findViewById(R.id.cardFood);
            ll = itemView.findViewById(R.id.llBackground);

            cardFood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedFoodItemPosition = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
            imgFood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedFoodItemPosition = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });


        }
    }
}
