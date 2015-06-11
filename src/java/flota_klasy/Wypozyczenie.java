/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.sql.Date;

/**
 *
 * @author michal.krupiarz
 */
public class Wypozyczenie {
    
    private long id_wypozyczenia;
    private String id_alertu;
    private String tresc_zlecenia;
    private String id_zlecajacego;
    private String id_pracownika_realizujacego;
    private Date data_zlecenia;
    private Date data_przyjecia_zlecenia;
    private Date data_zakonczenia_zlecenia;
    private String id_pojazdu;
    private String id_pracownika_wypozyczajacego;
    private String id_lokalizacja;
    
    public Wypozyczenie () {
        
    }
    
    public Wypozyczenie ( long id_wypozyczenia,
     String id_alertu,
     String tresc_zlecenia,
     String id_zlecajacego,
     String id_pracownika_realizujacego,
     Date data_zlecenia,
     Date data_przyjecia_zlecenia,
     Date data_zakonczenia_zlecenia,
     String id_pojazdu,
     String id_pracownika_wypozyczajacego,
     String id_lokalizacja){
        this.id_wypozyczenia = id_wypozyczenia;
        this.id_alertu = id_alertu;
        this.tresc_zlecenia = tresc_zlecenia;
        this.id_zlecajacego = id_zlecajacego;
        this.id_pracownika_realizujacego = id_pracownika_realizujacego;
        this.data_zlecenia = data_zlecenia;
        this.data_przyjecia_zlecenia = data_przyjecia_zlecenia;
        this.data_zakonczenia_zlecenia = data_zakonczenia_zlecenia;
        this.id_pojazdu = id_pojazdu;
        this.id_pracownika_wypozyczajacego = id_pracownika_wypozyczajacego;
        this.id_lokalizacja = id_lokalizacja;
    }

    public long getId_wypozyczenia() {
        return id_wypozyczenia;
    }

    public void setId_wypozyczenia(long id_wypozyczenia) {
        this.id_wypozyczenia = id_wypozyczenia;
    }

    public String getId_alertu() {
        return id_alertu;
    }

    public void setId_alertu(String id_alertu) {
        this.id_alertu = id_alertu;
    }

    public String getTresc_zlecenia() {
        return tresc_zlecenia;
    }

    public void setTresc_zlecenia(String tresc_zlecenia) {
        this.tresc_zlecenia = tresc_zlecenia;
    }

    public String getId_zlecajacego() {
        return id_zlecajacego;
    }

    public void setId_zlecajacego(String id_zlecajacego) {
        this.id_zlecajacego = id_zlecajacego;
    }

    public String getId_pracownika_realizujacego() {
        return id_pracownika_realizujacego;
    }

    public void setId_pracownika_realizujacego(String id_pracownika_realizujacego) {
        this.id_pracownika_realizujacego = id_pracownika_realizujacego;
    }

    public Date getData_zlecenia() {
        return data_zlecenia;
    }

    public void setData_zlecenia(Date data_zlecenia) {
        this.data_zlecenia = data_zlecenia;
    }

    public Date getData_przyjecia_zlecenia() {
        return data_przyjecia_zlecenia;
    }

    public void setData_przyjecia_zlecenia(Date data_przyjecia_zlecenia) {
        this.data_przyjecia_zlecenia = data_przyjecia_zlecenia;
    }

    public Date getData_zakonczenia_zlecenia() {
        return data_zakonczenia_zlecenia;
    }

    public void setData_zakonczenia_zlecenia(Date data_zakonczenia_zlecenia) {
        this.data_zakonczenia_zlecenia = data_zakonczenia_zlecenia;
    }

    public String getId_pojazdu() {
        return id_pojazdu;
    }

    public void setId_pojazdu(String id_pojazdu) {
        this.id_pojazdu = id_pojazdu;
    }

    public String getId_pracownika_wypozyczajacego() {
        return id_pracownika_wypozyczajacego;
    }

    public void setId_pracownika_wypozyczajacego(String id_pracownika_wypozyczajacego) {
        this.id_pracownika_wypozyczajacego = id_pracownika_wypozyczajacego;
    }

    public String getId_lokalizacja() {
        return id_lokalizacja;
    }

    public void setId_lokalizacja(String id_lokalizacja) {
        this.id_lokalizacja = id_lokalizacja;
    }
    
    
}

