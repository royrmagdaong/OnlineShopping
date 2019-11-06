package com.example.onlineshopping.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Constants.StaticArrayList;
import com.example.onlineshopping.Models.DailyDiscoverItem;
import com.example.onlineshopping.Models.ShopCategoryItem;
import com.example.onlineshopping.R;
import com.example.onlineshopping.RecyclerAdapter.DailyDiscoverRecyclerAdapter;
import com.example.onlineshopping.RecyclerAdapter.ShopCategoryRecyclerAdapter;
import com.example.onlineshopping.ViewProductActivity;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    public static final String product_name = "com.example.onlineshopping.NAME";
    public static final String product_img = "com.example.onlineshopping.IMG";

    LinearLayout topProd1, topProd2, topProd3, topProd4, topProd5, topProd6;
    ImageView top_prod_img1, top_prod_img2, top_prod_img3, top_prod_img4, top_prod_img5, top_prod_img6;
    TextView top_prod_name1, top_prod_name2, top_prod_name3, top_prod_name4, top_prod_name5, top_prod_name6;

    LinearLayout hotProd1, hotProd2, hotProd3, hotProd4, hotProd5, hotProd6;
    ImageView hot_prod_1_img, hot_prod_2_img, hot_prod_3_img, hot_prod_4_img, hot_prod_5_img, hot_prod_6_img;
    TextView hot_prod_1_name, hot_prod_2_name, hot_prod_3_name, hot_prod_4_name, hot_prod_5_name, hot_prod_6_name;

    RecyclerView dailyDiscoverRecyclerView;
    ScrollView scrollView;

    DailyDiscoverRecyclerAdapter dailyDiscoverRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.home_fragment, container,false);

       topProd1 = view.findViewById(R.id.top_prod_1);
       topProd2 = view.findViewById(R.id.top_prod_2);
       topProd3 = view.findViewById(R.id.top_prod_3);
       topProd4 = view.findViewById(R.id.top_prod_4);
       topProd5 = view.findViewById(R.id.top_prod_5);
       topProd6 = view.findViewById(R.id.top_prod_6);
       hotProd1 = view.findViewById(R.id.hot_prod_1);
       hotProd2 = view.findViewById(R.id.hot_prod_2);
       hotProd3 = view.findViewById(R.id.hot_prod_3);
       hotProd4 = view.findViewById(R.id.hot_prod_4);
       hotProd5 = view.findViewById(R.id.hot_prod_5);
       hotProd6 = view.findViewById(R.id.hot_prod_6);

       // images top product
        top_prod_img1 = view.findViewById(R.id.top_prod_1_img);
        top_prod_img2 = view.findViewById(R.id.top_prod_2_img);
        top_prod_img3 = view.findViewById(R.id.top_prod_3_img);
        top_prod_img4 = view.findViewById(R.id.top_prod_4_img);
        top_prod_img5 = view.findViewById(R.id.top_prod_5_img);
        top_prod_img6 = view.findViewById(R.id.top_prod_6_img);
        // names top product
        top_prod_name1 = view.findViewById(R.id.top_prod_1_name);
        top_prod_name2 = view.findViewById(R.id.top_prod_2_name);
        top_prod_name3 = view.findViewById(R.id.top_prod_3_name);
        top_prod_name4 = view.findViewById(R.id.top_prod_4_name);
        top_prod_name5 = view.findViewById(R.id.top_prod_5_name);
        top_prod_name6 = view.findViewById(R.id.top_prod_6_name);

        // images hot product
        hot_prod_1_img = view.findViewById(R.id.hot_prod_1_img);
        hot_prod_2_img = view.findViewById(R.id.hot_prod_2_img);
        hot_prod_3_img = view.findViewById(R.id.hot_prod_3_img);
        hot_prod_4_img = view.findViewById(R.id.hot_prod_4_img);
        hot_prod_5_img = view.findViewById(R.id.hot_prod_5_img);
        hot_prod_6_img = view.findViewById(R.id.hot_prod_6_img);
        //names hot product
        hot_prod_1_name = view.findViewById(R.id.hot_prod_1_name);
        hot_prod_2_name = view.findViewById(R.id.hot_prod_2_name);
        hot_prod_3_name = view.findViewById(R.id.hot_prod_3_name);
        hot_prod_4_name = view.findViewById(R.id.hot_prod_4_name);
        hot_prod_5_name = view.findViewById(R.id.hot_prod_5_name);
        hot_prod_6_name = view.findViewById(R.id.hot_prod_6_name);

        dailyDiscoverRecyclerView = view.findViewById(R.id.dailyDiscoverRecyclerView);
        scrollView = view.findViewById(R.id.home_fragment_scroll_view);

       gotoTopProduct();
       gotoHotProduct();
       initDailyDiscoverRecyclerView();
       return view;
    }

    private void gotoTopProduct(){
        topProd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name1.getText().toString());
                intent.putExtra(product_img, "prod_a");
                startActivity(intent);
            }
        });
        topProd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name2.getText().toString());
                intent.putExtra(product_img, "prod_b");
                startActivity(intent);
            }
        });
        topProd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name3.getText().toString());
                intent.putExtra(product_img, "prod_c");
                startActivity(intent);
            }
        });
        topProd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name4.getText().toString());
                intent.putExtra(product_img, "prod_d");
                startActivity(intent);
            }
        });
        topProd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name5.getText().toString());
                intent.putExtra(product_img, "prod_e");
                startActivity(intent);
            }
        });
        topProd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name6.getText().toString());
                intent.putExtra(product_img, "prod_f");
                startActivity(intent);
            }
        });
    }

    private void gotoHotProduct(){
        hotProd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_1_name.getText().toString());
                intent.putExtra(product_img, "prod_aa");
                startActivity(intent);
            }
        });
        hotProd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_2_name.getText().toString());
                intent.putExtra(product_img, "prod_bb");
                startActivity(intent);
            }
        });
        hotProd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_3_name.getText().toString());
                intent.putExtra(product_img, "prod_cc");
                startActivity(intent);
            }
        });
        hotProd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_4_name.getText().toString());
                intent.putExtra(product_img, "prod_dd");
                startActivity(intent);
            }
        });
        hotProd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_5_name.getText().toString());
                intent.putExtra(product_img, "prod_ee");
                startActivity(intent);
            }
        });
        hotProd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_6_name.getText().toString());
                intent.putExtra(product_img, "prod_ff");
                startActivity(intent);
            }
        });
    }

    public void initDailyDiscoverRecyclerView(){

        dailyDiscoverRecyclerAdapter = new DailyDiscoverRecyclerAdapter(getContext(), StaticArrayList.dailyDiscoverItems);
        dailyDiscoverRecyclerView.setAdapter(dailyDiscoverRecyclerAdapter);
        dailyDiscoverRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        scrollView.getViewTreeObserver()
                .addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        if (scrollView.getChildAt(0).getBottom()
                                <= (scrollView.getHeight() + scrollView.getScrollY())) {
                            //scroll view is at bottom
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Product 1","prod_a"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Product 2","prod_e"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Product 3","prod_bb"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Product 4","prod_d"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Product 1","prod_a"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Product 2","prod_e"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Product 3","prod_bb"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Product 4","prod_d"));

                            dailyDiscoverRecyclerAdapter.notifyDataSetChanged();
                        } else {
                            //scroll view is not at bottom
                        }
                    }
                });

    }


}
