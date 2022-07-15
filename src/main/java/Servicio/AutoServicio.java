/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Modelo.Auto;
import java.util.ArrayList;
import java.util.List;

public class AutoServicio implements IAutoServicio {
    private static List<Auto> autoList = new ArrayList<>();
     
    @Override
    public Auto crear(Auto auto) {
        var autoBuscado=this.buscarPorCodigo(auto.getCodigo());
        if(autoBuscado==null){
            this.autoList.add(auto);
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado a la placa: "+autoBuscado.getPlaca());
        }
        return auto;
    }

     @Override
    public List<Auto> listar() {
        return this.autoList;
    }
    @Override
    public Auto buscarPorCodigo(int codigo) {
        Auto auto=null;
        for(var c:this.autoList){
            if(codigo==c.getCodigo()){
                auto=c;
                break;
            }
        }
        return auto;
    }
    
    @Override
    public Auto modificar(int codigo, Auto autoNuevo) {
        var posicion=this.buscarPosicion(this.buscarPorCodigo(codigo));
        this.listar().get(posicion).setPlaca(autoNuevo.getPlaca());
        this.listar().get(posicion).setMarca(autoNuevo.getMarca());
        this.listar().get(posicion).setPrecio(autoNuevo.getPrecio());
        this.listar().get(posicion).setKilometraje(autoNuevo.getKilometraje());
        this.listar().get(posicion).setModelo(autoNuevo.getModelo());
        return autoNuevo;
    }

    @Override
    public Auto eliminar(int codigo) {
        Auto auto=this.buscarPorCodigo(codigo);
        var posicion=this.buscarPosicion(auto);
        this.listar().remove(posicion);
        return auto;
    }

    @Override
    public int buscarPosicion(Auto auto) {
        int posicion=-1;
        for(var c:this.autoList){
            posicion++;
            if(c.getCodigo()==c.getCodigo()){
                break;
            }
        }
        return posicion;
    }
}
