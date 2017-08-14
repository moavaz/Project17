package com.example.moavaz.project17;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentViewActivity extends AppCompatActivity {

    private Activity activity;
    private TextView textView, textView2, textView3, textView4, textView5, textView6;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);

        textView = (TextView) findViewById(R.id.id);
        textView2 = (TextView) findViewById(R.id.fname);
        textView3 = (TextView) findViewById(R.id.lname);
        textView4 = (TextView) findViewById(R.id.mail);
        textView5 = (TextView) findViewById(R.id.ph);
        textView6 = (TextView) findViewById(R.id.stuid);
        imageView = (ImageView) findViewById(R.id.img);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("id"));
        textView2.setText(intent.getStringExtra("fname"));
        textView3.setText(intent.getStringExtra("lname"));
        textView4.setText(intent.getStringExtra("mail"));
        textView5.setText(intent.getStringExtra("ph"));
        textView6.setText(intent.getStringExtra("stuid"));
        imageView.setImageResource(R.drawable.newpng);
    }
}
