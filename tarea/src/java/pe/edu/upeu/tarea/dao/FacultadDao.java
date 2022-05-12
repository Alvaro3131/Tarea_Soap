/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.tarea.dao;

import java.util.List;
import pe.edu.upeu.tarea.model.Facultad;


/**
 *
 * @author alvar
 */
public interface FacultadDao {
    int create(Facultad rol);
    int update(Facultad rol);
    int delete(int id);
    Facultad read(int id);
    List<Facultad> readAll();
    
}
