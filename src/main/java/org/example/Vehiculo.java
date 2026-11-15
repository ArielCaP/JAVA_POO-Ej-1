package org.example;

import java.security.cert.CertificateRevokedException;

public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private double tarifaBase;

    public Vehiculo(String placa, String marca, String modelo, double tarifaBase) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaBase = tarifaBase;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double calcularTarifaDiaria(){
        return this.tarifaBase;
    }
    public double calcularAlquiler(int dias){
        return calcularTarifaDiaria() * dias;
    }
    public double calcularAlquiler(int dias, double porcentajeDescuento){
        double total=calcularAlquiler(dias);
        return total-(total*(porcentajeDescuento/100));
    }

    @Override
    public String toString() {
        return "[Vehiculo] " +
                placa +
                ", "+marca+
                ", "+ modelo+
                ", Tarifa diaria: $" + String.format("%.2f", calcularTarifaDiaria());
    }
}
