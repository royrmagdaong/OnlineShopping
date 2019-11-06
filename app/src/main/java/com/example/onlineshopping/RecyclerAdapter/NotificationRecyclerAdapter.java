package com.example.onlineshopping.RecyclerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Models.NotificationItem;
import com.example.onlineshopping.R;

import java.util.ArrayList;

public class NotificationRecyclerAdapter extends RecyclerView.Adapter<NotificationRecyclerAdapter.ViewHolder>{


    private ArrayList<NotificationItem> notificationItems;

    private Context context;

    public NotificationRecyclerAdapter(Context mContext, ArrayList<NotificationItem> mGroceryItems) {
        this.notificationItems = mGroceryItems;
        this.context = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final NotificationItem notificationItem = notificationItems.get(position);

        holder.order_num.setText(notificationItem.getOrderNumber());
        holder.time.setText(notificationItem.getTime());
        holder.status.setText(notificationItem.getStatus());



        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, ""+currentItem.getQuantity(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return notificationItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView order_num, time, status;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            order_num = itemView.findViewById(R.id.order_num);
            time = itemView.findViewById(R.id.time);
            status = itemView.findViewById(R.id.status);
        }
    }



}
