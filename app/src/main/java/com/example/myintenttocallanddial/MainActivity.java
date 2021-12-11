package com.example.myintenttocallanddial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEdtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtPhone = findViewById(R.id.edt_phone);
        Button btnCall = findViewById(R.id.btn_call);
        Button btnDial = findViewById(R.id.btn_dial);

        btnCall.setOnClickListener(v -> {
            callOrDial(v);
        });
        btnDial.setOnClickListener(v -> {
            callOrDial(v);
        });
    }

    private void callOrDial(View v) {
        String value = mEdtPhone.getText().toString().trim();
        if (value.length() < 9) {
            return;
        }

        String action = "";
        if (v.getId() == R.id.btn_call) {
            action = Intent.ACTION_CALL;
        } else if (v.getId() == R.id.btn_dial) {
            action = Intent.ACTION_DIAL;
        }

        value = "tel:" + value;
        Intent intent = new Intent(action);
        intent.setData(Uri.parse(value));
        startActivity(intent);

    }
}