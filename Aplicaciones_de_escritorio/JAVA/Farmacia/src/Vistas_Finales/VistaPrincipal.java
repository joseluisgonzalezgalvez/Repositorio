/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas_Finales;
//import com.birosoft.liquid.LiquidLookAndFeel;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
//import Control.*;
/**
 *
 * @author Tiago
 */
public class VistaPrincipal extends JFrame{
        public JDesktopPane elEscritorio;
        public JPanel EscritorioMedio;
	public JToolBar barra = new JToolBar();
        public JTabbedPane JPs;
	public JButton[] botones ;
	public ImageIcon ima;
	public JMenuItem tipo1,tipo2,tipo3,tipo4,tam1,tam2,tam3,tam4,tam5,bol,ital,xx;
        public JMenuItem Rojo,Axul,Negro;
        public JMenu ipo;
        public JMenu Archivo,Archivo2,Archivo3,Actualizar,Operaciones,Ayuda;
        public JMenu Creditos,Consultas,Cobros;
        public JMenuItem Configurar,Usuarios,Salir;
        public JMenuItem Clientes,  Prestamos,Empleados;
        public JMenuItem AltasC,BajasC,ModificarC,AltasP,BajasP,ModificarP,AltasE,BajasE,ModificarE;
        public JMenuItem NuevoC,Con_Cre,Con_Cobro,Con_Deudores,Cobrar_Cliente;
        public JMenuItem Manual,Acerca;
        public JPopupMenu JP;
	public int x=0,y=0;
        public Font fRedeterminada; //Esto es una variable de la clase!!!
        public JRadioButtonMenuItem colorfuente[], tiposfuente[],tamañofuente[];
	public JCheckBoxMenuItem negritas,cursiba,subrayado,normal;
	public ButtonGroup grupotiposfuente, grupocolorfuente,grupotamañofuente;
        public CheckboxGroup Hola;
	public JMenu archivo,edicion,formato,tipo,color,tipof,tamaño;
        public JMenu Estilooos;
	public JLabel pantallaEtiqueta;
        public JTextArea textarea;
	public JMenuItem nuevo,guardar,salir,abrir,copiar,pegar,borrar,copiar2,pegar2,borrar2,nuevo2;
	public JMenuBar barramenu,barralateral;
        public static String Puesto_Usuario="",Nombre_Usuario="";

	public VistaPrincipal(){
                setExtendedState(MAXIMIZED_BOTH);
                //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void diseno(String Nombre, String Pues){
                Vistas_Finales.Acceso ac= new Vistas_Finales.Acceso();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Toolkit tk = Toolkit.getDefaultToolkit();
                Dimension tama = tk.getScreenSize();
		barramenu = new JMenuBar();
                barralateral = new JMenuBar();
//------------- Seccion de Menus -----------------------------------------------
		Archivo = new JMenu("Archivo");
		Actualizar = new JMenu("Almacen");
		Operaciones = new JMenu("Servicio");
                Ayuda = new JMenu("Ayuda");
//------------- Seccion de Archivo ---------------------------------------------
		Configurar =new JMenuItem("Corte De Caja Servicios");
                Configurar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		Usuarios=new JMenuItem("Corte De Caja Medicos");
		Usuarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_MASK));
                //Creditos = new JMenu("Empleados");
                Rojo=new JMenuItem("Empleados");
                //Axul=new JMenuItem("Consultas Empleados");
                //Creditos.add(Rojo);
                //Creditos.add(Axul);
		Salir =new JMenuItem("Salir");
		Salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
                Archivo.add(Rojo);
                //Archivo.add(Configurar);
                //Archivo.add(Usuarios);
                Archivo.add(Salir);
//------------- Seccion de Clientes --------------------------------------------
		Clientes=new JMenuItem("Registrar Productos");
                Actualizar.add(Clientes);
//------------- Seccion de Prestamos -------------------------------------------
		Prestamos=new JMenuItem("Registrar Provedores");
                Actualizar.add(Prestamos);
//------------- Seccion de Empleados -------------------------------------------
                Empleados=new JMenuItem("Consultas Generales");
                AltasE=new JMenuItem("Modificar/Eliminar");
                //Actualizar.add(Empleados);
                //Actualizar.add(AltasE);
//------------- Seccion de Creditos -----------------------------------------
		//Creditos = new JMenu("Venta");
                NuevoC=new JMenuItem("Expedir Venta");
                //Creditos.add(NuevoC);
                Operaciones.add(NuevoC);
