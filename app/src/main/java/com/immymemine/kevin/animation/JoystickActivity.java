package com.immymemine.kevin.animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class JoystickActivity extends AppCompatActivity {
    Button btnP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joystick);
        btnP = (Button)findViewById(R.id.btnP);
    }
    int playerX = 0;
    int playerY = 0;
    public void move(View view) {
        ObjectAnimator aniX;
        ObjectAnimator aniY;
        switch (view.getId()) {
            case R.id.btnU:
                playerY -= 100;
                aniY = ObjectAnimator.ofFloat(btnP, "translationY", playerY);
                aniY.start();
                break;
            case R.id.btnD:
                playerY += 100;
                aniY = ObjectAnimator.ofFloat(btnP, "translationY", playerY);
                aniY.start();
                break;
            case R.id.btnL:
                playerX -= 100;
                aniX = ObjectAnimator.ofFloat(btnP, "translationX", playerX);
                aniX.start();
                break;
            case R.id.btnR:
                playerX += 100;
                aniX = ObjectAnimator.ofFloat(btnP, "translationX", playerX);
                aniX.start();
                break;
        }
    }
}
