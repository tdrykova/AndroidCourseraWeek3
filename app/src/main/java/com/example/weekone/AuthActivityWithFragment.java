package com.example.weekone;

import androidx.fragment.app.Fragment;

public class AuthActivityWithFragment extends SingleFragmentActivity{

    @Override
    protected Fragment getFragment() {
        return AuthFragment.newInstance();
    }
}
