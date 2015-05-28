package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class Ventana extends JFrame {

	private JPanel ventana;
	

		public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		ventana = new JPanel();
		ventana.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ventana);
		ventana.setLayout(null);
		
		//PanelPrueba panel=new PanelPrueba();
		//add(panel);
		
		//Carton c=new Carton();
		
		Cartones c= new Cartones(3);//(int) (Math.random()*3+1));
		ventana.add(c);
		}
}
