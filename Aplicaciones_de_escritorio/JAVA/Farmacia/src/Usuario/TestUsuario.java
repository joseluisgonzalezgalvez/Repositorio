/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
//import com.birosoft.liquid.LiquidLookAndFeel;
//import com.birosoft.liquid.LiquidLookAndFeel;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
/**
 *
 * @author Tiago
 */
public class TestUsuario extends JFrame{
    Font Estilo = new Font("MONOTYPE CORSIVA", Font.BOLD,40);
    public static void main (String Args[]){
        
            /*try{
                
                
                UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
                LiquidLookAndFeel.setLiquidDecorations(true, "panther");
            }
            catch(Exception e){}*/
            Vistas_Finales.Acceso VA= new Vistas_Finales.Acceso();
            VA.Disenio();
            VA.setLocationRelativeTo(null);
            VA.setTitle("ACCESO AL SISTEMA");
            VA.setVisible(true);
            VA.setResizable(false);
            VA.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
            
        
}
