package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final Random RANDOM = new Random();
    private static final int[] VIEWS_IDS = {R.id.text_1, R.id.text_2, R.id.text_3, R.id.text_4, R.id.text_5};
    private int viewIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.view).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.text_1).setOnClickListener(this);


    }

    @Override
    public void onClick(final View v) {
        final int clickedViewId = v.getId();
        switch (clickedViewId) {
            case R.id.view: {
                resetColor();
                break;
            }
            case R.id.button: {
                rondomlychangeNextViewColor();
                break;
            }
            case R.id.text_1:{
                startActivity(new Intent(this,SecondActivity.class));
                break;
            }
        }
    }

    private void rondomlychangeNextViewColor() {
        findViewById(VIEWS_IDS[getNextTextviewId()]).setBackgroundColor(RANDOM.nextInt());
    }


    private void resetColor() {
        for (final int viewsId : VIEWS_IDS) {
            findViewById(viewsId).setBackgroundColor(Color.WHITE);
        }
    }

    private int getNextTextviewId() {
        if (viewIndex < VIEWS_IDS.length) {
            return viewIndex++;
        }
        viewIndex = 0;
        return viewIndex;
    }

}