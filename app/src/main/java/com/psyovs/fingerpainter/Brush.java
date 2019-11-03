package com.psyovs.fingerpainter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Brush extends AppCompatActivity {

    Spinner shapeSpinner, sizeSpinner;
    String shapes[] = new String[] {"", "ROUND", "SQUARE", "BUTT"};
    String sizes[] = new String[] {"","1", "2","3","4","5","6","7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
            "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
            "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76",
            "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"};
    TextView currentBrushSize;
    TextView currentBrushShape;
    String currentShape, currentSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush);

        currentBrushShape = (TextView) findViewById(R.id.currentShape);
        currentBrushSize = (TextView) findViewById(R.id.currentSize);

        shapeSpinner = (Spinner) findViewById(R.id.shapeSpinner);
        sizeSpinner = (Spinner) findViewById(R.id.sizeSpinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, shapes);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sizes);
        shapeSpinner.setAdapter(adapter1);
        sizeSpinner.setAdapter(adapter2);

        shapeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0: // nothing NEW is selected, therefore it keeps the same values as before.
                        currentBrushShape.setText(currentShape);
                        break;
                    case 1:
                        currentShape = "ROUND";
                        currentBrushShape.setText(currentShape);
                        break;
                    case 2:
                        currentShape = "SQUARE";
                        currentBrushShape.setText(currentShape);
                        break;
                    case 3:
                        currentShape = "BUTT";
                        currentBrushShape.setText(currentShape);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    currentBrushSize.setText(currentSize);
                } else {
                    currentBrushSize.setText(parent.getItemAtPosition(position).toString());
                    currentSize = parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Bundle brush = getIntent().getExtras();
        currentSize = brush.getString("currentBrushSize");
        currentShape = brush.getString("currentBrushShape");
        currentBrushShape.setText(currentShape);
        currentBrushSize.setText(currentSize);

    }

    public void onSaveClick (View save) {

        Bundle saved = new Bundle();
        saved.putString("currentSize", currentSize);
        saved.putString("currentShape", currentShape);

        Intent intent = new Intent();
        intent.putExtras(saved);
        setResult(RESULT_OK, intent);

        finish();

    }

}
