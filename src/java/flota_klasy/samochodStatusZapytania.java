/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

/**
 *
 * @author michal.krupiarz
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class samochodStatusZapytania {
    public List<samochodStatus> getSamochodStatusList(){
        Connection c=null;
        List <samochodStatus> lista = new ArrayList<samochodStatus>();
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "Select * from samochod_status";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                samochodStatus lok = new samochodStatus();
                lok.setId_samochod_status(rs.getInt("id_samochod_status"));
                lok.setNazwa_samochod_status(rs.getString("nazwa_samochod_status"));
                lista.add(lok);

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
        
        return lista;
    }
}
