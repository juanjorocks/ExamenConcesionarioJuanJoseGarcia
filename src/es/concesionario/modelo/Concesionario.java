package es.concesionario.modelo;

import java.util.ArrayList;

import es.concesionario.modelo.Vehiculo;
import es.concesionario.integracion.VehiculoDAO;

public class Concesionario {
	 private VehiculoDAO vehiculodao = new VehiculoDAO();
	 
	 public int darAlta(String matricula, String marca, String modelo,String color, int caballos, boolean cambio) {
	        Vehiculo vehiculo= new Vehiculo(String matricula, String marca, String modelo,String color, int caballos, boolean cambio);
	        int id =vehiculodao.darAlta(vehiculo);
	      return  id;
	    }
	 
	 public Vehiculo consultarUno(int id) {
	       
	        Vehiculo vehiculos =vehiculodao.consultarUno(id);
	      
	        return vehiculo;
	    }
	 
	 public ArrayList<Vehiculo> consultarTodos() {
	       
	       ArrayList<Vehiculo> vehiculos=vehiculodao.consultarTodos();
	      return vehiculos;
	    }
	 
	 public ArrayList<Vehiculo> consultarMatricula(String matricula) {
    	 ArrayList<Vehiculo> paises=vehiculodao.consultarMatricula(matricula);
         return vehiculos;
     }
	 
	 public String borrar(int id) {
			String msg;
			
			int vehiculosBorrados= vehiculodao.borrar(id);
			if(vehiculosBorrados>=1){
				msg="Se han borrado" +vehiculosBorrados+ "vehiculos";
			}
			else{
				msg="No se ha podido borrar";
			}
			return msg;
		}
	 
	 public String modificar(int id, String matricula, String marca, 
			 String modelo, String color, int caballos, boolean cambio) {
	        String msg;
	        
	        int filas= vehiculodao.actualizar(id, matricula, marca, modelo, color, caballos, cambio);
	        if(filas>=1) {
	            msg="Se ha actualizado " +filas +" vehiculos";
	        }
	        else {
	              msg="No se ha podido actualizar";
	        }
	       return msg;
	    }
}
