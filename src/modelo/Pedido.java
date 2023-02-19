package modelo;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

public class Pedido {
	
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> pedido;
	private ArrayList<String> registrosPedido;
	
	public Pedido(String nombreCliente, String direccionCliente, int numeroPedidos) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.numeroPedidos = numeroPedidos;
		this.idPedido = this.numeroPedidos + 1;
		this.numeroPedidos++;
		this.pedido = new ArrayList<Producto>();
		this.registrosPedido = new ArrayList<String>();
		}
	
	public int getIdPedido() {
		return idPedido;
	}
	
	public void agregarProducto(Producto nuevoItem) {
		pedido.add(nuevoItem);
		registrosPedido.add(nuevoItem.generarTextoFactura());
	}
	
	public void ordenarPedido() {
		Collections.sort(registrosPedido);
	}
	
	public String getRegistroPedido() {
		String registros = "";
		for (String registro: registrosPedido) {
			registros += registro;
		}
		return registros;
	}
	
	private double getPrecioNetoPedido() {
		double p = 0;
		for (Producto producto: pedido) {
			p += producto.getPrecio();
		}
		return p;
	}
	
	private double getPrecioIVAPedido() {
		double precioBase = getPrecioNetoPedido();
		double IVA = precioBase*0.19;
		return IVA;
	}
	
	private double getPrecioTotalPedido() {
		double precioBase = getPrecioNetoPedido();
		double IVA = getPrecioIVAPedido();
		double precioTotal = precioBase + IVA;
		return precioTotal;
	}
	
	public String generarTextoFactura() {
		String mssg = "";
		mssg += "RESTAURANTE DE HAMBURGUESAS DPOO\n";
		mssg += "--------------------------------\n\n";
		mssg += "ID pedido: " + idPedido + "\n";
		mssg += "Nombre cliente: " + nombreCliente + "\n";
		mssg += "Dirección cliente: " + direccionCliente + "\n\n";
		mssg += "Artículos comprados\n--------------------------------\n";
		for (Producto producto: pedido) {
			mssg += producto.generarTextoFactura() + " ^";
		}
		mssg += "\n--------------------------------\nPrecio neto: $" + getPrecioNetoPedido() + "\n";
		mssg += "IVA: $" + getPrecioIVAPedido() + "\n";
		mssg += "Precio total: $" + getPrecioTotalPedido() + "\n--------------------------------\n";
		mssg += "\n¡Gracias por su compra!";
		return mssg;
	}
	
	public void guardarFactura(File archivo) throws IOException {
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String factura = this.generarTextoFactura();
        wr.write(factura);
        wr.close();
        bw.close();
	}
	
}