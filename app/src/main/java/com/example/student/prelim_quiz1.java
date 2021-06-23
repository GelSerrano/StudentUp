package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class prelim_quiz1 extends AppCompatActivity {
    Button submit;
    int total = 0;
    int correct = 0;
    int wrong = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
    long datetime = new Date().getTime();

    String check;
    //Multiple Choice
    String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;
    //True or False
    String answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20;
    //Identification
    String answer21,answer22, answer23, answer24,answer25;
    //    quizmenu qz;
    String childname;
    TextView timer;

    TextView question1, question2, question3, question4, question5, question6, question7, question8, question9, question10
            , question11, question12, question13, question14, question15, question16, question17, question18, question19, question20
            , question21, question22, question23, question24, question25;

    //correctAnswer
    TextView correct1;

    //multiple Choice Radio Group
    RadioGroup q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;
    //True or False Radio Group
    RadioGroup q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;
    //identification
    RadioGroup q21, q22, q23, q24, q25;



    // Multiple Choice Button
    Button a1, b1, c1, d1;
    Button a2, b2, c2, d2;
    Button a3, b3, c3, d3;
    Button a4, b4, c4, d4;
    Button a5, b5, c5, d5;
    Button a6, b6, c6, d6;
    Button a7, b7, c7, d7;
    Button a8, b8, c8, d8;
    Button a9, b9, c9, d9;
    Button a10, b10, c10, d10;

    // True or False Button

    Button a11, b11;
    Button a12, b12;
    Button a13, b13;
    Button a14, b14;
    Button a15, b15;
    Button a16, b16;
    Button a17, b17;
    Button a18, b18;
    Button a19, b19;
    Button a20, b20;


    Button next1, next2, next3, next4, next5, next6, next7, next8, next9, next10, next11, next12, next13, next14, next15, next16, next17, next18, next19
            , next20,next21,next22,next23,next24,
            back2, back3, back4, back5, back6, back7, back8, back9, back10, back11, back12, back13, back14, back15, back16, back17, back18, back19, back20
            ,back21,back22,back23,back24,back25;
    EditText ans21, ans22, ans23, ans24, ans25;



    DatabaseReference databaseReference;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prelim_quiz1);

        correct = 0;

        // Storing data into SharedPreferences
        sharedPreferences = getSharedPreferences("P_Q1SharedPref",MODE_PRIVATE);
        // Creating an Editor object to edit(write to the file)
        final SharedPreferences.Editor myEdit = sharedPreferences.edit();

        //getDate
        DateTime dt = new DateTime();
        final String currdate = dt.getDate();

        timer = findViewById(R.id.textView10);
        //Button
        submit = findViewById(R.id.submit);


        //correct
        correct1 = findViewById(R.id.correct1);



        //RadioGroup for multiple choice
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        q6 = findViewById(R.id.q6);
        q7 = findViewById(R.id.q7);
        q8 = findViewById(R.id.q8);
        q9 = findViewById(R.id.q9);
        q10 = findViewById(R.id.q10);


        //RadioButton for True or false
        q11 = findViewById(R.id.q11);
        q12 = findViewById(R.id.q12);
        q13 = findViewById(R.id.q13);
        q14 = findViewById(R.id.q14);
        q15 = findViewById(R.id.q15);
        q16 = findViewById(R.id.q16);
        q17 = findViewById(R.id.q17);
        q18 = findViewById(R.id.q18);
        q19 = findViewById(R.id.q19);
        q20 = findViewById(R.id.q20);

        //Identification

        q21 =findViewById(R.id.q21);
        q22 =findViewById(R.id.q22);
        q23 =findViewById(R.id.q23);
        q24 =findViewById(R.id.q24);
        q25 =findViewById(R.id.q25);



        //multiple Choice buttons



        //Radio Button1
        a1 = findViewById(R.id.a1);
        b1 = findViewById(R.id.b1);
        c1 = findViewById(R.id.c1);
        d1 = findViewById(R.id.d1);
        //Radio Button2
        a2 = findViewById(R.id.a2);
        b2 = findViewById(R.id.b2);
        c2 = findViewById(R.id.c2);
        d2 = findViewById(R.id.d2);
        //Radio Button3
        a3 = findViewById(R.id.a3);
        b3 = findViewById(R.id.b3);
        c3 = findViewById(R.id.c3);
        d3 = findViewById(R.id.d3);
        //Radio Button4
        a4 = findViewById(R.id.a4);
        b4 = findViewById(R.id.b4);
        c4 = findViewById(R.id.c4);
        d4 = findViewById(R.id.d4);
        //Radio Button5
        a5 = findViewById(R.id.a5);
        b5 = findViewById(R.id.b5);
        c5 = findViewById(R.id.c5);
        d5 = findViewById(R.id.d5);
        //Radio Button6
        a6 = findViewById(R.id.a6);
        b6 = findViewById(R.id.b6);
        c6 = findViewById(R.id.c6);
        d6 = findViewById(R.id.d6);
        //Radio Button7
        a7 = findViewById(R.id.a7);
        b7 = findViewById(R.id.b7);
        c7 = findViewById(R.id.c7);
        d7 = findViewById(R.id.d7);
        //Radio Button8
        a8 = findViewById(R.id.a8);
        b8 = findViewById(R.id.b8);
        c8 = findViewById(R.id.c8);
        d8 = findViewById(R.id.d8);
        //Radio Button9
        a9 = findViewById(R.id.a9);
        b9 = findViewById(R.id.b9);
        c9 = findViewById(R.id.c9);
        d9 = findViewById(R.id.d9);
        //Radio Button10
        a10 = findViewById(R.id.a10);
        b10 = findViewById(R.id.b10);
        c10 = findViewById(R.id.c10);
        d10 = findViewById(R.id.d10);

        //True or false Buttons
        a11 = findViewById(R.id.a11);
        b11 = findViewById(R.id.b11);

        a12 = findViewById(R.id.a12);
        b12 = findViewById(R.id.b12);

        a13 = findViewById(R.id.a13);
        b13 = findViewById(R.id.b13);

        a14 = findViewById(R.id.a14);
        b14 = findViewById(R.id.b14);

        a15 = findViewById(R.id.a15);
        b15 = findViewById(R.id.b15);

        a16 = findViewById(R.id.a16);
        b16 = findViewById(R.id.b16);

        a17 = findViewById(R.id.a17);
        b17 = findViewById(R.id.b17);

        a18 = findViewById(R.id.a18);
        b18 = findViewById(R.id.b18);

        a19 = findViewById(R.id.a19);
        b19 = findViewById(R.id.b19);

        a20 = findViewById(R.id.a20);
        b20 = findViewById(R.id.b20);


        //Back and Next
        next1 = (Button) findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q1.setVisibility(View.GONE);
                q2.setVisibility(View.VISIBLE);
                a1.setEnabled(false);
                b1.setEnabled(false);
                c1.setEnabled(false);
                d1.setEnabled(false);
            }
        });
        back2 = (Button) findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q2.setVisibility(View.GONE);
                q1.setVisibility(View.VISIBLE);
            }
        });
        next2 = (Button) findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q2.setVisibility(View.GONE);
                q3.setVisibility(View.VISIBLE);
            }
        });
        back3 = (Button) findViewById(R.id.back3);
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q2.setVisibility(View.VISIBLE);
                q3.setVisibility(View.GONE);
            }
        });
        next3 = (Button) findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q3.setVisibility(View.GONE);
                q4.setVisibility(View.VISIBLE);
            }
        });
        back4 = (Button) findViewById(R.id.back4);
        back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q3.setVisibility(View.VISIBLE);
                q4.setVisibility(View.GONE);
            }
        });
        next4 = (Button) findViewById(R.id.next4);
        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q4.setVisibility(View.GONE);
                q5.setVisibility(View.VISIBLE);
            }
        });
        back5 = (Button) findViewById(R.id.back5);
        back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q4.setVisibility(View.VISIBLE);
                q5.setVisibility(View.GONE);
            }
        });
        next5 = (Button) findViewById(R.id.next5);
        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q5.setVisibility(View.GONE);
                q6.setVisibility(View.VISIBLE);
            }
        });
        back6 = (Button) findViewById(R.id.back6);
        back6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q5.setVisibility(View.VISIBLE);
                q6.setVisibility(View.GONE);
            }
        });
        next6 = (Button) findViewById(R.id.next6);
        next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q6.setVisibility(View.GONE);
                q7.setVisibility(View.VISIBLE);
            }
        });
        back7 = (Button) findViewById(R.id.back7);
        back7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q6.setVisibility(View.VISIBLE);
                q7.setVisibility(View.GONE);
            }
        });
        next7 = (Button) findViewById(R.id.next7);
        next7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q7.setVisibility(View.GONE);
                q8.setVisibility(View.VISIBLE);
            }
        });
        back8 = (Button) findViewById(R.id.back8);
        back8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q7.setVisibility(View.VISIBLE);
                q8.setVisibility(View.GONE);
            }
        });
        next8 = (Button) findViewById(R.id.next8);
        next8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q8.setVisibility(View.GONE);
                q9.setVisibility(View.VISIBLE);
            }
        });
        back9 = (Button) findViewById(R.id.back9);
        back9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q8.setVisibility(View.VISIBLE);
                q9.setVisibility(View.GONE);
            }
        });
        next9 = (Button) findViewById(R.id.next9);
        next9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q9.setVisibility(View.GONE);
                q10.setVisibility(View.VISIBLE);
            }
        });
        back10 = (Button) findViewById(R.id.back10);
        back10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q9.setVisibility(View.VISIBLE);
                q10.setVisibility(View.GONE);
            }
        });
        next10 = (Button) findViewById(R.id.next10);
        next10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q10.setVisibility(View.GONE);
                q11.setVisibility(View.VISIBLE);
            }
        });
        back11 = (Button) findViewById(R.id.back11);
        back11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q10.setVisibility(View.VISIBLE);
                q11.setVisibility(View.GONE);
            }
        });

        next11 = (Button) findViewById(R.id.next11);
        next11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q11.setVisibility(View.GONE);
                q12.setVisibility(View.VISIBLE);
            }
        });
        back12 = (Button) findViewById(R.id.back12);
        back12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q11.setVisibility(View.VISIBLE);
                q12.setVisibility(View.GONE);
            }
        });
        next12 = (Button)findViewById(R.id.next12);
        next12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q12.setVisibility(View.GONE);
                q13.setVisibility(View.VISIBLE);
            }
        });
        back13 = (Button)findViewById(R.id.back13);
        back13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q12.setVisibility(View.VISIBLE);
                q13.setVisibility(View.GONE);
            }
        });
        next13 = (Button) findViewById(R.id.next13);
        next13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q13.setVisibility(View.GONE);
                q14.setVisibility(View.VISIBLE);
            }
        });

        back14 = (Button) findViewById(R.id.back14);
        back14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q13.setVisibility(View.VISIBLE);
                q14.setVisibility(View.GONE);
            }
        });
        next14 = (Button) findViewById(R.id.next14);
        next14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q14.setVisibility(View.GONE);
                q15.setVisibility(View.VISIBLE);
            }
        });
        back15 = (Button) findViewById(R.id.back15);
        back15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q14.setVisibility(View.VISIBLE);
                q15.setVisibility(View.GONE);
            }
        });


        next15 = (Button) findViewById(R.id.next15);
        next15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q15.setVisibility(View.GONE);
                q16.setVisibility(View.VISIBLE);
            }
        });
        back16 = (Button) findViewById(R.id.back16);
        back16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q15.setVisibility(View.VISIBLE);
                q16.setVisibility(View.GONE);
            }
        });


        next16 = (Button) findViewById(R.id.next16);
        next16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q16.setVisibility(View.GONE);
                q17.setVisibility(View.VISIBLE);
            }
        });
        back17 = (Button) findViewById(R.id.back17);
        back17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q16.setVisibility(View.VISIBLE);
                q17.setVisibility(View.GONE);
            }
        });


        next17 = (Button) findViewById(R.id.next17);
        next17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q17.setVisibility(View.GONE);
                q18.setVisibility(View.VISIBLE);
            }
        });
        back18 = (Button) findViewById(R.id.back18);
        back18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q17.setVisibility(View.VISIBLE);
                q18.setVisibility(View.GONE);
            }
        });


        next18 = (Button) findViewById(R.id.next18);
        next18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q18.setVisibility(View.GONE);
                q19.setVisibility(View.VISIBLE);
            }
        });
        back19 = (Button) findViewById(R.id.back19);
        back19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q18.setVisibility(View.VISIBLE);
                q19.setVisibility(View.GONE);
            }
        });


        next19 = (Button) findViewById(R.id.next19);
        next19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q19.setVisibility(View.GONE);
                q20.setVisibility(View.VISIBLE);
            }
        });
        back20 = (Button) findViewById(R.id.back20);
        back20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q19.setVisibility(View.VISIBLE);
                q20.setVisibility(View.GONE);
            }
        });
        next20 = (Button) findViewById(R.id.next20);
        next20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q20.setVisibility(View.GONE);
                q21.setVisibility(View.VISIBLE);
            }
        });
        back21 = (Button)findViewById(R.id.back21);
        back21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q20.setVisibility(View.VISIBLE);
                q21.setVisibility(View.GONE);
            }
        });
        next21 = (Button)findViewById(R.id.next21);
        next21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q21.setVisibility(View.GONE);
                q22.setVisibility(View.VISIBLE);
            }
        });
        back22 = (Button)findViewById(R.id.back22);
        back22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q21.setVisibility(View.VISIBLE);
                q22.setVisibility(View.GONE);
            }
        });
        next22 =(Button) findViewById(R.id.next22);
        next22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q22.setVisibility(View.GONE);
                q23.setVisibility(View.VISIBLE);
            }
        });
        back23 = (Button) findViewById(R.id.back23);
        back23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q22.setVisibility(View.VISIBLE);
                q23.setVisibility(View.GONE);
            }
        });
        next23 = (Button) findViewById(R.id.next23);
        next23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q23.setVisibility(View.GONE);
                q24.setVisibility(View.VISIBLE);
            }
        });
        back24 = (Button)findViewById(R.id.back24);
        back24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q23.setVisibility(View.VISIBLE);
                q24.setVisibility(View.GONE);
            }
        });
        next24 = (Button)findViewById(R.id.next24);
        next24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q24.setVisibility(View.GONE);
                q25.setVisibility(View.VISIBLE);
            }
        });
        back25 =(Button)findViewById(R.id.back25);
        back25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q24.setVisibility(View.VISIBLE);
                q25.setVisibility(View.GONE);
            }
        });

        //TextView
        question1 = findViewById(R.id.question1);
        question2 = findViewById(R.id.question2);
        question3 = findViewById(R.id.question3);
        question4 = findViewById(R.id.question4);
        question5 = findViewById(R.id.question5);
        question6 = findViewById(R.id.question6);
        question7 = findViewById(R.id.question7);
        question8 = findViewById(R.id.question8);
        question9 = findViewById(R.id.question9);
        question10 = findViewById(R.id.question10);
        question11 = findViewById(R.id.question11);
        question12 = findViewById(R.id.question12);
        question13 = findViewById(R.id.question13);
        question14 = findViewById(R.id.question14);
        question15 = findViewById(R.id.question15);
        question16 = findViewById(R.id.question16);
        question17 = findViewById(R.id.question17);
        question18 = findViewById(R.id.question18);
        question19 = findViewById(R.id.question19);
        question20 = findViewById(R.id.question20);
        question21 = findViewById(R.id.question21);
        question22 = findViewById(R.id.question22);
        question23 = findViewById(R.id.question23);
        question24 = findViewById(R.id.question24);
        question25 = findViewById(R.id.question25);

