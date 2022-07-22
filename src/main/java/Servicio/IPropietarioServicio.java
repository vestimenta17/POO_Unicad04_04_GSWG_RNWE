/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import java.util.List;
import Modelo.Propietario;

/**
 *
 * @author User
 */
public interface IPropietarioServicio {
    public Propietario crear(Propietario propietario);
    public List<Propietario> listar();
    public Propietario buscarPorId(int idPropietario);
    public Propietario eliminar(int idPropietario);
    public Propietario modificar(int idPropietario, Propietario propietarioNuevo);
    public int buscarPosicion(Propietario propietario);
    public boolean almacenarEnArchivo(Propietario propietario, String rutaArchivo) throws Exception;
    public List<Propietario> recuperarDeArchivo(String rutaArchivo) throws Exception;
}
