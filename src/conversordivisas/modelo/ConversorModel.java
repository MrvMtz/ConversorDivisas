/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package conversordivisas.modelo;

import java.util.ArrayList;

/**
 *
 * @author MrvMtz
 */
public class ConversorModel {

     private ArrayList<Moneda> monedas;

    public ConversorModel() {
        
        monedas = new ArrayList<>();
        // Agregar las monedas disponibles
        monedas.add(new Moneda(1, "USD - Dólar estadounidense", 1, "/conversordivisas/vista/icons/USD.png"));
        monedas.add(new Moneda(2, "EUR - Euro", 1.1078, "/conversordivisas/vista/icons/EUR.png"));
        monedas.add(new Moneda(3, "MXN - Peso Mexicano", 0.0593971, "/conversordivisas/vista/icons/MXN.png"));
        monedas.add(new Moneda(4, "GBP - Libra Esterlina", 1.29001, "/conversordivisas/vista/icons/GBP.png"));
        monedas.add(new Moneda(5, "CAD - Dolar Canadiense", 0.758998, "/conversordivisas/vista/icons/CAD.png"));
        monedas.add(new Moneda(6, "JPY - Yen Japonés", 0.00709439, "/conversordivisas/vista/icons/JPY.png"));
        monedas.add(new Moneda(7, "CNY - Yuan Chino", 0.140139, "/conversordivisas/vista/icons/CNY.png"));
        monedas.add(new Moneda(8, "RUB - Rublo Ruso", 0.140139, "/conversordivisas/vista/icons/RUB.png"));
        monedas.add(new Moneda(9, "BRL - Real Brasilero", 0.210527, "/conversordivisas/vista/icons/BRL.png"));
        monedas.add(new Moneda(10, "ARS - Peso Argentino", 0.00368163, "/conversordivisas/vista/icons/ARS.png"));
        monedas.add(new Moneda(11, "CLP- Peso Chileno", 0.00120655, "/conversordivisas/vista/icons/CLP.png"));
        monedas.add(new Moneda(12, "COP - Peso Colombiano", 0.000251878, "/conversordivisas/vista/icons/COP.png"));
        monedas.add(new Moneda(13, "UYU - Peso Uruguayo", 0.0263994, "/conversordivisas/vista/icons/UYU.png"));
        monedas.add(new Moneda(14, "PEN - Sol Peruano", 0.277627, "/conversordivisas/vista/icons/PEN.png"));
        monedas.add(new Moneda(15, "HNL - Lempira Hondureño", 0.0406082, "/conversordivisas/vista/icons/HNL.png"));
        monedas.add(new Moneda(16, "GTQ - Quetzal Guatemalteco", 0.127368, "/conversordivisas/vista/icons/GTQ.png"));
        monedas.add(new Moneda(17, "PAB - Balboa Panameño", 1, "/conversordivisas/vista/icons/PAB.png"));
        monedas.add(new Moneda(18, "SAR - Riyal Saudi", 0.266667, "/conversordivisas/vista/icons/SAR.png"));
        monedas.add(new Moneda(19, "BTC - Bitcoin", 29235.1, "/conversordivisas/vista/icons/BTC.png"));
        monedas.add(new Moneda(20, "ETH - Ethereum", 1862.61, "/conversordivisas/vista/icons/ETH.png"));
    
    }

    public ArrayList<Moneda> getMonedas() {
        return monedas;
    }
    

    public double otraDivisaADolar(double cantidad, double tasaCambio){
        return cantidad*tasaCambio;
    }
    
    public double DolaraOtraDivisa(double cantidad, double tasaCambio){
        return cantidad/tasaCambio;
    }
}
