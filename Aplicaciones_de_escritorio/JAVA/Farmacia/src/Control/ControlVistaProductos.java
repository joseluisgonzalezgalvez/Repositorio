/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Vistas.*;
import Validaciones.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
/**
 *
 * @author Sala3_02
 */
public class ControlVistaProductos implements ActionListener,ItemListener,MouseListener{
    VistaProducto pp;
    Validar_Datos Vd= new Validar_Datos();
    Base_Datos.Sentecias_BD Op;
    int ban=2;
    public ControlVistaProductos(VistaProducto pp){
        this.pp=pp;
        Op = new Base_Datos.Sentecias_BD();
//        JOptionPane.showMessageDialog(null,"HOla bonito");
    }
    public void Limpiar_Formulario(){
            pp.Imagen.setText("");
            pp.Jt[0].setText("");
            pp.Jt[1].setText("");
            pp.A.setSelectedIndex(0);
            pp.Jt[3].setText("");
            pp.JB[1].setEnabled(true);
            pp.Jt[4].setText("");
            pp.Jt[5].setText("");
            pp.val.setSelectedItem(0);
            pp.ml.setSelectedItem(0);
            //********* Panel de Datos Bodega
            pp.Jt[7].setText("");
            pp.Jt[8].setText("");
            pp.Jt[9].setText("");
            //********* Panel de Datos Proveedor
            
            pp.Jt[11].setText("");
            pp.Jt[12].setText("");
            
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        String Selecci = (String) pp.B.getSelectedItem();
        String dos = (String) pp.C.getSelectedItem();
        if(dos.equals("")){
            pp.Imagen.setEnabled(true);
            pp.Validax.setEnabled(false);
  //          pp.Veri.setEnabled(true);
            //********* Panel de Datos Productos
            pp.Jt[0].setEnabled(true);
            pp.Jt[1].setEnabled(true);
            pp.A.setEnabled(true);
            pp.Jt[3].setEnabled(false);
            pp.JB[1].setEnabled(true);
            pp.Jt[4].setEnabled(true);
            pp.Jt[5].setEnabled(true);
            pp.val.setEnabled(true);
            pp.ml.setEnabled(true);
            pp.JB[12].setEnabled(true);
            //********* Panel de Datos Bodega
            pp.Jt[7].setEnabled(true);
            pp.Jt[8].setEnabled(true);
            pp.Jt[9].setEnabled(true);
            //********* Panel de Datos Proveedor
            
            pp.Jt[11].setEnabled(false);
            pp.Jt[12].setEnabled(false);
            
            pp.B.setEnabled(true);
            //********* Panel de Consultas
            pp.C.setEnabled(true);
            pp.JB[0].setVisible(false);
            pp.JT[1].setVisible(false);
            pp.JB[0].setEnabled(false);
            pp.JT[1].setEnabled(false);
            
            pp.JT[0].setEnabled(false);
            pp.D.setEnabled(false);
            pp.D.setVisible(false);
            
            pp.JB[2].setEnabled(false);
            pp.JT[2].setEnabled(false);            
            pp.JB[2].setVisible(false);
            pp.JT[2].setVisible(false);
            
            //********* Panel de Acciones
            pp.JB[3].setEnabled(false);
            pp.JB[4].setEnabled(true);
            pp.JB[5].setEnabled(true);
            //pp.Veri.setEnabled(false);
            pp.JB[6].setEnabled(false);
            pp.JB[7].setEnabled(false);
            pp.JB[8].setEnabled(false);
            pp.JB[9].setEnabled(false);
            //********* Panel Tabla
            pp.Valuacion2.setEnabled(false);
            
        }
        
        if(dos.equals("Forma_Farmaceutica")){
            pp.Imagen.setEnabled(false);
            pp.Validax.setEnabled(true);
            pp.B.setEnabled(false);
            //pp.D.setSelectedIndex(0);
            //********* Panel de Datos Productos
            pp.Jt[0].setEnabled(false);
            pp.Jt[1].setEnabled(false);
            pp.A.setEnabled(false);
            pp.Jt[3].setEnabled(false);
            pp.JB[1].setEnabled(false);
            pp.Jt[4].setEnabled(false);
            pp.Jt[5].setEnabled(false);
            pp.val.setEnabled(false);
            pp.ml.setEnabled(false);
            pp.JB[12].setEnabled(false);
            //********* Panel de Datos Bodega
            pp.Jt[7].setEnabled(false);
            pp.Jt[8].setEnabled(false);
            pp.Jt[9].setEnabled(false);
            //********* Panel de Datos Proveedor
            
            pp.Jt[11].setEnabled(true);
            pp.Jt[12].setEnabled(true);
            
            //********* Panel de Consultas
            pp.C.setEnabled(true);
            pp.JB[0].setVisible(false);
            pp.JT[1].setVisible(false);
            pp.JB[0].setEnabled(false);
            pp.JT[1].setEnabled(false);
            
            pp.JT[0].setEnabled(false);
            pp.JT[0].setVisible(false);
            pp.D.setEnabled(true);
            pp.D.setVisible(true);
            
            pp.JB[2].setEnabled(false);
            pp.JT[2].setEnabled(false);            
            pp.JB[2].setVisible(false);
            pp.JT[2].setVisible(false);
            
            //********* Panel de Acciones
            pp.JB[3].setEnabled(false);
            pp.JB[4].setEnabled(false);
            pp.JB[5].setEnabled(false);
            //pp.Veri.setEnabled(true);
            pp.JB[6].setEnabled(true);
            pp.JB[7].setEnabled(true);
            pp.JB[8].setEnabled(false);
            pp.JB[9].setEnabled(false);
            //********* Panel Tabla
            pp.Valuacion2.setEnabled(false);
        }
        
        
        
        if(e.getSource() == pp.Veri){
           // JOptionPane.showMessageDialog(null,"Entro");
            if(pp.Veri.isSelected()==true){
                Op.Open();
                
                //Consulta_Por_Campo((String) pp.C.getSelectedItem());
                pp.Llenar_Tabla(Op.Llenar_Tabla_Producto());
                Op.Close();
            }
            if(pp.Veri.isSelected()==false){
                pp.Borrar_Productos();
            }
        }
        
        if(dos.equals("Id_Producto") || dos.equals("Nombre_Producto") || dos.equals("Precio") || dos.equals("Cantidad_Producto") || dos.equals("Existencia_Minima") || dos.equals("Existencia_Maxima") ){
            pp.B.setEnabled(false);
            pp.Imagen.setEnabled(false);
            pp.Validax.setEnabled(true);
            //********* Panel de Datos Productos
            pp.Jt[0].setEnabled(false);
            pp.Jt[1].setEnabled(false);
            pp.A.setEnabled(false);
            pp.Jt[3].setEnabled(false);
            pp.JB[1].setEnabled(false);
            pp.Jt[4].setEnabled(false);
            pp.Jt[5].setEnabled(false);
            pp.val.setEnabled(false);
            pp.ml.setEnabled(false);
            pp.JB[12].setEnabled(false);
            //********* Panel de Datos Bodega
            pp.Jt[7].setEnabled(false);
            pp.Jt[8].setEnabled(false);
            pp.Jt[9].setEnabled(false);
            //********* Panel de Datos Proveedor
            pp.B.setEnabled(false);
            pp.Jt[11].setEnabled(false);
            pp.Jt[12].setEnabled(false);
            
            //********* Panel de Consultas
            pp.C.setEnabled(true);
            pp.JB[0].setVisible(false);
            pp.JT[1].setVisible(false);
            pp.JB[0].setEnabled(false);
            pp.JT[1].setEnabled(false);
            //pp.JT[0].setText("");
            pp.JT[0].setEnabled(true);
            pp.JT[0].setVisible(true);
            pp.D.setEnabled(false);
            pp.D.setVisible(false);
            
            pp.JB[2].setEnabled(false);
            pp.JT[2].setEnabled(false);            
            pp.JB[2].setVisible(false);
            pp.JT[2].setVisible(false);
            
            //********* Panel de Acciones
            pp.JB[3].setEnabled(false);
            pp.JB[4].setEnabled(false);
            pp.JB[5].setEnabled(false);
            //pp.Veri.setEnabled(true);
            pp.JB[6].setEnabled(true);
            pp.JB[7].setEnabled(true);
            pp.JB[8].setEnabled(false);
            pp.JB[9].setEnabled(false);
            //********* Panel Tabla
            pp.Valuacion2.setEnabled(false);
        }
        if(dos.equals("Fecha_Caducidad")){
            pp.Imagen.setEnabled(false);
            pp.Validax.setEnabled(true);
            //********* Panel de Datos Productos
            pp.Jt[0].setEnabled(false);
            pp.Jt[1].setEnabled(false);
            pp.A.setEnabled(false);
            pp.Jt[3].setEnabled(false);
            pp.JB[1].setEnabled(false);
            pp.Jt[4].setEnabled(false);
            pp.Jt[5].setEnabled(false);
            pp.val.setEnabled(false);
            pp.ml.setEnabled(false);
            pp.JB[12].setEnabled(false);
            //********* Panel de Datos Bodega
            pp.Jt[7].setEnabled(false);
            pp.Jt[8].setEnabled(false);
            pp.Jt[9].setEnabled(false);
            //********* Panel de Datos Proveedor
            pp.B.setEnabled(false);
            pp.Jt[11].setEnabled(false);
            pp.Jt[12].setEnabled(false);
            //********* Panel de Consultas
            pp.C.setEnabled(true);
            pp.JB[0].setVisible(true);
            pp.JT[1].setVisible(true);
            pp.JB[0].setEnabled(true);
            pp.JT[1].setEnabled(false);
            /*
            pp.JT[1].setText("");
            pp.JT[2].setText("");
            */
            pp.JT[0].setEnabled(false);
            pp.JT[0].setVisible(false);
            pp.D.setEnabled(false);
            pp.D.setVisible(false);
            
            pp.JB[2].setEnabled(true);
            pp.JT[2].setEnabled(false);            
            pp.JB[2].setVisible(true);
            pp.JT[2].setVisible(true);
            
            //********* Panel de Acciones
            pp.JB[3].setEnabled(false);
            pp.JB[4].setEnabled(false);
            pp.JB[5].setEnabled(false);
           // pp.Veri.setEnabled(true);
            pp.JB[6].setEnabled(true);
            pp.JB[7].setEnabled(true);
            pp.JB[8].setEnabled(false);
            pp.JB[9].setEnabled(false);
            //********* Panel Tabla
            pp.Valuacion2.setEnabled(false);
        }
        
        
        if(e.getSource() == pp.Validax){
            pp.Valuacion2.setEnabled(true);
            
            if(pp.Validax.isSelected()==true){
                Consulta_Por_Campo((String) pp.C.getSelectedItem());
                pp.Valuacion2.addMouseListener(this);
                pp.Valuacion2.setEnabled(true);
            }
            else{
                Consulta_Por_Campo((String) pp.C.getSelectedItem());
                pp.Valuacion2.removeMouseListener(this);
                pp.Valuacion2.setEnabled(false);
            }
        }
        
        if(o == pp.JB[12]){

        }
        if(o == pp.JB[7]){
            //JOptionPane.showMessageDialog(null,ban);
            if(ban%2==0){
                pp.Valuacion2.setEnabled(true);
                pp.JB[8].setEnabled(true);
                pp.JB[9].setEnabled(true);
                
            }
            else{
                pp.Valuacion2.setEnabled(true);
                pp.JB[8].setEnabled(true);
                pp.JB[9].setEnabled(true);
                
            }
            ban++;
            
        }
        if(o == pp.JB[3]){

            //********* Panel de Datos Productos
            pp.Jt[0].setEnabled(true);
            pp.Jt[1].setEnabled(true);
            pp.A.setEnabled(true);
            pp.Jt[3].setEnabled(false);
            pp.JB[1].setEnabled(true);
            pp.Jt[4].setEnabled(true);
            pp.Jt[5].setEnabled(true);
            
            //********* Panel de Datos Bodega
            pp.Jt[7].setEnabled(true);
            pp.Jt[8].setEnabled(true);
            pp.Jt[9].setEnabled(true);
            //********* Panel de Datos Proveedor
            pp.B.setSelectedIndex(0);
            pp.Jt[11].setEnabled(false);
            pp.Jt[12].setEnabled(false);
            
            //********* Panel de Consultas
            pp.C.setEnabled(true);
            
            pp.JB[0].setEnabled(false);
            pp.JT[1].setEnabled(false);
            
            pp.JT[0].setEnabled(false);
            pp.D.setEnabled(false);
            
            pp.JB[2].setEnabled(false);
            pp.JT[2].setEnabled(false);
            
            //********* Panel de Acciones
            pp.JB[3].setEnabled(false);
            pp.JB[4].setEnabled(true);
            pp.JB[5].setEnabled(true);
    //        pp.Veri.setEnabled(false);
            pp.JB[6].setEnabled(false);
            pp.JB[7].setEnabled(false);
            pp.JB[8].setEnabled(false);
            pp.JB[9].setEnabled(false);
            //********* Panel Tabla
            pp.Valuacion2.setEnabled(false);
            /*
            pp.B.removeAllItems();
            pp.B.addItem("");
            pp.B.addItem(pp.Jt[11].getText());
            pp.B.addItem("Agregar Nuevo");
            pp.B.setSelectedIndex(1);
            pp.Jt[11].setText((String)pp.B.getSelectedItem());
            pp.Jt[12].setText((String)pp.B.getSelectedItem());*/
            
        }
        if(o == pp.JB[6]){
      //JOptionPane.showMessageDialog(null,(String) pp.C.getSelectedItem());
            // Falta consultar datos de los de mas valores.... condiciones y las demas cosas
            Consulta_Por_Campo((String) pp.C.getSelectedItem());

            //}
        }
        if(o == pp.JB[4]){
            Limpiar_Formulario();
        }
        if(o == pp.JB[5]){
            
            String au = (String) pp.val.getSelectedItem();
            String au2 = (String) pp.ml.getSelectedItem();
            String Cantidad = au2+" "+au;
            String Nombre = pp.Jt[0].getText();
            String Generico = pp.Jt[1].getText();
            String Tipo = (String) pp.A.getSelectedItem();
            String Caducidad = pp.Jt[3].getText();
            //String Cantidad = pp.Jt[4].getText();
            String Precio = pp.Jt[5].getText();
            String Cantidad_Pro = pp.Jt[7].getText();
            String Exis_Minima = pp.Jt[8].getText();
            String Exis_Maxima = pp.Jt[9].getText();
            String Nombre_Prove = pp.Jt[11].getText();
            String Empresa = pp.Jt[12].getText();
            
            
            
            if(Vd.Validar_Letras(Nombre)==false){
                if(Vd.Validar_Letras(Generico)== false){
                    if(Vd.Validar_Letras(Tipo)==false){
                        //Falta convertir la fecha en date para q lo compares con la fecha del sistema asi validas esta campo
                        if(Vd.Validar_Fechas(Caducidad)==false){
                            if(Vd.Validar_Letras_Numeros(Cantidad)==false){
                                if(Vd.Validar_Precios(Precio)==false){
                                    if(Vd.Validar_Numeros(Cantidad_Pro)==false){
                                        if(Vd.Validar_Numeros(Exis_Minima)== false){
                                            if(Vd.Validar_Numeros(Exis_Maxima)== false){
                                                int Aux = Integer.parseInt(Exis_Minima);
                                                int Aux2 = Integer.parseInt(Exis_Maxima);  
                                                if(Aux2>Aux){
                                                    int Aux3 = Integer.parseInt(Cantidad_Pro);
                                                    JOptionPane.showMessageDialog(null,"Minimo: "+Aux);
                                                    JOptionPane.showMessageDialog(null,"MAximo: "+Aux2);
                                                    JOptionPane.showMessageDialog(null,"Cantidad: "+Aux3);
                                                    if(Aux3>Aux && Aux3<Aux2){
                                                        if(Vd.Validar_Letras(Nombre_Prove)==false){
                                                            if(Vd.Validar_Letras(Empresa)==false){
                                                                    String Valor = (String) pp.val.getSelectedItem();
                                                                    String Can = (String) pp.ml.getSelectedItem();
                                                                    String Empaque = Valor+" "+Can;
                                                                    String Name = pp.Jt[0].getText();
                                                                    String Cientif = pp.Jt[1].getText();
                                                                    String Tip = (String) pp.A.getSelectedItem();
                                                                    String fecha = pp.Jt[3].getText();
                                                                    String Pre = pp.Jt[5].getText();
                                                                    String Can_Pro = pp.Jt[7].getText();
                                                                    String Exis_Min = pp.Jt[8].getText();
                                                                    String Exis_Max = pp.Jt[9].getText();
                                                                    //String Name_Prove = pp.Jt[11].getText();
                                                                    Double Per = Double.parseDouble(Pre);

                                                                    String ItCom= (String) pp.B.getSelectedItem();
                                                                    int Id_Pr =Integer.parseInt(ItCom);

                                                                   /* JOptionPane.showMessageDialog(null,Name);
                                                                    JOptionPane.showMessageDialog(null,Cientif);
                                                                    JOptionPane.showMessageDialog(null,Tip);
                                                                    JOptionPane.showMessageDialog(null,fecha);
                                                                    JOptionPane.showMessageDialog(null,Per);
                                                                    JOptionPane.showMessageDialog(null,"Cantidad" +Aux3);
                                                                    JOptionPane.showMessageDialog(null,"Cantidad_Min" +Aux);
                                                                    JOptionPane.showMessageDialog(null,"Cantidad_Max" +Aux2);
                                                                    JOptionPane.showMessageDialog(null,Id_Pr);*/

                                                                 Op.Open();
                                                                try {
                                                                     JOptionPane.showMessageDialog(null,pp.Imagen.getText());
                                                                    Op.Alta_Producto(Name, Cientif, Tip,fecha,Empaque,Per, Aux3, Aux, Aux2,Id_Pr,pp.Imagen.getText());
                                                                    JOptionPane.showMessageDialog(null,"Producto Agregado");
                                                                                pp.val.setSelectedItem(0);
                                                                                pp.ml.setSelectedItem(0);
                                                                    Limpiar_Formulario();
                                                                    pp.Borrar_Productos();
                                                                    pp.Llenar_Tabla(Op.Llenar_Tabla_Producto());
                                                                    } catch (SQLException ex) {
                                                                    Logger.getLogger(ControlVistaProductos.class.getName()).log(Level.SEVERE, null, ex);
                                                                }
                                                                 Op.Close();
                                                            }
                                                            else
                                                                JOptionPane.showMessageDialog(null,"Nombre de la empresa incorrecta","EROR",JOptionPane.ERROR_MESSAGE);
                                                        }
                                                        else
                                                            JOptionPane.showMessageDialog(null,"Nombre del Proveedor Incorrecto","EROR",JOptionPane.ERROR_MESSAGE);
                                                            
                                                    }
                                                    else{
                                                        pp.Jt[7].setText("");
                                                        JOptionPane.showMessageDialog(null,"La cantidad debe estar entre el Minimo y Maximo","ERROR",JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                                else
                                                    JOptionPane.showMessageDialog(null,"La Cantidad Maxima Debe Ser Mayor a Cantidad Minima","ERROR",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                                JOptionPane.showMessageDialog(null,"Cantidad Maxima Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
                                          }
                                        else
                                            JOptionPane.showMessageDialog(null,"Cantidad Minima Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
                                    }       
                                    else
                                        JOptionPane.showMessageDialog(null,"Cantidad Producto Incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
                                }
                                else
                                    JOptionPane.showMessageDialog(null,"Precio Incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                            else
                                JOptionPane.showMessageDialog(null,"Cantidad Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Fecha Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Tipo Incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Nombre Generico Incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,"Nombre Incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    

    public void Consulta_Por_Campo(String Campos){
            pp.Borrar_Productos();
            Op.Open();
            String Dato = pp.JT[0].getText();
            //JOptionPane.showMessageDialog(null, Dato);
           // JOptionPane.showMessageDialog(null, Campos);
            pp.Llenar_Tabla(Op.Llenar_Tabla_Producto_Consulta(Campos,Dato));
            Op.Close();
    }

    @Override
    public void itemStateChanged(ItemEvent ee) {
        //String Seleccionado = (String) pp.C.getSelectedItem();
        String ItCom= (String) pp.B.getSelectedItem();
        int Indice= Integer.parseInt(ItCom);
        if(pp.B==ee.getItemSelectable()){
            Op.Open();
            String col1="Nombre_Provedor";
            String col2="Empresa";
            pp.Jt[11].setText(Op.Fuc_Cadena(col1, Indice));
            pp.Jt[12].setText(Op.Fuc_Cadena(col2, Indice));
            Op.Close();
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        String x= (String) pp.C.getSelectedItem();
         int fila = pp.Valuacion2.rowAtPoint(e.getPoint());
         int columna = pp.Valuacion2.columnAtPoint(e.getPoint());
         
         //JOptionPane.showMessageDialog(null, fila);
         //JOptionPane.showMessageDialog(null, columna);
         
         if ((fila > -1) && (columna > -1)){
             Object Id =  pp.modelo.getValueAt(fila,0);
             String Con = String.valueOf(Id);
             String Nuevo_Valor=null;
             int Valore = Integer.parseInt(Con);
             int seleccion = JOptionPane.showOptionDialog(null," !! Seleccione Una Opcion !!",   "Eliminar/Modificar",   JOptionPane.YES_NO_CANCEL_OPTION,   JOptionPane.QUESTION_MESSAGE,   new ImageIcon("Salir.png"),new Object[] { "Eliminar", "Modificar", "Cancelar" },"opcion 1");
             
             if(seleccion+1 == 2){
                 
                 
                 
                 
                 String Columna = pp.modelo.getColumnName(columna);
                 boolean Reques = true;
                 do{                     
                    if(Columna.equals("Id_Producto")){
                        Reques=true;
                        JOptionPane.showMessageDialog(null,"No se puede modificar el Id_Producto");
                    }
                    if(Columna.equals("Nombre_Producto") || Columna.equals("Nombre_Cientifico")){
                        boolean val=false;
                        Nuevo_Valor= JOptionPane.showInputDialog("Ingrese valor para el campo "+Columna+"");
                        if(Nuevo_Valor == null){
                            val=false;
                        }
                        else{
                        do{
                            if(Vd.Validar_Letras(Nuevo_Valor) == false){
                                val=true;
                                       Op.Open();
                                        try {
                                            Op.Modificar_Producto(Columna,Nuevo_Valor, Valore);
                                        } catch (SQLException ex) {
                                                Logger.getLogger(ControlVistaProductos.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        Op.Close();
                                        JOptionPane.showMessageDialog(null,"Se modifico el registro");
                                        Consulta_Por_Campo((String) pp.C.getSelectedItem());
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Ingreso Mal el Dato");
                            }
                        }while(val!=true);
                        }
                    }
                    if(Columna.equals("Forma_Farmaceutica")){
                        Object selecci = JOptionPane.showInputDialog(null,"Seleccione opcion","Selector de opciones",   JOptionPane.QUESTION_MESSAGE,   null,new Object[] { "Jarabe", "Tabletas", "Gel Pomada" , "Solucion" , "Inyectable" },"opcion 1");
                        String xxxx = String.valueOf(selecci);
                        Reques=true;
                                       Op.Open();
                                        try {
                                            Op.Modificar_Producto(Columna,xxxx, Valore);
                                        } catch (SQLException ex) {
                                                Logger.getLogger(ControlVistaProductos.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        Op.Close();
                                        JOptionPane.showMessageDialog(null,"Se modifico el registro");
                                        Consulta_Por_Campo((String) pp.C.getSelectedItem());
                        
                    }
                    
                    if(Columna.equals("Cantidad")){
                         
                         Object selecci2 = JOptionPane.showInputDialog(null,"Seleccione opcion","Selector de opciones",   JOptionPane.QUESTION_MESSAGE,   null,new Object[] { "50", "75", "100" , "125" , "150", "200" , "250", "375", "500", "750", "1000", "1500", "2000"},"opcion 1");
                         Object selecci = JOptionPane.showInputDialog(null,"Seleccione opcion","Selector de opciones",   JOptionPane.QUESTION_MESSAGE,   null,new Object[] { "ml","grms" },"opcion 1");
                         String xxxx = String.valueOf(selecci)+String.valueOf(selecci2);
                         
                        Reques=true;
                                        Op.Open();
                                        try {
                                            Op.Modificar_Producto(Columna,xxxx, Valore);
                                        } catch (SQLException ex) {
                                                Logger.getLogger(ControlVistaProductos.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        Op.Close();
                                        JOptionPane.showMessageDialog(null,"Se modifico el registro");
                                        Consulta_Por_Campo((String) pp.C.getSelectedItem());
                    }                   
                    if(Columna.equals("Precio")){
                        boolean val=false;
                        Nuevo_Valor= JOptionPane.showInputDialog("Ingrese valor para el campo "+Columna+"");
                        if(Nuevo_Valor == null){//***** si presionan cancelar
                            val=false;
                        }
                        else{
                        do{
                            if(Vd.Validar_Precios(Nuevo_Valor) == false){
                                val=true;
                                       Op.Open();
                                        try {
                                            Op.Modificar_Producto_Double(Columna,Double.parseDouble(Nuevo_Valor), Valore);
                                        } catch (SQLException ex) {
                                                Logger.getLogger(ControlVistaProductos.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        Op.Close();
                                        Consulta_Por_Campo((String) pp.C.getSelectedItem());
                                        JOptionPane.showMessageDialog(null,"Se modifico el registro");
                                
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Ingreso Mal el Dato");
                            }
                        }while(val!=true);
                        }   
                    }
                    if(Columna.equals("Cantidad_Producto")){
                        Reques=true;
                        
                    }
                    if(Columna.equals("Existencia_Minima") || Columna.equals("Existencia_Minima")|| Columna.equals("Existencia_Maxima")|| Columna.equals("Id_Provedor")){
                        boolean val=false;
                        Nuevo_Valor= JOptionPane.showInputDialog("Ingrese valor para el campo "+Columna+"");
                        if(Nuevo_Valor == null){//***** si presionan cancelar
                            val=false;
                        }
                        else{
                        do{
                            if(Vd.Validar_Numeros(Nuevo_Valor) == false){
                                val=true;
                                        Op.Open();
                                        try {
                                            Op.Modificar_Producto_int(Columna,Integer.parseInt(Nuevo_Valor), Valore);
                                        } catch (SQLException ex) {
                                                Logger.getLogger(ControlVistaProductos.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        Op.Close();
                                        Consulta_Por_Campo((String) pp.C.getSelectedItem());
                                        JOptionPane.showMessageDialog(null,"Se modifico el registro");
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Ingreso Mal el Dato");
                            }
                        }while(val!=true);
                        }   
                        
                    }
                 }while(Reques==false);
             }
             
             if(seleccion+1 ==1){
                 int confirmado = JOptionPane.showConfirmDialog(null,"¿Confirma La Eliminacion?");   
                 if (JOptionPane.OK_OPTION == confirmado){
                              Op.Open();
                              try {
                                    Op.Eliminar_Productos(Valore);
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
             
             
             if(seleccion+1==3){}
             
             
             
             
/*             if(seleccion+1==2){

                 String Columna =(String) pp.modelo.getColumnName(columna);
                 int Acceso=0;
                 boolean Reques=true;
                 do{
                     
                     if(Columna.equals("Nombre_Producto") || Columna.equals("Nombre_Cientifico")){
                         Nuevo_Valor = JOptionPane.showInputDialog(null,"Nuevo Valor Para Campo "+Columna+":",JOptionPane.QUESTION_MESSAGE);
                         if(Nuevo_Valor == null){Reques=true;Acceso=2;Columna=Columna+" ";}
                         if(Vd.Validar_Letras(Nuevo_Valor)==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Cantidad")){
                         //Object selecci = JOptionPane.showInputDialog(null,"Seleccione opcion","Selector de opciones",   JOptionPane.QUESTION_MESSAGE,   null,new Object[] { "Jarabe", "Tabletas", "Gel Pomada" , "Solucion" , "Inyectable" },"opcion 1");
                         Nuevo_Valor = JOptionPane.showInputDialog(null,"Nuevo Valor Para Campo "+Columna+":",JOptionPane.QUESTION_MESSAGE);
                         if(Nuevo_Valor == null){Reques=true;Acceso=2;Columna=Columna+" ";}
                         if(Vd.Validar_Letras_Numeros(Nuevo_Valor) ==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Precio")){
                         Nuevo_Valor = JOptionPane.showInputDialog(null,"Nuevo Valor Para Campo "+Columna+":",JOptionPane.QUESTION_MESSAGE);
                         if(Nuevo_Valor == null){Reques=true;Acceso=2;Columna=Columna+" ";}
                         if(Vd.Validar_Precios(Nuevo_Valor) ==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Cantidad_Producto") || Columna.equals("Existencia_Minima")|| Columna.equals("Existencia_Maxima")){
                         Nuevo_Valor = JOptionPane.showInputDialog(null,"Nuevo Valor Para Campo "+Columna+":",JOptionPane.QUESTION_MESSAGE);
                         if(Nuevo_Valor == null){Reques=true;Acceso=2;Columna=Columna+" ";}
                         if(Vd.Validar_Numeros(Nuevo_Valor) ==false){
                             Reques=true;
                         }else{Reques=false;} 
                     }
                     if(Columna.equals("Forma_Farmaceutica")){
                         Object selecci = JOptionPane.showInputDialog(null,"Seleccione opcion","Selector de opciones",   JOptionPane.QUESTION_MESSAGE,   null,new Object[] { "Jarabe", "Tabletas", "Gel Pomada" , "Solucion" , "Inyectable" },"opcion 1");
                         Object selecci2 = JOptionPane.showInputDialog(null,"Seleccione opcion","Selector de opciones",   JOptionPane.QUESTION_MESSAGE,   null,new Object[] { "50", "75", "100" , "125" , "150", "200" , "250", "375", "500", "750", "1000", "1500", "2000"},"opcion 1");
                         Reques=true;
                     }
                     if(Columna.equals("Fecha_Caducidad")){
                         JOptionPane.showMessageDialog(null,"Falta Desplegar el calendario");
                     }
                     if(Columna.equals("Id_Producto")){
                             Reques=true;
                             Acceso=2;
                     }
                     if(Columna.equals("")){
                         Reques=true;
                     }                     
                 }while(Reques!=true);
                 if(Acceso==0){
                     
                              JOptionPane.showMessageDialog(null,"Dato Correcto");
                     /*         Op.Open();
                              pp.modelo.setValueAt(Nuevo_Valor,fila, columna);//Este es solo para modificar
                              try {
                                    Op.Modificar_Provedor(Vp.modelo.getColumnName(columna), Nuevo_Valor,Valore);
                              } catch (SQLException ex) {
                                        Logger.getLogger(Control_Vista_Provedor.class.getName()).log(Level.SEVERE, null, ex);
                              }
                              Op.Close();
                      */
                 //}
                 //else{JOptionPane.showMessageDialog(null,"No Se Modifico El Campo "+Columna+"");}
                     
   /*                     
             }
             if(seleccion+1==1){
                 int confirmado = JOptionPane.showConfirmDialog(null,"¿Confirma La Eliminacion?");   
                 if (JOptionPane.OK_OPTION == confirmado){
                       /*       Op.Open();
                              try {
                                    Op.Eliminar_Provedor(Valore);
                                    Vp.Borrar_Provedores();
                                    Vp.Llenar_Tabla(Op.Llenar_Tabla_Profesor());
                                    Consulta_Por_Campo(x);
                              } catch (SQLException ex) {
                                        Logger.getLogger(Control_Vista_Provedor.class.getName()).log(Level.SEVERE, null, ex);
                              }
                              Op.Close();*/
 /*                }else{JOptionPane.showMessageDialog(null,"!! No se Elimino El Registro !!");
                 }          
             }
             if(seleccion+1==3){
             
             }
/*             
             //if (seleccion != -1)
//                        System.out.println((seleccion + 1));
             
             
             
             
             
             
            
             
             
             //JOptionPane.showMessageDialog(null, Con);
                                      
             //JOptionPane.showMessageDialog(null,"Id_Provedor: "+Vp.modelo.getValueAt(fila, 0));
             
             //JOptionPane.showMessageDialog(null,"Nombre de la Columna: "+(String) Vp.modelo.getColumnName(columna));
             
             //JOptionPane.showMessageDialog(null,"Dato en Columna: "+(String) Vp.modelo.getValueAt(fila, columna));
             
             
             
             
             
             
             

             
             
             
             //String Hola = (String) Vp.modelo.getValueAt(fila, columna);
             //JOptionPane.showMessageDialog(null, Hola);
           //JOptionPane.showMessageDialog(null,Vp.modelo.getValueAt(fila,columna));*/
         }
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
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
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

}
