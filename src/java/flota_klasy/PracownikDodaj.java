/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author M
 */
@ManagedBean
@SessionScoped
public class PracownikDodaj {
    
    private Pracownik dodawanyPracownik = new Pracownik();
    

    
    public Pracownik getDodawanyPracownik(){
        return dodawanyPracownik;
    }
    
    private boolean loginBlad = false;
     

    public String wywietldodajPracownik() {
        return "dodajPracownik";
    }

  
    public void dodajPracownik() {
           
        if (!WeryfikacjaDanych.czyUnikalny("login", "pracownik", dodawanyPracownik.getLogin())){
            System.out.println("Wszystko jest unikalne.");
            PracownikZapytania.dodajPracownika(dodawanyPracownik);
        }

    }
    
    

    

}
