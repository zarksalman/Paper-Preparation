package com.example.paperprepationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.paperprepationapp.databinding.ActivityMainBinding;

import static com.example.paperprepationapp.AppConstants.SUBJECT_CODE;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView (this, R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cv_eng001)
        {
            String string = activityMainBinding.tvEng001.getText().toString();
            Intent intent = new Intent(this, MidFinalActivity.class);
            intent.putExtra(SUBJECT_CODE, string);
            startActivity(intent);
        }
        else if (v.getId() == R.id.cv_eng_101)
        {
            String string = activityMainBinding.tvEng101.getText().toString();
            Intent intent = new Intent(this, MidFinalActivity.class);
            intent.putExtra(SUBJECT_CODE, string);
            startActivity(intent);

        }

    }
}
