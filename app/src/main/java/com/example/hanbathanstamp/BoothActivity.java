package com.example.hanbathanstamp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BoothActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booth); // 레이아웃 파일 이름이 activity_booth.xml인 경우

        // binary_41th
        ImageButton button10 = findViewById(R.id.imageButton10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram("https://www.instagram.com/binary_41th/");
            }
        });

        // delight_13th
        ImageButton button11 = findViewById(R.id.imageButton11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram("https://www.instagram.com/delight_13th/");
            }
        });

        // 42nd_shine
        ImageButton button12 = findViewById(R.id.imageButton12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram("https://www.instagram.com/42nd_shine/");
            }
        });

        // binary_41th (button13도 binary와 동일한 링크로 이동)
        ImageButton button13 = findViewById(R.id.imageButton13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram("https://www.instagram.com/binary_41th/");
            }
        });

        // hbnu_41st_link (more 버튼)
        ImageButton button14 = findViewById(R.id.imageButton14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram("https://www.instagram.com/hbnu_41st_link/");
            }
        });
    }

    private void openInstagram(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.setPackage("com.instagram.android");

        // 인스타그램 앱이 설치되지 않은 경우 브라우저로 열기
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        }
    }
}