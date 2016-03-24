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
public class UbezpieczenieDodaj {
private Ubezpieczenie dodawaneUbezpieczenie = new Ubezpieczenie();

    public Ubezpieczenie getDodawaneUbezpieczenie() {
        return dodawaneUbezpieczenie;
    }
    public String dodajUbezpieczenie(){
        
        UbezpieczenieZapytania.dodajUbezpieczenie(dodawaneUbezpieczenie);
        return "ubezpieczeniaWyszukane";
    }
    public String wyswietlDodajUbezpieczenie(){
        return "ubezpieczenieDodaj";
    }
}
