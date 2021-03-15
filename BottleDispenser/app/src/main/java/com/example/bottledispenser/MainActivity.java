/**
 * MainActivity.java
 * CT60A2411 Olio-ohjelmointi L03T4
 * @author Aino Liukkonen
 * 15.3.2021
 */

package com.example.bottledispenser;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView, textView2, seekBarText;
    Button addMoney, getMoney, buy;
    SeekBar seekBar;
    double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        seekBarText = (TextView) findViewById(R.id.seekBarText);
        addMoney = (Button) findViewById(R.id.addMoney);
        getMoney = (Button) findViewById(R.id.getMoney);
        buy = (Button) findViewById(R.id.buy);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        BottleDispenser bd = BottleDispenser.getInstance();

        getMoney.setOnClickListener(v -> bd.returnMoney(textView, textView2));

        buy.setOnClickListener(v -> bd.buyBottle(0, textView, textView2));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar3, int progress, boolean fromUser) {
                value = seekBar.getProgress();
                String prog = "Press Add Money \nto add: " + value + "€";
                seekBarText.setText(prog);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar3) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar3) {
            }
        });

        addMoney.setOnClickListener(v -> {
            bd.addMoney(textView, textView2, value);
            seekBar.setProgress(0);
        });
    }
}
