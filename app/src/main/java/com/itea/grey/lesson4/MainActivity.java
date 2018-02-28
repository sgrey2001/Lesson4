package com.itea.grey.lesson4;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.itea.grey.lesson4.ControlActivity.BLUE_KEY;
import static com.itea.grey.lesson4.ControlActivity.GREEN_KEY;
import static com.itea.grey.lesson4.ControlActivity.RED_KEY;

public class MainActivity extends AppCompatActivity {

    TextView tvNumberR;
    TextView tvNumberG;
    TextView tvNumberB;
    Button bGetColor;

  public static final int SECOND_ACTIVITY_CODE = 1;
    int red;
    int green;
    int blue;

    View colorView;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECOND_ACTIVITY_CODE){
            if (resultCode == RESULT_OK){
                red = data.getExtras().getInt(RED_KEY);
                green = data.getExtras().getInt(GREEN_KEY);
                blue = data.getExtras().getInt(BLUE_KEY);

                colorView.setBackgroundColor(Color.rgb(red, green, blue));
                tvNumberR.setText(String.valueOf(red));
                tvNumberG.setText(String.valueOf(green));
                tvNumberB.setText(String.valueOf(blue));

            } else {
                tvNumberR.setText("");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumberR = (TextView)findViewById(R.id.tvNumberR);
        tvNumberG = (TextView)findViewById(R.id.tvNumberG);
        tvNumberB = (TextView)findViewById(R.id.tvNumberB);
        colorView = (View)findViewById(R.id.colorView);

        bGetColor = (Button)findViewById(R.id.bGetColor);
        bGetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ControlActivity.class);
                startActivityForResult(intent, SECOND_ACTIVITY_CODE);

            }
        });

    }
}
