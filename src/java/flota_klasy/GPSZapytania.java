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
 * @author michal.krupiarz
 */
@ManagedBean
@SessionScoped
public class GPSZapytania {

    public List<GPS> getGPSList() {
        Connection c = null;
        List<GPS> listaGPS = new ArrayList<GPS>();
        Statement stmt = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            
            stmt = c.createStatement();
            String sql = "Select * from gps";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                GPS lok = new GPS();
                lok.setId_gps(rs.getInt("id_gps"));
                lok.setGps_numer(rs.getString("gps_numer"));
                listaGPS.add(lok);
                System.out.println(lok.getGps_numer());
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
        return listaGPS;
      
   }
    
}
