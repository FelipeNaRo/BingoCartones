
import Modelo.ConexionDB;
import Modelo.modeloCorredores;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Principal.Primera;


public class Lanzador {

	public static void main(String[] args) {
		
		
		//Establecemos la conexion con la base de datos
				ConexionDB Bingo;
				
				//Generamos el objeto
				Bingo=new ConexionDB ("91.121.110.152","Bingo","rootbingo","bingoplayers");
				
				if (Bingo.connectDB()==true) {
				//System.out.println("Conectados con éxito");
				JOptionPane.showMessageDialog (null, "Conectado con exito  a la BD "
						+ "\n YA PUEDES JUGAR", "CONECTADO", JOptionPane.INFORMATION_MESSAGE);
			
				
				Primera ventana= new Primera();
				ventana.setVisible(true);
				
				
							
				}
				
				else {	
					JOptionPane.showMessageDialog(null, "No podemos coenctar con la BD"
							+ "\n y es necesaria para jugar", "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
							System.exit(0);}
				
					}

}
