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
    public Auto crear(String [] args){
        var auto = new Auto(Integer.valueOf(args[0]), args[1], args[2], 
                Integer.valueOf(args[3]), Integer.valueOf(args[4]),args[5]);
        this.autoServicio.crear(auto);
        return auto;                                                    
    }
    public Auto buscarAuto(String arg){
        return this.autoServicio.buscarPorCodigo(Integer.valueOf(arg));
    }
    
    public Auto eliminar(String arg)
    {
        return this.autoServicio.eliminar(Integer.valueOf(arg));
    }
    public Auto modificar(String [] args){
        Auto autoNuevo = new Auto(Integer.valueOf(args[0]),args[1],args[2],
                Integer.valueOf(args[3]),Integer.valueOf(args[4]),args[5]);
        this.autoServicio.modificar(Integer.valueOf(args[0]), autoNuevo);
        return autoNuevo;
    }
    public List<Auto> listar()
    {
        return this.autoServicio.listar();
    }
}
