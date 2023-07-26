/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package conversordivisas.modelo;

/**
 *
 * @author MrvMtz
 */
public class Moneda {

    private int id;
    private String nombre;
    private double valor;
    private String path;

    public Moneda(int id, String nombre, double valor, String path) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.path = path;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
