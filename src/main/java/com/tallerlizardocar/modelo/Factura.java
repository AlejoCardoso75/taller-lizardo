package com.tallerlizardocar.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String cliente;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false, length = 150)
    private String concepto;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    public Factura() {
    }

    public Factura(String cliente, String fecha, String concepto, Double valorTotal) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.concepto = concepto;
        this.valorTotal = valorTotal;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getConcepto() { return concepto; }
    public void setConcepto(String concepto) { this.concepto = concepto; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
}