/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;
import Modelo.Propietario;
import Servicio.PropietarioServicio;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class PropietarioControl {
    private final PropietarioServicio propietarioServicio = new PropietarioServicio();
    
    public Propietario crear(String [] args) throws RuntimeException{
        var propietario = new Propietario(this.convertirEntero(args[0]),args[1],
                LocalDate.parse(args[2]),this.convertirEntero(args[3]),args[4]);
        this.propietarioServicio.crear(propietario);
        return propietario;                                                    
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
    public Propietario buscarPropietario(String arg){
        return this.propietarioServicio.buscarPorId(Integer.valueOf(arg));
    }
    
    public Propietario eliminar(String arg)
    {
        return this.propietarioServicio.eliminar(Integer.valueOf(arg));
    }
    public Propietario modificar(String [] args){
        Propietario propietarioNuevo = new Propietario(Integer.valueOf(args[0]),
                args[1],LocalDate.parse(args[2]),Integer.valueOf(args[3]),args[4]);
        this.propietarioServicio.modificar(Integer.valueOf(args[0]), propietarioNuevo);
        return propietarioNuevo;
    }
    public List<Propietario> listar()
    {
        return this.propietarioServicio.listar();
    }
}

