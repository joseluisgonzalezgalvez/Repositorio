package Vistas;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import Control.Control_bajas;
public class Bajas extends JPanel{
	Control_bajas item_event=new Control_bajas(this);
	
	public JList existen,aborrar;
	public JButton mov_list[];
	public JComboBox personal;
	
	
	public Bajas(){
		diseño();	
	}
	
	public void diseño(){
		setLayout(null);
		bajas();
	}
	
	public void bajas(){
		botones();
		listas();
		add(empleo());
	}
	
	public void botones(){
		String[] name_but={">","<","Eliminar"};
		mov_list=new JButton[name_but.length];
		for(int i=0;i<mov_list.length;i++){
			mov_list[i]=new JButton(name_but[i]);
			mov_list[i].addActionListener(item_event);
			if(i!=2){
				mov_list[i].setFont(new Font("Arial",Font.BOLD,11));
				mov_list[i].setBounds(190, 50+(i*50), 50, 30);	
			}
			else
				mov_list[i].setBounds(300, 300, 100, 30);
			add(mov_list[i]);
		}
	}
	
	public void listas(){
		existen=new JList();
		existen.setSelectionBackground(Color.orange);
		existen.setBounds(10,10,170,250);
		existen.setBorder(BorderFactory.createTitledBorder("Personal"));
		add(existen);
		
		aborrar=new JList();
		aborrar.setSelectionBackground(Color.red);
		aborrar.setBounds(250,10,170,250);
		aborrar.setBorder(BorderFactory.createTitledBorder("Eliminar"));
		add(aborrar);
		
	}
	
	public JComboBox empleo(){
		String[] name_personal={"--Seleccione--","Administrativo","Académico"};
		personal=new JComboBox(name_personal);
		personal.addItemListener(item_event);
		personal.setBounds(10, 300, 120, 25);
		return personal;
	}
}
