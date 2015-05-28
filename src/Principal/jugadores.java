package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Modelo.*;

public class jugadores extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel pantalla;
	private JTextField CampoNombre;
	private JLabel Nombre;
	private JButton EliminarJugador;
	int numeroJugadores=0;
	private int cont=0;
	private ArrayList<String> nombreJugador=new ArrayList<String>();
	
	
	

	
	public jugadores() {
		setResizable(true);

		setIconImage(new ImageIcon(getClass().getResource("../Principal/icono.png")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 90, 900, 600);
		pantalla = new Fondo("/Principal/imagenes/fondoJugadores.jpg");
		pantalla.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla);
		pantalla.setLayout(null);
		setTitle("Bingo twist");
		
		JLabel IntroduzcaJugadores = new JLabel("");
		IntroduzcaJugadores.setIcon(new ImageIcon(getClass().getResource("/Principal/imagenes/IntroduceJugadores.png")));
		IntroduzcaJugadores.setBackground(Color.WHITE);
		IntroduzcaJugadores.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		IntroduzcaJugadores.setBounds(241, 11, 471, 80);
		pantalla.add(IntroduzcaJugadores);
				
		Nombre = new JLabel("CUAL ES TU NICK");
		Nombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		Nombre.setForeground(Color.BLACK);
		Nombre.setVerticalAlignment(SwingConstants.TOP);
		Nombre.setBounds(248, 179, 187, 29);
		pantalla.add(Nombre);
		
		CampoNombre = new JTextField();
		CampoNombre.setBounds(426, 185, 149, 20);
		pantalla.add(CampoNombre);
		CampoNombre.setColumns(10);

		
		
		JButton NuevoJugador = new JButton("Add New Player");
		NuevoJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ponerJugador();
			}
		});
		NuevoJugador.setBounds(296, 278, 139, 23);
		pantalla.add(NuevoJugador);
		
		EliminarJugador = new JButton("Delete Player");
		EliminarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CampoNombre.setText("");
				
			}
		});
		EliminarJugador.setBounds(472, 278, 139, 23);
		pantalla.add(EliminarJugador);
		
		JButton Salir = new JButton("Leave");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				jugadores.this.dispose();						
			}
		});	
		
		Salir.setBounds(670, 503, 126, 29);
		pantalla.add(Salir);
		
		JButton comienza = new JButton("");
		comienza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					/*
					 * Si no hay ningun nombre de jugador y/o ningun email, nos aparece un mensaje informativo
					 * avisandonos de la auscencia de estos
					 */
					
					if (CampoNombre.getText().trim().isEmpty())
					{

						JOptionPane.showMessageDialog(null,"Please Enter a Player", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));
						 Principal VentPrinc = new Principal(numeroJugadores,nombreJugador);

							VentPrinc.setVisible (false);
								
					}

					
					else
					{
						ponerJugador();
						Principal VentPrinc = new Principal(numeroJugadores,nombreJugador);
						VentPrinc.setVisible (true);
						jugadores.this.dispose();
					}
					

				
			}
		});
		
		comienza.setIcon(new ImageIcon(getClass().getResource("/Principal/imagenes/Comienza.png")));
		comienza.setBounds(361, 365, 195, 72);
		pantalla.add(comienza);
		
		JButton Atras = new JButton("Back");		
		Atras.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Primera VentPrinc = new Primera();
				VentPrinc.setVisible (true);
				jugadores.this.dispose();			
				
			}
		});				
		Atras.setBounds(85, 503, 126, 29);
		pantalla.add(Atras);
	}
	public void ponerJugador(){
		getNombreJugador().add(CampoNombre.getText());
		numeroJugadores=numeroJugadores+1;
		CampoNombre.setText("");
		
		
	}
	public int getNumeroJugadores(){
		return numeroJugadores;
	}
	public ArrayList<String> getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(ArrayList<String> nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
}
