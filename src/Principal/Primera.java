package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.util.Iterator;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import Modelo.ModeloVerificacion;
import Modelo.modeloCorredores;

public class Primera extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel pantalla;
	public static JPasswordField CampoContra;
	modeloCorredores usuarios;
	ModeloVerificacion verificacion;
	

	public Primera() {

		setEnabled(true);

		setResizable(false);

		
		setIconImage(new ImageIcon(getClass().getResource("../Principal/icono.png")).getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 90, 900, 600);
		pantalla = new Fondo("/Principal/imagenes/fondoPrimera.png");
		pantalla.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla);
		pantalla.setLayout(null);
		setTitle("Bingo twist");
		
		JButton Entrar = new JButton("Enter");
		Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				verificacion=new ModeloVerificacion();
				
				if(CampoContra.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Please Enter a Password", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));
					jugadores VentPrinc = new jugadores();
					VentPrinc.setVisible (false);

						
					}
				else{
					if  (CampoContra.equals(verificacion));
					System.out.println("Contraseña correcta"); 
					Primera.this.dispose();
					jugadores VentPrinc1 = new jugadores();		
					VentPrinc1.setVisible (true);
					
				}

				
			}
			
			
		});	
		Entrar.setBounds(357, 503, 89, 23);
		pantalla.add(Entrar);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(getClass().getResource("/Principal/imagenes/logoBingoNuevo.png")));
		logo.setBounds(77, 43, 700, 294);
		pantalla.add(logo);
	

		JLabel Username = new JLabel("Username");
		Username.setForeground(Color.WHITE);
		Username.setBounds(373, 434, 60, 14);
		pantalla.add(Username);
	

		
		JLabel Password = new JLabel("Password");
		Password.setForeground(Color.WHITE);
		Password.setBounds(373, 462, 63, 14);
		pantalla.add(Password);
		
		CampoContra = new JPasswordField();
		CampoContra.setBounds(443, 460, 120, 18);
		pantalla.add(CampoContra);
		
		JButton Salir = new JButton("Leave");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				Primera.this.dispose();							
			}
		});	
		
		Salir.setBounds(478, 503, 89, 23);
		pantalla.add(Salir);
		
		JComboBox Desplegable = new JComboBox();
		Desplegable.setBounds(443, 431, 120, 17);
		pantalla.add(Desplegable);
		
		
		//Rellenamos JComboBox
		
				usuarios=new modeloCorredores();
				
				Iterator<String> it=usuarios.getusuarios().iterator();
				while(it.hasNext()){
					Desplegable.addItem((String)it.next());
				}
				
				
	

	}
}
