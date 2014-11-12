package es.concesionario.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.Concesionario;
import es.concesionario.modelo.Vehiculo;

/**
 * Servlet implementation class DarAltaServlet
 */
@WebServlet("/DarAlta")
public class DarAltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DarAltaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.recuperar los datos de la URL
		String matricula = request.getParameter("matricula");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");
		int caballos = Integer.parseInt(request.getParameter("caballos"));
		String TipoDeCambio= request.getParameter("cambio");
		boolean cambio;
		if(TipoDeCambio.equals("manual")){
			 cambio=true;
   }
   else{
	        cambio=false;
    }
		//Pasar datos recuperados al concesionario
		Concesionario concesionario = new Concesionario();
		int id= concesionario.darAlta(matricula, marca, modelo, color, caballos, cambio);
		//consultar vehiculo
		Vehiculo v=concesionario.consultarUno(id);
		//meter el vehiculo en el request...(setAttribute)
		request.setAttribute("vehiculo",v);
		//redirigir a la vista individual
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("vistaIndividual.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
