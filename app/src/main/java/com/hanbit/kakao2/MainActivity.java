package com.hanbit.kakao2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hanbit.kakao2.presentation.member.LoginActivity;
import com.hanbit.kakao2.presentation.member.RegisterMemberActivity;
import com.hanbit.kakao2.util.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btLogin, btRegister, btHelp;
    //LinearLayout help_center;
    TextView menu_home;
    View mCustomView;
    private BackPressCloseHandler backPressCloseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menu_home = (TextView) findViewById(R.id.menu_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        mCustomView = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_custombar,null);
        actionBar.setCustomView(mCustomView);
        setContentView(R.layout.activity_main);
        init();


    }


    public void init(){

        btRegister = (Button) findViewById(R.id.btRegister);
        //help_center = findViewById(R.id.help_center);
        btLogin = (Button) mCustomView.findViewById(R.id.btLogin);
        //btHelp = (Button) mCustomView.findViewById(R.id.menu_help);

        btRegister.setOnClickListener(this);
        //help_center.setOnClickListener(this);
        btLogin.setOnClickListener(this);
        //btHelp.setOnClickListener(this);
        backPressCloseHandler = new BackPressCloseHandler(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btRegister:
                this.startActivity(new Intent(MainActivity.this, RegisterMemberActivity.class));
                break;

            case R.id.btLogin:
                this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;

        }

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }
}