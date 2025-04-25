package com.example.hanbathanstamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LodingActivity extends AppCompatActivity {

    private ImageView firework1, firework2, hani, nani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);

        // ImageView 참조
        firework1 = findViewById(R.id.firwork1);
        firework2 = findViewById(R.id.firework2);
        hani = findViewById(R.id.hani);
        nani = findViewById(R.id.nani);

        // Scale 애니메이션
        Animation scaleAnim1 = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        Animation scaleAnim2 = AnimationUtils.loadAnimation(this, R.anim.scale_animation);

        // Translate 애니메이션
        Animation translateAnim1 = AnimationUtils.loadAnimation(this, R.anim.translate_animation);
        Animation translateAnim2 = AnimationUtils.loadAnimation(this, R.anim.translate_animation);

        // 애니메이션 리스너 설정
        Animation.AnimationListener animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // 애니메이션 시작 시 동작 (필요시 추가)
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // 애니메이션 종료 후 LoginActivity로 이동
                Intent intent = new Intent(LodingActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();  // 현재 Activity 종료
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // 애니메이션 반복 시 동작 (필요시 추가)
            }
        };

        // 애니메이션에 리스너 설정
        scaleAnim1.setAnimationListener(animationListener);
        scaleAnim2.setAnimationListener(animationListener);
        translateAnim1.setAnimationListener(animationListener);
        translateAnim2.setAnimationListener(animationListener);

        // 애니메이션 시작
        firework1.startAnimation(scaleAnim1);
        firework2.startAnimation(scaleAnim2);

        hani.startAnimation(translateAnim1);
        nani.startAnimation(translateAnim2);
    }
}
