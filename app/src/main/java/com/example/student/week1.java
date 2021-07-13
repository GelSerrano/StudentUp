package com.example.student;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class week1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week1);


        ImageView image = (ImageView) findViewById(R.id.backk);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("1.\tValue the program objectives, course intended learning outcomes and course requirements\n" +
                "2.\tUnderstand the concept of Java Programming Language\n" +
                "3.\tDescribe the steps involved in program compilation and execution of Java.\n" +
                "\n" +
                "Objectives:\n" +
                "\n1.\tBecome familiar with the Java programming language.\n" +
                "2.\tIdentify the issues related to problem solving in general.\n" +
                "3.\tPresent an overview of object-oriented principles."

        );

        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
        LinearLayout button = (LinearLayout) findViewById(R.id.quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(week1.this)

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
                        Intent intent = new Intent(week1.this, prelim_quiz1.class);
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
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
        LinearLayout video = (LinearLayout)findViewById(R.id.video);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openvideo();
            }
        });
    }

    private void openvideo() {
        Intent intent = new Intent(this,PW1_Vid.class);
        startActivity(intent);
    }

    private void openlink() {
        Intent intent = new Intent(this,prelimLinks1.class);
        startActivity(intent);
    }




}
