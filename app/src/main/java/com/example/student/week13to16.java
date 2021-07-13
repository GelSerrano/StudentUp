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

public class week13to16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week13to16);
        ImageView image = (ImageView) findViewById(R.id.backk);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("1.\tUnderstand the concept of programming using Graphical User Interface \n" +
                "2.\tDifferentiate AWT from SWING in developing GUI applications\n" +
                "3.\tDesign an application using AWT and SWING containers and components\n" +
                "4.\tUnderstand the concept of programming using Graphical User Interface \n" +
                "5.\tDesign an application using AWT and SWING containers and components\n" +
                "6.\tDemonstrate how to use Layout Managers and add components to a container. \n" +
                "7.\tUnderstand the different types of layout managers.\n" +
                "8.\tDesign a system using the right layout manager. \n" +
                "9.\tSolve the common problems in using a layout manager.\n" +
                "10.\tUnderstand the concept of event handler and listener\n" +
                "11.\tDemonstrate how to handle window events\n" +
                "12.\tDemonstrate how to handle mouse and keyboard input\n" +
                "13.\tDesign a system using event handling\n" +
                "\n" +
                "\nObjectives:\n" +
                "1.\tUnderstand the core elements needed in any Java GUI: components, events, and listeners.\n" +
                "2.\tDetermine the use of containers to organize components.\n" +
                "3.\tIdentify various types of components, including buttons, text fields, sliders, and combo boxes.\n" +
                "4.\tExplain the various types of events that components generate, and under what conditions.\n" +
                "5.\tUnderstand the concept of a layout manager and explore several specific ones.\n" +
                "6.\tIdentify various types of mouse and keyboard events.\n" +
                "7.\tCreate dialog boxes, including specialized dialog boxes for choosing files and colors.\n" +
                "8.\tIdentify the use of borders, tool tips, and mnemonics."

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
                AlertDialog dialog = new AlertDialog.Builder(week13to16.this)

                        .setTitle("Assessment Content!")
                        .setMessage("Part 1: 20 Multiple Choice "+
                                "\n Choose from the 4 choices below which one is the correct answer very carefully\n" +
                                "\nPart 2: 20 True or False"+
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
                                "\nFor Total of 50/50\n"+
                                "\nAre you ready?")
                        .setPositiveButton("Yes", null )
                        .setNegativeButton("No", null)
                        .show();
                dialog.setCanceledOnTouchOutside(false);
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(week13to16.this, final_quiz16.class);
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
        Intent intent = new Intent(this, FW13to16_Vid.class);
        startActivity(intent);
    }
    private void openlink() {
        Intent intent = new Intent(this, finalLink1.class);
        startActivity(intent);
    }



}