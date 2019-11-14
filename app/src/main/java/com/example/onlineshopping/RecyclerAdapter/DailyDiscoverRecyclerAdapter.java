package com.example.onlineshopping.RecyclerAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Models.DailyDiscoverItem;
import com.example.onlineshopping.R;
import com.example.onlineshopping.ViewProductActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DailyDiscoverRecyclerAdapter extends RecyclerView.Adapter<DailyDiscoverRecyclerAdapter.ViewHolder>{

    public static final String product_name = "com.example.onlineshopping.NAME";
    public static final String product_img = "com.example.onlineshopping.IMG";

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
        holder.product_price.setText(dailyDiscoverItem.getPrice());

        String imageUri = "https://b.zmtcdn.com/data/pictures/chains/9/6304949/975a43f9501a49f13f6aff8c4692f221.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A";
        Picasso.with(context).load(imageUri).fit().centerCrop()
                .into(holder.product_image);


//        if (dailyDiscoverItem.getProduct_img().equals("bagnet_sm")){
//            holder.product_image.setImageResource(R.drawable.bagnet_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("biko_bulacan_sm")){
//            holder.product_image.setImageResource(R.drawable.biko_bulacan_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("cashey_nuts_bataan_sm")){
//            holder.product_image.setImageResource(R.drawable.cashey_nuts_bataan_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("hopya_ibanag_sm")){
//            holder.product_image.setImageResource(R.drawable.hopya_ibanag_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("ilocos_bagoong_sm")){
//            holder.product_image.setImageResource(R.drawable.ilocos_bagoong_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("inatata_isabela_sm")){
//            holder.product_image.setImageResource(R.drawable.inatata_isabela_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("isabela_binalay_sm")){
//            holder.product_image.setImageResource(R.drawable.isabela_binalay_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("longganisa_batotay_sm")){
//            holder.product_image.setImageResource(R.drawable.longganisa_batotay_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("abel_weaving_sm")){
//            holder.product_image.setImageResource(R.drawable.abel_weaving_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("manga_zambales_2_sm")){
//            holder.product_image.setImageResource(R.drawable.manga_zambales_2_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("moriecos_isabela_sm")){
//            holder.product_image.setImageResource(R.drawable.moriecos_isabela_sm);
//        }else if(dailyDiscoverItem.getProduct_img().equals("muscovado_sugar_tarlac_sm")){
//            holder.product_image.setImageResource(R.drawable.muscovado_sugar_tarlac_sm);
//        }

        setAnimation(holder.itemView, position);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewProductActivity.class);
                intent.putExtra(product_name, dailyDiscoverItem.getProduct_name());
                intent.putExtra(product_img, dailyDiscoverItem.getProduct_img());
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return dailyDiscoverItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView product_name, product_price;
        ImageView product_image;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            product_name = itemView.findViewById(R.id.product_name);
            product_price = itemView.findViewById(R.id.price);
            product_image = itemView.findViewById(R.id.product_image);

        }
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}
