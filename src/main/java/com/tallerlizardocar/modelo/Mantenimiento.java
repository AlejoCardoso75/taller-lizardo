package com.tallerlizardocar.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA que representa un mantenimiento programado para un
 * vehículo del cliente. Se mapea a la tabla mantenimientos.
 */
@Entity
@Table(name = "mantenimientos")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false, length = 20)
    private String placa;

    @Column(nullable = false, length = 100)
    private String cliente;

    @Column(name = "responsable_tecnico", nullable = false, length = 100)
    private String responsableTecnico;

    @Column(name = "tipo_servicio", nullable = false, length = 60)
    private String tipoServicio;

    @Column(length = 255)
    private String repuestos;

    public Mantenimiento() {
    }

    public Mantenimiento(String fecha, String placa, String cliente, String responsableTecnico,
                         String tipoServicio, String repuestos) {
        this.fecha = fecha;
        this.placa = placa;
        this.cliente = cliente;
        this.responsableTecnico = responsableTecnico;
        this.tipoServicio = tipoServicio;
        this.repuestos = repuestos;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getResponsableTecnico() { return responsableTecnico; }
    public void setResponsableTecnico(String responsableTecnico) { this.responsableTecnico = responsableTecnico; }

    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }

    public String getRepuestos() { return repuestos; }
    public void setRepuestos(String repuestos) { this.repuestos = repuestos; }
}