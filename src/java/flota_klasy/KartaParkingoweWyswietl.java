package flota_klasy;


import flota_klasy.KartaParkingowa;
import flota_klasy.KartaParkingowaWyszukaj;
import flota_klasy.KartaParkingowaZapytania;
import flota_klasy.Roznice;
import flota_klasy.WeryfikacjaDanych;
import flota_klasy.WyswietlSamochod;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michal
 */
@ManagedBean
@SessionScoped
public class KartaParkingoweWyswietl{
    DataModel listaParkingowychWyszukanych;
    private KartaParkingowa usuwaneParkingowej = new KartaParkingowa();
    DataModel listaParkingowychNowa;
    private List<Roznice> listaRoznicParkingowe = new ArrayList<Roznice>();
    private KartaParkingowa aktualneParkingowa = new KartaParkingowa();
    private KartaParkingowa wyedytowaneParkingowa = new KartaParkingowa();
    private KartaParkingowa ParkingowaDoWyszukania = new KartaParkingowa();
    private boolean numerParkingowejBlad = false;
    private List<String> listaPol = asList("Id", 
            "Status", 
            "Lokalizacja",
            "Numer Karty");

    public KartaParkingowa getUsuwaneParkingowej() {
        return usuwaneParkingowej;
    }

    public void setUsuwaneParkingowej(KartaParkingowa usuwaneParkingowej) {
        this.usuwaneParkingowej = usuwaneParkingowej;
    }

    public KartaParkingowa getAktualneParkingowa() {
        return aktualneParkingowa;
    }

    public void setAktualneParkingowa(KartaParkingowa aktualneParkingowa) {
        this.aktualneParkingowa = aktualneParkingowa;
    }

    public KartaParkingowa getWyedytowaneParkingowa() {
        return wyedytowaneParkingowa;
    }

    public void setWyedytowaneParkingowa(KartaParkingowa wyedytowaneParkingowa) {
        this.wyedytowaneParkingowa = wyedytowaneParkingowa;
    }

    public KartaParkingowa getParkingowaDoWyszukania() {
        return ParkingowaDoWyszukania;
    }

    public void setParkingowaDoWyszukania(KartaParkingowa ParkingowaDoWyszukania) {
        this.ParkingowaDoWyszukania = ParkingowaDoWyszukania;
    }

    public boolean isNumerParkingowejBlad() {
        return numerParkingowejBlad;
    }

    public void setNumerParkingowejBlad(boolean numerParkingowejBlad) {
        this.numerParkingowejBlad = numerParkingowejBlad;
    }

    public List<Roznice> getListaRoznicParkingowe() {
        return listaRoznicParkingowe;
    }

    public void setListaRoznicParkingowe(List<Roznice> listaRoznicParkingowe) {
        this.listaRoznicParkingowe = listaRoznicParkingowe;
    }
    /**
     * Metoda do wywolywania strony z wyszukana karta paliwowa
     * @return strona karty paliwowej
     */
    public String wyszukajParkingowa(){
        return "parkingowaWyszukana";
    }
    public DataModel getWyswietlWszystkieParkingowe() {
        listaParkingowychNowa = new ListDataModel(KartaParkingowaWyszukaj.getListaParkingowych());
        return listaParkingowychNowa;
    }
    public DataModel getWyswietlWyszukaneParkingowe() {
        listaParkingowychWyszukanych = new ListDataModel(KartaParkingowaWyszukaj.getListWyszukanychParkingowych(ParkingowaDoWyszukania));
        return listaParkingowychWyszukanych;
    }
    public String goToIndex() {
        return "parkingowaWidok";
    }
    public String pokazParkingowa() throws CloneNotSupportedException {
        aktualneParkingowa = (KartaParkingowa) listaParkingowychNowa.getRowData();
        wyedytowaneParkingowa = (KartaParkingowa) aktualneParkingowa.clone();
        return "parkingowaWybrana";
    }
    
     public String weryfikacjaDanych() throws IllegalAccessException, InstantiationException {
            
       List<Integer> listaRoznic = new ArrayList<Integer>();
        List<Object> aktKartaPark = new ArrayList<Object>();
        List<Object> wyedKartaPark = new ArrayList<Object>();

        if (!aktualneParkingowa.getNumer_karta_parkingowa().equals(wyedytowaneParkingowa.getNumer_karta_parkingowa())) {
            setNumerParkingowejBlad(!WeryfikacjaDanych.czyUnikalny("numer_karty", "karta_paliwowa", wyedytowaneParkingowa.getNumer_karta_parkingowa()));
        }
        if (numerParkingowejBlad) {
            saveMessage("Numer karty paliwowej juz wystepuje, podaj inny.");
        }

        if (!numerParkingowejBlad) {
            RequestContext context = RequestContext.getCurrentInstance();
            for (Field field : aktualneParkingowa.getClass().getDeclaredFields()) {
                field.setAccessible(true); // You might want to set modifier to public first.
                Object value = field.get(aktualneParkingowa);
                System.out.println("pole " + field.getName() + " wartosc " + value);
                aktKartaPark.add(value);

                Object value2 = field.get(wyedytowaneParkingowa);
                wyedKartaPark.add(value2);

            }
            listaRoznic.clear();
            listaRoznic = WyswietlSamochod.porownajDwieListy(aktKartaPark, wyedKartaPark);
            if (listaRoznic.isEmpty()) {
                return "parkingowaWidok";
            } else {
                listaRoznicParkingowe = Roznice.stworzListeRoznic(aktKartaPark, wyedKartaPark, listaRoznic, listaPol);
                context.execute("PF('dlg1').show();");
                return "parkingowaWybrana";
            }

        } else {
            return "parkingowaWybrana";
        }

    
    }
      public void saveMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
      public String zapiszWyedytowanaKarte(){
       //do dodania funkcja nie usuwac
        KartaParkingowaZapytania.zapiszWyedytowanaKarteParkingowa(wyedytowaneParkingowa); 
        return "parkingowaWidok";
    }
    
    public String usunKarteParkingowa() {
        usuwaneParkingowej = (KartaParkingowa) listaParkingowychNowa.getRowData();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('potwierdzUsuwanie').show();");
        return "parkingowaWidok";
    }
    
    public String potwierdzUsuniecieKarty(){
        //do dodania funkcja nie usuwac
        KartaParkingowaZapytania.usunKarteParkingowa(usuwaneParkingowej.getId_karta_parkingowa());
        return "parkingowaWidok";
    }

}
