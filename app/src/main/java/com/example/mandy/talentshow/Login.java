package com.example.mandy.talentshow;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private Button sign_in ;// 登录
    private Button sign_up;//注册
    private EditText  email , login ;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sign_in = (Button) findViewById(R.id.sign_in_button);
        sign_up = (Button) findViewById(R.id.sign_up_button);
        email = (EditText) findViewById(R.id.activity_login_email);
        sign_in.setOnClickListener(this);
        sign_up.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_in_button:
                Intent intent1 = new Intent(Login.this , MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.sign_up_button:
                intent = new Intent(Login.this , Register.class);
                startActivityForResult(intent , 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 && resultCode ==2){
            String string = data.getStringExtra("Email");
            email.setText(string);
        }

    }
}
