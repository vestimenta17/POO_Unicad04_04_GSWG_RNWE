/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;
import Modelo.Auto;
import Servicio.AutoServicio;

/**
 *
 * @author User
 */
public class AutoControl {
    private final AutoServicio autoServicio = new AutoServicio();
    public Auto crear(String [] args) throws RuntimeException{
        var auto = new Auto(this.convertirEntero(args[0]), args[1], args[2], 
                this.convertirEntero(args[3]), this.convertirEntero(args[4]),args[5]);
        this.autoServicio.crear(auto);
        return auto;                                                    
    }
    
    private int convertirEntero(String numero){
        try
        {
            return Integer.valueOf(numero);
        }catch(NumberFormatException e){
            throw new RuntimeException("El campo ingresado solamente recibe "
                    + "números");
        }catch(Exception e){
            throw new RuntimeException("Error inesperado");
        }
    }
    
    public Auto buscarAuto(String arg){
        return this.autoServicio.buscarPorCodigo(Integer.valueOf(arg));
    }
    
    public Auto eliminar(String arg)
    {
        return this.autoServicio.eliminar(Integer.valueOf(arg));
    }
    public Auto modificar(String [] args) throws RuntimeException{
        Auto autoNuevo = new Auto(this.convertirEntero(args[0]),args[1],args[2],
                this.convertirEntero(args[3]),this.convertirEntero(args[4]),args[5]);
        this.autoServicio.modificar(this.convertirEntero(args[0]), autoNuevo);
        return autoNuevo;
    }
    public List<Auto> listar()
    {
        return this.autoServicio.listar();
    }
}
