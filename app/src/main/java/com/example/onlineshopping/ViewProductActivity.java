package com.example.onlineshopping;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineshopping.Constants.StaticArrayList;
import com.example.onlineshopping.Fragments.HomeFragment;
import com.example.onlineshopping.Models.CartItem;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewProductActivity extends AppCompatActivity {

    ImageView product_img;
    TextView product_name;
    FloatingActionButton btnCart;

    CollapsingToolbarLayout collapsingToolbarLayout;


    String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);

        collapsingToolbarLayout = findViewById(R.id.collapsing);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        product_img = findViewById(R.id.product_img);
        product_name = findViewById(R.id.product_name);
        btnCart = findViewById(R.id.btnCart);



        getDataThroughIntent();
        addToCart();
    }

    private void getDataThroughIntent(){
        Intent intent = getIntent();
        product_name.setText(intent.getStringExtra(HomeFragment.product_name));
        img = intent.getStringExtra(HomeFragment.product_img);
        if (intent.getStringExtra(HomeFragment.product_img).equals("prod_a")){
            product_img.setImageResource(R.drawable.prod_a);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_b")){
            product_img.setImageResource(R.drawable.prod_b);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_c")){
            product_img.setImageResource(R.drawable.prod_c);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_d")){
            product_img.setImageResource(R.drawable.prod_d);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_e")){
            product_img.setImageResource(R.drawable.prod_e);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_f")){
            product_img.setImageResource(R.drawable.prod_f);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_aa")){
            product_img.setImageResource(R.drawable.prod_aa);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_bb")){
            product_img.setImageResource(R.drawable.prod_bb);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_cc")){
            product_img.setImageResource(R.drawable.prod_cc);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_dd")){
            product_img.setImageResource(R.drawable.prod_dd);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_ee")){
            product_img.setImageResource(R.drawable.prod_ee);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("prod_ff")){
            product_img.setImageResource(R.drawable.prod_ff);
        }
    }

    private void addToCart(){
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(ViewProductActivity.this,R.style.myDialog)); //alert for confirm to delete
                builder.setMessage("Do you want to add this item to your cart?");    //set message

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { //when click on DELETE
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StaticArrayList.cartItems.add(new CartItem(product_name.getText().toString(),img,"",1));
                        Toast.makeText(ViewProductActivity.this, "added to cart successfully", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {  //not removing items if cancel is done
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        return;
                    }
                }).show();  //show alert dialog

            }
        });
    }
}
