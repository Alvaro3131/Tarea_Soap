/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.tarea.ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.tarea.dao.EscuelaDao;
import pe.edu.upeu.tarea.daoImpl.EscuelaDaoImpl;
import pe.edu.upeu.tarea.model.Escuela;

/**
 *
 * @author alvar
 */
@WebService(serviceName = "EscuWebService")
public class EscuWebService {
EscuelaDao escuDao=new EscuelaDaoImpl();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertar")
    public int insertar(@WebParam(name = "nombre") String nombre,@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return escuDao.create(new Escuela(0,nombre,id));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editar")
    public int editar(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre,@WebParam(name = "idfacultad") int idfa ) {
        //TODO write your implementation code here:
        return escuDao.update(new Escuela(id,nombre,idfa));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
       return escuDao.delete(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "read")
    public Escuela read(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return escuDao.read(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "readall")
    public List<Escuela> readall() {
        //TODO write your implementation code here:
        return escuDao.readAll();
    }
}
