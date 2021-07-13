package com.example.student;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class week3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week3);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("1.\tUnderstand the concept of Object-Oriented Programming\n" +
                "2.\tAnalyze the concept of Encapsulation and Abstraction\n" +
                "3.\tCreate a class and objects and apply it to develop a program\n" +
                "\n" +
                "Objectives:\n" +
                "\n1.\tUnderstand the creation of objects and the use of object reference variables.\n" +
                "2.\tIdentify the services provided by the String class.\n" +
                "3.\tDescribe how the Java standard class library is organized into packages.\n" +
                "4.\tExplain the services provided by the Random and Math classes.\n" +
                "5.\tDescribe ways to format output using the NumberFormat and DecimalFormat classes.\n" +
                "6.\tIdentify enumerated types.\n" +
                "7.\tDescribe wrapper classes and the concept autoboxing.");

        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();


        ImageView back = (ImageView)findViewById(R.id.backk);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


        LinearLayout button = (LinearLayout) findViewById(R.id.quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(week3.this)

                        .setTitle("Quiz")
                        .setTitle("Assessment Content!")
                        .setMessage("Part 1: 10 Multiple Choice "+
                                "\n Choose from the 4 choices below which one is the correct answer very carefully\n" +
                                "\nPart 2: 10 True or False"+
                                "\nChoose True if the question is right and False if otherwise\n"+
                                "\nPart 3: 5 Identification\n"+
                                "Example 1:\n" +
                                "\n" +
                                "Java _____ - oriented programming.\n" +
                                "Answer: object\n" +
                                "\n" +
                                "Example 2:\n" +
                                "____ object - oriented programming.\n" +
                                "Answer: Java\n" +

                                "\nNOTE: Be aware of the sentence itself, the answer must based on the sentence also.\n"+
                                "\nFor Total of 25/25\n"+
                                "\nAre you ready?")
                        .setPositiveButton("Yes", null )
                        .setNegativeButton("No", null)
                        .show();
                dialog.setCanceledOnTouchOutside(false);
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(week3.this, prelim_quiz3.class);
                        startActivity(intent);
                    }
                });

            }
        });

        LinearLayout link = (LinearLayout)findViewById(R.id.link);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlink();
            }
        });
        LinearLayout Video = (LinearLayout)findViewById(R.id.video);
        Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVid();
            }
        });



    }

    private void openVid() {
        Intent intent = new Intent(this, PW3_Vid.class);
        startActivity(intent);
    }
    private void openlink() {
        Intent intent = new Intent(this,prelimLinks3.class);
        startActivity(intent);
    }

}
