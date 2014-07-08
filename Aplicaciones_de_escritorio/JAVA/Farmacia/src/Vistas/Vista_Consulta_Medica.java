/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Control.ContolPane4_Mouse;
import Control.ControlPane4;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Administrador
 */
public class Vista_Consulta_Medica extends JPanel implements ActionListener{
    
    
    
    
	public JToolBar barra;
        public JTabbedPane JPs;
	public JButton[] botones;
	public ImageIcon ima;
	public JPanel contenedor = new JPanel();
	public JMenuItem tipo1,tipo2,tipo3,tipo4,tam1,tam2,tam3,tam4,tam5,bol,ital,xx;
        public JMenuItem Rojo,Axul,Negro;
        public JMenu ipo;
        public JPopupMenu Jx;
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
	public JMenuBar barramenu;
        public JComboBox Sexi;
    
    public JPanel JP[]= new JPanel[5];
    public JButton JB[]= new JButton[20];
    public JTextField JT[]= new JTextField[20];
    JLabel JL[]= new JLabel[20];
    public JCheckBox JCK[]= new JCheckBox[4];
    public JComboBox C;
    public JTable Valuacion2,Valuacion;
    
    Base_Datos.Sentecias_BD Op = new Base_Datos.Sentecias_BD();
    Vistas_Finales.VistaPrincipal Vf = new Vistas_Finales.VistaPrincipal();
    public Vista_Consulta_Medica(){
        Disenio();
        fRedeterminada= textarea.getFont();
    }

