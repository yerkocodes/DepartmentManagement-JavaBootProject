package com.edutecno.facade;

import java.util.List;

import com.edutecno.dao.DepartamentoDao;
import com.edutecno.dao.DepartamentoDaoImplementacion;
import com.edutecno.dao.DepartamentoEmpleadoDao;
import com.edutecno.dao.DepartamentoEmpleadoDaoImpl;
import com.edutecno.dao.EmpleadoDao;
import com.edutecno.dao.EmpleadoDaoImplementacion;
import com.edutecno.model.Departamento;
import com.edutecno.model.DepartamentoEmpleado;
import com.edutecno.model.Empleado;

// Facade es un patron de diseno que ejecuta una entrada unica  a la capa de persistencia
public class Facade {
	
	// Metodo encargado de acceder al data access object DepartamentoDaoImplementacion
	public List<Departamento> obtieneDepartamentos() {
		DepartamentoDao departamentoDao = new DepartamentoDaoImplementacion();
		return departamentoDao.obtieneDepartamentos();
	}
	
	public List<Empleado> obtieneEmpleados() {
		EmpleadoDao empleadoDao = new EmpleadoDaoImplementacion();
		return empleadoDao.obtieneEmpleados();
	}
	
	// Metodo encargado de acceder al Dao DepartamentoEmpleadoImp
	public List<DepartamentoEmpleado> obtieneDepartamento(String nomDepto) {
		DepartamentoEmpleadoDao deptoEmpleadoDao = new DepartamentoEmpleadoDaoImpl();
		return deptoEmpleadoDao.obtieneDepartamento(nomDepto);
	}

}
