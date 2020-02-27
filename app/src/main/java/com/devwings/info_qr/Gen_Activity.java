package com.devwings.info_qr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class Gen_Activity extends AppCompatActivity {
    String TAG="GenerateQrCode";
    EditText equipmentid;
    ImageView qrimage;
    Button genqr;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    String inputvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen);
        equipmentid=(EditText) findViewById(R.id.equipmentid);
        qrimage=(ImageView)findViewById(R.id.qrimage);
        genqr=(Button)findViewById(R.id.genqrbtn);
        genqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputvalue=equipmentid.getText().toString().trim();
                if(inputvalue.length()>0)
                {
                    WindowManager manager=(WindowManager)getSystemService(WINDOW_SERVICE);
                    Display display= manager.getDefaultDisplay();
                    Point point=new Point();
                    display.getRealSize(point);
                    int width=point.x;
                    int height=point.y;
                    int smallerdimension=width<height ? width:height ;
                    smallerdimension=smallerdimension*3/4;
                    qrgEncoder=new QRGEncoder(inputvalue,null, QRGContents.Type.TEXT,smallerdimension);
                    try {
                        bitmap=qrgEncoder.encodeAsBitmap();
                        qrimage.setImageBitmap(bitmap);
                        Toast.makeText(Gen_Activity.this, "QR generated successfully", Toast.LENGTH_SHORT).show();
                    }
                    catch (WriterException e)
                    {
                        Log.v(TAG,e.toString());
                    }
                }
                else{
                    equipmentid.setError("REQUIRED");
                }


            }
        });



    }
}
