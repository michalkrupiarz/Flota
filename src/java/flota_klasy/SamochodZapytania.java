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
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author M
 */
@ManagedBean
@SessionScoped
public class SamochodZapytania {

    ;
    /**  
     * 
     * Creates a new instance of SamochodZapytania
     */
    public static String sprawdzUnikalnoscDanych(String nazwaPola, String nazwaTabeli, String zmienna) {

        String sprawdz;
        Connection c = null;
        String sql;
        Statement stmt = null;
        ResultSet rs = null;
        String wynikzbazy = "a";

        sql = "select " + nazwaPola + " as wynik from " + nazwaTabeli + " where " + nazwaPola + " = '" + zmienna + "'";
        System.out.println("zlozone zapytanie weryfikacyjne "+ sql);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");

            stmt = c.createStatement();

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
            wynikzbazy = rs.getString("wynik");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (wynikzbazy.isEmpty()) {
            sprawdz = "tak";
        } else {
            sprawdz = "nie";
        }
        return sprawdz;
    }
    
    
    public static String dodajSamochod(Samochod samochod){
    Connection c = null;
        Statement stmt = null;
       
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            stmt = c.createStatement();
            String sql = "INSERT INTO samochod(\n"
                    + "             nazwa, marka, model, oznaczenie_producenta, paliwo, \n"
                    + "            poj_silnika, nr_rej, nr_vin, id_status, id_opony_status, id_lokalizacja, \n"
                    + "            id_lokalizacja_stala, id_rodzaj_pojazdu, id_karta_parkingowa, \n"
                    + "            id_karta_paliwowa, id_importu, kilometry, pracownik_uzywajacy, \n"
                    + "            id_ubezpieczenia)\n"
                    + "    VALUES ( ?, ?, ?, ?, ?, \n"
                    + "            ?, ?, ?, ?, ?, ?, \n"
                    + "            ?, ?, ?, \n"
                    + "            ?, ?, ?, ?, \n"
                    + "            ?);";
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

       
        
        return "dodano";
    }
    //piszemyt wlasnie
    //pirzesmzy wlasnie
}
