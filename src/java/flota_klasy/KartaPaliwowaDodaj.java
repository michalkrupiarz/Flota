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
public class KartaPaliwowaDodaj {
    private boolean numerKartyBlad = false;
    private KartaPaliwowa dodawanaKarta = new KartaPaliwowa();

    public KartaPaliwowa getDodawanaKarta() {
        return dodawanaKarta;
    }

    public void setDodawanaKarta(KartaPaliwowa dodawanaKarta) {
        this.dodawanaKarta = dodawanaKarta;
    }

    public boolean isNumerKartyBlad() {
        return numerKartyBlad;
    }

    public void setNumerKartyBlad(boolean numerKartyBlad) {
        this.numerKartyBlad = numerKartyBlad;
    }
    
    public String dodajKartePaliwowa(){
        KartaPaliwowaZapytania.dodajKartePaliwowa(dodawanaKarta);
        return "paliwowaWidok";
    }
    public String wyswietlDodajKartePaliwowa(){
        return "paliwowaDodaj";
    }
    public String dodajKarte(){
        setNumerKartyBlad(!WeryfikacjaDanych.czyUnikalny("numer_karty", "karta_paliwowa",dodawanaKarta.getNumer_Karty()));
        if (!numerKartyBlad){
            KartaPaliwowaZapytania.dodajKartePaliwowa(dodawanaKarta);
            return "paliwowaWidok";
        }
        return "paliwowaDodaj";
    }
}
