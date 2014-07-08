/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
//import com.birosoft.liquid.LiquidLookAndFeel;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
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
                @SuppressWarnings("unused")
				Vistas.Acceso ac= new Vistas.Acceso();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Toolkit tk = Toolkit.getDefaultToolkit();
                Dimension tama = tk.getScreenSize();
                barramenu = new JMenuBar();
                barralateral = new JMenuBar();
              //------------- Seccion de Menus -----------------------------------------------
        		Archivo = new JMenu("Archivo");
        		Actualizar = new JMenu("Actualizaciones");
        		Operaciones = new JMenu("Operaciones");
                        Ayuda = new JMenu("Ayuda");
        //------------- Seccion de Archivo ---------------------------------------------
        		Configurar =new JMenuItem("Configurar Sistema");
                        Configurar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
        		Usuarios=new JMenuItem("Usuarios");
        		Usuarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_MASK));
        		Salir =new JMenuItem("Salir");
        		Salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
                        //Salir.addActionListener(new Control.Control_Usuario(this));
                        //Archivo.add(Configurar);
                       // Archivo.add(Usuarios);
                        Archivo.add(Salir);
        //------------- Seccion de Clientes --------------------------------------------
        		Clientes=new JMenuItem("Clientes");
                        AltasC=new JMenuItem("Nueva Amortización");
                        BajasC= new JMenuItem("Eliminar Un Clientes");
                        ModificarC= new JMenuItem("Modificar un Cliente");
                        /*Clientes.add(AltasC);
                        Clientes.add(BajasC);
                        Clientes.add(ModificarC);*/
                        Actualizar.add(Clientes);
        //------------- Seccion de Prestamos -------------------------------------------
        		Prestamos=new JMenuItem("Prestamos");
                        /*AltasP=new JMenuItem("Registrar Un Prestamo");//AltasP.setFont("Arial",Font.BOLD,12);
                        BajasP= new JMenuItem("Eliminar Un Prestamo");
                        ModificarP= new JMenuItem("Modificar Un Prestamo");
                        Prestamos.add(AltasP);
                        Prestamos.add(BajasP);
                        Prestamos.add(ModificarP);*/
                        //Actualizar.add(Prestamos);
        //------------- Seccion de Empleados -------------------------------------------
                        Empleados=new JMenuItem("Empleados");
                        /*AltasE=new JMenuItem("Registrar Un Empleados");
                        BajasE= new JMenuItem("Eliminar Un Empleados");
                        ModificarE= new JMenuItem("Modificar Un Empleados");
                        Empleados.add(AltasE);
                        Empleados.add(BajasE);
                        Empleados.add(ModificarE);*/
                       // Actualizar.add(Empleados);
        //------------- Seccion de Creditos -----------------------------------------
        		Creditos = new JMenu("Prestamo");
                        NuevoC=new JMenuItem("Nuevo Prestamo");
                        Creditos.add(NuevoC);
                        Creditos.add(AltasC);
                        Operaciones.add(Creditos);
        //------------- Seccion de Consultas -----------------------------------------
        		Consultas = new JMenu("Consultas");
                        Con_Cre=new JMenuItem("Consulta de Prestamos");
                        Con_Cobro=new JMenuItem("Consulta de Cobros");
                        Con_Deudores=new JMenuItem("Consulta de Deudores");
                        Consultas.add(Con_Cre);
                        Consultas.add(Con_Cobro);
                        Consultas.add(Con_Deudores);
                        //Operaciones.add(Consultas);
        //------------- Seccion de Cobros -----------------------------------------
        		Cobros = new JMenu("Cobros");
                        Cobrar_Cliente=new JMenuItem("Cobrar Cuota");
                        Cobros.add(Cobrar_Cliente);
                        Operaciones.add(Cobros);
        //------------- Seccion de Ayuda -------------------------------------------
                        Manual=new JMenuItem("Manual de Usuario");
                       // Acerca=new JMenuItem("Acerca de Sistema de Credito");
                        Ayuda.add(Manual);
                        //Ayuda.add(Acerca);
        		barramenu.setBounds(0, 0,tama.width, 30);
                        //barralateral.setBounds(0,(tama.height-90),tama.width,40);
        		barramenu.add(Archivo);
        		barramenu.add(Actualizar);
        		barramenu.add(Operaciones);
                        barramenu.add(Ayuda);
                        setJMenuBar( barramenu );
        		//add(barramenu);
                        //add(barralateral);
        		barra = new JToolBar("Barra");
        		botones=new JButton[8];
        		for(int i=0;i<8;i++){

        			botones[i]=new JButton();
        			botones[i].setSize(50,50);
        		}
                        botones[0].setMnemonic('N');
                        botones[0].setToolTipText("Registro de Clientes");
        		botones[0].setIcon(new ImageIcon("src/Imagenes/ACTUALIZAR.jpg"));
                        botones[1].setMnemonic('B');
                        botones[1].setToolTipText("Tabla de Amortización");
        		botones[1].setIcon(new ImageIcon("src/Imagenes/vender.jpg"));
                        botones[2].setMnemonic('C');
                        botones[2].setToolTipText("Registro de Prestamos");
        		botones[2].setIcon(new ImageIcon("src/Imagenes/almacen.jpg"));
                        botones[3].setMnemonic('I');
                        botones[5].setToolTipText("Acerca de Sistema Prestamo");
        		botones[5].setIcon(new ImageIcon("src/Imagenes/home.jpg"));
                        botones[5].setMnemonic('M');
                        
                        botones[6].setToolTipText("Manual de Usuario");
        		botones[6].setIcon(new ImageIcon("src/Imagenes/interoggacion.jpg"));
                        botones[6].setMnemonic('M');
                        
                        botones[7].setToolTipText("Salir");
        		botones[7].setIcon(new ImageIcon("src/Imagenes/salir.jpg"));
                        botones[7].setMnemonic('M');
                        
                        botones[3].setToolTipText("Consultar deudores");
        		botones[3].setIcon(new ImageIcon("src/Imagenes/buscar.jpg"));
                        botones[4].setMnemonic('V');
                        botones[4].setToolTipText("Cobrar Cuotas");
        		botones[4].setIcon(new ImageIcon("src/Imagenes/altas.jpg"));
        		for(int i=0;i<8;i++){
        			if(i==5 || i==3){
        				
        			}
        			else{
                    	barra.add(botones[i]);
						botones[i].setPreferredSize(new Dimension(60,60));
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
                NuevoC.addActionListener(new Control.ControlVistaPrincipal(this));
                AltasC.addActionListener(new Control.ControlVistaPrincipal(this));
                Manual.addActionListener(new Control.ControlVistaPrincipal(this));
                Con_Cre.addActionListener(new Control.ControlVistaPrincipal(this));
                Cobrar_Cliente.addActionListener(new Control.ControlVistaPrincipal(this));                //**************************************************************
/*
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
                }*/

        }
}
