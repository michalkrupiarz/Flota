/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michal.krupiarz
 */
public class WypozyczenieZapytania {
    
    public static List listaWypozyczen(){
        Connection c = null;
        String sql;
        List <Wypozyczenie> listaWypozyczen = new ArrayList<Wypozyczenie>();
        Statement stmt = null;
        
        sql ="select tresc_zlecenia as tresc_zlecenia, data_zlecenia as data_zlecenia, data_zakonczenia_zlecenia as data_zakonczenia_zlecenia from wypozyczenie";
        
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:7886/","postgres","ponczus21");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                Wypozyczenie wypozyczenie = new Wypozyczenie();
                wypozyczenie.setTresc_zlecenia(rs.getString("tresc_zlecenia"));
                wypozyczenie.setData_zlecenia(rs.getDate("data_zlecenia"));
                wypozyczenie.setData_zakonczenia_zlecenia(rs.getDate("data_zakonczenia_zlecenia"));
                listaWypozyczen.add(wypozyczenie);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);
        }
       
        
        return listaWypozyczen;
    }
    
}
