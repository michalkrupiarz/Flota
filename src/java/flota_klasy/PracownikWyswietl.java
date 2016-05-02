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
public class PracownikWyswietl {

    DataModel listaPracownikowWyszukanych;
    private Pracownik usuwanePracownik = new Pracownik();
    DataModel listaPracownikowNowa;
    private List<Roznice> listaRoznicPracownik = new ArrayList<Roznice>();
    private Pracownik aktualnePracownik = new Pracownik();
    private Pracownik wyedytowanePracownik = new Pracownik();
    private Pracownik PracownikDoWyszukania = new Pracownik();
    private boolean loginPracownikBlad = false;
    private List<String> listaPol = asList("Id pracownik",
            "Login",
            "Hsalo",
            "Imie",
            "Nazwisko",
            "Stanowisko",
            "Dzial",
            "Loklizacja",
            "Mail",
            "Telefon stacjonarny",
            "Telefon komorkowy",
            "Samochod",
            "id_import",
            "Uprawnienia",
            "Imie Nazwisko");

    public Pracownik getUsuwanePracownik() {
        return usuwanePracownik;
    }

    public void setUsuwanePracownik(Pracownik usuwanePracownik) {
        this.usuwanePracownik = usuwanePracownik;
    }

    public Pracownik getAktualnePracownik() {
        return aktualnePracownik;
    }

    public void setAktualnePracownik(Pracownik aktualnePracownik) {
        this.aktualnePracownik = aktualnePracownik;
    }

    public Pracownik getWyedytowanePracownik() {
        return wyedytowanePracownik;
    }

    public void setWyedytowanePracownik(Pracownik wyedytowanePracownik) {
        this.wyedytowanePracownik = wyedytowanePracownik;
    }

    public Pracownik getPracownikDoWyszukania() {
        return PracownikDoWyszukania;
    }

    public void setPracownikDoWyszukania(Pracownik PracownikDoWyszukania) {
        this.PracownikDoWyszukania = PracownikDoWyszukania;
    }

    public boolean getLoginPracownikBlad() {
        return loginPracownikBlad;
    }

    public void setLoginPracownikBlad(boolean numerPracownikBlad) {
        this.loginPracownikBlad = numerPracownikBlad;
    }

    public List<Roznice> getListaRoznicPracownik() {
        return listaRoznicPracownik;
    }

    public void setListaRoznicPracownik(List<Roznice> listaRoznicPracownik) {
        this.listaRoznicPracownik = listaRoznicPracownik;
    }

    /**
     * Metoda do wywolywania strony z wyszukana karta paliwowa
     *
     * @return strona karty paliwowej
     */
    public String wyszukajPracownik() {
        return "pracownikWyszukany";
    }

    public DataModel getWyswietlWszystkichPracownik() {
        listaPracownikowNowa = new ListDataModel(PracownikWyszukaj.getListaPracownikow());
        return listaPracownikowNowa;
    }

    public DataModel getWyswietlWyszukanePracownik() {
        listaPracownikowWyszukanych = new ListDataModel(PracownikWyszukaj.getListWyszukanychPracownikow(PracownikDoWyszukania));
        return listaPracownikowWyszukanych;
    }

    public String goToIndex() {
        return "pracownikWidok";
    }

    public String pokazPracownik() throws CloneNotSupportedException {
        aktualnePracownik = (Pracownik) listaPracownikowNowa.getRowData();
        wyedytowanePracownik = (Pracownik) aktualnePracownik.clone();
        return "pracownikWybrany";
    }

    public String weryfikacjaDanych() throws IllegalAccessException, InstantiationException {

        List<Integer> listaRoznic = new ArrayList<Integer>();
        List<Object> aktPracownik = new ArrayList<Object>();
        List<Object> wyedPracownik = new ArrayList<Object>();

        if (!aktualnePracownik.getLogin().equals(wyedytowanePracownik.getLogin())) {
            setLoginPracownikBlad(!WeryfikacjaDanych.czyUnikalny("login", "pracownik", wyedytowanePracownik.getLogin()));
        }
        if (loginPracownikBlad) {
            saveMessage("Login juz istnieje podaj inny");
        }

        if (!loginPracownikBlad) {
            RequestContext context = RequestContext.getCurrentInstance();
            for (Field field : aktualnePracownik.getClass().getDeclaredFields()) {
                field.setAccessible(true); // You might want to set modifier to public first.
                Object value = field.get(aktualnePracownik);
                System.out.println("pole " + field.getName() + " wartosc " + value);
                aktPracownik.add(value);

                Object value2 = field.get(wyedytowanePracownik);
                wyedPracownik.add(value2);

            }
            listaRoznic.clear();
            listaRoznic = WyswietlSamochod.porownajDwieListy(aktPracownik, wyedPracownik);
            if (listaRoznic.isEmpty()) {
                return "pracownikWidok";
            } else {
                listaRoznicPracownik = Roznice.stworzListeRoznic(aktPracownik, wyedPracownik, listaRoznic, listaPol);
                context.execute("PF('dlg1').show();");
                return "pracownikWybrany";
            }

        } else {
            return "pracownikWybrany";
        }

    }

    public void saveMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

    public String zapiszWyedytowanegoPracownika() {

        PracownikZapytania.zapiszPracownik(wyedytowanePracownik);
        return "pracownikWidok";
    }

    public String usunPracownik() {
        usuwanePracownik = (Pracownik) listaPracownikowNowa.getRowData();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('potwierdzUsuwanie').show();");
        return "pracownikWidok";
    }

    public String potwierdzUsunieciePracownika() {
        PracownikZapytania.usunPracownik(usuwanePracownik.getId_pracownik());
        return "pracownikWidok";
    }

}
