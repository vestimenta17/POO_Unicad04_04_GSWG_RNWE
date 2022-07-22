/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Propietario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            this.almacenarEnArchivo(propietario, "C:/carpeta1/archivoPropietario.obj");
        } catch (Exception ex) {
            throw new RuntimeException("El propietario no se pudo almacenar en el "
                    + "archivo de objetos"+ex.getMessage());
        }
        return propietario;
    }
    
    @Override
    public List<Propietario> listar() {
        try {
            this.propietarioList=this.recuperarDeArchivo("C:/carpeta1/archivoPropietario.obj");
        } catch (Exception ex) {
            Logger.getLogger(PropietarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.propietarioList;
    } 

   @Override
    public Propietario modificar(int idPropietario, Propietario propietarioNuevo) {
        var posicion=this.buscarPosicion(this.buscarPorId(idPropietario));
        this.listar().get(posicion).setNombrePropietario(propietarioNuevo.getNombrePropietario());
        this.listar().get(posicion).setFechaNacPropietario(propietarioNuevo.getFechaNacPropietario());
        this.listar().get(posicion).setNumeroVehiculosPropietario(propietarioNuevo.getNumeroVehiculosPropietario());
        this.listar().get(posicion).setTipoLicenciaPropietario(propietarioNuevo.getTipoLicenciaPropietario());
        try {
            this.almacenarEnArchivo(propietarioNuevo, "C:/carpeta1/archivoPropietario.obj");
        } catch (Exception ex) {
            throw new RuntimeException("El propietario no se pudo almacenar en el "
                    + "archivo de objetos"+ex.getMessage());
        }
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
    @Override
    public boolean almacenarEnArchivo(Propietario propietario, String rutaArchivo) throws Exception{
        ObjectOutputStream salida=null;
        var retorno=false;
        try{
            salida = new ObjectOutputStream(new FileOutputStream(new File(rutaArchivo),true));
            salida.writeObject(propietario);
            salida.close();
            retorno=true;
        }catch(Exception e1){
            System.out.println(e1.toString());
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<Propietario> recuperarDeArchivo(String rutaArchivo) throws Exception {
        var propietarioList = new ArrayList<Propietario>();
        var fis = new FileInputStream(new File(rutaArchivo));
        ObjectInputStream entrada = null;
        try{        
            while(fis.available()>0){
                entrada = new ObjectInputStream(fis);
                Propietario propietario = (Propietario) entrada.readObject();
                propietarioList.add(propietario);
            }
            entrada.close();
        }catch(Exception ex){
            entrada.close();
        }
        return propietarioList;
    }
}
