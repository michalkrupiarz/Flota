/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.util.Iterator;
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
public class WyswietlSamochod {

    long id;
    List<Lokalizacja> listaLokalizacji;
    List<Samochod> listaSamochodow;
    DataModel listaSamochodowNowa;
    Samochod samochod;

    private Samochod aktualnySamochod;

    private String modelSamochodu = "%";
    private String statusSamochodu = "%";
    private String nrrejSamochodu = "%";
    private String lokalizacjaSamochodu = "%";
    private String pracownikSamochodu = "%";
    private String nazwaSamochodu = "%";
    private String vinSamochodu = "%";
    private String oznaczenieproducentaSamochodu = "%";
    private String markaSamochodu = "%";
    private String oponystatusSamochodu = "%";

    private String paliwoSamochodu = "%";
    private String lokalizacjaStalaSamochodu = "%";

    private String rodzajSamochodu = "%";
    private String kartaParkingowa = "%";
    private String kartaPaliwowa = "%";
    private String przebiegSamochodu = "%";
    private String ubezpieczenieSamochodu = "%";

    private String poj_silnika = "%";
    private String rok_produkcji = "%";
    private String data_przyjecia = "%";
    private String data_pierwszej_rejestracji = "%";
    private String id_gps = "%";
    private String kilometry = "%";
    private String kolor = "%";
    private String wersja = "%";
    private String id_typ_samochodu = "%";
    private String vat = "%";
    private String id_grupa_limit = "%";
    private String nr_umowy_leasingu = "%";
    private String nr_umowy_serwis = "%";
    private String mpk = "%";
    private String prv_umowa = "%";
    private String umowa_z_dnia = "%";
    private String miejsce_parkingowe = "%";
    private String rozmiar_opon = "%";

    public String getModelSamochodu() {
        return modelSamochodu;
    }

    public void setModelSamochodu(String modelSamochodu) {
        this.modelSamochodu = modelSamochodu;
    }

    public String getStatusSamochodu() {
        return statusSamochodu;
    }

    public void setStatusSamochodu(String statusSamochodu) {
        this.statusSamochodu = statusSamochodu;
    }

    public String getNrrejSamochodu() {
        return nrrejSamochodu;
    }

    public void setNrrejSamochodu(String nrrejSamochodu) {
        this.nrrejSamochodu = nrrejSamochodu;
    }

    public String getLokalizacjaSamochodu() {
        return lokalizacjaSamochodu;
    }

    public void setLokalizacjaSamochodu(String lokalizacjaSamochodu) {
        this.lokalizacjaSamochodu = lokalizacjaSamochodu;
    }

    public String getPracownikSamochodu() {
        return pracownikSamochodu;
    }

    public void setPracownikSamochodu(String pracownikSamochodu) {
        this.pracownikSamochodu = pracownikSamochodu;
    }

    public String getNazwaSamochodu() {
        return nazwaSamochodu;
    }

    public void setNazwaSamochodu(String nazwaSamochodu) {
        this.nazwaSamochodu = nazwaSamochodu;
    }

    public String getVinSamochodu() {
        return vinSamochodu;
    }

    public void setVinSamochodu(String vinSamochodu) {
        this.vinSamochodu = vinSamochodu;
    }

    public String getOznaczenieproducentaSamochodu() {
        return oznaczenieproducentaSamochodu;
    }

    public void setOznaczenieproducentaSamochodu(String oznaczenieproducentaSamochodu) {
        this.oznaczenieproducentaSamochodu = oznaczenieproducentaSamochodu;
    }

    public String getMarkaSamochodu() {
        return markaSamochodu;
    }

    public void setMarkaSamochodu(String markaSamochodu) {
        this.markaSamochodu = markaSamochodu;
    }

    public String getOponystatusSamochodu() {
        return oponystatusSamochodu;
    }

    public void setOponystatusSamochodu(String oponystatusSamochodu) {
        this.oponystatusSamochodu = oponystatusSamochodu;
    }

    public String getPaliwoSamochodu() {
        return paliwoSamochodu;
    }

    public void setPaliwoSamochodu(String paliwoSamochodu) {
        this.paliwoSamochodu = paliwoSamochodu;
    }

    public String getLokalizacjaStalaSamochodu() {
        return lokalizacjaStalaSamochodu;
    }

    public void setLokalizacjaStalaSamochodu(String lokalizacjaStalaSamochodu) {
        this.lokalizacjaStalaSamochodu = lokalizacjaStalaSamochodu;
    }

    public String getRodzajSamochodu() {
        return rodzajSamochodu;
    }

    public void setRodzajSamochodu(String rodzajSamochodu) {
        this.rodzajSamochodu = rodzajSamochodu;
    }

    public String getKartaParkingowa() {
        return kartaParkingowa;
    }

    public void setKartaParkingowa(String kartaParkingowa) {
        this.kartaParkingowa = kartaParkingowa;
    }

    public String getKartaPaliwowa() {
        return kartaPaliwowa;
    }

    public void setKartaPaliwowa(String kartaPaliwowa) {
        this.kartaPaliwowa = kartaPaliwowa;
    }

    public String getPrzebiegSamochodu() {
        return przebiegSamochodu;
    }

    public void setPrzebiegSamochodu(String przebiegSamochodu) {
        this.przebiegSamochodu = przebiegSamochodu;
    }

    public String getUbezpieczenieSamochodu() {
        return ubezpieczenieSamochodu;
    }