//------------- Seccion de Consultas -----------------------------------------
		Consultas = new JMenu("Medico");
                BajasP=new JMenuItem("Expedir Consulta Medica");
                Con_Deudores=new JMenuItem("Consultar Receta");
                //Consultas.add(Con_Deudores);
                Consultas.add(BajasP);
//------------- Seccion de Cobros -----------------------------------------
		Cobros = new JMenu("Cajero");
                Cobrar_Cliente=new JMenuItem("Cobrar Venta");
                Con_Cre=new JMenuItem("Cobrar Consulta Medica");
                Cobros.add(Cobrar_Cliente);
                Cobros.add(Con_Cre);
//------------- Seccion de Ayuda -------------------------------------------
                Manual=new JMenuItem("Manual de Usuario");
                Acerca=new JMenuItem("Acerca de Sistema Farmaceutico Del Ismto");
                Ayuda.add(Manual);
                Ayuda.add(Acerca);
		barramenu.setBounds(0, 0,tama.width, 30);
		barramenu.add(Archivo);
		barramenu.add(Actualizar);
		barramenu.add(Operaciones);
                barramenu.add(Consultas);
                barramenu.add(Cobros);
                barramenu.add(Ayuda);
                setJMenuBar( barramenu );
		barra = new JToolBar("Barra");
		botones=new JButton[11];
		for(int i=0;i<11;i++){

			botones[i]=new JButton();
			botones[i].setSize(30,30);
		}
                botones[2].setMnemonic('A');
                botones[2].setToolTipText("Registar Productos");
		botones[2].setIcon(new ImageIcon("Producto.png"));
                botones[1].setMnemonic('B');
                botones[1].setToolTipText("Registrar Proveedores");
		botones[1].setIcon(new ImageIcon("Provedore.png"));
                botones[0].setMnemonic('C');
                botones[0].setToolTipText("Registrar Empleados");
		botones[0].setIcon(new ImageIcon("Empleado.png"));
//                botones[3].setMnemonic('D');
//                botones[3].setToolTipText("Consulta De Productos");
//		botones[3].setIcon(new ImageIcon("Consulta.png"));
//                botones[3].setMnemonic('E');
//                botones[3].setToolTipText("Generar Una Venta");
//		botones[3].setIcon(new ImageIcon("Venta.png"));

                botones[4].setMnemonic('F');
                botones[4].setToolTipText("Expedir Venta");
		botones[4].setIcon(new ImageIcon("Producto.png"));
                botones[5].setMnemonic('G');
                botones[5].setToolTipText("Expedir Consulta Medica");
		botones[5].setIcon(new ImageIcon("Provedore.png"));
                
                botones[6].setMnemonic('H');
                botones[6].setToolTipText("Cobrar Venta");
		botones[6].setIcon(new ImageIcon("Empleado.png"));
                botones[7].setMnemonic('I');
                botones[7].setToolTipText("Cobrar Consulta Medica");
		botones[7].setIcon(new ImageIcon("Consulta.png"));
                botones[9].setMnemonic('J');
                botones[9].setToolTipText("Acerca del Sistema De Venta");
		botones[9].setIcon(new ImageIcon("Venta.png"));
                botones[8].setMnemonic('L');
                botones[8].setToolTipText("Manual de Usuario");
		botones[8].setIcon(new ImageIcon("Venta.png"));                
                
                
                botones[10].setToolTipText("Salir");
		botones[10].setIcon(new ImageIcon("Salir.png"));
                botones[10].setMnemonic('K');
		for(int i=0;i<11;i++){
                    if(i!=3){
                    	barra.add(botones[i]);
			botones[i].setPreferredSize(new Dimension(10,50));
                        botones[i].addActionListener(new Control.ControlVistaPrincipal(this));
                    }
		}
                add(barra,BorderLayout.NORTH);
                Puesto_Usuario = Pues;
                Nombre_Usuario =Nombre;
                String User = "Usuario: "+Nombre;
                String Puesto = "Puesto: "+Pues;
                Archivo2= new JMenu(User);
                Archivo3= new JMenu(Puesto);
                barralateral.add(Archivo2);
                barralateral.add(Archivo3);
                add(barralateral,BorderLayout.SOUTH);
                //add(barralateral,BorderLayout.SOUTH);
                //**************************************************************
                elEscritorio = new JDesktopPane();
                getContentPane().add( elEscritorio );
                //**************************************************************
                Salir.addActionListener(new Control.ControlVistaPrincipal(this));
                Clientes.addActionListener(new Control.ControlVistaPrincipal(this));
