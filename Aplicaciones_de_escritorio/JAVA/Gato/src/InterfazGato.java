import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InterfazGato extends JFrame implements ActionListener
{
    JPanel niveles,juego,marcador,p1,jugadores,principal,principalmarcador,p2_2,pG,botones;
    JButton nuevo,salir;
    JButton [][] matrizbotones;
    JLabel jugador1,jugador2,mensaje,empate;
    JFormattedTextField textjugador1,textjugador2,textempate;
    JTextField textmensaje;
    CheckboxGroup nivelesjugar;
    JMenuBar barramenu=new JMenuBar();
    JMenu archivo=new JMenu("Archivo");
    JMenuItem nuevoj=new JMenuItem("Nuevo...");
    JMenuItem salirj=new JMenuItem("Salir");
    JMenu cambiarjugadores=new JMenu("Cambiar jugador"); 
    JMenu editar=new JMenu("Jugadores");
    JMenu ver=new JMenu("Ver");
    BorderLayout p;
    Font fuente = new Font("Times New Roman",Font.BOLD, 48);
    Computadora jugadorcomputadora=new Computadora();
    public static String gato1 = "O";//usuario
    public static String gato2 = "X";//computadora
    public int contadorcomputadora=0;
    public int contadorusuario=0;
    public int contadorempate=0;
    public InterfazGato()
    {
    	matrizbotones=new JButton[3][3];
        setTitle("JUEGO");
        setSize(600,400);
        //barra menu
        archivo.add(nuevoj);
        archivo.add(salirj);
        salirj.addActionListener(this);
        barramenu.add(archivo);
        editar.add(cambiarjugadores);
        barramenu.add(editar);//jugadores
        barramenu.add(ver);
        add(barramenu,BorderLayout.NORTH);
        //creacion de los paneles
        principal = new JPanel();
        niveles = new JPanel();
        juego = new JPanel();
        jugadores = new JPanel();
        principalmarcador = new JPanel();
        botones = new JPanel();
        marcador = new JPanel();
        
        niveles.setLayout(new FlowLayout());
        principal.setLayout(new GridLayout());
        principalmarcador.setLayout(new BorderLayout());
        jugadores.setLayout(new GridLayout(4,4,5,5));
        botones.setBorder(BorderFactory.createTitledBorder("Botones"));//titulo de botones
        juego.add(creabotones());//crea botones para el juego
        
        jugador1 = new JLabel("Usuario"); 
        
        textjugador1 =new JFormattedTextField(new Integer(contadorusuario));
        jugador2 = new JLabel("Computadora");
        textjugador2 =new JFormattedTextField(new Integer(contadorcomputadora));
        mensaje=new JLabel("Mensaje");
        textmensaje=new JTextField();
        empate=new JLabel("Empate");
        textempate =new JFormattedTextField(new Integer(contadorempate));
        jugadores.add(jugador1);
        jugadores.add(textjugador1);
        jugadores.add(jugador2);
        jugadores.add(textjugador2);
        jugadores.add(mensaje);
        jugadores.add(textmensaje);
        jugadores.add(empate);
        jugadores.add(textempate);
        jugadores.setBorder(BorderFactory.createTitledBorder("Jugadores"));//border al panel de jugadores
        marcador.add(jugadores);
        principalmarcador.add(creajuegonuevo());
        principalmarcador.add(salirjuego());
        principalmarcador.add(marcador,BorderLayout.NORTH);
        principalmarcador.setBorder(BorderFactory.createTitledBorder("Marcador"));//border al panel de marcador
        principal.add(juego);
		juego.setBorder(BorderFactory.createTitledBorder("Juego"));
		principal.add(principalmarcador, BorderLayout.EAST);
        niveles.setSize(400,50);//tamaño del panel de los niveles
		nivelesjugar=new CheckboxGroup();
		niveles.add(new Checkbox("Nivel 1",nivelesjugar,true));
		niveles.add(new Checkbox("Nivel 2",nivelesjugar,true));
		niveles.add(new Checkbox("Nivel 3",nivelesjugar,true));
		niveles.setBorder(BorderFactory.createTitledBorder("Niveles"));//border a niveles
		add(niveles,BorderLayout.SOUTH);
		principal.setBorder(BorderFactory.createTitledBorder("Juego Gato"));//border al panel central
        add(principal, BorderLayout.CENTER);
        principal.setBackground(Color.blue);
        add(niveles,BorderLayout.SOUTH );
        setVisible(true);
        juegonuevo();
    }
    public JPanel creabotones()
    {
        JPanel juego = new JPanel();
        juego.setLayout(new GridLayout(3,3,5,5));
        juego.setBorder(BorderFactory.createEmptyBorder(10,10,5,5));
        juego.setBackground(Color.red);
        for(int f=0; f<3; f++)
        {
            for(int c=0; c<3; c++)
            {
                matrizbotones[f][c] = new JButton();
                matrizbotones[f][c].addActionListener(this);
                matrizbotones[f][c].getText();//tamaño de los botones
                matrizbotones[f][c].setFont(fuente);
                juego.add(matrizbotones[f][c]);
            }
        }
        return juego;
    }
    public JPanel creajuegonuevo()
    {
        JPanel marcador = new JPanel();
        botones.add(nuevo = new JButton("Juego Nuevo"), BorderLayout.CENTER);
        marcador.add(botones);
        nuevo.addActionListener(this);
        return marcador;
    }  
    public JPanel salirjuego()
    {
    	JPanel marcador=new JPanel();
    	JMenuItem salirj=new JMenuItem("Salir");
    	barramenu.add(salirj);
    	botones.add(salir=new JButton("Salir"),BorderLayout.EAST);
    	marcador.add(botones);
    	salir.addActionListener(this);
    	salirj.addActionListener(this);
    	return marcador;
    }
    public void diagonalprincipal()
    {
        int aux1 = 0;
        int aux2 = 0;
        for(int f=0; f<3; f++)
        {
            for(int c=0; c<3; c++)
            {
                if(f==c)
                {
                    if(matrizbotones[f][c].getText() != null)
                    {
                        if(matrizbotones[f][c].getText().equals(gato1))
                        {
                            aux1++;
                            if(aux1==3)
                            {
                            	contadorusuario++;//aumenta ganados
                            	textjugador1.setValue(contadorusuario);//muestra el valor en una caja de texto
                            	textmensaje.setText("Tu ganas");
                               this.juegonuevo();
                            }
                        }
                        else if(matrizbotones[f][c].getText().equals(gato2))
                        {
                            aux2++;
                            if(aux2==3)
                            {
                            	contadorcomputadora++;//aumenta ganados
                            	textjugador2.setValue(contadorcomputadora);//muestra en caja de texto
                            	textmensaje.setText("Gana computadora");                                
                                this.juegonuevo();
                            }
                        }
                    }                    
                }
            }
        }
    }
    public void diagonalsecundaria()
    {
        int aux1 = 0;
        int aux2 = 0;
        //int numfilas = 3;
        //int numcolumna = 3;
        for(int f=0; f<3; f++){
            for(int c=0; c<3; c++){
                if((f + c) == (3 - 1)){
                    if(matrizbotones[f][c].getText() != null){

                        if(matrizbotones[f][c].getText().equals(gato1)){
                            aux1++;
                            if(aux1==3)
                            {
                            	contadorusuario++;//aumenta ganados
                            	textjugador1.setValue(contadorusuario);//muestra el valor en una caja de texto
                            	textmensaje.setText("Tu ganas");
                               this.juegonuevo();
                            }
                        }
                        else if(matrizbotones[f][c].getText().equals(gato2)){
                            aux2++;
                            if(aux2==3)
                            {
                            	contadorcomputadora++;//aumenta ganados
                            	textjugador2.setValue(contadorcomputadora);//muestra en caja de texto
                            	textmensaje.setText("Gana computadora");
                                this.juegonuevo();
                            }
                        }
                    }
                }
            }
        }
    }  
    public void filas()
    {
    	int aux1=0,aux2=0;
    	//int aux2=0;
    	for(int fila=0;fila<3;fila++)
    	{
    		for(int columna=0;columna<3;columna++)
    		{
    			if(matrizbotones[fila][columna].getText()!=null)
    			{
    				if(matrizbotones[fila][columna].getText().equals(gato1))
    				{
    					aux1++;
    					if(aux1==3)
                        {
                        	contadorusuario++;//aumenta ganados
                        	textjugador1.setValue(contadorusuario);//muestra el valor en una caja de texto
                        	textmensaje.setText("Tu ganas");
                        	this.juegonuevo();
                        }
    				}
    				else 
    				if(matrizbotones[fila][columna].getText().equals(gato2))
                    {
                        aux2++;
                        if(aux2==3)
                        {
                        	contadorcomputadora++;//aumenta ganados
                        	textjugador2.setValue(contadorcomputadora);//muestra en caja de texto
                        	textmensaje.setText("Gana computadora");
                            this.juegonuevo();
                        }
                    }
    			}
    		}
    		aux1=0;
    		aux2=0;
    	}
    }
    public void columnas()
    {
    	int aux1=0,aux2=0;
    	for(int fila=0;fila<3;fila++)
    	{
    		for(int columna=0;columna<3;columna++)
    		{
    			if(matrizbotones[columna][fila].getText() != null)
    			{
                    if(matrizbotones[columna][fila].getText().equals(gato1))
                    {
                        aux1++;
                        if(aux1==3)
                        {
                        	contadorusuario++;//aumenta ganados
                        	textjugador1.setValue(contadorusuario);//muestra el valor en una caja de texto
                        	textmensaje.setText("Tu ganas");
                            this.juegonuevo();
                        }
                    }
                    else 
                    if(matrizbotones[columna][fila].getText().equals(gato2))
                    {
                        aux2++;
                        if(aux2==3)
                        {
                        	contadorcomputadora++;//aumenta ganados
                        	textjugador2.setValue(contadorcomputadora);//muestra en caja de texto
                        	textmensaje.setText("Gana computadora");
                            this.juegonuevo();
                        }
                    }
                }
    		}
    		aux1=0;
    		aux2=0;
    	}
    }
    /*public void filasuperior()
    {
        int aux1 = 0;
        int aux2 = 0;
        for(int c=0; c<3; c++)
        {
            if(matrizbotones[0][c].getText() != null)
            {

                if(matrizbotones[0][c].getText().equals(gato1))
                {
                    aux1++;
                    if(aux1==3)
                    {
                    	contadorusuario++;//aumenta ganados
                    	textjugador1.setValue(contadorusuario);//muestra el valor en una caja de texto
                    	textmensaje.setText("Tu ganas");
                       this.juegonuevo();
                    }
                }
                else if(matrizbotones[0][c].getText().equals(gato2))
                {
                    aux2++;
                    if(aux2==3)
                    {
                    	contadorcomputadora++;//aumenta ganados
                    	textjugador2.setValue(contadorcomputadora);//muestra en caja de texto
                    	textmensaje.setText("Gana computadora");
                        this.juegonuevo();
                    }
                }
            }            
        }
    }
    public void filamedia()
    {
        int aux1 = 0;
        int aux2 = 0;
        for(int c=0; c<3; c++){
            if(matrizbotones[1][c].getText() != null)
            {
                if(matrizbotones[1][c].getText().equals(gato1))
                {
                    aux1++;
                    if(aux1==3)
                    {
                    	contadorusuario++;//aumenta ganados
                    	textjugador1.setValue(contadorusuario);//muestra el valor en una caja de texto
                    	textmensaje.setText("Tu ganas");
                       this.juegonuevo();
                    }
                }
                else if(matrizbotones[1][c].getText().equals(gato2))
                {
                    aux2++;
                    if(aux2==3)
                    {
                    	contadorcomputadora++;//aumenta ganados
                    	textjugador2.setValue(contadorcomputadora);//muestra en caja de texto
                    	textmensaje.setText("Gana computadora");
                        this.juegonuevo();
                    }
                }
            }
        }
    }
    public void filainferior()
    {
        int aux1 = 0;
        int aux2 = 0;
        for(int c=0; c<3; c++)
        {
            if(matrizbotones[2][c].getText() != null)
            {

                if(matrizbotones[2][c].getText().equals(gato1))
                {
                    aux1++;
                    if(aux1==3)
                    {
                    	contadorusuario++;//aumenta ganados
                    	textjugador1.setValue(contadorusuario);//muestra el valor en una caja de texto
                    	textmensaje.setText("Tu ganas");
                       this.juegonuevo();
                    }
                }
                else if(matrizbotones[2][c].getText().equals(gato2))
                {
                    aux2++;
                    if(aux2==3)
                    {
                    	contadorcomputadora++;//aumenta ganados
                    	textjugador2.setValue(contadorcomputadora);//muestra en caja de texto
                    	textmensaje.setText("Gana computadora");
                        this.juegonuevo();
                    }
                }
            }
        }
    }*/
   /* public void columnaizquierda()
    {
        int aux1=0;
        int aux2=0;
        for(int f=0; f<3; f++){
            if(matrizbotones[f][0].getText() != null){

                if(matrizbotones[f][0].getText().equals(gato1)){
                    aux1++;
                    if(aux1==3)
                    {
                    	contadorusuario++;//aumenta ganados
                    	textjugador1.setValue(contadorusuario);//muestra el valor en una caja de texto
                    	textmensaje.setText("Tu ganas");
                        //this.juegonuevo();
                    }
                }
                else if(matrizbotones[f][0].getText().equals(gato2)){
                    aux2++;
                    if(aux2==3)
                    {
                    	contadorcomputadora++;//aumenta ganados
                    	textjugador2.setValue(contadorcomputadora);//muestra en caja de texto
                    	textmensaje.setText("Gana computadora");
                        //this.juegonuevo();
                    }
                }
            }
        }
    }
    public void columnacentral()
    {
        int aux1 = 0;
        int aux2 = 0;
        for(int f=0; f<3; f++)
        {
            if(matrizbotones[f][1].getText() != null)
            {

                if(matrizbotones[f][1].getText().equals(gato1))
                {
                    aux1++;
                    if(aux1==3)
                    {
                    	contadorusuario++;//aumenta ganados
                    	textjugador1.setValue(contadorusuario);//muestra el valor en una caja de texto
                    	textmensaje.setText("Tu ganas");
                      // this.juegonuevo();
                    }
                }
                else if(matrizbotones[f][1].getText().equals(gato2))
                {
                    aux2++;
                    if(aux2==3)
                    {
                    	contadorcomputadora++;//aumenta ganados
                    	textjugador2.setValue(contadorcomputadora);//muestra en caja de texto
                    	textmensaje.setText("Gana computadora");
                        //this.juegonuevo();
                    }
                }
            }
        }
    }
    public void columnaderecha()
    {
        int aux1 = 0;
        int aux2 = 0;
        for(int f=0; f<3; f++)
        {
            if(matrizbotones[f][2].getText() != null)
            {
                if(matrizbotones[f][2].getText().equals(gato1))
                {
                    aux1++;
                    if(aux1==3)
                    {
                    	contadorusuario++;//aumenta ganados
                    	textjugador1.setValue(contadorusuario);//muestra el valor en una caja de texto
                    	textmensaje.setText("Tu ganas");
                       //this.juegonuevo();
                    }
                }
                else if(matrizbotones[f][2].getText().equals(gato2))
                {
                    aux2++;
                    if(aux2==3)
                    {
                    	contadorcomputadora++;//aumenta ganados
                    	textjugador2.setValue(contadorcomputadora);//muestra en caja de texto
                    	textmensaje.setText("Gana computadora");
                        //this.juegonuevo();
                    }
                }
            }            
        }
    }*/
    public void tablero()///empate
    {
        int aux = 0;
        for(int f=0; f<3; f++)
        {
            for(int c=0; c<3; c++)
            {
                if(matrizbotones[f][c].getText() != null)
                {
                    aux++;
                    if(aux==9)
                    {
                    	contadorempate++;//aumenta ganados
                    	textempate.setValue(contadorempate);//muestra el valor en una caja de texto
                    	textmensaje.setText("Empate");
                        this.juegonuevo();
                    }
                }
            }
        }
    }
    public void juegonuevo()
    {
        for(int f=0; f<3; f++)
        {
            for(int c=0; c<3; c++)
            {
            	matrizbotones[f][c].setText(null);
            }
        }
    }
    public void verificarcasillas(JButton[][] bot, int f, int c)
    {
        if(bot[f][c].getText() == null)
        {
        	matrizbotones[f][c].setText(gato1);
        }
        else
        {
        	textmensaje.setText("Casilla ocupada");
        }
    }
    public void analizar()
    {
        this.diagonalprincipal();
        this.diagonalsecundaria();
        this.filas();
        this.columnas();
        /*this.filasuperior();
        this.filamedia();
        this.filainferior();*/
        /*this.columnaizquierda();
        this.columnacentral();
        this.columnaderecha();*/
        this.tablero();
    }
    public void nuevapartida()
    {	
    	contadorusuario=0;
    	contadorcomputadora=0;
    	contadorempate=0;
    	textjugador1.setValue(contadorusuario);
    	textjugador2.setValue(contadorcomputadora);
    	textempate.setValue(contadorempate);
    	textmensaje.setText("");
    	juegonuevo();
    }
    public void actionPerformed(ActionEvent evento)
    {
        JButton eventoboton = (JButton)evento.getSource();
        for(int fila=0;fila<3;fila++)
        {
        	for(int columna=0;columna<3;columna++)
        	{
        		if(eventoboton.equals(matrizbotones[fila][columna]))
        		{
        			this.verificarcasillas(matrizbotones, fila,columna);
                    this.analizar();
                    if(jugadorcomputadora.jugando(matrizbotones) != true)
                    {
                    	jugadorcomputadora.juegaaleatorio(matrizbotones);
                    }
        		}
        	}
        }
        /*if(eventoboton.equals(matrizbotones[0][0]))
        {
            this.verificarcasillas(matrizbotones, 0, 0);
            this.analizar();
            if(jugadorcomputadora.jugando(matrizbotones) != true)
            {
            	jugadorcomputadora.juegaaleatorio(matrizbotones);
            }
        }
        if(eventoboton.equals(matrizbotones[0][1]))
        {
            this.verificarcasillas(matrizbotones, 0, 1);
            this.analizar();
            if(jugadorcomputadora.jugando(matrizbotones) != true)
            {
            	jugadorcomputadora.juegaaleatorio(matrizbotones);
            }
        }
        if(eventoboton.equals(matrizbotones[0][2]))
        {
            this.verificarcasillas(matrizbotones, 0, 2);
            this.analizar();
            if(jugadorcomputadora.jugando(matrizbotones) != true)
            {
            	jugadorcomputadora.juegaaleatorio(matrizbotones);
            }
        }
        if(eventoboton.equals(matrizbotones[1][0]))
        {
            this.verificarcasillas(matrizbotones, 1, 0);
            this.analizar();
            if(jugadorcomputadora.jugando(matrizbotones) != true)
            {
            	jugadorcomputadora.juegaaleatorio(matrizbotones);
            }
        }
        if(eventoboton.equals(matrizbotones[1][1]))
        {
            this.verificarcasillas(matrizbotones, 1, 1);
            this.analizar();
            if(jugadorcomputadora.jugando(matrizbotones) != true)
            {
            	jugadorcomputadora.juegaaleatorio(matrizbotones);
            }
        }
        if(eventoboton.equals(matrizbotones[1][2]))
        {
            this.verificarcasillas(matrizbotones, 1, 2);
            this.analizar();
            if(jugadorcomputadora.jugando(matrizbotones) != true)
            {
            	jugadorcomputadora.juegaaleatorio(matrizbotones);
            }
        }
        if(eventoboton.equals(matrizbotones[2][0]))
        {
            this.verificarcasillas(matrizbotones, 2, 0);
            this.analizar();
            if(jugadorcomputadora.jugando(matrizbotones) != true)
            {
            	jugadorcomputadora.juegaaleatorio(matrizbotones);
            }
        }
        if(eventoboton.equals(matrizbotones[2][1]))
        {
            this.verificarcasillas(matrizbotones, 2, 1);
            this.analizar();
            if(jugadorcomputadora.jugando(matrizbotones) != true)
            {
            	jugadorcomputadora.juegaaleatorio(matrizbotones);
            }
        }
        if(eventoboton.equals(matrizbotones[2][2]))
        {
            this.verificarcasillas(matrizbotones, 2, 2);
            this.analizar();
            if(jugadorcomputadora.jugando(matrizbotones) != true)
            {
            	jugadorcomputadora.juegaaleatorio(matrizbotones);
            }
        }*/
        if(eventoboton.equals(nuevo))
        {
        	this.nuevapartida();
            //this.juegonuevo();
            jugadorcomputadora.juegaaleatorio(matrizbotones);
        }
        if(eventoboton.equals(salir) || evento.getSource().equals(salirj))
        {
        	System.exit(0);
        }
        if(eventoboton.equals(cambiarjugadores))
        {
        	gato1="O";
        	gato2="X";
        }
        if(eventoboton.equals(nuevoj))
        {
        	this.juegonuevo();
        }
        if(evento.getSource().equals(salirj))
        {
        	System.exit(0);
        }
        this.analizar();
    }
    public static void main(String[] args)
    {
    	InterfazGato interfazgato=new InterfazGato();
    }
}