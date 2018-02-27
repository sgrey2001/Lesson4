package com.itea.grey.lesson4;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class ControlActivity extends AppCompatActivity {

    int redColor;
    int greenColor;
    int blueColor;

    public static final String RED_KEY = "RED_KEY";
    public static final String GREEN_KEY = "GREEN_KEY";
    public static final String BLUE_KEY = "BLUE_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        Button bSetColor;
        SeekBar sBarR;
        SeekBar sBarG;
        SeekBar sBarB;
        final TextView tvControlR;
        final TextView tvControlG;
        final TextView tvControlB;
        final View colorControlView;

        colorControlView = (View) findViewById(R.id.colorControlView);

        tvControlR = (TextView) findViewById(R.id.tvControlR);
        tvControlG = (TextView) findViewById(R.id.tvControlG);
        tvControlB = (TextView) findViewById(R.id.tvControlB);

        tvControlR.setText("0");
        tvControlG.setText("0");
        tvControlB.setText("0");


        sBarR = (SeekBar) findViewById(R.id.sBarR);
        sBarG = (SeekBar) findViewById(R.id.sBarG);
        sBarB = (SeekBar) findViewById(R.id.sBarB);


        sBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redColor = progress;
                colorControlView.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor));
                tvControlR.setText(String.valueOf(redColor));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        sBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenColor = progress;
                colorControlView.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor));
                tvControlG.setText(String.valueOf(greenColor));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueColor = progress;
                colorControlView.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor));
                tvControlB.setText(String.valueOf(blueColor));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        bSetColor = (Button) findViewById(R.id.bSetColor);
        bSetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, MainActivity.class);
                intent.putExtra(RED_KEY, redColor);
                intent.putExtra(GREEN_KEY, greenColor);
                intent.putExtra(BLUE_KEY, blueColor);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
