/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.text.NumberFormat.Field;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import static org.apache.commons.lang.SerializationUtils.clone;
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
    private Samochod wyszukanySamochod = new Samochod();

    private Samochod aktualnySamochod = new Samochod();

    private Samochod wyedytowanySamochod = new Samochod();

    public Samochod getWyedytowanySamochod() {

        return wyedytowanySamochod;
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
        System.out.println("nowa nazwa samochodu " + aktualnySamochod.getNazwa());
        System.out.println("nowa nazwa samochodu " + wyedytowanySamochod.getNazwa());
        
        System.out.println("nowa nazwa samochodu " + aktualnySamochod.getMarka());
        System.out.println("nowa nazwa samochodu " + wyedytowanySamochod.getMarka());
        return null;
    }
}
