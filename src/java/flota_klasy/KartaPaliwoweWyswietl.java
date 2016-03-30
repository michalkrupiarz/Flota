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
            
       List<Integer> listaRoznic = new ArrayList<Integer>();
        List<Object> aktKartaPal = new ArrayList<Object>();
        List<Object> wyedKartaPal = new ArrayList<Object>();

        if (!aktualnePaliwowa.getNumer_Karty().equals(wyedytowanePaliwowa.getNumer_Karty())) {
            setNumerPaliwowejBlad(!WeryfikacjaDanych.czyUnikalny("numer_karty", "karta_paliwowa", wyedytowanePaliwowa.getNumer_Karty()));
        }
        if (numerPaliwowejBlad) {
            saveMessage("Numer karty paliwowej juz wystepuje, podaj inny.");
        }

        if (!numerPaliwowejBlad) {
            RequestContext context = RequestContext.getCurrentInstance();
            for (Field field : aktualnePaliwowa.getClass().getDeclaredFields()) {
                field.setAccessible(true); // You might want to set modifier to public first.
                Object value = field.get(aktualnePaliwowa);
                System.out.println("pole " + field.getName() + " wartosc " + value);
                aktKartaPal.add(value);

                Object value2 = field.get(wyedytowanePaliwowa);
                wyedKartaPal.add(value2);

            }
            listaRoznic.clear();
            listaRoznic = WyswietlSamochod.porownajDwieListy(aktKartaPal, wyedKartaPal);
            if (listaRoznic.isEmpty()) {
                return "paliwowaWidok";
            } else {
                listaRoznicPaliwowe = Roznice.stworzListeRoznic(aktKartaPal, wyedKartaPal, listaRoznic, listaPol);
                context.execute("PF('dlg1').show();");
                return "paliwowaWybrana";
            }

        } else {
            return "paliwowaWybrana";
        }

    
    }
      public void saveMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
      public String zapiszWyedytowanaKarte(){
       
        KartaPaliwowaZapytania.zapiszWyedytowanaKartePaliwowa(wyedytowanePaliwowa);
        return "paliwowaWidok";
    }
    
    public String usunKartePaliwowa() {
        usuwanePaliwowej = (KartaPaliwowa) listaPaliwowychNowa.getRowData();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('potwierdzUsuwanie').show();");
        return "paliwowaWidok";
    }
    
    public String potwierdzUsuniecieKarty(){
        KartaPaliwowaZapytania.usunKartePaliwowa(usuwanePaliwowej.getId_karta_paliwowa());
        return "ubezpieczeniaWidok";
    }

}