    public void Disenio() {
        setLayout(null);
        setSize(1000,570);
        for(int i=0;i<5;i++){
            JP[i] = new JPanel();
            JP[i].setLayout(null);
        }
        for(int i=0;i<20;i++){
            JT[i] = new JTextField();
        }
        //++++++++++++++++ Titulo ++++++++++++++++++++++++++++++++++++++++++++++
        JL[0]= new JLabel("FARMACIAS DEL ISTMO");
        JL[1]= new JLabel("       Sucursal Ixtepec");
        JL[2]= new JLabel("Calle Vicente Guerrero, Avenida Hidalgo Nº 90");
        JL[0].setBounds(435,5,150,30);
        JL[1].setBounds(435,25,150,30);
      //  JL[2].setBounds(370,45,300,30);
        add(JL[0]);
        add(JL[1]);
        add(JL[2]);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        
        JL[4] = new JLabel("Nombre :");
        JL[5] = new JLabel("Direccion: ");
        JL[6] = new JLabel("Ciudad: ");
        JL[7] = new JLabel("Telefono: ");
        
        
        JL[8] = new JLabel("Edad: ");
        JL[9] = new JLabel("Sexo: ");
        JL[10] = new JLabel("Peso: ");
        JL[11] = new JLabel("Altura: ");
        
        JL[4].setBounds(10,20,120,30);
        JL[5].setBounds(10,50,120,30);
        JL[6].setBounds(10,80,120,30);
        JL[7].setBounds(10,110,120,30);

        JL[8].setBounds(10,140,120,30);
        JL[9].setBounds(10,170,120,30);
        JL[10].setBounds(10,200,120,30);
        JL[11].setBounds(10,230,120,30);

        
/*        
        JL[8].setBounds(570,20,120,30);
        JL[9].setBounds(570,50,120,30);
        JL[10].setBounds(570,80,120,30);
        JL[11].setBounds(570,110,120,30);
*/      

        
        JT[4].setBounds(100,20,170,25);
        Sexi= new JComboBox();
        Sexi.addItem("H");
        Sexi.addItem("M");
        
        Sexi.setBounds(100,170,170,25);
        JT[5].setBounds(100,50,170,25);
        JT[6].setBounds(100,80,170,25);
        JT[7].setBounds(100,110,170,25);
/*
        
        JT[8].setBounds(700,20,220,25);
        JT[9].setBounds(700,50,220,25);
        JT[10].setBounds(700,80,220,25);
        JT[11].setBounds(700,110,220,25);*/

        JT[8].setBounds(100,140,170,25);
       // JT[9].setBounds(100,170,170,25);
        JT[10].setBounds(100,200,170,25);
        JT[11].setBounds(100,230,170,25);
        
        
        
        
/*        
        JB[1]= new JButton("Guardar");
        JB[1].setBounds(10,230, 100,25);
        JP[1].add(JB[1]);
        JB[2]= new JButton("Modificar");
        JB[2].setBounds(140,230, 100,25);
        JP[1].add(JB[2]);
        JB[3]= new JButton("Guardar");
        JB[3].setBounds(270,230, 100,25);
        JP[1].add(JB[3]);
        
        
        JB[1].setEnabled(false);
        JB[2].setEnabled(false);
        JB[3].setEnabled(false);
        */
        JP[1].add(JL[4]);
        JP[1].add(JL[5]);
        JP[1].add(JL[6]);
        JP[1].add(JL[7]);
        JP[1].add(JL[8]);
        JP[1].add(JL[9]);
        JP[1].add(JL[10]);
        JP[1].add(JL[11]);
        
        JP[1].add(Sexi);
        JP[1].add(JT[4]);
        JP[1].add(JT[5]);
        JP[1].add(JT[5]);
        JP[1].add(JT[6]);
        JP[1].add(JT[7]);
        JP[1].add(JT[8]);
        JP[1].add(JT[9]);
        JP[1].add(JT[10]);
        JP[1].add(JT[11]);
               
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos Del Cliente"));
        JP[1].setBounds(10,70,310,270);
        add(JP[1]);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       /* 
        JTabbedPane JPx= new JTabbedPane();
        JPx.addTab("Receta Medica", new Panel4());
        JPx.setBounds(350, 60, 630, 500);
        add(JPx);*/
        //*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        
        
        JL[12] = new JLabel("Identificador :");
        JL[13] = new JLabel("Nombre: ");
        JL[14] = new JLabel("Especialidad: ");
        JL[15] = new JLabel("Cedula: ");
        
        JL[12].setBounds(10,20,120,30);
        JL[13].setBounds(10,50,120,30);
        JL[14].setBounds(10,80,120,30);
        JL[15].setBounds(10,110,120,30);
        JT[12].setEnabled(false);
        JT[13].setEnabled(false);
        JT[14].setEnabled(false);
        JT[15].setEnabled(false);
        JT[12].setBounds(100,20,170,25);
        JT[13].setBounds(100,50,170,25);
        JT[14].setBounds(100,80,170,25);
        JT[15].setBounds(100,110,170,25);      
        
        JP[2].add(JL[12]);
        JP[2].add(JL[13]);
        JP[2].add(JL[14]);
        JP[2].add(JL[15]);
        
        
        Op.Open();
        
        JT[12].setText(Op.Obtener_Id(Vf.Nombre_Usuario));
        JT[13].setText(Vf.Nombre_Usuario);
        JT[14].setText(Op.Obtener_Especialidad(Vf.Nombre_Usuario));
        JT[15].setText(Op.Obtener_Cedula(Vf.Nombre_Usuario));
        
        Op.Close();
        
        
        
        JP[2].add(JT[12]);
        JP[2].add(JT[13]);
        JP[2].add(JT[14]);
        JP[2].add(JT[15]);
        
        JP[2].setBorder(BorderFactory.createTitledBorder("Datos Del Empleado"));
        JP[2].setBounds(10,340,310,150);
        add(JP[2]);
        
        JB[0]=new JButton("Imprimir");
        JB[1]=new JButton("Limpiar");
        JB[0].addActionListener(new Control.Control_Consulta_Medica(this));
        JB[1].addActionListener(new Control.Control_Consulta_Medica(this));
        
        JB[1].addActionListener(this);
        JB[0].addActionListener(this);
        
        JB[0].setBounds(50,20, 100, 25);
        JB[1].setBounds(170,20, 100, 25);
        
        JP[3].add(JB[0]);
        JP[3].add(JB[1]);
        
        
       // JP[4].add(Aqui);
        
        JP[4].setBorder(BorderFactory.createTitledBorder("Empleado"));
        JP[4].setBounds(350, 60, 630, 500);
        add(JP[4]);
        
        JP[3].setBorder(BorderFactory.createTitledBorder("Empleado"));
        JP[3].setBounds(10,490,310,60);
        add(JP[3]);
        
        
        
        
        ///////////////////////////////////////////////////////////
        
		//setLayout(null);
		barramenu = new JMenuBar();
		archivo = new JMenu("Archivo");
		archivo.setMnemonic('A');
		edicion = new JMenu("Edicion");
		edicion.setMnemonic('E');
		formato = new JMenu("Formato");
		formato.setMnemonic('F');
		tipo = new JMenu("Tipo");
		tipo.setMnemonic('T');
		color = new JMenu("Colores");
		color.setMnemonic('C');
		tipof = new JMenu("Tipo de fuente");
		tipof.setMnemonic('F');
		tamaño = new JMenu("Tamaño de la fuente");
		tamaño.setMnemonic('L');

		nuevo =new JMenuItem("Nuevo");
		nuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		guardar=new JMenuItem("Salir");
		//guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		copiar =new JMenuItem("Copiar");
		copiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		pegar=new JMenuItem("Pegar");
		pegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
		borrar=new JMenuItem("Borrar");
		borrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));

		nuevo2 =new JMenuItem("Nuevo");
		nuevo2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		copiar2 =new JMenuItem("Copiar");
		copiar2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		pegar2=new JMenuItem("Pegar");
		pegar2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
		borrar2=new JMenuItem("Borrar");
		borrar2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));

		archivo.add(nuevo);
		//archivo.add(guardar);
		edicion.add(copiar);
		edicion.add(pegar);
		edicion.add(borrar);


		barramenu.setBounds(0, 0, 800, 30);
		barramenu.add(archivo);
		barramenu.add(edicion);
		barramenu.add(formato);
		barramenu.add(tipo);
		JP[4].add(barramenu);

                //-------------------------ventana emergente

                //textarea.add(JP);
                //JP.addMouseListener(new ContolPane4_Mouse(this));


