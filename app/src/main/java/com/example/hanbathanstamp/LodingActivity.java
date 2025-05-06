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

        firework1 = findViewById(R.id.firwork1);
        firework2 = findViewById(R.id.firework2);
        hani = findViewById(R.id.hani);
        nani = findViewById(R.id.nani);

        // 불꽃놀이 Scale 애니메이션 (firework1)
        Animation firework1Anim = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        firework1Anim.setDuration(2000);

        // firework2는 더 크고 위로 퍼지는 애니메이션
        Animation firework2Anim = AnimationUtils.loadAnimation(this, R.anim.scale_up_translate_up);
        firework2Anim.setDuration(2000);

        // hani 위로 이동하는 애니메이션
        Animation haniUpAnim = AnimationUtils.loadAnimation(this, R.anim.translate_up_animation);
        haniUpAnim.setDuration(1000); // 1초로 속도 빠르게 설정

        // hani 아래로 이동하는 애니메이션
        Animation haniDownAnim = AnimationUtils.loadAnimation(this, R.anim.translate_down_animation);
        haniDownAnim.setDuration(1000); // 1초로 속도 빠르게 설정

        // nani 위로 이동하는 애니메이션
        Animation naniUpAnim = AnimationUtils.loadAnimation(this, R.anim.translate_up_animation);
        naniUpAnim.setDuration(1000); // 1초로 속도 빠르게 설정

        // nani 아래로 이동하는 애니메이션
        Animation naniDownAnim = AnimationUtils.loadAnimation(this, R.anim.translate_down_animation);
        naniDownAnim.setDuration(1000); // 1초로 속도 빠르게 설정

        // naniUpAnim 끝나면 -> LoginActivity 이동
        naniUpAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(LodingActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        // 애니메이션 반복 설정
        haniUpAnim.setRepeatCount(1); // 1번 반복
        haniUpAnim.setRepeatMode(Animation.REVERSE); // 반복 시 위아래로 번갈아 반복

        naniUpAnim.setRepeatCount(1); // 1번 반복
        naniUpAnim.setRepeatMode(Animation.REVERSE); // 반복 시 위아래로 번갈아 반복

        // 애니메이션 시작
        firework1.startAnimation(firework1Anim);
        firework2.startAnimation(firework2Anim);
        hani.startAnimation(haniUpAnim);
        nani.startAnimation(naniUpAnim);
    }
}
