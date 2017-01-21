package com.hanbit.kakao2.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.kakao2.R;
import com.hanbit.kakao2.domian.MemberBean;
import com.hanbit.kakao2.service.MemberService;
import com.hanbit.kakao2.service.MemberServiceImp;

import java.util.List;

public class ModifyMemberActivity extends AppCompatActivity implements View.OnClickListener {
    Button btSubmit, btCancel;
    EditText etPass, etName, etTel, etAddr;
    TextView tvID;
    MemberService service;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        service = new MemberServiceImp(this.getApplicationContext());
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        member = service.searchById(id);


        tvID = (TextView) findViewById(R.id.tvID);
        etPass = (EditText) findViewById(R.id.etPass);
        etName = (EditText) findViewById(R.id.etName);
        etTel = (EditText) findViewById(R.id.etTel);
        etAddr = (EditText) findViewById(R.id.etAddr);

        btSubmit = (Button) findViewById(R.id.btSubmit);
        btCancel = (Button) findViewById(R.id.btCancel);

        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);

        service = new MemberServiceImp(this.getApplicationContext());
        List<MemberBean> list = service.list();

        tvID.setText(member.getId());
        etPass.setHint(member.getPw());
        etName.setHint(member.getName());
        etTel.setHint(member.getPhone());
        etAddr.setHint(member.getAddress());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSubmit:
                MemberBean temp = new MemberBean();
                temp.setId(tvID.getText().toString());
                temp.setPw((etPass.getText().toString().equals(""))?member.getPw():etPass.getText().toString());
                temp.setName((etName.getText().toString().equals(""))?member.getName():etName.getText().toString());
                temp.setAddress((etAddr.getText().toString().equals(""))?member.getAddress():etAddr.getText().toString());
                temp.setPhone((etTel.getText().toString().equals(""))?member.getPhone():etAddr.getText().toString());
                service.modify(temp);
                break;
            case R.id.btCancel:
                //this.startActivity(new Intent(ModifyMemberActivity.this, SearchMemberActivity.class));
                break;
        }
        Intent intent = new Intent(this,MemberDetailActivity.class);
        intent.putExtra("id",member.getId());
        startActivity(intent);
    }
}
