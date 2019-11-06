package com.example.onlineshopping.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.LoginActivity;
import com.example.onlineshopping.MainActivity;
import com.example.onlineshopping.Models.CartItem;
import com.example.onlineshopping.R;
import com.example.onlineshopping.RecyclerAdapter.CartRecyclerAdapter;
import com.example.onlineshopping.SignUpActivity;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    Button btnLogin, btnRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.profile_fragment, container,false);

       btnLogin = view.findViewById(R.id.btnLogin);
       btnRegister = view.findViewById(R.id.btnRegister);

       gotoLoginForm();
       gotoSignUpForm();
       return view;
    }

    private void gotoLoginForm(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void gotoSignUpForm(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SignUpActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }



}
