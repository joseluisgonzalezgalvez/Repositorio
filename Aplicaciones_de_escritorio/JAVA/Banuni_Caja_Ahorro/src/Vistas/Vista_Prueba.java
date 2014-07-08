/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Administrador
 */
//import com.birosoft.liquid.LiquidLookAndFeel;

import javax.swing.*;
//import com.birosoft.liquid.LiquidLookAndFeel;
@SuppressWarnings({ "serial", "unused" })
public class Vista_Prueba extends JFrame{

    public Vista_Prueba(){
        Iniciar();
        
    }
    public void Iniciar(){
        //Propiedades de la Interfas
        setSize(950,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane JP= new JTabbedPane();
       // JP.addTab("Menu", new Datos_Clientes.Vista_Cliente_Bajas());
       // JP.addTab("Menu", new Vista_Creditos.Vista_Prueba());
        add(JP);
    }
    
    public static void main (String Args[]){

        try{
     	   UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            }catch (Exception e){e.printStackTrace();} 
    	Vista_Prueba vp = new Vista_Prueba();
    	vp.Iniciar();
    	vp.setVisible(true);
    	vp.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    
  
}

           
    