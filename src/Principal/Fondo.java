package Principal;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class Fondo extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	ImageIcon fondo1;
	
	public Fondo(String nombre) {

		fondo1 = new ImageIcon (getClass().getResource(nombre));
		setSize(fondo1.getIconWidth(),fondo1.getIconHeight());
				
	}
	public void paintComponent (Graphics g){
		
		Dimension d = getSize();//new Dimension(imagen.getIconWidth(),imagen.getIconHeight());
		g.drawImage(fondo1.getImage(),0,0, d.width, d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
		
	}

}
