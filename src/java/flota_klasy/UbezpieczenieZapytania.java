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

public class UbezpieczenieZapytania {
    
    public List<Ubezpieczenie> getUbezpieczeniaList(){
        Connection c = null;
        String sql;
        List <Ubezpieczenie> listaUbezpieczen = new ArrayList<Ubezpieczenie>();
        Statement stmt = null;
        
        sql ="select * from ubezpieczenie where ubezpieczenie.id_samochodu is null";
        
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:7886/","postgres","ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                Ubezpieczenie ubezpieczenie = new Ubezpieczenie();
                ubezpieczenie.setId_ubezpieczenia(rs.getLong("id_ubezpieczenia"));
                ubezpieczenie.setId_samochodu(rs.getInt("id_samochodu"));
                ubezpieczenie.setData_rozpoczecia(rs.getDate("data_rozpoczecia"));
                ubezpieczenie.setData_zakonczenia(rs.getDate("data_zakonczenia"));
                ubezpieczenie.setData_zawarcia(rs.getDate("data_zawarcia"));
                ubezpieczenie.setUbezpieczyciel(rs.getString("ubezpieczyciel"));
                ubezpieczenie.setSkladka(rs.getFloat("skladka"));
                ubezpieczenie.setId_operator_zawierajacy(rs.getInt("id_operator_zawierajacy"));
                ubezpieczenie.setNotatka(rs.getString("notatka"));
                ubezpieczenie.setNumer_polisy(rs.getString("numer_polisy"));
                ubezpieczenie.setNazwa_sprzedawcy(rs.getString("nazwa_sprzedawcy"));
                ubezpieczenie.setKontakt(rs.getString("kontakt"));
                listaUbezpieczen.add(ubezpieczenie);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);
        }
       
        try {
            c.commit();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaUbezpieczen;
    }
    
}
