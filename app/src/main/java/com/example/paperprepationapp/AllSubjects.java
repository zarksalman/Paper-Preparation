package com.example.paperprepationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.paperprepationapp.databinding.ActivityAllSubjectsBinding;
import com.google.firebase.database.DatabaseReference;

import static com.example.paperprepationapp.AppConstants.ACCOUNTING;
import static com.example.paperprepationapp.AppConstants.CS;
import static com.example.paperprepationapp.AppConstants.ENGLISH;
import static com.example.paperprepationapp.AppConstants.MATHEMATICS;
import static com.example.paperprepationapp.AppConstants.SUBJECT_CODE;

public class AllSubjects extends Activity implements View.OnClickListener {

    // create variable for "activitylayoutBinding"
    private ActivityAllSubjectsBinding activityAllSubjectsBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAllSubjectsBinding = DataBindingUtil.setContentView(this, R.layout.activity_all_subjects);
        setListner(); // onclicklistner function call here
    }
//this function is made  for onClickListner
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
            intent.putExtra(SUBJECT_CODE, MATHEMATICS);

        } else if (v.getId() == R.id.cv_accounting) {
            intent.putExtra(SUBJECT_CODE, ACCOUNTING);

        } else if (v.getId() == R.id.cv_computer_science) {
            intent.putExtra(SUBJECT_CODE, CS);

        }
        startActivity(intent);
    }
}
