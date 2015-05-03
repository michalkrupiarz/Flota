/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author M
 */
@ManagedBean
@SessionScoped
public class DodajSamochod {
    private String dodajmodelSamochodu ;
    private String dodajstatusSamochodu ;
    private String dodajnrrejSamochodu ;
    private String dodajlokalizacjaSamochodu ;
    private String dodajpracownikSamochodu ;
    private String dodajnazwaSamochodu ;
    private String dodajvinSamochodu    ;
    private String dodajoznaczenieproducentaSamochodu    ;
    private String dodajmarkaSamochodu    ;
    private String dodajoponystatusSamochodu ;
    
    private String dodajpaliwoSamochodu ;
    private String dodajlokalizacjaStalaSamochodu    ;
    
    private String dodajrodzajSamochodu    ;
    private String dodajkartaParkingowa    ;
    private String dodajkartaPaliwowa    ;
    private String dodajprzebiegSamochodu    ; //dla tabeli kilometry
    private String dodajubezpieczenieSamochodu;
    
    private String dodajpojemnoscSilnika;
    private String dodajrokProdukcji;
    private String dodajdataPrzyjecia;
    private String dodajdataPierwszejRejestracji;
    private String dodajIdGps;
    private String dodajKilometry;
    private String dodajKolor;
    private String dodajWersja;
    private String dodajIdTypSamochodu;
    private String dodajVat;
    private String dodajIdGrupaLimit;
    private String dodajNrUmowyLeasingu;
    private String dodajNrUmowySerwis;
    private String dodajMpk;
    private String dodajPrvUmowa;
    private String dodajUmowaZDnia;
    private String dodajMiejsceParkingowe;
    private String dodajRozmiarOpon;
    
    
      public String getDodajmodelSamochodu() {
        return dodajmodelSamochodu;
    }

    public void setDodajmodelSamochodu(String dodajmodelSamochodu) {
        this.dodajmodelSamochodu = dodajmodelSamochodu;
    }

    public String getDodajstatusSamochodu() {
        return dodajstatusSamochodu;
    }

    public void setDodajstatusSamochodu(String dodajstatusSamochodu) {
        this.dodajstatusSamochodu = dodajstatusSamochodu;
    }

    public String getDodajnrrejSamochodu() {
        return dodajnrrejSamochodu;
    }

    public void setDodajnrrejSamochodu(String dodajnrrejSamochodu) {
        this.dodajnrrejSamochodu = dodajnrrejSamochodu;
    }

    public String getDodajlokalizacjaSamochodu() {
        return dodajlokalizacjaSamochodu;
    }

    public void setDodajlokalizacjaSamochodu(String dodajlokalizacjaSamochodu) {
        this.dodajlokalizacjaSamochodu = dodajlokalizacjaSamochodu;
    }

    public String getDodajpracownikSamochodu() {
        return dodajpracownikSamochodu;
    }

    public void setDodajpracownikSamochodu(String dodajpracownikSamochodu) {
        this.dodajpracownikSamochodu = dodajpracownikSamochodu;
    }

    public String getDodajnazwaSamochodu() {
        return dodajnazwaSamochodu;
    }

    public void setDodajnazwaSamochodu(String dodajnazwaSamochodu) {
        this.dodajnazwaSamochodu = dodajnazwaSamochodu;
    }

    public String getDodajvinSamochodu() {
        return dodajvinSamochodu;
    }

    public void setDodajvinSamochodu(String dodajvinSamochodu) {
        this.dodajvinSamochodu = dodajvinSamochodu;
    }

    public String getDodajoznaczenieproducentaSamochodu() {
        return dodajoznaczenieproducentaSamochodu;
    }

    public void setDodajoznaczenieproducentaSamochodu(String dodajoznaczenieproducentaSamochodu) {
        this.dodajoznaczenieproducentaSamochodu = dodajoznaczenieproducentaSamochodu;
    }

    public String getDodajmarkaSamochodu() {
        return dodajmarkaSamochodu;
    }

    public void setDodajmarkaSamochodu(String dodajmarkaSamochodu) {
        this.dodajmarkaSamochodu = dodajmarkaSamochodu;
    }

    public String getDodajoponystatusSamochodu() {
        return dodajoponystatusSamochodu;
    }

    public void setDodajoponystatusSamochodu(String dodajoponystatusSamochodu) {
        this.dodajoponystatusSamochodu = dodajoponystatusSamochodu;
    }

