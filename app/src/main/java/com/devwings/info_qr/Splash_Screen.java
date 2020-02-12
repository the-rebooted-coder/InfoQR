package com.devwings.info_qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Splash_Screen extends AppCompatActivity {
    private static int splash_screen_time_out=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Splash_Screen.this,Login_Activity.class);
                startActivity(i);
                finish();
            }
        },splash_screen_time_out);
    }
}


/*
  .--. .----..----.     .---..----..----. .--. .---..----.----.    .----.-.  .-.
 / {} \| {}  | {}  }   /  ___| {}  | {_  / {} {_   _| {_ | {}  \   | {}  \ \/ /
/  /\  | .--'| .--'    \     | .-. | {__/  /\  \| | | {__|     /   | {}  }}  {
`-'  `-`-'   `-'        `---'`-' `-`----`-'  `-'`-' `----`----'    `----' `--'


 _____               ________ __
|     \.-----.--.--.|  |  |  |__|.-----.-----.-----.
|  --  |  -__|  |  ||  |  |  |  ||     |  _  |__ --|
|_____/|_____|\___/ |________|__||__|__|___  |_____|
                                       |_____|

Spandan, Arpit, Eshita, Param, Akshat, Amit

 */
