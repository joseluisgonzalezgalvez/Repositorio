/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;
@SuppressWarnings({ "serial" })
public class TestUsuario extends JFrame{
   public static void main (String Args[]){
       try{
    	   UIManager.setLookAndFeel(new com.lipstikLF.LipstikLookAndFeel());
           }catch (Exception e){e.printStackTrace();} 
       Vistas.Acceso VA= new Vistas.Acceso();
       VA.Disenio();
       VA.setLocationRelativeTo(null);
       VA.setTitle("ACCESO <<CAJA FELIZ>>");
       VA.setVisible(true);
       VA.setResizable(false);
       VA.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       VA.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Imagenes/vender.jpg"));
       }
     
   }
            
            
        

