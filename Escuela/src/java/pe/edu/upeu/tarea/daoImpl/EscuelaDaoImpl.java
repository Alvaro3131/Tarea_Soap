/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.tarea.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.tarea.config.Conexion;
import pe.edu.upeu.tarea.dao.EscuelaDao;

import pe.edu.upeu.tarea.model.Escuela;


/**
 *
 * @author alvar
 */
public class EscuelaDaoImpl implements EscuelaDao {
private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Escuela escuela) {
        String SQL = "INSERT INTO escuela(nombre, idfacultad) VALUES(?, ?);";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, escuela.getNombre());
             ps.setInt(2, escuela.getIdfacultad());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int update(Escuela escuela) {
        String SQL = "UPDATE escuela SET nombre=? , idfacultad=? WHERE idescuela=?";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, escuela.getNombre());
            ps.setInt(2, escuela.getIdfacultad());
            ps.setInt(3, escuela.getIdfacultad());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
      String SQL = "DELETE FROM escuela WHERE idescuela=?";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;  
    }

    @Override
    public Escuela read(int id) {
        String SQL = "SELECT * FROM escuela WHERE idescuela=?";
        Escuela rol = new Escuela();
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                rol.setIdescuela(rs.getInt("idescuela"));
                rol.setNombre(rs.getString("nombre"));
                rol.setIdfacultad(rs.getInt("idfacultad"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return rol;
    }

    @Override
    public List<Escuela> readAll() {
        String SQL = "SELECT *FROM escuela";
        List<Escuela> lista = new ArrayList<>();
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Escuela rol = new Escuela();
                rol.setIdescuela(rs.getInt("idescuela"));
                rol.setNombre(rs.getString("nombre"));
                rol.setIdfacultad(rs.getInt("idfacultad"));
                lista.add(rol);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return lista;
    }
}
