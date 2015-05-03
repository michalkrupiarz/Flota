/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

/**
 *
 * @author M
 */
public class Lokalizacja {
private long id_lokalizacja;
private String nazwa_lokalizacja;
private int id_import;   

public Lokalizacja() {
    
}

    public Lokalizacja(long id_lokalizacja, String nazwa_lokalizacja, int id_import) {
        this.id_lokalizacja = id_lokalizacja;
        this.nazwa_lokalizacja = nazwa_lokalizacja;
        this.id_import = id_import;
    }

    public long getId_lokalizacja() {
        return id_lokalizacja;
    }

    public void setId_lokalizacja(long id_lokalizacja) {
        this.id_lokalizacja = id_lokalizacja;
    }

    public String getNazwa_lokalizacja() {
        return nazwa_lokalizacja;
    }

    public void setNazwa_lokalizacja(String nazwa_lokalizacja) {
        this.nazwa_lokalizacja = nazwa_lokalizacja;
    }

    public int getId_import() {
        return id_import;
    }

    public void setId_import(int id_import) {
        this.id_import = id_import;
    }


}
