package com.example.paperprepationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.paperprepationapp.databinding.ActivityAllSubjectsBinding;

import static com.example.paperprepationapp.AppConstants.ACCOUNTING;
import static com.example.paperprepationapp.AppConstants.CS;
import static com.example.paperprepationapp.AppConstants.ENGLISH;
import static com.example.paperprepationapp.AppConstants.MATTHEMATICS;
import static com.example.paperprepationapp.AppConstants.SUBJECT_CODE;

public class AllSubjects extends Activity implements View.OnClickListener {

    private ActivityAllSubjectsBinding activityAllSubjectsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAllSubjectsBinding = DataBindingUtil.setContentView(this, R.layout.activity_all_subjects);
        setListner();
    }

    private void  setListner(){
        activityAllSubjectsBinding.cvEnglish.setOnClickListener(this);
        activityAllSubjectsBinding.cvMathematics.setOnClickListener(this);
        activityAllSubjectsBinding.cvAccounting.setOnClickListener(this);
        activityAllSubjectsBinding.cvComputerScience.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, MidFinalActivity.class);

        if (v.getId() == R.id.cv_english) {
            intent.putExtra(SUBJECT_CODE, ENGLISH);

        } else if (v.getId() == R.id.cv_mathematics) {
            intent.putExtra(SUBJECT_CODE, MATTHEMATICS);

        } else if (v.getId() == R.id.cv_accounting) {
            intent.putExtra(SUBJECT_CODE, ACCOUNTING);

        } else if (v.getId() == R.id.cv_computer_science) {
            intent.putExtra(SUBJECT_CODE, CS);


        }
        startActivity(intent);
    }
}
