package modelo;

public class Bebida implements Producto{

	private String nombre;
	private double precio;
	private int calorias;
	private int n;

	public Bebida(String nombre, double precioBase, int calorias, int n) {
		this.nombre = nombre;
		this.precio = precioBase;
		this.calorias = calorias;
		this.n = n;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public double getPrecio() {
		return precio;
	}

	@Override
	public String generarTextoFactura() {
		return n + ". " + nombre + " -> $" + precio + ", "+ calorias + " cal.\n";
	}

	@Override
	public int getCalorias() {
		return calorias;
	}

	@Override
	public int getNo() {
		// TODO Auto-generated method stub
		return n;
	} 
	
}