    public String getDodajpaliwoSamochodu() {
        return dodajpaliwoSamochodu;
    }

    public void setDodajpaliwoSamochodu(String dodajpaliwoSamochodu) {
        this.dodajpaliwoSamochodu = dodajpaliwoSamochodu;
    }

    public String getDodajlokalizacjaStalaSamochodu() {
        return dodajlokalizacjaStalaSamochodu;
    }

    public void setDodajlokalizacjaStalaSamochodu(String dodajlokalizacjaStalaSamochodu) {
        this.dodajlokalizacjaStalaSamochodu = dodajlokalizacjaStalaSamochodu;
    }

    public String getDodajrodzajSamochodu() {
        return dodajrodzajSamochodu;
    }

    public void setDodajrodzajSamochodu(String dodajrodzajSamochodu) {
        this.dodajrodzajSamochodu = dodajrodzajSamochodu;
    }

    public String getDodajkartaParkingowa() {
        return dodajkartaParkingowa;
    }

    public void setDodajkartaParkingowa(String dodajkartaParkingowa) {
        this.dodajkartaParkingowa = dodajkartaParkingowa;
    }

    public String getDodajkartaPaliwowa() {
        return dodajkartaPaliwowa;
    }

    public void setDodajkartaPaliwowa(String dodajkartaPaliwowa) {
        this.dodajkartaPaliwowa = dodajkartaPaliwowa;
    }

    public String getDodajprzebiegSamochodu() {
        return dodajprzebiegSamochodu;
    }

    public void setDodajprzebiegSamochodu(String dodajprzebiegSamochodu) {
        this.dodajprzebiegSamochodu = dodajprzebiegSamochodu;
    }

    public String getDodajubezpieczenieSamochodu() {
        return dodajubezpieczenieSamochodu;
    }

    public void setDodajubezpieczenieSamochodu(String dodajubezpieczenieSamochodu) {
        this.dodajubezpieczenieSamochodu = dodajubezpieczenieSamochodu;
    }

    public String getDodajpojemnoscSilnika() {
        return dodajpojemnoscSilnika;
    }

    public void setDodajpojemnoscSilnika(String dodajpojemnoscSilnika) {
        this.dodajpojemnoscSilnika = dodajpojemnoscSilnika;
    }

    public String getDodajrokProdukcji() {
        return dodajrokProdukcji;
    }

    public void setDodajrokProdukcji(String dodajrokProdukcji) {
        this.dodajrokProdukcji = dodajrokProdukcji;
    }

    public String getDodajdataPrzyjecia() {
        return dodajdataPrzyjecia;
    }

    public void setDodajdataPrzyjecia(String dodajdataPrzyjecia) {
        this.dodajdataPrzyjecia = dodajdataPrzyjecia;
    }

    public String getDodajdataPierwszejRejestracji() {
        return dodajdataPierwszejRejestracji;
    }

    public void setDodajdataPierwszejRejestracji(String dodajdataPierwszejRejestracji) {
        this.dodajdataPierwszejRejestracji = dodajdataPierwszejRejestracji;
    }

    public String getDodajIdGps() {
        return dodajIdGps;
    }

    public void setDodajIdGps(String dodajIdGps) {
        this.dodajIdGps = dodajIdGps;
    }

    public String getDodajKilometry() {
        return dodajKilometry;
    }

    public void setDodajKilometry(String dodajKilometry) {
        this.dodajKilometry = dodajKilometry;
    }

    public String getDodajKolor() {
        return dodajKolor;
    }

    public void setDodajKolor(String dodajKolor) {
        this.dodajKolor = dodajKolor;
    }

    public String getDodajWersja() {
        return dodajWersja;
    }

    public void setDodajWersja(String dodajWersja) {
        this.dodajWersja = dodajWersja;
    }

    public String getDodajIdTypSamochodu() {
        return dodajIdTypSamochodu;
    }

    public void setDodajIdTypSamochodu(String dodajIdTypSamochodu) {
        this.dodajIdTypSamochodu = dodajIdTypSamochodu;
    }

    public String getDodajVat() {
        return dodajVat;
    }

    public void setDodajVat(String dodajVat) {
        this.dodajVat = dodajVat;
    }

    public String getDodajIdGrupaLimit() {
        return dodajIdGrupaLimit;
    }

