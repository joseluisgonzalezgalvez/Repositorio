package com.example.sensores2;

import java.util.List;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener{

	private List<Sensor> listaSensores;
	private TextView aaTextView[][] = new TextView[20][3];
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout raiz = (LinearLayout)findViewById(R.id.raiz);
        SensorManager se = (SensorManager)getSystemService(SENSOR_SERVICE);
        listaSensores = se.getSensorList(Sensor.TYPE_ALL);
        int n=0;
        
        for(Sensor sensor:listaSensores){
        	TextView aTextView = new TextView(this);
        	aTextView.setText(sensor.getName());
        	raiz.addView(aTextView);
        	LinearLayout nLinearLayout = new LinearLayout(this);
        	raiz.addView(nLinearLayout);
        	
        	for(int i=0;i<3;i++){
        		aaTextView[n][i] = new TextView(this);
        		aaTextView[n][i].setText("?");
        		aaTextView[n][i].setWidth(87);
        	}
        	TextView xtextView = new TextView(this);
        	xtextView.setText(" X: ");
        	nLinearLayout.addView(xtextView);
        	nLinearLayout.addView(aaTextView[n][0]);
        	xtextView.setText(" Y: ");
        	nLinearLayout.addView(xtextView);
        	nLinearLayout.addView(aaTextView[n][1]);
        	xtextView.setText(" Z: ");
        	nLinearLayout.addView(xtextView);
        	nLinearLayout.addView(aaTextView[n][2]);
        	se.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        	n++;
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		synchronized(this){
			int n=0;
			for (Sensor sensor: listaSensores){
				if(event.sensor == sensor){
					for(int i=0;i<event.values.length;i++){
						aaTextView[n][i].setText(Float.toString(event.values[i]));
					}
				}
				n++;
			}			
		}
	}
    
}
