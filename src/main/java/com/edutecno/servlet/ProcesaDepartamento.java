package com.edutecno.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.facade.Facade;

/**
 * Servlet implementation class ProcesaDepartamento
 * Responsabilidad de obtener todos los departamentos mediante el Facade que accede al DAO
 * Despachar hacia la vista los elementos a desplegar o hacia un servlet
 */
@WebServlet("/procesaDepartamento")
public class ProcesaDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Invocacion del Facade mediante instancia
		Facade facade = new Facade();
		// En el request se setean los datos que se enviaran o despacharan a la vista mediante Dispatcher
		request.setAttribute("departamentos", facade.obtieneDepartamentos());
		
		// Se despacha hacia la vista
		request.getRequestDispatcher("departamentos.jsp").forward(request, response);
	}

}
