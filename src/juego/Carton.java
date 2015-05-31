package juego;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.ConexionDB;
import Modelo.modeloCorredores;

import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.Insets;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;

import javax.swing.border.TitledBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Carton<setBounds> extends JPanel{
	
	private int numeroCarton=(int) (Math.random()*19+1);
	private int cont=0;
	private int pos=0;
	private ArrayList<String> numerosCarton;
	private String color;
	private String numeros;
	private int posicion;
	
	private String[] secuenciaNumeros;
	private JLabel[] dibujoNumerosCarton=new JLabel[28];
	static final String NUMEROS="SELECT NUMEROS FROM CARTONES WHERE NUM_CARTON =";
	private modeloCorredores mu;
	private Connection conexion = null;// maneja la conexión
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;

	public Carton() {
		color="amarillo";
		setNumeroCarton(numeroCarton);
		setBorder(new TitledBorder(null, "carton n\u00BA:"+numeroCarton, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(new Color(236, 233, 216));
		setBounds(10,10,275,120);
		setLayout(new MigLayout("", "[25.00px]", "[25.00px]"));
		
		
		
		mu=new modeloCorredores();
		numeros=mu.getNumeros(numeroCarton);
		secuenciaNumeros=numeros.split(",");
			for (int k=0;k<3;k++){
				for (int j=0;j<9;j++){
					cont=cont+1;
					posicion=cont;
					dibujoNumerosCarton[cont]=new Numero(Integer.parseInt(secuenciaNumeros[cont-1]));	
					this.add(dibujoNumerosCarton[cont], "cell "+j+" "+k+",alignx center,aligny center");
				}
			}
				
		
	}
	public void setNumeroCarton(int numeroCarton){
		if (numeroCarton<20){
			numeroCarton=numeroCarton+1;
		}else{numeroCarton=1;}	
		

		}
	
	
	
	}


