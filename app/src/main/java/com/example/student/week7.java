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

public class week7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week7);
        ImageView image = (ImageView) findViewById(R.id.backk);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("1.\tDefine and use arrays for basic data organization\n" +
                "2.\tExplore how to declare and manipulate data in arrays\n" +
                "3.\tSolve array index out of bound errors\n" +
                "4.\tDesign a program using one-dimensional and multidimensional arrays\n" +
                "\n" +
                "\nObjectives:\n" +
                "1.\tExplain the bounds checking and techniques for managing capacity.\n" +
                "2.\tIdentify the issues related to arrays as objects and arrays of objects.\n" +
                "3.\tDetermine the use of command-line arguments.\n" +
                "4.\tDescribe the syntax and use of variable-length parameter lists.\n" +
                "5.\tUnderstand the creation and use of multidimensional arrays.\n"

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
                AlertDialog dialog = new AlertDialog.Builder(week7.this)

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
                        Intent intent = new Intent(week7.this, midterm_quiz7.class);
                        startActivity(intent);
                    }
                });

            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

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
        Intent intent = new Intent(this, MW7_Vid.class);
        startActivity(intent);
    }
    private void openlink() {
        Intent intent = new Intent(this, midtermLinks1.class);
        startActivity(intent);

    }

}