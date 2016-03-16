/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Michal
 */
@ManagedBean
@SessionScoped
public class UbezpieczeniaWyswietl {
    
    DataModel listaUbezpieczenWyszukanych;
    
    DataModel listaUbezpieczenNowa;
    
    private Ubezpieczenie aktualneUbezpieczenie = new Ubezpieczenie();
    private Ubezpieczenie wyedytowaneUbezpieczenie = new Ubezpieczenie();
    private Ubezpieczenie ubezpieczenieDoWyszukania = new Ubezpieczenie();

    public Ubezpieczenie getAktualneUbezpieczenie() {
        return aktualneUbezpieczenie;
    }

    public void setAktualneUbezpieczenie(Ubezpieczenie aktualneUbezpieczenie) {
        this.aktualneUbezpieczenie = aktualneUbezpieczenie;
    }

    public Ubezpieczenie getWyedytowaneUbezpieczenie() {
        return wyedytowaneUbezpieczenie;
    }

    public void setWyedytowaneUbezpieczenie(Ubezpieczenie wyedytowaneUbezpieczenie) {
        this.wyedytowaneUbezpieczenie = wyedytowaneUbezpieczenie;
    }
    
    public Ubezpieczenie getUbezpieczenieDoWyszukania() {
        return ubezpieczenieDoWyszukania;
    }

    public void setUbezpieczenieDoWyszukania(Ubezpieczenie ubezpieczenieDoWyszukania) {
        this.ubezpieczenieDoWyszukania = ubezpieczenieDoWyszukania;
    }
    public DataModel getWyswietlWszystkieUbezpieczenia() {
        listaUbezpieczenNowa = new ListDataModel(UbezpieczeniaWyszukaj.getListaUbezpieczen());
        return listaUbezpieczenNowa;
    }
    
    public String wyszukajUbezpieczenia(){
        System.out.println("XXX "+ubezpieczenieDoWyszukania.getId_samochodu());
        return "ubezpieczeniaWyszukane";
    }
    public DataModel getWyswietlWyszukaneUbezpieczenia(){
        listaUbezpieczenWyszukanych = new ListDataModel(UbezpieczeniaWyszukaj.getListaWyszukanychUbezpieczen(ubezpieczenieDoWyszukania));
        return listaUbezpieczenWyszukanych;
    }
    
    public String goToIndex(){
        return "index";
    }
    
    public String pokazUbezpieczenie() throws CloneNotSupportedException {
        aktualneUbezpieczenie = (Ubezpieczenie) listaUbezpieczenNowa.getRowData();
        wyedytowaneUbezpieczenie = (Ubezpieczenie) aktualneUbezpieczenie.clone();
        return "ubezpieczenieWybrane";
    }
}
