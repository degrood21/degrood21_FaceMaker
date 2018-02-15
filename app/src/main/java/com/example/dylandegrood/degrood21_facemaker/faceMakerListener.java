package com.example.dylandegrood.degrood21_facemaker;

import android.graphics.Color;
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
 * @author Dylan DeGrood
 */

public class faceMakerListener implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, Spinner.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener{

    TextView updateTV; //initiated to ultimately change given TextView
    RadioGroup radioGroup;
    Button button;
    Spinner spinner;
    faceMaker myFace = null;
    int radioButtoninUse;

    private ArrayList<SeekBar> allSBs = new ArrayList<SeekBar>();
    private ArrayList<TextView> allTVs = new ArrayList<TextView>();

    int red;
    int green;
    int blue;

    //Ctor which takes in all variables and sets them
    //to the correct variable above
    public faceMakerListener(TextView initTV, SeekBar sb, faceMaker initFace, RadioGroup rg, Button b, Spinner s) {

        allTVs.add(initTV);
        allSBs.add(sb);
        myFace = initFace;
        radioGroup = rg;
        button = b;
        spinner = s;
    }

    //adds additional seekbars and textviews to ArrayLists
    public void addsb(TextView TV, SeekBar sb){

        allTVs.add(TV);
        allSBs.add(sb);

    }

    @Override
    public void onClick(View v) {

            myFace.randomizer(); //calls randomizer
            myFace.invalidate();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        //changes all textviews according to progress
        for(int i = 0; i < allSBs.size(); i++) {

            if (seekBar == allSBs.get(i)) {

                allTVs.get(i).setText("" + progress);

            }
        }

        red = allSBs.get(0).getProgress();
        green = allSBs.get(1).getProgress();
        blue = allSBs.get(2).getProgress();

        //depending on radioButton will
        //set color of face attribute selected
        if(radioButtoninUse == 0){

            myFace.setredSkinColor(red);
            myFace.setgreenSkinColor(green);
            myFace.setblueSkinColor(blue);

            myFace.setSkinColor(red, green, blue);

        }
        else if(radioButtoninUse == 1){

            myFace.setredEyeColor(red);
            myFace.setgreenEyeColor(green);
            myFace.setblueEyeColor(blue);

            myFace.setEyeColor(red, green, blue);

        }
        else if(radioButtoninUse == 2){

            myFace.setredHairColor(red);
            myFace.setgreenHairColor(green);
            myFace.setblueHairColor(blue);

            myFace.setHairColor(red, green, blue);

        }

        myFace.invalidate();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //depending on spinner selection will
        //redraw the corresponding hairstyle
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

        //when switching RadioButtons
        //the progress bars will adjust accordingly
        //(In theory) (could not get to work)
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.skinRadio:
                if (R.id.skinRadio == checkedId){

                    radioButtoninUse = 0;

                    //allSBs.get(0).setProgress(myFace.getredSkinColor());
                    //allSBs.get(1).setProgress(myFace.getgreenSkinColor());
                    //allSBs.get(2).setProgress(myFace.getblueSkinColor());

                }
                break;
            case R.id.eyeRadio:
                if(R.id.eyeRadio == checkedId){

                    radioButtoninUse = 1;

                    //allSBs.get(0).setProgress(myFace.getredEyeColor());
                    //allSBs.get(1).setProgress(myFace.getgreenEyeColor());
                    //allSBs.get(2).setProgress(myFace.getblueEyeColor());

                }
                break;
            case R.id.hairRadio:
                if(R.id.hairRadio == checkedId){

                    radioButtoninUse = 2;

                    //allSBs.get(0).setProgress(myFace.getredHairColor());
                    //allSBs.get(1).setProgress(myFace.getgreenHairColor());
                    //allSBs.get(2).setProgress(myFace.getblueHairColor());

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