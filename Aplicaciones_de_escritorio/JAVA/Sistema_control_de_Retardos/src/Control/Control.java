package Control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import BD.*;
import Vistas.*;

public class Control implements ActionListener{
	
	Altas pa;
	
	Operacion_altas op; 
	public Control(Altas pa){
		this.pa=pa;		
		op=new Operacion_altas();
	}
	
	public void actionPerformed(ActionEvent e){
		Object o=e.getSource();
		if(o==pa.agregar){
			if(((String) pa.personal.getSelectedItem()).equalsIgnoreCase("--Seleccione--")){
				JOptionPane.showMessageDialog(null, "Debe elegir el tipo de personal");
			}
			else{
				op.conectar();
				op.alta(Integer.parseInt(pa.cajas[2].getText()), pa.cajas[0].getText(), pa.cajas[1].getText(), ""+pa.personal.getSelectedItem());
				//pd.lista.setModel(op.op_lista());
				//pd.pane_list.add(pd.lista);
				//pd.lista(pd, pd.lista);				
				op.desconectar();				
			}		
		}
		
		if(o==pa.limpiar){
			pa.personal.setSelectedIndex(0);
			for(int i=0;i<pa.cajas.length;i++){
				pa.cajas[i].setText("");
			}
		}
	}
}
