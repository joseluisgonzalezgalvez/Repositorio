package Vistas_Empleado;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sala3_05
 */
@SuppressWarnings("serial")
public class Vehiculo extends JPanel{
    public JTextField Jt[]= new JTextField[7];
    public JLabel Jl[]= new JLabel[7];
    //public JPanel Panelito;
    public Vehiculo(){
        Disenio();
    }

    private void Disenio() {
        //Panelito = new JPanel();
        //Panelito.setLayout(null);
        setLayout(null);
        //setBackground(Color.red);
        //setSize(350, 320);
        for(int i=0;i<7;i++){
            Jt[i]= new JTextField();
        }
        Jl[0]= new JLabel("Tipo de Vehiculo: ");
        Jl[1]= new JLabel("Marca: ");
        Jl[2]= new JLabel("Modelo: ");
        Jl[3]= new JLabel("Color: ");
        Jl[4]= new JLabel("N� Puertas: ");
        Jl[5]= new JLabel("Numero De serie: ");
        Jl[6]= new JLabel("Valuaci�n: ");
        Jl[0].setBounds(20, 10,130,40);
        Jl[1].setBounds(20, 50,130,40);
        Jl[2].setBounds(20, 90,130,40);
        Jl[3].setBounds(20, 130,130,40);
        Jl[4].setBounds(20, 170,130,40);
        Jl[5].setBounds(20, 210,130,40);
        Jl[6].setBounds(20, 250,130,40);
        Jt[0].setBounds(150, 18, 150, 25);
        Jt[1].setBounds(150, 58, 150, 25);
        Jt[2].setBounds(150, 98, 150, 25);
        Jt[3].setBounds(150, 138, 150, 25);
        Jt[4].setBounds(150, 178, 150, 25);
        Jt[5].setBounds(150, 218, 150, 25);
        Jt[6].setBounds(150, 258, 150, 25);
        
        for(int i=0; i<7;i++){
                add(Jl[i]);
                add(Jt[i]);
        }
    }
}
