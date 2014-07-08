/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vistas.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Base_Datos.*;
import Validaciones.*;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
/**
 *
 * @author Administrador
 */
public class Control_Vista_Provedor implements ActionListener,MouseListener{
    VistaProvedor Vp;
    int Ban =2;
    static int Bande=0;
    static int Ba=0;
    static int Banderita=0;
    Validar_Datos v = new Validar_Datos();
    Sentecias_BD Op;
    
    
    public Control_Vista_Provedor(VistaProvedor Vp){
        this.Vp=Vp;
        Op = new Sentecias_BD();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String x= (String) Vp.C.getSelectedItem();
        if(x.equals("")){
            Vp.Validax.setEnabled(false);
            Vp.Jt[0].setEnabled(true);
            Vp.Jt[1].setEnabled(true);
            Vp.Jt[2].setEnabled(true);
            Vp.Jt[3].setEnabled(true);
            Vp.JB[0].setEnabled(true);
            Vp.JB[1].setEnabled(true);
            Vp.JT[0].setEnabled(false);
            Vp.JB[2].setEnabled(false);
            Vp.JB[3].setEnabled(false);
            Vp.JB[5].setEnabled(false);
            Vp.JB[6].setEnabled(false);
            Vp.Validax.setEnabled(false);
            //Vp.Valuacion2.removeMouseListener( new Control_Vista_Provedor(this));
        }
        if(x.equals("Id_Provedor") || x.equals("Nombre_Provedor") || x.equals("Direccion") || x.equals("Telefono") || x.equals("Empresa")){
            Limpiare();
            
            Vp.Jt[0].setEnabled(false);
            Vp.Jt[1].setEnabled(false);
            Vp.Jt[2].setEnabled(false);
            Vp.Jt[3].setEnabled(false);
            
            
            Vp.Borrar_Provedores();
            Vp.JB[0].setEnabled(false);
            Vp.JB[1].setEnabled(false);
            Vp.JT[0].setEnabled(true);
            Vp.JB[2].setEnabled(false);
            Vp.JB[3].setEnabled(true);
            Vp.JB[5].setEnabled(false);
            Vp.JB[6].setEnabled(false);
            Vp.Validax.setEnabled(true);
        
        }
//        if(Vp.Veri.isSelected()==false){Vp.Borrar_Provedores();}
//        if(Vp.Veri.isSelected()==true){Vp.Llenar_Tabla(Op.Llenar_Tabla_Profesor());}
        if(e.getSource() == Vp.Validax){
            Vp.Valuacion2.setEnabled(true);
            Consulta_Por_Campo(x);
            if(Vp.Validax.isSelected()==true){
                Vp.Valuacion2.addMouseListener(this);
                Vp.Valuacion2.setEnabled(true);
            }
            else{
                Vp.Valuacion2.removeMouseListener(this);
                Vp.Valuacion2.setEnabled(false);
            }
        }
        if(e.getSource()== Vp.JB[1]){
                Limpiare();
        }
        
        if(e.getSource()==Vp.JB[3]){
            Consulta_Por_Campo(x);
            Vp.Validax.setEnabled(true);
            Vp.Valuacion2.setEnabled(false);
            Vp.JB[2].setEnabled(true);
            Vp.JB[6].setEnabled(true);
            Vp.Valuacion2.removeMouseListener(this);
            
        }
        if(e.getSource()==Vp.JB[2]){
            Consulta_Por_Campo(x);
            Vp.Valuacion2.addMouseListener(this);
            
        }       
        if(e.getSource()==Vp.JB[6]){
            Consulta_Por_Campo(x);
            Vp.Valuacion2.addMouseListener(this);
            
        }               
        if(e.getSource() == Vp.Veri){
           // JOptionPane.showMessageDialog(null,"Entro");
            if(Vp.Veri.isSelected()==true){
                Op.Open();
                Vp.Llenar_Tabla(Op.Llenar_Tabla_Profesor());
                Op.Close();
            }
            if(Vp.Veri.isSelected()==false){
                Vp.Borrar_Provedores();
            }
        }
        
        
        if(e.getSource() == Vp.JB[0]){
                String Nombre = Vp.Jt[0].getText();
                String Empresa = Vp.Jt[1].getText();
                String Direccion = Vp.Jt[2].getText();
                String Telefono = Vp.Jt[3].getText();
                if(v.Validar_Letras(Nombre)==false){
                    if(v.Validar_Letras(Empresa)==false){
                        if(v.Validar_Direccion(Direccion)==false){
                            if(v.Validar_Telefonos(Telefono)==false){
                                Op.Open();
                                    try {
                                            Op.Alta_Provedor(Nombre, Empresa, Direccion, Telefono);
                                            JOptionPane.showMessageDialog(null,"          Provedor Agregado","VALIDADO",JOptionPane.PLAIN_MESSAGE);
                                            Limpiare();
                                            Vp.Borrar_Provedores();
                                            Vp.Llenar_Tabla(Op.Llenar_Tabla_Profesor());
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Control_Vista_Provedor.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                Op.Close();
                            }
                            else
                                JOptionPane.showMessageDialog(null,"Telefono Incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Direccion Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Empresa Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Nombre Incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Limpiare(){
            Vp.Jt[0].setText("");
            Vp.Jt[1].setText("");
            Vp.Jt[2].setText("");
            Vp.Jt[3].setText("");
    }
    public void Consulta_Por_Campo(String Campos){
            Op.Open();
            String Dato = Vp.JT[0].getText();
            Vp.Llenar_Tabla(Op.Llenar_Tabla_Profesor_Consulta(Campos,Dato));
            Op.Close();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        String x= (String) Vp.C.getSelectedItem();
         int fila = Vp.Valuacion2.rowAtPoint(e.getPoint());
         int columna = Vp.Valuacion2.columnAtPoint(e.getPoint());
         if ((fila > -1) && (columna > -1)){
             Object Id =  Vp.modelo.getValueAt(fila,0);
             String Con = String.valueOf(Id);
             String Nuevo_Valor=null;
             int Valore = Integer.parseInt(Con);
             int seleccion = JOptionPane.showOptionDialog(null," !! Seleccione Una Opcion !!",   "Eliminar/Modificar",   JOptionPane.YES_NO_CANCEL_OPTION,   JOptionPane.QUESTION_MESSAGE,   new ImageIcon("Salir.png"),new Object[] { "Eliminar", "Modificar", "Cancelar" },null);
             if(seleccion+1==2){
                 String Columna =(String) Vp.modelo.getColumnName(columna);
                 int Acceso=0;
                 boolean Reques=true;
                 do{
                     Nuevo_Valor = JOptionPane.showInputDialog(null,"Nuevo Valor Para Campo "+Columna+":",JOptionPane.QUESTION_MESSAGE);
                     
                     if(Nuevo_Valor == null){Reques=true;Acceso=2;Columna=Columna+" ";}
                     if(Columna.equals("Nombre_Provedor") || Columna.equals("Empresa")){
                         if(v.Validar_Letras(Nuevo_Valor)==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Direccion")){
                         if(v.Validar_Direccion(Nuevo_Valor)==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Telefono")){
                         if(v.Validar_Telefonos(Nuevo_Valor)==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Id_Provedor")){
                             Reques=true;
                             Acceso=2;
                     }
                     if(Columna.equals("")){
                         Reques=true;
                     }                     
                 }while(Reques!=true);
                 if(Acceso==0){
                              JOptionPane.showMessageDialog(null,"Dato Correcto");
                              Op.Open();
                              Vp.modelo.setValueAt(Nuevo_Valor,fila, columna);//Este es solo para modificar
                              try {
                                    Op.Modificar_Provedor(Vp.modelo.getColumnName(columna), Nuevo_Valor,Valore);
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
                                    Op.Eliminar_Provedor(Valore);
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
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
