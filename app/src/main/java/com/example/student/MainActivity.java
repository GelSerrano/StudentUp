package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView fone = (CardView) findViewById(R.id.fone);
        LinearLayout lecture = (LinearLayout) findViewById(R.id.lecture);
        LinearLayout simulation = (LinearLayout)findViewById(R.id.Simulation);
        LinearLayout assessment = (LinearLayout)findViewById(R.id.Assessment);
        LinearLayout pdf = (LinearLayout)findViewById(R.id.PDF);
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPDF();
            }
        });
        simulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensimulation();
            }
        });
        lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openActivity1();
            }
        });
        assessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensAssessment();
            }
        });

    }
    private void openPDF() {
        Intent intent = new Intent(this,Menu_PDF.class);
        startActivity(intent);
    }
    private void openActivity1() {
        Intent intent = new Intent(this,lecture1.class);
        startActivity(intent);
        finish();
    }
    private void opensimulation(){
        Intent intent = new Intent(this,simulation.class);
        startActivity(intent);

    }
    private void opensAssessment(){
        Intent intent = new Intent(this,Chart.class);
        startActivity(intent);
    }


}
