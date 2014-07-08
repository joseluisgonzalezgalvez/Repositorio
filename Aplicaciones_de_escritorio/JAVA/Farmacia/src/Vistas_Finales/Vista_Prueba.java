/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas_Finales;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Sala3_02
 */
public class Vista_Prueba extends JFrame
{
    Vista_Prueba(){
        Disenio();
    }

    public void Disenio() {
        setLayout(null);
        setSize(1020,750);
        JTabbedPane JPx= new JTabbedPane();
//        JPx.addTab("Consulta_Medica", new Vistas.Vista_Consulta_Medica());        
        //JPx.addTab("Provedor", new Vistas.VistaProvedor());
//        JPx.addTab("Producto",new Vistas.VistaProducto());
//        JPx.addTab("Factura",new Vistas.Vista_Factura());
        //JPx.addTab("Factura",new Vistas.VistaEmpleado());
//        JPx.addTab("Factura",new Vistas.Cobrar_Receta_Medica());
  JPx.addTab("Factura",new Vistas.Cobrar_Vista_Factura());
        JPx.setBounds(0, 0, 1020, 700);
        add(JPx);
    }
    public static void main(String Args[]){
        Vista_Prueba Vp = new Vista_Prueba();
        Vp.Disenio();
        Vp.setVisible(true);
        Vp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
