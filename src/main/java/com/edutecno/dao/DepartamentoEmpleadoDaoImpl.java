package com.edutecno.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.Departamento;
import com.edutecno.model.DepartamentoEmpleado;
import com.edutecno.model.Empleado;
import com.edutecno.procesaConexion.AdministradorConexion;

public class DepartamentoEmpleadoDaoImpl extends AdministradorConexion implements DepartamentoEmpleadoDao {
	
	public DepartamentoEmpleadoDaoImpl() {//constructor vac�o
		conn = generaPoolConexion();//se genera la conexion para toda la clase
	}
	
	@Override
	public List<DepartamentoEmpleado> obtieneDepartamento(String nomDepto) {
		//lista para almacenar los datos obtenidos de la base de datos
		List<DepartamentoEmpleado> deptosEmpleados = new ArrayList<DepartamentoEmpleado>();
		String query = "SELECT * FROM empleados emp INNER JOIN departamentos dep ON dep.numdepto = emp.numdepto \r\n" + "WHERE ";
		
		if (nomDepto.isEmpty()) {
			query = "SELECT * FROM empleados emp INNER JOIN departamentos dep ON dep.numdepto = emp.numdepto";
		}else {
			query += "dep.nomdepto LIKE UPPER('%"+nomDepto+"%')";
		}
		
//		String query = "SELECT * FROM EMPLEADO EMP INNER JOIN DEPARTAMENTO DEP ON DEP.NUMDEPTO = EMP.NUMDEPTO WHERE "+ "DEP.NOMDEPTO LIKE UPPER('%"+nomDepto+"%')";
		
		try {
			//se prepara la query
			pstm = conn.prepareStatement(query);
			//se ejecuta la query
			rs = pstm.executeQuery();
			//se recorre el resultado
			while(rs.next()) {
				Departamento depto = new Departamento (rs.getInt("numdepto"), rs.getString("nomdepto"), rs.getString("ubicaciondepto"));
				Empleado empleado = new Empleado(rs.getInt("numempleado"), rs.getString("nombre"), rs.getInt("numdepto"));
				DepartamentoEmpleado deptoEmpl = new DepartamentoEmpleado(depto, empleado);
				deptosEmpleados.add(deptoEmpl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptosEmpleados;
	}
}
