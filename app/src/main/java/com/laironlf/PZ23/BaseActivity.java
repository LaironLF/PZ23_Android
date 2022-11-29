package com.laironlf.PZ23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    ConstraintLayout main_layout;
    Intent mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        viewInit();
        intentInit();
        setListeners();
    }

    private void viewInit(){
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout_base);
    }

    private void intentInit(){
        mainActivity = new Intent(this, MainActivity.class);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setListeners(){
        main_layout.setOnTouchListener(new SwipeListener(){
            @Override
            public void swipeRight() {
                startActivity(new Intent(mainActivity));
                overridePendingTransition(R.anim.to_right_in, R.anim.to_right_out);
                finish();
            }
        });
    }
}