//EditText
        ans21 = findViewById(R.id.ans21);
        ans22 = findViewById(R.id.ans22);
        ans23 = findViewById(R.id.ans23);
        ans24 = findViewById(R.id.ans24);
        ans25 = findViewById(R.id.ans25);



        reverseTimer(300, timer);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Quizzes/week1");
        databaseReference.keepSynced(true);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> number = new ArrayList<String>();
                number.add(0, String.valueOf(1));
                number.add(0, String.valueOf(2));
                number.add(0, String.valueOf(3));
                number.add(0, String.valueOf(4));
                number.add(0, String.valueOf(5));
                number.add(0, String.valueOf(6));
                number.add(0, String.valueOf(7));
                number.add(0, String.valueOf(8));
                number.add(0, String.valueOf(9));
                number.add(0, String.valueOf(10));
                Collections.shuffle(number);

                ArrayList<String> tf = new ArrayList<String>();
                tf.add(0, String.valueOf(1));
                tf.add(0, String.valueOf(2));
                tf.add(0, String.valueOf(3));
                tf.add(0, String.valueOf(4));
                tf.add(0, String.valueOf(5));
                tf.add(0, String.valueOf(6));
                tf.add(0, String.valueOf(7));
                tf.add(0, String.valueOf(8));
                tf.add(0, String.valueOf(9));
                tf.add(0, String.valueOf(10));
                Collections.shuffle(tf);

                ArrayList<String> ident = new ArrayList<String>();
                ident.add(0, String.valueOf(1));
                ident.add(0, String.valueOf(2));
                ident.add(0, String.valueOf(3));
                ident.add(0, String.valueOf(4));
                ident.add(0, String.valueOf(5));
                ident.add(0, String.valueOf(6));

                Collections.shuffle(ident);

                final Question one = dataSnapshot.child("PrelimMultipleChoice").child(number.get(0)).getValue(Question.class);
                //Question1

                ArrayList<String> q1choice = new ArrayList<String>();

                q1choice.add(0, one.getOption1());
                q1choice.add(1, one.getOption2());
                q1choice.add(2, one.getOption3());
                q1choice.add(3, one.getOption4());
                Collections.shuffle(q1choice);
                correct1.setText(one.getAnswer());
                question1.setText(one.getQuestion());
                a1.setText(q1choice.get(0));
                b1.setText(q1choice.get(1));
                c1.setText(q1choice.get(2));
                d1.setText(q1choice.get(3));
                a1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = a1.getText().toString();
                        if (a1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                            q1.setBackgroundColor(Color.GREEN);
                            a1.setEnabled(false);
                            b1.setEnabled(false);
                            c1.setEnabled(false);
                            d1.setEnabled(false);
                        } else {
                            wrong++;
                            q1.setBackgroundColor(Color.RED);
                            correct1.setVisibility(View.VISIBLE);
                            a1.setEnabled(false);
                            b1.setEnabled(false);
                            c1.setEnabled(false);
                            d1.setEnabled(false);

                        }
                    }
                });

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = b1.getText().toString();
                        if (b1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                            q1.setBackgroundColor(Color.GREEN);
                            a1.setEnabled(false);
                            b1.setEnabled(false);
                            c1.setEnabled(false);
                            d1.setEnabled(false);
                        } else {
                            wrong++;
                            q1.setBackgroundColor(Color.RED);
                            correct1.setVisibility(View.VISIBLE);
                            a1.setEnabled(false);
                            b1.setEnabled(false);
                            c1.setEnabled(false);
                            d1.setEnabled(false);
                        }
                    }
                });

                c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = c1.getText().toString();
                        if (c1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                            q1.setBackgroundColor(Color.GREEN);
                            a1.setEnabled(false);
                            b1.setEnabled(false);
                            c1.setEnabled(false);
                            d1.setEnabled(false);
                        } else {
                            wrong++;
                            q1.setBackgroundColor(Color.RED);
                            correct1.setVisibility(View.VISIBLE);
                            a1.setEnabled(false);
                            b1.setEnabled(false);
                            c1.setEnabled(false);
                            d1.setEnabled(false);
                        }
                    }
                });

                d1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = d1.getText().toString();
                        if (d1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                            q1.setBackgroundColor(Color.GREEN);
                            a1.setEnabled(false);
                            b1.setEnabled(false);
                            c1.setEnabled(false);
                            d1.setEnabled(false);
                        } else {
                            wrong++;
                            q1.setBackgroundColor(Color.RED);
                            correct1.setVisibility(View.VISIBLE);
                            a1.setEnabled(false);
                            b1.setEnabled(false);
                            c1.setEnabled(false);
                            d1.setEnabled(false);
                        }

                    }
                });

                final Question two = dataSnapshot.child("PrelimMultipleChoice").child(number.get(1)).getValue(Question.class);
                //Question2
                ArrayList<String> q2choice = new ArrayList<String>();
                q2choice.add(0, two.getOption1());
                q2choice.add(0, two.getOption2());
                q2choice.add(0, two.getOption3());
                q2choice.add(0, two.getOption4());
                Collections.shuffle(q2choice);
                question2.setText(two.getQuestion());
                a2.setText(q2choice.get(0));
                b2.setText(q2choice.get(1));
                c2.setText(q2choice.get(2));
                d2.setText(q2choice.get(3));
                a2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer2 = a2.getText().toString();
                        if (a2.getText().toString().equals(two.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer2 = b2.getText().toString();
                        if (b2.getText().toString().equals(two.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer2 = c2.getText().toString();
                        if (c2.getText().toString().equals(two.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer2 = d2.getText().toString();
                        if (d2.getText().toString().equals(two.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //Question3
                final Question three = dataSnapshot.child("PrelimMultipleChoice").child(number.get(2)).getValue(Question.class);
                ArrayList<String> q3choice = new ArrayList<String>();
                q3choice.add(0, three.getOption1());
                q3choice.add(0, three.getOption2());
                q3choice.add(0, three.getOption3());
                q3choice.add(0, three.getOption4());
                Collections.shuffle(q3choice);
                question3.setText(three.getQuestion());
                a3.setText(q3choice.get(0));
                b3.setText(q3choice.get(1));
                c3.setText(q3choice.get(2));
                d3.setText(q3choice.get(3));

                a3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer3 = a3.getText().toString();
                        if (a3.getText().toString().equals(three.getAnswer())) {
                            correct++;

                        } else {
                            wrong++;
                        }
                    }
                });

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer3 = b3.getText().toString();
                        if (b3.getText().toString().equals(three.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer3 = c3.getText().toString();
                        if (c3.getText().toString().equals(three.getAnswer())) {
                            correct++;

                        } else {
                            wrong++;
                        }
                    }
                });

                d3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer3 = d3.getText().toString();
                        if (d3.getText().toString().equals(three.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //Question4
                final Question four = dataSnapshot.child("PrelimMultipleChoice").child(number.get(3)).getValue(Question.class);
                ArrayList<String> q4choice = new ArrayList<String>();
                q4choice.add(0, four.getOption1());
                q4choice.add(0, four.getOption2());
                q4choice.add(0, four.getOption3());
                q4choice.add(0, four.getOption4());
                Collections.shuffle(q4choice);
                question4.setText(four.getQuestion());
                a4.setText(q4choice.get(0));
                b4.setText(q4choice.get(1));
                c4.setText(q4choice.get(2));
                d4.setText(q4choice.get(3));

                a4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer4 = a4.getText().toString();
                        if (a4.getText().toString().equals(four.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer4 = b4.getText().toString();
                        if (b4.getText().toString().equals(four.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer4 = c4.getText().toString();
                        if (c4.getText().toString().equals(four.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer4 = d4.getText().toString();
                        if (d4.getText().toString().equals(four.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //question 5
                final Question five = dataSnapshot.child("PrelimMultipleChoice").child(number.get(4)).getValue(Question.class);
                ArrayList<String> q5choice = new ArrayList<String>();
                q5choice.add(0, five.getOption1());
                q5choice.add(0, five.getOption2());
                q5choice.add(0, five.getOption3());
                q5choice.add(0, five.getOption4());
                Collections.shuffle(q5choice);
                question5.setText(five.getQuestion());
                a5.setText(q5choice.get(0));
                b5.setText(q5choice.get(1));
                c5.setText(q5choice.get(2));
                d5.setText(q5choice.get(3));

                a5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer5 = a5.getText().toString();
                        if (a5.getText().toString().equals(five.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer5 = b5.getText().toString();
                        if (b5.getText().toString().equals(five.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer5 = c5.getText().toString();
                        if (c5.getText().toString().equals(five.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer5 = d5.getText().toString();
                        if (d5.getText().toString().equals(five.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //question 6
                final Question six = dataSnapshot.child("PrelimMultipleChoice").child(number.get(5)).getValue(Question.class);
                ArrayList<String> q6choice = new ArrayList<String>();
                q6choice.add(0, six.getOption1());
                q6choice.add(0, six.getOption2());
                q6choice.add(0, six.getOption3());
                q6choice.add(0, six.getOption4());
                Collections.shuffle(q6choice);
                question6.setText(six.getQuestion());
                a6.setText(q6choice.get(0));
                b6.setText(q6choice.get(1));
                c6.setText(q6choice.get(2));
                d6.setText(q6choice.get(3));

                a6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer6 = a6.getText().toString();
                        if (a6.getText().toString().equals(six.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer6 = b6.getText().toString();
                        if (b6.getText().toString().equals(six.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer6 = c6.getText().toString();
                        if (c6.getText().toString().equals(six.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer6 = d6.getText().toString();
                        if (d6.getText().toString().equals(six.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //question 7
                final Question seven = dataSnapshot.child("PrelimMultipleChoice").child(number.get(6)).getValue(Question.class);
                ArrayList<String> q7choice = new ArrayList<String>();
                q7choice.add(0, seven.getOption1());
                q7choice.add(0, seven.getOption2());
                q7choice.add(0, seven.getOption3());
                q7choice.add(0, seven.getOption4());
                Collections.shuffle(q7choice);
                question7.setText(seven.getQuestion());
                a7.setText(q7choice.get(0));
                b7.setText(q7choice.get(1));
                c7.setText(q7choice.get(2));
                d7.setText(q7choice.get(3));

                a7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer7 = a7.getText().toString();
                        if (a7.getText().toString().equals(seven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer7 = b7.getText().toString();
                        if (b7.getText().toString().equals(seven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer7 = c7.getText().toString();
                        if (c7.getText().toString().equals(seven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer7 = d7.getText().toString();
                        if (d7.getText().toString().equals(seven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //question 8
                final Question eight = dataSnapshot.child("PrelimMultipleChoice").child(number.get(7)).getValue(Question.class);
                ArrayList<String> q8choice = new ArrayList<String>();
                q8choice.add(0, eight.getOption1());
                q8choice.add(0, eight.getOption2());
                q8choice.add(0, eight.getOption3());
                q8choice.add(0, eight.getOption4());
                Collections.shuffle(q8choice);
                question8.setText(eight.getQuestion());
                a8.setText(q8choice.get(0));
                b8.setText(q8choice.get(1));
                c8.setText(q8choice.get(2));
                d8.setText(q8choice.get(3));

                a8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer8 = a8.getText().toString();
                        if (a8.getText().toString().equals(eight.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer8 = b8.getText().toString();
                        if (b8.getText().toString().equals(eight.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer8 = c8.getText().toString();
                        if (c8.getText().toString().equals(eight.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer8 = d8.getText().toString();
                        if (d8.getText().toString().equals(eight.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });



                //question 9
                final Question nine = dataSnapshot.child("PrelimMultipleChoice").child(number.get(8)).getValue(Question.class);
                ArrayList<String> q9choice = new ArrayList<String>();
                q9choice.add(0, eight.getOption1());
                q9choice.add(0, eight.getOption2());
                q9choice.add(0, eight.getOption3());
                q9choice.add(0, eight.getOption4());
                Collections.shuffle(q9choice);
                question9.setText(nine.getQuestion());
                a9.setText(q9choice.get(0));
                b9.setText(q9choice.get(1));
                c9.setText(q9choice.get(2));
                d9.setText(q9choice.get(3));

                a9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer9 = a9.getText().toString();
                        if (a9.getText().toString().equals(nine.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer9 = b9.getText().toString();
                        if (b9.getText().toString().equals(nine.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer9 = c9.getText().toString();
                        if (c9.getText().toString().equals(nine.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer9 = d9.getText().toString();
                        if (d9.getText().toString().equals(nine.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //question 9
                final Question ten = dataSnapshot.child("PrelimMultipleChoice").child(number.get(9)).getValue(Question.class);
                ArrayList<String> q10choice = new ArrayList<String>();
                q10choice.add(0, eight.getOption1());
                q10choice.add(0, eight.getOption2());
                q10choice.add(0, eight.getOption3());
                q10choice.add(0, eight.getOption4());
                Collections.shuffle(q9choice);
                question10.setText(ten.getQuestion());
                a10.setText(q9choice.get(0));
                b10.setText(q9choice.get(1));
                c10.setText(q9choice.get(2));
                d10.setText(q9choice.get(3));
                a10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer10 = a10.getText().toString();
                        if (a10.getText().toString().equals(ten.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer10 = b10.getText().toString();
                        if (b10.getText().toString().equals(ten.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer10 = c10.getText().toString();
                        if (c10.getText().toString().equals(ten.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer10 = d10.getText().toString();
                        if (d10.getText().toString().equals(ten.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });



                final Question eleven = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(0)).getValue(Question.class);
                question11.setText(eleven.getQuestion());
                a11.setText(eleven.getOption1());
                b11.setText(eleven.getOption2());

                a11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer11 = a11.getText().toString();
                        if (a11.getText().toString().equals(eleven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer11 = b11.getText().toString();
                        if (b11.getText().toString().equals(eleven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                final Question twelve = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(1)).getValue(Question.class);
                question12.setText(twelve.getQuestion());
                a12.setText(twelve.getOption1());
                b12.setText(twelve.getOption2());

                a12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer12 = a12.getText().toString();
                        if (a12.getText().toString().equals(twelve.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer12 = b12.getText().toString();
                        if (b12.getText().toString().equals(twelve.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });




                final Question thirteen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(2)).getValue(Question.class);
                question13.setText(thirteen.getQuestion());
                a13.setText(thirteen.getOption1());
                b13.setText(thirteen.getOption2());

                a13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer13 = a13.getText().toString();
                        if (a13.getText().toString().equals(thirteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer13 = b3.getText().toString();
                        if (b13.getText().toString().equals(thirteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });



                final Question forthteen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(3)).getValue(Question.class);
                question14.setText(forthteen.getQuestion());
                a14.setText(forthteen.getOption1());
                b14.setText(forthteen.getOption2());

                a14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer14 = a14.getText().toString();
                        if (a14.getText().toString().equals(forthteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer14 = b14.getText().toString();
                        if (b14.getText().toString().equals(forthteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                final Question fifteen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(4)).getValue(Question.class);
                question15.setText(fifteen.getQuestion());
                a15.setText(fifteen.getOption1());
                b15.setText(fifteen.getOption2());

                a15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer15 = a15.getText().toString();
                        if (a15.getText().toString().equals(fifteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer15 = b5.getText().toString();
                        if (b15.getText().toString().equals(fifteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                final Question sixteen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(5)).getValue(Question.class);
                question16.setText(sixteen.getQuestion());
                a16.setText(sixteen.getOption1());
                b16.setText(sixteen.getOption2());

                a16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer16 = a16.getText().toString();
                        if (a16.getText().toString().equals(sixteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer16 = b16.getText().toString();
                        if (b16.getText().toString().equals(sixteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                final Question seventeen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(6)).getValue(Question.class);
                question17.setText(seventeen.getQuestion());
                a17.setText(seventeen.getOption1());
                b17.setText(seventeen.getOption2());

                a17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer17 = a17.getText().toString();
                        if (a17.getText().toString().equals(seventeen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer17 = b7.getText().toString();
                        if (b17.getText().toString().equals(seventeen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });



                final Question eighteen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(7)).getValue(Question.class);
                question18.setText(eighteen.getQuestion());
                a18.setText(eighteen.getOption1());
                b18.setText(eighteen.getOption2());

                a18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer18 = a18.getText().toString();
                        if (a18.getText().toString().equals(eighteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer18 = b8.getText().toString();
                        if (b18.getText().toString().equals(eighteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });



                final Question nineteen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(8)).getValue(Question.class);
                question19.setText(nineteen.getQuestion());
                a19.setText(nineteen.getOption1());
                b19.setText(nineteen.getOption2());

                a19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer19 = a19.getText().toString();
                        if (a19.getText().toString().equals(nineteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer19 = b19.getText().toString();
                        if (b19.getText().toString().equals(nineteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                final Question twenty = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(9)).getValue(Question.class);
                question20.setText(twenty.getQuestion());
                a20.setText(twenty.getOption1());
                b20.setText(twenty.getOption2());

                a20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer20 = a20.getText().toString();
                        if (a20.getText().toString().equals(twenty.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer20 = b20.getText().toString();
                        if (b20.getText().toString().equals(twenty.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //Question21
                final Question twentyone = dataSnapshot.child("PrelimIdentification").child(ident.get(0)).getValue(Question.class);
                question21.setText(twentyone.getQuestion());

                //Question22
                final Question twentytwo = dataSnapshot.child("PrelimIdentification").child(ident.get(1)).getValue(Question.class);
                question22.setText(twentytwo.getQuestion());

                //Question23
                final Question twentythree = dataSnapshot.child("PrelimIdentification").child(ident.get(2)).getValue(Question.class);
                question23.setText(twentythree.getQuestion());

                //Question24
                final Question twentyfour = dataSnapshot.child("PrelimIdentification").child(ident.get(3)).getValue(Question.class);
                question24.setText(twentyfour.getQuestion());

                //Question25
                final Question twentyfive = dataSnapshot.child("PrelimIdentification").child(ident.get(4)).getValue(Question.class);
                question25.setText(twentyfive.getQuestion());




                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        answer21 = ans21.getText().toString();
                        if (answer21.equals(twentyone.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer22 = ans22.getText().toString();
                        if (answer22.equals(twentytwo.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer23= ans23.getText().toString();
                        if (ans23.getText().toString().equals(twentythree.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer24= ans24.getText().toString();
                        if (ans24.getText().toString().equals(twentyfour.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }


                        answer25= ans25.getText().toString();
                        if (ans25.getText().toString().equals(twentyfive.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }


                        //storing history stuff
                        String pq1_h1_pref = sharedPreferences.getString("pq1_h1_date", null);
                        if(pq1_h1_pref == null) {
                            myEdit.putString("pq1_h1_date",currdate);
                            myEdit.putInt("pq1_h1_score", correct);
                            myEdit.commit();

                            myEdit.putString("test","test");
                            Log.i("SP_", "pq1_h1 processed");

                        } else {
                            String pq1_h2_pref = sharedPreferences.getString("pq1_h2_date", null);
                            if (pq1_h2_pref == null) {
                                myEdit.putString("pq1_h2_date", currdate);
                                myEdit.putInt("pq1_h2_score", correct);
                                myEdit.commit();
                                Log.i("SP_", "pq1_h2 processed");
                            } else {
                                String pq1_h3_pref = sharedPreferences.getString("pq1_h3_date", null);
                                if (pq1_h3_pref == null) {
                                    myEdit.putString("pq1_h3_date", currdate);
                                    myEdit.putInt("pq1_h3_score", correct);
                                    myEdit.commit();
                                    Log.i("SP_", "pq1_h3 processed");
                                } else {

                                    String pq1_h4_pref = sharedPreferences.getString("pq1_h4_date", null);
                                    if (pq1_h4_pref == null) {
                                        myEdit.putString("pq1_h4_date", currdate);
                                        myEdit.putInt("pq1_h4_score", correct);
                                        myEdit.commit();
                                        Log.i("SP_", "pq1_h4 processed");
                                    } else {
                                        String pq1_h5_pref = sharedPreferences.getString("pq1_h5_date", null);
                                        if (pq1_h5_pref == null) {
                                            myEdit.putString("pq1_h5_date", currdate);
                                            myEdit.putInt("pq1_h5_score", correct);
                                            myEdit.commit();
                                            Log.i("SP_", "pq1_h5 processed");
                                        } else{
                                            String pq1_h6_pref = sharedPreferences.getString("pq1_h6_date", null);
                                            if (pq1_h6_pref == null) {
                                                myEdit.putString("pq1_h6_date", currdate);
                                                myEdit.putInt("pq1_h6_score", correct);
                                                myEdit.commit();
                                                Log.i("SP_", "pq1_h6 processed");
                                            }else{
                                                String pq1_h7_pref = sharedPreferences.getString("pq1_h7_date", null);
                                                if (pq1_h7_pref == null) {
                                                    myEdit.putString("pq1_h7_date", currdate);
                                                    myEdit.putInt("pq1_h7_score", correct);
                                                    myEdit.commit();
                                                    Log.i("SP_", "pq1_h7 processed");
                                                }else{
                                                    String pq1_h8_pref = sharedPreferences.getString("pq1_h8_date", null);
                                                    if (pq1_h8_pref == null) {
                                                        myEdit.putString("pq1_h8_date", currdate);
                                                        myEdit.putInt("pq1_h8_score", correct);
                                                        myEdit.commit();
                                                        Log.i("SP_", "pq1_h8 processed");
                                                    }else{
                                                        String pq1_h9_pref = sharedPreferences.getString("pq1_h9_date", null);
                                                        if (pq1_h9_pref == null) {
                                                            myEdit.putString("pq1_h9_date", currdate);
                                                            myEdit.putInt("pq1_h9_score", correct);
                                                            myEdit.commit();
                                                            Log.i("SP_", "pq1_h9 processed");
                                                        }else{
                                                            String pq1_h10_pref = sharedPreferences.getString("pq1_h10_date", null);
                                                            if (pq1_h10_pref == null) {
                                                                myEdit.putString("pq1_h10_date", currdate);
                                                                myEdit.putInt("pq1_h10_score", correct);
                                                                myEdit.commit();
                                                                Log.i("SP_", "pq1_h10 processed");
                                                            }else{
                                                                Log.i("SP_","history is full");

                                                                //adjusts entries 2 to 1, 3 to 2 and so on
                                                                myEdit.putString("pq1_h1_date",  sharedPreferences.getString("pq1_h2_date", ""));
                                                                myEdit.putInt("pq1_h1_score", sharedPreferences.getInt("pq1_h2_score", 0));

                                                                myEdit.putString("pq1_h2_date",  sharedPreferences.getString("pq1_h3_date", ""));
                                                                myEdit.putInt("pq1_h2_score", sharedPreferences.getInt("pq1_h3_score", 0));

                                                                myEdit.putString("pq1_h3_date",  sharedPreferences.getString("pq1_h4_date", ""));
                                                                myEdit.putInt("pq1_h3_score", sharedPreferences.getInt("pq1_h4_score", 0));

                                                                myEdit.putString("pq1_h4_date",  sharedPreferences.getString("pq1_h5_date", ""));
                                                                myEdit.putInt("pq1_h4_score", sharedPreferences.getInt("pq1_h5_score", 0));

                                                                myEdit.putString("pq1_h5_date",  sharedPreferences.getString("pq1_h6_date", ""));
                                                                myEdit.putInt("pq1_h5_score", sharedPreferences.getInt("pq1_h6_score", 0));

                                                                myEdit.putString("pq1_h6_date",  sharedPreferences.getString("pq1_h7_date", ""));
                                                                myEdit.putInt("pq1_h6_score", sharedPreferences.getInt("pq1_h7_score", 0));

                                                                myEdit.putString("pq1_h7_date",  sharedPreferences.getString("pq1_h8_date", ""));
                                                                myEdit.putInt("pq1_h7_score", sharedPreferences.getInt("pq1_h8_score", 0));

                                                                myEdit.putString("pq1_h8_date",  sharedPreferences.getString("pq1_h9_date", ""));
                                                                myEdit.putInt("pq1_h8_score", sharedPreferences.getInt("pq1_h9_score", 0));

                                                                myEdit.putString("pq1_h9_date",  sharedPreferences.getString("pq1_h10_date", ""));
                                                                myEdit.putInt("pq1_h9_score", sharedPreferences.getInt("pq1_h10_score", 0));
                                                                //adjusts entries 2 to 1, 3 to 2 and so on
                                                                myEdit.putString("pq1_h10_date", currdate);
                                                                myEdit.putInt("pq1_h10_score", correct);
                                                                myEdit.commit();

                                                            }
                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //end of storing history stuff

                        sharedPreferences  = getSharedPreferences("P_Q1SharedPref", MODE_PRIVATE);
                        int q1_h1_s = sharedPreferences.getInt("pq1_h1_score", 0);
                        String q1_h1_d = sharedPreferences.getString("pq1_h1_date", "");
                        int q1_h2_s = sharedPreferences.getInt("pq1_h2_score", 0);
                        String q1_h2_d = sharedPreferences.getString("pq1_h2_date", "");
                        int q1_h3_s = sharedPreferences.getInt("pq1_h3_score", 0);
                        String q1_h3_d = sharedPreferences.getString("pq1_h3_date", "");
                        int q1_h4_s = sharedPreferences.getInt("pq1_h4_score", 0);
                        String q1_h4_d = sharedPreferences.getString("pq1_h4_date", "");
                        int q1_h5_s = sharedPreferences.getInt("pq1_h5_score", 0);
                        String q1_h5_d = sharedPreferences.getString("pq1_h5_date", "");
                        int q1_h6_s = sharedPreferences.getInt("pq1_h6_score", 0);
                        String q1_h6_d = sharedPreferences.getString("pq1_h6_date", "");
                        int q1_h7_s = sharedPreferences.getInt("pq1_h7_score", 0);
                        String q1_h7_d = sharedPreferences.getString("pq1_h7_date", "");
                        int q1_h8_s = sharedPreferences.getInt("pq1_h8_score", 0);
                        String q1_h8_d = sharedPreferences.getString("pq1_h8_date", "");
                        int q1_h9_s = sharedPreferences.getInt("pq1_h9_score", 0);
                        String q1_h9_d = sharedPreferences.getString("pq1_h9_date", "");
                        int q1_h10_s = sharedPreferences.getInt("pq1_h10_score", 0);
                        String q1_h10_d = sharedPreferences.getString("pq1_h10_date", "");
                        Log.i("SP_content", "" );
                        Log.i("SP_content", "h1: "+ q1_h1_d +" "+ q1_h1_s );
                        Log.i("SP_content", "h2: "+ q1_h2_d +" "+ q1_h2_s );
                        Log.i("SP_content", "h3: "+ q1_h3_d +" "+ q1_h3_s );
                        Log.i("SP_content", "h4: "+ q1_h4_d +" "+ q1_h4_s );
                        Log.i("SP_content", "h5: "+ q1_h5_d +" "+ q1_h5_s );
                        Log.i("SP_content", "h6: "+ q1_h6_d +" "+ q1_h6_s );
                        Log.i("SP_content", "h7: "+ q1_h7_d +" "+ q1_h7_s );
                        Log.i("SP_content", "h8: "+ q1_h8_d +" "+ q1_h8_s );
                        Log.i("SP_content", "h9: "+ q1_h9_d +" "+ q1_h9_s );
                        Log.i("SP_content", "h10: "+ q1_h10_d +" "+ q1_h10_s );

                        //quiz history


                        //save prelim quiz 1 result
//                        myEdit.putString("pq1_h1_date",currdate);
//                        myEdit.putInt("pq1_h1_score", correct);
//                        myEdit.commit();

                        AlertDialog dialog = new AlertDialog.Builder(prelim_quiz1.this)

                                .setTitle("Caution")
                                .setMessage("Are you sure you want to submit??")
                                .setPositiveButton("Yes", null)
                                .setNegativeButton("No", null)
                                .show();
                        dialog.setCanceledOnTouchOutside(false);
                        final Button positiveButton1 = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        positiveButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                AlertDialog dialog1 = new AlertDialog.Builder(prelim_quiz1.this)
                                        .setTitle("Score")
                                        .setMessage("Your score was: \t" + correct)
                                        .setPositiveButton("OK", null)
                                        .show();
                                final Button positiveButton = dialog1.getButton(AlertDialog.BUTTON_POSITIVE);
                                positiveButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(prelim_quiz1.this, prelim_quiz1.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void reverseTimer(int seconds, final TextView tv) {
        new CountDownTimer(seconds * 1000 + 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                tv.setText("Times Up");
                a1.setEnabled(false);
                b1.setEnabled(false);
                c1.setEnabled(false);
                d1.setEnabled(false);
                a2.setEnabled(false);
                b2.setEnabled(false);
                c2.setEnabled(false);
                d2.setEnabled(false);
                a3.setEnabled(false);
                b3.setEnabled(false);
                c3.setEnabled(false);
                d3.setEnabled(false);
                a4.setEnabled(false);
                b4.setEnabled(false);
                c4.setEnabled(false);
                d4.setEnabled(false);
                a5.setEnabled(false);
                b5.setEnabled(false);
                c5.setEnabled(false);
                d5.setEnabled(false);
                a6.setEnabled(false);
                b6.setEnabled(false);
                c6.setEnabled(false);
                d6.setEnabled(false);
                a7.setEnabled(false);
                b7.setEnabled(false);
                c7.setEnabled(false);
                d7.setEnabled(false);
                a8.setEnabled(false);
                b8.setEnabled(false);
                c8.setEnabled(false);
                d8.setEnabled(false);
                a9.setEnabled(false);
                b9.setEnabled(false);
                c9.setEnabled(false);
                d9.setEnabled(false);
                a10.setEnabled(false);
                b10.setEnabled(false);
                c10.setEnabled(false);
                d10.setEnabled(false);

            }
        }.start();


    }
    public void onBackPressed () {
    }


}
