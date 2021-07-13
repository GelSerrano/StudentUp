package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class midtermLinks2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midterm_links2);




        TextView text = (TextView) findViewById(R.id.link1);
        text.setMovementMethod(LinkMovementMethod.getInstance());
        TextView text2 = (TextView) findViewById(R.id.link2);
        text2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView text3 = (TextView) findViewById(R.id.link3);
        text3.setMovementMethod(LinkMovementMethod.getInstance());
        ImageView back = (ImageView)findViewById(R.id.backk);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

}
