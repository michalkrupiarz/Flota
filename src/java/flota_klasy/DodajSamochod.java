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
public class DodajSamochod {
    
    private Samochod dodawanySamochod = new Samochod();
    

    
    public Samochod getDodawanySamochod(){
        return dodawanySamochod;
    }
    
   

    private boolean nazwaSamochoduBlad = false;
    private boolean NrRejSamochoduBlad = false;
    private boolean nr_umowy_leasingBlad = false;
    private boolean nr_umowy_serwisBlad = false;
    private boolean nr_vinBlad = false;
    private boolean prv_umowaBlad = false;
    private boolean miejsce_parkingoweBlad = false;

    public boolean isMiejsce_parkingoweBlad() {
        return miejsce_parkingoweBlad;
    }

    public void setMiejsce_parkingoweBlad(boolean miejsce_parkingoweBlad) {
        this.miejsce_parkingoweBlad = miejsce_parkingoweBlad;
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

    public boolean isNrRejSamochoduBlad() {
        return NrRejSamochoduBlad;
    }

    public void setNrRejSamochoduBlad(boolean NrRejSamochoduBlad) {
        this.NrRejSamochoduBlad = NrRejSamochoduBlad;
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

        int iloscNieUnikalnychDanych = 0;
        Samochod dodawanySamochod = new Samochod();
        List<Boolean> listaWeryfikacyjnaDlaSamochodu = new ArrayList<Boolean>();

        

        listaWeryfikacyjnaDlaSamochodu.add(WeryfikacjaDanych.czyUnikalny("nazwa", "samochod", dodawanySamochod.getNazwa()));
        setNazwaSamochoduBlad(!WeryfikacjaDanych.czyUnikalny("nazwa", "samochod", dodawanySamochod.getNazwa()));
        listaWeryfikacyjnaDlaSamochodu.add(WeryfikacjaDanych.czyUnikalny("nr_rej", "samochod", dodawanySamochod.getNr_rej()));
        setNrRejSamochoduBlad(!WeryfikacjaDanych.czyUnikalny("nr_rej", "samochod", dodawanySamochod.getNr_rej()));
        listaWeryfikacyjnaDlaSamochodu.add(WeryfikacjaDanych.czyUnikalny("nr_vin", "samochod", dodawanySamochod.getNr_vin()));
        setNr_vinBlad(!WeryfikacjaDanych.czyUnikalny("nr_vin", "samochod", dodawanySamochod.getNr_vin()));
        listaWeryfikacyjnaDlaSamochodu.add(WeryfikacjaDanych.czyUnikalny("nr_umowy_leasingu", "samochod", dodawanySamochod.getNr_umowy_leasingu()));
        setNr_umowy_leasingBlad(!WeryfikacjaDanych.czyUnikalny("nr_umowy_leasingu", "samochod", dodawanySamochod.getNr_umowy_leasingu()));
        listaWeryfikacyjnaDlaSamochodu.add(WeryfikacjaDanych.czyUnikalny("nr_umowy_serwis", "samochod", dodawanySamochod.getNr_umowy_serwis()));
        setNr_umowy_serwisBlad(!WeryfikacjaDanych.czyUnikalny("nr_umowy_serwis", "samochod", dodawanySamochod.getNr_umowy_serwis()));
        listaWeryfikacyjnaDlaSamochodu.add(WeryfikacjaDanych.czyUnikalny("prv_umowa", "samochod", dodawanySamochod.getPrv_umowa()));
        setPrv_umowaBlad(!WeryfikacjaDanych.czyUnikalny("prv_umowa", "samochod", dodawanySamochod.getPrv_umowa()));
        listaWeryfikacyjnaDlaSamochodu.add(WeryfikacjaDanych.czyUnikalny("miejsce_parkingowe", "samochod", dodawanySamochod.getMiejsce_parkingowe()));
        setMiejsce_parkingoweBlad(!WeryfikacjaDanych.czyUnikalny("miejsce_parkingowe", "samochod", dodawanySamochod.getMiejsce_parkingowe()));
        
        System.out.println(dodawanySamochod.getId_gps());
        
        if (!czyJestFalse(listaWeryfikacyjnaDlaSamochodu)){
            System.out.println("Wszystko jest unikalne.");
            SamochodZapytania.dodajSamochod(dodawanySamochod);
        }

    }
    
    public boolean czyJestFalse(List<Boolean> listaBooleanow){
        boolean flaga = false;
        for (Boolean item:listaBooleanow){
            if (!item){
                flaga=true;
            }
        }
        return flaga;
    }

    

}
