package modelo;

public class ProductoMenu implements Producto{
	
	private String nombre;
	private double precio;
	private int calorias;
	private int n;

	public ProductoMenu(String nombre, double precioBase, int calorias, int n) {
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
		return n + ". " + nombre + " -> $" + getPrecio() + ", "+ getCalorias() +" cal.\n";
	} 
	
	@Override
	public int getCalorias() {
		return calorias;
	}
	
	public int getNo() {
		return n;
	}
	
}