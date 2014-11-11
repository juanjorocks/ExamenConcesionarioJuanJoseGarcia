package es.concesionario.modelo;

public class Vehiculo {
	private int id;
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int caballos;
	private boolean cambio;
	
	//METODOS CONSTRUCTORES
	public Vehiculo(int id, String matricula, String marca, String modelo,
			String color, int caballos, boolean cambio) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.caballos = caballos;
		this.cambio = cambio;
	}
	
	
	public Vehiculo(String matricula, String marca, String modelo,
			String color, int caballos, boolean cambio) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.caballos = caballos;
		this.cambio = cambio;
	}



	public Vehiculo() {
		super();
	}

	//METODOS GET Y SET
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public boolean isCambio() {
		return cambio;
	}

	public void setCambio(boolean cambio) {
		this.cambio = cambio;
	}
	
	
	
	
	
}
