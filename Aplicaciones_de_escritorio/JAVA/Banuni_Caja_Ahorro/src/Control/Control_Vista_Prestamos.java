package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Vista_Creditos.Amortizacion;
import Vista_Creditos.ManejadorFechas;

public class Control_Vista_Prestamos implements ActionListener{
	Vista_Creditos.VistaPrestamo vp;
	int plazos=0;
	double interes = 0,importe = 0,pago_acordado;
	Operaciones.Operaciones op = new Operaciones.Operaciones();
	public Control_Vista_Prestamos(Vista_Creditos.VistaPrestamo vp){
		this.vp= vp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object x = e.getSource();

		if(x == vp.JB[0]){
			JOptionPane.showMessageDialog(null, "Buscando");
			String campo = vp.JT[0].getText();
			JOptionPane.showMessageDialog(null,campo);
			op.conectar();
			vp.cajitas[0].setText(op.consulta("Id_cliente", "Cliente","Id_cliente", campo));
			vp.cajitas[1].setText(op.consulta("Nombre", "Cliente","Id_cliente", campo));
			vp.cajitas[2].setText(op.consulta("Apellido", "Cliente","Id_cliente", campo));
			vp.cajitas[3].setText(op.consulta("Edo_crediticio", "Cliente","Id_cliente", campo));
			vp.cajitas[4].setText(op.consulta("Ciudad", "Cliente","Id_cliente", campo));
			op.desconectar();
		}
		if(x == vp.JB[6]){
			vp.Borrar();
			importe = Double.parseDouble(vp.JT[4].getText());
			interes = Double.parseDouble(vp.JT[1].getText());
			pago_acordado = Double.parseDouble(vp.JT[5].getText());
			if(pago_acordado>(importe*(interes/100))){
				if(vp.Plazos.getSelectedItem().equals("Semanal")){plazos= 7;}
				if(vp.Plazos.getSelectedItem().equals("Quincenal")){plazos= 15;}
				if(vp.Plazos.getSelectedItem().equals("Mensual")){plazos= 30;}
				Amortizacion a = new Amortizacion();
				vp.modelo = a.Calculos(importe, interes, pago_acordado, vp.modelo, plazos);
			}
			else{
				JOptionPane.showMessageDialog(null,"Pago Acordado","ERROR",JOptionPane.ERROR_MESSAGE);
			
			}
		
		}
		if(x == vp.JB[3]){
			
			op.conectar();
			vp.Valuacion3.setModel(op.ver_prest());
			op.desconectar();
		}
		
		if(x == vp.JB[2]){
			op.conectar();
			Vista_Creditos.ManejadorFechas mf = new ManejadorFechas();
			@SuppressWarnings("static-access")
			String fecha = mf.DameFechaActual() +" "+mf.getHoraActual();
			try {
				op.Alta_Prestamos(vp.JT[6].getText(),Double.parseDouble(vp.JT[1].getText()),Double.parseDouble(vp.JT[4].getText()),fecha ,(String) vp.Plazos.getSelectedItem(),vp.cajitas[0].getText() , 1, "No","Pendiente");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

            int fila = vp.Valuacion2.getRowCount();
            for(int i=0; i<fila;i++){
            		
            		Object fechaz = vp.modelo.getValueAt(i,1);
            		String fechas = String.valueOf(fechaz);
            		
            		Object interes = vp.modelo.getValueAt(i,2);
            		String interes_men = String.valueOf(interes);
            		
            		Object abo_cap = vp.modelo.getValueAt(i,3);
            		String abono_capital = String.valueOf(abo_cap);
            		
            		Object pago = vp.modelo.getValueAt(i,4);
            		String pago_rea = String.valueOf(pago);
            		
            		Object deuda = vp.modelo.getValueAt(i,5);
            		String deuda_act = String.valueOf(deuda);
            		
            		try {
						op.Alta_Tabla_Amortizacion(vp.JT[6].getText(), fecha, fechas, interes_men, abono_capital, pago_rea, deuda_act, "No Pagado");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

            }
			
			
			op.desconectar();
			
		}
		
	}
}
