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
import android.widget.TextView;

public class week1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week1);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("I.   \tUnderstand the concept of Java Programming Language. \n" +
                "II.  \tDescribe the steps involved in program compilation and execution of Java.\n");
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
        Button button = (Button) findViewById(R.id.quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(week1.this)

                        .setTitle("Quiz")
                        .setMessage("Do you want to take a Quiz?")
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

    }
    public void onBackPressed() {

    }
}
