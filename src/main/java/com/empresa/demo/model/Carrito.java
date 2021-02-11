package com.empresa.demo.model;

//PRIMERA PRUEBA DE CARRITO
public class Carrito {
	
	int item;
	String idProducto;
	String nombres;
	String descripcion;
	double precioCompra;
	float cantidad;
	double subTotal;
	
	public Carrito() {
		// TODO Auto-generated constructor stub
	}

	public Carrito(int item, String idProducto, String nombres, String descripcion, double precioCompra, float cantidad,
			double subTotal) {
		super();
		this.item = item;
		this.idProducto = idProducto;
		this.nombres = nombres;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	

	

}
