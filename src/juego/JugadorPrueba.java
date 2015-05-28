package juego;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class JugadorPrueba extends JPanel {
	private JTextField textField;
	private JTextField cartones;

	/**
	 * Create the panel.
	 */
	public JugadorPrueba(int j) {
		setBounds(10,10,250,450);
		setToolTipText("Carton");
		setLayout(new BorderLayout(0, 0));
		
		cartones = new JTextField();
		cartones.setHorizontalAlignment(SwingConstants.CENTER);
		cartones.setEditable(false);
		cartones.setText("Cartones jugador numero: "+j);
		add(cartones, BorderLayout.NORTH);
		cartones.setColumns(10);
		
		
	}

}
