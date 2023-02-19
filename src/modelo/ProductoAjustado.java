package modelo;

public class ProductoAjustado implements Producto{
	
	private Producto productoBase;
	private double precio;
	private String agregados;
	private String eliminados;
	private int calorias;

	public ProductoAjustado(Producto base) {
		this.productoBase = base;
		this.precio = productoBase.getPrecio();
		this.agregados = "";
		this.eliminados = "";
		this.calorias = productoBase.getCalorias();
	}
	
	public void agregarIngrediente(Ingrediente ingrediente) {
		precio += ingrediente.getCostoAdicional();
		agregados += ingrediente.getNombre() + ",";
		calorias += ingrediente.getCalorias();
		}
	
	public void eliminarIngrediente(Ingrediente ingrediente) {
		eliminados += ingrediente.getNombre() + ",";
		calorias -= ingrediente.getCalorias();
	}
	
	@Override
	public double getPrecio() {
		return precio;
	}

	@Override
	public String getNombre() {
		return productoBase.getNombre();
	}

	@Override
	public String generarTextoFactura() {
		String mssg = productoBase.getNo() + ". " + productoBase.getNombre() + " -> $" + precio + ", "+ calorias +" cal.\n";
		if (agregados != "") {
			mssg += "  (Con adición de " + agregados + ")\n";
		}
		if (eliminados != "") {
			mssg += "  (Sin " + eliminados + ")\n";
		}
		return mssg;
	}

	@Override
	public int getCalorias() {
		return calorias;
	}

	@Override
	public int getNo() {
		return productoBase.getNo();
	}

}