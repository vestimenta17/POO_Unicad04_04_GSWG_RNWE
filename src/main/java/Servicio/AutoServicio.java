/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Modelo.Auto;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
        try {
            this.almacenarEnArchivo(auto, "C:/carpeta1/archivoAuto.dat");
        } catch (Exception ex) {
            throw new RuntimeException("Auto No se puede almacenar en archivo"+ex.getMessage());
        }
        return auto;
    }

    public List<Auto> listar() {
        try {
            this.autoList=this.recuperarDeArchivo("C:/carpeta1/archivoAuto.dat");
        } catch (Exception ex) {
            throw new RuntimeException("No se puede recuperar de archivo"+ex.getMessage());
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
        try {
            this.almacenarEnArchivo(auto, "C:/carpeta1/archivoAuto.dat");
        } catch (Exception ex) {
            throw new RuntimeException("Auto No se puede almacenar en archivo"+ex.getMessage());
        }
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
    public boolean almacenarEnArchivo(Auto auto, String rutaArchivo) throws Exception{
        var retorno = false;
        DataOutputStream salida=null;
        try{
            salida = new DataOutputStream( new FileOutputStream(rutaArchivo,true) );
            salida.writeInt(auto.getCodigo());
            salida.writeUTF(auto.getPlaca());
            salida.writeUTF(auto.getMarca());
            salida.writeInt(auto.getPrecio());
            salida.writeInt(auto.getKilometraje());
            salida.writeUTF(auto.getModelo());
            salida.close();
            retorno=true;
        }catch(IOException e)
        {
            salida.close();
        }
        return retorno;
    }


    @Override
    public List<Auto> recuperarDeArchivo(String rutaArchivo) throws Exception {
        var autoList = new ArrayList<Auto>();
        DataInputStream entrada=null;
        try{
            entrada = new DataInputStream(new FileInputStream(rutaArchivo));
            while(true){
                var codigo=entrada.readInt();
                var placa=entrada.readUTF();
                var marca=entrada.readUTF();
                var precio=entrada.readInt();
                var kilometraje=entrada.readInt();
                var modelo=entrada.readUTF();
                var auto = new Auto(codigo,placa,marca,precio,kilometraje,modelo);
                autoList.add(auto);
            }
        }catch(IOException e){
            entrada.close();
        }
        return autoList;
    }
}

