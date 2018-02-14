package com.example.dylandegrood.degrood21_facemaker;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    String[] hairStyles={"Afro","Boxed","Rounded"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        faceMaker face = (faceMaker) findViewById(R.id.surfaceView_faceMaker);
       //faceMakerListener faceListener = new faceMakerListener(face);

        //All are initializing the various sliders, buttons and textviews, etc
        TextView redValueTV = (TextView)findViewById(R.id.redValueTV);
        TextView greenValueTV = (TextView)findViewById(R.id.greenValueTV);
        TextView blueValueTV = (TextView)findViewById(R.id.blueValueTV);

        SeekBar redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        SeekBar greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        SeekBar blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);

        RadioButton hairRadio = (RadioButton)findViewById(R.id.hairRadio);
        RadioButton eyeRadio = (RadioButton)findViewById(R.id.eyeRadio);
        RadioButton skinRadio = (RadioButton)findViewById(R.id.skinRadio);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.groupRadio);

        Button randomButton = (Button) findViewById(R.id.randomButton);

        Spinner hairStyleSp = (Spinner) findViewById(R.id.hairStyleSpinner);

        //All the listeners for the initailized variables

        //faceMakerListener randomButtonListener = new faceMakerListener(randomButton);
        //faceMakerListener hairRadioListener = new faceMakerListener(hairRadio);
        //faceMakerListener eyeRadioListener = new faceMakerListener(eyeRadio);
        //faceMakerListener skinRadioListener = new faceMakerListener(skinRadio);

        faceMakerListener faceListener = new faceMakerListener(redValueTV, redSeekBar, face, radioGroup, randomButton, hairStyleSp);
        faceListener.addsb(greenValueTV, greenSeekBar);
        faceListener.addsb(blueValueTV, blueSeekBar);



        //connecting listeners to the listening class
        //hairRadio.setOnClickListener(faceListener);
        //eyeRadio.setOnClickListener(faceListener);
        //skinRadio.setOnClickListener(faceListener);

        randomButton.setOnClickListener(faceListener);

        redSeekBar.setMax(255);
        redSeekBar.setOnSeekBarChangeListener(faceListener);

        greenSeekBar.setMax(255);
        greenSeekBar.setOnSeekBarChangeListener(faceListener);

        blueSeekBar.setMax(255);
        blueSeekBar.setOnSeekBarChangeListener(faceListener);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, hairStyles);
        hairStyleSp.setAdapter(adapter);

        hairStyleSp.setOnItemSelectedListener(faceListener);

        radioGroup.setOnCheckedChangeListener(faceListener);


    }
}
