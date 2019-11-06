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
        if (cartItem.getPrice().equals("prod_a")){
            holder.product_img.setImageResource(R.drawable.prod_a);
        }else if(cartItem.getPrice().equals("prod_b")){
            holder.product_img.setImageResource(R.drawable.prod_b);
        }else if(cartItem.getPrice().equals("prod_c")){
            holder.product_img.setImageResource(R.drawable.prod_c);
        }else if(cartItem.getPrice().equals("prod_d")){
            holder.product_img.setImageResource(R.drawable.prod_d);
        }else if(cartItem.getPrice().equals("prod_e")){
            holder.product_img.setImageResource(R.drawable.prod_e);
        }else if(cartItem.getPrice().equals("prod_f")){
            holder.product_img.setImageResource(R.drawable.prod_f);
        }else if(cartItem.getPrice().equals("prod_aa")){
            holder.product_img.setImageResource(R.drawable.prod_aa);
        }else if(cartItem.getPrice().equals("prod_bb")){
            holder.product_img.setImageResource(R.drawable.prod_bb);
        }else if(cartItem.getPrice().equals("prod_cc")){
            holder.product_img.setImageResource(R.drawable.prod_cc);
        }else if(cartItem.getPrice().equals("prod_dd")){
            holder.product_img.setImageResource(R.drawable.prod_dd);
        }else if(cartItem.getPrice().equals("prod_ee")){
            holder.product_img.setImageResource(R.drawable.prod_ee);
        }else if(cartItem.getPrice().equals("prod_ff")){
            holder.product_img.setImageResource(R.drawable.prod_ff);
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
