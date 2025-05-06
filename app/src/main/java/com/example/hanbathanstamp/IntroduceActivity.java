package com.example.hanbathanstamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class IntroduceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce); // introduce.xml과 연결된 layout 파일명

        // booth 버튼 클릭 시 BoothActivity로 이동
        ImageButton boothButton = findViewById(R.id.imageButton);
        boothButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroduceActivity.this, BoothActivity.class);
                startActivity(intent);
            }
        });

        // gift 버튼 클릭 시 GiftActivity로 이동
        ImageButton giftButton = findViewById(R.id.imageButton2);
        giftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroduceActivity.this, GiftActivity.class);
                startActivity(intent);
            }
        });

        // instagram 버튼 클릭 시 인스타 링크로 이동
        ImageButton instagramButton = findViewById(R.id.imageButton9);
        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/hbnu_41st_link/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}