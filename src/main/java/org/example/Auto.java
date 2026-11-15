package org.example;

public class Auto extends Vehiculo{
    private int nueroPuertas;
    private boolean tieneAireAcondicionado;

    public Auto(String placa, String marca, String modelo, double tarifaBase, int nueroPuertas, boolean tieneAireAcondicionado) {
        super(placa, marca, modelo, tarifaBase);
        this.nueroPuertas = nueroPuertas;
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    public int getNueroPuertas() {
        return nueroPuertas;
    }

    public void setNueroPuertas(int nueroPuertas) {
        this.nueroPuertas = nueroPuertas;
    }

    public boolean isTieneAireAcondicionado() {
        return tieneAireAcondicionado;
    }

    public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    @Override
    public double calcularTarifaDiaria() {
        if(tieneAireAcondicionado){
            return super.calcularTarifaDiaria()+10;
        }else {
            return super.calcularTarifaDiaria();
        }
    }

    @Override
    public String toString() {
        String aire;
        if(tieneAireAcondicionado){
            aire="con A/C";
        }else{
            aire="no con A/C";
        }
        return "[Auto] "+getPlaca()+" "+getMarca()+" "+getModelo()+", "+getNueroPuertas()+
                " puertas"+", "+aire+", Tarifa diaria: $"+String.format("%.2f",calcularTarifaDiaria());
    }
}
