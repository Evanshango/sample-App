package com.evans.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {

    EditText mName, mEmail, mPassword, mConfirmPassword;
    private Button mRegister;
    CircleImageView mImage;
    TextView mHaveAnAccount;
    private String myName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeVariables();

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput())
                    doRegister();
            }
        });

        mHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void doRegister() {
        //some logic
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        intent.putExtra("MyName", myName);
        startActivity(intent);
        finish();
    }

    private void initializeVariables() {
        mName = findViewById(R.id.reg_name);
        mEmail = findViewById(R.id.reg_email);
        mPassword = findViewById(R.id.reg_password);
        mConfirmPassword = findViewById(R.id.reg_confirm_password);
        mImage = findViewById(R.id.reg_account);
        mRegister = findViewById(R.id.btn_register);
        mHaveAnAccount = findViewById(R.id.txt_already_have_an_account);
    }


    private boolean validateInput(){
        boolean isInputValid = false;

        myName = mName.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String cpassword = mConfirmPassword.getText().toString().trim();

        if (!myName.isEmpty()){
            if (!email.isEmpty()){
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (!password.isEmpty()){
                        if (!cpassword.isEmpty()){
                            if (password.equals(cpassword)){
                                if (password.length() >=6){
                                    isInputValid = true;
                                } else {
                                    mPassword.setError("Password should be at least 6 characters long");
                                    mPassword.requestFocus();
                                }
                            } else {
                                Toast.makeText(this, "Password mismatch", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            mConfirmPassword.setError("Password confirmation is required");
                            mConfirmPassword.requestFocus();
                        }
                    } else {
                        mPassword.setError("Password is required");
                        mPassword.requestFocus();
                    }
                } else {
                    mEmail.setError("Enter a valid email");
                    mEmail.requestFocus();
                }
            } else {
                mEmail.setError("Email is required");
                mEmail.requestFocus();
            }
        } else {
            mName.setError("Name is required");
            mName.requestFocus();
        }

        return isInputValid;
    }

}
