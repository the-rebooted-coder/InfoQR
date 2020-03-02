package com.devwings.info_qr;

import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Manual_Update extends AppCompatActivity {
    private View myView;
    private Vibrator myVib;

    EditText editTextName;
    Button buttonAdd;
    EditText spinnerGenres;
    EditText service_date;

    DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_manual_update);
        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");

        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAdd = (Button) findViewById(R.id.buttonAddArtist);
        spinnerGenres = (EditText) findViewById(R.id.spinnerGenres);
        service_date = (EditText) findViewById(R.id.service_date);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addArtist();
            }
        });
    }
    private void addArtist(){
        String name = editTextName.getText().toString().trim();
        String genre  = spinnerGenres.getText().toString().trim();
        String date = service_date.getText().toString().trim();

        if (!TextUtils.isEmpty(name))
        {
            String id = databaseArtists.push().getKey();
            Artist artist = new Artist(id, name, genre, date);
            databaseArtists.child(id).setValue(artist);
            Toast.makeText(this, "Record Added!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "You should Enter a Name", Toast.LENGTH_LONG).show();
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