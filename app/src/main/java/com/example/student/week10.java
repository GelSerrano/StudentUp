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

public class week10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week10);
        ImageView image = (ImageView) findViewById(R.id.backk);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("1.\tConceptualize the application of Polymorphism in inheriting the class\n" +
                "2.\tAnalyze the concept of Overriding and hiding methods\n" +
                "3.\tDesign a program using Inheritance.\n" +
                "\n" +
                "\nObjectives:\n" +
                "1.\t Understand the derivation of new classes from existing ones.\n" +
                "2.\tIdentify the concept and purpose of method overriding\n" +
                "3.\tDevelop a design of class hierarchies\n" +
                "4.\tDetermine the purpose and use of abstract classes\n" +
                "5.\tDescribe the issue of visibility as it relates to inheritance.\n" +
                "6.\tCreate object-oriented design in the context of inheritance.\n" +
                "\n"

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
                AlertDialog dialog = new AlertDialog.Builder(week10.this)

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
                        Intent intent = new Intent(week10.this, midterm_quiz10.class);
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
        Intent intent = new Intent(this, MW10_Vid.class);
        startActivity(intent);
    }
    private void openlink() {
        Intent intent = new Intent(this, midtermLinks4.class);
        startActivity(intent);
    }


}