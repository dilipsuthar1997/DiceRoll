package com.ds.diceroll;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "DiceRoll";

    // TODO: Member variable here
    private Animation clockWise, antiClockWise;
    private ImageView leftDice;
    private ImageView rightDice;
    private TextView numberLeftDice;
    private TextView numberRightDice;
    private int[] diceArray = {R.drawable.dice1,
                                R.drawable.dice2,
                                R.drawable.dice3,
                                R.drawable.dice4,
                                R.drawable.dice5,
                                R.drawable.dice6 };

    private SoundPool mSoundPool;
    private int mSoundID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        antiClockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        leftDice = findViewById(R.id.image_leftDice);
        rightDice = findViewById(R.id.image_rightDice);

        numberLeftDice = findViewById(R.id.tv_leftDice);
        numberRightDice = findViewById(R.id.tv_rightDice);

        // TODO: Create a new SoundPool
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        // TODO: Load and get the IDs to identify the sounds
        mSoundID = mSoundPool.load(getApplicationContext(),R.raw.dice_roll, 1);

    }

    public void playDiceRoll (View v) {
        Log.d(TAG, "Roll Button pressed");
        // TODO: Added play(Public method) triggered by button
        mSoundPool.play(mSoundID, 1.0f, 1.0f, 0, 0, 1.0f);

        Random randomNumber = new Random();
        int number = randomNumber.nextInt(6);
        Log.d("Dice", "The random number is : " + number);

        leftDice.startAnimation(clockWise);
        leftDice.setImageResource(diceArray[number]);
        int i = number+1;
        numberLeftDice.setText(String.valueOf(i));

        number = randomNumber.nextInt(6);
        rightDice.startAnimation(antiClockWise);
        rightDice.setImageResource(diceArray[number]);
        int j = number+1;
        numberRightDice.setText(String.valueOf(j));
    }
}
