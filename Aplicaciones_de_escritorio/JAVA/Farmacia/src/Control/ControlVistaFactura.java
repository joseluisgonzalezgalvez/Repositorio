package Control;

import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import Vistas.*;
import java.lang.Object;
import java.text.DecimalFormat;

public class ControlVistaFactura implements ActionListener,MouseListener{
    ///Object o = e.getSource();
    Vista_Factura vf;
    static double Subtotal_final=0.0;
    static double Subtotal=0.0;
    static int Canit=0;
    static int Activador=0;
    Base_Datos.Sentecias_BD Op;
    Validaciones.Validar_Datos validar;
    public ControlVistaFactura(Vista_Factura vf){
        this.vf= vf;
        Op = new Base_Datos.Sentecias_BD();
        validar = new Validaciones.Validar_Datos();
    }
    public void actionPerformed(ActionEvent e){
        
        
        JOptionPane.showMessageDialog(null,"El valor que ingresaste en cantidad es:" +Canit);
        String Selec=(String) vf.C.getSelectedItem();
        if(vf.JCK[0]==e.getSource()){
            if(vf.JCK[0].isSelected()==true){
                    //vf.JP[0].setVisible(true);
                    vf.JB[0].setEnabled(true);
                    vf.JT[0].setEnabled(true);
            }
            else{
                    //vf.JP[0].setVisible(false);
                    vf.JB[0].setEnabled(false);
                    vf.JT[0].setEnabled(false);
            }
        }
        if(vf.JCK[1]==e.getSource()){
            if(vf.JCK[1].isSelected()==true){
                for(int i=4;i<11;i++){
                    vf.JT[i].setEnabled(true);
                }
                for(int i=1;i<4;i++){
                    vf.JB[i].setEnabled(true);
                }
            }
            else{
                for(int i=4;i<11;i++){
                    vf.JT[i].setEnabled(false);
                }
                for(int i=1;i<4;i++){
                    vf.JB[i].setEnabled(false);
                }
            }
            
        }
        if(Selec!="")
        {
            vf.JT[13].setEnabled(true);
            vf.JB[8].setEnabled(true);
            vf.JCK[2].setEnabled(true);
            vf.JB[4].setEnabled(true);
            vf.JCK[3].setEnabled(true);
            vf.JB[5].setEnabled(true);
            vf.JB[6].setEnabled(true);
            vf.JB[7].setEnabled(true);
            vf.JB[9].setEnabled(true);
            vf.Valuacion2.setEnabled(true);

        }
        if(Selec.equals(""))
        {
            vf.JT[13].setEnabled(false);
            vf.JB[8].setEnabled(false);
            vf.JCK[2].setEnabled(false);
            vf.JB[4].setEnabled(false);
            vf.JCK[3].setEnabled(false);
            vf.JB[5].setEnabled(false);
            vf.JB[6].setEnabled(false);
            vf.JB[7].setEnabled(false);
            vf.JB[9].setEnabled(false);
            vf.Valuacion2.setEnabled(false);
            
        }
        if(vf.JB[8] == e.getSource()){
            //JOptionPane.showMessageDialog(null,vf.C.getSelectedItem());
            Consulta_Por_Campo((String) vf.C.getSelectedItem());
        }
        if(e.getSource() == vf.JCK[2]){
            if(vf.JCK[2].isSelected()== true){
                vf.Valuacion2.addMouseListener(this);
                vf.JCK[3].setSelected(false);
                Activador=1;
                
            }
            else{
                vf.Valuacion2.removeMouseListener(this);
            }
        }
        if(e.getSource() == vf.JCK[3]){
            if(vf.JCK[3].isSelected()== true){
                vf.Valuacion.addMouseListener(this);
                vf.JCK[2].setSelected(false);
                Activador=2;
            }
            else{
                vf.Valuacion.removeMouseListener(this);
            }
        }
    }
    public void Consulta_Por_Campo(String Campos){
            Op.Open();
            String Dato = vf.JT[13].getText();
            vf.Borrar_Productos();
            //JOptionPane.showMessageDialog(null, Dato);
            vf.Llenar_Tabla(Op.Llenar_Tabla_Producto_Consulta_Por_Factura(Campos, Dato));
            Op.Close();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
     if(Activador==1){
     

        String ColumintaSelec= (String) vf.C.getSelectedItem();
        int fila = vf.Valuacion2.rowAtPoint(e.getPoint());
        int columna = vf.Valuacion2.columnAtPoint(e.getPoint());
        if ((fila > -1) && (columna > -1)){
             Object Id =  vf.modelo.getValueAt(fila,0);
             String Con = String.valueOf(Id);
             int Id_Produc= Integer.parseInt(Con);
             int Bandera=1;
             String Cantidad_P=null;
             

             int seleccion = JOptionPane.showOptionDialog(null,"¿Agregar El Producto a La Compra?",   "Agregar Productos",   JOptionPane.YES_NO_CANCEL_OPTION,   JOptionPane.QUESTION_MESSAGE,   new ImageIcon("Salir.png"),new Object[] { "Si", "No" },null);
             if(seleccion+1 == 1){
                 boolean Condicion= true;
                 do{
                     Cantidad_P = JOptionPane.showInputDialog(null,"¿ Ingrese la Cantidad a Comprar del Producto?");
                     //JOptionPane.showMessageDialog(null,Cantidad_P);
                     if(Cantidad_P == null){
                         Condicion=true;
                     }
                     else{
                        if(validar.Validar_Numeros(Cantidad_P) == false){
                             Canit= Integer.parseInt(Cantidad_P);
                             //obteniendo el minimo del producto y el maximo del producto
                             Op.Open();
                             int Maxi =Op.Maximo(Id_Produc);
                             int Mini =Op.Minima(Id_Produc);
                             int Maa =Op.Cantid(Id_Produc);
                             //JOptionPane.showMessageDialog(null,Minia);
                             //JOptionPane.showMessageDialog(null,Maxia);
                             Op.Close();
                             
                             
                             JOptionPane.showMessageDialog(null,"Ingreso" +Canit);
                            // JOptionPane.showMessageDialog(null,"Maximo" +Maxia);
                            // JOptionPane.showMessageDialog(null,"Minimo"+Minia);
                             
                             if(Canit>0 && Canit<Maa){
                             JOptionPane.showMessageDialog(null,"Nu entrro");
                             Bandera=2;
                             Condicion = true;
                             }else{JOptionPane.showMessageDialog(null,"Cantidad Erronea");Condicion=false;}
                             //JOptionPane.showMessageDialog(null,Canit);
                             
                        }  
                        else{JOptionPane.showMessageDialog(null,"Error Ingrese Un Entero");
                        }
                     
                     }
                     
                 
                 }while(Condicion !=true);
                 if(Bandera==2){
                     String Name = (String) vf.modelo.getValueAt(fila,1);
                     String For_Far  = (String) vf.modelo.getValueAt(fila,3);
                     String Cant = (String) vf.modelo.getValueAt(fila,4);
                     
                     Object Exu = vf.modelo.getValueAt(fila,6);
                     String Exu2 = String.valueOf(Exu);
                     double Prec = Double.parseDouble(Exu2);
                     Subtotal = Prec * Canit;
                     Object x[]={Name,For_Far,Cant,Prec,Canit,Subtotal};
                     
                     Op.Open();
                     int cn= Op.Cantid(Id_Produc);
                    try {
                        //Modificar Cantidad
                        JOptionPane.showMessageDialog(null,"Modificar" +cn);
                        Op.Modificar_Cantidad(Id_Produc,cn-Canit);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControlVistaFactura.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     Op.Close();
                     Consulta_Por_Campo((String) vf.C.getSelectedItem());
                     
                     vf.modelo2.addRow(x);
                     DecimalFormat df = new DecimalFormat("0.00"); 
                     Subtotal_final=Subtotal_final+Subtotal;
                     vf.JT[14].setText(""+df.format(Subtotal_final));
                     
                     
                     
                 }
             }
             else{
             }
         }
     
     }
     if(Activador==2){
     

        int fila2 = vf.Valuacion.rowAtPoint(e.getPoint());
        int columna2 = vf.Valuacion.columnAtPoint(e.getPoint());
        
        if ((fila2 > -1) && (columna2 > -1)){
            JOptionPane.showMessageDialog(null, columna2);
             Object Id =  vf.modelo.getValueAt(fila2,0);
             String Con = String.valueOf(Id);
             int Id_Produc= Integer.parseInt(Con);
            int sele = JOptionPane.showOptionDialog(null,"¿Quitar de Lista de Compra?",   "Quitar Productos",   JOptionPane.YES_NO_CANCEL_OPTION,   JOptionPane.QUESTION_MESSAGE,   new ImageIcon("Salir.png"),new Object[] { "Si", "No" },null);
            if(sele+1 ==1){
                     Op.Open();
                     int cn= Op.Cantid(Id_Produc);
                    try {
                        //Modificar Cantidad
                        Op.Modificar_Cantidad(Id_Produc,cn+Canit);
                        
                        //Regresar el valor del subtotal y del total y eliminar el registro
                        Subtotal_final=Subtotal_final-Subtotal;
                        DecimalFormat df = new DecimalFormat("0.00"); 
                        vf.JT[14].setText(""+df.format(Subtotal_final));
                        vf.modelo2.removeRow(fila2);
                        
                        
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ControlVistaFactura.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     Op.Close();
                     Consulta_Por_Campo((String) vf.C.getSelectedItem());
            }
            else{}
        }
     
     }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}
