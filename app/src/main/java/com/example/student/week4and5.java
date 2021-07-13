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

public class week4and5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week4and5);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("1.\tConstruct a Boolean expression that can be used to make decisions\n" +
                "2.\tPerform decision making using conditional statements\n" +
                "3.\tDevelop a program using conditional statement\n" +
                "4.\tUnderstand the concept of iterative statements\n" +
                "5.\tExecute statements repetitively using while, do while and for\n" +
                "6.\tDevelop a program using while, do while and for\n" +
                "7.\tDemonstrate how to use and form nested control structures\n" +
                "8.\tControl Structures\n" +
                "\nObjectives:\n" +
                "\n1.\tUnderstand the flow of control through a method.\n" +
                "2.\tDetermine the issues pertaining to the comparison of certain types of data.\n" +
                "3.\tDescribe the concept of an iterator object and use one to read a text file.\n" +
                "4.\tIdentify the relationships among classes.\n");

        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();

        ImageView back = (ImageView) findViewById(R.id.backk);
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
                AlertDialog dialog = new AlertDialog.Builder(week4and5.this)

                        .setTitle("Quiz")
                        .setTitle("Assessment Content!")
                        .setMessage("Part 1: 15 Multiple Choice "+
                                "\n Choose from the 4 choices below which one is the correct answer very carefully\n" +
                                "\nPart 2: 15 True or False"+
                                "\nChoose True if the question is right and False if otherwise\n"+
                                "\nPart 3: 10 Identification\n"+
                                "Example 1:\n" +
                                "\n" +
                                "Java _____ - oriented programming.\n" +
                                "Answer: object\n" +
                                "\n" +
                                "Example 2:\n" +
                                "____ object - oriented programming.\n" +
                                "Answer: Java\n" +

                                "\nNOTE: Be aware of the sentence itself, the answer must based on the sentence also.\n"+
                                "\nFor Total of 40/40\n"+
                                "\nAre you ready?")
                        .setPositiveButton("Yes", null )
                        .setNegativeButton("No", null)
                        .show();
                dialog.setCanceledOnTouchOutside(false);
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(week4and5.this, prelim_quiz4.class);
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
        Intent intent = new Intent(this, PW4and5_Vid.class);
        startActivity(intent);
    }
    private void openlink() {
        Intent intent = new Intent(this,prelimLinks4and5.class);
        startActivity(intent);
    }

}