    public void setUbezpieczenieSamochodu(String ubezpieczenieSamochodu) {
        this.ubezpieczenieSamochodu = ubezpieczenieSamochodu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
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

    public String getId_gps() {
        return id_gps;
    }

    public void setId_gps(String id_gps) {
        this.id_gps = id_gps;
    }

    public String pokazWszystkieSamochody() {

        modelSamochodu = "%";
        statusSamochodu = "%";
        nrrejSamochodu = "%";
        lokalizacjaSamochodu = "%";
        pracownikSamochodu = "%";
        nazwaSamochodu = "%";
        vinSamochodu = "%";
        oznaczenieproducentaSamochodu = "%";
        markaSamochodu = "%";
        oponystatusSamochodu = "%";

        paliwoSamochodu = "%";
        lokalizacjaStalaSamochodu = "%";

        rodzajSamochodu = "%";
        kartaParkingowa = "%";
        kartaPaliwowa = "%";
        przebiegSamochodu = "%"; //dla tabeli kilometry
        ubezpieczenieSamochodu = "%";

        poj_silnika = "%";
        rok_produkcji = "%";
        data_przyjecia = "%";
        data_pierwszej_rejestracji = "%";
        id_gps = "%";
        kilometry = "%";
        kolor = "%";
        wersja = "%";
        id_typ_samochodu = "%";
        vat = "%";
        id_grupa_limit = "%";
        nr_umowy_leasingu = "%";
        nr_umowy_serwis = "%";
        mpk = "%";
        prv_umowa = "%";
        umowa_z_dnia = "%";
        miejsce_parkingowe = "%";
        rozmiar_opon = "%";

        return "index";
    }

    public String pokazSamochod() {
        aktualnySamochod = (Samochod) listaSamochodowNowa.getRowData();

        return "wybranySamochod";
    }

    public Samochod getAktualnySamochod() {
        if (aktualnySamochod == null) {
            aktualnySamochod = new Samochod();
        }

        return aktualnySamochod;
    }

    public DataModel getWyswietlSamochod() {

        listaSamochodowNowa = new ListDataModel(WyszukajSamochod.getListaSamochodowWyszukanych(statusSamochodu, nrrejSamochodu,
                modelSamochodu, lokalizacjaSamochodu, pracownikSamochodu, nazwaSamochodu,
                oponystatusSamochodu, oznaczenieproducentaSamochodu, vinSamochodu, markaSamochodu,
                paliwoSamochodu, lokalizacjaStalaSamochodu, rodzajSamochodu, kartaParkingowa,
                kartaPaliwowa, przebiegSamochodu, ubezpieczenieSamochodu, poj_silnika,
                rok_produkcji,
                data_przyjecia,
                data_pierwszej_rejestracji,
                id_gps,
                kilometry,
                kolor,
                wersja,
                id_typ_samochodu,
                vat,
                id_grupa_limit,
                nr_umowy_leasingu,
                nr_umowy_serwis,
                mpk,
                prv_umowa,
                umowa_z_dnia,
                miejsce_parkingowe,
                rozmiar_opon
        ));

        return listaSamochodowNowa;
    }

    public String wyszukajSamochod() {
        return "wyszukaneSamochody";
    }

    public DataModel getWyswietlWszystkieSamochody() {
        listaSamochodowNowa = new ListDataModel(WyszukajSamochod.getListaSamochodowNowa(statusSamochodu, nrrejSamochodu,
                modelSamochodu, lokalizacjaSamochodu, pracownikSamochodu, nazwaSamochodu,
                oponystatusSamochodu, oznaczenieproducentaSamochodu, vinSamochodu, markaSamochodu,
                paliwoSamochodu, lokalizacjaStalaSamochodu, rodzajSamochodu, kartaParkingowa,
                kartaPaliwowa, przebiegSamochodu, ubezpieczenieSamochodu, poj_silnika,
                rok_produkcji,
                data_przyjecia,
                data_pierwszej_rejestracji,
                id_gps,
                kilometry,
                kolor,
                wersja,
                id_typ_samochodu,
                vat,
                id_grupa_limit,
                nr_umowy_leasingu,
                nr_umowy_serwis,
                mpk,
                prv_umowa,
                umowa_z_dnia,
                miejsce_parkingowe,
                rozmiar_opon));

        return listaSamochodowNowa;
    }

    public DataModel getWyswietlwyszukanySamochod() {
        listaSamochodowNowa = new ListDataModel(WyszukajSamochod.getListaSamochodowWyszukanych(statusSamochodu, nrrejSamochodu,
                modelSamochodu, lokalizacjaSamochodu, pracownikSamochodu, nazwaSamochodu,
                oponystatusSamochodu, oznaczenieproducentaSamochodu, vinSamochodu, markaSamochodu,
                paliwoSamochodu, lokalizacjaStalaSamochodu, rodzajSamochodu, kartaParkingowa,
                kartaPaliwowa, przebiegSamochodu, ubezpieczenieSamochodu, poj_silnika,
                rok_produkcji,
                data_przyjecia,
                data_pierwszej_rejestracji,
                id_gps,
                kilometry,
                kolor,
                wersja,
                id_typ_samochodu,
                vat,
                id_grupa_limit,
                nr_umowy_leasingu,
                nr_umowy_serwis,
                mpk,
                prv_umowa,
                umowa_z_dnia,
                miejsce_parkingowe,
                rozmiar_opon));

        return listaSamochodowNowa;
    }
}
