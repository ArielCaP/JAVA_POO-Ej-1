package org.example;

public class Camion extends Vehiculo{
    public static final double RECARGO=15;
    private double capacidadCarga;

    public Camion(String placa, String marca, String modelo, double tarifaBase, double capacidadCarga) {
        super(placa, marca, modelo, tarifaBase);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularTarifaDiaria() {
        if(capacidadCarga>1.5){
            return super.calcularTarifaDiaria()+(super.calcularTarifaDiaria()*(RECARGO/100));
        }else {
            return super.calcularTarifaDiaria();
        }
    }

    @Override
    public String toString() {
        return  "[Camioneta] "+getPlaca()+" "+getMarca()+" "+getModelo()+", carga "+getCapacidadCarga()+" t"+
                ", Tarifa diaria: $"+String.format("%.2f",calcularTarifaDiaria());
    }
}
