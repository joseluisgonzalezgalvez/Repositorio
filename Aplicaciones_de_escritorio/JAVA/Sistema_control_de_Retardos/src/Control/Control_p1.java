package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import BD.Archivos;
import BD.Operacion_altas;
import BD.Operacion_pesta�as;
import BD.Report;
import Vistas.Altas;
import Vistas.Pesta�as;

public class Control_p1 implements ActionListener,FocusListener{
	Pesta�as ps;
	Operacion_pesta�as op;
	Archivos ar;
	Report r;
	DefaultListModel mod;
	public Control_p1(Pesta�as ps){
		this.ps=ps;		
		op=new Operacion_pesta�as();
		ar=new Archivos();
		r=new Report();
	}
	
	public void actionPerformed(ActionEvent e){
		Object o=e.getSource();
		ArrayList<String>tol;
		ArrayList<String>ret;
		ArrayList<String>fal;
		if(o==ps.b[0]){
			int x=0;
			mod=(DefaultListModel)ps.lista.getModel();
			String s=(String) mod.getElementAt(ps.lista.getSelectedIndex());
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)==':')
					x=i;
			}
			tol=ar.tol(Integer.parseInt(s.substring(0,x)));
			JOptionPane.showMessageDialog(null, tol.size());
		}
		if(o==ps.b[1]){
			int x=0;
			mod=(DefaultListModel)ps.lista.getModel();
			String s=(String) mod.getElementAt(ps.lista.getSelectedIndex());
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)==':')
					x=i;
			}
			ret=ar.ret(Integer.parseInt(s.substring(0,x)));
			JOptionPane.showMessageDialog(null, ret.size());
		}
		if(o==ps.b[2]){
			int x=0;
			mod=(DefaultListModel)ps.lista.getModel();
			String s=(String) mod.getElementAt(ps.lista.getSelectedIndex());
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)==':')
					x=i;
			}
			fal=ar.faltas(Integer.parseInt(s.substring(0,x)));
			JOptionPane.showMessageDialog(null, fal.size());
		}
		if(o==ps.b[3]){
			int x=0;
			try{
				mod=(DefaultListModel)ps.lista.getModel();
				String s=(String) mod.getElementAt(ps.lista.getSelectedIndex());
				for(int i=0;i<s.length();i++){
					if(s.charAt(i)==':')
						x=i;
				}
				ps.tabla.setModel(ar.query(Integer.parseInt(s.substring(0,x))));	
			}catch(Exception d){
				JOptionPane.showMessageDialog(null, "Debe Seleccionar un personal de la Lista!");
			}
		}
		if(o==ps.item[0]){
			r.pasa_parametrosBD(Integer.parseInt(JOptionPane.showInputDialog("Inserte la clave")));
		}
	}
	
	public void focusGained(FocusEvent f){		
		refresh();		
	}
	
	public void focusLost(FocusEvent f){
		
	}
	
	public void refresh(){
		ps.lista.setModel(op.op_lista());
	}
	
}
