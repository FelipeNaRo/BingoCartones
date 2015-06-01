package Modelo;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class modeloCorredores {
	//Selecciones a realizar.
	private static String USUARIO_SEL="SELECT * FROM Jugadores";
	private static String USUARIO_COL="nombre";
	private static String CARTON_NUM="SELECT NUMEROS FROM CARTONES WHERE NUM_CARTON =";
	private static String NUM_CARTON_ULTIMO="SELECT NUM_CARTON FROM CARTONES WHERE ULTIMO = 1";
	private static String ACTUALIZAR_CARTON="UPDATE CARTONES SET ULTIMO=0 WHERE ULTIMO= 1";
	private static String NUEVO_CARTON_ULTIMO="UPDATE CARTONES SET ULTIMO=1 WHERE NUM_CARTON=";
	
	//Conexion
	private Connection conexion = null;// maneja la conexión
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;
	ResultSet conjuntoResultados2 = null;
	
	//usuariosDB
	private ArrayList<String> usuarios=null;
	private int numero=0;
	private String numeros="";
	
	
	
	public modeloCorredores() {
		conexion=ConexionDB.getConexion();
		usuarios= new ArrayList<String>();
	}
	
	
	// Coge la lista de usuarios de la BD,
	public ArrayList<String> getusuarios(){
		try{
			instruccion = this.conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery(USUARIO_SEL);

			//Listaremos por pantalla los datos
			while( conjuntoResultados.next() ) {
				usuarios.add (conjuntoResultados.getString(USUARIO_COL));
			}// fin de while
			return usuarios;
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return usuarios;
		}
		finally{
			try{
				conjuntoResultados.close();
				instruccion.close();

				//conexion.close();

			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
	}
	
	// Coge los numeros que conforman el cartón, cero para espacios
	public String getNumeros(int carton){
		try{ 
			instruccion = this.conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery(CARTON_NUM+carton);

			//Listaremos por pantalla los datos
				if(conjuntoResultados.next())
				numeros=conjuntoResultados.getString("numeros");
				return numeros;
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return numeros;
		}
		finally{
			try{
				conjuntoResultados.close();
				instruccion.close();

			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
	}
	
	// Coge el numero del cartón que ha de ser el primero en repartirse.
	public int getNumeroCarton(){
		try{ 
			instruccion = this.conexion.createStatement();
			conjuntoResultados2 = instruccion.executeQuery(NUM_CARTON_ULTIMO);
				if(conjuntoResultados2.next()){
				numero=conjuntoResultados2.getInt("num_carton");
				instruccion.executeUpdate(ACTUALIZAR_CARTON);}
						return numero;
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return numero;
		}
		finally{
			try{
				conjuntoResultados2.close();
				
				instruccion.close();

			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
	}
	
	// Guearda el numero del cartón que será el primero de la siguiente partida.
	public void setNumeroCarton(int numero){
		try{ 
			instruccion = this.conexion.createStatement();
			instruccion.executeUpdate(NUEVO_CARTON_ULTIMO+numero);
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			
		}
		finally{
			try{
				
				instruccion.close();

			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
	}
}
