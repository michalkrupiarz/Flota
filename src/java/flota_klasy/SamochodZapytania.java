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
    public static boolean sprawdzUnikalnoscDanych(String nazwaPola, String nazwaTabeli, String zmienna) {

        Connection c = null;
        String sql;
        Statement stmt = null;
        ResultSet rs = null;
        String wynikzbazy = "a";

        sql = "select " + nazwaPola + " as wynik from " + nazwaTabeli + " where " + nazwaPola + " ilike ('" + zmienna + "')";
        System.out.println(sql);

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

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

        try {
            c.commit();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("wynik wyszukiwania w bazie " + wynikzbazy.equalsIgnoreCase(zmienna));
        return !wynikzbazy.equalsIgnoreCase(zmienna);
    }

    public static String dodajSamochod(Samochod samochod) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO samochod(\n"
                    + "             nazwa, marka, model, oznaczenie_producenta, paliwo, \n"
                    + "            poj_silnika, rok_produkcji, data_przyjecia, data_pierwszej_rejestracji, \n"
                    + "            id_gps, nr_rej, nr_vin, id_status, id_opony_status, id_lokalizacja, \n"
                    + "            id_lokalizacja_stala, id_rodzaj_pojazdu, id_karta_parkingowa, \n"
                    + "            id_karta_paliwowa, kilometry, przebieg_calkowity, \n"
                    + "            kolor, wersja, id_typ_samochod, vat, id_grupa_limit, nr_umowy_leasingu, \n"
                    + "            nr_umowy_serwis, mpk, prv_umowa, umowa_z_dnia, miejsce_parkingowe, \n"
                    + "            rozmiar_opon)\n"
                    + "    VALUES (" + samochod.getNazwa() + ", \n"
                    + "            " + samochod.getMarka() + ", \n"
                    + "            " + samochod.getModel() + ", \n"
                    + "            " + samochod.getOznaczenie_producenta() + " ," + samochod.getPaliwo() + ", \n"
                    + "            " + samochod.getPoj_silnika() + "," + samochod.getRok_produkcji() + ", \n"
                    + "            " + samochod.getData_przyjecia() + "," + samochod.getData_pierwszej_rejestracji() + ",select gps.id_gps from gps where gps.gps_numer ilike ('" + samochod.getId_gps() + "') , \n"
                    + "            " + samochod.getNr_rej() + ", \n"
                    + "            " + samochod.getNr_vin() + ", select samochod_status.id_samochod_status from samochod_status where samochod_status.nazwa_samochod_status ilike('" + samochod.getId_status() + "'), \n"
                    + "            select opony_status.id_opony_status from opony_status where opony_status.nazwa_opony_status ilike('" + samochod.getId_opony_satus() + "') , \n"
                    + "            select lokalizacja.id_lokalizacja from lokalizacja where lokalizacja.nazwa_lokalizacja ilike('" + samochod.getIdlokalizacja() + "'), \n"
                    + "            select lokalizacja.id_lokalizacja from lokalizacja where lokalizacja.nazwa_lokalizacja ilike('" + samochod.getId_lokalizacja_stala() + "'), \n"
                    + "            select rodzaj_pojazdu.id_rodzaj_pojazdu from rodzaj_pojazdu where rodzaj_pojazdu.nazwa ilike ('" + samochod.getId_rodzaj_pojazdu() + "'), \n"
                    + "            select karta_parkingowa.id_karta_parkingowa from karta_parkingowa where karta_parkingowa.numer_karta_parkingowa ('" + samochod.getId_karta_parkingowa() + "'), \n"
                    + "            select karta_paliwowa.id_karta_paliwowa from karta_paliwowa where karta_paliwowa.numer_karta_paliwowa ('" + samochod.getId_karta_paliwowa() + "'), \n"
                    + "            " + samochod.getKilometry() + ", " + samochod.getPrzebieg_calkowity() + ", " + samochod.getKolor() + ", " + samochod.getWersja() + ", \n"
                    + "            select typ_samochod.id_typ_samochod from typ_samochod where typ_samochod.nazwa ilike('" + samochod.getId_typ_samochodu() + "'), \n"
                    + "            " + samochod.getVat() + ",\n"
                    + "            select grupa_limit.id_grupa_limit from grupa_limit where grupa_limit.nazwa ilike ('" + samochod.getId_grupa_limit() + "'),\n"
                    + "            "+samochod.getNr_umowy_leasingu()+", "+samochod.getNr_umowy_serwis()+", "+samochod.getMpk()+", \n"
                    + "            "+samochod.getPrv_umowa()+", "+samochod.getUmowa_z_dnia()+", "+samochod.getMiejsce_parkingowe()+","+samochod.getMiejsce_parkingowe();
                    
                    System.out.println(sql);
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

        return "dodano";
    }
    //piszemyt wlasnie
    //pirzesmzy wlasnie
}
