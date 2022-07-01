package com.edutecno.procesaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// Clase para realizar la conexion a la base de datos con sus respectivos metodos y atributos
public class AdministradorConexion {

	// Variables solo declaradas pero no instanciadas
	protected static Connection conn;
	protected PreparedStatement pstm;
	protected ResultSet rs;

	// Metodo que generara una conexion mediante una JDBC clasica
	protected Connection generaConexion() {

		if (conn == null) { // Si la conexion no ha sido instanciada lo hace
			try {

				// Clase del Driver a utilizar para la conexion

				// ORACLE
				// Class.forName("oracle.jdbc.OracleDriver");
				//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe\", \"EDUTECNO\", \"admin\");
				
				// MYSQL
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/DATABASENAME?user=USERNAME&password=PASSWORD");
				
				System.out.println("Conexion generada mediante generaConexion()");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return conn;
	};

	// Metodo que generara una conexion mediante singleton referenciando un recurso
	// Para establecer la conexion mediante variables de entorno en el servidor con el 'context.xml':
	// https://tomcat.apache.org/tomcat-9.0-doc/jndi-resources-howto.html
	// https://www.baeldung.com/spring-persistence-jpa-jndi-datasource
	protected Connection generaPoolConexion() {
		
		// https://www.baeldung.com/jndi
		Context iniContext; // Variable declarada con la que se ubicara el recurso mediante el archivo 'context.xml' en el servidor
		
		if (conn == null) {
			try {
				
				iniContext = new InitialContext(); // Instancia para poder acceder a la ruta donde se encuentra el recurso 'context.xml'
				
				// PARA ORACLE:
				//DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/ConexionOracle");
				
				// PARA MYSQL:
				DataSource ds = (DataSource) iniContext.lookup("java:comp/env/jdbc/ConexionMySQL"); // Setea en la variable ls configuracion obtenida en el archivo 'context.xml'
				
				conn = ds.getConnection(); // Setea en la variable de conexion la conexion ya configurada
				
				System.out.println("Conexion generada mediante generaPoolConexion()");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return conn;
	};
}
