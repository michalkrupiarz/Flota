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
 * @author Michal
 */
@ManagedBean
@SessionScoped
public class KartaParkingowaStatusyZapytania {
    public List<KartaParkingowaStatusy> getListaKartaParkingowaStatusy(){
        Connection c=null;
        List <KartaParkingowaStatusy> listKartaParkingowaStatusyow = new ArrayList<KartaParkingowaStatusy>();
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
           
            stmt = c.createStatement();
            String sql = "Select * from karta_parkingowa_statusy";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KartaParkingowaStatusy lok = new KartaParkingowaStatusy();
                lok.setId(rs.getLong("id_karta_parkingowa_statusy"));
                lok.setStatus(rs.getString("status_karta_parkingowa_statusy"));
                lok.setId_import(rs.getLong("id_importu"));
                listKartaParkingowaStatusyow.add(lok);

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
        
        return listKartaParkingowaStatusyow;
    }
    
}
