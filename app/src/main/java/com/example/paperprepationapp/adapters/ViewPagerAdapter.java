package com.example.paperprepationapp.adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ViewPagerAdapter
{



}

    /*  public ViewPagerAdapter(ArrayList<Questions> questionsArrayList, Context context) {
        this.questionsArrayList = questionsArrayList;
        this.context = context;
    }
    @Override
    public int getCount() {
        return questionsArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.mcqs_layout, container,false);

        TextView question, option1, option2, option3, option4;

        question  = view.findViewById(R.id.cv_mcqs_question);
        option1  = view.findViewById(R.id.cv_mcqs_option_1);
        option2  = view.findViewById(R.id.cv_mcqs_option_2);
        option3  = view.findViewById(R.id.cv_mcqs_option_3);
        option4  = view.findViewById(R.id.cv_mcqs_option_4);

        question.setText(questionsArrayList.get(position).getQuestion());
        option1.setText(questionsArrayList.get(position).getOption1());
        option2.setText(questionsArrayList.get(position).getOption2());
        option3.setText(questionsArrayList.get(position).getOption3());
        option4.setText(questionsArrayList.get(position).getOption4());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainMcqsActivity.class);
                context.startActivity(intent);
            }
        });
        container.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }*/

