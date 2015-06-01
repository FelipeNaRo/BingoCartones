package Principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Color;

import Modelo.modeloCorredores;

import java.util.ArrayList;

import javax.swing.BoxLayout;

import juego.Cartones;



public class Principal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel pantalla;
    private JLabel marcador[]=new JLabel[91];
    private JLabel SacaBolas=new JLabel(); 
    private int a=0;
    private int cont=0;
    private int orden=0;
    private int testigo=0;
    private int numero[]= new int [91];
    private int numeroCartones=0;
    private int[] numerosCarton=new int[15];
    private int[] primeraFila=new int[5];
	private int[] segundaFila=new int[5];
	private int[] terceraFila=new int[5];
    private String numeros;
    private String cart="";
    private String[] secuenciaNumeros;
    private String numerosSinCero[]=new String [15];
   
    private modeloCorredores mu;





	public Principal(int numeroJugadores, ArrayList<String> nombreJugadores) {
		setResizable(false);

		setEnabled(true);


		setIconImage(new ImageIcon(getClass().getResource("../Principal/icono.png")).getImage());
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 90, 900, 600);
		pantalla = new Fondo("/Principal/imagenes/fondoPrincipal.jpg");
		pantalla.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla);
		pantalla.setLayout(null);

		setTitle("Bingo twist");
		
		// Añade marcador de numeros que han salido
		
		for (int i=0;i<=8;i++){
			for (int j=0;j<=9;j++){
				cont=cont+1;
		marcador[cont]=new JLabel();	
		marcador[cont].setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Botones Rojos/"+cont+".png"))));
		marcador[cont].setBounds(10+j*60, 10+i*45, 38, 38);
		pantalla.add(marcador[cont]);
		SacaBolas=new JLabel();
		SacaBolas.setBounds(140,450, 100, 100);
		}}
		
		
		JButton Salir = new JButton("Exit");
		Salir.setBackground(Color.ORANGE);
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				Principal.this.dispose();						
			}
		});	
		
		Salir.setBounds(470, 494, 126, 56);
		pantalla.add(Salir);
		
		// Inicia una nueva partida. 
		
		JButton PartidaNueva = new JButton("New Game");
		PartidaNueva.setBackground(Color.CYAN);
		PartidaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal VentPrinc = new Principal(numeroJugadores, nombreJugadores);
				VentPrinc.setVisible (true);
				Principal.this.dispose();
				reiniciar();			
			}
		});
		PartidaNueva.setBounds(470, 424, 126, 56);
		pantalla.add(PartidaNueva);
		
		// Saca una nueva bola.
		JButton BolaNueva = new JButton("New Ball");
		BolaNueva.setForeground(Color.WHITE);
		BolaNueva.setBackground(Color.MAGENTA);
		BolaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				SacaBolas.setVisible(true);
				if (cont>=90){cont=0;};
				do
				a=(int)(Math.random()*90+1);
				while (numero[a]!=0);
				cont=cont+1;
				if (SacaBolas!=null){SacaBolas.removeAll();}
				pantalla.repaint();
				marcador[a].setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Botones Azules/"+a+".png"))));
				SacaBolas.setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Bolas/bolaBingo"+a+".png"))));
				pantalla.add(SacaBolas);
				pantalla.repaint();
				if (cont==90){
					cont=0;
					for (int i=1;i<91;i++){numero[i]=0;
					marcador[i].setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Botones Rojos/"+i+".png"))));
					pantalla.repaint();}
					for (int i=1;i<91;i++){numero[i]=0;}
					}else{numero[a]=1;}
			}}
		);
		
		
		
		BolaNueva.setBounds(351, 424, 109, 126);
		pantalla.add(BolaNueva);
		
		JButton Linea = new JButton("");
		Linea.setIcon(new ImageIcon(getClass().getResource("/Principal/imagenes/btnLinea.png")));
		
		Linea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				cart=JOptionPane.showInputDialog("card's number: ");
				
				int a=Integer.parseInt(cart);
				if(comprobarLinea(a)==true){
				JOptionPane.showMessageDialog(null, "Correct Line!!!!!", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));
				}else{JOptionPane.showMessageDialog(null, "Incorrect Line", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));			
}
				}
		});	
		Linea.setBounds(606, 11, 109, 50);
		pantalla.add(Linea);
		
		JButton Bingo = new JButton("");
		Bingo.setIcon(new ImageIcon(getClass().getResource("/Principal/imagenes/btnBingo.png")));
		Bingo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				setBounds(200, 90, 900, 600);
				int a=Integer.parseInt(JOptionPane.showInputDialog("numero de cartón: "));
				if(comprobarBingo(a)==true){
					JOptionPane.showMessageDialog(null, "¡¡¡¡¡ Bingo !!!!!", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));
					JOptionPane.showMessageDialog(null, "Any More Bingo?...", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));
					}else{JOptionPane.showMessageDialog(null, "Bingo Incorrect", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));			
	}
				setBounds(200, 90, 900, 600);
			}
		});	
		Bingo.setBounds(765, 11, 109, 50);
		pantalla.add(Bingo);
		
		JTabbedPane panelPestaña = new JTabbedPane(JTabbedPane.TOP);

		panelPestaña.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		panelPestaña.setBounds(606, 75, 270, 475);
		panelPestaña.setBounds(606, 75, 268, 475);
		
		//panelPestaña.setLayout(new BoxLayout(panelPestaña, BoxLayout.Y_AXIS));
		pantalla.add(panelPestaña);

		
		
		for (int i=0;i<numeroJugadores;i++){
		JPanel panel[] = new JPanel[numeroJugadores];
		
		numeroCartones=(int)(Math.random()*3+1);
		Cartones carton=new Cartones(numeroCartones);
		panel[i]=new JPanel();
		panel[i].add(carton);
		panelPestaña.addTab((String)nombreJugadores.get(i), null, panel[i], null);
		pantalla.add(panelPestaña);
		}
	}
	public void reiniciar(){
		for (int i=1;i<91;i++){numero[i]=0;
		marcador[i].setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Botones Rojos/"+i+".png"))));
		}

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(32, 53, 157, -26);
		pantalla.add(layeredPane);
		layeredPane.setLayout(new BoxLayout(layeredPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 89, 23);
		panel.add(btnNewButton);
		for (int i=1;i<91;i++){numero[i]=0;}
		SacaBolas.setVisible(false);
		pantalla.repaint();
	}
	public String[] getNombres( ArrayList<String> nombreJugadores){
		String[] nombres = new String[nombreJugadores.size()];
		nombres=(String[]) nombreJugadores.toArray();
		return nombres;
	} 
	
	public boolean comprobarLinea(int carton){
		orden=0;
		boolean a=true;
		mu=new modeloCorredores();
		numeros=mu.getNumeros(carton);
		secuenciaNumeros=numeros.split(",");
		for (int i=0; i<secuenciaNumeros.length; i++){
			if (Integer.parseInt(secuenciaNumeros[i])!=0){
				numerosSinCero[orden]=secuenciaNumeros[i];
				orden=orden+1;
			}	
			}
		
		for (int j=0;j<numerosSinCero.length;j++){
			
				if (j<5){
				primeraFila[j]=Integer.parseInt(numerosSinCero[(j)]);
				}else{
				if (j<10){
					segundaFila[j-5]=Integer.parseInt(numerosSinCero[(j)]);
					}else{terceraFila[j-10]=Integer.parseInt(numerosSinCero[(j)]);}
				}
		}		
			for (int k=0;k<primeraFila.length;k++)
			{
				if (numero[primeraFila[k]]!=1)
				{
					a=false;
				}
			}
			if (a==false)
			{
				testigo=0;
				for (int k=0;k<segundaFila.length;k++)
				{	
					if (numero[segundaFila[k]]!=1)
						{
						a=false;
						}else{
								testigo=testigo+1;
								}
				}
			}
			   if (testigo==5)
			   {
				   a=true;
			   }else 	{
				   		testigo=0;
				   		}
			if (a==false)
			{
				for (int k=0;k<terceraFila.length;k++)
				{
					if (numero[terceraFila[k]]!=1)	
					{
						a=false;
					}else
					{
						testigo=testigo+1;
					}
				}
			} 	if (testigo==5) {a=true;}
		return a;}
	public boolean comprobarBingo(int carton){
		orden=0;
		boolean a=true;
		mu=new modeloCorredores();
		numeros=mu.getNumeros(carton);
		secuenciaNumeros=numeros.split(",");
		for (int i=0; i<secuenciaNumeros.length; i++){
			if (Integer.parseInt(secuenciaNumeros[i])!=0){
				numerosSinCero[orden]=secuenciaNumeros[i];
				orden=orden+1;
			}	
			}
		for (int j=0;j<numerosSinCero.length;j++){
			numerosCarton[j]=Integer.parseInt(numerosSinCero[(j)]);
			if (numero[numerosCarton[j]]!=1){
				a=false;
			}
		}
		return a;
	}

	}

