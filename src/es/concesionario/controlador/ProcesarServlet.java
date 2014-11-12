package es.concesionario.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.Concesionario;

/**
 * Servlet implementation class ProcesarServlet
 */
@WebServlet("/Procesar")
public class ProcesarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
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
		String borrar= request.getParameter("borrar");
		String modificar= request.getParameter("modificarr");
		Concesionario concesionario = new Concesionario();
		
		String h = "";
		
		//BORRAR
		
		if(borrar!= null){
			h= concesionario.borrar(id);
		}
		
		//MODIFICAR
		
		if(modificar!=null){
			h= concesionario.modificar(id, matricula, marca, modelo, color, caballos, cambio);
		}
		String mensaje= concesionario.borrar(id);
		
		request.setAttribute("mensaje", h);
		
		RequestDispatcher rd= request.getRequestDispatcher("vistaMensaje.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
