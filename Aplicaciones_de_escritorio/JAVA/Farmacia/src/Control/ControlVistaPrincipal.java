/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrador
 */
public class ControlVistaPrincipal implements ActionListener{
    Vistas_Finales.VistaPrincipal Vp;
    public ControlVistaPrincipal(Vistas_Finales.VistaPrincipal Vp){
        this.Vp = Vp;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
/*        if(Vp.Puesto_Usuario.equals("Con Poder")){
            //Vp.Salir.setEnabled(true);
            Vp.botones[0].setEnabled(true);
            Vp.botones[1].setEnabled(true);            
        }
        if(Vp.Puesto_Usuario.equals("Servicio")){
            //Vp.Salir.setEnabled(false);
            Vp.botones[0].setEnabled(false);
            Vp.botones[1].setEnabled(false);
        }*/
        
//Funciona muy bien solo tienes que ponerlo en el diseño asi esta mejor
        
        if(e.getSource() == Vp.Salir || e.getSource()== Vp.botones[10]){
            ///******** Para la entrega final del este proyecto descomenta lo ya comentado

            
            Vistas_Finales.Acceso Va = new Vistas_Finales.Acceso();
                    Va.Disenio();
                    Va.setLocationRelativeTo(null);
                    Va.setTitle("Sistema Farmaceutico Del Istmo");
                    Va.setVisible(true);
                    Va.setResizable(false);
                    Va.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    Vp.setVisible(false);
            
        }
        if(e.getSource()== Vp.Clientes || e.getSource() == Vp.botones[0]){
            //JOptionPane.showMessageDialog(null,"Hola mundo como estas");
               //JInternalFrame marco = new JInternalFrame("------- Productos -------", true, true, true, true );
               //Vistas.VistaProducto panel = new Vistas.VistaProducto();
               //MandarPanel(panel,marco);

        }
        if(e.getSource() == Vp.NuevoC || e.getSource() == Vp.botones[1]){
        }
        if(e.getSource() == Vp.Con_Cre || e.getSource() == Vp.botones[2]){

        }
        if(e.getSource() == Vp.Cobrar_Cliente || e.getSource() == Vp.botones[4]){
        }

        if(e.getSource() == Vp.Consultas || e.getSource() == Vp.botones[5]){
               JInternalFrame marco = new JInternalFrame("------- Recetas Medicas -------", true, true, true, true );
               Vistas.Vista_Consulta_Medica panel = new Vistas.Vista_Consulta_Medica();
               MandarPanel(panel,marco);
        }
        if(e.getSource() == Vp.Operaciones || e.getSource() == Vp.botones[4]){
               JInternalFrame marco = new JInternalFrame("------- Recetas Medicas -------", true, true, true, true );
               Vistas.Vista_Factura panel = new Vistas.Vista_Factura();
               MandarPanel(panel,marco);
        }
        if(e.getSource() == Vp.Clientes || e.getSource() == Vp.botones[2]){
               JInternalFrame marco = new JInternalFrame("------- Productos -------", true, true, true, true );
               Vistas.VistaProducto panel = new Vistas.VistaProducto();
               MandarPanel(panel,marco);
        }
        if(e.getSource() == Vp.Prestamos || e.getSource() == Vp.botones[1]){
               JInternalFrame marco = new JInternalFrame("------- Provedores -------", true, true, true, true );
               Vistas.VistaProvedor panel = new Vistas.VistaProvedor();
               MandarPanel(panel,marco);
        }
        if(e.getSource() == Vp.Cobrar_Cliente || e.getSource() == Vp.botones[6]){
               JInternalFrame marco = new JInternalFrame("------- Cobrar Venta -------", true, true, true, true );
               Vistas.Cobrar_Vista_Factura panel = new Vistas.Cobrar_Vista_Factura();
               MandarPanel(panel,marco);
        }
    }
    public void MandarPanel(JPanel panel, JInternalFrame marco){
               // adjuntar panel al panel de contenido del marco interno
               Container contenedor = marco.getContentPane();
               //MiJPanel panel = new MiJPanel();
               contenedor.add( panel, BorderLayout.CENTER );
               // establecer tamaño de marco interno en el tamaño de su contenido
               //marco.setResizable(false);
               marco.pack();
               
               // adjuntar marco interno al escritorio y mostrarlo
               Vp.elEscritorio.add( marco );
               
               marco.setVisible( true );    
    }
}
