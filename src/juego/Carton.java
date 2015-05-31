package juego;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.modeloCorredores;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;

import javax.swing.border.TitledBorder;

public class Carton extends JPanel{
	
	private int numeroCarton=(int) (Math.random()*19+1);
	private int cont=0;	
	private String numeros;
	private String[] secuenciaNumeros;
	private JLabel[] dibujoNumerosCarton=new JLabel[28];
	private modeloCorredores mu;
	public Carton() {
		mu=new modeloCorredores();
		numeroCarton=mu.getNumeroCarton();
		setNumeroCarton(numeroCarton);
		setBorder(new TitledBorder(null, "carton n\u00BA:"+numeroCarton, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(new Color(236, 233, 216));
		setBounds(10,10,275,120);
		setLayout(new MigLayout("", "[25.00px]", "[25.00px]"));
		
		numeros=mu.getNumeros(numeroCarton);
		secuenciaNumeros=numeros.split(",");
			for (int k=0;k<3;k++){
				for (int j=0;j<9;j++){
					cont=cont+1;
					dibujoNumerosCarton[cont]=new Numero(Integer.parseInt(secuenciaNumeros[cont-1]));	
					this.add(dibujoNumerosCarton[cont], "cell "+j+" "+k+",alignx center,aligny center");
					setNumeroCarton(numeroCarton);
				}
			}
		mu.setNumeroCarton(setNumeroCarton(numeroCarton));		
		
	}
	public int setNumeroCarton(int numeroCarton){
		if (numeroCarton<20){
			numeroCarton=numeroCarton+1;
		}else{numeroCarton=1;}	
		return numeroCarton;
		}
	
}


