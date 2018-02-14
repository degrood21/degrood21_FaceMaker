package com.example.dylandegrood.degrood21_facemaker;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dylandegrood on 2/11/18.
 */

public class faceMakerListener implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, Spinner.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener{

    TextView updateTV; //initiated to ultimately change given TextView
    RadioGroup radioGroup;
    Button button;
    Spinner spinner;
    faceMaker myFace = null;
    RadioButton radioButton;
    int radioButtoninUse;

    private ArrayList<SeekBar> allSBs = new ArrayList<SeekBar>();
    private ArrayList<TextView> allTVs = new ArrayList<TextView>();

    int red;
    int green;
    int blue;

    //int redSkin;
    //int greenSkin;
    //int blueSkin;

    //int redEye;
    //int greenEye;
    //int blueEye;

    //int redHair;
    //int greenHair;
    //int blueHair;

    public faceMakerListener(TextView initTV, SeekBar sb, faceMaker initFace, RadioGroup rg, Button b, Spinner s) {

        allTVs.add(initTV);
        allSBs.add(sb);
        myFace = initFace;
        radioGroup = rg;
        button = b;
        spinner = s;
    }

    public void addsb(TextView TV, SeekBar sb){

        allTVs.add(TV);
        allSBs.add(sb);

    }

   // public faceMakerListener(faceMaker fM){

   //     face = fM;

    //}


    @Override
    public void onClick(View v) {

            myFace.randomizer();
            myFace.invalidate();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        for(int i = 0; i < allSBs.size(); i++) {

            if (seekBar == allSBs.get(i)) {

                allTVs.get(i).setText("" + progress);

            }
        }

        red = allSBs.get(0).getProgress();
        green = allSBs.get(1).getProgress();
        blue = allSBs.get(2).getProgress();

        if(radioButtoninUse == 0 ){

            //redSkin = allSBs.get(0).getProgress();
            //greenSkin = allSBs.get(1).getProgress();
            //blueSkin = allSBs.get(2).getProgress();

            myFace.setSkinColor(red, green, blue);

        }
        else if( radioButtoninUse == 1){

            //redEye = allSBs.get(0).getProgress();
            //greenEye = allSBs.get(1).getProgress();
            //blueEye = allSBs.get(2).getProgress();

            myFace.setEyeColor(red, green, blue);

        }
        else{

            //redHair = allSBs.get(0).getProgress();
            //greenHair = allSBs.get(1).getProgress();
            //blueHair = allSBs.get(2).getProgress();

            myFace.setHairColor(red, green, blue);

        }

        myFace.invalidate();

        // updateTV.setText(String.valueOf(progress));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (parent.getId() == spinner.getId()) {
            if (position == 0) {

                myFace.setHairStyle(position);
                myFace.invalidate();

            } else if (position == 1) {

                myFace.setHairStyle(position);
                myFace.invalidate();

            } else {

                myFace.setHairStyle(position);
                myFace.invalidate();

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        radioButton = (RadioButton) group.findViewById(checkedId);

        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.skinRadio:
                if (R.id.skinRadio == checkedId){

                    radioButtoninUse = 0;
                    //allSBs.get(0).setProgress(redSkin);
                    //allSBs.get(1).setProgress(greenSkin);
                    //allSBs.get(2).setProgress(blueSkin);

                }
                break;
            case R.id.eyeRadio:
                if(R.id.eyeRadio == checkedId){

                    radioButtoninUse = 1;
                    //allSBs.get(0).setProgress(redEye);
                    //allSBs.get(1).setProgress(greenEye);
                    //allSBs.get(2).setProgress(blueEye);

                }
                break;
            case R.id.hairRadio:
                if(R.id.hairRadio == checkedId){

                    radioButtoninUse = 2;
                    //allSBs.get(0).setProgress(redHair);
                    //allSBs.get(1).setProgress(greenHair);
                    //allSBs.get(2).setProgress(blueHair);

                }
                break;
        }

    }
}
/**
 External Citation
 Date:     13 February 2018
 Problem:  Did not know how to use RadioButtons
 Resource:
 https://developer.android.com/guide/topics/ui/controls/radiobutton.html
 Solution: Followed the link above for an example
 */

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