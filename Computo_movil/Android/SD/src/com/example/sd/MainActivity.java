package com.example.sd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	public EditText et1,et2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void grabar(View v){

    	boolean sdDisp = false;
    	boolean sdAccesoEsc = false;
    	
    	String estado = Environment.getExternalStorageState();
    	
    	if(estado.equals(Environment.MEDIA_MOUNTED)){
    		sdDisp = true;
    		sdAccesoEsc = true;
    	}
    	else if(estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
    		sdDisp = true;
    		sdAccesoEsc = false;
    	}
    	else{
    		sdDisp = false;
    		sdAccesoEsc = false;
    	}
    	if(sdDisp && sdAccesoEsc){
    		String nombre = et1.getText().toString();
    		String cont = et2.getText().toString();
    		try{
    			File ruta_sd = Environment.getExternalStorageDirectory();
    			File f = new File(ruta_sd.getAbsolutePath(), nombre);
    			OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
    			fout.write(cont);
    			fout.flush();
    			fout.close();
    			et1.setText("");
    			et2.setText("");
    			Toast.makeText(this, "Los datos fueron almacenados!!", Toast.LENGTH_LONG).show();    			
    		}catch(Exception e){
    			Log.e("ficheros", "Error al escribir fichero a SD");
    		}
    	}
    }
    
    public void mostrar(View v){
    	String nombre = et1.getText().toString();
    	File ruta_sd = Environment.getExternalStorageDirectory();
		File f = new File(ruta_sd.getAbsolutePath(), nombre);
		try{
			FileInputStream fin = new FileInputStream(f);
			InputStreamReader archivo = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(archivo);
			String linea = br.readLine();
			String all = "";
			while(linea != null){
				all = all + linea + "\n";
				linea = br.readLine();
			}
			br.close();
			archivo.close();
			et2.setText(all);
		}catch(Exception e){
			Log.e("ficheros", "Error al leer fichero a SD");
		}
		
    }
}
