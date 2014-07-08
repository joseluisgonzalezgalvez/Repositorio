    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */
    package Vistas_Empleado;

    import javax.swing.JFrame;
    import javax.swing.*;
    public class Vista_Prueba extends JFrame{

		private static final long serialVersionUID = 1L;

		public Vista_Prueba(){
            Iniciar();
           // setExtendedState(MAXIMIZED_BOTH);
        }
        public void Iniciar(){
            //Propiedades de la Interfas
            setSize(820,610);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTabbedPane JP= new JTabbedPane();
            JP.addTab("Menu", new Vista_Creditos.Amortizacion_Prestamos());
            add(JP);
        }

        public static void main (String Args[]){
                 Vista_Prueba Vp =new Vista_Prueba();
                 Vp.Iniciar();
                 Vp.setVisible(true);  
            }


    }


