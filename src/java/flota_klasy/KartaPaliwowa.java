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
public class KartaPaliwowa {
    
    private long id_karta_paliwowa;
    private String id_status_paliwowa;
    private String id_lokalizacja_paliwowa;
    private String numer_Karty;
    private String pin_karty;
    private int id_importu;
    
    public KartaPaliwowa(){
        
    }

    public KartaPaliwowa(long id_karta_paliwowa, String id_status_paliwowa, String id_lokalizacja_paliwowa, String numer_Karty, String pin_karty, int id_importu) {
        this.id_karta_paliwowa = id_karta_paliwowa;
        this.id_status_paliwowa = id_status_paliwowa;
        this.id_lokalizacja_paliwowa = id_lokalizacja_paliwowa;
        this.numer_Karty = numer_Karty;
        this.pin_karty = pin_karty;
        this.id_importu = id_importu;
    }

    public long getId_karta_paliwowa() {
        return id_karta_paliwowa;
    }

    public void setId_karta_paliwowa(long id_karta_paliwowa) {
        this.id_karta_paliwowa = id_karta_paliwowa;
    }

    public String getId_status_paliwowa() {
        return id_status_paliwowa;
    }

    public void setId_status_paliwowa(String id_status_paliwowa) {
        this.id_status_paliwowa = id_status_paliwowa;
    }

    public String getId_lokalizacja_paliwowa() {
        return id_lokalizacja_paliwowa;
    }

    public void setId_lokalizacja_paliwowa(String id_lokalizacja_paliwowa) {
        this.id_lokalizacja_paliwowa = id_lokalizacja_paliwowa;
    }

    public String getNumer_Karty() {
        return numer_Karty;
    }

    public void setNumer_Karty(String numer_Karty) {
        this.numer_Karty = numer_Karty;
    }

    public String getPin_karty() {
        return pin_karty;
    }

    public void setPin_karty(String pin_karty) {
        this.pin_karty = pin_karty;
    }

    public int getId_importu() {
        return id_importu;
    }

    public void setId_importu(int id_importu) {
        this.id_importu = id_importu;
    }
    
    
    
}
