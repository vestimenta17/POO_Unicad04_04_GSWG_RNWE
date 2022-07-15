/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Propietario;
import java.util.ArrayList;
import java.util.List;

public class PropietarioServicio implements IPropietarioServicio {

    private static List<Propietario> propietarioList = new ArrayList<>();

    @Override
    public Propietario crear(Propietario propietario) {
        var propietarioBuscado=this.buscarPorId(propietario.getIdPropietario());
        if(propietarioBuscado==null){
            this.propietarioList.add(propietario);
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado a: "+propietarioBuscado.getNombrePropietario());
        }
        return propietario;
    }

    @Override
    public List<Propietario> listar() {
        return this.propietarioList;
    } 

   @Override
    public Propietario modificar(int idPropietario, Propietario propietarioNuevo) {
        var posicion=this.buscarPosicion(this.buscarPorId(idPropietario));
        this.listar().get(posicion).setNombrePropietario(propietarioNuevo.getNombrePropietario());
        this.listar().get(posicion).setFechaNacPropietario(propietarioNuevo.getFechaNacPropietario());
        this.listar().get(posicion).setNumeroVehiculosPropietario(propietarioNuevo.getNumeroVehiculosPropietario());
        this.listar().get(posicion).setTipoLicenciaPropietario(propietarioNuevo.getTipoLicenciaPropietario());
        return propietarioNuevo;
    }

    @Override
    public Propietario eliminar(int idPropietario) {
        Propietario propietario=this.buscarPorId(idPropietario);
        var posicion=this.buscarPosicion(propietario);
        this.listar().remove(posicion);
        return propietario;
    }

    @Override
    public Propietario buscarPorId(int idPropietario) {
        Propietario propietario=null;
        for(var i:this.propietarioList){
            if(idPropietario==i.getIdPropietario()){
                propietario=i;
                break;
            }
        }
        return propietario;
    }


    @Override
    public int buscarPosicion(Propietario propietario) {
        int posicion=-1;
        for(var p:this.propietarioList){
            posicion++;
            if(p.getIdPropietario()==propietario.getIdPropietario()){
                break;
            }
        }
        return posicion;
    }
}
