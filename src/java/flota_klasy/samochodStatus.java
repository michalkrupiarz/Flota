/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

/**
 *
 * @author michal.krupiarz
 */
public class samochodStatus {
    private long id_samochod_status;
    private String nazwa_samochod_status;
    
    public samochodStatus(){
        
    }

    public samochodStatus(long id_samochod_status, String nazwa_samochod_status) {
        this.id_samochod_status = id_samochod_status;
        this.nazwa_samochod_status = nazwa_samochod_status;
    }

    public long getId_samochod_status() {
        return id_samochod_status;
    }

    public void setId_samochod_status(long id_samochod_status) {
        this.id_samochod_status = id_samochod_status;
    }

    public String getNazwa_samochod_status() {
        return nazwa_samochod_status;
    }

    public void setNazwa_samochod_status(String nazwa_samochod_status) {
        this.nazwa_samochod_status = nazwa_samochod_status;
    }
    
    
}
