package com.edutecno.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.facade.Facade;

/**
 * Servlet implementation class ProcesaEmpleado
 */
@WebServlet("/procesaEmpleado")
public class ProcesaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		request.setAttribute("empleados", facade.obtieneEmpleados());
		request.getRequestDispatcher("empleados.jsp").forward(request, response);
	}

}
