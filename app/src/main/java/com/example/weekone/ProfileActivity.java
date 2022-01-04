package com.example.weekone;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class ProfileActivity extends AppCompatActivity {

//    public static String EMAIL_KEY = "EMAIL_KEY";
//    public static String PASSWORD_KEY = "PASSWORD_KEY";
      public static String USER_KEY = "USER_KEY";

    private TextView mLogin;
    private TextView mPassword;
    private AppCompatImageView mPhoto;

    private View.OnClickListener mOnPhotoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_profile);

        mLogin = findViewById(R.id.tvEmail);
        mPassword = findViewById(R.id.tvPassword);
        mPhoto = findViewById(R.id.ivPhoto);

        mPhoto.setOnClickListener(mOnPhotoClickListener);

        Bundle bundle = getIntent().getExtras();
//        mLogin.setText(bundle.getString(EMAIL_KEY));
//        mPassword.setText(bundle.getString(PASSWORD_KEY));

        User user = (User) bundle.get(USER_KEY);
        mLogin.setText(user.getLogin());
        mPassword.setText(user.getPassword());

    }
}
