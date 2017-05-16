package com.example.kiran.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    String clickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStartActivity = (Button) findViewById(R.id.button_start_activity);
        btnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK){
                clickButton =data.getStringExtra("BUTTON");
                Toast.makeText(this, clickButton, Toast.LENGTH_SHORT).show();
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Bundle bundle = new Bundle();
                        bundle.putString("CLICK", clickButton);
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        CustomeDialogFragment customeDialogFragment = new CustomeDialogFragment();
                        customeDialogFragment.setArguments(bundle);
                        customeDialogFragment.show(fragmentManager, "MYDIALOG");
                    }
                });
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no clickButton
            }
        }
    }
}
