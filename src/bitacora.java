import java.sql.*;

/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ialek
 */
public class bitacora {
    
    static String todos = "SELECT * FROM bitacora ORDER BY folio DESC";
    
    String folio, tiempo, tipo, observaciones, infantes, responsables, educadores;

    public bitacora(String folio, String tiempo, String tipo, String observaciones, String infantes, String responsables, String educadores) {
        this.folio = folio;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.observaciones = observaciones;
        this.infantes = infantes;
        this.responsables = responsables;
        this.educadores = educadores;
    }

   
    bitacora() {
        
    }

    bitacora(Object object, String text, String toString, String text0, String toString0, String toString1, String toString2, String toString3) {
        
    }
    
    public int insertar(Connection con){
        int resultado = 0;
        try {
            String sql = "INSERT INTO bitacora VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, tiempo);
            ps.setString(3, tipo);
            ps.setString(4, observaciones);
            ps.setString(5, infantes);
            ps.setString(6, responsables);
            ps.setString(7, educadores);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
    
    public int borrar(Connection con){
        int resultado = 0;
        try {
            String sql = "DELETE FROM bitacora WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
        
    }
    
    public int actualizar(Connection con){
      int resultado = 0;
        try {
            String sql = "UPDATE bitacora SET tiempo = ?, tipo = ?, observaciones = ?, infantes_curp = ?, responsables_curpr = ?, educadores_curpe = ? WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tiempo);
            ps.setString(2, tipo);
            ps.setString(3, observaciones);
            ps.setString(4, infantes);
            ps.setString(5, responsables);
            ps.setString(6, educadores);
            ps.setString(7, folio); // El folio va al final por ser la condición WHERE
            return ps.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
}
