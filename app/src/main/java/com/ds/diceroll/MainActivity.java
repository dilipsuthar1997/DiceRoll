package com.ds.diceroll;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Animation clockWise, antiClockWise;
    MediaPlayer diceRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        antiClockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);
        diceRoll = MediaPlayer.create(this, R.raw.dice_roll);

        Button rollButton = findViewById(R.id.roll_button);

        final ImageView leftDice = findViewById(R.id.image_leftDice);
        final ImageView rightDice = findViewById(R.id.image_rightDice);

        final TextView numberLeftDice = findViewById(R.id.tv_leftDice);
        final TextView numberRightDice = findViewById(R.id.tv_rightDice);

        final int[] diceArray = {R.drawable.dice1,
                            R.drawable.dice2,
                            R.drawable.dice3,
                            R.drawable.dice4,
                            R.drawable.dice5,
                            R.drawable.dice6};

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceRoll.start();
                Log.d("Dice", "Button has been pressed");

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
        });

    }
}
