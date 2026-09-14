package com.tallerlizardocar.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA que representa un producto del inventario del taller.
 *
 * La anotación @Entity le indica a Spring Data JPA que esta clase se
 * debe mapear a una tabla de la base de datos; @Table indica el nombre
 * exacto de esa tabla (productos, la misma usada en las evidencias
 * AA2-EV01 y AA2-EV02).
 */
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String categoria;

    @Column(nullable = false, length = 60)
    private String marca;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double precio;

    /**
     * Constructor vacío requerido por JPA/Hibernate para poder
     * instanciar la entidad al leer resultados de la base de datos.
     */
    public Producto() {
    }

    /**
     * Constructor usado al crear un producto nuevo, todavía sin id.
     */
    public Producto(String nombre, String categoria, String marca, Integer cantidad, Double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Calcula el valor total del producto en inventario (cantidad x precio).
     */
    public double calcularValorTotal() {
        return cantidad * precio;
    }
}
