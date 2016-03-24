/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
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
public class PaliwoweWyswietl {
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
        listaPaliwowychNowa = new ListDataModel(PaliwowaWyszukaj.getListaPaliwowych());
        return listaPaliwowychNowa;
    }
    public DataModel getWyswietlWyszukanePaliwowe() {
        listaPaliwowychWyszukanych = new ListDataModel(PaliwowaWyszukaj.getListWyszukanychPaliwowych(PaliwowaDoWyszukania));
        return listaPaliwowychWyszukanych;
    }
}
