package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class SignUpActivity extends AppCompatActivity {

    TextView txtLogin;
    Button btnSignUp;

    //Button btnUpload;
    LinearLayout blurred_bg;

    EditText emailAddress, edtPassword, repeatPassword;

    private ProgressBar mProgressBar;
    // Firebase Auth
    private FirebaseAuth mAuth;


    // Firebase storage
    FirebaseStorage storage;
    StorageReference storageRef;

    int RESULT_LOAD_IMAGE = 000;

    String realPath;
    private static final String DOMAIN_NAME = "gmail.com";
    private static final String DOMAIN_NAME2 = "yahoo.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtLogin = findViewById(R.id.txtLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        //btnUpload = findViewById(R.id.btnUpload);

        emailAddress = findViewById(R.id.emailAddress);
        edtPassword = findViewById(R.id.password);
        repeatPassword = findViewById(R.id.repeatPassword);

        mProgressBar = findViewById(R.id.progressBar);
        blurred_bg = findViewById(R.id.blurred_bg);

        //firebase init
        mAuth = FirebaseAuth.getInstance();


        goToLoginForm();
        signUp();
        //uploadFileToFirebase();
        hideSoftKeyboard();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//
//        if (currentUser!=null){
//            Intent intent = new Intent(getBaseContext(), MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//            finish();
//        }
//
//    }


    private void goToLoginForm(){
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
    private void signUp(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (emailAddress.getText().toString().equals("") || edtPassword.getText().toString().equals("") || repeatPassword.getText().toString().equals("")){
                    Toast.makeText(SignUpActivity.this, "Please fill up empty fields", Toast.LENGTH_SHORT).show();
                }else{
                    String email = emailAddress.getText().toString();
                    String password = edtPassword.getText().toString();
                    String rPassword = repeatPassword.getText().toString();

                    if (password.equals(rPassword)){
//                        mAuth.createUserWithEmailAndPassword(email, password)
//                                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<AuthResult> task) {
//                                        if (task.isSuccessful()) {
//                                            // Sign in success, update UI with the signed-in user's information
//                                            //Log.d(TAG, "createUserWithEmail:success");
//                                            FirebaseUser user = mAuth.getCurrentUser();
//                                            Toast.makeText(SignUpActivity.this, ""+user.getEmail(), Toast.LENGTH_SHORT).show();
//
//                                            // go to login form
//                                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
//                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                            startActivity(intent);
//                                            finish();
//
//                                        } else {
//                                            // If sign in fails, display a message to the user.
//                                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                                            Toast.makeText(getBaseContext(), "Authentication failed.",
//                                                    Toast.LENGTH_SHORT).show();
//                                            //updateUI(null);
//                                        }
//
//                                        // ...
//                                    }
//                                });

                        if (isValidDomain(email)){
                            registerNewEmail(email,password);
                        }else{
                            Toast.makeText(SignUpActivity.this, "Email is not valid", Toast.LENGTH_SHORT).show();
                        }


                    }else{
                        Toast.makeText(SignUpActivity.this, "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

//    private void uploadFileToFirebase(){
//        btnUpload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
////                startActivityForResult(i, RESULT_LOAD_IMAGE);
////                Intent intent = new Intent();
////                intent.setType("image/*");
////                intent.setAction(Intent.ACTION_GET_CONTENT);
////                startActivityForResult(Intent.createChooser(intent, "Select Picture"), RESULT_LOAD_IMAGE);
//
//                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
//                getIntent.setType("image/*");
//
//
//                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                pickIntent.setType("image/*");
//
//                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
//                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
//
//                startActivityForResult(chooserIntent, RESULT_LOAD_IMAGE);
//
//            }
//        });
//
//
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
//
//            Uri uri = data.getData();
//
//
//             realPath = ImageFilePath.getPath(SignUpActivity.this, data.getData());
//              // realPath = RealPathUtil.getRealPathFromURI_API19(this, data.getData());
//
//            //Log.i(TAG, "onActivityResult: file path : " + realPath);
//            Toast.makeText(this, "file path: "+realPath, Toast.LENGTH_SHORT).show();
//
//            // Upload to Firebase Storage
//
//            storage = FirebaseStorage.getInstance();
//            storageRef = storage.getReference();
//
//            Uri file = Uri.fromFile(new File(realPath));
//            StorageReference riversRef = storageRef.child("images/"+file.getLastPathSegment());
//            UploadTask uploadTask = riversRef.putFile(file);
//
//            // Register observers to listen for when the download is done or if it fails
//            uploadTask.addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception exception) {
//                    // Handle unsuccessful uploads
//                }
//            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
//                    // ...
//                    Toast.makeText(SignUpActivity.this, ""+taskSnapshot.getMetadata().getSizeBytes(), Toast.LENGTH_SHORT).show();
//
//                }
//            });
//
//
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//                // Log.d(TAG, String.valueOf(bitmap));
//
//                ImageView imageView = (ImageView) findViewById(R.id.img_profile);
//                imageView.setImageBitmap(bitmap);
//                imageView.setVisibility(View.VISIBLE);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
//        }
//
//    }

    public void registerNewEmail(final String email, String password){

        showDialog();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //  Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (task.isSuccessful()){
                            //  Log.d(TAG, "onComplete: AuthState: " + FirebaseAuth.getInstance().getCurrentUser().getUid());

                            //send email verificaiton
                            sendVerificationEmail();

                            FirebaseAuth.getInstance().signOut();

                            //redirect the user to the login screen
                            redirectLoginScreen();


                        }
                        if (!task.isSuccessful()) {

                            Toast.makeText(SignUpActivity.this, ""+task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
//                            Log.e("REGISTER ERROR", "onFailed: AuthState: " + task.getException().getMessage());
//                            //AuthState: The given password is invalid. [ Password should be at least 6 characters ]
//                            //The email address is already in use by another account.
                        }
                        hideDialog();

                        // ...
                    }
                });
    }
    private void sendVerificationEmail(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null){
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUpActivity.this, "Sent Verification Email", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SignUpActivity.this, "Couldn't send Verification Email", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
    private boolean isValidDomain(String email){
        // Log.d(TAG, "isValidDomain: verifying email has correct domain: " + email);
        String domain = email.substring(email.indexOf("@") + 1).toLowerCase();
        //Log.d(TAG, "isValidDomain: users domain: " + domain);
        return (domain.equals(DOMAIN_NAME)||domain.equals(DOMAIN_NAME2));
    }

    private void redirectLoginScreen(){
        // Log.d(TAG, "redirectLoginScreen: redirecting to login screen.");

        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void showDialog(){
        mProgressBar.setVisibility(View.VISIBLE);
        blurred_bg.setVisibility(View.VISIBLE);
    }
    private void hideDialog(){
        if(mProgressBar.getVisibility() == View.VISIBLE){
            mProgressBar.setVisibility(View.INVISIBLE);
            blurred_bg.setVisibility(View.INVISIBLE);
        }
    }

    private void hideSoftKeyboard(){
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


}