/*
                String Estilitos[]={"Negritas","Cursiva","Normal"};
                Estilikos = new JCheckBoxMenuItem[Estilitos.length];
                for(int i=0;i<2;i++){
                    Estilikos[i]= new JCheckBoxMenuItem(Estilitos[i]);
                    Estilooos.add(Estilikos[i]);
                   //Hola.add(Estilikos[i]);

                    //Estilikos[i].addActionListener(new ControlPane4(this));
                }
                formato.add(Estilooos);*/
                //formato.addSeparator();
		String colores[]={"Rojo","Azul","Negro"};
		colorfuente =new JRadioButtonMenuItem[colores.length];
		grupocolorfuente=new ButtonGroup();
		for(int i=0;i<colores.length;i++)
		{
			colorfuente[i]=new JRadioButtonMenuItem(colores[i]);
			color.add(colorfuente[i]);
			grupocolorfuente.add(colorfuente[i]);
			colorfuente[i].addActionListener(new ControlPane4(this));
		}
		formato.add(color);
		colorfuente[2].setSelected(true);
		formato.addSeparator();
		String fuente[]={"Times New Roman","Arial","Calibri","Predeterminado"};
		tiposfuente=new JRadioButtonMenuItem[fuente.length];
		grupotiposfuente=new ButtonGroup();
		for(int i=0;i<fuente.length;i++)
		{
			tiposfuente[i]=new JRadioButtonMenuItem(fuente[i]);
			tipof.add(tiposfuente[i]);
			grupotiposfuente.add(tiposfuente[i]);
			tiposfuente[i].addActionListener(new ControlPane4(this));
		}
		formato.add(tipof);
		tiposfuente[3].setSelected(true);
		formato.addSeparator();
		String tamfuente[]={"12","13","14","16","Prederminado"};
		tamañofuente=new JRadioButtonMenuItem[tamfuente.length];
		grupotamañofuente=new ButtonGroup();
		for(int i=0;i<tamfuente.length;i++)
		{
			tamañofuente[i]=new JRadioButtonMenuItem(tamfuente[i]);
			tamaño.add(tamañofuente[i]);
			grupotamañofuente.add(tamañofuente[i]);
			tamañofuente[i].addActionListener(new ControlPane4(this));
		}
		formato.add(tamaño);
		tamañofuente[4].setSelected(true);

		normal=new JCheckBoxMenuItem("Normal");
		negritas=new JCheckBoxMenuItem("Negritas");
		cursiba=new JCheckBoxMenuItem("Cursiva");
		//subrayado=new JCheckBoxMenuItem("Subrayado");
		tipo.add(normal);
		tipo.add(negritas);
		tipo.add(cursiba);
