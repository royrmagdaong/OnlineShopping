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


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Constants.StaticArrayList;
import com.example.onlineshopping.Models.DailyDiscoverItem;
import com.example.onlineshopping.R;
import com.example.onlineshopping.RecyclerAdapter.DailyDiscoverRecyclerAdapter;
import com.example.onlineshopping.ViewProductActivity;


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
                intent.putExtra(product_img, (String) top_prod_img1.getTag());
                startActivity(intent);
            }
        });
        topProd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name2.getText().toString());
                intent.putExtra(product_img, (String) top_prod_img2.getTag());
                startActivity(intent);
            }
        });
        topProd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name3.getText().toString());
                intent.putExtra(product_img, (String) top_prod_img3.getTag());
                startActivity(intent);
            }
        });
        topProd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name4.getText().toString());
                intent.putExtra(product_img, (String) top_prod_img4.getTag());
                startActivity(intent);
            }
        });
        topProd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name5.getText().toString());
                intent.putExtra(product_img, (String) top_prod_img5.getTag());
                startActivity(intent);
            }
        });
        topProd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, top_prod_name6.getText().toString());
                intent.putExtra(product_img, (String) top_prod_img6.getTag());
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
                intent.putExtra(product_img, (String) hot_prod_1_img.getTag());
                startActivity(intent);
            }
        });
        hotProd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_2_name.getText().toString());
                intent.putExtra(product_img, (String) hot_prod_2_img.getTag());
                startActivity(intent);
            }
        });
        hotProd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_3_name.getText().toString());
                intent.putExtra(product_img, (String) hot_prod_3_img.getTag());
                startActivity(intent);
            }
        });
        hotProd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_4_name.getText().toString());
                intent.putExtra(product_img, (String) hot_prod_4_img.getTag());
                startActivity(intent);
            }
        });
        hotProd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_5_name.getText().toString());
                intent.putExtra(product_img, (String) hot_prod_5_img.getTag());
                startActivity(intent);
            }
        });
        hotProd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewProductActivity.class);
                intent.putExtra(product_name, hot_prod_6_name.getText().toString());
                intent.putExtra(product_img, (String) hot_prod_6_img.getTag());
                startActivity(intent);
            }
        });
    }

    public void initDailyDiscoverRecyclerView(){

        dailyDiscoverRecyclerAdapter = new DailyDiscoverRecyclerAdapter(getContext(), StaticArrayList.dailyDiscoverItems);
        dailyDiscoverRecyclerView.setAdapter(dailyDiscoverRecyclerAdapter);
        dailyDiscoverRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));


        // Add item to recyclerview trigger by reaching the bottom of scrollview
        scrollView.getViewTreeObserver()
                .addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        if (scrollView.getChildAt(0).getBottom()
                                <= (scrollView.getHeight() + scrollView.getScrollY())) {
                            //scroll view is at bottom
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Bagnet","bagnet_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Bico Bulacan","biko_bulacan_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Cashey Nuts(Kasoy) Bataan","cashey_nuts_bataan_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Hopya Ibanag","hopya_ibanag_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Bagoong Ilocos","ilocos_bagoong_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Inatata Isabela","inatata_isabela_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Binalay Isabela","isabela_binalay_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Batotay Longganisa","longganisa_batotay_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Abel Weaving","abel_weaving_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Manga Zambales","manga_zambales_2_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Moriecos","moriecos_isabela_sm","525.0"));
                            StaticArrayList.dailyDiscoverItems.add(new DailyDiscoverItem("Muscovado","muscovado_sugar_tarlac_sm","525.0"));

                            dailyDiscoverRecyclerAdapter.notifyDataSetChanged();
                        } else {
                            //scroll view is not at bottom
                        }
                    }
                });

    }


}
