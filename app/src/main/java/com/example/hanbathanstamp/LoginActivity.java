package com.example.hanbathanstamp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText loginText;
    private EditText passwordText;
    private ImageButton behindIcon;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginText = findViewById(R.id.logintext);
        passwordText = findViewById(R.id.passwordtext);
        behindIcon = findViewById(R.id.behindicon);
        Button loginButton = findViewById(R.id.loginbutton);

        behindIcon.setOnClickListener(v -> {
            if (isPasswordVisible) {
                passwordText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                isPasswordVisible = false;
            } else {
                passwordText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                isPasswordVisible = true;
            }
            passwordText.setSelection(passwordText.getText().length());
        });

        loginButton.setOnClickListener(v -> {
            String enteredId = loginText.getText().toString();
            String enteredPassword = passwordText.getText().toString();

            if (enteredId.equals("20231988") && enteredPassword.equals("1234*")) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "학번 또는 비밀번호가 올바르지 않습니다!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}