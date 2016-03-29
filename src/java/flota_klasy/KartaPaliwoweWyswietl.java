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
public class KartaPaliwoweWyswietl {
    DataModel listaPaliwowychWyszukanych;
    private KartaPaliwowa usuwanePaliwowej = new KartaPaliwowa();
    DataModel listaPaliwowychNowa;
    private List<Roznice> listaRoznicPaliwowe = new ArrayList<Roznice>();
    private KartaPaliwowa aktualnePaliwowa = new KartaPaliwowa();
    private KartaPaliwowa wyedytowanePaliwowa = new KartaPaliwowa();
    private KartaPaliwowa PaliwowaDoWyszukania = new KartaPaliwowa();
    private boolean numerPaliwowejBlad = false;
    private List<String> listaPol = asList("Id", 
            "Status", 
            "Lokalizacja",
            "Numer Karty",
            "Pin Karty");

    public KartaPaliwowa getUsuwanePaliwowej() {
        return usuwanePaliwowej;
    }

    public void setUsuwanePaliwowej(KartaPaliwowa usuwanePaliwowej) {
        this.usuwanePaliwowej = usuwanePaliwowej;
    }

    public KartaPaliwowa getAktualnePaliwowa() {
        return aktualnePaliwowa;
    }

    public void setAktualnePaliwowa(KartaPaliwowa aktualnePaliwowa) {
        this.aktualnePaliwowa = aktualnePaliwowa;
    }

    public KartaPaliwowa getWyedytowanePaliwowa() {
        return wyedytowanePaliwowa;
    }

    public void setWyedytowanePaliwowa(KartaPaliwowa wyedytowanePaliwowa) {
        this.wyedytowanePaliwowa = wyedytowanePaliwowa;
    }

    public KartaPaliwowa getPaliwowaDoWyszukania() {
        return PaliwowaDoWyszukania;
    }

    public void setPaliwowaDoWyszukania(KartaPaliwowa PaliwowaDoWyszukania) {
        this.PaliwowaDoWyszukania = PaliwowaDoWyszukania;
    }

    public boolean isNumerPaliwowejBlad() {
        return numerPaliwowejBlad;
    }

    public void setNumerPaliwowejBlad(boolean numerPaliwowejBlad) {
        this.numerPaliwowejBlad = numerPaliwowejBlad;
    }

    public List<Roznice> getListaRoznicPaliwowe() {
        return listaRoznicPaliwowe;
    }

    public void setListaRoznicPaliwowe(List<Roznice> listaRoznicPaliwowe) {
        this.listaRoznicPaliwowe = listaRoznicPaliwowe;
    }
    /**
     * Metoda do wywolywania strony z wyszukana karta paliwowa
     * @return strona karty paliwowej
     */
    public String wyszukajPaliwowa(){
        return "paliwowaWyszukana";
    }
    public DataModel getWyswietlWszystkiePaliwowe() {
        listaPaliwowychNowa = new ListDataModel(KartaPaliwowaWyszukaj.getListaPaliwowych());
        return listaPaliwowychNowa;
    }
    public DataModel getWyswietlWyszukanePaliwowe() {
        listaPaliwowychWyszukanych = new ListDataModel(KartaPaliwowaWyszukaj.getListWyszukanychPaliwowych(PaliwowaDoWyszukania));
        return listaPaliwowychWyszukanych;
    }
    public String goToIndex() {
        return "paliwowaWidok";
    }
    public String pokazPaliwowa() throws CloneNotSupportedException {
        aktualnePaliwowa = (KartaPaliwowa) listaPaliwowychNowa.getRowData();
        wyedytowanePaliwowa = (KartaPaliwowa) aktualnePaliwowa.clone();
        return "paliwowaWybrana";
    }
    
     public String weryfikacjaDanych() throws IllegalAccessException, InstantiationException {
            
//        List<Integer> listaRoznic = new ArrayList<Integer>();
//        List<Object> aktualneUbezpieczenieLista = new ArrayList<Object>();
//        List<Object> wyedytowaneUbezpieczenieLista = new ArrayList<Object>();
//
//        if (!aktualneUbezpieczenie.getNumer_polisy().equals(wyedytowaneUbezpieczenie.getNumer_polisy())) {
//            setNumerPolisyBlad(!WeryfikacjaDanych.czyUnikalny("numer_polisy", "ubezpieczenie", wyedytowaneUbezpieczenie.getNumer_polisy()));
//        }
//        if (numerPolisyBlad) {
//            saveMessage("Numer polisy juz wystepuje w bazie");
//        }
//
//        if (!numerPolisyBlad) {
//            RequestContext context = RequestContext.getCurrentInstance();
//            for (Field field : aktualneUbezpieczenie.getClass().getDeclaredFields()) {
//                field.setAccessible(true); // You might want to set modifier to public first.
//                Object value = field.get(aktualneUbezpieczenie);
//                System.out.println("pole " + field.getName() + " wartosc " + value);
//                aktualneUbezpieczenieLista.add(value);
//
//                Object value2 = field.get(wyedytowaneUbezpieczenie);
//                wyedytowaneUbezpieczenieLista.add(value2);
//
//            }
//            listaRoznic.clear();
//            listaRoznic = WyswietlSamochod.porownajDwieListy(aktualneUbezpieczenieLista, wyedytowaneUbezpieczenieLista);
//            if (listaRoznic.isEmpty()) {
//                return "index";
//            } else {
//                listaRoznicUbezpieczenie = Roznice.stworzListeRoznic(aktualneUbezpieczenieLista, wyedytowaneUbezpieczenieLista, listaRoznic, listaPol);
//                context.execute("PF('dlg1').show();");
//                return "ubezpieczenieWybrane";
//            }
//
//        } else {
//            return "ubezpieczenieWybrane";
//        }

    return null;
    }
      public void saveMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
      public String zapiszWyedytowaneUbezpieczenie(){
       
        KartaPaliwowaZapytania.zapiszWyedytowanaKartePaliwowa(wyedytowanePaliwowa);
        return "paliwowaWidok";
    }
    
    public String usunKartePaliwowa() {
        usuwanePaliwowej = (KartaPaliwowa) listaPaliwowychNowa.getRowData();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('potwierdzUsuwanie').show();");
        return "paliwowaWidok";
    }
    
    public String potwierdzUsuniecieUbezpieczenia(){
        UbezpieczenieZapytania.usunKartePaliwowa(usuwanePaliwowej.getId_karta_paliwowa());
        return "ubezpieczeniaWidok";
    }

}
