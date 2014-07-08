package Vistas_Empleado;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Control.control_vista_clientes;

/**
 *
 * @author Tiago
 */
public class VistaClientes extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel clave;
	public JTextField claves;
	public JPanel Pruebita;
	public JLabel Imagen;
	public JPanel JP[]= new JPanel[6];
	public JLabel Jl[]= new JLabel[13];
	public JTextField Jt[]= new JTextField[13];
	public JTextArea Observaciones;
	public JTable t1;
	public JRadioButton rb1[]= new JRadioButton[4];
	public JCheckBox jcb;
	public ButtonGroup bg;
	public JLabel HuellaDigital;
	public String [] encabezados;
	public Icon Logo1= new ImageIcon();
	public Icon Logo2= new ImageIcon();
	public Icon logito= new ImageIcon ("Imagenes/logito.PNG");
	public ButtonGroup grupo;
	public JRadioButton op1;
	public JRadioButton op2;
	public JRadioButton op3;
	public JRadioButton op4;
	public JRadioButton op5;
    
    
	public ButtonGroup grupo2;
	public JRadioButton op6;
    public JRadioButton op7;
    public JRadioButton op8;
    
    public Aval ava= new Aval();
    public Datos_Laboral dl = new Datos_Laboral();
    public Propiedad propi = new Propiedad();
    public Vehiculo vehi = new Vehiculo();
    
    
    public JTextField Busqueda;
    @SuppressWarnings("rawtypes")
	public JComboBox Edo_Civil;
    @SuppressWarnings("rawtypes")
	public JComboBox Edo_Crediticio;
    @SuppressWarnings("rawtypes")
	public JComboBox Lim_Credito;
    public JButton JB[]= new JButton[9];

        public VistaClientes(){
        Disenio();
        }
