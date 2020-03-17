package com.example.paperprepationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paperprepationapp.adapters.ViewPagerAdapter;
import com.example.paperprepationapp.databinding.ActivityMainMcqsBinding;
import com.example.paperprepationapp.models.Questions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PreparationMcqActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainMcqsBinding activityMainMcqsBinding;

    int cCount = 0;
    int correct = 0;
    int wrong = 0;
    int total = 0;

    DatabaseReference databaseReference;
    Questions questions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainMcqsBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_mcqs);
        reverseTimer(60,activityMainMcqsBinding.tvTimer);
        setListener();
        updateQuestions();



    }

    //this function is made  for onClickListner
    private void setListener() {
        activityMainMcqsBinding.tvMcqsOption1.setOnClickListener(this);
        activityMainMcqsBinding.tvMcqsOption2.setOnClickListener(this);
        activityMainMcqsBinding.tvMcqsOption3.setOnClickListener(this);
        activityMainMcqsBinding.tvMcqsOption4.setOnClickListener(this);
        activityMainMcqsBinding.btnNext.setOnClickListener(this);
        activityMainMcqsBinding.btnPrevious.setOnClickListener(this);
        activityMainMcqsBinding.tvQuestionNo.setOnClickListener(this);
        //activityMainMcqsBinding.tvTimer.setOnClickListener(this);
    }

    public void updateQuestions() {
            cCount++;
        if (cCount > 5) {
            Toast.makeText(getApplicationContext(), "Finished", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("total", String.valueOf(total));
            intent.putExtra("correct", String.valueOf(correct));
            intent.putExtra("wrong", String.valueOf(wrong));
            startActivity(intent);

        } else {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(cCount));
            total++;
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Questions questions = dataSnapshot.getValue(Questions.class);
                    activityMainMcqsBinding.tvMcqsQuestion.setText(questions.getQuestion());
                    activityMainMcqsBinding.tvMcqsOption1.setText(questions.getOption1());
                    activityMainMcqsBinding.tvMcqsOption2.setText(questions.getOption2());
                    activityMainMcqsBinding.tvMcqsOption3.setText(questions.getOption3());
                    activityMainMcqsBinding.tvMcqsOption4.setText(questions.getOption4());
                    setListener();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });

        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.tv_mcqs_option_1) {

            if (activityMainMcqsBinding.tvMcqsOption1.getText().toString().equals(questions.getAnswer())) {
                Toast.makeText(getApplicationContext(), "Correct answer", Toast.LENGTH_SHORT).show();
                activityMainMcqsBinding.tvMcqsOption1.setBackgroundColor(Color.GREEN);
                correct = correct + 1;

            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                wrong = wrong + 1;
                activityMainMcqsBinding.tvMcqsOption1.setBackgroundColor(Color.RED);

                if (activityMainMcqsBinding.tvMcqsOption2.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption2.setBackgroundColor(Color.GREEN);

                } else if (activityMainMcqsBinding.tvMcqsOption3.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption3.setBackgroundColor(Color.GREEN);

                } else if (activityMainMcqsBinding.tvMcqsOption4.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption4.setBackgroundColor(Color.GREEN);
                }

            }

        } else if (v.getId() == R.id.tv_mcqs_option_2) {
            if (activityMainMcqsBinding.tvMcqsOption2.getText().toString().equals(questions.getAnswer())) {
                Toast.makeText(getApplicationContext(), "Correct answer", Toast.LENGTH_SHORT).show();
                activityMainMcqsBinding.tvMcqsOption2.setBackgroundColor(Color.GREEN);
                correct = correct + 1;

            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                wrong = wrong + 1;
                activityMainMcqsBinding.tvMcqsOption2.setBackgroundColor(Color.RED);

                if (activityMainMcqsBinding.tvMcqsOption1.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption1.setBackgroundColor(Color.GREEN);

                } else if (activityMainMcqsBinding.tvMcqsOption3.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption3.setBackgroundColor(Color.GREEN);

                } else if (activityMainMcqsBinding.tvMcqsOption4.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption4.setBackgroundColor(Color.GREEN);
                }
            }


        } else if (v.getId() == R.id.tv_mcqs_option_3) {
            if (activityMainMcqsBinding.tvMcqsOption3.getText().toString().equals(questions.getAnswer())) {
                Toast.makeText(getApplicationContext(), "Correct answer", Toast.LENGTH_SHORT).show();
                activityMainMcqsBinding.tvMcqsOption3.setBackgroundColor(Color.GREEN);
                correct = correct + 1;

            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                wrong = wrong + 1;
                activityMainMcqsBinding.tvMcqsOption3.setBackgroundColor(Color.RED);

                if (activityMainMcqsBinding.tvMcqsOption2.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption2.setBackgroundColor(Color.GREEN);

                } else if (activityMainMcqsBinding.tvMcqsOption1.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption1.setBackgroundColor(Color.GREEN);

                } else if (activityMainMcqsBinding.tvMcqsOption4.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption4.setBackgroundColor(Color.GREEN);
                }
            }

        } else if (v.getId() == R.id.tv_mcqs_option_4) {
            if (activityMainMcqsBinding.tvMcqsOption4.getText().toString().equals(questions.getAnswer())) {
                Toast.makeText(getApplicationContext(), "Correct answer", Toast.LENGTH_SHORT).show();
                activityMainMcqsBinding.tvMcqsOption4.setBackgroundColor(Color.GREEN);
                correct = correct + 1;

            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                wrong = wrong + 1;
                activityMainMcqsBinding.tvMcqsOption4.setBackgroundColor(Color.RED);

                if (activityMainMcqsBinding.tvMcqsOption2.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption2.setBackgroundColor(Color.GREEN);

                } else if (activityMainMcqsBinding.tvMcqsOption3.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption3.setBackgroundColor(Color.GREEN);

                } else if (activityMainMcqsBinding.tvMcqsOption1.getText().toString().equals(questions.getAnswer())) {
                    activityMainMcqsBinding.tvMcqsOption1.setBackgroundColor(Color.GREEN);
                }

            }

        } else if (v.getId() == R.id.btn_next){
            updateQuestions();
            questionStyle();

        } else if (v.getId() == R.id.btn_previous){

            questionStyle();

        }

    }

    public void questionStyle(){
        activityMainMcqsBinding.tvMcqsOption1.setBackgroundColor(Color.parseColor("#6200EE"));
        activityMainMcqsBinding.tvMcqsOption2.setBackgroundColor(Color.parseColor("#6200EE"));
        activityMainMcqsBinding.tvMcqsOption3.setBackgroundColor(Color.parseColor("#6200EE"));
        activityMainMcqsBinding.tvMcqsOption4.setBackgroundColor(Color.parseColor("#6200EE"));

    }

    public void reverseTimer(int Seconds, final TextView textView){
        new CountDownTimer(Seconds * 1000 + 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int)(millisUntilFinished/1000);
                int minutes = seconds /60;
                seconds = seconds % 60;
                textView.setText(String.format("%02d",seconds));
            }

            @Override
            public void onFinish() {
                textView.setText("Completed");
                Intent intent = new Intent(PreparationMcqActivity.this,ResultActivity.class);
                intent.putExtra("total",String.valueOf(total));
                intent.putExtra("correct",String.valueOf(correct));
                intent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(intent);
            }
        }.start();
    }
}
