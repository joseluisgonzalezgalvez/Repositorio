package Vistas;
import java.awt.event.ActionEvent;

import Control.Control;
import javax.swing.*;

public class Altas extends JPanel{
	public JButton limpiar,agregar;
	public JComboBox personal;
	public JTextField cajas[];
	private JLabel etiq[];
	Control evento=new Control(this);
	
	
	public Altas(){
		alta();
	}
	
	
	public void alta(){
		setLayout(null);
		//setSize(500,500);
		labels();
		campos();
		empleo();
		botones();
	}
	
	public void labels(){
		String[] name_etiq={"Personal:","Nombre:","Puesto:","Clave:"};
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
			add(cajas[i]);
		}
	}
	
	public void empleo(){
		String[] name_personal={"--Seleccione--","Administrativo","Académico"};
		personal=new JComboBox(name_personal);
		personal.setBounds(100, 50, 200, 25);
		add(personal);
	}
	
	public void botones(){
		limpiar=new JButton("Limpiar");
		limpiar.setBounds(50, 300, 100, 30);
		limpiar.addActionListener(evento);
		add(limpiar);
		
		agregar=new JButton("Agregar");
		agregar.setBounds(200, 300, 100, 30);
		agregar.addActionListener(evento);
		add(agregar);
	}
	
}
