package edu.neu.madcourse.musicloud;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ShakeActivity extends AppCompatActivity implements SensorEventListener {
    private ImageView imageView;
    private SensorManager sensorManager;
    private Sensor sensor;
    private boolean isSensorAvailable,isNotFirstTime;
    private float curX, curY, curZ, difX, difY, difZ, lastX, lastY, lastZ;
    private final float threshold=1f;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);

        imageView = findViewById(R.id.imageView);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            isSensorAvailable = true;

        }else{
            isSensorAvailable = false;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isSensorAvailable){
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isSensorAvailable){
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        curX = sensorEvent.values[0];
        curY = sensorEvent.values[1];
        curZ = sensorEvent.values[2];
        if(isNotFirstTime){
            difX = Math.abs(curX - lastX);
            difY = Math.abs(curY - lastY);
            difZ = Math.abs(curZ -  lastZ);

            if((difX > threshold && difY > threshold)||(difX > threshold && difZ>threshold)||(difY>threshold && difZ >threshold)){
               vibrator.vibrate(500);
               imageView.setImageResource(R.drawable.ic_baseline_menu_24);

            }
        }
        lastX = curX;
        lastY = curY;
        lastZ = curZ;
        isNotFirstTime = true;


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}