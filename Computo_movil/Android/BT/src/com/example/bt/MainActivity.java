package com.example.bt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	BluetoothAdapter btAdpt,DispMatch;
	Button verificar,devices,scanner;
	CheckBox BT,visible;
	ArrayList aux,Dispositivos,list;
	ArrayAdapter<String> adaptador;
	
	
	private static final int ENABLE_BLUETOOTH = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		btAdpt = BluetoothAdapter.getDefaultAdapter();
		DispMatch = BluetoothAdapter.getDefaultAdapter();
		BT = (CheckBox)findViewById(R.id.activo);				
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void Verificar(View view){		
		if(btAdpt == null){
			Toast toast1 =
		            Toast.makeText(getApplicationContext(),
		                    "El dispositivo cuenta con BT", Toast.LENGTH_SHORT);
		        toast1.show();		    
		}else{
			Toast toast2 =
		            Toast.makeText(getApplicationContext(),
		                    "El dispositivo cuenta con BT", Toast.LENGTH_SHORT);		 
		        toast2.show();
		}
	}
	
	public void Activar(View view){
		if(!btAdpt.isEnabled()){			
			Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(intent, ENABLE_BLUETOOTH);
		}else{
			btAdpt.disable();
			Toast toast2 =
		            Toast.makeText(getApplicationContext(),
		                    "Iniciado", Toast.LENGTH_SHORT);		 
		        toast2.show();
		}		
	}
	
	public void Visible(View view){
		Intent discoverIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
		discoverIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 120);
		startActivity(discoverIntent);
	}
	
	public void Devices(View view){		
		BluetoothAdapter mBluetoothAdapter= BluetoothAdapter.getDefaultAdapter();
		if(mBluetoothAdapter.isDiscovering()){
			mBluetoothAdapter.cancelDiscovery();
		}
		else{
			aux = new ArrayList<String>();
			Dispositivos = new ArrayList<BluetoothDevice>();
			adaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, aux);
			mBluetoothAdapter.startDiscovery();
			registerReceiver(bReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));   
		}  
	}
	
	public BroadcastReceiver bReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)) {
            	if(Dispositivos == null)
            		Dispositivos = new ArrayList<BluetoothDevice>();
                 BluetoothDevice host = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                 Dispositivos.add(host);                
                 ListView listView = (ListView)findViewById(R.id.listView1);
                 aux.add(host.getAddress() + "\n" + host.getName());
                 
                 adaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, aux);
           		 listView.setAdapter(adaptador);                 
            }
        }
	};
	
	public Set<BluetoothDevice> Vincular;
	
	public void Listar(View view){
		ListView listView = (ListView)findViewById(R.id.listView1);
		Vincular =btAdpt.getBondedDevices();
		list = new ArrayList<BluetoothDevice>();
		for(BluetoothDevice bt:Vincular){
			list.add(bt.getName());
		}					
		Toast.makeText(getApplicationContext(), "Dispositivos Vinculados", Toast.LENGTH_LONG).show();
		adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,list);
		listView.setAdapter(adaptador);
		
		listView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id){				
				Toast.makeText(getApplicationContext(), ""+pariente.getItemAtPosition(posicion).toString(), Toast.LENGTH_LONG).show();
			}
		});
	}
		
	
	BluetoothSocket mmSocket;
	BluetoothDevice mmDevice;
	OutputStream mmOutputStream;
	InputStream mmInputStream;
	
	void openBT() throws IOException {
	     UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard                //SerialPortService ID	     
	     mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);    
	     mmSocket.connect();
	     mmOutputStream = mmSocket.getOutputStream();
	     mmInputStream = mmSocket.getInputStream();
	     //beginListenForData();
	     Toast.makeText(getApplicationContext(), "Conexion abierta", Toast.LENGTH_LONG).show();
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent Data){
		if(requestCode == ENABLE_BLUETOOTH){
			if(resultCode == RESULT_OK){
				Toast toast2 =
			            Toast.makeText(getApplicationContext(),
			                    "OK!", Toast.LENGTH_SHORT);			 
			        toast2.show();
			}				
		}
	}
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