//                NuevoC.addActionListener(new Control.ControlVistaPrincipal(this));
//                Con_Cre.addActionListener(new Control.ControlVistaPrincipal(this));
//                Cobrar_Cliente.addActionListener(new Control.ControlVistaPrincipal(this));
                //**************************************************************

                if(Pues.equals("Cajero")){
                    
                    Operaciones.setEnabled(false);
                    Configurar.setEnabled(false);
                    Usuarios.setEnabled(false);
                    Consultas.setEnabled(false);
                    Cobros.setEnabled(true);
                    //Creditos.setEnabled(false);
                    Actualizar.setEnabled(false);
                    
                    botones[0].setEnabled(false);
                    botones[1].setEnabled(false);
                    botones[2].setEnabled(false);
                    botones[4].setEnabled(false);
                    botones[5].setEnabled(false);
                    botones[6].setEnabled(true);
                    botones[7].setEnabled(true);
                    botones[8].setEnabled(true);
                    botones[9].setEnabled(true);
                    botones[10].setEnabled(true);
                    
                }
                
                if(Pues.equals("Servicio")){
                    
                    Operaciones.setEnabled(true);
                    Configurar.setEnabled(false);
                    Usuarios.setEnabled(false);
                    Consultas.setEnabled(false);
                    Cobros.setEnabled(false);
                    //Creditos.setEnabled(false);
                    Actualizar.setEnabled(false);
                    
                    botones[0].setEnabled(false);
                    botones[1].setEnabled(false);
                    botones[2].setEnabled(false);
                    botones[4].setEnabled(true);
                    botones[5].setEnabled(false);
                    botones[6].setEnabled(false);
                    botones[7].setEnabled(false);
                    botones[8].setEnabled(true);
                    botones[9].setEnabled(true);
                    botones[10].setEnabled(true); 
                }
                
                if(Pues.equals("Almacenista")){

                    Operaciones.setEnabled(false);
                    Configurar.setEnabled(false);
                    Usuarios.setEnabled(false);
                    Consultas.setEnabled(false);
                    Cobros.setEnabled(false);
                    //Creditos.setEnabled(false);
                    Actualizar.setEnabled(true);
                    
                    botones[0].setEnabled(false);
                    botones[1].setEnabled(true);
                    botones[2].setEnabled(true);
                    botones[4].setEnabled(false);
                    botones[5].setEnabled(false);
                    botones[6].setEnabled(false);
                    botones[7].setEnabled(false);
                    botones[8].setEnabled(true);
                    botones[9].setEnabled(true);
                    botones[10].setEnabled(true);
                    
                }
                
                if(Pues.equals("Medico")){

                    Operaciones.setEnabled(false);
                    Configurar.setEnabled(false);
                    Usuarios.setEnabled(false);
                    Consultas.setEnabled(true);
                    Actualizar.setEnabled(false);
                    Cobros.setEnabled(false);
                    //Creditos.setEnabled(false);
                    botones[0].setEnabled(false);
                    botones[1].setEnabled(false);
                    botones[2].setEnabled(false);
                    botones[4].setEnabled(false);
                    botones[5].setEnabled(true);
                    botones[6].setEnabled(false);
                    botones[7].setEnabled(false);
                    botones[8].setEnabled(true);
                    botones[9].setEnabled(true);
                    botones[10].setEnabled(true);
                }
/*                
                if(Pues.equals("Con Poder")){
                    for(int i=0;i<11;i++){
    			botones[i].setEnabled(true);
            		}
                    Creditos.setEnabled(true);
                    Operaciones.setEnabled(true);
                    Configurar.setEnabled(true);
                    Usuarios.setEnabled(true);
                    Consultas.setEnabled(true);
                    Cobros.setEnabled(true);
                }
  */              
                
        }

        public void Crear_Panel_Usuario(String Nombre){

        }

        /*
        public static void main (String Args[]){


            try{


                UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
                LiquidLookAndFeel.setLiquidDecorations(true, "panther");
            }
            catch(Exception e){}


            VistaPrincipal v= new VistaPrincipal();
            v.diseno();
            v.setVisible(true);
            v.setTitle("SISTEMA FARMACEUTICO");
            v.setResizable(false);
            v.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        }*/
}