    public void setDodajIdGrupaLimit(String dodajIdGrupaLimit) {
        this.dodajIdGrupaLimit = dodajIdGrupaLimit;
    }

    public String getDodajNrUmowyLeasingu() {
        return dodajNrUmowyLeasingu;
    }

    public void setDodajNrUmowyLeasingu(String dodajNrUmowyLeasingu) {
        this.dodajNrUmowyLeasingu = dodajNrUmowyLeasingu;
    }

    public String getDodajNrUmowySerwis() {
        return dodajNrUmowySerwis;
    }

    public void setDodajNrUmowySerwis(String dodajNrUmowySerwis) {
        this.dodajNrUmowySerwis = dodajNrUmowySerwis;
    }

    public String getDodajMpk() {
        return dodajMpk;
    }

    public void setDodajMpk(String dodajMpk) {
        this.dodajMpk = dodajMpk;
    }

    public String getDodajPrvUmowa() {
        return dodajPrvUmowa;
    }

    public void setDodajPrvUmowa(String dodajPrvUmowa) {
        this.dodajPrvUmowa = dodajPrvUmowa;
    }

    public String getDodajUmowaZDnia() {
        return dodajUmowaZDnia;
    }

    public void setDodajUmowaZDnia(String dodajUmowaZDnia) {
        this.dodajUmowaZDnia = dodajUmowaZDnia;
    }

    public String getDodajMiejsceParkingowe() {
        return dodajMiejsceParkingowe;
    }

    public void setDodajMiejsceParkingowe(String dodajMiejsceParkingowe) {
        this.dodajMiejsceParkingowe = dodajMiejsceParkingowe;
    }

    public String getDodajRozmiarOpon() {
        return dodajRozmiarOpon;
    }

    public void setDodajRozmiarOpon(String dodajRozmiarOpon) {
        this.dodajRozmiarOpon = dodajRozmiarOpon;
    }
       
    
    
    public String wyswietldodajSamochod(){
        
        return "dodajSamochod";
    }
    
    public void weryfikujDane(){
        
        boolean poprawnynrrej;
        
        //System.out.println("lokalizacja zwykla "+dodajlokalizacjaSamochodu);
        System.out.println("lokalizacja stala "+dodajlokalizacjaStalaSamochodu);
        System.out.println(WeryfikacjaDanych.Paliwo(dodajpaliwoSamochodu));
        poprawnynrrej = WeryfikacjaDanych.sprawdzNrRej(dodajnrrejSamochodu);
        System.out.println(dodajmodelSamochodu);
    }
    
    public void getDodajSamochod(){
        
        
        dodajSamochod(dodajmodelSamochodu,
                dodajstatusSamochodu,
                dodajnrrejSamochodu,
                dodajlokalizacjaSamochodu,
                dodajpracownikSamochodu,
                dodajnazwaSamochodu,
                dodajvinSamochodu,
                dodajoznaczenieproducentaSamochodu,
                dodajmarkaSamochodu,
                dodajoponystatusSamochodu,
                dodajpaliwoSamochodu,
                dodajlokalizacjaStalaSamochodu,
                dodajrodzajSamochodu,
                dodajkartaParkingowa,
                dodajkartaPaliwowa,
                dodajprzebiegSamochodu,
                dodajubezpieczenieSamochodu);
        
        

    }
    
    public String dodajSamochod(String dodajmodelSamochodu,
            String dodajstatusSamochodu,
            String dodajnrrejSamochodu,
            String dodajlokalizacjaSamochodu,
            String dodajpracownikSamochodu,
            String dodajnazwaSamochodu,
            String dodajvinSamochodu,
            String dodajoznaczenieproducentaSamochodu,
            String dodajmarkaSamochodu,
            String dodajoponystatusSamochodu,
            String dodajpaliwoSamochodu,
            String dodajlokalizacjaStalaSamochodu,
            String dodajrodzajSamochodu,
            String dodajkartaParkingowa,
            String dodajkartaPaliwowa,
            String dodajprzebiegSamochodu,
            String dodajubezpieczenieSamochodu
    ) {
        Connection c = null;
        Statement stmt = null;
        System.out.println("taka wartosc paliwa "+dodajpaliwoSamochodu);
        System.out.println("nazwa "+dodajnazwaSamochodu);
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

        return "aaa";
    }
    
   
}
