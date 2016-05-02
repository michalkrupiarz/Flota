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
public class DzialZapytania {

    public List<Dzial> getDzialList() { 
        Connection c = null;
        List<Dzial> listaDzial = new ArrayList<Dzial>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            
            stmt = c.createStatement();
            String sql = "Select * from dzial";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Dzial lok = new Dzial();
                lok.setId_dzial(rs.getLong("id_dzial"));
                lok.setNazwa_dzial(rs.getString("nazwa_dzial"));
                listaDzial.add(lok);

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
        return listaDzial;

    }

}
