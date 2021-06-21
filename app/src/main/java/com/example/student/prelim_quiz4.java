package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class prelim_quiz4 extends AppCompatActivity {

    Button submit;
    int total = 0;
    int correct = 0;
    int wrong = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
    long datetime = new Date().getTime();
    ;
    String check;
    TextView timer;
    //Multiple Choice
    String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,answer11, answer12, answer13, answer14, answer15;
    //True or False
    String  answer16, answer17, answer18, answer19, answer20, answer21,answer22, answer23, answer24,answer25,answer26,answer27,answer28,answer29,answer30 ;
    //Identification
    String answer31, answer32, answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40;

    //    quizmenu qz;
    String childname;

    TextView question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13, question14, question15
            , question16, question17, question18, question19, question20 , question21, question22, question23, question24, question25, question26, question27, question28, question29, question30
            , question31, question32, question33, question34, question35, question36, question37, question38, question39, question40;


    //multiple Choice Radio Group
    RadioGroup q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15;
    //True or False Radio Group
    RadioGroup q16, q17, q18, q19, q20, q21, q22, q23, q24, q25, q26, q27, q28, q29, q30;
    //identification
    RadioGroup q31, q32, q33, q34, q35, q36, q37, q38, q39, q40;


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
    Button a11, b11, c11, d11;
    Button a12, b12, c12, d12;
    Button a13, b13, c13, d13;
    Button a14, b14, c14, d14;
    Button a15, b15, c15, d15;

    // True or False Button

    Button a16, b16;
    Button a17, b17;
    Button a18, b18;
    Button a19, b19;
    Button a20, b20;
    Button a21 ,b21;
    Button a22 ,b22;
    Button a23 ,b23;
    Button a24 ,b24;
    Button a25 ,b25;
    Button a26 ,b26;
    Button a27 ,b27;
    Button a28 ,b28;
    Button a29 ,b29;
    Button a30 ,b30;


    EditText ans31, ans32, ans33, ans34, ans35, ans36, ans37, ans38, ans39, ans40;
    Button next1, next2, next3, next4, next5, next6, next7, next8, next9, next10, next11, next12, next13, next14, next15, next16, next17, next18, next19
            , next20,next21,next22,next23,next24,next25,next26,next27,next28,next29, next30, next31, next32, next33, next34, next35, next36, next37, next38, next39,
            back2, back3, back4, back5, back6, back7, back8, back9, back10, back11, back12, back13, back14, back15, back16, back17, back18, back19, back20
            ,back21,back22,back23,back24, back25, back26, back27, back28, back29, back30, back31, back32, back33, back34, back35, back36, back37, back38, back39, back40;

    DatabaseReference databaseReference;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prelim_quiz4);

        correct = 0;

        // Storing data into SharedPreferences
        sharedPreferences = getSharedPreferences("P_Q4SharedPref",MODE_PRIVATE);
        // Creating an Editor object to edit(write to the file)
        final SharedPreferences.Editor myEdit = sharedPreferences.edit();

        //getDate
        DateTime dt = new DateTime();
        final String currdate = dt.getDate();

        timer = findViewById(R.id.textView10);
        //Button
        submit = findViewById(R.id.submit);
        //RadioGroup



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
        q11 = findViewById(R.id.q11);
        q12 = findViewById(R.id.q12);
        q13 = findViewById(R.id.q13);
        q14 = findViewById(R.id.q14);
        q15 = findViewById(R.id.q15);
        q16 = findViewById(R.id.q16);

        //RadioButton for True or false

        q17 = findViewById(R.id.q17);
        q18 = findViewById(R.id.q18);
        q19 = findViewById(R.id.q19);
        q20 = findViewById(R.id.q20);
        q21 =findViewById(R.id.q21);
        q22 =findViewById(R.id.q22);
        q23 =findViewById(R.id.q23);
        q24 =findViewById(R.id.q24);
        q25 =findViewById(R.id.q25);
        q26 =findViewById(R.id.q26);
        q27 =findViewById(R.id.q27);
        q28 =findViewById(R.id.q28);
        q29 =findViewById(R.id.q29);
        q30 =findViewById(R.id.q30);


        //Identification
        q31 = findViewById(R.id.q31);
        q32 = findViewById(R.id.q32);
        q33 = findViewById(R.id.q33);
        q34 = findViewById(R.id.q34);
        q35 = findViewById(R.id.q35);
        q36 = findViewById(R.id.q36);
        q37 = findViewById(R.id.q37);
        q38 = findViewById(R.id.q38);
        q39 = findViewById(R.id.q39);
        q40 = findViewById(R.id.q40);


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
        //Radio Button11
        a11 = findViewById(R.id.a11);
        b11 = findViewById(R.id.b11);
        c11 = findViewById(R.id.c11);
        d11 = findViewById(R.id.d11);

        a12 = findViewById(R.id.a12);
        b12 = findViewById(R.id.b12);
        c12 = findViewById(R.id.c12);
        d12 = findViewById(R.id.d12);


        a13 = findViewById(R.id.a13);
        b13 = findViewById(R.id.b13);
        c13 = findViewById(R.id.c13);
        d13 = findViewById(R.id.d13);

        a14 = findViewById(R.id.a14);
        b14 = findViewById(R.id.b14);
        c14 = findViewById(R.id.c14);
        d14 = findViewById(R.id.d14);

        a15 = findViewById(R.id.a15);
        b15 = findViewById(R.id.b15);
        c15 = findViewById(R.id.c15);
        d15 = findViewById(R.id.d15);
        //True or false Buttons


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

        a21 = findViewById(R.id.a21);
        b21 = findViewById(R.id.b21);

        a22 = findViewById(R.id.a22);
        b22 = findViewById(R.id.b22);

        a23 = findViewById(R.id.a23);
        b23 = findViewById(R.id.b23);

        a24 = findViewById(R.id.a24);
        b24 = findViewById(R.id.b24);

        a25 = findViewById(R.id.a25);
        b25 = findViewById(R.id.b25);

        a26 = findViewById(R.id.a26);
        b26 = findViewById(R.id.b26);

        a27 = findViewById(R.id.a27);
        b27 = findViewById(R.id.b27);

        a28 = findViewById(R.id.a28);
        b28 = findViewById(R.id.b28);

        a29 = findViewById(R.id.a29);
        b29 = findViewById(R.id.b29);

        a30 = findViewById(R.id.a30);
        b30 = findViewById(R.id.b30);



        //Back and Next
        //Back and Next
        next1 = (Button) findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q1.setVisibility(View.GONE);
                q2.setVisibility(View.VISIBLE);
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
        next25 = (Button)findViewById(R.id.next25);
        next25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q25.setVisibility(View.GONE);
                q26.setVisibility(View.VISIBLE);

            }
        });
        back26 =(Button)findViewById(R.id.back26);
        back26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q25.setVisibility(View.VISIBLE);
                q26.setVisibility(View.GONE);
            }
        });
        next27 = (Button)findViewById(R.id.next26);
        next27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q26.setVisibility(View.GONE);
                q27.setVisibility(View.VISIBLE);

            }
        });

        back27 =(Button)findViewById(R.id.back27);
        back27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q26.setVisibility(View.VISIBLE);
                q27.setVisibility(View.GONE);
            }
        });
        next27 = (Button)findViewById(R.id.next27);
        next27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q27.setVisibility(View.GONE);
                q28.setVisibility(View.VISIBLE);

            }
        });


        back28 =(Button)findViewById(R.id.back28);
        back28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q27.setVisibility(View.VISIBLE);
                q28.setVisibility(View.GONE);
            }
        });
        next28 = (Button)findViewById(R.id.next28);
        next28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q28.setVisibility(View.GONE);
                q29.setVisibility(View.VISIBLE);

            }
        });
        back29 =(Button)findViewById(R.id.back29);
        back29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q28.setVisibility(View.VISIBLE);
                q29.setVisibility(View.GONE);
            }
        });
        next29 = (Button)findViewById(R.id.next29);
        next29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q29.setVisibility(View.GONE);
                q30.setVisibility(View.VISIBLE);

            }
        });
        back30 =(Button)findViewById(R.id.back30);
        back30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q29.setVisibility(View.VISIBLE);
                q30.setVisibility(View.GONE);
            }
        });
        next30 = (Button)findViewById(R.id.next30);
        next30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q30.setVisibility(View.GONE);
                q31.setVisibility(View.VISIBLE);

            }
        });
        back31 =(Button)findViewById(R.id.back31);
        back31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q30.setVisibility(View.VISIBLE);
                q31.setVisibility(View.GONE);
            }
        });
        next31 = (Button)findViewById(R.id.next31);
        next31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q31.setVisibility(View.GONE);
                q32.setVisibility(View.VISIBLE);

            }
        });

        back32 =(Button)findViewById(R.id.back32);
        back32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q31.setVisibility(View.VISIBLE);
                q32.setVisibility(View.GONE);
            }
        });
        next32 = (Button)findViewById(R.id.next32);
        next32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q32.setVisibility(View.GONE);
                q33.setVisibility(View.VISIBLE);

            }
        });
        back33 =(Button)findViewById(R.id.back33);
        back33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q32.setVisibility(View.VISIBLE);
                q33.setVisibility(View.GONE);
            }
        });
        next33 = (Button)findViewById(R.id.next33);
        next33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q33.setVisibility(View.GONE);
                q34.setVisibility(View.VISIBLE);

            }
        });

        back34 =(Button)findViewById(R.id.back34);
        back34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q33.setVisibility(View.VISIBLE);
                q34.setVisibility(View.GONE);
            }
        });
        next34 = (Button)findViewById(R.id.next34);
        next34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q34.setVisibility(View.GONE);
                q35.setVisibility(View.VISIBLE);

            }
        });

        back35 =(Button)findViewById(R.id.back35);
        back35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q34.setVisibility(View.VISIBLE);
                q35.setVisibility(View.GONE);
            }
        });
        next35 = (Button)findViewById(R.id.next35);
        next35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q35.setVisibility(View.GONE);
                q36.setVisibility(View.VISIBLE);

            }
        });

        back36 =(Button)findViewById(R.id.back36);
        back36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q35.setVisibility(View.VISIBLE);
                q36.setVisibility(View.GONE);
            }
        });
        next36 = (Button)findViewById(R.id.next36);
        next36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q36.setVisibility(View.GONE);
                q37.setVisibility(View.VISIBLE);

            }
        });

        back37 =(Button)findViewById(R.id.back37);
        back37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q36.setVisibility(View.VISIBLE);
                q37.setVisibility(View.GONE);
            }
        });
        next37 = (Button)findViewById(R.id.next37);
        next37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q37.setVisibility(View.GONE);
                q38.setVisibility(View.VISIBLE);

            }
        });

        back38 =(Button)findViewById(R.id.back38);
        back38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q37.setVisibility(View.VISIBLE);
                q38.setVisibility(View.GONE);
            }
        });
        next38 = (Button)findViewById(R.id.next38);
        next38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q38.setVisibility(View.GONE);
                q39.setVisibility(View.VISIBLE);

            }
        });

        back39 =(Button)findViewById(R.id.back39);
        back39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q38.setVisibility(View.VISIBLE);
                q39.setVisibility(View.GONE);
            }
        });
        next39 = (Button)findViewById(R.id.next39);
        next39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q39.setVisibility(View.GONE);
                q40.setVisibility(View.VISIBLE);

            }
        });
        back40 = (Button)  findViewById(R.id.back40);
        back40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q39.setVisibility(View.VISIBLE);
                q40.setVisibility(View.GONE);
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
        question26 = findViewById(R.id.question26);
        question27 = findViewById(R.id.question27);
        question28 = findViewById(R.id.question28);
        question29 = findViewById(R.id.question29);
        question30 = findViewById(R.id.question30);
        question31 = findViewById(R.id.question31);
        question32 = findViewById(R.id.question32);
        question33 = findViewById(R.id.question33);
        question34 = findViewById(R.id.question34);
        question35 = findViewById(R.id.question35);
        question36 = findViewById(R.id.question36);
        question37 = findViewById(R.id.question37);
        question38 = findViewById(R.id.question38);
        question39 = findViewById(R.id.question39);
        question40 = findViewById(R.id.question40);

        //EditText
        ans31 = findViewById(R.id.ans31);
        ans32 = findViewById(R.id.ans32);
        ans33 = findViewById(R.id.ans33);
        ans34 = findViewById(R.id.ans34);
        ans35 = findViewById(R.id.ans35);
        ans36 = findViewById(R.id.ans36);
        ans37 = findViewById(R.id.ans37);
        ans38 = findViewById(R.id.ans38);
        ans39 = findViewById(R.id.ans39);
        ans40 = findViewById(R.id.ans40);


        reverseTimer(300, timer);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Quizzes/week4and5");
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
                number.add(0,String.valueOf(9));
                number.add(0,String.valueOf(10));
                number.add(0,String.valueOf(11));
                number.add(0,String.valueOf(12));
                number.add(0,String.valueOf(13));
                number.add(0,String.valueOf(14));
                number.add(0,String.valueOf(15));
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
                tf.add(0, String.valueOf(11));
                tf.add(0, String.valueOf(12));
                tf.add(0, String.valueOf(13));
                tf.add(0, String.valueOf(14));
                tf.add(0, String.valueOf(15));

                Collections.shuffle(tf);

                ArrayList<String> ident = new ArrayList<String>();
                ident.add(0, String.valueOf(1));
                ident.add(0, String.valueOf(2));
                ident.add(0, String.valueOf(3));
                ident.add(0, String.valueOf(4));
                ident.add(0, String.valueOf(5));
                ident.add(0, String.valueOf(6));
                ident.add(0, String.valueOf(7));
                ident.add(0, String.valueOf(8));
                ident.add(0, String.valueOf(9));
                ident.add(0, String.valueOf(10));

                Collections.shuffle(ident);


                final Question one = dataSnapshot.child("PrelimMultipleChoice").child(number.get(0)).getValue(Question.class);
                //Question1

                ArrayList<String> q1choice = new ArrayList<String>();

                q1choice.add(0, one.getOption1());
                q1choice.add(1, one.getOption2());
                q1choice.add(2, one.getOption3());
                q1choice.add(3, one.getOption4());
                Collections.shuffle(q1choice);
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
                        } else {
                            wrong++;
                        }
                    }
                });

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = b1.getText().toString();
                        if (b1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = c1.getText().toString();
                        if (c1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = d1.getText().toString();
                        if (d1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
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
                q9choice.add(0, nine.getOption1());
                q9choice.add(0, nine.getOption2());
                q9choice.add(0, nine.getOption3());
                q9choice.add(0, nine.getOption4());
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

                //question 10
                final Question ten = dataSnapshot.child("PrelimMultipleChoice").child(number.get(9)).getValue(Question.class);
                ArrayList<String> q10choice = new ArrayList<String>();
                q10choice.add(0, ten.getOption1());
                q10choice.add(0, ten.getOption2());
                q10choice.add(0, ten.getOption3());
                q10choice.add(0, ten.getOption4());
                Collections.shuffle(q9choice);
                question10.setText(ten.getQuestion());
                a10.setText(q10choice.get(0));
                b10.setText(q10choice.get(1));
                c10.setText(q10choice.get(2));
                d10.setText(q10choice.get(3));
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

                //11
                final Question eleven = dataSnapshot.child("PrelimMultipleChoice").child(number.get(10)).getValue(Question.class);
                ArrayList<String> q11choice = new ArrayList<String>();
                q11choice.add(0, eleven.getOption1());
                q11choice.add(0, eleven.getOption2());
                q11choice.add(0, eleven.getOption3());
                q11choice.add(0, eleven.getOption4());
                Collections.shuffle(q9choice);
                question11.setText(eleven.getQuestion());
                a11.setText(q11choice.get(0));
                b11.setText(q11choice.get(1));
                c11.setText(q11choice.get(2));
                d11.setText(q11choice.get(3));
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

                c11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer11 = c11.getText().toString();
                        if (c11.getText().toString().equals(eleven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer11 = d11.getText().toString();
                        if (d11.getText().toString().equals(eleven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });



                //12
                final Question twelve = dataSnapshot.child("PrelimMultipleChoice").child(number.get(11)).getValue(Question.class);
                ArrayList<String> q12choice = new ArrayList<String>();
                q12choice.add(0, twelve.getOption1());
                q12choice.add(0, twelve.getOption2());
                q12choice.add(0, twelve.getOption3());
                q12choice.add(0, twelve.getOption4());
                Collections.shuffle(q9choice);
                question12.setText(twelve.getQuestion());
                a12.setText(q12choice.get(0));
                b12.setText(q12choice.get(1));
                c12.setText(q12choice.get(2));
                d12.setText(q12choice.get(3));
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

                c12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer12 = c12.getText().toString();
                        if (c12.getText().toString().equals(twelve.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer12 = d12.getText().toString();
                        if (d12.getText().toString().equals(twelve.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //13
                final Question thirteen = dataSnapshot.child("PrelimMultipleChoice").child(number.get(12)).getValue(Question.class);
                ArrayList<String> q13choice = new ArrayList<String>();
                q13choice.add(0, thirteen.getOption1());
                q13choice.add(0, thirteen.getOption2());
                q13choice.add(0, thirteen.getOption3());
                q13choice.add(0, thirteen.getOption4());
                Collections.shuffle(q9choice);
                question13.setText(thirteen.getQuestion());
                a13.setText(q13choice.get(0));
                b13.setText(q13choice.get(1));
                c13.setText(q13choice.get(2));
                d13.setText(q13choice.get(3));
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
                        answer13 = b13.getText().toString();
                        if (b13.getText().toString().equals(thirteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer13 = c13.getText().toString();
                        if (c13.getText().toString().equals(thirteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer13 = d13.getText().toString();
                        if (d13.getText().toString().equals(thirteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //14
                final Question fourteen = dataSnapshot.child("PrelimMultipleChoice").child(number.get(13)).getValue(Question.class);
                ArrayList<String> q14choice = new ArrayList<String>();
                q14choice.add(0, fourteen.getOption1());
                q14choice.add(0, fourteen.getOption2());
                q14choice.add(0, fourteen.getOption3());
                q14choice.add(0, fourteen.getOption4());
                Collections.shuffle(q9choice);
                question14.setText(fourteen.getQuestion());
                a14.setText(q14choice.get(0));
                b14.setText(q14choice.get(1));
                c14.setText(q14choice.get(2));
                d14.setText(q14choice.get(3));
                a14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer14 = a14.getText().toString();
                        if (a14.getText().toString().equals(fourteen.getAnswer())) {
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
                        if (b14.getText().toString().equals(fourteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer14 = c14.getText().toString();
                        if (c14.getText().toString().equals(fourteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer14 = d14.getText().toString();
                        if (d14.getText().toString().equals(fourteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //15
                final Question fifteen = dataSnapshot.child("PrelimMultipleChoice").child(number.get(14)).getValue(Question.class);
                ArrayList<String> q15choice = new ArrayList<String>();
                q15choice.add(0, fifteen.getOption1());
                q15choice.add(0, fifteen.getOption2());
                q15choice.add(0, fifteen.getOption3());
                q15choice.add(0, fifteen.getOption4());
                Collections.shuffle(q9choice);
                question15.setText(fifteen.getQuestion());
                a15.setText(q15choice.get(0));
                b15.setText(q15choice.get(1));
                c15.setText(q15choice.get(2));
                d15.setText(q15choice.get(3));
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
                        answer15 = b15.getText().toString();
                        if (b15.getText().toString().equals(fifteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer15 = c15.getText().toString();
                        if (c15.getText().toString().equals(fifteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer15 = d15.getText().toString();
                        if (d15.getText().toString().equals(fifteen.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });



                final Question sixteen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(0)).getValue(Question.class);
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


                final Question seventeen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(1)).getValue(Question.class);
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



                final Question eighteen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(2)).getValue(Question.class);
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



                final Question nineteen = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(3)).getValue(Question.class);
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


                final Question twenty = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(4)).getValue(Question.class);
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




                final Question twentyone = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(5)).getValue(Question.class);
                question21.setText(twentyone.getQuestion());
                a21.setText(twenty.getOption1());
                b21.setText(twenty.getOption2());

                a21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer21 = a21.getText().toString();
                        if (a21.getText().toString().equals(twentyone.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer21 = b21.getText().toString();
                        if (b21.getText().toString().equals(twentyone.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //22
                final Question twentytwo = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(6)).getValue(Question.class);
                question22.setText(twentytwo.getQuestion());
                a22.setText(twentytwo.getOption1());
                b22.setText(twentytwo.getOption2());

                a22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer22 = a22.getText().toString();
                        if (a22.getText().toString().equals(twentytwo.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer22 = b22.getText().toString();
                        if (b22.getText().toString().equals(twentytwo.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //23
                final Question twentythree = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(7)).getValue(Question.class);
                question23.setText(twentythree.getQuestion());
                a23.setText(twentythree.getOption1());
                b23.setText(twentythree.getOption2());

                a23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer23 = a23.getText().toString();
                        if (a23.getText().toString().equals(twentythree.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer23 = b23.getText().toString();
                        if (b23.getText().toString().equals(twentythree.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //24
                final Question twentyfour = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(8)).getValue(Question.class);
                question24.setText(twentyfour.getQuestion());
                a24.setText(twentyfour.getOption1());
                b24.setText(twentyfour.getOption2());

                a24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer24 = a24.getText().toString();
                        if (a24.getText().toString().equals(twentyfour.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer24 = b24.getText().toString();
                        if (b24.getText().toString().equals(twentyfour.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //25
                final Question twentyfive = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(9)).getValue(Question.class);
                question25.setText(twentyfive.getQuestion());
                a25.setText(twentyfive.getOption1());
                b25.setText(twentyfive.getOption2());

                a25.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer25 = a25.getText().toString();
                        if (a25.getText().toString().equals(twentyfive.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b25.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer25 = b25.getText().toString();
                        if (b25.getText().toString().equals(twentyfive.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //26
                final Question twentysix = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(10)).getValue(Question.class);
                question26.setText(twentysix.getQuestion());
                a26.setText(twentysix.getOption1());
                b26.setText(twentysix.getOption2());

                a26.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer26 = a26.getText().toString();
                        if (a26.getText().toString().equals(twentysix.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b26.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer26 = b26.getText().toString();
                        if (b26.getText().toString().equals(twentysix.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //27
                final Question twentyseven = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(6)).getValue(Question.class);
                question27.setText(twentyseven.getQuestion());
                a27.setText(twentyseven.getOption1());
                b27.setText(twentyseven.getOption2());

                a27.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer27 = a27.getText().toString();
                        if (a27.getText().toString().equals(twentyseven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b27.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer27 = b27.getText().toString();
                        if (b27.getText().toString().equals(twentyseven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //28
                final Question twentyeight = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(7)).getValue(Question.class);
                question28.setText(twentyeight.getQuestion());
                a28.setText(twentyeight.getOption1());
                b28.setText(twentyeight.getOption2());

                a28.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer28 = a28.getText().toString();
                        if (a28.getText().toString().equals(twentyeight.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b28.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer28 = b28.getText().toString();
                        if (b28.getText().toString().equals(twentyeight.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //29
                final Question twentynine = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(8)).getValue(Question.class);
                question29.setText(twentynine.getQuestion());
                a29.setText(twentynine.getOption1());
                b29.setText(twentynine.getOption2());

                a29.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer29 = a29.getText().toString();
                        if (a29.getText().toString().equals(twentynine.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b29.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer29 = b29.getText().toString();
                        if (b29.getText().toString().equals(twentynine.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //30
                final Question thirty = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(9)).getValue(Question.class);
                question30.setText(thirty.getQuestion());
                a30.setText(thirty.getOption1());
                b30.setText(thirty.getOption2());

                a30.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer30 = a30.getText().toString();
                        if (a30.getText().toString().equals(thirty.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b30.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer30 = b30.getText().toString();
                        if (b30.getText().toString().equals(thirty.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

// identification

                final Question thirtyone = dataSnapshot.child("PrelimIdentification").child(ident.get(0)).getValue(Question.class);
                question31.setText(thirtyone.getQuestion());

                final Question thirtytwo = dataSnapshot.child("PrelimIdentification").child(ident.get(1)).getValue(Question.class);
                question32.setText(thirtytwo.getQuestion());

                final Question thirtythree = dataSnapshot.child("PrelimIdentification").child(ident.get(2)).getValue(Question.class);
                question33.setText(thirtythree.getQuestion());

                final Question thirtyfour = dataSnapshot.child("PrelimIdentification").child(ident.get(3)).getValue(Question.class);
                question34.setText(thirtyfour.getQuestion());

                final Question thirtyfive = dataSnapshot.child("PrelimIdentification").child(ident.get(4)).getValue(Question.class);
                question35.setText(thirtyfive.getQuestion());

                final Question thirtysix = dataSnapshot.child("PrelimIdentification").child(ident.get(5)).getValue(Question.class);
                question36.setText(thirtysix.getQuestion());

                final Question thirtyseven = dataSnapshot.child("PrelimIdentification").child(ident.get(6)).getValue(Question.class);
                question37.setText(thirtyseven.getQuestion());

                final Question thirtyeight = dataSnapshot.child("PrelimIdentification").child(ident.get(7)).getValue(Question.class);
                question38.setText(thirtyeight.getQuestion());

                final Question thirtynine = dataSnapshot.child("PrelimIdentification").child(ident.get(8)).getValue(Question.class);
                question39.setText(thirtynine.getQuestion());

                final Question fourty = dataSnapshot.child("PrelimIdentification").child(ident.get(9)).getValue(Question.class);
                question40.setText(fourty.getQuestion());


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        answer31 = ans31.getText().toString();
                        if (answer31.equals(thirtyone.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer32 = ans32.getText().toString();
                        if (answer32.equals(thirtytwo.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer33= ans33.getText().toString();
                        if (ans33.getText().toString().equals(thirtythree.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer34= ans34.getText().toString();
                        if (ans34.getText().toString().equals(thirtyfour.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }


                        answer35= ans35.getText().toString();
                        if (ans35.getText().toString().equals(thirtyfive.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }


                        answer36= ans36.getText().toString();
                        if (ans36.getText().toString().equals(thirtysix.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer37= ans37.getText().toString();
                        if (ans37.getText().toString().equals(thirtyseven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer38= ans38.getText().toString();
                        if (ans38.getText().toString().equals(thirtyeight.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer39= ans39.getText().toString();
                        if (ans39.getText().toString().equals(thirtynine.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer40 = ans40.getText().toString();
                        if (ans40.getText().toString().equals(fourty.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }



                        //storing history stuff
                        String pq4_h1_pref = sharedPreferences.getString("pq4_h1_date", null);
                        if(pq4_h1_pref == null) {
                            myEdit.putString("pq4_h1_date",currdate);
                            myEdit.putInt("pq4_h1_score", correct);
                            myEdit.commit();

                            myEdit.putString("test","test");
                            Log.i("SP_", "pq4_h1 processed");

                        } else {
                            String pq4_h2_pref = sharedPreferences.getString("pq4_h2_date", null);
                            if (pq4_h2_pref == null) {
                                myEdit.putString("pq4_h2_date", currdate);
                                myEdit.putInt("pq4_h2_score", correct);
                                myEdit.commit();
                                Log.i("SP_", "pq4_h2 processed");
                            } else {
                                String pq4_h3_pref = sharedPreferences.getString("pq4_h3_date", null);
                                if (pq4_h3_pref == null) {
                                    myEdit.putString("pq4_h3_date", currdate);
                                    myEdit.putInt("pq4_h3_score", correct);
                                    myEdit.commit();
                                    Log.i("SP_", "pq4_h3 processed");
                                } else {

                                    String pq4_h4_pref = sharedPreferences.getString("pq4_h4_date", null);
                                    if (pq4_h4_pref == null) {
                                        myEdit.putString("pq4_h4_date", currdate);
                                        myEdit.putInt("pq4_h4_score", correct);
                                        myEdit.commit();
                                        Log.i("SP_", "pq4_h4 processed");
                                    } else {
                                        String pq4_h5_pref = sharedPreferences.getString("pq4_h5_date", null);
                                        if (pq4_h5_pref == null) {
                                            myEdit.putString("pq4_h5_date", currdate);
                                            myEdit.putInt("pq4_h5_score", correct);
                                            myEdit.commit();
                                            Log.i("SP_", "pq4_h5 processed");
                                        } else{
                                            String pq4_h6_pref = sharedPreferences.getString("pq4_h6_date", null);
                                            if (pq4_h6_pref == null) {
                                                myEdit.putString("pq4_h6_date", currdate);
                                                myEdit.putInt("pq4_h6_score", correct);
                                                myEdit.commit();
                                                Log.i("SP_", "pq4_h6 processed");
                                            }else{
                                                String pq4_h7_pref = sharedPreferences.getString("pq4_h7_date", null);
                                                if (pq4_h7_pref == null) {
                                                    myEdit.putString("pq4_h7_date", currdate);
                                                    myEdit.putInt("pq4_h7_score", correct);
                                                    myEdit.commit();
                                                    Log.i("SP_", "pq4_h7 processed");
                                                }else{
                                                    String pq4_h8_pref = sharedPreferences.getString("pq4_h8_date", null);
                                                    if (pq4_h8_pref == null) {
                                                        myEdit.putString("pq4_h8_date", currdate);
                                                        myEdit.putInt("pq4_h8_score", correct);
                                                        myEdit.commit();
                                                        Log.i("SP_", "pq4_h8 processed");
                                                    }else{
                                                        String pq4_h9_pref = sharedPreferences.getString("pq4_h9_date", null);
                                                        if (pq4_h9_pref == null) {
                                                            myEdit.putString("pq4_h9_date", currdate);
                                                            myEdit.putInt("pq4_h9_score", correct);
                                                            myEdit.commit();
                                                            Log.i("SP_", "pq4_h9 processed");
                                                        }else{
                                                            String pq4_h10_pref = sharedPreferences.getString("pq4_h10_date", null);
                                                            if (pq4_h10_pref == null) {
                                                                myEdit.putString("pq4_h10_date", currdate);
                                                                myEdit.putInt("pq4_h10_score", correct);
                                                                myEdit.commit();
                                                                Log.i("SP_", "pq4_h10 processed");
                                                            }else{
                                                                Log.i("SP_","history is full");

                                                                //adjusts entries 2 to 1, 3 to 2 and so on
                                                                myEdit.putString("pq4_h1_date",  sharedPreferences.getString("pq4_h2_date", ""));
                                                                myEdit.putInt("pq4_h1_score", sharedPreferences.getInt("pq4_h2_score", 0));

                                                                myEdit.putString("pq4_h2_date",  sharedPreferences.getString("pq4_h3_date", ""));
                                                                myEdit.putInt("pq4_h2_score", sharedPreferences.getInt("pq4_h3_score", 0));

                                                                myEdit.putString("pq4_h3_date",  sharedPreferences.getString("pq4_h4_date", ""));
                                                                myEdit.putInt("pq4_h3_score", sharedPreferences.getInt("pq4_h4_score", 0));

                                                                myEdit.putString("pq4_h4_date",  sharedPreferences.getString("pq4_h5_date", ""));
                                                                myEdit.putInt("pq4_h4_score", sharedPreferences.getInt("pq4_h5_score", 0));

                                                                myEdit.putString("pq4_h5_date",  sharedPreferences.getString("pq4_h6_date", ""));
                                                                myEdit.putInt("pq4_h5_score", sharedPreferences.getInt("pq4_h6_score", 0));

                                                                myEdit.putString("pq4_h6_date",  sharedPreferences.getString("pq4_h7_date", ""));
                                                                myEdit.putInt("pq4_h6_score", sharedPreferences.getInt("pq4_h7_score", 0));

                                                                myEdit.putString("pq4_h7_date",  sharedPreferences.getString("pq4_h8_date", ""));
                                                                myEdit.putInt("pq4_h7_score", sharedPreferences.getInt("pq4_h8_score", 0));

                                                                myEdit.putString("pq4_h8_date",  sharedPreferences.getString("pq4_h9_date", ""));
                                                                myEdit.putInt("pq4_h8_score", sharedPreferences.getInt("pq4_h9_score", 0));

                                                                myEdit.putString("pq4_h9_date",  sharedPreferences.getString("pq4_h10_date", ""));
                                                                myEdit.putInt("pq4_h9_score", sharedPreferences.getInt("pq4_h10_score", 0));
                                                                //adjusts entries 2 to 1, 3 to 2 and so on
                                                                myEdit.putString("pq4_h10_date", currdate);
                                                                myEdit.putInt("pq4_h10_score", correct);
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
                        int q4_h1_s = sharedPreferences.getInt("pq4_h1_score", 0);
                        String q4_h1_d = sharedPreferences.getString("pq4_h1_date", "");
                        int q4_h2_s = sharedPreferences.getInt("pq4_h2_score", 0);
                        String q4_h2_d = sharedPreferences.getString("pq4_h2_date", "");
                        int q4_h3_s = sharedPreferences.getInt("pq4_h3_score", 0);
                        String q4_h3_d = sharedPreferences.getString("pq4_h3_date", "");
                        int q4_h4_s = sharedPreferences.getInt("pq4_h4_score", 0);
                        String q4_h4_d = sharedPreferences.getString("pq4_h4_date", "");
                        int q4_h5_s = sharedPreferences.getInt("pq4_h5_score", 0);
                        String q4_h5_d = sharedPreferences.getString("pq4_h5_date", "");
                        int q4_h6_s = sharedPreferences.getInt("pq4_h6_score", 0);
                        String q4_h6_d = sharedPreferences.getString("pq4_h6_date", "");
                        int q4_h7_s = sharedPreferences.getInt("pq4_h7_score", 0);
                        String q4_h7_d = sharedPreferences.getString("pq4_h7_date", "");
                        int q4_h8_s = sharedPreferences.getInt("pq4_h8_score", 0);
                        String q4_h8_d = sharedPreferences.getString("pq4_h8_date", "");
                        int q4_h9_s = sharedPreferences.getInt("pq4_h9_score", 0);
                        String q4_h9_d = sharedPreferences.getString("pq4_h9_date", "");
                        int q4_h10_s = sharedPreferences.getInt("pq4_h10_score", 0);
                        String q4_h10_d = sharedPreferences.getString("pq4_h10_date", "");
                        Log.i("SP_content", "" );
                        Log.i("SP_content", "h1: "+ q4_h1_d +" "+ q4_h1_s );
                        Log.i("SP_content", "h2: "+ q4_h2_d +" "+ q4_h2_s );
                        Log.i("SP_content", "h3: "+ q4_h3_d +" "+ q4_h3_s );
                        Log.i("SP_content", "h4: "+ q4_h4_d +" "+ q4_h4_s );
                        Log.i("SP_content", "h5: "+ q4_h5_d +" "+ q4_h5_s );
                        Log.i("SP_content", "h6: "+ q4_h6_d +" "+ q4_h6_s );
                        Log.i("SP_content", "h7: "+ q4_h7_d +" "+ q4_h7_s );
                        Log.i("SP_content", "h8: "+ q4_h8_d +" "+ q4_h8_s );
                        Log.i("SP_content", "h9: "+ q4_h9_d +" "+ q4_h9_s );
                        Log.i("SP_content", "h10: "+ q4_h10_d +" "+ q4_h10_s );

                        AlertDialog dialog = new AlertDialog.Builder(prelim_quiz4.this)

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

                                AlertDialog dialog1 = new AlertDialog.Builder(prelim_quiz4.this)
                                        .setTitle("Score")
                                        .setMessage("Your score was: \t" + correct)
                                        .setPositiveButton("OK", null)
                                        .show();
                                final Button positiveButton = dialog1.getButton(AlertDialog.BUTTON_POSITIVE);
                                positiveButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(prelim_quiz4.this, Lecture.class);
                                        startActivity(intent);
                                    }
                                });
//                        builder.setCancelable(false);
//                        builder.setTitle("Score");
//                        builder.setMessage("Your Score was: \t"+  correct);
//                        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
                                //                                Intent intent = new Intent(pquiz1.this,PWeek1.class);
                            }
                        });
//                        builder.show();
//                            }
//                        });

//                        AlertDialog.Builder builder = new AlertDialog.Builder(pquiz1.this);
//                        builder.setCancelable(false);
//                        builder.setTitle("Score");
//                        builder.setMessage("Your Score was: /t"+  correct);
//                        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                            }
//                        });
//                        builder.show();
////                        Intent i = new Intent(pquiz1.this,prelimresult1.class);
////                        finish();
//                        i.putExtra("correct",String.valueOf(correct));
//
//                        i.putExtra("q11", one.getQuestion());
//                        i.putExtra("youranswer1", answer1);
//                        i.putExtra("correctanswer1", one.getAnswer());
//
//                        i.putExtra("q22", two.getQuestion());
//                        i.putExtra("youranswer2", answer2);
//                        i.putExtra("correctanswer2", two.getAnswer());
//
//                        i.putExtra("q33", three.getQuestion());
//                        i.putExtra("youranswer3", answer3);
//                        i.putExtra("correctanswer3", three.getAnswer());
//
//                        i.putExtra("q44", four.getQuestion());
//                        i.putExtra("youranswer4", answer4);
//                        i.putExtra("correctanswer4", four.getAnswer());
//
//                        i.putExtra("q55", five.getQuestion());
//                        i.putExtra("youranswer5", answer5);
//                        i.putExtra("correctanswer5",five.getAnswer());
//
//                        i.putExtra("q66", six.getQuestion());
//                        i.putExtra("youranswer6", answer6);
//                        i.putExtra("correctanswer6", six.getAnswer());
//
//                        i.putExtra("q77", seven.getQuestion());
//                        i.putExtra("youranswer7", answer7);
//                        i.putExtra("correctanswer7", seven.getAnswer());
//
//                        i.putExtra("q88", eight.getQuestion());
//                        i.putExtra("youranswer8", answer8);
//                        i.putExtra("correctanswer8", eight.getAnswer());
//
//                        i.putExtra("q99", nine.getQuestion());
//                        i.putExtra("youranswer9", answer9);
//                        i.putExtra("correctanswer9", nine.getAnswer());
//
//                        i.putExtra("q100", ten.getQuestion());
//                        i.putExtra("youranswer10", answer10);
//                        i.putExtra("correctanswer10", ten.getAnswer());

//                        startActivity(i);
//                        finish();
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

                a6.setEnabled(false);
                b6.setEnabled(false);

                a7.setEnabled(false);
                b7.setEnabled(false);


            }
        }.start();


//
//
//        timer = findViewById(R.id.textView10);
//        //Button
//        submit = findViewById(R.id.submit);
//        //Radio Group
//        next1 = (Button) findViewById(R.id.next1);
//        next2 = (Button) findViewById(R.id.next2);
//        q1 = findViewById(R.id.q1);
//        q2 = findViewById(R.id.q2);
//        q3 = findViewById(R.id.q3);
//        q4 = findViewById(R.id.q4);
//        q5 = findViewById(R.id.q5);
//        q6 = findViewById(R.id.q6);
//        q7 = findViewById(R.id.q7);
////        q8 = findViewById(R.id.q8);
////        q9 = findViewById(R.id.q9);
////        q10 = findViewById(R.id.q10);
//        //RadioButton
//        a1 = findViewById(R.id.a1);
//        b1 = findViewById(R.id.b1);
//        c1 = findViewById(R.id.c1);
//        d1 = findViewById(R.id.d1);
//        a2 = findViewById(R.id.a2);
//        b2 = findViewById(R.id.b2);
//        c2 = findViewById(R.id.c2);
//        d2 = findViewById(R.id.d2);
//        a3 = findViewById(R.id.a3);
//        b3 = findViewById(R.id.b3);
//        c3 = findViewById(R.id.c3);
//        d3 = findViewById(R.id.d3);
//        a4 = findViewById(R.id.a4);
//        b4 = findViewById(R.id.b4);
//        c4 = findViewById(R.id.c4);
//        d4 = findViewById(R.id.d4);
//        a5 = findViewById(R.id.a5);
//        b5 = findViewById(R.id.b5);
//        a6 = findViewById(R.id.a6);
//        b6 = findViewById(R.id.b6);
//        a7 = findViewById(R.id.a7);
//        b7 = findViewById(R.id.b7);
//
//        //TextView
//        question1 = findViewById(R.id.question1);
//        question2 = findViewById(R.id.question2);
//        question3 = findViewById(R.id.question3);
//        question4 = findViewById(R.id.question4);
//        question5 = findViewById(R.id.question5);
//        question6 = findViewById(R.id.question6);
//        question7 = findViewById(R.id.question7);
//        question8 = findViewById(R.id.question8);
//        question9 = findViewById(R.id.question9);
//        question10 = findViewById(R.id.question10);
//
//        //EditText
//        ans8 = findViewById(R.id.ans8);
//        ans9 = findViewById(R.id.ans9);
//        ans10 = findViewById(R.id.ans10);
//
//        q2.setVisibility(View.GONE);
//        q3.setVisibility(View.GONE);
//        q4.setVisibility(View.GONE);
//        q5.setVisibility(View.GONE);
//        q6.setVisibility(View.GONE);
//        q7.setVisibility(View.GONE);
//        question8.setVisibility(View.GONE);
//        question9.setVisibility(View.GONE);
//        question10.setVisibility(View.GONE);
//        ans8.setVisibility(View.GONE);
//        ans9.setVisibility(View.GONE);
//        ans10.setVisibility(View.GONE);
//        next1.setVisibility(View.GONE);
//        next2.setVisibility(View.GONE);
//        submit.setVisibility(View.GONE);
//
//        reverseTimer(120, timer);
//
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("PrelimQuestion").child("lesson1");
//        databaseReference.keepSynced(true);
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                ArrayList<String> number = new ArrayList<String>();
//                number.add(0, "1");
//                number.add(0, "2");
//                number.add(0, "3");
//                number.add(0, "4");
//                number.add(0, "5");
//                number.add(0, "6");
//                number.add(0, "7");
//                number.add(0, "8");
//                Collections.shuffle(number);
//
//
//                ArrayList<String> tf = new ArrayList<String>();
//                tf.add(0, String.valueOf(1));
//                tf.add(0, String.valueOf(2));
//                tf.add(0, String.valueOf(3));
//                tf.add(0, String.valueOf(4));
//                tf.add(0, String.valueOf(5));
//                tf.add(0, String.valueOf(6));
//                Collections.shuffle(tf);
//
//                ArrayList<String> ident = new ArrayList<String>();
//                ident.add(0, String.valueOf(1));
//                ident.add(0, String.valueOf(2));
//                ident.add(0, String.valueOf(3));
//                ident.add(0, String.valueOf(4));
//                ident.add(0, String.valueOf(5));
//                ident.add(0, String.valueOf(6));
//                Collections.shuffle(ident);
//
//
//                final Question one = dataSnapshot.child("PrelimMultipleChoice").child(number.get(0)).getValue(Question.class);
//                //Question1
//                ArrayList<String> q1choice = new ArrayList<String>();
//                q1choice.add(0, one.getOption1());
//                q1choice.add(1, one.getOption2());
//                q1choice.add(2, one.getOption3());
//                q1choice.add(3, one.getOption4());
//                Collections.shuffle(q1choice);
//                question1.setText(one.getQuestion());
//                a1.setText(q1choice.get(0));
//                b1.setText(q1choice.get(1));
//                c1.setText(q1choice.get(2));
//                d1.setText(q1choice.get(3));
//                a1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer1 = a1.getText().toString();
//                        if (a1.getText().toString().equals(one.getAnswer())){
//                            correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q2.setVisibility(View.VISIBLE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer1 = b1.getText().toString();
//                        if (b1.getText().toString().equals(one.getAnswer())){
//                            correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q2.setVisibility(View.VISIBLE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                c1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer1 = c1.getText().toString();
//                        if (c1.getText().toString().equals(one.getAnswer())){
//                            correct++;} else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q2.setVisibility(View.VISIBLE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                d1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer1 = d1.getText().toString();
//                        if (d1.getText().toString().equals(one.getAnswer())){
//                            correct++;} else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q2.setVisibility(View.VISIBLE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                final Question two = dataSnapshot.child("PrelimMultipleChoice").child(number.get(1)).getValue(Question.class);
//                //Question2
//                ArrayList<String> q2choice = new ArrayList<String>();
//                q2choice.add(0, two.getOption1());
//                q2choice.add(0, two.getOption2());
//                q2choice.add(0, two.getOption3());
//                q2choice.add(0, two.getOption4());
//                Collections.shuffle(q2choice);
//                question2.setText(two.getQuestion());
//                a2.setText(q2choice.get(0));
//                b2.setText(q2choice.get(1));
//                c2.setText(q2choice.get(2));
//                d2.setText(q2choice.get(3));
//                a2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer2 = a2.getText().toString();
//                        if (a2.getText().toString().equals(two.getAnswer())){
//                            correct++;} else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q3.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer2 = b2.getText().toString();
//                        if (b2.getText().toString().equals(two.getAnswer())){
//                            correct++;} else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q3.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                c2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer2 = c2.getText().toString();
//                        if (c2.getText().toString().equals(two.getAnswer())){
//                            correct++;} else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q3.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                d2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer2 = d2.getText().toString();
//                        if (d2.getText().toString().equals(two.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q3.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//
//                //Question3
//                final Question three = dataSnapshot.child("PrelimMultipleChoice").child(number.get(2)).getValue(Question.class);
//                ArrayList<String> q3choice = new ArrayList<String>();
//                q3choice.add(0, three.getOption1());
//                q3choice.add(0, three.getOption2());
//                q3choice.add(0, three.getOption3());
//                q3choice.add(0, three.getOption4());
//                Collections.shuffle(q3choice);
//                question3.setText(three.getQuestion());
//                a3.setText(q3choice.get(0));
//                b3.setText(q3choice.get(1));
//                c3.setText(q3choice.get(2));
//                d3.setText(q3choice.get(3));
//
//                a3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer3 = a3.getText().toString();
//                        if (a3.getText().toString().equals(three.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q4.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer3 = b3.getText().toString();
//                        if (b3.getText().toString().equals(three.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q4.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                c3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer3 = c3.getText().toString();
//                        if (c3.getText().toString().equals(three.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q4.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                d3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer3 = d3.getText().toString();
//                        if (d3.getText().toString().equals(three.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q4.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                //Question4
//                final Question four = dataSnapshot.child("PrelimMultipleChoice").child(number.get(3)).getValue(Question.class);
//                ArrayList<String> q4choice = new ArrayList<String>();
//                q4choice.add(0, four.getOption1());
//                q4choice.add(0, four.getOption2());
//                q4choice.add(0, four.getOption3());
//                q4choice.add(0, four.getOption4());
//                Collections.shuffle(q4choice);
//                question4.setText(four.getQuestion());
//                a4.setText(q4choice.get(0));
//                b4.setText(q4choice.get(1));
//                c4.setText(q4choice.get(2));
//                d4.setText(q4choice.get(3));
//
//                a4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer4 = a4.getText().toString();
//                        if (a4.getText().toString().equals(four.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q5.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer4 = b4.getText().toString();
//                        if (b4.getText().toString().equals(four.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q5.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                c4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer4 = c4.getText().toString();
//                        if (c4.getText().toString().equals(four.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q5.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                d4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer4 = d4.getText().toString();
//                        if (d4.getText().toString().equals(four.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q5.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//
//                //Question5
//                final Question five = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(0)).getValue(Question.class);
//                question5.setText(five.getQuestion());
//                a5.setText(five.getOption1());
//                b5.setText(five.getOption2());
//
//                a5.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer5 = a5.getText().toString();
//                        if (a5.getText().toString().equals(five.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q6.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b5.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer5 = b5.getText().toString();
//                        if (b5.getText().toString().equals(five.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q6.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                //Question6
//                final Question six = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(1)).getValue(Question.class);
//                question6.setText(six.getQuestion());
//                a6.setText(six.getOption1());
//                b6.setText(six.getOption2());
//
//                a6.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer6 = a6.getText().toString();
//                        if (a6.getText().toString().equals(six.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q7.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b6.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer6 = b6.getText().toString();
//                        if (b6.getText().toString().equals(six.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q7.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//
//                //Question7
//                final Question seven = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(2)).getValue(Question.class);
//                question7.setText(seven.getQuestion());
//                a7.setText(seven.getOption1());
//                b7.setText(seven.getOption2());
//
//                a7.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer7 = a7.getText().toString();
//                        if (a7.getText().toString().equals(seven.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        question8.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.VISIBLE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.VISIBLE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b7.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer7 = b7.getText().toString();
//                        if (b7.getText().toString().equals(seven.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        question8.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.VISIBLE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.VISIBLE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                //Question8
//                final Question eight = dataSnapshot.child("PrelimIdentification").child(ident.get(0)).getValue(Question.class);
//                question8.setText(eight.getQuestion());
//
//
//                //Question9
//                final Question nine = dataSnapshot.child("PrelimIdentification").child(ident.get(1)).getValue(Question.class);
//                question9.setText(nine.getQuestion());
//
//                //Question10
//                final Question ten = dataSnapshot.child("PrelimIdentification").child(ident.get(2)).getValue(Question.class);
//                question10.setText(ten.getQuestion());
//
////
//                next1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        q1.setVisibility(View.GONE);
//                        question9.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans9.setVisibility(View.VISIBLE);
//                        ans8.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next2.setVisibility(View.VISIBLE);
//                        next1.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//                next2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        q1.setVisibility(View.GONE);
//                        question10.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.VISIBLE);
//                        ans9.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        submit.setVisibility(View.VISIBLE);
//                    }
//                });
//
//                submit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        answer8 = ans8.getText().toString();
//                        if (answer8.equals(eight.getAnswer())){
//                            correct++;
//
//
//                        }
//                        else{wrong++;
//
//                        }
//
//                        answer9 = ans9.getText().toString();
//                        if (answer9.equals(nine.getAnswer())){correct++;
//                        }
//                        else{wrong++;
//
//
//                        }
//
//                        answer10 = ans10.getText().toString();
//                        if (ans10.getText().toString().equals(ten.getAnswer())){correct++;
////
//                        }
//                        else{wrong++;
//
//                        }
//
//
//                        new AlertDialog.Builder(pquiz1.this)
//                                .setTitle("Done!")
//                                .setMessage("Congratulations for taking the quiz, your score is " + correct)
//                                .setCancelable(false)
//                                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int which) {
//
//
//
//                                        Intent intent = new Intent(pquiz1.this, prelimLecture.class);
//                                        startActivity(intent);
//                                        finish();
//                                    }
//                                })
//                                .show();
//                    }
//                });
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//    public void reverseTimer(int seconds, final TextView tv) {
//        new CountDownTimer(seconds * 1000 + 1000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//                int seconds = (int) (millisUntilFinished / 1000);
//                int minutes = seconds / 60;
//                seconds = seconds % 60;
//                tv.setText(String.format("%02d", minutes)
//                        + ":" + String.format("%02d", seconds));
//            }
//
//            public void onFinish() {
//                tv.setText("Times Up");
//                a1.setEnabled(false);
//                b1.setEnabled(false);
//                c1.setEnabled(false);
//                d1.setEnabled(false);
//                a2.setEnabled(false);
//                b2.setEnabled(false);
//                c2.setEnabled(false);
//                d2.setEnabled(false);
//                a3.setEnabled(false);
//                b3.setEnabled(false);
//                c3.setEnabled(false);
//                d3.setEnabled(false);
//                a4.setEnabled(false);
//                b4.setEnabled(false);
//                c4.setEnabled(false);
//                d4.setEnabled(false);
//
//                a5.setEnabled(false);
//                b5.setEnabled(false);
//
//                a6.setEnabled(false);
//                b6.setEnabled(false);
//
//                a7.setEnabled(false);
//                b7.setEnabled(false);
//
//                ans8.setEnabled(false);
//                ans9.setEnabled(false);
//                ans10.setEnabled(false);
//
//            }
//        }.start();
//    }


    }
    public void onBackPressed () {
    }
}

//                        Intent i = new Intent(sample.this,result.class);
//                        finish();
//                        i.putExtra("correct",String.valueOf(correct));
//
//                        i.putExtra("q11", one.getQuestion());
//                        i.putExtra("youranswer1", answer1);
//                        i.putExtra("correctanswer1", one.getAnswer());
//
//                        i.putExtra("q22", two.getQuestion());
//                        i.putExtra("youranswer2", answer2);
//                        i.putExtra("correctanswer2", two.getAnswer());
//
//                        i.putExtra("q33", three.getQuestion());
//                        i.putExtra("youranswer3", answer3);
//                        i.putExtra("correctanswer3", three.getAnswer());
//
//                        i.putExtra("q44", four.getQuestion());
//                        i.putExtra("youranswer4", answer4);
//                        i.putExtra("correctanswer4", four.getAnswer());
//
//                        i.putExtra("q55", five.getQuestion());
//                        i.putExtra("youranswer5", answer5);
//                        i.putExtra("correctanswer5",five.getAnswer());
//
//                        i.putExtra("q66", six.getQuestion());
//                        i.putExtra("youranswer6", answer6);
//                        i.putExtra("correctanswer6", six.getAnswer());
//
//                        i.putExtra("q77", seven.getQuestion());
//                        i.putExtra("youranswer7", answer7);
//                        i.putExtra("correctanswer7", seven.getAnswer());
//
//                        i.putExtra("q88", eight.getQuestion());
//                        i.putExtra("youranswer8", answer8);
//                        i.putExtra("correctanswer8", eight.getAnswer());
//
//                        i.putExtra("q99", nine.getQuestion());
//                        i.putExtra("youranswer9", answer9);
//                        i.putExtra("correctanswer9", nine.getAnswer());
//
//                        i.putExtra("q100", ten.getQuestion());
//                        i.putExtra("youranswer10", answer10);
//                        i.putExtra("correctanswer10", ten.getAnswer());
//
//                        startActivity(i);
//                        finish();

//                                        EditText sample = findViewById(R.id.sample);
////                                        sample.setEnabled(false);
////                                        sasmple = correct;
////                                        sample.getText().toString();
//                                        SharedPreferences sharedPreferences = pquiz1.this.getPreferences(Context.MODE_PRIVATE);
//                                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                                        editor.putLong("timedate", datetime);
//                                        editor.putInt("score",correct);
//                                        editor.commit();
//
//
//                                        int mm = correct;


//quiz