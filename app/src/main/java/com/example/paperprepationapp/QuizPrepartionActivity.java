package com.example.paperprepationapp;

import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.paperprepationapp.databinding.ActivityQuizPrepartionBinding;
import com.google.firebase.database.DatabaseReference;

import static com.example.paperprepationapp.AppConstants.SUBJECT_CODE;
import static com.example.paperprepationapp.AppConstants.TERM_CODE;

public class QuizPrepartionActivity extends Activity implements View.OnClickListener {

    private ActivityQuizPrepartionBinding activityQuizPrepartionBinding;
    private String subjectCode;
    private String termCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityQuizPrepartionBinding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_prepartion);
        subjectCode = getIntent().getStringExtra(SUBJECT_CODE);
        termCode = getIntent().getStringExtra(TERM_CODE);
        setListner();

        activityQuizPrepartionBinding.tvMidTittle.setText(subjectCode);
        activityQuizPrepartionBinding.tvSubMidTittle.setText(termCode);
    }

    private void setListner() {
        activityQuizPrepartionBinding.cvPrepartion.setOnClickListener(this);
        activityQuizPrepartionBinding.cvQuiz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, PreparationMcqActivity.class);

        if (v.getId() == R.id.cv_prepartion) {
            Toast.makeText(this, "Prepartion ", Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.cv_quiz) {
            Toast.makeText(this, "Quiz", Toast.LENGTH_SHORT).show();

        }
        startActivity(intent);

    }
}
