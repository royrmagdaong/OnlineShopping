package com.example.onlineshopping.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Models.NotificationItem;
import com.example.onlineshopping.R;
import com.example.onlineshopping.RecyclerAdapter.NotificationRecyclerAdapter;

import java.util.ArrayList;


public class NotificationFragment extends Fragment {

    RecyclerView recyclerView;
    NotificationRecyclerAdapter notificationRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.notification_fragment, container,false);

       recyclerView = view.findViewById(R.id.notificationRecyclerView);

       initRecyclerView();
       return view;
    }

    public void initRecyclerView(){

        final ArrayList<NotificationItem> notificationItems = new ArrayList<>();


        notificationItems.add(new NotificationItem("20190001","2m ago","Your order has been placed."));
        notificationItems.add(new NotificationItem("20190002","10m ago","Your order has been placed."));
        notificationItems.add(new NotificationItem("20190003","21m ago","Your order has been placed."));
        notificationItems.add(new NotificationItem("20190004","28m ago","Your order has been placed."));
        notificationItems.add(new NotificationItem("20190005","36m ago","Your order has been placed."));
        notificationItems.add(new NotificationItem("20190006","50m ago","Your order has been placed."));
        notificationItems.add(new NotificationItem("20190007","1h 30m ago","Your order has been placed."));




        notificationRecyclerAdapter = new NotificationRecyclerAdapter(getContext(),notificationItems);
        recyclerView.setAdapter(notificationRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition(); //get position which is swipe

                if (direction == ItemTouchHelper.LEFT) {    //if swipe left

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext()); //alert for confirm to delete
                    builder.setMessage("Are you sure to delete?");    //set message

                    builder.setPositiveButton("REMOVE", new DialogInterface.OnClickListener() { //when click on DELETE
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            notificationRecyclerAdapter.notifyItemRemoved(position);    //item removed from recylcerview
                            //sqldatabase.execSQL("delete from " + TABLE_NAME + " where _id='" + (position + 1) + "'"); //query for delete
                            //list.remove(position);  //then remove item
                            notificationItems.remove(position);
                            return;
                        }
                    }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {  //not removing items if cancel is done
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            notificationRecyclerAdapter.notifyItemRemoved(position + 1);    //notifies the RecyclerView Adapter that data in adapter has been removed at a particular position.
                            notificationRecyclerAdapter.notifyItemRangeChanged(position, notificationRecyclerAdapter.getItemCount());   //notifies the RecyclerView Adapter that positions of element in adapter has been changed from position(removed element index to end of list), please update it.
                            return;
                        }
                    }).show();  //show alert dialog
                }
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView); //set swipe to recylcerview
    }



}
