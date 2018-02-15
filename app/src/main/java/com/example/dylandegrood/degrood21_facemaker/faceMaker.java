package com.example.dylandegrood.degrood21_facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.Random;

/**
 * faceMaker completely draws the entire face onto the SurfaceView
 *
 * @author Dylan DeGrood
 */

public class faceMaker extends SurfaceView {

    //ints will be converted to paints so Android
    //can fill the shape with specific color
    Paint black = new Paint();
    Paint white = new Paint();
    Paint skinC = new Paint();
    Paint hairC = new Paint();
    Paint eyeC = new Paint();

    int skinColor; //Color value for the color of skin
    int hairColor; //Color value for the color of hair
    int eyeColor; //Color value for the color of eye
    int hairStyle = 0; //value 0,1, or 2 for hair style choice

    //All ints below help with the getters and setters
    int rskinColor;
    int gskinColor;
    int bskinColor;

    int reyeColor;
    int geyeColor;
    int beyeColor;

    int rhairColor;
    int ghairColor;
    int bhairColor;


    public faceMaker(Context context) {
        super(context);
        generalInit();
    }

    public faceMaker(Context context, AttributeSet attrs) {
        super(context, attrs);
        randomizer(); //calls randomizer method to randomize colors and styles
        generalInit();
    }

