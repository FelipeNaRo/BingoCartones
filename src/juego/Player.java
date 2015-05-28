package juego;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Principal.Principal;


public class Player {
	
	JPanel dibujo= new JPanel();
	JLabel numero[]=new JLabel[27];
	private ArrayList <String> carton=new ArrayList();
	private int numeroJugador;
	private ArrayList nombreJugador;
	private int numeroCartones;
	private int cont;
	private Principal p=new Principal(numeroJugador,nombreJugador);
	public Player(int c) {
		System.out.print("segundo paso"+c);
		dibujo.setBounds(0,0,200,100);
		for (int l=1; l==c; l++)
		cont=0;
		Cartones cartonJugador= new Cartones(numeroCartones);
		for (int i=1;i==27;i++){
			carton.add(cartonJugador.getNumerosCarton(i));
			}
				for (int j=1;j==3;j++){
					for (int k=1;k==9;k++){
						cont=cont+1;
						numero[cont].setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Botones Azules/"+cont+".png"))));
						dibujo.setBounds(k, j, 60, 40);
						dibujo.add(numero[cont]);
					}
				}
			
		
		
		
	}
	public JPanel getDibujo(){
		return this.dibujo;
	}

}
