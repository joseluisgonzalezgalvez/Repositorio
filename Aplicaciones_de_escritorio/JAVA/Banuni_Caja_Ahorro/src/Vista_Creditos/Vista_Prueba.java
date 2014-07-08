    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */
    package Vista_Creditos;
    import javax.swing.*;

import org.jvnet.substance.SubstanceLookAndFeel;
    @SuppressWarnings("unused")
	public class Vista_Prueba extends JFrame{
		private static final long serialVersionUID = 1L;
		public Vista_Prueba(){
            Iniciar();
          //  SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
        }
        public void Iniciar(){
            setSize(1035,620);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTabbedPane JP= new JTabbedPane();
            JP.addTab("Menu", new Cobrar_Cuotas());
            
            add(JP);
        }
        public static void main (String Args[]){
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    Vista_Prueba Vp =new Vista_Prueba();
                    Vp.Iniciar();
                    Vp.setVisible(true);  
                    Vp.setLocationRelativeTo(null);
        }
    }


