package com.example.hanbathanstamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private ImageButton imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // ImageButton 초기화
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5 = findViewById(R.id.imageButton5);
        imageButton6 = findViewById(R.id.imageButton6);
        imageButton7 = findViewById(R.id.imageButton7);
        imageButton8 = findViewById(R.id.imageButton8);

        // 버튼 클릭 리스너 설정
        setOnClickListener(imageButton3, StampActivity.class);
        setOnClickListener(imageButton4, IntroduceActivity.class);
        setOnClickListener(imageButton5, BoothActivity.class);
        setOnClickListener(imageButton6, StampActivity.class);
        setOnClickListener(imageButton7, GiftActivity.class);
        setOnClickListener(imageButton8, FormActivity.class);
    }

    // 공통 클릭 리스너 메서드
    private void setOnClickListener(ImageButton imageButton, final Class<?> targetActivity) {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, targetActivity);
                startActivity(intent);
            }
        });
    }
}


