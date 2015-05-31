package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class Ventana extends JFrame {

	private JPanel ventana;
	JLabel numero;
	private String color;

		public Ventana() {
		color="amarillo";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		ventana = new JPanel();
		ventana.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ventana);
		ventana.setLayout(null);
		
		numero = new JLabel("Hola");
		
		numero.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
			
				alternador(color); 

			}
		});
		numero.setIcon(new ImageIcon(Ventana.class.getResource("/numerosCartonAmarillo/1.PNG")));
		
		numero.setBounds(10, 10, 30, 30);
		ventana.add(numero);
		
		//PanelPrueba panel=new PanelPrueba();
		//add(panel);
	
		
		//Carton c=new Carton();
		
		//Cartones c= new Cartones(3);//(int) (Math.random()*3+1));
		//ventana.add(c);
		}
		public void alternador(String color){
			
			if (color=="amarillo")
			{				
			numero.setIcon(new ImageIcon(Ventana.class.getResource("/numerosCarton/1.PNG")));
			setColor();
			}else{numero.setIcon(new ImageIcon(Ventana.class.getResource("/numerosCartonAmarillo/1.PNG")));
			setColor();
			}  

		}
		
		public void setColor(){
			
			if (color=="amarillo"){this.color="azul";
			}else{this.color="amarillo";}
		
		}
}
