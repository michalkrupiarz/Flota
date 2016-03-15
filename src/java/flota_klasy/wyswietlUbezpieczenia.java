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
public class wyswietlUbezpieczenia {
    
    DataModel listaUbezpieczenNowa;
    private Ubezpieczenie ubezpieczenieDoWyszukania = new Ubezpieczenie();

    public Ubezpieczenie getWyszukaneUbezpieczenie() {
        return ubezpieczenieDoWyszukania;
    }

    public void setWyszukaneUbezpieczenie(Ubezpieczenie wyszukaneUbezpieczenie) {
        this.ubezpieczenieDoWyszukania = wyszukaneUbezpieczenie;
    }
    public DataModel getWyswietlWszystkieUbezpieczenia() {
        listaUbezpieczenNowa = new ListDataModel(UbezpieczeniaWyszukaj.getListaUbezpieczen());
        return listaUbezpieczenNowa;
    }
}
