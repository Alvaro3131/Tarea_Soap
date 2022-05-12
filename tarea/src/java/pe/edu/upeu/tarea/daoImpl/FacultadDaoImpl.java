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
import pe.edu.upeu.tarea.model.Facultad;
import pe.edu.upeu.tarea.dao.FacultadDao;


/**
 *
 * @author alvar
 */
public class FacultadDaoImpl implements FacultadDao {
private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Facultad rol) {
        String SQL = "INSERT INTO facultad(nombre) VALUES(?)";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, rol.getNombre());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int update(Facultad rol) {
        String SQL = "UPDATE facultad SET nombre=? WHERE idfacultad=?";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, rol.getNombre());
            ps.setInt(2, rol.getIdfacultad());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
      String SQL = "DELETE FROM facultad WHERE idfacultad=?";
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
    public Facultad read(int id) {
        String SQL = "SELECT * FROM facultad WHERE idfacultad=?";
        Facultad rol = new Facultad();
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                rol.setIdfacultad(rs.getInt("idfacultad"));
                rol.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return rol;
    }

    @Override
    public List<Facultad> readAll() {
        String SQL = "SELECT *FROM facultad";
        List<Facultad> lista = new ArrayList<>();
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Facultad rol = new Facultad();
                rol.setIdfacultad(rs.getInt("idfacultad"));
                rol.setNombre(rs.getString("nombre"));
                lista.add(rol);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return lista;
    }
}
