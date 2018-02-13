package com.example.dylandegrood.degrood21_facemaker;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    String[] hairStyles={"HairStyle 1","HairStyle 2","HairStyle 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView redValueTV = (TextView)findViewById(R.id.redValueTV);
        TextView greenValueTV = (TextView)findViewById(R.id.greenValueTV);
        TextView blueValueTV = (TextView)findViewById(R.id.blueValueTV);
        TextView randomButtonTV = (TextView)findViewById(R.id.randomButton);

        faceMakerListener redseekbarListener = new faceMakerListener(redValueTV);
        faceMakerListener greenseekbarListener = new faceMakerListener(greenValueTV);
        faceMakerListener blueseekbarListener = new faceMakerListener(blueValueTV);
        faceMakerListener randomButtonListener = new faceMakerListener(randomButtonTV);

        SeekBar redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        redSeekBar.setMax(255);
        redSeekBar.setOnSeekBarChangeListener(redseekbarListener);

        SeekBar greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        greenSeekBar.setMax(255);
        greenSeekBar.setOnSeekBarChangeListener(greenseekbarListener);

        SeekBar blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);
        blueSeekBar.setMax(255);
        blueSeekBar.setOnSeekBarChangeListener(blueseekbarListener);

        Spinner hairStyleSp = (Spinner) findViewById(R.id.hairStyleSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, hairStyles);
        hairStyleSp.setAdapter(adapter);

        Button randomButton = (Button) findViewById(R.id.randomButton);
        randomButton.setOnClickListener(randomButtonListener);


    }
}
