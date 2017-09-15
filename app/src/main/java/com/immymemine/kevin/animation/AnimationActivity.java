package com.immymemine.kevin.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnM, btnR, btnS, btnA, object, btnTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();
        initListener();
    }

    private void initView() {
        btnM = (Button)findViewById(R.id.btnM);
        btnR = (Button)findViewById(R.id.btnR);
        btnS = (Button)findViewById(R.id.btnS);
        btnA = (Button)findViewById(R.id.btnA);
        object = (Button)findViewById(R.id.object);
        btnTest = (Button)findViewById(R.id.btnTest);
    }

    private void initListener() {
        btnM.setOnClickListener(this);
        btnR.setOnClickListener(this);
        btnS.setOnClickListener(this);
        btnA.setOnClickListener(this);
        object.setOnClickListener(this);
        btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnM: move();
                break;
            case R.id.btnA: alpha();
                break;
            case R.id.btnR: rotate();
                break;
            case R.id.btnS: scale();
                break;
            case R.id.object: property();
                break;
            case R.id.btnTest: goTest();
                break;
        }
    }
    private void move() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);
        object.startAnimation(animation);
    }
    private void rotate() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        object.startAnimation(animation);
    }
    private void scale() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        object.startAnimation(animation);
    }
    private void alpha() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        object.startAnimation(animation);
    }
    private void property() {
        Intent intent = new Intent(this, PropAniActivity.class);
        startActivity(intent);
    }
    private void goTest() {
        Intent intent = new Intent(this, Test.class);
        startActivity(intent);
    }
}
