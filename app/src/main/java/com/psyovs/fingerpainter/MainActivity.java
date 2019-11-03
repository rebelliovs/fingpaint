package com.psyovs.fingerpainter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    FingerPainterView canvas;

    static final int BRUSH_REQUEST = 0;
    static final int COLOR_REQUEST = 1;

    String currentBrushShape, currentBrushSize, currentColorText, currentSizeText;
    int currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvas = findViewById(R.id.canvas);
        canvas.load(getIntent().getData());
        // get current brush shape

        if(canvas.getBrush() == Paint.Cap.ROUND) {
            currentBrushShape = canvas.getBrush().name();
        } else if(canvas.getBrush() == Paint.Cap.SQUARE) {
            currentBrushShape = canvas.getBrush().name();
        } else if(canvas.getBrush() == Paint.Cap.BUTT) {
            currentBrushShape = canvas.getBrush().name();
        }

        // get current brush size

        currentBrushSize = Integer.toString(canvas.getBrushWidth());
        currentSizeText = currentBrushSize;

        // get current color

        currentColor = canvas.getColour();
        if(currentColor == 0xFF000000) {
            currentColorText = "Black";
        }

    }

    public void onClickBrush (View brush) {

        Bundle bundleBrush = new Bundle();
        bundleBrush.putString("currentBrushShape", currentBrushShape);
        bundleBrush.putString("currentBrushSize", currentBrushSize);

        Intent intent = new Intent(MainActivity.this,
                Brush.class);
        intent.putExtras(bundleBrush);
        startActivityForResult(intent, BRUSH_REQUEST);
    }

    public void onClickColor (View color) {

        Bundle bundleColor = new Bundle();
        bundleColor.putInt("currentColor", currentColor);
        bundleColor.putString("colorText", currentColorText);

        Intent intent = new Intent(MainActivity.this,
                Color.class);
        intent.putExtras(bundleColor);
        startActivityForResult(intent, COLOR_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data)
    {

        if (requestCode == BRUSH_REQUEST)
        {
            if (resultCode == RESULT_OK)
            {
                Bundle bundle = data.getExtras();
                currentBrushShape = bundle.getString("currentShape");
                currentBrushSize = bundle.getString("currentSize");
                canvas.setBrush(Paint.Cap.valueOf(currentBrushShape));
                canvas.setBrushWidth(Integer.valueOf(currentBrushSize));

            }
        }

        if (requestCode == COLOR_REQUEST)
        {
            if (resultCode == RESULT_OK)
            {
                Bundle bundle = data.getExtras();
                currentColor = bundle.getInt("currentColor");
                canvas.setColour(bundle.getInt("currentColor"));
                currentColorText = bundle.getString("colorText");

            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentBrushShape", currentBrushShape);
        outState.putString("currentBrushSize", currentBrushSize);
        outState.putInt("currentColor", currentColor);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentBrushShape = savedInstanceState.getString("currentBrushShape");
        currentBrushSize = savedInstanceState.getString("currentBrushSize");
        currentColor = savedInstanceState.getInt("currentColor");
        canvas.setBrush(Paint.Cap.valueOf(currentBrushShape));
        canvas.setBrushWidth(Integer.valueOf(currentBrushSize));
        canvas.setColour(currentColor);
    }

}
