package com.example.onlineshopping.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Models.NotificationItem;
import com.example.onlineshopping.Models.ShopCategoryItem;
import com.example.onlineshopping.R;
import com.example.onlineshopping.RecyclerAdapter.NotificationRecyclerAdapter;
import com.example.onlineshopping.RecyclerAdapter.ShopCategoryRecyclerAdapter;

import java.util.ArrayList;


public class ShopFragment extends Fragment {

    RecyclerView shopCategoryRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.shop_fragment, container,false);
        shopCategoryRecyclerView = view.findViewById(R.id.shopCategoryRecyclerView);

       initRecyclerView();
       return view;
    }

    public void initRecyclerView(){

        ArrayList<ShopCategoryItem> shopCategoryItems = new ArrayList<>();
        ShopCategoryRecyclerAdapter shopCategoryRecyclerAdapter;

        shopCategoryItems.add(new ShopCategoryItem("Gadgets"));
        shopCategoryItems.add(new ShopCategoryItem("Home Appliances"));
        shopCategoryItems.add(new ShopCategoryItem("Women's Bag"));
        shopCategoryItems.add(new ShopCategoryItem("Men's Bag"));
        shopCategoryItems.add(new ShopCategoryItem("Men's Shoes"));
        shopCategoryItems.add(new ShopCategoryItem("Women's Accessories"));
        shopCategoryItems.add(new ShopCategoryItem("Women's Apparel"));
        shopCategoryItems.add(new ShopCategoryItem("Men's Apparel"));



        shopCategoryRecyclerAdapter = new ShopCategoryRecyclerAdapter(getContext(),shopCategoryItems);
        shopCategoryRecyclerView.setAdapter(shopCategoryRecyclerAdapter);
        shopCategoryRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

}
