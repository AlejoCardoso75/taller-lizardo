package com.tallerlizardocar.dto;

public class ReporteFacturacionDTO {

    private int cantidadFacturas;
    private double totalFacturado;
    private double promedioPorFactura;

    public ReporteFacturacionDTO() {
    }

    public ReporteFacturacionDTO(int cantidadFacturas, double totalFacturado, double promedioPorFactura) {
        this.cantidadFacturas = cantidadFacturas;
        this.totalFacturado = totalFacturado;
        this.promedioPorFactura = promedioPorFactura;
    }

    public int getCantidadFacturas() { return cantidadFacturas; }
    public void setCantidadFacturas(int cantidadFacturas) { this.cantidadFacturas = cantidadFacturas; }

    public double getTotalFacturado() { return totalFacturado; }
    public void setTotalFacturado(double totalFacturado) { this.totalFacturado = totalFacturado; }

    public double getPromedioPorFactura() { return promedioPorFactura; }
    public void setPromedioPorFactura(double promedioPorFactura) { this.promedioPorFactura = promedioPorFactura; }
}