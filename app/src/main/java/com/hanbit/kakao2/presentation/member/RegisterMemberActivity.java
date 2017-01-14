package com.hanbit.kakao2.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.kakao2.MainActivity;
import com.hanbit.kakao2.R;

public class RegisterMemberActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etID, etPass, etName, etTel, etAddr ;
    Button btSubmit, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_member);

        btSubmit = (Button) findViewById(R.id.btSubmit);
        btCancel= (Button) findViewById(R.id.btCancel);

        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*
        String id = etID.getText().toString();
        int pass = Integer.parseInt(etPass.getText().toString());
        String name = etName.getText().toString();
        int tel = Integer.parseInt(etTel.getText().toString());
        String addr = etAddr.getText().toString();
        */
        switch (v.getId()){
            case R.id.btSubmit :
                break;

            case R.id.btCancel :
                Toast.makeText(RegisterMemberActivity.this, "Click Cancel", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(RegisterMemberActivity.this, MainActivity.class));
                break;
        }
    }
}
