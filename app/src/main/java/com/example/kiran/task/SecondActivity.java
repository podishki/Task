package com.example.kiran.task;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private final String BUTTON = "BUTTON";
    private final String BUTTON_OK = "Clicked OK";
    private final String BUTTON_CANCEL = "Clicked Cancel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnOk = (Button) findViewById(R.id.button_ok);
        Button btnCancel = (Button) findViewById(R.id.button_cancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentCall(BUTTON_OK);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentCall(BUTTON_CANCEL);
            }
        });
    }
    void intentCall(String buttonClick) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(BUTTON, buttonClick);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}

