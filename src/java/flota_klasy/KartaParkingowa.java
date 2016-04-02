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
public class KartaParkingowa implements Cloneable{
    private long id_karta_parkingowa;
    private String id_status_parkingowa;
    private String id_lokalizacja_parkingowa;
    private String numer_karta_parkingowa;
    private int id_importu;
    
    public KartaParkingowa(){
        
    }

    public KartaParkingowa(long id_karta_parkingowa, String id_status_parkingowa, String id_lokalizacja_parkingowa, String numer_karta_parkingowa, int id_importu) {
        this.id_karta_parkingowa = id_karta_parkingowa;
        this.id_status_parkingowa = id_status_parkingowa;
        this.id_lokalizacja_parkingowa = id_lokalizacja_parkingowa;
        this.numer_karta_parkingowa = numer_karta_parkingowa;
        this.id_importu = id_importu;
    }

    public long getId_karta_parkingowa() {
        return id_karta_parkingowa;
    }

    public void setId_karta_parkingowa(long id_karta_parkingowa) {
        this.id_karta_parkingowa = id_karta_parkingowa;
    }

    public String getId_status_parkingowa() {
        return id_status_parkingowa;
    }

    public void setId_status_parkingowa(String id_status_parkingowa) {
        this.id_status_parkingowa = id_status_parkingowa;
    }

    public String getId_lokalizacja_parkingowa() {
        return id_lokalizacja_parkingowa;
    }

    public void setId_lokalizacja_parkingowa(String id_lokalizacja_parkingowa) {
        this.id_lokalizacja_parkingowa = id_lokalizacja_parkingowa;
    }

    public String getNumer_karta_parkingowa() {
        return numer_karta_parkingowa;
    }

    public void setNumer_karta_parkingowa(String numer_karta_parkingowa) {
        this.numer_karta_parkingowa = numer_karta_parkingowa;
    }

    public int getId_importu() {
        return id_importu;
    }

    public void setId_importu(int id_importu) {
        this.id_importu = id_importu;
    }
    
     @Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
    
}
