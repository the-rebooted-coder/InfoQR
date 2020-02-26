package com.devwings.info_qr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Scan_Fetch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_fetch);

        Bundle bundle = getIntent().getExtras();
//Pass Data to String Variables
        String data_1 = bundle.getString("firstdata");

        TextView textView = (TextView) findViewById(R.id.textView11);

        textView.setText(data_1);


    }
}
