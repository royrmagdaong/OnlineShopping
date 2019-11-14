package com.example.onlineshopping;

import androidx.annotation.NonNull;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ViewProductActivity extends AppCompatActivity {

    ImageView product_img;
    TextView product_name;
    FloatingActionButton btnCart;

    CollapsingToolbarLayout collapsingToolbarLayout;

    //firebase
    FirebaseUser currentUser;


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
        if (intent.getStringExtra(HomeFragment.product_img).equals("bagnet_sm")){
            product_img.setImageResource(R.drawable.bagnet);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("biko_bulacan_sm")){
            product_img.setImageResource(R.drawable.biko_bulacan);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("cashey_nuts_bataan_sm")){
            product_img.setImageResource(R.drawable.cashey_nuts_bataan);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("hopya_ibanag_sm")){
            product_img.setImageResource(R.drawable.hopya_ibanag);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("ilocos_bagoong_sm")){
            product_img.setImageResource(R.drawable.ilocos_bagoong);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("inatata_isabela_sm")){
            product_img.setImageResource(R.drawable.inatata_isabela);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("isabela_binalay_sm")){
            product_img.setImageResource(R.drawable.isabela_binalay);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("longganisa_batotay_sm")){
            product_img.setImageResource(R.drawable.longganisa_batotay);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("abel_weaving_sm")){
            product_img.setImageResource(R.drawable.abel_weaving);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("manga_zambales_2_sm")){
            product_img.setImageResource(R.drawable.manga_zambales_2);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("moriecos_isabela_sm")){
            product_img.setImageResource(R.drawable.moriecos_isabela);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("muscovado_sugar_tarlac_sm")){
            product_img.setImageResource(R.drawable.muscovado_sugar_tarlac);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("sukang_iloco_sm")){
            product_img.setImageResource(R.drawable.sukang_iloco);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("romana_peanut_brittle_sm")){
            product_img.setImageResource(R.drawable.romana_peanut_brittle);
        }else if(intent.getStringExtra(HomeFragment.product_img).equals("vigan_longganisa_sm")){
            product_img.setImageResource(R.drawable.vigan_longganisa);
        }
    }

    private void addToCart(){
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if (currentUser!=null){
                    //Toast.makeText(ViewProductActivity.this, "not null", Toast.LENGTH_SHORT).show();
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
                }else{
                    startActivity(new Intent(ViewProductActivity.this,LoginActivity.class));
                }

            }
        });
    }
}
