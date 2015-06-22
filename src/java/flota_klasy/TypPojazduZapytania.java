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

public class TypPojazduZapytania {
    public List<TypPojazdu> getTypPojazduList(){
        Connection c=null;
        List <TypPojazdu> listaTypPojazdu = new ArrayList<TypPojazdu>();
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            
            stmt = c.createStatement();
            String sql = "Select * from typ_samochod";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                TypPojazdu lok = new TypPojazdu();
                lok.setId_typ_pojazdu(rs.getInt("id_typ_samochod"));
                lok.setNazwa(rs.getString("nazwa"));
                listaTypPojazdu.add(lok);

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
        
        return listaTypPojazdu;
    }
}
