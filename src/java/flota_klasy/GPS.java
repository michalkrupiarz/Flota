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
public class GPS {
    private long id_gps;
    private String gps_numer;
    
    public GPS(){
        
    }

    public GPS(long id_gps, String gps_numer) {
        this.id_gps = id_gps;
        this.gps_numer = gps_numer;
    }

    public long getId_gps() {
        return id_gps;
    }

    public void setId_gps(long id_gps) {
        this.id_gps = id_gps;
    }

    public String getGps_numer() {
        return gps_numer;
    }

    public void setGps_numer(String gps_numer) {
        this.gps_numer = gps_numer;
    }
    
}
