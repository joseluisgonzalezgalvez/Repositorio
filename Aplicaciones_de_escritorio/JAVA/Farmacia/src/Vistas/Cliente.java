/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;
import Control.Control_Cliente;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Cliente extends JPanel
{
    static private ResultSet r1;//para almacenar la informacion obtenida de la BD
    //OperacionesProfesores o=new OperacionesProfesores();
    Base_Datos.Sentecias_BD op=new Base_Datos.Sentecias_BD();

    public JLabel matrizlabel[]=new JLabel[9];
    public JTextField matriztext[]=new JTextField[8];
    public JTextArea domicilioprofesor;
    public JComboBox clavecliente;
    public JTextArea impresion;
    public JButton matrizboton[]=new JButton[6];
    public JScrollPane jp,jp1;

    public Cliente()
    {
        disenio();
        llenar();
    }
    public void disenio()
    {
        setLayout(null);
        //creación de los compornestes de la ventana
        matrizlabel[0]=new JLabel("Id_Cliente");
        matrizlabel[1]=new JLabel("Id_Cliente");
        matrizlabel[2]=new JLabel("Nombre_Cliente");
        matrizlabel[3]=new JLabel("Direccion");
        matrizlabel[4]=new JLabel("Ciudad");
        matrizlabel[5]=new JLabel("Telefono");
        matrizlabel[6]=new JLabel("Codigo_Postal");
        matrizlabel[7]=new JLabel("Estado");
        matrizlabel[8]=new JLabel("Numero_Tarjeta");

        domicilioprofesor=new JTextArea();
        impresion=new JTextArea();
        clavecliente=new JComboBox();
        for(int i=0;i<8;i++)
        {
            matriztext[i]=new JTextField();
        }
        matrizboton[0]= new JButton("Nuevo");
        matrizboton[1]= new JButton("Guardar");
        matrizboton[2]= new JButton("Eliminar");
        matrizboton[3]= new JButton("Imprimir");
        matrizboton[4]= new JButton("Modificar");
        matrizboton[5]= new JButton("Salir");
        //termina creacion de los componestes de la ventana

        //inicia agregacion de los componentes de la ventana
        matrizboton[0].setBounds(600, 50, 150, 40);
        matrizboton[1].setBounds(600, 100, 150, 40);
        matrizboton[2].setBounds(600, 150, 150, 40);
        matrizboton[3].setBounds(600, 200, 150, 40);
        matrizboton[4].setBounds(600, 250, 150, 40);
        matrizboton[5].setBounds(600, 300, 150, 40);


        matrizlabel[0].setBounds(50, 0, 150, 40);
        matrizlabel[1].setBounds(50, 50, 150, 40);
        matrizlabel[2].setBounds(50,100, 150, 40);
        matrizlabel[3].setBounds(50,150, 150, 40);
        matrizlabel[4].setBounds(50,200, 150, 40);
        matrizlabel[5].setBounds(50,250, 150, 40);
        matrizlabel[6].setBounds(50,300, 150, 40);
        matrizlabel[7].setBounds(50,350, 150, 40);
        matrizlabel[8].setBounds(50,400, 150, 40);

        matriztext[0].setBounds(300,50,200,40);
        matriztext[0].setEnabled(false);
        matriztext[1].setBounds(300,100,200,40);
        matriztext[2].setBounds(300,150,200,40);
        matriztext[3].setBounds(300,200,200,40);
        matriztext[4].setBounds(300,250,200,40);
        matriztext[5].setBounds(300,300,200,40);
        matriztext[6].setBounds(300,350,200,40);
        matriztext[7].setBounds(300,400,200,40);

        //claveprofesor.setBorder(n)
        clavecliente.setBounds(300, 0, 200, 40);
        //claveprofesor.setBorder(new BorderFactory.createLineBorder(Color.red));
        jp=new JScrollPane(domicilioprofesor);
        //jp1=new JScrollPane(impresion);
        //jp.setViewportView(domicilioprofesor);
        //domicilioprofesor.setBounds(300, 250, 200, 50);
        //jp.setBounds(300, 250, 200, 50);
        //jp1.setBounds(50, 350, 600, 300);
        //termina agregacion de los componentes de la ventana
        for(int i=0;i<9;i++)
        {
            add(matrizlabel[i]);
        }
        for(int i=0;i<8;i++)
        {
            add(matriztext[i]);
        }
        clavecliente.addItemListener(new Control_Cliente(this));
        for(int i=0;i<6;i++)
        {
            add(matrizboton[i]);
            matrizboton[i].addActionListener(new Control_Cliente(this));
        }

        add(clavecliente);
        //add(domicilioprofesor);
        add(jp);
        //add(jp1);
    }
    public void llenar()
    {
        try
        {
            op.Open();
            r1=op.Consulta_clave();
            while(r1.next())
            {
                clavecliente.addItem(r1.getString(1));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error no se puede llenar");
        }
        op.Close();
    }
}
