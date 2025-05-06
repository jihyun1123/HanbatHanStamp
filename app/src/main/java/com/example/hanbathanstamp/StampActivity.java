package com.example.hanbathanstamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hanbathanstamp.QRScanActivity;
import com.example.hanbathanstamp.R;

public class StampActivity extends AppCompatActivity {

    private static final int QR_SCAN_REQUEST = 100;

    private ImageView haniStamp, naniStamp, batiStamp, utiStamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stamp); // 이 XML 파일 이름이 activity_stamp.xml이라고 가정

        ImageButton scanButton = findViewById(R.id.imageButton6);
        haniStamp = findViewById(R.id.hani_stamp);
        naniStamp = findViewById(R.id.nani_stamp);
        batiStamp = findViewById(R.id.bati_stamp);
        utiStamp = findViewById(R.id.uti_stamp);

        // 초기 투명도 설정 (50%)
        setAlphaAllStamps(0.5f);

        // 스캔 버튼 클릭 이벤트
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scanIntent = new Intent(StampActivity.this, QRScanActivity.class);
                startActivityForResult(scanIntent, QR_SCAN_REQUEST);
            }
        });
    }

    private void setAlphaAllStamps(float alpha) {
        haniStamp.setAlpha(alpha);
        naniStamp.setAlpha(alpha);
        batiStamp.setAlpha(alpha);
        utiStamp.setAlpha(alpha);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == QR_SCAN_REQUEST && resultCode == RESULT_OK && data != null) {
            String result = data.getStringExtra("scan_result");
            if (result != null) {
                result = result.toLowerCase();

                if (result.contains("computer")) {
                    naniStamp.setAlpha(1.0f);
                } else if (result.contains("information")) {
                    haniStamp.setAlpha(1.0f);
                } else if (result.contains("material")) {
                    utiStamp.setAlpha(1.0f);
                } else if (result.contains("japan")) {
                    batiStamp.setAlpha(1.0f);
                }
            }
        }
    }

}