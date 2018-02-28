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

    private int redColor;
    private int greenColor;
    private int blueColor;

    public static final String RED_KEY = "RED_KEY";
    public static final String GREEN_KEY = "GREEN_KEY";
    public static final String BLUE_KEY = "BLUE_KEY";

    private Button bSetColor;
    private SeekBar sBarR;
    private SeekBar sBarG;
    private SeekBar sBarB;
    private TextView tvControlR;
    private TextView tvControlG;
    private TextView tvControlB;
    private View colorControlView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        colorControlView = (View) findViewById(R.id.colorControlView);
        tvControlR = (TextView) findViewById(R.id.tvControlR);
        tvControlG = (TextView) findViewById(R.id.tvControlG);
        tvControlB = (TextView) findViewById(R.id.tvControlB);
        tvControlR.setText(String.valueOf(0));
        tvControlG.setText(String.valueOf(0));
        tvControlB.setText(String.valueOf(0));
        sBarR = (SeekBar) findViewById(R.id.sBarR);
        sBarG = (SeekBar) findViewById(R.id.sBarG);
        sBarB = (SeekBar) findViewById(R.id.sBarB);

        sBarR.setOnSeekBarChangeListener(seekBarListener);
        sBarG.setOnSeekBarChangeListener(seekBarListener);
        sBarB.setOnSeekBarChangeListener(seekBarListener);

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

    private SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            updateView();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void updateView(){
        redColor = sBarR.getProgress();
        greenColor = sBarG.getProgress();
        blueColor = sBarB.getProgress();
        colorControlView.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor));
        tvControlR.setText(String.valueOf(redColor));
        tvControlG.setText(String.valueOf(greenColor));
        tvControlB.setText(String.valueOf(blueColor));
    }
}
