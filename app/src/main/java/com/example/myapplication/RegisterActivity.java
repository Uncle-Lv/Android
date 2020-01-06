package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        ImageView backImage = findViewById(R.id.back);

        final RadioButton checkButton = findViewById(R.id.radio_button);
        Button registerButton = findViewById(R.id.register_button);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView sendVeriView = findViewById(R.id.send_veri_code);

        String sendVeriStr = getString(R.string.send_veri_code);
        SpannableStringBuilder sendVeriStringBuilder = new SpannableStringBuilder(sendVeriStr);
        SendVeriTextViewSpan sendVeriTextViewSpan = new SendVeriTextViewSpan();
        sendVeriStringBuilder.setSpan(sendVeriTextViewSpan, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        sendVeriView.setText(sendVeriStringBuilder);
        sendVeriView.setMovementMethod(LinkMovementMethod.getInstance());

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkButton.isChecked()) {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "请先同意《用户协议》", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private class SendVeriTextViewSpan extends ClickableSpan {
        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(@NonNull View widget) {
            Toast.makeText(RegisterActivity.this, "验证码已发送", Toast.LENGTH_SHORT).show();
        }
    }
}
