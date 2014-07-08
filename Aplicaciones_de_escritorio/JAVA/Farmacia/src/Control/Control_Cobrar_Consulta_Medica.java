/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Control_Cobrar_Consulta_Medica implements ActionListener{
    Vistas.Cobrar_Receta_Medica cr;
    Validaciones.Validar_Datos va = new Validaciones.Validar_Datos();
    Base_Datos.Sentecias_BD Op;
    public Control_Cobrar_Consulta_Medica(Vistas.Cobrar_Receta_Medica cr){
        this.cr=cr;
        Op = new Base_Datos.Sentecias_BD();
    }
    
    void Limpiar(){
            for(int i=0;i<20;i++){
                cr.JT[i].setText("");
            }
    }
    void Consulta(String Code){
                    int x=0;
                    int Precio= 50;
                    Op.Open();
                    int Cod = Integer.parseInt(Code);
                    x =Op.Obtener_Dato_Receta("Id_Paciente",Cod);
                    cr.JT[5].setText(Op.Obtener_Paciente("Nombre_Paciente",x));
                    cr.JT[6].setText(Op.Obtener_Paciente("Direccion",x));
                    cr.JT[8].setText(Op.Obtener_Rece("Pagado", Cod));
                    String v = cr.JT[8].getText();
                    //JOptionPane.showMessageDialog(null,v);
                    if(v.equals("Si")){
                      //  JOptionPane.showMessageDialog(null,"Entro");
                        cr.JT[10].setEnabled(false);
                        cr.JT[11].setEnabled(false);
                        cr.JB[0].setEnabled(false);
                        cr.JT[10].setText(Op.Obtener_Rece("Efectivo", Cod));
                        cr.JT[11].setText(Op.Obtener_Rece("Cambio", Cod));
                        
                    }else{
                        cr.JT[10].setEnabled(true);
                        cr.JT[11].setEnabled(true);
                        cr.JB[0].setEnabled(true);
                    }
                    cr.JT[9].setText(""+Precio);
                    
                    int mm= Op.Obtener_Dato_Receta("Id_Empleado", Cod);
                    
                    String Nombre_Usuario = Op.Obtener_Name(""+mm+"");
                    
                    cr.JT[12].setText(Op.Obtener_Id(Nombre_Usuario));
                    cr.JT[13].setText(Nombre_Usuario);
                    cr.JT[14].setText(Op.Obtener_Especialidad(Nombre_Usuario));
                    cr.JT[15].setText(Op.Obtener_Cedula(Nombre_Usuario));
                    Op.Close();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(cr.JB[1] == e.getSource()){
           Limpiar();
        }
        if(cr.JB[0]== e.getSource()){
            String x = cr.JT[10].getText();
            if(va.Validar_Precios(x)==false){
                //if((cr.JT[4].getText()).equals("")){
                    double efe = Double.parseDouble(x);
                    double Precio= 50.00;
                    DecimalFormat df = new DecimalFormat("0.00"); 
                    if(efe>=50){
                            int confirmado = JOptionPane.showConfirmDialog(null,"¿Confirma El Cobro?");   
                            if (JOptionPane.OK_OPTION == confirmado){
                            double cambio= efe-Precio;
                            cr.JT[11].setText(df.format(cambio));
                            Op.Open();
                            try {
                                Op.Modificar_Dato_Consulta(Precio,efe, cambio,"Si","No", Integer.parseInt(cr.JT[4].getText()));
                            } catch (SQLException ex) {
                                Logger.getLogger(Control_Cobrar_Consulta_Medica.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Op.Close();
                            Consulta(cr.JT[4].getText());
                        }else{JOptionPane.showMessageDialog(null,"!! No Se Cobro La Consulta !!");
                        }          
                    }else{
                        JOptionPane.showMessageDialog(null,"Cantidad Insuficiente Para Pagar");
                    }
                //}
                //else{
//                    JOptionPane.showMessageDialog(null, "Ingrese Codigo de Factura");
//                }
            }
            else{JOptionPane.showMessageDialog(null,"Precio Incorrecto");
            }
        }
        if(cr.JB[2] == e.getSource()){
            String Code=cr.JT[4].getText();
            String Efectivo=cr.JT[10].getText();
            if(va.Validar_Numeros(Code)==false){
//                Limpiar();
                Consulta(Code);
            }
            else{
                JOptionPane.showMessageDialog(null,"Ingrese Numero Receta");
            }
        }
        
    }
    
}
