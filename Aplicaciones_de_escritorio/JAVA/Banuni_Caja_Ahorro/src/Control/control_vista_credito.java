package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Vista_Creditos.Amortizacion;

public class control_vista_credito implements ActionListener{
	Vista_Creditos.Amortizacion_Prestamos am;
	int plazos=0;
	Base_Datos.Sentencias s =  new Base_Datos.Sentencias();
	public control_vista_credito(Vista_Creditos.Amortizacion_Prestamos am){
		this.am=am;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object x = e.getSource();
		if(x == am.JB[2]){
			am.Borrar();
			double importe = Double.parseDouble(am.JT[1].getText());
			double interes = Double.parseDouble(am.JT[6].getText());
			double pago_acordado = Double.parseDouble(am.JT[4].getText());
			if(pago_acordado>(importe*(interes/100))){
				if(am.Plazos.getSelectedItem().equals("Semanal")){plazos= 7;}
				if(am.Plazos.getSelectedItem().equals("Quincenal")){plazos= 15;}
				if(am.Plazos.getSelectedItem().equals("Mensual")){plazos= 30;}
				Amortizacion a = new Amortizacion();
				am.modelo = a.Calculos(importe, interes, pago_acordado, am.modelo, plazos);
			}
			else{
				JOptionPane.showMessageDialog(null,"Pago Acordado","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(x == am.JB[3]){

			s.Open();
			s.Eliminar_Tabla_Amortizacion();
			s.Crear_Tabla_Amortizacion();
            int fila = am.Valuacion2.getRowCount();
            for(int i=0; i<fila;i++){
            		
            		Object fecha = am.modelo.getValueAt(i,1);
            		String fechas = String.valueOf(fecha);
            		
            		Object interes = am.modelo.getValueAt(i,2);
            		String interes_men = String.valueOf(interes);
            		
            		Object abo_cap = am.modelo.getValueAt(i,3);
            		String abono_capital = String.valueOf(abo_cap);
            		
            		Object pago = am.modelo.getValueAt(i,4);
            		String pago_rea = String.valueOf(pago);
            		
            		Object deuda = am.modelo.getValueAt(i,5);
            		String deuda_act = String.valueOf(deuda);
            		try {
						s.Alta_Amortizacion(fechas, interes_men, abono_capital, pago_rea, deuda_act);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
            }
            s.Close();
            s.print_morti();
		}
		if(x == am.JB[4]){
			limpiar();
			s.Open();
			s.Eliminar_Tabla_Amortizacion();
			s.Close();
		}
	}
	public void limpiar(){
        for(int i=1;i<9;i++){
            am.JT[i].setText("");
        }
        am.Plazos.setSelectedIndex(0);
        am.Borrar();
	}
}
