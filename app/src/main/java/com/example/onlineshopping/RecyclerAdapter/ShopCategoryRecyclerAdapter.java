package com.example.onlineshopping.RecyclerAdapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Models.CartItem;
import com.example.onlineshopping.Models.ShopCategoryItem;
import com.example.onlineshopping.R;

import java.util.ArrayList;

public class ShopCategoryRecyclerAdapter extends RecyclerView.Adapter<ShopCategoryRecyclerAdapter.ViewHolder>{


    private ArrayList<ShopCategoryItem> shopCategoryItems;

    private Context context;

    public ShopCategoryRecyclerAdapter(Context mContext, ArrayList<ShopCategoryItem> mshopCategoryItems) {
        this.shopCategoryItems = mshopCategoryItems;
        this.context = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_category_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final ShopCategoryItem shopCategoryItem = shopCategoryItems.get(position);

        holder.category_name.setText(shopCategoryItem.getCategoryName());
    }


    @Override
    public int getItemCount() {
        return shopCategoryItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView category_name;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            category_name = itemView.findViewById(R.id.category_name);

        }
    }

}
