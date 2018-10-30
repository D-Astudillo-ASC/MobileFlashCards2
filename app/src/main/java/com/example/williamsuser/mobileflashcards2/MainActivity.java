package com.example.williamsuser.mobileflashcards2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });

        findViewById(R.id.card_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.correct_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.card_question).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.correct_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.correct_answer).setVisibility(View.INVISIBLE);
                findViewById(R.id.card_question).setVisibility(View.VISIBLE);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String updated_question = data.getExtras().getString("question");
            String updated_answer = data.getExtras().getString("answer");
            ((TextView) findViewById(R.id.card_question)).setText(updated_question);
            ((TextView) findViewById(R.id.correct_answer)).setText(updated_answer);
        }
    }
}
