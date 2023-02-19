package modelo;

public class ProductoMenu implements Producto{
	
	private String nombre;
	private double precio;
	private int calorias;

	public ProductoMenu(String nombre, double precioBase, int calorias) {
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
		return "* " + nombre + " -> $" + getPrecio() + ", "+ getCalorias() +" cal.\n";
	} 
	
	@Override
	public int getCalorias() {
		return calorias;
	}
	
}