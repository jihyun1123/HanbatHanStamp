package com.example.hanbathanstamp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.HashSet;import android.content.pm.ActivityInfo;

public class QRScanActivity extends AppCompatActivity {

    private static final HashSet<String> VALID_CODES = new HashSet<String>() {{
        add("computer");
        add("information");
        add("material");
        add("japan");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(PortraitCaptureActivity.class); // 💥 세로 전용 CaptureActivity 설정
        integrator.setPrompt("QR 코드를 스캔하세요");
        integrator.setBeepEnabled(true);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setCameraId(0);
        integrator.initiateScan();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // 회전 방향이 바뀌었을 때 처리할 코드 (필요한 경우)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // 가로 모드일 때의 처리
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // 세로 모드일 때의 처리
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null && result.getContents() != null) {
            String scanned = result.getContents().toLowerCase();

            if (VALID_CODES.contains(scanned)) {
                Toast.makeText(this, "스탬프 획득!", Toast.LENGTH_SHORT).show();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("scan_result", scanned);
                setResult(RESULT_OK, resultIntent);
            } else {
                Toast.makeText(this, "QR 인식이 실패 했어!", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED);
            }
        } else {
            Toast.makeText(this, "QR 인식이 실패 했어!", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED);
        }

        finish(); // StampActivity 로 돌아감
    }
}