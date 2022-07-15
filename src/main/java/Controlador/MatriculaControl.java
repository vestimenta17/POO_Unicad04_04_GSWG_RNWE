/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Auto;
import java.util.List;
import Modelo.Matricula;
import Modelo.Propietario;
import Servicio.AutoServicio;
import Servicio.MatriculaServicio;
import Servicio.PropietarioServicio;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class MatriculaControl {
    public final MatriculaServicio matriculaServicio = new MatriculaServicio();
    public final AutoServicio autoServicio= new AutoServicio();
    public final PropietarioServicio propietarioServicio= new PropietarioServicio();
    
    public Matricula crear(String [] args) throws RuntimeException{
        Auto auto = this.autoServicio.buscarPorCodigo(Integer.valueOf(args[3]));
        Propietario propietario = this.propietarioServicio.buscarPorId(Integer.valueOf(args[4]));
        Matricula matricula = new Matricula(this.convertirEntero(args[0]),
                LocalDate.parse(args[1]),this.convertirEntero(args[2]),
                auto,propietario);
        this.matriculaServicio.crear(matricula);
        return matricula;                                                    
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
    public Matricula buscarMatricula(String arg){
        return this.matriculaServicio.buscarPorCod(Integer.valueOf(arg));
    }
    
    public Matricula eliminar(String arg)
    {
        return this.matriculaServicio.eliminar(Integer.valueOf(arg));
    }
    
    public Matricula modificar(String [] args){
        Auto auto = this.autoServicio.buscarPorCodigo(Integer.valueOf(args[3]));
        Propietario propietario= this.propietarioServicio.buscarPorId(Integer.valueOf(args[4]));
//        Matricula matricula= this.matriculaServicio.buscarPorCod(Integer.valueOf(args[0]));
//        if(matricula!=null){
//            matricula.setNumero(Integer.valueOf(args[0]));
//            matricula.setFechaMatricula(LocalDate.parse(args[1]));
//            matricula.setNumeroChasis(Integer.valueOf(args[2]));
//            matricula.setAuto(auto);
//            matricula.setPropietario(propietario);
//            return matricula;
//        }
        Matricula matriculaNuevo = new Matricula(Integer.valueOf(args[0]),
                LocalDate.parse(args[1]),Integer.valueOf(args[2]),
                auto,propietario);
        this.matriculaServicio.modificar(Integer.valueOf(args[0]), matriculaNuevo);
        return matriculaNuevo;
    }
    
    public List<Matricula> listar()
    {
        return this.matriculaServicio.listar();
    }
}

