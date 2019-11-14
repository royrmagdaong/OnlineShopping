package com.example.onlineshopping.RecyclerAdapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Models.CartItem;
import com.example.onlineshopping.Models.NotificationItem;
import com.example.onlineshopping.R;

import java.util.ArrayList;

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.ViewHolder>{


    private ArrayList<CartItem> cartItems;

    private Context context;

    public CartRecyclerAdapter(Context mContext, ArrayList<CartItem> mcartItems) {
        this.cartItems = mcartItems;
        this.context = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final CartItem cartItem = cartItems.get(position);

        holder.product_name.setText(cartItem.getProductName());
        //holder.price.setText(cartItem.getPrice());
        if (cartItem.getPrice().equals("bagnet_sm")){
            holder.product_img.setImageResource(R.drawable.bagnet_sm);
        }else if(cartItem.getPrice().equals("biko_bulacan_sm")){
            holder.product_img.setImageResource(R.drawable.biko_bulacan_sm);
        }else if(cartItem.getPrice().equals("cashey_nuts_bataan_sm")){
            holder.product_img.setImageResource(R.drawable.cashey_nuts_bataan_sm);
        }else if(cartItem.getPrice().equals("hopya_ibanag_sm")){
            holder.product_img.setImageResource(R.drawable.hopya_ibanag_sm);
        }else if(cartItem.getPrice().equals("ilocos_bagoong_sm")){
            holder.product_img.setImageResource(R.drawable.ilocos_bagoong_sm);
        }else if(cartItem.getPrice().equals("inatata_isabela_sm")){
            holder.product_img.setImageResource(R.drawable.inatata_isabela_sm);
        }else if(cartItem.getPrice().equals("isabela_binalay_sm")){
            holder.product_img.setImageResource(R.drawable.isabela_binalay_sm);
        }else if(cartItem.getPrice().equals("longganisa_batotay_sm")){
            holder.product_img.setImageResource(R.drawable.longganisa_batotay_sm);
        }else if(cartItem.getPrice().equals("abel_weaving_sm")){
            holder.product_img.setImageResource(R.drawable.abel_weaving_sm);
        }else if(cartItem.getPrice().equals("manga_zambales_2_sm")){
            holder.product_img.setImageResource(R.drawable.manga_zambales_2_sm);
        }else if(cartItem.getPrice().equals("moriecos_isabela_sm")){
            holder.product_img.setImageResource(R.drawable.moriecos_isabela_sm);
        }else if(cartItem.getPrice().equals("muscovado_sugar_tarlac_sm")){
            holder.product_img.setImageResource(R.drawable.muscovado_sugar_tarlac_sm);
        }else if(cartItem.getPrice().equals("sukang_iloco_sm")){
            holder.product_img.setImageResource(R.drawable.sukang_iloco_sm);
        }else if(cartItem.getPrice().equals("romana_peanut_brittle_sm")){
            holder.product_img.setImageResource(R.drawable.romana_peanut_brittle_sm);
        }else if(cartItem.getPrice().equals("vigan_longganisa_sm")){
            holder.product_img.setImageResource(R.drawable.vigan_longganisa_sm);
        }

        holder.total_price.setText(cartItem.getTotalPrice());
        holder.quantity.setText(String.valueOf(cartItem.getQuantity()));

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "add", Toast.LENGTH_SHORT).show();
                int quan = Integer.parseInt(holder.quantity.getText().toString());
                quan++;
                holder.quantity.setText(String.valueOf(quan));
            }
        });
        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "subtract", Toast.LENGTH_SHORT).show();
                int quan = Integer.parseInt(holder.quantity.getText().toString());
                if (quan>1) {
                    quan--;
                    holder.quantity.setText(String.valueOf(quan));
                }
            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Do you want to remove this item?");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        cartItems.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, getItemCount() - position);

                    }
                });

                alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();

            }
        });

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, ""+currentItem.getQuantity(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return cartItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView product_name, price, total_price, quantity, remove;
        ImageView product_img;
        Button btnAdd, btnMinus;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            product_name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.price);
            total_price = itemView.findViewById(R.id.total_price);
            quantity = itemView.findViewById(R.id.quantity);
            btnAdd = itemView.findViewById(R.id.btnAdd);
            btnMinus = itemView.findViewById(R.id.btnMinus);
            remove = itemView.findViewById(R.id.remove);
            product_img = itemView.findViewById(R.id.product_image);
        }
    }

}
