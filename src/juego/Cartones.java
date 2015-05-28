package juego;

import javax.swing.JPanel;

import Modelo.modeloCorredores;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;


public class Cartones extends JPanel{
	
	private Carton cartones[]=new Carton [4];
	private int numeroCarton;
	private String numerosCartones="";
	private String numerosCarton[]=new String [27];
	private modeloCorredores numeracion;
	
	
	public Cartones(int numeroCartones) {
		setBounds(10,10,300,450);
		setLayout(new MigLayout("", "[210.00px]", "[18px][18px]"));
		
		switch (numeroCartones){
		
		case 1:
			Carton c= new Carton();
			add(c, "cell 0 1,alignx left,growy");
			break;
			
		case 2:
			Carton c1= new Carton();
			add(c1, "cell 0 1,alignx left,growy");
			Carton c2= new Carton();
			add(c2, "cell 0 2,alignx left,growy");
			break;
			
		case 3:
			Carton c3= new Carton();
			add(c3, "cell 0 1,alignx left,growy");
			Carton c4= new Carton();
			add(c4, "cell 0 2,alignx left,growy");
			Carton c5= new Carton();
			add(c5, "cell 0 3,alignx left,growy");
			break;
		}
	
		/*Carton c= new Carton();
		add(c, "cell 0 0,alignx left,growy");

		
		Carton c2= new Carton();
		add(c2, "cell 0 1,alignx left,growy");*/
		
		/*for (int i=1; i==numeroCartones; i++){
			cartones[i]=new Carton();
			add(cartones[i],"cell 0 "+(i-1)+",alignx left,growy");
		}*/
		
		}
	public String getNumerosCarton(int i){
		return this.numerosCarton[i];
	}
}
