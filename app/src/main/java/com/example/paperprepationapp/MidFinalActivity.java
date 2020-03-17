package com.example.paperprepationapp;

import androidx.databinding.DataBindingUtil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.paperprepationapp.databinding.ActivityMidfinalBinding;

import static com.example.paperprepationapp.AppConstants.FINALTERM;
import static com.example.paperprepationapp.AppConstants.MIDTERM;
import static com.example.paperprepationapp.AppConstants.SUBJECT_CODE;
import static com.example.paperprepationapp.AppConstants.TERM_CODE;

public class MidFinalActivity extends Activity implements View.OnClickListener {

    private ActivityMidfinalBinding activityMidfinalBinding;
    private String subjectCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMidfinalBinding = DataBindingUtil.setContentView(this, R.layout.activity_midfinal);
        subjectCode = getIntent().getStringExtra(SUBJECT_CODE);

        activityMidfinalBinding.tvTittle.setText(subjectCode);
        setListner();
    }

    private void setListner() {
        activityMidfinalBinding.cvMidTerm.setOnClickListener(this);
        activityMidfinalBinding.cvFinalTerm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, QuizPrepartionActivity.class);
        intent.putExtra(SUBJECT_CODE, subjectCode);

        if (v.getId() == R.id.cv_mid_term) {
            intent.putExtra(TERM_CODE,MIDTERM);

        } else if (v.getId() == R.id.cv_final_term) {
            intent.putExtra(TERM_CODE, FINALTERM);
        }
        startActivity(intent);
    }
 }