//		tipo.add(subrayado);
                formato.add(tipo);

		barra = new JToolBar("Barra");
		botones=new JButton[5];
		for(int i=0;i<5;i++){

			botones[i]=new JButton();
			botones[i].setSize(30,30);
		}
                botones[0].setMnemonic('N');
                botones[0].setToolTipText("Nuevo");
		botones[0].setIcon(new ImageIcon("new.png"));
                //botones[1].setMnemonic('A');
		//botones[1].setIcon(new ImageIcon("abrir.jpg"));
                botones[1].setMnemonic('B');
                botones[1].setToolTipText("Cortar");
		botones[1].setIcon(new ImageIcon("cute.png"));
                botones[2].setMnemonic('C');
                botones[2].setToolTipText("Copiar");
		botones[2].setIcon(new ImageIcon("Copiar.png"));
                //botones[4].setMnemonic('G');
		//botones[4].setIcon(new ImageIcon("guardar.jpg"));
                botones[3].setMnemonic('I');
                botones[3].setToolTipText("Imprimir");
		botones[3].setIcon(new ImageIcon("print.png"));
                botones[4].setMnemonic('V');
                botones[4].setToolTipText("Pegar");
		botones[4].setIcon(new ImageIcon("paste.png"));
		for(int i=0;i<5;i++){

                    	barra.add(botones[i]);
			botones[i].setPreferredSize(new Dimension(10,20));
                        botones[i].addActionListener(new ControlPane4(this));
		}
		barra.setBounds(0,30,800,70);
		JP[4].add(barra);
                barra.disable();
		JP[4].add(contenedor);




		textarea=new JTextArea();
		textarea.setBounds(20,120,590,330);
		JP[4].add(textarea);

                Jx= new JPopupMenu();
                Jx.add(copiar2);
                Jx.add(pegar2);
                Jx.add(borrar2);
                Jx.add(nuevo2);
   /*             
                
        JTabbedPane JPs= new JTabbedPane();
        JPs.addTab("Menu", new Panel());
        JPs.addTab("Menu 2",new Panel2());
        add(JPs);
        JPs.setBounds(0,100,500,100);
                
  Ç*/              
                textarea.addMouseListener(new ContolPane4_Mouse(this));

		normal.addActionListener(new ControlPane4(this));
		cursiba.addActionListener(new ControlPane4(this));
		negritas.addActionListener(new ControlPane4(this));
		//subrayado.addActionListener(new ControlPane4(this));
		nuevo.addActionListener(new ControlPane4(this));
		guardar.addActionListener(new ControlPane4(this));
		copiar.addActionListener(new ControlPane4(this));
		pegar.addActionListener(new ControlPane4(this));
		borrar.addActionListener(new ControlPane4(this));
                nuevo2.addActionListener(new ControlPane4(this));
		copiar2.addActionListener(new ControlPane4(this));
		pegar2.addActionListener(new ControlPane4(this));
		borrar2.addActionListener(new ControlPane4(this));
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
        
        
        
    }
    /*
   public static void main(String Args[]){
        Vista_Consulta_Medica Cm = new Vista_Consulta_Medica();
        Cm.Disenio();
        Cm.setVisible(true);
        Cm.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
    */
/*
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == JB[1] ){
            
             for(int i=0;i<12;i++){
                    JT[i].setText("");
             }
            
        }/*
        if(e.getSource()== JB[0]){
                JOptionPane.showMessageDialog(null,Aqui.textarea);
         */       
