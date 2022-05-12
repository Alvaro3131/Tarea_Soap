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
import pe.edu.upeu.tarea.dao.FacultadDao;
import pe.edu.upeu.tarea.daoImpl.FacultadDaoImpl;
import pe.edu.upeu.tarea.model.Facultad;

/**
 *
 * @author alvar
 */
@WebService(serviceName = "FacuWebService")
public class FacuWebService {
    FacultadDao facuDao=new FacultadDaoImpl();
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
    public int insertar(@WebParam(name = "nombre") String nombre) {
        //TODO write your implementation code here:
        return facuDao.create(new Facultad(0,nombre));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editar")
    public int editar(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre) {
        //TODO write your implementation code here:
        return facuDao.update(new Facultad(id,nombre));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
       return facuDao.delete(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "read")
    public Facultad read(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return facuDao.read(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "readall")
    public List<Facultad> readall() {
        //TODO write your implementation code here:
        return facuDao.readAll();
    }
}
