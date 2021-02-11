package com.empresa.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="plato")
public class Plato implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id_plato;
	@Column(name="nombre")
	private String nombre;
	@Column(name="precio")
	private double precio;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="stock")
	private int stock;
	@Column(name="imagen")
	private String imagen;
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	public Plato() {
		// TODO Auto-generated constructor stub
	}

	public Plato(String id_plato, String nombre, double precio, String descripcion, int stock, String imagen,
			Categoria categoria) {
		super();
		this.id_plato = id_plato;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.stock = stock;
		this.imagen = imagen;
		this.categoria = categoria;
	}

	public String getId_plato() {
		return id_plato;
	}

	public void setId_plato(String id_plato) {
		this.id_plato = id_plato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	//METODOS PARA EL STOCK
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void restarStock(Float stock) {
        this.stock -= stock;
    }
	
    public boolean sinStock() {
        return this.stock <= 0;
    }
	
	//

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	

}
