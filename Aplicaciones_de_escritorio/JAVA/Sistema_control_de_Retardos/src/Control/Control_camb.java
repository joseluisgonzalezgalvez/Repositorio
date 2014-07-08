package Control;

import java.awt.event.*;

import javax.swing.JOptionPane;

import BD.Operacion_cambios;
import Vistas.Cambios;

public class Control_camb implements ActionListener,ItemListener{
	Cambios cm;
	Operacion_cambios op;
	
	public Control_camb(Cambios cm){
		this.cm=cm;
		op=new Operacion_cambios();
	}
	
	public void actionPerformed(ActionEvent e){
		String []mos={"nombre","puesto","clave"};
		int cl=(Integer) cm.personal2.getSelectedItem();
		
		if(e.getSource()==cm.personal2){
			if(op.query("tipo",cl).equals("Administrativo"))
				cm.personal.setSelectedIndex(1);
			else
				cm.personal.setSelectedIndex(2);
			for(int i=0;i<mos.length;i++)
				cm.cajas[i].setText(op.query(mos[i],cl));
		}
		
		if(e.getSource()==cm.agregar){
			op.upd(cl, cm.cajas[0].getText(), cm.cajas[1].getText(), ""+cm.personal.getSelectedItem());
		}
		
		
	}
	
	public void itemStateChanged(ItemEvent it){
		
	}
}
