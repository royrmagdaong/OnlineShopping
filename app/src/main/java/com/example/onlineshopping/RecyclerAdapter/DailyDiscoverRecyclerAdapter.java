package com.example.onlineshopping.RecyclerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Models.DailyDiscoverItem;
import com.example.onlineshopping.Models.ShopCategoryItem;
import com.example.onlineshopping.R;

import java.util.ArrayList;

public class DailyDiscoverRecyclerAdapter extends RecyclerView.Adapter<DailyDiscoverRecyclerAdapter.ViewHolder>{

    private ArrayList<DailyDiscoverItem> dailyDiscoverItems;

    private Context context;

    private int lastPosition = -1;

    public DailyDiscoverRecyclerAdapter(Context mContext, ArrayList<DailyDiscoverItem> dailyDiscoverItems) {
        this.dailyDiscoverItems = dailyDiscoverItems;
        this.context = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_discover_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final DailyDiscoverItem dailyDiscoverItem = dailyDiscoverItems.get(position);

        holder.product_name.setText(dailyDiscoverItem.getProduct_name());

        if (dailyDiscoverItem.getProduct_img().equals("prod_a")){
            holder.product_image.setImageResource(R.drawable.prod_a);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_b")){
            holder.product_image.setImageResource(R.drawable.prod_b);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_c")){
            holder.product_image.setImageResource(R.drawable.prod_c);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_d")){
            holder.product_image.setImageResource(R.drawable.prod_d);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_e")){
            holder.product_image.setImageResource(R.drawable.prod_e);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_f")){
            holder.product_image.setImageResource(R.drawable.prod_f);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_aa")){
            holder.product_image.setImageResource(R.drawable.prod_aa);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_bb")){
            holder.product_image.setImageResource(R.drawable.prod_bb);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_cc")){
            holder.product_image.setImageResource(R.drawable.prod_cc);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_dd")){
            holder.product_image.setImageResource(R.drawable.prod_dd);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_ee")){
            holder.product_image.setImageResource(R.drawable.prod_ee);
        }else if(dailyDiscoverItem.getProduct_img().equals("prod_ff")){
            holder.product_image.setImageResource(R.drawable.prod_ff);
        }

        setAnimation(holder.itemView, position);

    }


    @Override
    public int getItemCount() {
        return dailyDiscoverItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView product_name;
        ImageView product_image;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            product_name = itemView.findViewById(R.id.product_name);
            product_image = itemView.findViewById(R.id.product_image);

        }
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
            animation.setDuration(2500);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}
