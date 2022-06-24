/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

public class Matricula {
    int numero;
    LocalDate fechaMatricula;
    int numeroChasis;
    Auto auto;
    Propietario propietario;

    public Matricula(int numero, LocalDate fechaMatricula, int numeroChasis, 
            Auto auto, Propietario propietario) {
        this.numero = numero;
        this.fechaMatricula = fechaMatricula;
        this.numeroChasis = numeroChasis;
        this.auto = auto;
        this.propietario = propietario;
    }

    public Matricula(int numero, LocalDate fechaMatricula, int numeroChasis) {
        this.numero = numero;
        this.fechaMatricula = fechaMatricula;
        this.numeroChasis = numeroChasis;
    }   
 
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public int getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(int numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

        
    public int calcularExpiracion(){
        var retorno=1000;
        
        return retorno;
    }
    public boolean validadChasis(){
        var retorno=true;
        
        return retorno;
    }

    @Override
    public String toString() {
        return "Matricula{" + "numero=" + numero + ", fechaMatricula=" + 
                fechaMatricula + ", numeroChasis=" + numeroChasis + ", auto=" + 
                auto.toString() + ", propietario=" + propietario.toString() + '}';
    }  
}
