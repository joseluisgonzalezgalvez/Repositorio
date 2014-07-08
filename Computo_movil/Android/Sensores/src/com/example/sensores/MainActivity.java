package com.example.sensores;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements  SensorEventListener{
	private SensorManager sensorManager;
	TextView xCor,yCor,zCor;	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xCor = (TextView)findViewById(R.id.textView1);
        yCor = (TextView)findViewById(R.id.TextView2);
        zCor = (TextView)findViewById(R.id.TextView3);
        
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        		, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy){
    	
    }
    
    @Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
    		float x=event.values[0];
    		float y=event.values[1];
    		float z=event.values[2];
    		
    		xCor.setText("X: "+x);
    		yCor.setText("Y: "+y);
    		zCor.setText("Z: "+z);
		}
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	
    
}
