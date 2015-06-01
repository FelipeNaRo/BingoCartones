package juego;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Numero extends JLabel{
	
	private static final long serialVersionUID = 1L;
	private int posicion;
	private String color;

	// Dibuja el numero con la imagen correspondiente a su numero, el 0 es cuadro.
	
	public Numero(int pos) {
		color="azul";
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alternador(color,posicion);
			}
		});
		setIcon(new ImageIcon((getClass().getResource("/numerosCarton/"+pos+".png"))));
		this.posicion=pos;
		}
	
public void setColor(){
		
	// Selecciona el color azul o amarillo con cada click.
	
		if (color=="amarillo"){this.color="azul";
		}else{this.color="amarillo";}
	
	}
public void alternador(String color, int pos){
	
	// Segun el color que toca, selecciona la imagen del numero.
	if (color=="amarillo")
	{				
	setIcon(new ImageIcon(Numero.class.getResource("/numerosCarton/"+pos+".PNG")));
	setColor();
	}else{setIcon(new ImageIcon(Numero.class.getResource("/numerosCartonAmarillo/"+pos+".PNG")));
	setColor();
	}  

}
}

