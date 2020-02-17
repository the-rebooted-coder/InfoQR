package com.devwings.info_qr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class Manual_Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_update);
    }

    public void saveQuote(View view) {
        EditText quoteView = (EditText) findViewById(R.id.editTextQuote);
        EditText authorView = (EditText) findViewById(R.id.editTextAuthor);
        String quoteText = quoteView.getText().toString();
        String authorText = quoteView.getText().toString();

        if (quoteText.isEmpty() || authorText.isEmpty()){
            return;
        }
        Map<String. Object> dataToSave = new 

    }
}
