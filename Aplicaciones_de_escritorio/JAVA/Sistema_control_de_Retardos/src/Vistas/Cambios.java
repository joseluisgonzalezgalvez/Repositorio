package Vistas;
import javax.swing.*;

import BD.Operacion_cambios;
import Control.Control_camb;

public class Cambios extends JPanel{
	
	Operacion_cambios op=new Operacion_cambios();
	Control_camb item_event=new Control_camb(this);
	
	public JButton limpiar,agregar;
	public JComboBox personal,personal2;
	public JTextField cajas[];
	private JLabel etiq[];
	
	public Cambios(){
		diseño();
	}
	
	
	public void diseño(){
		setLayout(null);
		cambios();		
	}
	
	
	public void cambios(){
		
		labels();
		campos();
		empleo();
		personal();
		botones();
	}
	
	public void labels(){
		String[] name_etiq={"Personal:","Nombre:","Puesto:","Clave:","Empleado:"};
		etiq=new JLabel[name_etiq.length];
		for(int i=0;i<etiq.length;i++){
			etiq[i]=new JLabel(name_etiq[i]);
			etiq[i].setBounds(10, 50+(i*50), 100, 30);
			add(etiq[i]);
		}		
	}
	
	public void campos(){
		cajas=new JTextField[etiq.length-1];
		for(int i=0;i<cajas.length;i++){
			cajas[i]=new JTextField();
			cajas[i].setBounds(100, 50+((i+1)*50), 200, 25);
			if(i==2)
				cajas[i].setBounds(100, 50+((i+1)*50), 50, 25);		
			if(i!=3)	
				add(cajas[i]);
		}
	}
	
	public void empleo(){
		String[] name_personal={"--Seleccione--","Administrativo","Académico"};
		personal=new JComboBox(name_personal);
		personal.setBounds(100, 50, 200, 25);
		add(personal);
	}
	
	public void personal(){		
		personal2=new JComboBox(op.employ_lista());
		personal2.setBounds(100, 250, 200, 25);
		personal2.addActionListener(item_event);
		add(personal2);
	}
	
	public void botones(){
		limpiar=new JButton("Limpiar");
		limpiar.setBounds(50, 300, 100, 30);
		
		add(limpiar);
		
		agregar=new JButton("Agregar");
		agregar.setBounds(200, 300, 100, 30);
		agregar.addActionListener(item_event);
		add(agregar);
	}
	
	
	
}