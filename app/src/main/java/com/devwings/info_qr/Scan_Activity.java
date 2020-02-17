package com.devwings.info_qr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class Scan_Activity extends AppCompatActivity {


    SurfaceView surfaceView;
    CameraSource cameraSource;
    TextView textView4;
    BarcodeDetector barcodeDetector;
    private Button bugbtn;
    private Button userbtn;
    private Button man_updt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        final Vibrator vibe = (Vibrator) Scan_Activity.this.getSystemService(Context.VIBRATOR_SERVICE);

        surfaceView = (SurfaceView)findViewById(R.id.camerapreview);
        textView4 = (TextView)findViewById(R.id.textView4);

        bugbtn = findViewById(R.id.button7);

        userbtn=findViewById(R.id.button5);
        userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToUserPage();
            }
        });
        bugbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibe.vibrate(80);
                moveToReportPage();



                man_updt = findViewById(R.id.man_updt);
                man_updt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        moveToManualUpdatePage();
                    }
                });

            }
        });


        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE) .build();


        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640,480).build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try {
                    cameraSource.start(surfaceHolder);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes = detections.getDetectedItems();

                if(qrCodes.size()!=0)
                {
                    textView4.post(new Runnable() {
                        @Override
                        public void run() {
                            Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(1000);
                            textView4.setText(qrCodes.valueAt(0).displayValue);
                        }
                    });
                }
            }
        });

    }

    private void moveToReportPage(){

        Intent intent = new Intent(Scan_Activity.this, Report_a_Bug.class);
        startActivity(intent);
    }
    private void moveToManualUpdatePage(){

        Intent intent = new Intent(Scan_Activity.this, Manual_Update.class);
        startActivity(intent);
    }

    private void moveToUserPage(){
        Intent intent=new Intent(Scan_Activity.this,User_Info.class);
        startActivity(intent);
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