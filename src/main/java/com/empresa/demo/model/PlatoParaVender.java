package com.empresa.demo.model;

public class PlatoParaVender extends Plato {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int item;
	private double precioCompra;
	private double cantidad;
	private double subTotal;
	
	
	

	
    public PlatoParaVender(String id_plato, String nombre, double precio, String descripcion, int stock, String imagen,
			Categoria categoria, int item, double precioCompra, double cantidad, double subTotal) {
		super(id_plato, nombre, precio, descripcion, stock, imagen, categoria);
		this.item = item;
		this.precioCompra = precioCompra;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
	}

    public void aumentarCantidad() {
        this.cantidad++;
    }
    



	public int getItem() {
		return item;
	}





	public void setItem(int item) {
		this.item = item;
	}





	public double getPrecioCompra() {
		return precioCompra;
	}





	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}





	public double getCantidad() {
		return cantidad;
	}





	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}





	public double getSubTotal() {
		return subTotal;
	}





	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}





	public double getTotal() {
        return this.getPrecio() * this.cantidad;
    }
	
	

	

}
