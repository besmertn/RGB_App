package com.example.bessmertnyi.rgb_app;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.PersistableBundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int MAX_COLOR_VALUE = 255;

    SeekBar redSeekBar, greenSeekBar, blueSeekBar;

    TextView colorTextView;

    View mainLayout, seekBarsLayout;

    int redValue = MAX_COLOR_VALUE, greenValue = MAX_COLOR_VALUE, blueValue = MAX_COLOR_VALUE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        seekBarsLayout = findViewById(R.id.seekBarsLayout);

        colorTextView = findViewById(R.id.colorTextView);

        redSeekBar = findViewById(R.id.redSeekBar);
        greenSeekBar = findViewById(R.id.greenSeekBar);
        blueSeekBar = findViewById(R.id.blueSeekBar);

        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redValue = MAX_COLOR_VALUE - progress;
                mainLayout.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
                int color = Color.TRANSPARENT;
                Drawable background = mainLayout.getBackground();
                if (background instanceof ColorDrawable)
                    color = ((ColorDrawable) background).getColor();
                colorTextView.setText("" + String.format("#%06X", (0xFFFFFF & color)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenValue = MAX_COLOR_VALUE - progress;
                mainLayout.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
                int color = Color.TRANSPARENT;
                Drawable background = mainLayout.getBackground();
                if (background instanceof ColorDrawable)
                    color = ((ColorDrawable) background).getColor();
                colorTextView.setText("" + String.format("#%06X", (0xFFFFFF & color)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueValue = MAX_COLOR_VALUE - progress;
                mainLayout.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
                int color = Color.TRANSPARENT;
                Drawable background = mainLayout.getBackground();
                if (background instanceof ColorDrawable)
                    color = ((ColorDrawable) background).getColor();
                colorTextView.setText("" + String.format("#%06X", (0xFFFFFF & color)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("redValue", redValue);
        outState.putInt("greenValue", greenValue);
        outState.putInt("blueValue", blueValue);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        redValue = savedInstanceState.getInt("redValue");
        greenValue = savedInstanceState.getInt("greenValue");
        blueValue = savedInstanceState.getInt("blueValue");
    }

    @Override
    protected void onResume() {
        super.onResume();

        mainLayout.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
        int color = Color.TRANSPARENT;
        Drawable background = mainLayout.getBackground();
        if (background instanceof ColorDrawable)
            color = ((ColorDrawable) background).getColor();
        colorTextView.setText("" + String.format("#%06X", (0xFFFFFF & color)));

    }
}
