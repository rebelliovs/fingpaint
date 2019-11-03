package com.psyovs.fingerpainter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Color extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner colorSpinner;
    TextView currentColorShape;
    TextView currentTextBox;
    String colorText;
    String colors[] = new String[] {"" ,"Black", "Blue", "Cyan", "Green", "Yellow", "Magenta", "Orange", "Purple", "Red", "White"}; // list of colors for dropdown list
    int currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        currentColorShape = (TextView) findViewById(R.id.currentColor);
        currentTextBox = (TextView) findViewById(R.id.currentColorText);

        // creating the dropdown list, adding items to the spinner

        colorSpinner = (Spinner) findViewById(R.id.colorSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, colors);
        colorSpinner.setAdapter(adapter);
        colorSpinner.setOnItemSelectedListener(this);

        Bundle color = getIntent().getExtras();
        currentColor = color.getInt("currentColor");
        colorText = color.getString("colorText");
        currentColorShape.setBackgroundColor(currentColor);
        currentTextBox.setText(colorText);
        currentTextBox.setTextColor(currentColor);

    }

    @Override
    public void onItemSelected(AdapterView<?> p, View v, int pos, long id) {

        switch(pos) {
            case 0: // nothing NEW is selected, therefore it keeps the same values as before.
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
            case 1:
                colorText = "Black";
                currentColor = 0xFF000000;
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
            case 2:
                colorText = "Blue";
                currentColor = 0xFF0000FF;
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
            case 3:
                colorText = "Cyan";
                currentColor = 0xFF00FFFF;
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
            case 4:
                colorText = "Green";
                currentColor = 0xFF008000;
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
            case 5:
                colorText = "Yellow";
                currentColor = 0xFFFFFF00;
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
            case 6:
                colorText = "Magenta";
                currentColor = 0xFFFF00FF;
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
            case 7:
                colorText = "Orange";
                currentColor = 0xFFFF7F00;
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
            case 8:
                colorText = "Purple";
                currentColor = 0xFF800080;
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
            case 9:
                colorText = "Red";
                currentColor = 0xFFFF0000;
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
            case 10:
                colorText = "White";
                currentColor = 0xFFFFFFFF;
                currentTextBox.setText(colorText);
                currentTextBox.setTextColor(currentColor);
                currentColorShape.setTextColor(currentColor);
                currentColorShape.setBackgroundColor(currentColor);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> p) {

    }

    public void onSaveClick (View save) {

        Bundle saved = new Bundle();
        saved.putInt("currentColor", currentColor);
        saved.putString("colorText", colorText);

        Intent intent = new Intent();
        intent.putExtras(saved);
        setResult(RESULT_OK, intent);

        finish();

    }
}
