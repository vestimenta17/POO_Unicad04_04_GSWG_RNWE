/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import java.util.List;
import Modelo.Auto;

/**
 *
 * @author User
 */
interface IAutoServicio {
    public Auto crear(Auto auto);
    public List<Auto> listar();
    public Auto modificar(int codigo, Auto autoNuevo);
    public Auto eliminar(int codigo);
    public Auto buscarPorCodigo(int codigo);
    public int buscarPosicion(Auto auto);
}
