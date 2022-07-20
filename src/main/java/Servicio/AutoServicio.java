/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Modelo.Auto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            this.almacenarEnArchivo(auto, "C:/carpeta1/archivoAuto.obj");
        } catch (Exception ex) {
            throw new RuntimeException("El barco no se pudo almacenar en el "
                    + "archivo de objetos"+ex.getMessage());
        }
        return auto;
    }

     @Override
    public List<Auto> listar() {
        try {
            this.autoList=this.recuperarDeArchivo("C:/carpeta1/archivoAuto.obj");
        } catch (Exception ex) {
            Logger.getLogger(AutoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    @Override
    public boolean almacenarEnArchivo(Auto auto, String rutaArchivo) throws Exception {
        ObjectOutputStream salida=null;
        var retorno=false;
        try{
            salida = new ObjectOutputStream(new FileOutputStream(new File(rutaArchivo),true));
            salida.writeObject(auto);
            salida.close();
            retorno=true;
        }catch(Exception e1){
            System.out.println(e1.toString());
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<Auto> recuperarDeArchivo(String rutaArchivo) throws Exception {
        
        var autoList = new ArrayList<Auto>();
        var fis = new FileInputStream(new File(rutaArchivo));
        ObjectInputStream entrada = null;
        try{        
            while(fis.available()>0){
                entrada = new ObjectInputStream(fis);
                Auto auto = (Auto) entrada.readObject();
                autoList.add(auto);
            }
            entrada.close();
        }catch(Exception ex){
            entrada.close();
        }
        return autoList;
        
    }
}