    public faceMaker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        generalInit();
    }


    private void generalInit() {
        setWillNotDraw(false);
    }

    //onDraw helper methods to draw Left and Right eyes
    public void drawLeftEye(Canvas canvas){

        canvas.drawCircle(canvas.getWidth() - canvas.getWidth()/2 - 65.0f, canvas.getHeight() - canvas.getHeight()/2 - 60.0f, 35.0f, white);
        canvas.drawCircle(canvas.getWidth() - canvas.getWidth()/2 - 65.0f, canvas.getHeight() - canvas.getHeight()/2 - 60.0f, 20.0f, eyeC);
        canvas.drawCircle(canvas.getWidth() - canvas.getWidth()/2 - 65.0f, canvas.getHeight() - canvas.getHeight()/2 - 60.0f, 10.0f, black);

    }

    //onDraw helper methods to draw Left and Right eyes
    public void drawRightEye(Canvas canvas){

        canvas.drawCircle(canvas.getWidth() - canvas.getWidth()/2 + 65.0f, canvas.getHeight() - canvas.getHeight()/2 - 60.0f, 35.0f, white);
        canvas.drawCircle(canvas.getWidth() - canvas.getWidth()/2 + 65.0f, canvas.getHeight() - canvas.getHeight()/2 - 60.0f, 20.0f, eyeC);
        canvas.drawCircle(canvas.getWidth() - canvas.getWidth()/2 + 65.0f, canvas.getHeight() - canvas.getHeight()/2 - 60.0f, 10.0f, black);

    }

    //depending on value of hairStyle will draw appropriate hair style
    public void drawHairStyle(Canvas canvas){

        if(hairStyle == 0){

            canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight() - canvas.getHeight()/2 - 70.0f, 150, hairC);
            canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, 150.0f, skinC);
            canvas.drawRect(canvas.getWidth()/2 + 115, canvas.getHeight()/2 - 110, canvas.getWidth()/2 - 115, canvas.getHeight()/2 - 150, hairC);

        }
        else if(hairStyle == 1){

            canvas.drawRect(canvas.getWidth()/2 + 115, canvas.getHeight()/2 - 100, canvas.getWidth()/2 - 115, canvas.getHeight()/2 - 200, hairC);
            canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, 150.0f, skinC);
            canvas.drawOval(canvas.getWidth()/2 + 115, canvas.getHeight()/2 - 110, canvas.getWidth()/2 - 115, canvas.getHeight()/2 - 200, hairC);

        }
        else{

            canvas.drawOval(canvas.getWidth()/2 + 115, canvas.getHeight()/2 - 80, canvas.getWidth()/2 - 115, canvas.getHeight()/2 - 195, hairC);
            canvas.drawOval(canvas.getWidth()/2 + 115, canvas.getHeight()/2 - 50, canvas.getWidth()/2 - 115, canvas.getHeight()/2 - 195, hairC);
            canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, 150.0f, skinC);
            canvas.drawOval(canvas.getWidth()/2 + 80, canvas.getHeight()/2 - 115, canvas.getWidth()/2 - 80, canvas.getHeight()/2 - 190, hairC);


        }

    }

    public void drawMouth(Canvas canvas) {

        canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight() - canvas.getHeight()/2 + 70.0f, 40, black);
        canvas.drawRect(canvas.getWidth()/2 + 40, canvas.getHeight()/2 + 64, canvas.getWidth()/2 - 40, canvas.getHeight()/2 + 30, black);

    }


    //Takes in 3 values for red green and blue
    //to turn it into a Color for hairColor
    public void setHairColor(int r, int g, int b){

        hairColor = Color.rgb(r, g, b);

    }

    //Takes in 3 values for red green and blue
    //to turn it into a Color for skinColor
    public void setSkinColor(int r, int g, int b){

        skinColor = Color.rgb(r, g, b);

    }

    //Takes in 3 values for red green and blue
    //to turn it into a Color for eyeColor
    public void setEyeColor(int r, int g, int b){

        eyeColor = Color.rgb(r, g, b);

    }

    public  void setHairStyle(int styleNum){

        hairStyle = styleNum;

    }

    //randomly sets colors for skin, hair, and eye
    //and also sets a random hair style
    public void randomizer(){

        Random num = new Random();

        skinColor = Color.rgb(num.nextInt(255), num.nextInt(255), num.nextInt(255));
        hairColor = Color.rgb(num.nextInt(255), num.nextInt(255), num.nextInt(255));
        eyeColor = Color.rgb(num.nextInt(255), num.nextInt(255), num.nextInt(255));
        hairStyle = num.nextInt(3);

        //invalidate();

    }

    //getters
    public int getredSkinColor(){return rskinColor;}
    public int getgreenSkinColor(){return gskinColor;}
    public int getblueSkinColor(){return bskinColor;}

    public int getredEyeColor(){return reyeColor;}
    public int getgreenEyeColor(){return geyeColor;}
    public int getblueEyeColor(){return beyeColor;}

    public int getredHairColor(){return rhairColor;}
    public int getgreenHairColor(){return ghairColor;}
    public int getblueHairColor(){return bhairColor;}

    public int getHairStyle(){return hairStyle;}

    //setters
    public void setredSkinColor(int progress){

        rskinColor = progress;

    }

    public void setgreenSkinColor(int progress){

        gskinColor = progress;

    }

    public void setblueSkinColor(int progress){

        bskinColor = progress;

    }

    public void setredHairColor(int progress){

        rhairColor = progress;

    }

    public void setgreenHairColor(int progress){

        ghairColor = progress;

    }

    public void setblueHairColor(int progress){

        bhairColor = progress;

    }

    public void setredEyeColor(int progress){

        reyeColor = progress;

    }

    public void setgreenEyeColor(int progress){

        geyeColor = progress;

    }

    public void setblueEyeColor(int progress){

        beyeColor = progress;

    }

    //draws the face on the given canvas
    public void onDraw(Canvas canvas){

        black.setColor(Color.BLACK);
        white.setColor(Color.WHITE);
        skinC.setColor(skinColor);
        hairC.setColor(hairColor);
        eyeC.setColor(eyeColor);


        drawHairStyle(canvas);

        drawLeftEye(canvas);

        drawRightEye(canvas);

        drawMouth(canvas);

    }


}

/**
 External Citation
 Date:     11 February 2018
 Problem:  onDraw would not draw
 Resource:
 http://android-er.blogspot.com/2014/03/simple-
 surfaceview-example.html
 Solution: Used this xml example to change Surface View
 */

/**
 External Citation
 Date:     11 February 2018
 Problem:  Did not know how to put in a picture
 Resource:
 https://stackoverflow.com/questions/5176441/drawable-
 image-on-a-canvas
 Solution: Used 3 lines of code from stackoverflow
 */