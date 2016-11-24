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
 * @author M
 */
@ManagedBean
@SessionScoped
public class WyswietlSamochod {

    private String growlMessage;

    public String getGrowlMessage() {
        return growlMessage;
    }

    public void setGrowlMessage(String growlMessage) {
        this.growlMessage = growlMessage;
    }
    private boolean nazwaSamochoduBlad = false;
    private boolean NrRejSamochoduBlad = false;
    private boolean nr_umowy_leasingBlad = false;
    private boolean nr_umowy_serwisBlad = false;
    private boolean nr_vinBlad = false;
    private boolean prv_umowaBlad = false;
    private boolean nr_miejsca_parkingowegoBlad = false;
    private boolean showSaveDialog = true;
    long id;
    public boolean isFlaga;
    List<Lokalizacja> listaLokalizacji;
    List<Samochod> listaSamochodow;
    DataModel listaSamochodowNowa;
    Samochod samochod;
    private Samochod usuwanySamochod = new Samochod();
    private Samochod wyszukanySamochod = new Samochod();

    private Samochod aktualnySamochod = new Samochod();

    private Samochod wyedytowanySamochod = new Samochod();
    private List<Object> listaRoznicWzor = new ArrayList<Object>();
    private List<Object> listaRoznicKopia = new ArrayList<Object>();
    private List<String> listaPolZRoznicami = new ArrayList<String>();
    private List<String> listaPolDoWyswietlenia = new ArrayList<String>();
    private List<String> listaPol = asList("Id pola",
            "Nazwa pojazdu",
            "Marka pojazdu",
            "Model pojazdu",
            "Oznaczenie producenta pojazdu",
            "Rodzaj paliwa",
            "Nr rejesracyjny",
            "Nr VIN",
            "Status pojazdu",
            "Rodzaj opon",
            "Lokalizacja pojazduj",
            "Lokalizacja stała pojazduj",
            "Rodzaj pojazdu",
            "Numer karty parkingowej.",
            "Numer karty paliwowej.",
            "Przebieg",
            "Pracownik używający.",
            "Rok produkcji",
            "Numer ubezpieczenia.",
            "Data przyjęcia na stan.",
            "Data pierwszej rejestracji.",
            "Numer seryjny GPS.",
            "Kolor nadwozia.",
            "Wersja pojazdu.",
            "Typ samochodu.",
            "VAT.",
            "Grupa limit.",
            "Nr umowy leasingu.",
            "Nr umowy serwis.",
            "MPK.",
            "PRV umowa.",
            "Umowa z dnia.",
            "NR miejsca parkingowego.",
            "Rozmiar opon.");

    private List<Roznice> listaRoznicSamochod = new ArrayList<Roznice>();

    public List<Roznice> getListaRoznicSamochod() {
        return listaRoznicSamochod;
    }

    public void setListaRoznicSamochod(List<Roznice> listaRoznicSamochod) {
        this.listaRoznicSamochod = listaRoznicSamochod;
    }

    public List<String> getListaPol() {
        return listaPol;
    }

    public List<String> getListaPolDoWyswietlenia() {
        return listaPolDoWyswietlenia;
    }

    public void setListaPolDoWyswietlenia(List<String> listaPolDoWyswietlenia) {
        this.listaPolDoWyswietlenia = listaPolDoWyswietlenia;
    }

    public void setListaPol(List<String> listaPol) {
        this.listaPol = listaPol;
    }

    public List<Object> getListaRoznicWzor() {
        return listaRoznicWzor;
    }

    public void setListaRoznicWzor(List<Object> listaRoznicWzor) {
        this.listaRoznicWzor = listaRoznicWzor;
    }

    public List<Object> getListaRoznicKopia() {
        return listaRoznicKopia;
    }

    public void setListaRoznicKopia(List<Object> listaRoznicKopia) {
        this.listaRoznicKopia = listaRoznicKopia;
    }

    public List<String> getListaPolZRoznicami() {
        return listaPolZRoznicami;
    }

    public void setListaPolZRoznicami(List<String> listaPolZRoznicami) {
        this.listaPolZRoznicami = listaPolZRoznicami;
    }

    public Samochod getWyedytowanySamochod() {

        return wyedytowanySamochod;
    }

    public boolean isNr_miejsca_parkingowego() {
        return nr_miejsca_parkingowegoBlad;
    }

    public boolean isShowSaveDialog() {
        return showSaveDialog;
    }

    public void setShowSaveDialog(boolean showSaveDialog) {
        this.showSaveDialog = showSaveDialog;
    }

    public void setNr_miejsca_parkingowego(boolean nr_miejsca_parkingowego) {
        this.nr_miejsca_parkingowegoBlad = nr_miejsca_parkingowego;
    }

    public boolean isIsFlaga() {
        return isFlaga;
    }

