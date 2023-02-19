package modelo;

public class Bebida implements Producto{

	private String nombre;
	private double precio;
	private int calorias;

	public Bebida(String nombre, double precioBase, int calorias) {
		this.nombre = nombre;
		this.precio = precioBase;
		this.calorias = calorias;
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
		return "* " + nombre + " -> $" + precio + ", "+ calorias + " cal.\n";
	}

	@Override
	public int getCalorias() {
		return calorias;
	} 
	
}
