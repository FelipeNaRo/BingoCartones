import Modelo.ConexionDB;

import javax.swing.JOptionPane;

import Principal.Primera;


public class Lanzador {

	public static void main(String[] args) {
		
		
		//Establecemos la conexion con la base de datos
				ConexionDB Bingo;
				
				//Generamos el objeto
				Bingo=new ConexionDB ("91.121.110.152","Bingo","rootbingo","bingoplayers");
				
				if (Bingo.connectDB()==true) {
				
				JOptionPane.showMessageDialog (null, "Successfully connected to DB"
						+ "\n CAN PLAY", "CONNECTED", JOptionPane.INFORMATION_MESSAGE);
			
				
				Primera ventana= new Primera();
				ventana.setVisible(true);
							
				}
				else {
					JOptionPane.showMessageDialog(null, "Can't connect to the database BD"
							+ "\n It's required to play", "CONNECT FAILURE", JOptionPane.ERROR_MESSAGE);
							System.exit(0);}
	}
}
