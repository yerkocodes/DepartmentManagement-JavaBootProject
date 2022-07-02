package com.edutecno.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.Empleado;
import com.edutecno.procesaConexion.AdministradorConexion;

// EmpleadoDao hereda desde AdministradorConexion e implementa los metodos de la interfaz EmpeadoDao
public class EmpleadoDaoImplementacion extends AdministradorConexion implements EmpleadoDao {

	public EmpleadoDaoImplementacion() {
		conn = generaPoolConexion();
	}

	@Override
	public List<Empleado> obtieneEmpleados() {
		
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		try {

			pstm = conn.prepareStatement("SELECT * FROM empleados");
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Empleado empleado = new Empleado();
				empleado.setNumEmpleado(rs.getInt("numempleado"));
				empleado.setNombreEmpleado(rs.getString("nombre"));
				empleado.setNumDepto(rs.getInt("numdepto"));
				
				listaEmpleados.add(empleado);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaEmpleados;
	}

}