    public void setIsFlaga(boolean isFlaga) {
        this.isFlaga = isFlaga;
    }

    public boolean isNazwaSamochoduBlad() {
        return nazwaSamochoduBlad;
    }

    public void setNazwaSamochoduBlad(boolean nazwaSamochoduBlad) {
        this.nazwaSamochoduBlad = nazwaSamochoduBlad;
    }

    public boolean isNrRejSamochoduBlad() {
        return NrRejSamochoduBlad;
    }

    public void setNrRejSamochoduBlad(boolean NrRejSamochoduBlad) {
        this.NrRejSamochoduBlad = NrRejSamochoduBlad;
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

    public Samochod getWyszukanySamochod() {
        return wyszukanySamochod;
    }

    public String pokazWszystkieSamochody() {

        return "index";
    }

    public Samochod getUsuwanySamochod() {
        return usuwanySamochod;
    }

    public void setUsuwanySamochod(Samochod usuwanySamochod) {
        this.usuwanySamochod = usuwanySamochod;
    }

    public String pokazSamochod() throws CloneNotSupportedException {
        aktualnySamochod = (Samochod) listaSamochodowNowa.getRowData();
        wyedytowanySamochod = (Samochod) aktualnySamochod.clone();
        return "wybranySamochod";
    }

    public Samochod getAktualnySamochod() {
        if (aktualnySamochod == null) {
            aktualnySamochod = new Samochod();
        }

        return aktualnySamochod;
    }

    public DataModel getWyswietlSamochod() {

        listaSamochodowNowa = new ListDataModel(WyszukajSamochod.getListaSamochodowWyszukanych(
                wyszukanySamochod
        ));

        return listaSamochodowNowa;
    }

    public String wyszukajSamochod() {

        return "wyszukaneSamochody";
    }
    
    public String wyszukajSamochodDoWypozyczenia(){
        return "samochodyZnalezioneDoWypozyczenia";
    }

    public DataModel getWyswietlWszystkieSamochody() {
        listaSamochodowNowa = new ListDataModel(WyszukajSamochod.getListaSamochodowNowa());

        return listaSamochodowNowa;
    }

    public DataModel getWyswietlwyszukanySamochod() {
        listaSamochodowNowa = new ListDataModel(WyszukajSamochod.getListaSamochodowWyszukanych(
                wyszukanySamochod));

        return listaSamochodowNowa;
    }

    public String zapiszWyedytowanySamochod() {
        System.out.println("XXX ODPALONO ZAPISYWANIE EDYTOWANEGO SAMOCHODU");
        SamochodZapytania.zapiszWyedytowanySamochod(wyedytowanySamochod, aktualnySamochod);
        return "index";

    }

    public String weryfikacjaDanych() throws IllegalAccessException, InstantiationException {

        List<Boolean> listaWeryfikacyjna = new ArrayList<Boolean>();
        List<Object> aktualnySamochodLista = new ArrayList<Object>();
        List<Object> wyedytowanySamochodLista = new ArrayList<Object>();
        List<Integer> listaRoznic = new ArrayList<Integer>();

        if (aktualnySamochod.getNazwa().equals(wyedytowanySamochod.getNazwa())) {
            setNazwaSamochoduBlad(WeryfikacjaDanych.czyUnikalny("nazwa", "samochod", wyedytowanySamochod.getNazwa()));
        } else {
            setNazwaSamochoduBlad(!WeryfikacjaDanych.czyUnikalny("nazwa", "samochod", wyedytowanySamochod.getNazwa()));
        }
        listaWeryfikacyjna.add(nazwaSamochoduBlad);

        if (aktualnySamochod.getNr_vin().equals(wyedytowanySamochod.getNr_vin())) {
            setNr_vinBlad(WeryfikacjaDanych.czyUnikalny("nr_vin", "samochod", wyedytowanySamochod.getNr_vin()));
        } else {
            setNr_vinBlad(!WeryfikacjaDanych.czyUnikalny("nr_vin", "samochod", wyedytowanySamochod.getNr_vin()));
        }
        listaWeryfikacyjna.add(nr_vinBlad);
        if (aktualnySamochod.getNr_umowy_leasingu().equals(wyedytowanySamochod.getNr_umowy_leasingu())) {
            setNr_umowy_leasingBlad(WeryfikacjaDanych.czyUnikalny("nr_umowy_leasingu", "samochod", wyedytowanySamochod.getNr_umowy_leasingu()));
        } else {
            setNr_umowy_leasingBlad(!WeryfikacjaDanych.czyUnikalny("nr_umowy_leasingu", "samochod", wyedytowanySamochod.getNr_umowy_leasingu()));
        }
        listaWeryfikacyjna.add(nr_umowy_leasingBlad);
        if (aktualnySamochod.getNr_umowy_serwis().equals(wyedytowanySamochod.getNr_umowy_serwis())) {
            setNr_umowy_serwisBlad(WeryfikacjaDanych.czyUnikalny("nr_umowy_serwis", "samochod", wyedytowanySamochod.getNr_umowy_serwis()));
        } else {
            setNr_umowy_serwisBlad(!WeryfikacjaDanych.czyUnikalny("nr_umowy_serwis", "samochod", wyedytowanySamochod.getNr_umowy_serwis()));
        }
        listaWeryfikacyjna.add(nr_umowy_leasingBlad);
        if (aktualnySamochod.getPrv_umowa().equals(wyedytowanySamochod.getPrv_umowa())) {
            setPrv_umowaBlad(WeryfikacjaDanych.czyUnikalny("prv_umowa", "samochod", wyedytowanySamochod.getPrv_umowa()));
        } else {
            setPrv_umowaBlad(!WeryfikacjaDanych.czyUnikalny("prv_umowa", "samochod", wyedytowanySamochod.getPrv_umowa()));
        }
        listaWeryfikacyjna.add(prv_umowaBlad);
        if (aktualnySamochod.getMiejsce_parkingowe().equals(wyedytowanySamochod.getMiejsce_parkingowe())) {
            setNr_miejsca_parkingowego(WeryfikacjaDanych.czyUnikalny("miejsce_parkingowe", "samochod", wyedytowanySamochod.getMiejsce_parkingowe()));
        } else {
            setNr_miejsca_parkingowego(!WeryfikacjaDanych.czyUnikalny("miejsce_parkingowe", "samochod", wyedytowanySamochod.getMiejsce_parkingowe()));
        }
        listaWeryfikacyjna.add(nr_miejsca_parkingowegoBlad);
        if (nr_miejsca_parkingowegoBlad) {
            saveMessage("Nr miejsca parkingowego jest już przypisany do innego pojazdu!");
        }
        if (prv_umowaBlad) {
            saveMessage("Nr umowy PRV wystęuje już w bazie danych!");
        }

        if (nr_umowy_serwisBlad) {
            saveMessage("Nr umowy serwisowej występuje już w bazie danych!");
        }

        if (nr_umowy_leasingBlad) {
            saveMessage("Nr umowy leasingu występuje już w bazie danych!");
        }

        if (nr_vinBlad) {
            saveMessage("Nr VIN samochodu wystepuje juz w bazie danych!");
        }

        if (nazwaSamochoduBlad) {
            saveMessage("Nazwa samochodu juz występuje!");
        }

        if (!czyJestTrue(listaWeryfikacyjna)) {
            RequestContext context = RequestContext.getCurrentInstance();

            for (Field field : aktualnySamochod.getClass().getDeclaredFields()) {
                field.setAccessible(true); // You might want to set modifier to public first.
                Object value = field.get(aktualnySamochod);
                System.out.println("pole " + field.getName() + " wartosc " + value);
                aktualnySamochodLista.add(value);

                Object value2 = field.get(wyedytowanySamochod);
                wyedytowanySamochodLista.add(value2);

            }
            listaRoznic.clear();
            listaRoznic = porownajDwieListy(aktualnySamochodLista, wyedytowanySamochodLista);
            if (listaRoznic.isEmpty()) {
                return "index";
            } else {
                listaRoznicSamochod = Roznice.stworzListeRoznic(aktualnySamochodLista, wyedytowanySamochodLista, listaRoznic, listaPol);
                context.execute("PF('dlg1').show();");
                return "wybranySamochod";
            }
        } else {
            return "wybranySamochod";
        }

    }

    public static List<Integer> porownajDwieListy(List<Object> wzor, List<Object> kopia) {
        int i = 0;
        List<Integer> listaRoznychDanych = new ArrayList<Integer>();
        for (Object item : wzor) {
            if (item != null) {
                if (!item.equals(kopia.get(i))) {
                    listaRoznychDanych.add(i);
                }
                i = i + 1;
            } else {
                i = i + 1;
            }
        }
        return listaRoznychDanych;
    }

    public void saveMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

    public void showMessage() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg1').show();");
    }

    public boolean czyJestTrue(List<Boolean> listaBooleanow) {
        boolean flaga = false;
        for (Boolean item : listaBooleanow) {
            if (item) {
                flaga = true;
            }
        }
        return flaga;
    }

    public String usunPojazd() {
        usuwanySamochod = (Samochod) listaSamochodowNowa.getRowData();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('potwierdzUsuwanie').show();");
        return "index";
    }

    public String potwierdzUsunieciePojazdu() {
        SamochodZapytania.usunPojazd(usuwanySamochod);
        return "index";
    }

    public String pokazIndex() {
        return "index";
    }
}
