package Modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;


public class ModeloVerificacion {
	//DEVOLVER CORREDORES
	private static String CONTRA_SEL="SELECT * FROM Jugadores";
	private static String CONTRA_COL="CONTRASENA";
	
	
	//Conexion
	private Connection conexion = null;// maneja la conexión
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;
	
	
	//usuariosDB
	private ArrayList<String> verificacion=null;
	
	
	
	public ModeloVerificacion() {
		conexion=ConexionDB.getConexion();
		verificacion= new ArrayList<String>();
	}
	
	
	
	public ArrayList getVerificacion(){
		try{
			instruccion = this.conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery(CONTRA_SEL);

			//Listaremos por pantalla los datos
			while( conjuntoResultados.next() ) {
				verificacion.add (conjuntoResultados.getString(CONTRA_COL));
			}// fin de while
			return verificacion;
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return verificacion;
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