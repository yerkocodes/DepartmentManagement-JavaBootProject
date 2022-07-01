package com.edutecno.model;

public class Empleado {
	private int numEmpleado;
	private String nombreEmpleado;
	private int numDepto;
	
	// Empty constructor
	public Empleado() {}

	// Constructor with fields
	public Empleado(int numEmpleado, String nombreEmpleado, int numDepto) {
		super();
		this.numEmpleado = numEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.numDepto = numDepto;
	}

	// Getters and Setters
	public int getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public int getNumDepto() {
		return numDepto;
	}

	public void setNumDepto(int numDepto) {
		this.numDepto = numDepto;
	}

	@Override
	public String toString() {
		return "Empleado [numEmpleado=" + numEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", numDepto=" + numDepto
				+ "]";
	}
	
}
