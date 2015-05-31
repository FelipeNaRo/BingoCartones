package juego;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPrueba extends JTabbedPane {

	private int numero, jugadores;
	
	/**
	 * Create the panel.
	 */
	public PanelPrueba() {
		
		
		setBounds(10,10,250,450);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("New label");
		//label.setBounds(10, 11, 26, 29);
		label.setIcon(new ImageIcon(PanelPrueba.class.getResource("/numerosCarton/1.png")));

		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setIcon(new ImageIcon((getClass().getResource("/numerosCartonAmarillo/1.png"))));

			}
		});
		
		panel.add(label);
		
		
		
	

	}

}
