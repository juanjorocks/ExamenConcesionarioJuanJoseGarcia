package es.concesionario.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.concesionario.modelo.Vehiculo;

public class VehiculoDAO {
	private Connection cx;
	
	private void conectar(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cx=DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario","root","root");
			                                
			cx.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private void desconectar(){	
		try {
			cx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int darAlta(Vehiculo vehiculo) {
		
		int idRetornar = 0;
		try {
			//CONEXION
			conectar();
			//QUERY
			PreparedStatement ps;
			ps = cx.prepareStatement("INSERT INTO VEHICULO VALUES(?,?,?,?,?,?,?)");
			
			ps.setInt(1, 0);
			ps.setString(2, vehiculo.getMatricula());
			ps.setString(3, vehiculo.getMarca());
			ps.setString(4, vehiculo.getModelo());
			ps.setString(5, vehiculo.getColor());
			ps.setInt(6, vehiculo.getCaballos());
			ps.setBoolean(7, vehiculo.isCambio());
			//CONSULTAR
			int filasAfectadas = ps.executeUpdate();
			//COMMIT
			cx.commit();
			if(filasAfectadas>=1){
				idRetornar= ultimoId();
			}
			//DESCONEXION
			desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idRetornar;
		
	}

	private int ultimoId() {
		int  idM=10;
		try {
			//CONEXION
			conectar();
			//SENTENCIA		
			PreparedStatement ps= cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM VEHICULO");
			//CONSULTA
			ResultSet consulta= ps.executeQuery();
			//RESULTADO DE LA CONSULTA
			if(consulta.next()){
				idM=consulta.getInt("ULTIMO");
			}
			//DESCONEXION
			desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idM;
	}
	public Vehiculo consultarUno(int id) {
		Vehiculo v = new Vehiculo();
		
		try {
			//CONEXION
			conectar();
			//SENTENCIA
			PreparedStatement ps;
			ps= cx.prepareStatement("SELECT * FROM VEHICULO WHERE id=?");
			
			ps.setInt(1,id);
			//CONSULTA
			ResultSet rs= ps.executeQuery();
			//RESPUESTA DE LA BASE DE DATOS
			if(rs.next()) {
				v.setId(rs.getInt("id"));
				v.setMatricula(rs.getString("matricula"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setColor(rs.getString("color"));
				v.setCaballos(rs.getInt("caballos"));
				v.setCambio(rs.getBoolean("cambio"));
			}
			//desconexion
			desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	public ArrayList<Vehiculo> consultarTodos() {
		ArrayList<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
		
		try {
			//CONEXION
			conectar();
			//SENTENCIA
			PreparedStatement ps = cx.prepareStatement("SELECT * FROM VEHICULO");
			//CONSULTA
			ResultSet consulta= ps.executeQuery();
			//RESPUESTA
			while(consulta.next()){
				Vehiculo v = new Vehiculo();
				v.setId(consulta.getInt("id"));
				v.setMatricula(consulta.getString("matricula"));
				v.setMarca(consulta.getString("marca"));
				v.setModelo(consulta.getString("modelo"));
				v.setColor(consulta.getString("color"));
				v.setCaballos(consulta.getInt("caballos"));
				v.setCambio(consulta.getBoolean("cambio"));
				vehiculos.add(v);
			}
			//DESCONEXION
			desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehiculos;
	}

	public int borrar(int id) {
		int filasAfectadas=0;
		try {
			//CONEXION
			conectar();
			//SENTENCIA
			PreparedStatement ps= cx.prepareStatement("DELETE FROM VEHICULO WHERE ID =?");
				
			ps.setInt(1, id);
			//CONSULTA
			filasAfectadas= ps.executeUpdate();
			//COMMIT
			cx.commit(); 
			//DESCONEXION
	        desconectar();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
			}
		return filasAfectadas;
	}

	public ArrayList<Vehiculo> consultarMatricula(String matricula) {
		ArrayList<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
	       try {
	            //CONEXION
	            conectar();
	            //SENTENCIA
	            PreparedStatement ps = cx.prepareStatement("SELECT * FROM VEHICULO WHERE MATRICULA LIKE ?");
	            //SETEAR EL INTERROGANTE
	            ps.setString(1, "%" +matricula+  "%");
	            //CONSULTA
	            ResultSet consulta = ps.executeQuery();
	            //RESULTADO DE LA CONSULTA
	            while(consulta.next()){
					Vehiculo v = new Vehiculo();
					v.setId(consulta.getInt("id"));
					v.setMatricula(consulta.getString("matricula"));
					v.setMarca(consulta.getString("marca"));
					v.setModelo(consulta.getString("modelo"));
					v.setColor(consulta.getString("color"));
					v.setCaballos(consulta.getInt("caballos"));
					v.setCambio(consulta.getBoolean("cambio"));
					vehiculos.add(v);
				}
	            //DESCONEXION
	            desconectar();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return vehiculos;
	}
	
	public int modificar(int id, String matricula, String marca, String modelo,
			String color, int caballos, boolean cambio) {
		int filasAfectadas=0;
        try { 
            //CONEXION
              conectar();
            //SENTENCIA
              PreparedStatement ps= cx.prepareStatement("UPDATE VEHICULO SET MATRICULA=?,MARCA=?,MODELO=?,COLOR=?,CABALLOS=?,CAMBIO=? WHERE ID=?");
            //SETEAR LOS INTERROGANTES                                                   
              ps.setString(1, matricula);
              ps.setString(2, marca);
              ps.setString(3, modelo);
              ps.setString(4, color);
              ps.setInt(5, caballos);
              ps.setBoolean(6, cambio);
              ps.setInt(7, id);
            //CONSULTA
              filasAfectadas= ps.executeUpdate();
            //COMMIT
              cx.commit();
           //DESCONEXION
              desconectar();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return filasAfectadas;
	}
}
