package com.devwings.info_qr;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class User_Info extends AppCompatActivity {
    FirebaseUser currentUser;
    TextView usrnm;
    TextView useremail;
    ImageView userphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_nfo);
        final TextView  username = findViewById(R.id.username_field);
        username.setText("UserName:");
        username.postDelayed(new Runnable() {
            @Override
            public void run() {
                username.setVisibility(View.INVISIBLE);
            }
        },6000);

        final TextView usersemail = findViewById(R.id.usersemial);
        usersemail.setText("Email ID:");
        usersemail.postDelayed(new Runnable() {
            @Override
            public void run() {
                usersemail.setVisibility(View.INVISIBLE);
            }
        },6000);

        usrnm= findViewById(R.id.textView10);
        useremail=findViewById(R.id.textView12);
        userphoto=findViewById(R.id.imageView1);
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser!=null)
        {
            String name=currentUser.getDisplayName();
            usrnm.setText(name);
            String email=currentUser.getEmail();
            useremail.setText(email);
            Uri photo=currentUser.getPhotoUrl();
            userphoto.setImageURI(photo);


        }
        else {
            Toast.makeText(this, "Please be logged in", Toast.LENGTH_SHORT).show();
        }
    }
}
/*
 _____           __          ___
 |  __ \          \ \        / (_)
 | |  | | _____   _\ \  /\  / / _ _ __   __ _ ___
 | |  | |/ _ \ \ / /\ \/  \/ / | | '_ \ / _` / __|
 | |__| |  __/\ V /  \  /\  /  | | | | | (_| \__ \
 |_____/ \___| \_/    \/  \/   |_|_| |_|\__, |___/
                                         __/ |
                                        |___/
 */