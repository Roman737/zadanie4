package com.example.ugadai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    TextView tvinfo;
    EditText teinput;
    Button bcontrol;
    int guess;
    boolean gameFinished;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Связываем наши переменные
        tvinfo = (TextView) findViewById(R.id.textView22);
        EditText etInput = (EditText) findViewById(R.id.edittext);
        bcontrol = (Button) findViewById(R.id.button2);

        guess = (int) (Math.random() * 100);
        gameFinished = false;

    }

    public void onClick(View v){

        if (!gameFinished) {
            int inp = Integer.parseInt(teinput.getText().toString());
            if (inp > guess)
               tvinfo.setText(getResources().getString(R.string.ahead));
            if (inp < guess)
                tvinfo.setText("Недолет!");
            if (inp == guess);
            {
                tvinfo.setText("В точку");
                bcontrol.setText(getResources().getString(R.string.play_more));
                gameFinished=true;
            }
        }
        else
        {
            guess = (int) Math.random() * 100;
            bcontrol.setText("Ввести значение");
            tvinfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
    }
}