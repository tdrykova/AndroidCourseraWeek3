package com.example.weekone;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuthActivitySeparate extends AppCompatActivity {

    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegister;

    private View.OnClickListener mEnterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isEmailValid() && isPasswordValid()) {
                Intent startProfileIntent =
                        new Intent(AuthActivitySeparate.this, ProfileActivity.class);
//                startProfileIntent.putExtra(ProfileActivity.EMAIL_KEY, mLogin.getText().toString());
//                startProfileIntent.putExtra(ProfileActivity.PASSWORD_KEY, mPassword.getText().toString());

                // класс User Serializable
                startProfileIntent.putExtra(ProfileActivity.USER_KEY,
                        new User(mLogin.getText().toString(), mPassword.getText().toString()));
                startActivity(startProfileIntent);
            } else {
                showMessage(R.string.login_input_error);
            }
        }
    };

    private View.OnClickListener mRegisterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // todo
        }
    };

    private boolean isEmailValid() {
        return !TextUtils.isEmpty(mLogin.getText())
                && Patterns.EMAIL_ADDRESS.matcher(mLogin.getText()).matches();
    }

    private boolean isPasswordValid() {
        return !TextUtils.isEmpty(mPassword.getText());
    }

    private void showMessage(@StringRes int str) {   // Почему тип int?
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_auth);

        mLogin = findViewById(R.id.etLogin);
        mPassword = findViewById(R.id.etPassword);
        mEnter = findViewById(R.id.buttonEnter);
        mRegister = findViewById(R.id.buttonRegister);

        mEnter.setOnClickListener(mEnterOnClickListener);
        mRegister.setOnClickListener(mRegisterOnClickListener);
    }
}