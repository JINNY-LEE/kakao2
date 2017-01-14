package com.hanbit.kakao2.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.kakao2.R;
import com.hanbit.kakao2.domian.MemberBean;
import com.hanbit.kakao2.service.MemberService;
import com.hanbit.kakao2.service.MemberServiceImp;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    Button btLogin, btCancel;
    EditText etID, etPass;
    MemberService service;
    MemberBean member;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etID = (EditText) findViewById(R.id.etID);
        etPass= (EditText) findViewById(R.id.etPass);

        btLogin = (Button) findViewById(R.id.btLogin);
        btCancel = (Button) findViewById(R.id.btCancel);

        btLogin.setOnClickListener(this);
        btCancel.setOnClickListener(this);

        service = new MemberServiceImp(this.getApplicationContext());
        // context는 우리가 알 수 없고, memberServiceImp에서 은닉화되어 구현
        member = new MemberBean();
    }



    @Override
    public void onClick(View v) {

        String id = String.valueOf(etID.getText());
        String pw = String.valueOf(etPass.getText());

        Log.d("넘어온 ID:", id);
        Log.d("넘어온 PW:", pw);
        member.setId(id);
        member.setPw(pw);

        switch (v.getId()){
            case R.id.btLogin:
                boolean flag = service.login(member);
                if(flag){
                    Toast.makeText(LoginActivity.this,"Login Success",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this,"Login Fail",Toast.LENGTH_LONG).show();
                    this.startActivity(new Intent(LoginActivity.this, com.hanbit.kakao2.presentation.member.MemberListActivity.class));
                }

                break;
            case R.id.btCancel:
                this.startActivity(new Intent(LoginActivity.this, com.hanbit.kakao2.presentation.member.MemberListActivity.class));

                break;

        }
    }
}
