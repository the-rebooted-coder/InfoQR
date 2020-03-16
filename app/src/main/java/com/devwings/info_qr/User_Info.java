package com.devwings.info_qr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
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
        usrnm=(TextView)findViewById(R.id.textView10);
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
            Toast.makeText(this, "plaese be logged in", Toast.LENGTH_SHORT).show();
        }
    }
}