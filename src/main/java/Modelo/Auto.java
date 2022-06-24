/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author HP
 */
public class Auto {
    int codigo;
    String placa;
    String marca;
    int precio;
    int kilometraje;
    String modelo;

    public Auto(int codigo, String placa, String marca, int precio, 
            int kilometraje, String modelo) {
        this.codigo = codigo;
        this.placa = placa;
        this.marca = marca;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.modelo = modelo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    @Override
    public String toString() {
        return "Auto{" + "codigo=" + codigo + ", placa=" + placa + 
                ", marca=" + marca + ", precio=" + precio + ", kilometraje=" 
                + kilometraje + ", modelo=" + modelo +'}';
    }
}

    