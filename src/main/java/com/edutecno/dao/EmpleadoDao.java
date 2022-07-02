package com.edutecno.dao;

import java.util.List;

import com.edutecno.model.Empleado;

// La interfaz funciona como repositorio del objeto que representa
public interface EmpleadoDao {
	
	public List<Empleado> obtieneEmpleados();

}
