package com.example.mandy.talentshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Mandy on 2016/9/6.
 */
public class Register extends Activity {
    private EditText etEmail;
    private Button sure_sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmail = (EditText) findViewById(R.id.etEmail);
        sure_sign_up = (Button) findViewById(R.id.sure_sign_up);
        sure_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(Register.this , Login.class);
                intentRegister.putExtra("Email"  , etEmail.getText().toString());
                setResult( 2 , intentRegister);
                finish();
            }
        });


    }
}
