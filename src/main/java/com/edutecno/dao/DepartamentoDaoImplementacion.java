package com.edutecno.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.Departamento;
import com.edutecno.procesaConexion.AdministradorConexion;

// DepartamentoDaoImplementacion hereda lo que se encuentra en la clase AdministradorConexion y tambien se extiende de la interfaz DepartamentoDao
public class DepartamentoDaoImplementacion extends AdministradorConexion implements DepartamentoDao {
	
	// Constructor de superclase que hereda todo de AdministradorConexion
	public DepartamentoDaoImplementacion() {
		conn = generaPoolConexion();
	}

	// Sobreescritura del metodo existente en la interfaz
	// Metodo encargaddo de consultar por todos los departamentos eexistentes en la base de datos
	@Override
	public List<Departamento> obtieneDepartamentos() {
		
		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		
		try {
			
			// Preparar la query para la ejecucion con el PreparedStatement y Connection
			pstm = conn.prepareStatement("SELECT * FROM departamentos");

			// Se ejecuta la query con pstm.executeQuery()
			rs = pstm.executeQuery();
			
			while (rs.next()) { // Se verifica que en la fila donde se encuentra el rs tenga datos
				Departamento departamento = new Departamento();
				departamento.setNumDepto(rs.getInt("numdepto"));
				departamento.setNombreDepto(rs.getString("nomdepto"));
				departamento.setUbicacionDepto(rs.getString("ubicaciondepto"));
				
				listaDepartamentos.add(departamento);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaDepartamentos;
	}

}
