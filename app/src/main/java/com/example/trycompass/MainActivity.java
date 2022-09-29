package com.example.trycompass;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager    sm;
    Sensor sensor;
    LevelView   lv;
    float[] info= new float[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    lv = findViewById(R.id.levelView);
    sm = (SensorManager) getSystemService(SENSOR_SERVICE);
    sensor = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);


    }
    public void onResume(){
        super.onResume();
        sm.registerListener(this, sensor,SensorManager.SENSOR_STATUS_ACCURACY_HIGH);

    }

        public void onPause(){
        super.onPause();
        sm.unregisterListener(this);

        }
    @Override
    public void onSensorChanged(SensorEvent event) {
        switch ( event.sensor.getType() ) {
            case Sensor.TYPE_MAGNETIC_FIELD:
                info = event.values.clone();
                break;
            default: return;
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}