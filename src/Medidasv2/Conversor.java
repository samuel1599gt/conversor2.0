/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidasv2;

/**
 *
 * @author WIN 10
 */
public class Conversor {
    public static double convertirDistancia(double valor, String unidadOrigen, String unidadDestino) {
        switch (unidadOrigen) {
            case "Metros":
                break;
            case "Kilómetros":
                valor *= 1000;
                break;
            case "Millas":
                valor *= 1609.34;
                break;
            case "Pies":
                valor *= 0.3048;
                break;
        }
        
        switch (unidadDestino) {
            case "Metros":
                break;
            case "Kilómetros":
                valor /= 1000;
                break;
            case "Millas":
                valor /= 1609.34;
                break;
            case "Pies":
                valor /= 0.3048;
                break;
        }

        return valor;
    }

    public static double convertirVolumen(double valor, String unidadOrigen, String unidadDestino) {
        switch (unidadOrigen) {
            case "Litros":
                break;
            case "Mililitros":
                valor /= 1000;
                break;
            case "Galones":
                valor *= 3.78541;
                break;
        }
        
        switch (unidadDestino) {
            case "Litros":
                break;
            case "Mililitros":
                valor *= 1000;
                break;
            case "Galones":
                valor /= 3.78541;
                break;
        }

        return valor;
    }

    public static double convertirPeso(double valor, String unidadOrigen, String unidadDestino) {
        switch (unidadOrigen) {
            case "Kilogramos":
                break;
            case "Gramos":
                valor /= 1000;
                break;
            case "Libras":
                valor *= 0.453592;
                break;
        }
        
        switch (unidadDestino) {
            case "Kilogramos":
                break;
            case "Gramos":
                valor *= 1000;
                break;
            case "Libras":
                valor /= 0.453592;
                break;
        }

        return valor;
    }
}
 
    

