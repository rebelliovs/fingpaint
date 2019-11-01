package com.psyovs.fingerpainter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonBrush;
    Button buttonColor;

    FingerPainterView canvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvas = findViewById(R.id.canvas);
        canvas.load(getIntent().getData());

    }

    public void onClickBrush (View brush) {
        Intent intent = new Intent(MainActivity.this,
                Brush.class);
        startActivity(intent);
    }

    public void onClickColor (View color) {
        Intent intent = new Intent(MainActivity.this,
                Color.class);
        startActivity(intent);
    }

}
