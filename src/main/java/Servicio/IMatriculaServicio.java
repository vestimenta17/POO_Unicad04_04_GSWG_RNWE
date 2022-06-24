/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import java.util.List;
import Modelo.Matricula;

interface IMatriculaServicio {
    public Matricula crear(Matricula matricula);
    public List<Matricula> listar();
    public Matricula modificar(int codigoMatricula, Matricula matriculaNuevo);
    public Matricula eliminar(int codigoMatricula);
    public Matricula buscarPorCod(int codigoMatricula);
    public int buscarPosicion(Matricula matricula);
}
