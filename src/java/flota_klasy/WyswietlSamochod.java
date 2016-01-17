/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

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
    private Samochod wyszukanySamochod = new Samochod();

    private Samochod aktualnySamochod;

    private Samochod wyedytowanySamochod = new Samochod();

    public Samochod getWyedytowanySamochod() {
        return wyedytowanySamochod;
    }

    public void nadpisz(String nadpisz) {
        aktualnySamochod.setNazwa(nadpisz);
    }

    public Samochod getWyszukanySamochod() {
        return wyszukanySamochod;
    }

    public String pokazWszystkieSamochody() {

        return "index";
    }

    public String pokazSamochod() {
        aktualnySamochod = (Samochod) listaSamochodowNowa.getRowData();
        wyedytowanySamochod = aktualnySamochod;
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
    
    public String zapiszWyedytowanySamochod(){  
        aktualnySamochod = wyedytowanySamochod;        
    
        System.out.println("nowa nazwa samochodu"+aktualnySamochod.getNazwa());
        
        return null;
    }
}
