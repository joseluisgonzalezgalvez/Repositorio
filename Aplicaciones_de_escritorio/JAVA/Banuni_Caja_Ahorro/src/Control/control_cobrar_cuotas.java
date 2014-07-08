package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import Vistas_Empleado.VistaClientes;
import Operaciones.Operaciones;

public class control_cobrar_cuotas implements ActionListener,MouseListener{
	Vista_Creditos.Cobrar_Cuotas vc;
	Operaciones op;
	
	public control_cobrar_cuotas(Vista_Creditos.Cobrar_Cuotas vc){
		this.vc=vc;
		op=new Operaciones();
	}

	public void actionPerformed(ActionEvent e) {
		Object x = e.getSource();
		// ************ Boton de Altas ***********
		if(x ==vc.JB[0]){
			op.conectar();
			vc.Llenar_Tabla_Base_Datos(op.fill_table(vc.JT[0].getText()));
			op.desconectar();
		}
		
		if(x == vc.JB[1]){
			op.mod_edo(vc.JT[8].getText(), vc.JT[9].getText());
			/*
			op.conectar();
            vc.Llenar_Tabla_Cuotas(op.fill_pagos(vc.JT[8].getText(),vc.JT[9].getText()));
            op.desconectar();*/	
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent m) {
				
		if(m.getSource() == vc.Valuacion2){
			vc.Borrar_Cuotas();
			int fila = vc.Valuacion2.rowAtPoint(m.getPoint());
	        int columna = vc.Valuacion2.columnAtPoint(m.getPoint());
	        
	        if((fila > -1) && (columna> -1)){
	            Object Id_Produ = vc.modelo.getValueAt(fila,0);
	            String Id_Prod = String.valueOf(Id_Produ);
	            
	            Object fex = vc.modelo.getValueAt(fila,3);
	            String fexa = String.valueOf(fex);
	            
	            op.conectar();
	            vc.Llenar_Tabla_Cuotas(op.fill_pagos(Id_Prod,fexa));
	            op.desconectar();	
	        	}
		}
	    if(m.getSource() == vc.Valuacion3){
				int row = vc.Valuacion3.rowAtPoint(m.getPoint());
		        int column = vc.Valuacion3.columnAtPoint(m.getPoint());
		        
		        if((row > -1) && (column> -1)){
		        	/*
		            Object Id_Produ = vc.modelo2.getValueAt(row,1);
		            String Id_Prod = String.valueOf(Id_Produ);
		            JOptionPane.showMessageDialog(null, Id_Prod);
		            Object fex = vc.modelo2.getValueAt(row,3);
		            String fexa = String.valueOf(fex);
		            JOptionPane.showMessageDialog(null, fexa);
		            */
		            op.conectar();
		            vc.JT[6].setText(String.valueOf(vc.modelo2.getValueAt(row,5)));
		            vc.JT[7].setText(String.valueOf(vc.modelo2.getValueAt(row,4)));
		            vc.JT[8].setText(String.valueOf(vc.modelo2.getValueAt(row,1)));
		            vc.JT[9].setText(String.valueOf(vc.modelo2.getValueAt(row,3)));
		            //vc.JT[0].setText(arg0);
		            //vc.Llenar_Tabla_Cuotas(op.fill_pagos(Id_Prod,fexa));
		            op.desconectar();	
		        }
	    }
            //JOptionPane.showMessageDialog(null, fexa);
            
            //Id_Cliente= Id_Pro;
            //JOptionPane.showMessageDialog(null, Id_Cliente);
            /*s.Open();
            vc.Jt[0].setText(s.Obtener_Nombre(Id_Pro));
            vc.Jt[1].setText(s.Obtener_Apellidos(Id_Pro));
            vc.Jt[2].setText(s.Obtener_Direccion(Id_Pro));
            vc.Jt[3].setText(s.Obtener_Ciudad(Id_Pro));
            vc.Jt[4].setText(s.Obtener_Tel(Id_Pro));
            vc.Jt[6].setText(""+s.Obtener_Fecha_Reg(Id_Pro)+" "+s.Obtener_Hora_Reg(Id_Pro));
            s.Close();*/
     
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
