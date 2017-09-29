package com.example.admin.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static TextView tv;
    private static SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar();

    }

    public void seekBar(){

        tv = (TextView) findViewById(R.id.textView);
        sb = (SeekBar) findViewById(R.id.seekBar);

        tv.setText("Covered : " + sb.getProgress() + " / " + sb.getMax());



        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressValue;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
                tv.setText("Covered : " + progress + " / " + sb.getMax());
                Toast.makeText(MainActivity.this, "SeekBar in progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


                Toast.makeText(MainActivity.this, "SeekBar Start Tracking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv.setText("Covered : " + progressValue + " / " + sb.getMax());

                Toast.makeText(MainActivity.this, "SeekBar Stop Tracking", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
