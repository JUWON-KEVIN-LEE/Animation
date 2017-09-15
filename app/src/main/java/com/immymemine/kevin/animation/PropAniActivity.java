package com.immymemine.kevin.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class PropAniActivity extends AppCompatActivity {
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop_ani);
        btnGo = (Button)findViewById(R.id.go);
    }
    float y = 0;
    public void move(View view) {
        /*
        y = y + 100;

        ObjectAnimator ani = ObjectAnimator.ofFloat(btnGo, "translationY", y);
        ani.start();
        */
        ObjectAnimator aniX = ObjectAnimator.ofFloat(btnGo, "translationX", 100);
        ObjectAnimator aniY = ObjectAnimator.ofFloat(btnGo, "translationY", 100);
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.setDuration(3000);

        aniSet.setInterpolator(new LinearInterpolator());
        // 점점 빠르게 : acceleraterInterpolator
        // 점점 느리게 : deceleraterInterpol
        // // 위 둘을 동시에 : acceleraterDecelerateInterpolator
        // // 시작위치에서 조금 뒤로 당겼다 이동 : anticipateInterpolator
        // // 도착위치를 조금 지나쳤다가 도착위치로 이동 : overshootInterpolator
        // // 위 둘을 동시에 : anticipateOvershootInterpolator
        // // 도착위치에서 튕김 : bounceInterpolator
        aniSet.start();
    }
    public void goJoyStick(View view) {
        Intent intent = new Intent(this, JoystickActivity.class);
        startActivity(intent);
    }
}
