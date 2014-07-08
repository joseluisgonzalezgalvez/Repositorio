/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vistas.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrador
 */
public class Control_Consulta_Medica implements ActionListener{
    Vista_Consulta_Medica Vm;
    Base_Datos.Sentecias_BD Op = new Base_Datos.Sentecias_BD();
    Validaciones.Validar_Datos Va= new Validaciones.Validar_Datos();
    public Control_Consulta_Medica(Vista_Consulta_Medica Vm){
        this.Vm = Vm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Vm.JB[1] ){
            
             for(int i=0;i<12;i++){
                    Vm.JT[i].setText("");
             }
            
        }
        
        if(e.getSource() == Vm.JB[0]){
            String Nombre = Vm.JT[4].getText();
            String Direcc = Vm.JT[5].getText();
            String Ciudad = Vm.JT[6].getText();
            String Telefono = Vm.JT[7].getText();
            String Edad = Vm.JT[8].getText();
            
            String Peso = Vm.JT[10].getText();
            String Altura = Vm.JT[11].getText();
            
            if(Va.Validar_Letras(Nombre)== false){
                if(Va.Validar_Direccion(Direcc)==false){
                    if(Va.Validar_Letras(Ciudad)== false){
                        if(Va.Validar_Telefonos(Telefono)==false){
                            if(Va.Validar_Numeros(Edad)==false){
                                if(Va.Validar_Precios(Peso)==false){
                                    if(Va.Validar_Precios(Altura)==false && Double.parseDouble(Altura)<2.45){
                                            //******** Empezamos a dar de alta
                                            Op.Open();
                                        try {
                                            Op.Alta_Paciente(Nombre, Direcc, Ciudad, Telefono, Integer.parseInt(Edad),(String) Vm.Sexi.getSelectedItem(), Double.parseDouble(Peso), Double.parseDouble(Altura),Vm.textarea.getText());
                                            String i = Op.Obtener_Id(Vm.JT[13].getText());
                                            JOptionPane.showMessageDialog(null,i);
                                            
                                            String x = Op.Obtener_Id_Paciente(Nombre);
                                            JOptionPane.showMessageDialog(null,x);
                                            
                                            JOptionPane.showMessageDialog(null,Integer.parseInt(i));
                                            JOptionPane.showMessageDialog(null,Integer.parseInt(x));
                                            Op.Alta_receta(Integer.parseInt(i),Integer.parseInt(x),Vm.textarea.getText());
                                            
                                        } catch (SQLException ex) {
                                            Logger.getLogger(Control_Consulta_Medica.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                            Op.Close();
                                            
                                            //***************** Imprimir Reporte Medico
                                            
                                            
                                            
                                            //**********************************
                                            
                                            
                                            
                                       }
                                       else{
                                        JOptionPane.showMessageDialog(null,"Altura Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
                                      }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Peso Incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);

                                }
                            }
                            else{
                               JOptionPane.showMessageDialog(null,"Edad Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Telefono Incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Direccion Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Direccion Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
              JOptionPane.showMessageDialog(null,"Nombre Incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
