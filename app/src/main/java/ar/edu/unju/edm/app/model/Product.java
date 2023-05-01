package ar.edu.unju.edm.app.model;

import org.springframework.stereotype.Component;

@component
public class Product  {
	
	private int ID;
	private String nombre;
	private String descripcion;
	private String precio;
	private String marca;
	private int Stock;
	private String URL;
	
	public Product () {}
	
	public Product (int ID,String nombre, String descripcion, String precio, String marca, int Stock,String URL) {}
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
        this.Stock = stock;
        this.URL = URL
    }
    public String getNombre () {
    	return nombre;
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
}
    public String getDescripcion () {
        return descripcion;
    }
    public void setDescripcion (String descripcion) {
    	this.descripcion = descripcion;
    }
    public String getPrecio () {
    	return precio;
    }
    public void setPrecio (String precio) {
    	this.precio = precio;
    }
    public String getMarca () {
    	return marca;
    }
    public void setMarca (String marca) {
    	this.marca = marca;
    }
    public int getID () {
    	return ID;
    }
    public void setStock (int Stock) {
    	this.Stock = Stock;
    }
    public String getURL () {
    	return URL;
    }
    public void setURL (String URL) {
    	this.URL = URL
    }