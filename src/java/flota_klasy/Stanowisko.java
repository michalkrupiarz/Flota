/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author M
 */
@ManagedBean
@SessionScoped
public class Stanowisko implements Cloneable{
    private long id_stanowisko;
    private String nazwa_stanowisko;
    private long id_importu; 

    public long getId_stanowisko() {
        return id_stanowisko;
    }

    public void setId_stanowisko(long id_stanowisko) {
        this.id_stanowisko = id_stanowisko;
    }

    public String getNazwa_stanowisko() {
        return nazwa_stanowisko;
    }

    public void setNazwa_stanowisko(String nazwa_stanowisko) {
        this.nazwa_stanowisko = nazwa_stanowisko;
    }

    public long getId_importu() {
        return id_importu;
    }

    public void setId_importu(long id_importu) {
        this.id_importu = id_importu;
    }
     @Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
    
}
