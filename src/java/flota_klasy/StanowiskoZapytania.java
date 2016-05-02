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
public class StanowiskoZapytania {

    public List<Stanowisko> getStanowiskoList() { 
        Connection c = null;
        List<Stanowisko> listaStanowisko = new ArrayList<Stanowisko>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            
            stmt = c.createStatement();
            String sql = "Select * from stanowisko";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Stanowisko lok = new Stanowisko();
                lok.setId_stanowisko(rs.getLong("id_stanowisko"));
                lok.setNazwa_stanowisko(rs.getString("nazwa_stanowisko"));
                listaStanowisko.add(lok);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        
        try {
            c.commit();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaStanowisko;

    }

}
