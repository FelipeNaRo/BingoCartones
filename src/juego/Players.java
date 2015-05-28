package juego;

import java.util.ArrayList;


public class Players {
	
	private ArrayList<Player> jugador=new ArrayList<Player>(); 
	private String nombres[];
	private int numeroCartones;
	
	public Players(int numeroJugadores, ArrayList <String> nombreJugadores) {
		nombres = new String[nombreJugadores.size()];
		nombres=(String[]) nombreJugadores.toArray();
		for (int i=0; i<numeroJugadores; i++){
			Player p=new Player(i);
		    jugador.add(p);
		}
	}

}
