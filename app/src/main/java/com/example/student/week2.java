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

public class week2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week2);



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("1.\tDevelop a simple program that uses the recommended coding conventions. \n" +
                "2.\tApply the recommended variable naming conventions, data types and assignments to the program\n" +
                "3.\t Analyze the different java primitive data types\n" +
                "\n" +
                "Objectives:\n" +
                "\n1.\tDetermine the use of character strings, concatenation, and escape sequences.\n" +
                "2.\tUnderstand the declaration and use of variables.\n" +
                "3.\tDescribe the Java primitive data types.\n" +
                "4.\tCreate a syntax and process the use of expression.\n" +
                "5.\tIdentify the types of data conversions and the mechanisms for accomplishing them.\n");

        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();

        LinearLayout button = (LinearLayout) findViewById(R.id.quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(week2.this)

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
                        Intent intent = new Intent(week2.this, prelim_quiz2.class);
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
        ImageView image = (ImageView) findViewById(R.id.backk);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
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
        Intent intent = new Intent(week2.this, PW2_vid.class);
        startActivity(intent);
    }

    private void openlink() {
        Intent intent = new Intent(this, prelimLinks2.class);
        startActivity(intent);
    }

}
