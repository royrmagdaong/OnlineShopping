package com.example.onlineshopping.Fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Constants.StaticArrayList;
import com.example.onlineshopping.EditProfileActivity;
import com.example.onlineshopping.LoginActivity;
import com.example.onlineshopping.MainActivity;
import com.example.onlineshopping.Models.CartItem;
import com.example.onlineshopping.Models.ExpandableListDataPump;
import com.example.onlineshopping.R;
import com.example.onlineshopping.RecyclerAdapter.CartRecyclerAdapter;
import com.example.onlineshopping.RecyclerAdapter.ExpandableListAdapter;
import com.example.onlineshopping.SignUpActivity;
import com.example.onlineshopping.ViewProductActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ProfileFragment extends Fragment {

    Button btnLogin, btnRegister;
    ImageView profile_image;

    //ExpandableListView expandableListView;
//    ExpandableListAdapter expandableListAdapter;
//    List<String> expandableListTitle;
//    HashMap<String, List<String>> expandableListDetail;
//

    LinearLayout myProfile, logout;

    // Firebase
    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    GoogleSignInClient mGoogleSignInClient;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        btnLogin = view.findViewById(R.id.btnLogin);
        btnRegister = view.findViewById(R.id.btnRegister);
        profile_image = view.findViewById(R.id.product_image);

        myProfile = view.findViewById(R.id.myProfile);
        logout = view.findViewById(R.id.profile_logout);

        // firebase init
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);

//       expandableListView =  view.findViewById(R.id.expandableListView);
//       expandableListDetail = ExpandableListDataPump.getData();
//       expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
//       expandableListAdapter = new ExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
//       expandableListView.setAdapter(expandableListAdapter);


//       sample1.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//               if (subSample1.getVisibility() == View.VISIBLE){
//                   subSample1.setVisibility(View.GONE);
//                   subSample2.setVisibility(View.GONE);
//               }else{
//                   subSample1.setVisibility(View.VISIBLE);
//                   subSample2.setVisibility(View.VISIBLE);
//               }
//
//           }
//       });

        gotoLoginForm();
        gotoSignUpForm();
        gotoMyProfile();
        user_logout();
        checkIfLogin();
        //expandableListEvents();
        return view;
    }


    private void gotoLoginForm() {
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

    private void gotoSignUpForm() {
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

    private void gotoMyProfile() {
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    private void user_logout() {
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.myDialog)); //alert for confirm to delete
                builder.setMessage("Are you sure you want to logout?");    //set message

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { //when click on DELETE
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getContext(), "added to cart successfully", Toast.LENGTH_SHORT).show();

                        mAuth.signOut();
                        mGoogleSignInClient.signOut();
                        //Toast.makeText(getContext(), "Log out", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), MainActivity.class));

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

//    private void expandableListEvents(){
//        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//
//            @Override
//            public void onGroupExpand(int groupPosition) {
////                Toast.makeText(getContext(),
////                        expandableListTitle.get(groupPosition) + " List Expanded.",
////                        Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//
//            @Override
//            public void onGroupCollapse(int groupPosition) {
////                Toast.makeText(getContext(),
////                        expandableListTitle.get(groupPosition) + " List Collapsed.",
////                        Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
////                Toast.makeText(
////                        getContext(),
////                        expandableListTitle.get(groupPosition)
////                                + " -> "
////                                + expandableListDetail.get(
////                                expandableListTitle.get(groupPosition)).get(
////                                childPosition), Toast.LENGTH_SHORT
////                )
////                        .show();
//                return false;
//            }
//        });
//    }

    private void checkIfLogin() {
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null) {

            btnRegister.setVisibility(View.GONE);
            btnLogin.setVisibility(View.GONE);
            logout.setVisibility(View.VISIBLE);
        } else {
            btnRegister.setVisibility(View.VISIBLE);
            btnLogin.setVisibility(View.VISIBLE);
            logout.setVisibility(View.GONE);
        }
    }

//    private void changeProfilePicture() {
//        currentUser = FirebaseAuth.getInstance().getCurrentUser();
//        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                .setDisplayName("Randy Gonzales")
//                .setPhotoUri(Uri.parse("https://lh3.googleusercontent.com/-Q6rwTWnVQ8I/Xc0YVynASKI/AAAAAAAAABc/KFwUdogxNK8WVwZA_a27DQhtQ4aQNdQpgCEwYBhgL/w140-h140-p/mens%2Bapparel.jpg"))
//                .build();
//
//        currentUser.updateProfile(profileUpdates)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            //Log.d(TAG, "User profile updated.");
//                            Toast.makeText(getContext(), "User Profile updated", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//
//    }
}