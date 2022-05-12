/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.tarea.dao;

import java.util.List;
import pe.edu.upeu.tarea.model.Escuela;



/**
 *
 * @author alvar
 */
public interface EscuelaDao {
    int create(Escuela escuela);
    int update(Escuela escuela);
    int delete(int id);
    Escuela read(int id);
    List<Escuela> readAll();
    
}
