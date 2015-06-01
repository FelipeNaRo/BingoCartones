package juego;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;


public class Cartones extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	public Cartones(int numeroCartones) {
		
		// Crea la base donde van los cartones.
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
	
		}
	
}
