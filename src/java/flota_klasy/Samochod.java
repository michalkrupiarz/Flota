/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

/**
 *
 * @author M
 */
public class Samochod {

    private long id_samochod;
    private String nazwa;
    private String marka;
    private String model;
    private String oznaczenie_producenta;
    private String paliwo;

    private String poj_silnika;
    private String rok_produkcji;
    private String data_przyjecia;
    private String data_pierwszej_rejestracji;
    private String id_gps;

    private String nr_rej;
    private String nr_vin;
    private String id_status;
    private String id_opony_satus;
    private String idlokalizacja;
    private String id_lokalizacja_stala;
    private String id_rodzaj_pojazdu;
    private String id_karta_parkingowa;
    private String id_karta_paliwowa;

    private String kilometry;

    private String przebieg_calkowity;

    private String kolor;
    private String wersja;
    private String id_typ_samochodu;
    private String vat;
    private String id_grupa_limit;
    private String nr_umowy_leasingu;
    private String nr_umowy_serwis;
    private String mpk;
    private String prv_umowa;
    private String umowa_z_dnia;
    private String miejsce_parkingowe;
    private String rozmiar_opon;

    private String pracownik_uzywajacy;
    private String id_ubezpieczenia;

    public Samochod() {

    }

    public Samochod(long id_samochod, String nazwa, String marka, String model, String oznaczenie_producenta,
            String paliwo, String nr_rej, String nr_vin, String id_status, String id_opony_status,
            String lokalizacja, String id_lokalizacja_stala, String id_rodzaj_pojazdu, String id_karta_parkingowa,
            String id_karta_paliwowa, String przebieg_calkowity, String pracownik_uzywajacy, String id_ubezpieczenia,
            String poj_silnika,
            String rok_produkcji,
            String data_przyjecia,
            String data_pierwszej_rejestracji,
            String id_gps,
            String kilometry,
            String kolor,
            String wersja,
            String id_typ_samochodu,
            String vat,
            String id_grupa_limit,
            String nr_umowy_leasingu,
            String nr_umowy_serwis,
            String mpk,
            String prv_umowa,
            String umowa_z_dnia,
            String miejsce_parkingowe,
            String rozmiar_opon) {
        this.id_samochod = id_samochod;
        this.nazwa = nazwa;
        this.marka = marka;
        this.model = model;
        this.oznaczenie_producenta = oznaczenie_producenta;
        this.paliwo = paliwo;
        this.nr_rej = nr_rej;
        this.nr_vin = nr_vin;
        this.id_status = id_status;
        this.id_opony_satus = id_opony_status;
        this.idlokalizacja = lokalizacja;
        this.id_lokalizacja_stala = id_lokalizacja_stala;
        this.id_rodzaj_pojazdu = id_rodzaj_pojazdu;
        this.id_karta_parkingowa = id_karta_parkingowa;
        this.id_karta_paliwowa = id_karta_paliwowa;
        this.przebieg_calkowity = przebieg_calkowity;
        this.pracownik_uzywajacy = pracownik_uzywajacy;
        this.id_ubezpieczenia = id_ubezpieczenia;
        this.poj_silnika = poj_silnika;
        this.rok_produkcji = rok_produkcji;
        this.data_przyjecia = data_przyjecia;
        this.data_pierwszej_rejestracji = data_pierwszej_rejestracji;
        this.id_gps = id_gps;
        this.kilometry = kilometry;
        this.kolor = kolor;
        this.wersja = wersja;
        this.id_typ_samochodu = id_typ_samochodu;
        this.vat = vat;
        this.id_grupa_limit = id_grupa_limit;
        this.nr_umowy_leasingu = nr_umowy_leasingu;
        this.nr_umowy_serwis = nr_umowy_serwis;
        this.mpk = mpk;
        this.prv_umowa = prv_umowa;
        this.umowa_z_dnia = umowa_z_dnia;
        this.miejsce_parkingowe = miejsce_parkingowe;
        this.rozmiar_opon = rozmiar_opon;

    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOznaczenie_producenta() {
        return oznaczenie_producenta;
    }

    public void setOznaczenie_producenta(String oznaczenie_producenta) {
        this.oznaczenie_producenta = oznaczenie_producenta;
    }

    public String getPaliwo() {
        return paliwo;
    }

    public void setPaliwo(String paliwo) {
        this.paliwo = paliwo;
    }

    public String getNr_rej() {
        return nr_rej;
    }

    public void setNr_rej(String nr_rej) {
        this.nr_rej = nr_rej;
    }

    public String getNr_vin() {
        return nr_vin;
    }

    public void setNr_vin(String nr_vin) {
        this.nr_vin = nr_vin;
    }

    public String getId_status() {
        return id_status;
    }

    public void setId_status(String id_status) {
        this.id_status = id_status;
    }

    public String getId_opony_satus() {
        return id_opony_satus;
    }

    public void setId_opony_satus(String id_opony_satus) {
        this.id_opony_satus = id_opony_satus;
    }

    public String getId_lokalizacja_stala() {
        return id_lokalizacja_stala;
    }

    public void setId_lokalizacja_stala(String id_lokalizacja_stala) {
        this.id_lokalizacja_stala = id_lokalizacja_stala;
    }

    public String getId_rodzaj_pojazdu() {
        return id_rodzaj_pojazdu;
    }

    public void setId_rodzaj_pojazdu(String id_rodzaj_pojazdu) {
        this.id_rodzaj_pojazdu = id_rodzaj_pojazdu;
    }

    public String getId_karta_parkingowa() {
        return id_karta_parkingowa;
    }

    public void setId_karta_parkingowa(String id_karta_parkingowa) {
        this.id_karta_parkingowa = id_karta_parkingowa;
    }

    public String getId_karta_paliwowa() {
        return id_karta_paliwowa;
    }

    public void setId_karta_paliwowa(String id_karta_paliwowa) {
        this.id_karta_paliwowa = id_karta_paliwowa;
    }

    public String getPrzebieg_calkowity() {
        return przebieg_calkowity;
    }

    public void setPrzebieg_calkowity(String przebieg_calkowity) {
        this.przebieg_calkowity = przebieg_calkowity;
    }

    public String getPracownik_uzywajacy() {
        return pracownik_uzywajacy;
    }

    public void setPracownik_uzywajacy(String pracownik_uzywajacy) {
        this.pracownik_uzywajacy = pracownik_uzywajacy;
    }

    public String getId_ubezpieczenia() {
        return id_ubezpieczenia;
    }

    public void setId_ubezpieczenia(String id_ubezpieczenia) {
        this.id_ubezpieczenia = id_ubezpieczenia;
    }

    public long getId_samochod() {
        return id_samochod;
    }

    public void setId_samochod(long id_samochod) {
        this.id_samochod = id_samochod;

    }

    public String getLokalizacja() {
        return idlokalizacja;
    }

    public void setLokalizacja(String idlokalizacja) {
        this.idlokalizacja = idlokalizacja;
    }

    public String getPoj_silnika() {
        return poj_silnika;
    }

    public void setPoj_silnika(String poj_silnika) {
        this.poj_silnika = poj_silnika;
    }

    public String getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(String rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public String getData_przyjecia() {
        return data_przyjecia;
    }

    public void setData_przyjecia(String data_przyjecia) {
        this.data_przyjecia = data_przyjecia;
    }

    public String getData_pierwszej_rejestracji() {
        return data_pierwszej_rejestracji;
    }

    public void setData_pierwszej_rejestracji(String data_pierwszej_rejestracji) {
        this.data_pierwszej_rejestracji = data_pierwszej_rejestracji;
    }

    public String getId_gps() {
        return id_gps;
    }

    public void setId_gps(String id_gps) {
        this.id_gps = id_gps;
    }

    public String getIdlokalizacja() {
        return idlokalizacja;
    }

    public void setIdlokalizacja(String idlokalizacja) {
        this.idlokalizacja = idlokalizacja;
    }

    public String getKilometry() {
        return kilometry;
    }

    public void setKilometry(String kilometry) {
        this.kilometry = kilometry;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public String getWersja() {
        return wersja;
    }

    public void setWersja(String wersja) {
        this.wersja = wersja;
    }

    public String getId_typ_samochodu() {
        return id_typ_samochodu;
    }

    public void setId_typ_samochodu(String id_typ_samochodu) {
        this.id_typ_samochodu = id_typ_samochodu;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getId_grupa_limit() {
        return id_grupa_limit;
    }

    public void setId_grupa_limit(String id_grupa_limit) {
        this.id_grupa_limit = id_grupa_limit;
    }

    public String getNr_umowy_leasingu() {
        return nr_umowy_leasingu;
    }

    public void setNr_umowy_leasingu(String nr_umowy_leasingu) {
        this.nr_umowy_leasingu = nr_umowy_leasingu;
    }

    public String getNr_umowy_serwis() {
        return nr_umowy_serwis;
    }

    public void setNr_umowy_serwis(String nr_umowy_serwis) {
        this.nr_umowy_serwis = nr_umowy_serwis;
    }

    public String getMpk() {
        return mpk;
    }

    public void setMpk(String mpk) {
        this.mpk = mpk;
    }

    public String getPrv_umowa() {
        return prv_umowa;
    }

    public void setPrv_umowa(String prv_umowa) {
        this.prv_umowa = prv_umowa;
    }

    public String getUmowa_z_dnia() {
        return umowa_z_dnia;
    }

    public void setUmowa_z_dnia(String umowa_z_dnia) {
        this.umowa_z_dnia = umowa_z_dnia;
    }

    public String getMiejsce_parkingowe() {
        return miejsce_parkingowe;
    }

    public void setMiejsce_parkingowe(String miejsce_parkingowe) {
        this.miejsce_parkingowe = miejsce_parkingowe;
    }

    public String getRozmiar_opon() {
        return rozmiar_opon;
    }

    public void setRozmiar_opon(String rozmiar_opon) {
        this.rozmiar_opon = rozmiar_opon;
    }
    
}
