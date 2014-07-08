/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import manual.Manual;

        @SuppressWarnings("unused")
		public class ControlVistaPrincipal implements ActionListener{
            Vistas.VistaPrincipal Vp;
            public ControlVistaPrincipal(Vistas.VistaPrincipal Vp){
                this.Vp = Vp;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
                if(e.getSource() == Vp.Salir || e.getSource() == Vp.botones[7]){
                    Vistas.Acceso Va = new Vistas.Acceso();
                            Va.Disenio();
                            Va.setLocationRelativeTo(null);
                            Va.setTitle("ACCESO <<CAJA FELIZ>>");
                            Va.setVisible(true);
                            Va.setResizable(false);
                            Va.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                            Vp.setVisible(false);
                            Va.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Imagenes/vender.jpg"));
                }
                if(e.getSource()== Vp.Clientes ||  Vp.botones[0] == e.getSource()){
                       JInternalFrame marco = new JInternalFrame("Registro de Clientes",true,true,false,true);
                       Vistas_Empleado.VistaClientes panel = new Vistas_Empleado.VistaClientes();
                       marco.setLocation(200,20);
                       marco.setFrameIcon(new ImageIcon("src/Imagenes/1.jpg"));
                       MandarPanel(panel,marco);
                }

                
                if(e.getSource() == Vp.AltasC | e.getSource() == Vp.botones[1] ){
                	
                    JInternalFrame marco = new JInternalFrame("Tabla de Amortización", true, true, false, true);
                    Vista_Creditos.Amortizacion_Prestamos panel = new Vista_Creditos.Amortizacion_Prestamos();
                    marco.setLocation(250,10);
                    marco.setFrameIcon(new ImageIcon("src/Imagenes/ve.jpg"));
                    MandarPanel(panel,marco);
                }
                
                if(e.getSource() == Vp.botones[2] || e.getSource() == Vp.NuevoC){
                	JInternalFrame marco = new JInternalFrame("Registro de Prestamos", true, true, false, true);
                	Vista_Creditos.VistaPrestamo panel = new Vista_Creditos.VistaPrestamo();
                    marco.setLocation(250,10);
                    marco.setFrameIcon(new ImageIcon("src/Imagenes/2.jpg"));
                    MandarPanel(panel,marco);
                }
                
                if(e.getSource() == Vp.botones[4] || e.getSource() == Vp.Cobrar_Cliente){
                	JInternalFrame marco = new JInternalFrame("Cobrar Cuotas", true, true, false, true);
                	Vista_Creditos.Cobrar_Cuotas panel = new Vista_Creditos.Cobrar_Cuotas();
                    marco.setLocation(300,20);
                    marco.setFrameIcon(new ImageIcon("src/Imagenes/3.jpg"));
                    MandarPanel(panel,marco);
                }
                if(e.getSource() == Vp.botones[6] || e.getSource() == Vp.Manual){
                    manual.Manual man=new manual.Manual();
                    man.diseñoManual();
                }
                
            }
            public void MandarPanel(JPanel panel, JInternalFrame marco){
                       Container contenedor = marco.getContentPane();
                       contenedor.add( panel, BorderLayout.CENTER );
                       marco.pack();
                       Vp.elEscritorio.add( marco );
                       marco.setVisible( true );    
            }
            
            

            
            
        }