//

        @SuppressWarnings({ "rawtypes", "unchecked" })
		public void Disenio(){
        setLayout(null);
        setSize(1024,550);
        for(int i=0; i<6;i++){
                JP[i]= new JPanel();
                JP[i].setLayout(null);
        }
        //Pruebita = new JPanel();
        //Pruebita.setLayout(null);
        //-------------- Crear Labels ------------------------------------------
        clave = new JLabel("Codigo Cliente: ");
        Jl[0]= new JLabel("Nombre(s): ");
        Jl[1]= new JLabel("Apellido(s): ");
        Jl[2]= new JLabel("Dirección: ");
        Jl[3]= new JLabel("Ciudad: ");
        
        
        Jl[4]= new JLabel("Telefono: ");
        Jl[5]= new JLabel("Estado Civil: ");
        Jl[6]= new JLabel("Estado Crediticio: ");
        Jl[7]= new JLabel("Limite De Crédito: ");
        Jl[8]= new JLabel("Eliminado: ");

        
        Edo_Civil = new JComboBox();
        Edo_Civil.addItem("");
        Edo_Civil.addItem("Viudo");
        Edo_Civil.addItem("Casado");
        Edo_Civil.addItem("Soltero");
        Edo_Civil.addItem("Divorciado");
        Edo_Civil.addItem("Union Libre");
        Edo_Civil.setBounds(450, 118, 150, 25);//Estado civil
        
        Edo_Crediticio = new JComboBox();
        Edo_Crediticio.addItem("");
        Edo_Crediticio.addItem("Regular");
        Edo_Crediticio.addItem("Moroso");
        Edo_Crediticio.setBounds(450, 178, 150, 25);//Estado crediticio

        
        op6 = new JRadioButton("Altas");
        op7 = new JRadioButton("Bajas");
        op8 = new JRadioButton("Cambios");
        op6.addActionListener(new control_vista_clientes(this));
        op7.addActionListener(new control_vista_clientes(this));
        op8.addActionListener(new control_vista_clientes(this));
        //op1.setSelected(true);
        op6.setBounds(20, 140, 100,25);
        op7.setBounds(150, 140, 100,25);
        op8.setBounds(250, 140, 100,25);
        //op6.addActionListener(this);
        grupo2 = new ButtonGroup();
        grupo2.add(op6);
        grupo2.add(op7);
        grupo2.add(op8);
        
        
        JP[3].add(op6);
        JP[3].add(op7);
        JP[3].add(op8);
        //---------------- Posicionarlos----------------------------------------
        clave.setBounds(20, 40,130,40);
        Jl[0].setBounds(20, 110,130,40);
        Jl[1].setBounds(20, 170,130,40);
        Jl[2].setBounds(20, 230,130,40);
        Jl[3].setBounds(20, 290,130,40);
        
        Jl[4].setBounds(330, 40,130,40);
        Jl[5].setBounds(330, 110,130,40);
        Jl[6].setBounds(330, 170,130,40);
        Jl[7].setBounds(330, 230,130,40);
        Jl[8].setBounds(330, 290,130,40);
/*        Jl[9].setBounds(330, 120,130,40);
        Jl[10].setBounds(330, 160,130,40);
        Jl[11].setBounds(330, 200,130,40);
        Jl[12].setBounds(330, 240,130,40);*/
        //-------------- Creamos los Jlabel y Jtextfield -----------------------
        for(int i=0;i<13;i++){
            Jt[i]= new JTextField();
        }
        //--------- Posicionando las cajas de Textos ---------------------------
        claves = new JTextField();
        claves.setBounds(120, 48, 180, 25);
        Jt[0].setBounds(120, 118, 180, 25);//nombre
        Jt[1].setBounds(120, 178, 180, 25);//ape
        Jt[2].setBounds(120, 238, 180, 25);//dir
        Jt[3].setBounds(120, 298, 180, 25);//cd
        
        
        Jt[4].setBounds(450, 48, 150, 25);//tel
        //Jt[5].setBounds(450, 118, 150, 25);
        //Jt[6].setBounds(450, 178, 150, 25);
        Jt[7].setBounds(450, 238, 150, 25);//limite de credito
        Jt[8].setBounds(450, 298, 150, 25);//cliente activo
        
        
       /* Jt[9].setBounds(450, 128, 150, 25);
        Jt[10].setBounds(450, 168, 150, 25);
        Jt[11].setBounds(450, 208, 150, 25);
        Jt[12].setBounds(450, 248, 150, 25);*/
        //----------------- Tabla de Clientes ----------------------------------
        /*
        String encabezados[] ={"Clave","Nombre","Apellido"};
        Object[][] datos={
            {200,"Tomás","Santiago"},
            {200,"karla","Cabrera"},
            {200,"Saúl","Morales"},
            {200,"Ángel","Espinoza"},
            {200,"Luis","Maldonado"},
            {200,"Marcos","Toledo"},
            {200,"Teresa","Gonzales"},
        };*/
        //Construir la Tabla con el constructor (cadena,matriz de objetos)
        DefaultTableModel modelo=new DefaultTableModel(); 
        modelo.addColumn("Clave");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        t1=new JTable(modelo);
        //agragar la tabla a un panel de desplazamiento
        JScrollPane scr=new JScrollPane(t1);
        //establece el tamaño del puerto de vista desplazable
        t1.setPreferredScrollableViewportSize(new Dimension(200,150));
        t1.addMouseListener(new control_vista_clientes(this));
        scr.setBounds(10, 30, 300,150);
        
        //----------------------- Huella Digital -------------------------------
        Imagen = new JLabel();
        Imagen.setIcon(logito);
        Imagen.setBorder(BorderFactory.createTitledBorder("Huella Digital"));
        Imagen.setBounds(220,30,140,140);
        //Imagen.setBackground(Color.red);
        //********************** campos de consultas ***************************
        grupo = new ButtonGroup();
        Busqueda= new JTextField();
        JB[0]= new JButton("Buscar");
        JB[1]= new JButton("Mostrar Todos");
        op1 = new JRadioButton("Por Apellido");
        op2 = new JRadioButton("Por Codigo");
        op3 = new JRadioButton("Por Ciudad");
        op4 = new JRadioButton("Por Estado");
        op1.setSelected(true);
        grupo.add(op1);
        grupo.add(op2);
        grupo.add(op3);
        grupo.add(op4);
        op1.setBounds(10, 20,130, 30);
        op2.setBounds(10, 50,130, 30);
        op3.setBounds(10, 80,130, 30);
        op4.setBounds(10, 110,130, 30);
        Busqueda.setBounds(140,115, 140, 25);
        JB[0].setBounds(140,35, 140, 26);
        JB[0].addActionListener(new control_vista_clientes(this));
        JB[1].setBounds(140,75, 140, 26);
        JB[1].addActionListener(new control_vista_clientes(this));
        JP[0].add(op1);
        JP[0].add(op2);
        JP[0].add(op3);
        JP[0].add(op4);
        JP[0].add(Busqueda);
        JP[0].add(JB[0]);
        JP[0].add(JB[1]);
        JP[0].setBounds(330,10,290,180);
        JP[0].setBorder(BorderFactory.createTitledBorder("Consultas"));
        JP[2].add(JP[0]);
        //************************* Botones ************************************
        JB[2]= new JButton("Nuevo Cliente");
        JB[3]= new JButton("Modificar Cliente");
        JB[4]= new JButton("Eliminar Cliente");
        JB[5]= new JButton("Limpiar Formulario");
        JB[6]= new JButton("Imprimir Lista Clientes");
        JB[7]= new JButton("Imprimir Datos Cliente");
        JB[8]= new JButton("Cerrar Ventana");
        
        JB[2].setBounds(8,20, 180, 26);
        JB[3].setBounds(192,20, 180, 26);
        JB[4].setBounds(8,60, 180, 26);
        JB[5].setBounds(192,60, 180, 26);
        JB[6].setBounds(8,100, 180, 26);
        JB[7].setBounds(192,100, 180, 26);
        //JB[8].setBounds(138,140, 180, 26);
        for(int i=2;i<9;i++){
        		JB[i].addActionListener(new control_vista_clientes(this));
                JP[3].add(JB[i]);
                JB[i].setEnabled(false);
        }
        JP[3].setBounds(630,9,383,190);
        JP[3].setBorder(BorderFactory.createTitledBorder("Acciones"));
        //************************* agregamos componentes al panel -------------
        //JP[2].add(Imagen);
        //************************* Avales y extras ****************************
        JTabbedPane JPs= new JTabbedPane();
        JPs.addTab("Aval", ava);
        JPs.addTab("Propiedad", propi);
        JPs.addTab("Vehiculo", vehi);
        JPs.addTab("Laboral",dl);
        JPs.setBounds(5,15,370,330);
        JP[4].add(JPs);
       
        //**********************************************************************
        JP[2].add(scr);
        JP[2].setBounds(0,0, 630,200);
        JP[1].setBounds(0,200,630,350);
        JP[4].setBounds(630, 200,383,350);
        JP[4].setBorder(BorderFactory.createTitledBorder("Datos Extras"));
        JP[2].setBorder(BorderFactory.createTitledBorder("Lista de Cliente"));
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
        for(int i=0; i<9;i++){
                JP[1].add(Jl[i]);
                JP[1].add(Jt[i]);
        }
        JP[1].add(Edo_Civil);
        JP[1].add(Edo_Crediticio);
        JP[1].add(clave);
        JP[1].add(claves);
        add(JP[2]);
        add(JP[1]);
        add(JP[3]);
        add(JP[4]);
        for(int i=0;i<7;i++){
        	  ava.Jt[i].setEnabled(false);
        	  propi.Jt[i].setEnabled(false);
        	  vehi.Jt[i].setEnabled(false);
        	  dl.Jt[i].setEnabled(false);
        	  Jt[i].setEnabled(false);
        }
        Jt[7].setEnabled(false);
        Jt[8].setEnabled(false);
        claves.setEnabled(false);
        Edo_Crediticio.setEnabled(false);
        Edo_Civil.setEnabled(false);
        }
}
