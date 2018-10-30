package com.example.williamsuser.mobileflashcards2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this,MainActivity.class);
                intent.putExtra("question",((EditText) findViewById(R.id.questionField)).getText().toString());
                intent.putExtra("answer",((EditText) findViewById(R.id.answerField)).getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
