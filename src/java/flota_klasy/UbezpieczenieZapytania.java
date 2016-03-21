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
        System.out.print("weszklo do tworzenia zapytania");
        sql ="select * from ubezpieczenie where ubezpieczenie.id_samochodu is not null";
        
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:7886/","postgres","ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                Ubezpieczenie ubezpieczenie = new Ubezpieczenie();
                ubezpieczenie.setId_ubezpieczenia(rs.getLong("id_ubezpieczenie"));
                ubezpieczenie.setId_samochodu(rs.getString("id_samochodu"));
                ubezpieczenie.setData_rozpoczecia(rs.getString("data_rozpoczecia"));
                ubezpieczenie.setData_zakonczenia(rs.getString("data_zakonczenia"));
                ubezpieczenie.setData_zawarcia(rs.getString("data_zawarcia"));
                ubezpieczenie.setUbezpieczyciel(rs.getString("ubezpieczyciel"));
                ubezpieczenie.setSkladka(rs.getString("skladka"));
                ubezpieczenie.setId_operator_zawierajacy(rs.getString("id_operator_zawierajacy"));
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
    public static void usunUbezpieczenie(Long idSamochodu){
        Connection c = null;
        String sql;
        List <Ubezpieczenie> listaUbezpieczen = new ArrayList<Ubezpieczenie>();
        Statement stmt = null;
        System.out.print("weszklo do tworzenia zapytania");
        sql = "DELETE FROM ubezpieczenie where id_samochodu="+idSamochodu;
        
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:7886/","postgres","ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            
           
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
    }
    
    public static String zapiszWyedytowaneUbezpieczenie(Ubezpieczenie wyedytowaneUbezpieczenie){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE ubezpieczenie"
                    + "     SET  "
                    + "     id_samochodu=(select samochod.id_samochod from samochod where samochod.nazwa ilike('" + wyedytowaneUbezpieczenie.getId_samochodu()+ "')), "
                    + "     data_rozpoczecia='" + wyedytowaneUbezpieczenie.getData_rozpoczecia() + "', "
                    + "     data_zakonczenia='" + wyedytowaneUbezpieczenie.getData_zakonczenia() + "', "
                    + "     data_zawarcia='" + wyedytowaneUbezpieczenie.getData_zawarcia() + "', "
                    + "     ubezpieczyciel='" + wyedytowaneUbezpieczenie.getUbezpieczyciel() + "', "
                    + "     skladka='" + wyedytowaneUbezpieczenie.getSkladka() + "', "
                    + "     id_operator_zawierajacy=(select pracownik.id_pracownik from pracownik where (pracownik.imie ilike ('" + SamochodZapytania.znajdzImie(wyedytowaneUbezpieczenie.getId_operator_zawierajacy()) + "') and pracownik.nazwisko ilike ('" + SamochodZapytania.znajdzNazwisko(wyedytowaneUbezpieczenie.getId_operator_zawierajacy()) + "'))), "
                    + "     notatka='" + wyedytowaneUbezpieczenie.getNotatka() + "', "
                    + "     numer_polisy='" + wyedytowaneUbezpieczenie.getNumer_polisy() + "', "
                    + "     nazwa_sprzedawcy='" + wyedytowaneUbezpieczenie.getNazwa_sprzedawcy()+ "', "
                    + "     kontakt='" + wyedytowaneUbezpieczenie.getKontakt()+ "' "
                    + "     WHERE "
                    + "     id_ubezpieczenie=" + wyedytowaneUbezpieczenie.getId_ubezpieczenia();
            System.out.println("XXX");
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        try {
            c.commit();
            c.close();
            System.out.println("XXX ZAPISANIE WYEDYTOWANEGO POJAZDU POWIODŁO SIE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "zapisano";
    }
    
     
}
