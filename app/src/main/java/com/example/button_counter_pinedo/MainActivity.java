package com.example.button_counter_pinedo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private Button incButton;
    private Button decButton;
    private Button zeroButton;
    private TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"I entered into onCreate()");

        display = findViewById(R.id.displayId);

        incButton = findViewById(R.id.incButtonId);
        incButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "*****************I pressed the increment button*****************");

                incrementCounter();
            }
        });

        decButton = findViewById(R.id.decButtonId);
        decButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.i(TAG, "*****************I pressed the decrement button*****************");

                decrementCounter();
            }
        });

        zeroButton = findViewById(R.id.zeroButtonId);
        zeroButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.i(TAG, "********************I pressed the zero button********************");

                resetToZero();
            }
        });
    }

    private void incrementCounter(){
        int currentValue = Integer.valueOf(display.getText().toString());
        currentValue++;
        display.setText(String.valueOf(currentValue));
    }

    private void decrementCounter(){
        int currentValue = Integer.valueOf(display.getText().toString());
        currentValue--;
        display.setText(String.valueOf(currentValue));
    }

    private void resetToZero(){
        int currentValue = Integer.valueOf(display.getText().toString());
        currentValue = 0;
        display.setText(String.valueOf(currentValue));
    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);

        String counterValue = display.getText().toString();
        outState.putString("Display", counterValue);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String counterValue = savedInstanceState.getString("display");
        display.setText(counterValue);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "I entered into onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "I entered into onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "I entered into onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "I entered into onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "I entered into onDestroy()");
    }
}