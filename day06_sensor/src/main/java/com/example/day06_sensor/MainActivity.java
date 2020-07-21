package com.example.day06_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //getAll();
        userOrien();
    }

    private void userOrien() {
        Sensor defaultSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(new Listener(), defaultSensor, SensorManager.SENSOR_DELAY_NORMAL);
        Sensor sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(new Listenertwo(), sensorLight, SensorManager.SENSOR_DELAY_NORMAL);
    }
    public class Listener implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            float v = event.values[0];
            Log.e("tag", "方向角度: "+v );
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    private void getAll() {
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < sensorList.size(); i++) {
            Sensor sensor = sensorList.get(i);
            String name = sensor.getName();
            String vendor = sensor.getVendor();
            int version = sensor.getVersion();
            Log.e("tag", "onCreate: name:"+name+","+vendor +","+version);
        }
    }
    public class Listenertwo implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            float value = event.values[0];
            Log.e("tag", "光线强度:"+value);
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
}
