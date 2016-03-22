/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Michal
 */
@ManagedBean
@SessionScoped
public class UbezpieczeniaWyswietl {

    DataModel listaUbezpieczenWyszukanych;
    private Ubezpieczenie usuwaneUbezpieczenie = new Ubezpieczenie();
    DataModel listaUbezpieczenNowa;
    private List<Roznice> listaRoznicUbezpieczenie = new ArrayList<Roznice>();
    private Ubezpieczenie aktualneUbezpieczenie = new Ubezpieczenie();
    private Ubezpieczenie wyedytowaneUbezpieczenie = new Ubezpieczenie();
    private Ubezpieczenie ubezpieczenieDoWyszukania = new Ubezpieczenie();
    private boolean numerPolisyBlad = false;
    private List<String> listaPol = asList("Id", 
            "Nazwa Samochod", 
            "Data rozpoczecia",
            "Data zakonczenia",
            "Data pierwszego podpisania umowy",
            "Nazwa ubezpieczyciela",
            "Wysokosc skladki",
            "Pracownik zawierajacy ubezpieczenie",
            "Notatka",
            "Numer polisy",
            "Nazwa sprzedawcy",
            "Kontakt");

    public List<Roznice> getListaRoznicUbezpieczenie() {
        return listaRoznicUbezpieczenie;
    }

    public void setListaRoznicUbezpieczenie(List<Roznice> listaRoznicUbezpieczenie) {
        this.listaRoznicUbezpieczenie = listaRoznicUbezpieczenie;
    }

    public Ubezpieczenie getUsuwaneUbezpieczenie() {
        return usuwaneUbezpieczenie;
    }

    public void setUsuwaneUbezpieczenie(Ubezpieczenie usuwaneUbezpieczenie) {
        this.usuwaneUbezpieczenie = usuwaneUbezpieczenie;
    }
        
    public boolean isNumerPolisyBlad() {
        return numerPolisyBlad;
    }

    public void setNumerPolisyBlad(boolean numerPolisyBlad) {
        this.numerPolisyBlad = numerPolisyBlad;
    }

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

    public String wyszukajUbezpieczenia() {
        System.out.println("XXX " + ubezpieczenieDoWyszukania.getId_samochodu());
        return "ubezpieczeniaWyszukane";
    }

    public DataModel getWyswietlWyszukaneUbezpieczenia() {
        listaUbezpieczenWyszukanych = new ListDataModel(UbezpieczeniaWyszukaj.getListaWyszukanychUbezpieczen(ubezpieczenieDoWyszukania));
        return listaUbezpieczenWyszukanych;
    }

    public String goToIndex() {
        return "ubezpieczeniaWidok";
    }

    public String pokazUbezpieczenie() throws CloneNotSupportedException {
        aktualneUbezpieczenie = (Ubezpieczenie) listaUbezpieczenNowa.getRowData();
        wyedytowaneUbezpieczenie = (Ubezpieczenie) aktualneUbezpieczenie.clone();
        return "ubezpieczenieWybrane";
    }

    public String weryfikacjaDanych() throws IllegalAccessException, InstantiationException {
            
        List<Integer> listaRoznic = new ArrayList<Integer>();
        List<Object> aktualneUbezpieczenieLista = new ArrayList<Object>();
        List<Object> wyedytowaneUbezpieczenieLista = new ArrayList<Object>();

        if (!aktualneUbezpieczenie.getNumer_polisy().equals(wyedytowaneUbezpieczenie.getNumer_polisy())) {
            setNumerPolisyBlad(!WeryfikacjaDanych.czyUnikalny("numer_polisy", "ubezpieczenie", wyedytowaneUbezpieczenie.getNumer_polisy()));
        }
        if (numerPolisyBlad) {
            saveMessage("Numer polisy juz wystepuje w bazie");
        }

        if (!numerPolisyBlad) {
            RequestContext context = RequestContext.getCurrentInstance();
            for (Field field : aktualneUbezpieczenie.getClass().getDeclaredFields()) {
                field.setAccessible(true); // You might want to set modifier to public first.
                Object value = field.get(aktualneUbezpieczenie);
                System.out.println("pole " + field.getName() + " wartosc " + value);
                aktualneUbezpieczenieLista.add(value);

                Object value2 = field.get(wyedytowaneUbezpieczenie);
                wyedytowaneUbezpieczenieLista.add(value2);

            }
            listaRoznic.clear();
            listaRoznic = WyswietlSamochod.porownajDwieListy(aktualneUbezpieczenieLista, wyedytowaneUbezpieczenieLista);
            if (listaRoznic.isEmpty()) {
                return "index";
            } else {
                listaRoznicUbezpieczenie = Roznice.stworzListeRoznic(aktualneUbezpieczenieLista, wyedytowaneUbezpieczenieLista, listaRoznic, listaPol);
                context.execute("PF('dlg1').show();");
                return "ubezpieczenieWybrane";
            }

        } else {
            return "ubezpieczenieWybrane";
        }

        
    }

    public void saveMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
    
    public String zapiszWyedytowaneUbezpieczenie(){
        UbezpieczenieZapytania.zapiszWyedytowaneUbezpieczenie(wyedytowaneUbezpieczenie);
        return "ubezpieczeniaWidok";
    }
    
    public String usunUbezpieczenie() {
        usuwaneUbezpieczenie = (Ubezpieczenie) listaUbezpieczenNowa.getRowData();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('potwierdzUsuwanie').show();");
        return "ubezpieczeniaWidok";
    }
    
    public String potwierdzUsuniecieUbezpieczenia(){
        UbezpieczenieZapytania.usunUbezpieczenie(usuwaneUbezpieczenie.getId_ubezpieczenia());
        return "ubezpieczeniaWidok";
    }
    
}
