/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author M
 */
@ManagedBean
@SessionScoped
public class GrupaLimitZapytania {

    public List<GrupaLimit> getGrupaLimitZapytaniaList() {
        Connection c = null;
        List<GrupaLimit> listaGrupaLimit = new ArrayList<GrupaLimit>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c=DriverManager.getConnection("jdbc:postgresql://localhost:7886/","postgres","ponczus21");
            c.setAutoCommit(false);
            
            stmt = c.createStatement();
            String sql = "select * from grupa_limit";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                GrupaLimit grupaLimit = new GrupaLimit();
                grupaLimit.setId_grupa_limit(rs.getInt("id_grupa_limit"));
                grupaLimit.setNazwa(rs.getString("nazwa"));
                listaGrupaLimit.add(grupaLimit);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        
        try {
            c.commit();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaGrupaLimit;
    }

}
