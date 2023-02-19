package modelo;

public class Ingrediente {	
	
	private String nombre;
	private int costoAdicional;
	private int calorias;
	private int n;
	
	public Ingrediente (String nombre, int costoAdicional, int calorias, int n) {
		this.nombre = nombre;
		this.costoAdicional = costoAdicional;
		this.calorias = calorias;
		this.n = n;
	}
	
	public String getNombre () {
		return nombre;
	}
	
	public int getCostoAdicional() {
		return costoAdicional;
	}
	
	public int getCalorias() {
		return calorias;
	}

	public int getNo() {
		return n;
	}
	
}