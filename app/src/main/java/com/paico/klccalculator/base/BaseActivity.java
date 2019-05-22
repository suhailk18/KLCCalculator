package com.paico.klccalculator.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.paico.klccalculator.apputility.ViewUtils;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        init();
    }

    public abstract int getLayout();

    public abstract void init();

    @Override
    protected void onResume() {
        super.onResume();
        ViewUtils.hideKeyboardOnStartActivity(this);
    }


}
