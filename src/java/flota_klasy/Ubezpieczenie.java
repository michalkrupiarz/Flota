/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author michal.krupiarz
 */
public class Ubezpieczenie implements Cloneable{
    private long id_ubezpieczenia;
    private String id_samochodu;
    private String data_rozpoczecia;
    private String data_zakonczenia;
    private String data_zawarcia;
    private String ubezpieczyciel;
    private String skladka;
    private String id_operator_zawierajacy;
    private String notatka;
    private String numer_polisy;
    private String nazwa_sprzedawcy;
    private String kontakt;
    
    public Ubezpieczenie(){
        
    }

    public Ubezpieczenie(long id_ubezpieczenia, String id_samochodu, String data_rozpoczecia, String data_zakonczenia, String data_zawarcia, String ubezpieczyciel, String skladka, String id_operator_zawierajacy, String notatka, String numer_polisy, String nazwa_sprzedawcy, String kontakt) {
        this.id_ubezpieczenia = id_ubezpieczenia;
        this.id_samochodu = id_samochodu;
        this.data_rozpoczecia = data_rozpoczecia;
        this.data_zakonczenia = data_zakonczenia;
        this.data_zawarcia = data_zawarcia;
        this.ubezpieczyciel = ubezpieczyciel;
        this.skladka = skladka;
        this.id_operator_zawierajacy = id_operator_zawierajacy;
        this.notatka = notatka;
        this.numer_polisy = numer_polisy;
        this.nazwa_sprzedawcy = nazwa_sprzedawcy;
        this.kontakt = kontakt;
    }

    public long getId_ubezpieczenia() {
        return id_ubezpieczenia;
    }

    public void setId_ubezpieczenia(long id_ubezpieczenia) {
        this.id_ubezpieczenia = id_ubezpieczenia;
    }

    public String getId_samochodu() {
        return id_samochodu;
    }

    public void setId_samochodu(String id_samochodu) {
        this.id_samochodu = id_samochodu;
    }

    public String getData_rozpoczecia() {
        return data_rozpoczecia;
    }

    public void setData_rozpoczecia(String data_rozpoczecia) {
        this.data_rozpoczecia = data_rozpoczecia;
    }

    public String getData_zakonczenia() {
        return data_zakonczenia;
    }

    public void setData_zakonczenia(String data_zakonczenia) {
        this.data_zakonczenia = data_zakonczenia;
    }

    public String getData_zawarcia() {
        return data_zawarcia;
    }

    public void setData_zawarcia(String data_zawarcia) {
        this.data_zawarcia = data_zawarcia;
    }

    public String getUbezpieczyciel() {
        return ubezpieczyciel;
    }

    public void setUbezpieczyciel(String ubezpieczyciel) {
        this.ubezpieczyciel = ubezpieczyciel;
    }

    public String getSkladka() {
        return skladka;
    }

    public void setSkladka(String skladka) {
        this.skladka = skladka;
    }

    public String getId_operator_zawierajacy() {
        return id_operator_zawierajacy;
    }

    public void setId_operator_zawierajacy(String id_operator_zawierajacy) {
        this.id_operator_zawierajacy = id_operator_zawierajacy;
    }

    public String getNotatka() {
        return notatka;
    }

    public void setNotatka(String notatka) {
        this.notatka = notatka;
    }

    public String getNumer_polisy() {
        return numer_polisy;
    }

    public void setNumer_polisy(String numer_polisy) {
        this.numer_polisy = numer_polisy;
    }

    public String getNazwa_sprzedawcy() {
        return nazwa_sprzedawcy;
    }

    public void setNazwa_sprzedawcy(String nazwa_sprzedawcy) {
        this.nazwa_sprzedawcy = nazwa_sprzedawcy;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }
    @Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
    
}
