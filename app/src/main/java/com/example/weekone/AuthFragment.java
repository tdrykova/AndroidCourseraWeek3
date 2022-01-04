package com.example.weekone;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class AuthFragment extends Fragment {

    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegister;

    public static AuthFragment newInstance() {
        Bundle args = new Bundle();
        AuthFragment fragment = new AuthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private View.OnClickListener mEnterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isEmailValid() && isPasswordValid()) {
                Intent startProfileIntent =
                        new Intent(getActivity(), ProfileActivity.class);
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
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, RegistrationFragment.newInstance())
                    .commit();
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
        Toast.makeText(getActivity(), str, Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fr_auth, container, false);

        mLogin = view.findViewById(R.id.etLogin);
        mPassword = view.findViewById(R.id.etPassword);
        mEnter = view.findViewById(R.id.buttonEnter);
        mRegister = view.findViewById(R.id.buttonRegister);

        mEnter.setOnClickListener(mEnterOnClickListener);
        mRegister.setOnClickListener(mRegisterOnClickListener);

        return view;
    }
}