package com.example.onlineshopping.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Constants.StaticArrayList;
import com.example.onlineshopping.R;
import com.example.onlineshopping.RecyclerAdapter.CartRecyclerAdapter;


public class CartFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.cart_fragment, container,false);

       recyclerView = view.findViewById(R.id.cartRecyclerView);

       initRecyclerView();

       return view;
    }

    public void initRecyclerView(){

        CartRecyclerAdapter cartRecyclerAdapter;

        cartRecyclerAdapter = new CartRecyclerAdapter(getContext(), StaticArrayList.cartItems);
        recyclerView.setAdapter(cartRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
