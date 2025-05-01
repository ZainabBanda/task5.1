package com.mine.newsapp2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText etFull, etUser, etPass, etConfirm;
    Button btnCreate;

    @Override protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_sign_up);

        etFull    = findViewById(R.id.etFullName);
        etUser    = findViewById(R.id.etUsername);
        etPass    = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirm);
        btnCreate = findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(v -> {
            String full = etFull.getText().toString().trim();
            String u    = etUser.getText().toString().trim();
            String p    = etPass.getText().toString();
            String c    = etConfirm.getText().toString();
            if (full.isEmpty() || u.isEmpty() || p.isEmpty() || !p.equals(c)) {
                Toast.makeText(this, "Please fill in correctly", Toast.LENGTH_SHORT).show();
                return;
            }
            SharedPreferences sp = getSharedPreferences("users", MODE_PRIVATE);
            sp.edit().putString(u, p).apply();
            Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
