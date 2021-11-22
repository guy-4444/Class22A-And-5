package com.guy.class22a_and_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;

import java.text.DecimalFormat;

public class Activity_Panel extends AppCompatActivity {

    public static final String SENSOR_TYPE = "SENSOR_TYPE";

    private MaterialTextView panel_LBL_info;

    private SensorManager sensorManager;
    private Sensor accSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        panel_LBL_info = findViewById(R.id.panel_LBL_info);




        initSensor();

    }

    private void initSensor() {
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    private SensorEventListener accSensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            DecimalFormat df = new DecimalFormat("##.##");
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            panel_LBL_info.setText(
                    df.format(x) + "\n" + df.format(y) + "\n" + df.format(z)
            );

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(accSensorEventListener, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(accSensorEventListener);
    }

    public boolean isSensorExist(int sensorType) {
        return (sensorManager.getDefaultSensor(sensorType) != null);
    }
}