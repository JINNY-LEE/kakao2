package com.hanbit.kakao2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_intro);
        Handler handler = new Handler();
        handler.postDelayed(()-> {
            startActivity(new Intent(IntroActivity.this, MainActivity.class));
            finish();
        }, 2000 );

    }

    @Override
    protected void onStart() {
        super.onStart();
/*
          try{
              Thread.sleep(5000);
          } catch (Exception e) {
              e.printStackTrace();
          }
*/
    }
}
