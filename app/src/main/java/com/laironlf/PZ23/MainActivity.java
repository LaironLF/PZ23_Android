package com.laironlf.PZ23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout main_layout;
    Intent baseActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewInit();
        intentInit();
        setListeners();
    }

    private void viewInit(){
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
    }

    private void intentInit(){
        baseActivity = new Intent(this, BaseActivity.class);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setListeners(){
        main_layout.setOnTouchListener(new SwipeListener(){
            @Override
            public void swipeLeft() {
                startActivity(new Intent(baseActivity));
                overridePendingTransition(R.anim.to_left_in, R.anim.to_left_out);
                finish();
            }
        });
    }
}