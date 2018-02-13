package com.example.dylandegrood.degrood21_facemaker;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dylandegrood on 2/11/18.
 */

public class faceMakerListener implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, Spinner.OnItemSelectedListener {

    TextView updateTV; //initiated to ultimately change given TextView

    public faceMakerListener(TextView initTV) {

        updateTV = initTV;

    }


    @Override
    public void onClick(View v) {

        //should call randomizer from faceMaker


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        updateTV.setText(String.valueOf(progress));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

/**
 External Citation
 Date:     11 February 2018
 Problem:  Could not figure out how to change
 the value of textview from seekbar progress
 Resource:
 https://stackoverflow.com/questions/33349424/android-
 seekbar-changing-the-value
 Solution: One of the answers from link helped out
 */