package cs371.carstereo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.SeekBar;
import android.util.Log;

import java.nio.channels.SeekableByteChannel;


public class CarStereo extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ToggleButton PowerButton;
    private Button button6;
    private Button button5;
    private Button button4;
    private Button button3;
    private Button button2;
    private Button button1;
    private ToggleButton Frequency;
    private boolean Freq;
    private double FM;
    private int AM;
    private TextView radioDisplay;
    private SeekBar tunerBar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_stereo);

        PowerButton = (ToggleButton) findViewById(R.id.PowerButton);
        button6 = (Button) findViewById(R.id.button6);
        button5 = (Button) findViewById(R.id.button5);
        button4 = (Button) findViewById(R.id.button4);
        button3 = (Button) findViewById(R.id.button3);
        button2 = (Button) findViewById(R.id.button2);
        button1 = (Button) findViewById(R.id.button1);
        Frequency = (ToggleButton) findViewById(R.id.Frequency);
        radioDisplay = (TextView) findViewById(R.id.radioDisplay);
        tunerBar = (SeekBar) findViewById(R.id.tunerBar);
        tunerBar.setOnSeekBarChangeListener(this);


    }

    public boolean Power(View v) {

        if (PowerButton.isChecked()) {
            button1.setBackgroundColor(Color.BLACK);
            button2.setBackgroundColor(Color.BLACK);
            button3.setBackgroundColor(Color.BLACK);
            button4.setBackgroundColor(Color.BLACK);
            button5.setBackgroundColor(Color.BLACK);
            button6.setBackgroundColor(Color.BLACK);
            Frequency.setBackgroundColor(Color.BLACK);
            return true;
        } else {
            button1.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            Frequency.setBackgroundColor(Color.WHITE);
            return false;
        }


    }

    @Override
    public void onProgressChanged(SeekBar tunerBar, int progress, boolean fromUser) {

        if (Frequency.isChecked()) {
            //tunerBar.incrementProgressBy(2/10);
            tunerBar.setMax(99);
            FM = progress *0.2 + 88.1;
            radioDisplay.setText(FM + " FM");
        }
        else
        {
           // tunerBar.incrementProgressBy(10);
            tunerBar.setMax(117);
            AM = progress*10 + 530;
            radioDisplay.setText(AM + " AM");
        }


    }

    public void onStartTrackingTouch(SeekBar tunerBar) {

    }

    public void onStopTrackingTouch (SeekBar tunerBar) {
    }

    public void presetButtons (View v) {
        if (Frequency.isChecked()) {
            double[] fmStations = {90.9, 92.9, 94.9, 96.9, 98.9, 100.9};
            /*if (button1.isPressed()) {
                onProgressChanged(tunerBar, 14, boolean fromUser);
                //radioDisplay.setText(90.9 + " FM");
            }
            if (button2.isPressed()) {
                radioDisplay.setText(92.9 + " FM");
            }
            if (button3.isPressed()) {
                radioDisplay.setText(94.9 + " FM");
            }
            if (button4.isPressed()) {
                radioDisplay.setText(96.9 + " FM");
            }
            if (button5.isPressed()) {
                radioDisplay.setText(98.9 + " FM");
            }
            if (button6.isPressed()) {
                radioDisplay.setText(100.9 + " FM");
            }*/

        } else {
            int[] amStation = {550, 600, 650, 700, 750, 800};
        }
    }

}
