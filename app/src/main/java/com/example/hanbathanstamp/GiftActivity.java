package com.example.hanbathanstamp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class GiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift); // 레이아웃 파일 이름이 activity_gift.xml인 경우

        ImageButton button19 = findViewById(R.id.imageButton19);

        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiftActivity.this, QRscanActivity.class);
                startActivity(intent);
            }
        });
    }
}
