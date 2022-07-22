/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Modelo.Matricula;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MatriculaServicio implements IMatriculaServicio {
    private static List<Matricula> matriculaList = new ArrayList<>();
     
    @Override
    public Matricula crear(Matricula matricula) {
        var matriculaBuscado=this.buscarPorCod(matricula.getNumero());
        if(matriculaBuscado==null){
            this.matriculaList.add(matricula);
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado al chasis: "+matriculaBuscado.getNumeroChasis());
        }
        try {
            this.almacenarEnArchivo(matricula, "C:/carpeta1/archivoMatricula.obj");
        } catch (Exception ex) {
            throw new RuntimeException("La matricula no se pudo almacenar en el "
                    + "archivo de objetos"+ex.getMessage());
        }
        return matricula;
    }

    @Override
    public List<Matricula> listar() {
        try {
            this.matriculaList=this.recuperarDeArchivo("C:/carpeta1/archivoMatricula.obj");
        } catch (Exception ex) {
            Logger.getLogger(MatriculaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.matriculaList;
    }
    @Override
    public Matricula modificar(int codigoMatricula,Matricula matriculaNuevo) {
        var posicion=this.buscarPosicion(this.buscarPorCod(codigoMatricula));
        this.listar().get(posicion).setFechaMatricula(matriculaNuevo.getFechaMatricula());
        this.listar().get(posicion).setAuto(matriculaNuevo.getAuto());
        this.listar().get(posicion).setPropietario(matriculaNuevo.getPropietario());
        return matriculaNuevo;
    }

    @Override
    public Matricula eliminar(int codigoMatricula) {
        Matricula matricula=this.buscarPorCod(codigoMatricula);
        var posicion=this.buscarPosicion(matricula);
        this.listar().remove(posicion);
        return matricula;
    }

    @Override
    public Matricula buscarPorCod(int codigoMatricula) {
        Matricula matricula=null;
        for(var m:this.matriculaList){
            if(codigoMatricula==m.getNumero()){
                matricula=m;
                break;
            }
        }
        return matricula;
    }

    @Override
    public int buscarPosicion(Matricula matricula) {
        int posicion=-1;
        for(var m:this.matriculaList){
            posicion++;
            if(m.getNumero()==matricula.getNumero()){
                break;
            }
        }
        return posicion;
    }
    @Override
    public boolean almacenarEnArchivo(Matricula matricula, String rutaArchivo) throws Exception{
        ObjectOutputStream salida=null;
        var retorno=false;
        try{
            salida = new ObjectOutputStream(new FileOutputStream(new File(rutaArchivo),true));
            salida.writeObject(matricula);
            salida.close();
            retorno=true;
        }catch(Exception e1){
            System.out.println(e1.toString());
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<Matricula> recuperarDeArchivo(String rutaArchivo) throws Exception {
        var matriculaList = new ArrayList<Matricula>();
        var fis = new FileInputStream(new File(rutaArchivo));
        ObjectInputStream entrada = null;
        try{        
            while(fis.available()>0){
                entrada = new ObjectInputStream(fis);
                Matricula matricula = (Matricula) entrada.readObject();
                matriculaList.add(matricula);
            }
            entrada.close();
        }catch(Exception ex){
            entrada.close();
        }
        return matriculaList;
    }

}
