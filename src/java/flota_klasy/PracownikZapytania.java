/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

/**
 *
 * @author M
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
public class PracownikZapytania {
    public List<Pracownik> getListaPracownik(){
        Connection c=null;
        List <Pracownik> listPracownikow = new ArrayList<Pracownik>();
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
           
            stmt = c.createStatement();
            String sql = "Select * from pracownik";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Pracownik lok = new Pracownik();
                lok.setId_pracownik(rs.getInt("id_pracownik"));
                lok.setLogin(rs.getString("login"));
                lok.setHaslo(rs.getString("haslo"));
                lok.setImie(rs.getString("imie"));
                lok.setNazwisko(rs.getString("nazwisko"));
                lok.setId_stanowisko(rs.getInt("id_stanowisko"));
                lok.setId_dzial(rs.getInt("id_dzial"));
                lok.setId_lokalizacja(rs.getInt("id_lokalizacja"));
                lok.setMail(rs.getString("mail"));
                lok.setTel_stac(rs.getInt("tel_stac"));
                lok.setTel_kom(rs.getInt("tel_kom"));
                lok.setId_import(rs.getInt("id_import"));
                lok.setId_uprawnienia(rs.getInt("id_uprawnienia"));
                lok.setImieNazwisko(lok.getImie()+" "+lok.getNazwisko());
                listPracownikow.add(lok);

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
        
        return listPracownikow;
    }
}
