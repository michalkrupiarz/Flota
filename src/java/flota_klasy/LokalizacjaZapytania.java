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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author M
 */
@ManagedBean
@SessionScoped
public class LokalizacjaZapytania {
 
     public List<Lokalizacja> getLokalizacjaList() {
        Connection c = null;
        List<Lokalizacja> listaLokalizacji = new ArrayList<Lokalizacja>();
        Statement stmt = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            System.out.println("Opened database successfully lokalizacja");
            stmt = c.createStatement();
            String sql = "Select * from lokalizacja";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Lokalizacja lok = new Lokalizacja();
                lok.setId_lokalizacja(rs.getInt("id_lokalizacja"));
                lok.setNazwa_lokalizacja(rs.getString("nazwa_lokalizacja"));
                listaLokalizacji.add(lok);
                

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return listaLokalizacji;
      
   }
     
   public List<Lokalizacja> getLokalizacjaStalaList() {
        Connection c = null;
        List<Lokalizacja> listaLokalizacjiStalych = new ArrayList<Lokalizacja>();
        Statement stmt = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "Select * from lokalizacja";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Lokalizacja lok = new Lokalizacja();
                lok.setId_lokalizacja(rs.getInt("id_lokalizacja"));
                lok.setNazwa_lokalizacja(rs.getString("nazwa_lokalizacja"));
                listaLokalizacjiStalych.add(lok);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return listaLokalizacjiStalych;
      
   }  
     
     
   public static int iloscLokalizacji(){
       int ilosc=0;   
       
       Connection c = null;
       Statement stmt = null;
       
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "Select max(id_lokalizacja) as ilosc_lok from lokalizacja";
            ResultSet rs = stmt.executeQuery(sql);
            
            ilosc = rs.getInt("ilosc_lok");

            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
       
       return ilosc;
   }
    
   
   
}
