package Principal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import Modelo.modeloCorredores;
import juego.Carton;
import juego.Cartones;



public class Principal extends JFrame {

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
    private String[] secuenciaNumeros;
    private String numerosSinCero[]=new String [15];
    private Carton prueba;
    private modeloCorredores mu;
    
    public Principal(){}

	public Principal(int numeroJugadores, ArrayList nombreJugadores) {
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
		
		// Añade marcador de bolas salidas
		for (int i=0;i<=8;i++){
			for (int j=0;j<=9;j++){
				cont=cont+1;
		marcador[cont]=new JLabel();	
		marcador[cont].setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Botones Rojos/"+cont+".png"))));
		marcador[cont].setBounds(10+j*60, 10+i*45, 38, 38);
		pantalla.add(marcador[cont]);
		
		numero[cont]=0;
		SacaBolas=new JLabel();
		SacaBolas.setBounds(40,450, 100, 100);
		}}
		
		
		JButton Salir = new JButton("Salir");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				Principal.this.dispose();						
			}
		});	
		
		Salir.setBounds(748, 521, 126, 29);
		pantalla.add(Salir);
		

		JButton PartidaNueva = new JButton("Partida Nueva");
		PartidaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal VentPrinc = new Principal(numeroJugadores, nombreJugadores);
				VentPrinc.setVisible (true);
				Principal.this.dispose();
				reiniciar();			
			}
		});
		PartidaNueva.setBounds(748, 480, 126, 30);
		pantalla.add(PartidaNueva);
		prueba=new Carton();
		JButton BolaNueva = new JButton("Bola Nueva");
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
		
		
		
		BolaNueva.setBounds(629, 480, 109, 70);
		pantalla.add(BolaNueva);
		
		JButton Linea = new JButton("");
		Linea.setIcon(new ImageIcon(getClass().getResource("/Principal/imagenes/btnLinea.png")));
		
		Linea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				int a=Integer.parseInt(JOptionPane.showInputDialog("numero de cartón: "));
				prueba=new Carton();
				if(comprobarLinea(a)==true){
				JOptionPane.showMessageDialog(null, "Han cantado Linea!!!!!", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));			
				}else{JOptionPane.showMessageDialog(null, "Linea Incorrecta", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));			
}
				}
		});	
		Linea.setBounds(629, 11, 109, 50);
		pantalla.add(Linea);
		
		JButton Bingo = new JButton("");
		Bingo.setIcon(new ImageIcon(getClass().getResource("/Principal/imagenes/btnBingo.png")));
		Bingo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				setBounds(200, 90, 900, 600);
				int a=Integer.parseInt(JOptionPane.showInputDialog("numero de cartón: "));
				if(comprobarBingo(a)==true){
					JOptionPane.showMessageDialog(null, "Han cantado Bingo!!!!!", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));			
					}else{JOptionPane.showMessageDialog(null, "Bingo Incorrecto", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));			
	}
				setBounds(200, 90, 900, 600);
			}
		});	
		Bingo.setBounds(765, 11, 109, 50);
		pantalla.add(Bingo);
		
		JTabbedPane panelPestaña = new JTabbedPane(JTabbedPane.TOP);

		panelPestaña.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		panelPestaña.setBounds(629, 72, 300, 393);
		panelPestaña.setBounds(606, 75, 300, 393);
		
		
		
		
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
	
	public String[] getNombres( ArrayList nombreJugadores){
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


