package com.example.hanbathanstamp;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_GALLERY = 1;

    private EditText editTextText, editTextText2, editTextText3, editTextText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editTextText = findViewById(R.id.editTextText);   // 이름 입력
        editTextText2 = findViewById(R.id.editTextText2); // 두 번째 필드
        editTextText3 = findViewById(R.id.editTextText3); // 이미지 경로
        editTextText4 = findViewById(R.id.editTextText4); // 메시지

        // 한글만 입력 가능하도록 필터 설정
        editTextText.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (!Character.toString(source.charAt(i)).matches("[가-힣]")) {
                        return ""; // 한글이 아니면 입력 차단
                    }
                }
                return null;
            }
        }});

        ImageButton imageButton20 = findViewById(R.id.imageButton20); // 제출 버튼
        ImageButton imageButton21 = findViewById(R.id.imageButton21); // 이미지 선택 버튼

        imageButton20.setOnClickListener(v -> handleSubmit());

        imageButton21.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, REQUEST_CODE_GALLERY);
        });
    }

    private void handleSubmit() {
        String name = editTextText.getText().toString().trim();
        String field2 = editTextText2.getText().toString().trim();
        String imagePath = editTextText3.getText().toString().trim();
        String message = editTextText4.getText().toString().trim();

        if (name.isEmpty() || field2.isEmpty() || imagePath.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "입력칸을 다 채워줘!", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "제출 완료!", Toast.LENGTH_SHORT).show();

        // HomeActivity로 이동
        Intent intent = new Intent(FormActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                String imagePath = getRealPathFromURI(selectedImageUri);
                editTextText3.setText(imagePath);
            }
        }
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            String path = cursor.getString(column_index);
            cursor.close();
            return path;
        }
        return null;
    }
}
