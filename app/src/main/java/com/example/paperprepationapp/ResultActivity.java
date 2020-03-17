package com.example.paperprepationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView t1_total,t2_correct,t3_wrong;
    String total,correct,incorrect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t2_correct = findViewById(R.id.correct);
        t3_wrong = findViewById(R.id.incorrect);
        t1_total = findViewById(R.id.attempted);
        Intent i = getIntent();
        total = i.getStringExtra("total");
        correct = i.getStringExtra("correct");
        incorrect = i.getStringExtra("incorrect");

        setValues();
    }

    private void setValues()
    {
        t1_total.setText(total);
        t2_correct.setText(correct);
        t3_wrong.setText(incorrect);
    }


}
