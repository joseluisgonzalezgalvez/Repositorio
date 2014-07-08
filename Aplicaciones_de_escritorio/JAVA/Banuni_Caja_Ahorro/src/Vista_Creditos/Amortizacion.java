package Vista_Creditos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

public class Amortizacion {
	ManejadorFechas mf = new ManejadorFechas();
	Date Fechita;
	@SuppressWarnings({ "static-access" })
	public DefaultTableModel Calculos(double importe, double interes, double pago_acor,DefaultTableModel xx,int Plazos){
		String val;
		BigDecimal big;
		String retorno;
		int i=1;
		//double importe = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el importe"));
		//double interes = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el interers"));
		//double pago_acor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el pago acordado"));
		double interes_mensual = (interes/100) * importe;
		double abono_capital= (pago_acor-interes_mensual);
		double deuda_actual=importe-abono_capital;
		Fechita = mf.sumar_dias_fecha(mf.getFechaActual(),Plazos);
		Object cc[] = {i,Fechita ,"$"+interes_mensual,"$"+abono_capital,"$"+pago_acor,"$"+deuda_actual};
		xx.addRow(cc);	
		
		while(deuda_actual>0){
			i++;
		if(deuda_actual-abono_capital<=0){
			interes_mensual = (interes/100)*deuda_actual;
			val = interes_mensual+"";
			big = new BigDecimal(val);
			big = big.setScale(0, RoundingMode.HALF_EVEN);
			retorno = big+"";
			interes_mensual = Double.parseDouble(retorno);
			pago_acor= deuda_actual+interes_mensual;
			val = pago_acor+"";
			big = new BigDecimal(val);
			big = big.setScale(1, RoundingMode.HALF_EVEN);
			retorno = big+"";
			pago_acor = Double.parseDouble(retorno);
			abono_capital = pago_acor-interes_mensual;
			val = abono_capital+"";
			big = new BigDecimal(val);
			big = big.setScale(0, RoundingMode.HALF_EVEN);
			retorno = big+"";
			abono_capital = Double.parseDouble(retorno);
			deuda_actual= deuda_actual-abono_capital;
			Fechita = mf.sumar_dias_fecha(Fechita,Plazos);
			Object tt[] = {i,Fechita,"$"+interes_mensual,"$"+abono_capital,"$"+pago_acor,"$"+deuda_actual};
			xx.addRow(tt);
		}
		else{
			interes_mensual = (interes/100)*deuda_actual;
			val = interes_mensual+"";
			big = new BigDecimal(val);
			big = big.setScale(0, RoundingMode.HALF_EVEN);
			retorno = big+"";
			interes_mensual = Double.parseDouble(retorno);
			abono_capital = pago_acor-interes_mensual;
			val = pago_acor+"";
			big = new BigDecimal(val);
			big = big.setScale(1, RoundingMode.HALF_EVEN);
			retorno = big+"";
			pago_acor = Double.parseDouble(retorno);
			deuda_actual= deuda_actual-abono_capital;
			Fechita = mf.sumar_dias_fecha(Fechita,Plazos);
			Object tt[] = {i,Fechita,"$"+interes_mensual,"$"+abono_capital,"$"+pago_acor,"$"+deuda_actual};
			xx.addRow(tt);
			
		}
		}
		return xx;
		
	}
}


