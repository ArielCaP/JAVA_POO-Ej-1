package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        ArrayList<Vehiculo> listaVehiculos=new ArrayList<>();
        Set<String> listaPlacas=new HashSet<>();
        do{
            System.out.println("--- MENU RENTAESFOT ---");
            System.out.println("1. Registrar auto");
            System.out.println("2. Rgistrar camioneta");
            System.out.println("3. Mostrar vehiculos");
            System.out.println("4. Cotizar alquiler");
            System.out.println("5. Mostrar estadisticas");
            System.out.println("6. Salir");
            System.out.println("Ingrese opcion: ");
            opcion=sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1: {
                    System.out.println("Placa: ");
                    String placa = sc.nextLine();
                    if (listaPlacas.add(placa)) {
                        System.out.println("Marca: ");
                        String marca = sc.nextLine();
                        System.out.println("Modelo: ");
                        String modelo = sc.nextLine();
                        System.out.println("Tarifa diaria base: ");
                        double tarifa = sc.nextDouble();
                        sc.nextLine();
                        if (tarifa < 0) {
                            System.out.printf("La tarifa no puede sr negativa.");
                            listaPlacas.remove(placa);
                        } else {
                            System.out.println("Numero de puertas: ");
                            int numeroPuertas = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Tiene aire acondicionado? (s/n): ");
                            boolean tieneAireAcondicionado = sc.nextLine().equalsIgnoreCase("s");
                            listaVehiculos.add(new Auto(placa, marca, modelo, tarifa, numeroPuertas, tieneAireAcondicionado));
                            System.out.println("Auto registrado exitosamente.");
                        }
                    } else {
                        System.out.println("La placa " + placa + " ya esta registrada.");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Placa: ");
                    String placa = sc.nextLine();
                    if (listaPlacas.add(placa)) {
                        System.out.println("Marca: ");
                        String marca = sc.nextLine();
                        System.out.println("Modelo: ");
                        String modelo = sc.nextLine();
                        System.out.println("Tarifa diaria base: ");
                        double tarifa = sc.nextDouble();
                        sc.nextLine();

                        if (tarifa < 0) {
                            System.out.println("La tarifa no puede ser negativa");
                            listaPlacas.remove(placa);
                        } else {
                            System.out.println("Capacidad de carga (t): ");
                            double capacidadCarga = sc.nextDouble();
                            sc.nextLine();
                            if (capacidadCarga < 0) {
                                System.out.println("La capacidad de carga no puede ser negativa");
                                listaPlacas.remove(placa);
                            } else {
                                listaVehiculos.add(new Camion(placa, marca, modelo, tarifa, capacidadCarga));
                                System.out.println("Camioneta registrada exitosamente.");
                            }
                        }
                    } else {
                        System.out.println("La placa " + placa + " ya esta registrada.");
                    }
                    break;
            }
                case 3:{
                    if (!listaVehiculos.isEmpty()) {
                        for (Vehiculo v : listaVehiculos) {
                            System.out.println(v);
                        }
                    } else {
                        System.out.println("No hay vehiculos registrados.");
                    }
                    break;
            }
                case 4: {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    Vehiculo encontrado = null;
                    for (Vehiculo v : listaVehiculos) {
                        if (v.getPlaca().equals(placa)) {
                            encontrado = v;
                        }
                    }
                    if (encontrado == null) {
                        System.out.println("La placa " + placa + " no existe.");
                    } else {
                        System.out.print("Días: ");
                        int dias = Integer.parseInt(sc.nextLine());
                        if (dias <= 0) {
                            System.out.println("Los días deben ser mayores a 0.");
                        } else {
                            System.out.print("¿Aplica descuento? (s/n): ");
                            boolean aplicaDescuento = sc.nextLine().equalsIgnoreCase("s");
                            if (aplicaDescuento) {
                                System.out.print("Porcentaje de descuento: ");
                                double porcentaje = Double.parseDouble(sc.nextLine());
                                if (porcentaje < 0 || porcentaje > 50) {
                                    System.out.println("El descuento debe estar entre 0 y 50.");
                                } else {
                                    double total = encontrado.calcularAlquiler(dias, porcentaje);
                                    System.out.println("Total a pagar: $" + String.format("%.2f", total));
                                }
                            } else {
                                double total = encontrado.calcularAlquiler(dias);
                                System.out.println("Total a pagar: $" + String.format("%.2f", total));
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    if (listaVehiculos.isEmpty()) {
                        System.out.println("No hay vehículos registrados.");
                    } else {
                        Vehiculo mayor = listaVehiculos.get(0);   // empiezo suponiendo que el primero es el mayor
                        double suma = 0;
                        for (Vehiculo v : listaVehiculos) {
                            suma += v.calcularTarifaDiaria();
                            if (v.calcularTarifaDiaria() > mayor.calcularTarifaDiaria()) {
                                mayor = v;                        // encontré uno más caro
                            }
                        }
                        double promedio = suma / listaVehiculos.size();

                        System.out.println("Vehículo con mayor tarifa diaria: " + mayor.getMarca() + " "
                                + mayor.getModelo() + " ($" + String.format("%.2f", mayor.calcularTarifaDiaria()) + ")");
                        System.out.println("Promedio de tarifas diarias: $" + String.format("%.2f", promedio));
                    }
                    break;
                }
                case 6:
                    System.out.println("Saliendoo");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }while(opcion!=6);
        sc.close();




    }
}
