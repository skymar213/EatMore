package com.sky.eatmore;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.categoryHolder>  {

    List<foodCategory> data;
    Context context;
    int selectedItemPosition = 0;
    onCategoryClickedListener listener;

    public FoodCategoryAdapter(List<foodCategory> data, Context context,onCategoryClickedListener listener) {
        this.data = data;
        this.context = context;
        this.listener = listener;
    }



    @NonNull
    @Override
    public categoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.category_view_holder,parent,false);
     return new categoryHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onBindViewHolder(@NonNull categoryHolder holder, int position) {
       holder.img.setImageResource(data.get(position).getImage());
       holder.txtName.setText(data.get(position).getName());
       if(position == selectedItemPosition){
           holder.txtName.setTextColor(context.getColor(R.color.red));
           holder.img.setColorFilter(context.getColor(R.color.red), PorterDuff.Mode.SRC_IN);
           holder.cardCategory.setOutlineAmbientShadowColor(context.getColor(R.color.red));
           holder.cardCategory.setOutlineSpotShadowColor(context.getColor(R.color.red));
           holder.cardCategory.setStrokeWidth(2);
       }else{
           holder.cardCategory.setOutlineSpotShadowColor(context.getColor(R.color.grey));
           holder.cardCategory.setOutlineAmbientShadowColor(context.getColor(R.color.grey));
           holder.cardCategory.setStrokeWidth(0);
           holder.img.setColorFilter(context.getColor(R.color.grey), PorterDuff.Mode.SRC_IN);
           holder.txtName.setTextColor(context.getColor(R.color.grey));

       }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }





    class categoryHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView img;
        MaterialCardView cardCategory;

        public categoryHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtTitle);
            img = itemView.findViewById(R.id.img);
            cardCategory = itemView.findViewById(R.id.cardCategory);

            cardCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedItemPosition = getAdapterPosition();
                    if (listener != null){
                        listener.onCategoryClicked(getAdapterPosition());
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }

    public interface onCategoryClickedListener{
        void onCategoryClicked(int position);

        }

}
