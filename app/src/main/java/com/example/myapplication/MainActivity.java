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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView clickText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }
        });

        TextView problemTextView = findViewById(R.id.problem);
        TextView quickTextView = findViewById(R.id.quick_login);
        TextView registerTextView = findViewById(R.id.register_text);
        TextView modiTextView = findViewById(R.id.forget_password);

        String problemStr = getString(R.string.problem);
        SpannableStringBuilder problemStringBuilder = new SpannableStringBuilder(problemStr);
        ProblemTextViewSpan problemTextViewSpan = new ProblemTextViewSpan();
        problemStringBuilder.setSpan(problemTextViewSpan, 0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        String quickStr = getString(R.string.quick_login);
        SpannableStringBuilder quickStringBuilder = new SpannableStringBuilder(quickStr);
        QuickTextViewSpan quickTextViewSpan = new QuickTextViewSpan();
        quickStringBuilder.setSpan(quickTextViewSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        String registerStr = getString(R.string.register_text);
        SpannableStringBuilder registerStringBuiler = new SpannableStringBuilder(registerStr);
        RegisterTextViewSpan registerTextViewSpan = new RegisterTextViewSpan();
        registerStringBuiler.setSpan(registerTextViewSpan, 7, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        String modiPasswordStr = getString(R.string.foget_password);
        SpannableStringBuilder modiPasswordStringBuilder = new SpannableStringBuilder(modiPasswordStr);
        ModiTextViewSpan modiTextViewSpan = new ModiTextViewSpan();
        modiPasswordStringBuilder.setSpan(modiTextViewSpan, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        problemTextView.setText(problemStringBuilder);
        problemTextView.setMovementMethod(LinkMovementMethod.getInstance());

        quickTextView.setText(quickStringBuilder);
        quickTextView.setMovementMethod(LinkMovementMethod.getInstance());

        registerTextView.setText(registerStringBuiler);
        registerTextView.setMovementMethod(LinkMovementMethod.getInstance());

        modiTextView.setText(modiPasswordStringBuilder);
        modiTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private class ProblemTextViewSpan extends ClickableSpan {
        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(@NonNull View widget) {
            Intent intent = new Intent(MainActivity.this, ProblemActivity.class);
            startActivity(intent);
        }
    }

    private class QuickTextViewSpan extends ClickableSpan {
        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
            // ds.setColor(getResources().getColor(R.color.orange));
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(@NonNull View widget) {
            Intent intent = new Intent(MainActivity.this, QuickLoginActivity.class);
            startActivity(intent);
        }
    }

    private class RegisterTextViewSpan extends ClickableSpan {
        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
            ds.setColor(getResources().getColor(R.color.orange));
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(@NonNull View widget) {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    }

    private class ModiTextViewSpan extends ClickableSpan {
        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(@NonNull View widget) {
            Intent intent = new Intent(MainActivity.this, ModiPasswordActivity.class);
            startActivity(intent);
        }
    }
}