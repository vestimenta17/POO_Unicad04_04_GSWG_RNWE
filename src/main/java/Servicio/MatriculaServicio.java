/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Modelo.Matricula;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


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
            this.almacenarEnArchivo(matricula, "C:/carpeta1/archivoMatricula.dat");
        } catch (Exception ex) {
            throw new RuntimeException("No se puede almacenar en archivo"+ex.getMessage());
        }
        return matricula;
    }

    @Override
    public List<Matricula> listar() {
        try {
            this.matriculaList=this.recuperarDeArchivo("C:/carpeta1/archivoMatricula.dat");
        } catch (Exception ex) {
            throw new RuntimeException("No se puede recuperar de archivo"+ex.getMessage());
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
        var retorno = false;
        ObjectOutputStream salida=null;
        try{
            salida = new ObjectOutputStream( new FileOutputStream(rutaArchivo,true) );
            salida.writeInt(matricula.getNumero());
            salida.writeInt(matricula.getNumeroChasis());
            salida.close();
            retorno=true;
        }catch(IOException e)
        {
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<Matricula> recuperarDeArchivo(String rutaArchivo) throws Exception {
        var matriculaList = new ArrayList<Matricula>();
        ObjectInputStream entrada=null;
        try{
            entrada = new ObjectInputStream(new FileInputStream(rutaArchivo));
            while(true){
                var numero=entrada.readInt();
                var numeroChasis=entrada.readInt();
                var matricula = new Matricula(numero,fechaMatricula,numeroChasis);
                matriculaList.add(matricula);
            }
        }catch(IOException e){
            entrada.close();
        }
        return matriculaList;
    }

}
