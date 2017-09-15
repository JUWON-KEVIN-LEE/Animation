package com.immymemine.kevin.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Test extends AppCompatActivity implements View.OnClickListener {
    ConstraintLayout stage;
    Button btn1, btn2, btn3, btn4, btnGoal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initView();
        initListener();

        /*
        // button 에 custom layout apply
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(100, 100);

        stage = (ConstraintLayout) findViewById(R.id.stage);
        Button player = new Button(this);
        player.setLayoutParams(lp);
        //player.setWidth(100);
        //player.setHeight(100);
        player.setText("P");
        player.setY(50);

        Button player2 = new Button(this);
        player2.setBackgroundColor(Color.RED);
        player2.setWidth(100);
        player2.setHeight(100);
        player2.setText("P");
        player2.setY(0);

        stage.addView(player);
        stage.addView(player2);
        */
    }
    private void initView() {
        stage = (ConstraintLayout)findViewById(R.id.stage);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btnGoal = (Button)findViewById(R.id.btnGoal);
    }
    private void initListener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v instanceof Button) { // Button 인지 확인
            Button original = (Button) v;

            final Button dummy = new Button(this);

            dummy.setText(original.getText().toString());
            dummy.setWidth(original.getWidth());
            dummy.setHeight(original.getHeight());

            LinearLayout parent = (LinearLayout) original.getParent();
            dummy.setX(original.getX() + parent.getX());
            dummy.setY(original.getY() + parent.getY());

            stage.addView(dummy);

            float goalX = btnGoal.getX();
            float goalY = btnGoal.getY();
            ObjectAnimator aniX = ObjectAnimator.ofFloat(dummy, "x", btnGoal.getX());
            ObjectAnimator aniY = ObjectAnimator.ofFloat(dummy, "y", btnGoal.getY());
            ObjectAnimator aniR = ObjectAnimator.ofFloat(dummy, "rotation", 3600);
            final AnimatorSet aniSet = new AnimatorSet();
            aniSet.playTogether(aniX, aniY, aniR);
            aniSet.setDuration(1500);
            aniSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    stage.removeView(dummy);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            aniSet.start();
        }

    }
}