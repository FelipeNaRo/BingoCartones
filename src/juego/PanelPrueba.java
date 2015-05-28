package juego;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class PanelPrueba extends JTabbedPane {

	private int numero, jugadores;
	
	/**
	 * Create the panel.
	 */
	public PanelPrueba() {
		
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		setBounds(10,10,250,450);
		
		JPanel panel = new JPanel();
		JPanel panel_1 = new JPanel();
		
		
		//jugadores=(int)(Math.random()*3+1);
		jugadores=3;
		JPanel jugador[]= new JPanel[jugadores];
		
		for (int i=0; i<jugadores; i++){
			
			jugador[i] =new JPanel();
			jugador[i].add(panel_1);
			addTab("Numero:"+(i+1),null,jugador[i],null);
			//jugador[i].setLayout(new BorderLayout(0, 0));
		}

	}

}
