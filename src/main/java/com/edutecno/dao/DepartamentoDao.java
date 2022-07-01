package com.edutecno.dao;

import java.util.List;

import com.edutecno.model.Departamento;

// Existiran los metodos declarados que pertenecen a cada objeto que representan
// La interfaz es un repositorio que dictamina que metodos estan siendo implementados
public interface DepartamentoDao {

	// findAll()
	// findById(int id)
	// save(Object object)
	// delete(Object object / int id)
	// findByNombre(String nombre)
	// findLastId()
	
	public List<Departamento> obtieneDepartamentos();
}
