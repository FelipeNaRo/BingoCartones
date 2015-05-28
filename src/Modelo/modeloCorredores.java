package Modelo;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;


public class modeloCorredores {
	//DEVOLVER CORREDORES
	private static String USUARIO_SEL="SELECT * FROM Jugadores";
	private static String USUARIO_COL="nombre";
	private static String CARTON_NUM="SELECT NUMEROS FROM CARTONES WHERE NUM_CARTON =";
	
	
	//Conexion
	private Connection conexion = null;// maneja la conexión
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;
	
	
	//usuariosDB
	private ArrayList<String> usuarios=null;
	private String numeros="";
	
	
	
	public modeloCorredores() {
		conexion=ConexionDB.getConexion();
		usuarios= new ArrayList<String>();
	}
	
	
	
	public ArrayList getusuarios(){
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

				//conexion.close();

			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
	}

}
