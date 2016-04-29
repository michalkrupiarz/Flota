/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Michal
 */
@ManagedBean
@SessionScoped
public class KartaParkingowaDodaj {
     private boolean numerKartyBlad = false;
    private KartaParkingowa dodawanaKarta = new KartaParkingowa();

    public KartaParkingowa getDodawanaKarta() {
        return dodawanaKarta;
    }

    public void setDodawanaKarta(KartaParkingowa dodawanaKarta) {
        this.dodawanaKarta = dodawanaKarta;
    }

    public boolean isNumerKartyBlad() {
        return numerKartyBlad;
    }

    public void setNumerKartyBlad(boolean numerKartyBlad) {
        this.numerKartyBlad = numerKartyBlad;
    }
    
    
    
    public String wyswietlDodajKarteParkingowa(){
        return "parkingowaDodaj";
    }
    public String dodajKarte(){
        setNumerKartyBlad(!WeryfikacjaDanych.czyUnikalny("numer_karta_parkingowa", "karta_parkingowa",dodawanaKarta.getNumer_karta_parkingowa()));
        if (!numerKartyBlad){
            KartaParkingowaZapytania.dodajKarteParkingowa(dodawanaKarta);
            return "parkingowaWidok";
        }
        return "parkingowaDodaj";
    }
}
