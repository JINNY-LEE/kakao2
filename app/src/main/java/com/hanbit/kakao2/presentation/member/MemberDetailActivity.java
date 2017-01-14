package com.hanbit.kakao2.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hanbit.kakao2.R;
import com.hanbit.kakao2.domian.MemberBean;
import com.hanbit.kakao2.service.MemberService;
import com.hanbit.kakao2.service.MemberServiceImp;
import com.hanbit.kakao2.util.Phone;

public class MemberDetailActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService service;
    MemberBean member;
    TextView tvID, tvPass, tvName, tvTel, tvAddr;
    Button btCall, btMap, btMessage, btUpdate, btDelete, btList;
    Phone phone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);

        service = new MemberServiceImp(this.getApplicationContext());
        member = new MemberBean();
        phone = new Phone(this,this);

        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        member = service.searchById(id);
        tvID = (TextView) findViewById(R.id.tvID);
        tvPass = (TextView) findViewById(R.id.tvPass);
        tvName = (TextView) findViewById(R.id.tvName);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvAddr = (TextView) findViewById(R.id.tvAddr);

        tvID.setText(member.getId());
        tvPass.setText(member.getPw());
        tvName.setText(member.getName());
        tvTel.setText(member.getPhone());
        tvAddr.setText(member.getAddress());


        btCall = (Button) findViewById(R.id.btCall);
        btMap = (Button) findViewById(R.id.btMap);
        btMessage = (Button) findViewById(R.id.btMessage);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);
        btList = (Button) findViewById(R.id.btList);

        btCall.setOnClickListener(this);
        btMap.setOnClickListener(this);
        btMessage.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        btList.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case  R.id.btCall :
                Log.d("전화번호",member.getPhone());
                phone.dial(member.getPhone());
            break;

            case R.id.btMap :
            break;

            case R.id.btMessage :
            break;

            case R.id.btUpdate :
                Intent intent = new Intent(MemberDetailActivity.this,ModifyMemberActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);

            case R.id.btDelete :
                service.unregister(member.getId());
                startActivity(new Intent(MemberDetailActivity.this, ModifyMemberActivity.class));
        }

    }
}
