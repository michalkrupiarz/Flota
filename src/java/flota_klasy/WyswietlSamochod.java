/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author M
 */
@ManagedBean
@SessionScoped
public class WyswietlSamochod {

    private String growlMessage;

    public String getGrowlMessage() {
        return growlMessage;
    }

    public void setGrowlMessage(String growlMessage) {
        this.growlMessage = growlMessage;
    }
    private boolean nazwaSamochoduBlad = false;
    private boolean NrRejSamochoduBlad = false;
    private boolean nr_umowy_leasingBlad = false;
    private boolean nr_umowy_serwisBlad = false;
    private boolean nr_vinBlad = false;
    private boolean prv_umowaBlad = false;
    long id;
    public boolean isFlaga;
    List<Lokalizacja> listaLokalizacji;
    List<Samochod> listaSamochodow;
    DataModel listaSamochodowNowa;
    Samochod samochod;
    private Samochod wyszukanySamochod = new Samochod();

    private Samochod aktualnySamochod = new Samochod();

    private Samochod wyedytowanySamochod = new Samochod();

    public Samochod getWyedytowanySamochod() {

        return wyedytowanySamochod;
    }

    public boolean isIsFlaga() {
        return isFlaga;
    }

    public void setIsFlaga(boolean isFlaga) {
        this.isFlaga = isFlaga;
    }

    public boolean isNazwaSamochoduBlad() {
        return nazwaSamochoduBlad;
    }

    public void setNazwaSamochoduBlad(boolean nazwaSamochoduBlad) {
        this.nazwaSamochoduBlad = nazwaSamochoduBlad;
    }

    public boolean isNrRejSamochoduBlad() {
        return NrRejSamochoduBlad;
    }

    public void setNrRejSamochoduBlad(boolean NrRejSamochoduBlad) {
        this.NrRejSamochoduBlad = NrRejSamochoduBlad;
    }

    public boolean isNr_umowy_leasingBlad() {
        return nr_umowy_leasingBlad;
    }

    public void setNr_umowy_leasingBlad(boolean nr_umowy_leasingBlad) {
        this.nr_umowy_leasingBlad = nr_umowy_leasingBlad;
    }

    public boolean isNr_umowy_serwisBlad() {
        return nr_umowy_serwisBlad;
    }

    public void setNr_umowy_serwisBlad(boolean nr_umowy_serwisBlad) {
        this.nr_umowy_serwisBlad = nr_umowy_serwisBlad;
    }

    public boolean isNr_vinBlad() {
        return nr_vinBlad;
    }

    public void setNr_vinBlad(boolean nr_vinBlad) {
        this.nr_vinBlad = nr_vinBlad;
    }

    public boolean isPrv_umowaBlad() {
        return prv_umowaBlad;
    }

    public void setPrv_umowaBlad(boolean prv_umowaBlad) {
        this.prv_umowaBlad = prv_umowaBlad;
    }

    public Samochod getWyszukanySamochod() {
        return wyszukanySamochod;
    }

    public String pokazWszystkieSamochody() {

        return "index";
    }

    public String pokazSamochod() throws CloneNotSupportedException {
        aktualnySamochod = (Samochod) listaSamochodowNowa.getRowData();
        wyedytowanySamochod = (Samochod) aktualnySamochod.clone();
        return "wybranySamochod";
    }

    public Samochod getAktualnySamochod() {
        if (aktualnySamochod == null) {
            aktualnySamochod = new Samochod();
        }

        return aktualnySamochod;
    }

    public DataModel getWyswietlSamochod() {

        listaSamochodowNowa = new ListDataModel(WyszukajSamochod.getListaSamochodowWyszukanych(
                wyszukanySamochod
        ));

        return listaSamochodowNowa;
    }

    public String wyszukajSamochod() {

        return "wyszukaneSamochody";
    }

    public DataModel getWyswietlWszystkieSamochody() {
        listaSamochodowNowa = new ListDataModel(WyszukajSamochod.getListaSamochodowNowa());

        return listaSamochodowNowa;
    }

    public DataModel getWyswietlwyszukanySamochod() {
        listaSamochodowNowa = new ListDataModel(WyszukajSamochod.getListaSamochodowWyszukanych(
                wyszukanySamochod));

        return listaSamochodowNowa;
    }

    public String zapiszWyedytowanySamochod(String pole) {
        // poprzez metode klonowania mamy klona i rozne wartoisc, teraz nalezy tylko to odpowiednio obrobic 
        System.out.println(pole);
        System.out.println("czy unikalny " + WeryfikacjaDanych.czyUnikalny(pole, "samochod", wyedytowanySamochod.getNazwa()));
        System.out.println("stara nazwa samochodu " + aktualnySamochod.getNazwa());
        System.out.println("nowa nazwa samochodu " + wyedytowanySamochod.getNazwa());

        System.out.println("stara nazwa samochodu " + aktualnySamochod.getMarka());
        System.out.println("nowa nazwa samochodu " + wyedytowanySamochod.getMarka());
        setIsFlaga(true);
        return null;
    }

    public String weryfikacjaDanych() {            
        
        if (aktualnySamochod.getNazwa().equals(wyedytowanySamochod.getNazwa())) {
            setNazwaSamochoduBlad(WeryfikacjaDanych.czyUnikalny("nazwa", "samochod", wyedytowanySamochod.getNazwa()));
        } else {
            setNazwaSamochoduBlad(!WeryfikacjaDanych.czyUnikalny("nazwa", "samochod", wyedytowanySamochod.getNazwa()));
        }
        
        if (aktualnySamochod.getNr_vin().equals(wyedytowanySamochod.getNr_vin())){
            setNr_vinBlad(WeryfikacjaDanych.czyUnikalny("nr_vin", "samochod", wyedytowanySamochod.getNr_vin()));
        } else {
            setNr_vinBlad(!WeryfikacjaDanych.czyUnikalny("nr_vin", "samochod", wyedytowanySamochod.getNr_vin()));
        }
        
        if (nr_vinBlad){
            saveMessage("Nr VIN samochodu wystepuje juz w bazie danych!");
        }
        
        if (nazwaSamochoduBlad) {
            saveMessage("Nazwa samochodu juz występuje!");
        }
        
        return "wybranySamochod";
    }

    public void saveMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
}
