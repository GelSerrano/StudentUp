package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.student.R;
import com.example.student.week1;
import com.example.student.week2;
import com.example.student.week3;
import com.example.student.week4and5;

public class Lecture extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        ImageView back = (ImageView) findViewById(R.id.backk);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        LinearLayout week1 = (LinearLayout) findViewById(R.id.week1);
        week1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeek1();
            }


        });
        LinearLayout week2 = (LinearLayout) findViewById(R.id.week2);
        week2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeek2();
            }
        });
        LinearLayout week3 = (LinearLayout) findViewById(R.id.week3);
        week3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeek3();
            }


        });
        LinearLayout week4 = (LinearLayout)findViewById(R.id.week4and5);
        week4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenWeek4();
            }
        });

    }




    private void openWeek1() {
        Intent intent = new Intent(this, week1.class);
        startActivity(intent);
        finish();
    }
    private void openWeek2() {
        Intent intent = new Intent(this, week2.class);
        startActivity(intent);
        finish();
    }

    private void openWeek3() {
        Intent intent = new Intent(this, week3.class);
        startActivity(intent);
    }
    private void OpenWeek4() {
        Intent intent = new Intent(this, week4and5.class);
        startActivity(intent);
        finish();
    }


}




