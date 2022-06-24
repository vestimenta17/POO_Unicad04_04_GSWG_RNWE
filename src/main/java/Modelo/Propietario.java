/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Propietario {
    int idPropietario;
    String nombrePropietario;
    LocalDate fechaNacPropietario;
    int numeroVehiculosPropietario;
    String tipoLicenciaPropietario;
    
    public Propietario(int idPropietario, String nombrePropietario, 
            LocalDate fechaNacPropietario, int numeroVehiculosPropietario, 
            String tipoLicenciaPropietario) {
        this.idPropietario = idPropietario;
        this.nombrePropietario = nombrePropietario;
        this.fechaNacPropietario = fechaNacPropietario;
        this.numeroVehiculosPropietario = numeroVehiculosPropietario;
        this.tipoLicenciaPropietario = tipoLicenciaPropietario;
    }
    
    
    public boolean idValida(){
        var retorno= false;
        
        return retorno;
    }
    public int identificarNumeroVehiculos(){
        var retorno=10000;
        
        return retorno;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public LocalDate getFechaNacPropietario() {
        return fechaNacPropietario;
    }

    public void setFechaNacPropietario(LocalDate fechaNacPropietario) {
        this.fechaNacPropietario = fechaNacPropietario;
    }

    public int getNumeroVehiculosPropietario() {
        return numeroVehiculosPropietario;
    }

    public void setNumeroVehiculosPropietario(int numeroVehiculosPropietario) {
        this.numeroVehiculosPropietario = numeroVehiculosPropietario;
    }

    public String getTipoLicenciaPropietario() {
        return tipoLicenciaPropietario;
    }

    public void setTipoLicenciaPropietario(String tipoLicenciaPropietario) {
        this.tipoLicenciaPropietario = tipoLicenciaPropietario;
    }

    @Override
    public String toString() {
        return "Propietario{" + "idPropietario=" + idPropietario + 
                ", nombrePropietario=" + nombrePropietario + 
                ", fechaNacPropietario=" + fechaNacPropietario + 
                ", numeroVehiculosPropietario=" + numeroVehiculosPropietario + 
                ", tipoLicenciaPropietario=" + tipoLicenciaPropietario + '}';
    }
    

 
    
}
