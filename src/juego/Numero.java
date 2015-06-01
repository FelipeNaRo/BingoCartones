package juego;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Numero extends JLabel{
	private int posicion;
	private String color;

	public Numero(int posicion) {
		color="azul";
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alternador(color,posicion);
			}
		});
		setIcon(new ImageIcon((getClass().getResource("/numerosCarton/"+posicion+".png"))));
		this.posicion=posicion;
		}
	
public void setColor(){
		
	
		if (color=="amarillo"){this.color="azul";
		}else{this.color="amarillo";}
	
	}
public void alternador(String color, int pos){
	
	if (color=="amarillo")
	{				
	setIcon(new ImageIcon(Numero.class.getResource("/numerosCarton/"+pos+".PNG")));
	setColor();
	}else{setIcon(new ImageIcon(Numero.class.getResource("/numerosCartonAmarillo/"+pos+".PNG")));
	setColor();
	}  

}
}

