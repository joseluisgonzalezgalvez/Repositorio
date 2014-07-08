/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vistas.VistaEmpleado;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrador
 */
public class Control_Vista_Empleado implements ActionListener,MouseListener{
    VistaEmpleado Ve;
    Validaciones.Validar_Datos va= new Validaciones.Validar_Datos();
    Base_Datos.Sentecias_BD Op= new Base_Datos.Sentecias_BD();
    public Control_Vista_Empleado(Vistas.VistaEmpleado Ve){
        this.Ve= Ve;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        String Selec = (String) Ve.A.getSelectedItem();
        String Selec2 = (String) Ve.C.getSelectedItem(); 
        
        
        if(Selec.equals("Medico")){
                Ve.JT[4].setVisible(true);
                Ve.JT[5].setVisible(true);
                Ve.JP[4].setVisible(true);
        }
        if(Selec.equals("")){
                Ve.JT[4].setVisible(false);
                Ve.JT[5].setVisible(false);
                Ve.JP[4].setVisible(false);
        }
        if(Selec.equals("Servicio") || Selec.equals("Cajero") || Selec.equals("Almacenista")|| Selec.equals("Con Poder")){
                Ve.JT[4].setVisible(false);
                Ve.JT[5].setVisible(false);
                Ve.JP[4].setVisible(false);
        }
        
        
        if(Selec2.equals("")){
            Ve.JB[3].setEnabled(false);
            Ve.Verix.setEnabled(false);
            Ve.JT[0].setEnabled(false);
        }
        if(Selec2.equals("Id_Empleado") || Selec2.equals("Nombre_Empleado") || Selec2.equals("Direccion_Empleado")|| Selec2.equals("Telefono_Empleado")|| Selec2.equals("Especialidad")|| Selec2.equals("Cedula_Profesional")){
            Ve.JB[3].setEnabled(true);
            Ve.Verix.setEnabled(true);
            Ve.JT[0].setEnabled(true);
        }
        
        if(Ve.JB[1] == e.getSource()){
           for(int i=0; i<10; i++){
            Ve.JT[i].setText("");
            
            }
           Ve.Jt[0].setText("");
           Ve.Jt[1].setText("");
           Ve.Contra.setText("");
           Ve.Contra2.setText("");
        }
        
        if(Ve.JB[3] == e.getSource()){
            JOptionPane.showMessageDialog(null,"Entro");
            Consulta_Por_Campo(Selec2);
        }
        
        if(e.getSource() == Ve.Veri){
           // JOptionPane.showMessageDialog(null,"Entro");
            if(Ve.Veri.isSelected()==true){
                Op.Open();
                Ve.Llenar_Tabla_Empleados(Op.Llenar_Tabla_Empleado());
                Op.Close();
            }
            if(Ve.Veri.isSelected()==false){
                Ve.Borrar_Empleados();
            }
        }
        
        
       if(Ve.JB[0] == e.getSource()){
           String Name = Ve.Jt[0].getText();
           String Dire = Ve.Jt[1].getText();
           String Tele = Ve.JT[1].getText();
           String Contra1 = Ve.Contra.getText();
           String Contra2 = Ve.Contra2.getText();
           String Especilidad = Ve.JT[4].getText();
           String Cedula = Ve.JT[5].getText();
           
           if(Contra1.equals(Contra2)){
               if(va.Validar_Letras(Name)== false){
                   if(va.Validar_Direccion(Dire)==false){
                       if(va.Validar_Telefonos(Tele)==false){
                           if(Especilidad.equals("") && Cedula.equals("")){
                               //Alta de empleado sin cedula
                               
                                        Op.Open();
                                        try {
                                            Op.Alta_Empleado2(Name, Dire, Tele, Selec, " "," ", Contra2);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(Control_Vista_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                       Op.Close();
                               
                           }
                           else{
                               if(va.Validar_Letras(Especilidad)==false){
                                   if(va.Validar_cedula(Cedula)==false){
                                       
                                       //* empezamos a dar de alta
                                       Op.Open();
                                        try {
                                            Op.Alta_Empleado2(Name, Dire, Tele, Selec, Cedula, Especilidad, Contra2);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(Control_Vista_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                       Op.Close();
                                       //Ve.Borrar_Empleados();
                                       //Ve.Llenar_Tabla_Empleados();
                                       
                                   }else{
                                       JOptionPane.showMessageDialog(null,"Cedula No Valida");
                                   }
                                   
                               }
                               else{
                                    JOptionPane.showMessageDialog(null,"Especialidad No Valido");
                               }
                           }
                           
                       }else{
                            JOptionPane.showMessageDialog(null,"Telefono No Valido");
                       }
                   
                   }else{
                       JOptionPane.showMessageDialog(null,"Direccion No Valido");
                   }
               }
               else{
                   JOptionPane.showMessageDialog(null,"Nombre No Valido");
               }
           }
           else{
               JOptionPane.showMessageDialog(null,"La contraseña no es igual");
           }
           
           
           if(va.Validar_Letras(Name))
           {
           }
           
           JOptionPane.showMessageDialog(null,Name+" "+Dire+" "+Tele+" "+Contra1+" "+Contra2+" "+Especilidad+" "+Cedula);
                 
           
        }

    }
    
    
    
        public void Consulta_Por_Campo(String Campos){
            Op.Open();
            String Dato = Ve.JT[0].getText();
            //JOptionPane.showMessageDialog(null,Dato);
            Ve.Borrar_Empleados();
            Ve.Llenar_Tabla_Empleados(Op.Llenar_Tabla_Empleado_Consulta(Campos, Dato));
            Op.Close();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         String x = (String) Ve.C.getSelectedItem(); 
         int fila = Ve.Valuacion2.rowAtPoint(e.getPoint());
         int columna = Ve.Valuacion2.columnAtPoint(e.getPoint());
         if ((fila > -1) && (columna > -1)){
             Object Id =  Ve.modelo.getValueAt(fila,0);
             String Con = String.valueOf(Id);
             String Nuevo_Valor=null;
             int Valore = Integer.parseInt(Con);
             int seleccion = JOptionPane.showOptionDialog(null," !! Seleccione Una Opcion !!",   "Eliminar/Modificar",   JOptionPane.YES_NO_CANCEL_OPTION,   JOptionPane.QUESTION_MESSAGE,   new ImageIcon("Salir.png"),new Object[] { "Eliminar", "Modificar", "Cancelar" },null);
             if(seleccion+1==2){
                 String Columna =(String) Ve.modelo.getColumnName(columna);
                 int Acceso=0;
                 boolean Reques=true;
                 do{
                     Nuevo_Valor = JOptionPane.showInputDialog(null,"Nuevo Valor Para Campo "+Columna+":",JOptionPane.QUESTION_MESSAGE);
                     
                     if(Nuevo_Valor == null){Reques=true;Acceso=2;Columna=Columna+" ";}
                     if(Columna.equals("Nombre_Empleado") || Columna.equals("Empresa")){
                         if(va.Validar_Letras(Nuevo_Valor)==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Direccion_Empleado")){
                         if(va.Validar_Direccion(Nuevo_Valor)==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Telefono_Empleado")){
                         if(va.Validar_Telefonos(Nuevo_Valor)==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Puesto")){
                         if(va.Validar_Letras(Nuevo_Valor)==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Cedula_Profesional")){
                         if(va.Validar_cedula(Nuevo_Valor)==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     
                     if(Columna.equals("Especialidad")){
                         if(va.Validar_Letras(Nuevo_Valor)==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     
                     if(Columna.equals("Contrasenia")){
                         
                             Reques=true;
                         
                     }
                     if(Columna.equals("")){
                         Reques=true;
                     }                     
                 }while(Reques!=true);
                 if(Acceso==0){
                              JOptionPane.showMessageDialog(null,"Dato Correcto");
                              Op.Open();
                              Ve.modelo.setValueAt(Nuevo_Valor,fila, columna);//Este es solo para modificar
                              try {
                                    Op.Modificar_Empleado(Ve.modelo.getColumnName(columna), Nuevo_Valor,Valore);
                              } catch (SQLException ex) {
                                        Logger.getLogger(Control_Vista_Provedor.class.getName()).log(Level.SEVERE, null, ex);
                              }
                              Op.Close();
                      
                 }
                 else{JOptionPane.showMessageDialog(null,"No Se Modifico El Campo "+Columna+"");}
                     
                        
             }
             if(seleccion+1==1){
                 int confirmado = JOptionPane.showConfirmDialog(null,"¿Confirma La Eliminacion?");   
                 if (JOptionPane.OK_OPTION == confirmado){
                              Op.Open();
                              try {
                                    Op.Eliminar_Empleado(Valore);
//                                    Vp.Borrar_Provedores();
//                                    Vp.Llenar_Tabla(Op.Llenar_Tabla_Profesor());
                                    Consulta_Por_Campo(x);
                              } catch (SQLException ex) {
                                        Logger.getLogger(Control_Vista_Provedor.class.getName()).log(Level.SEVERE, null, ex);
                              }
                              Op.Close();
                 }else{JOptionPane.showMessageDialog(null,"!! No se Elimino El Registro !!");
                 }          
             }
             if(seleccion+1==3){
             
             }
         }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}


