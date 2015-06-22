/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author M
 */
@ManagedBean
@SessionScoped
public class DodajSamochod {

    private String dodajmodelSamochodu;
    private String dodajstatusSamochodu;
    private String dodajnrrejSamochodu;
    private String dodajlokalizacjaSamochodu;
    private String dodajpracownikSamochodu;
    private String dodajnazwaSamochodu;
    private String dodajvinSamochodu;
    private String dodajoznaczenieproducentaSamochodu;
    private String dodajmarkaSamochodu;
    private String dodajoponystatusSamochodu;

    private String dodajpaliwoSamochodu;
    private String dodajlokalizacjaStalaSamochodu;

    private String dodajrodzajSamochodu;
    private String dodajkartaParkingowa;
    private String dodajkartaPaliwowa;
    private String dodajprzebiegSamochodu; //dla tabeli kilometry
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
    
    private boolean nazwaSamochoduBlad=false;

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

    public String wywietldodajSamochod() {
        return "dodajSamochod";
    }

    public boolean isNazwaSamochoduBlad() {
        return nazwaSamochoduBlad;
    }

    public void setNazwaSamochoduBlad(boolean nazwaSamochoduBlad) {
        this.nazwaSamochoduBlad = nazwaSamochoduBlad;
    }
    
    public void dodajSamochod() {
        System.out.println("adasda");
        System.out.println("Nowa nazwa samochodu "+WeryfikacjaDanych.czyUnikalny("nazwa", "samochod", getDodajnazwaSamochodu()));
        isCzyWyswietlicNazweSamochoduBlad(WeryfikacjaDanych.czyUnikalny("nazwa", "samochod", getDodajnazwaSamochodu()));

    }

    public String isCzyWyswietlicNazweSamochoduBlad(boolean zmienna) {
        
        System.out.println(nazwaSamochoduBlad);
        setNazwaSamochoduBlad(!zmienna);
        System.out.println(nazwaSamochoduBlad);
        return "dodajSamochod";
    }

    public Samochod zczytajDane() {
        Samochod dodawanySamochod = new Samochod();
        dodawanySamochod.setId_samochod(1);
        dodawanySamochod.setNazwa(dodajnazwaSamochodu);
        dodawanySamochod.setModel(dodajmodelSamochodu);
        dodawanySamochod.setPaliwo(dodajpaliwoSamochodu);
        dodawanySamochod.setNr_vin(dodajvinSamochodu);
        dodawanySamochod.setId_opony_satus(dodajoponystatusSamochodu);
        dodawanySamochod.setId_status(dodajstatusSamochodu);
        dodawanySamochod.setNr_rej(dodajnrrejSamochodu);
        dodawanySamochod.setIdlokalizacja(dodajlokalizacjaSamochodu);
        dodawanySamochod.setPracownik_uzywajacy(dodajpracownikSamochodu);
        dodawanySamochod.setOznaczenie_producenta(dodajoznaczenieproducentaSamochodu);
        dodawanySamochod.setMarka(dodajmarkaSamochodu);
        dodawanySamochod.setPaliwo(dodajpaliwoSamochodu);
        dodawanySamochod.setLokalizacja(dodajlokalizacjaStalaSamochodu);
        dodawanySamochod.setId_rodzaj_pojazdu(dodajrodzajSamochodu);
        dodawanySamochod.setId_karta_parkingowa(dodajkartaParkingowa);
        dodawanySamochod.setId_karta_paliwowa(dodajkartaPaliwowa);
        dodawanySamochod.setPrzebieg_calkowity(dodajprzebiegSamochodu); //dla tabeli kilometry
        dodawanySamochod.setId_ubezpieczenia(dodajubezpieczenieSamochodu);
        dodawanySamochod.setPoj_silnika(dodajpojemnoscSilnika);
        dodawanySamochod.setRok_produkcji(dodajrokProdukcji);
        dodawanySamochod.setData_przyjecia(dodajdataPrzyjecia);
        dodawanySamochod.setData_pierwszej_rejestracji(dodajdataPierwszejRejestracji);
        dodawanySamochod.setId_gps(dodajIdGps);
        dodawanySamochod.setKilometry(dodajKilometry);
        dodawanySamochod.setKolor(dodajKolor);
        dodawanySamochod.setWersja(dodajWersja);
        dodawanySamochod.setId_typ_samochodu(dodajIdTypSamochodu);
        dodawanySamochod.setVat(dodajVat);
        dodawanySamochod.setId_grupa_limit(dodajIdGrupaLimit);
        dodawanySamochod.setNr_umowy_leasingu(dodajNrUmowyLeasingu);
        dodawanySamochod.setNr_umowy_serwis(dodajNrUmowySerwis);
        dodawanySamochod.setMpk(dodajMpk);
        dodawanySamochod.setPrv_umowa(dodajPrvUmowa);
        dodawanySamochod.setUmowa_z_dnia(dodajUmowaZDnia);
        dodawanySamochod.setMiejsce_parkingowe(dodajMiejsceParkingowe);
        dodawanySamochod.setRozmiar_opon(dodajRozmiarOpon);
        dodawanySamochod.setId_lokalizacja_stala(dodajlokalizacjaStalaSamochodu);

        return dodawanySamochod;
    }

}
