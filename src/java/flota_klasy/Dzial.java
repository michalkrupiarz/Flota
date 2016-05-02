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
public class Dzial implements Cloneable{
    private long id_dzial;
    private String nazwa_dzial;
    private long id_import;

    public long getId_dzial() {
        return id_dzial;
    }

    public void setId_dzial(long id_dzial) {
        this.id_dzial = id_dzial;
    }

    public String getNazwa_dzial() {
        return nazwa_dzial;
    }

    public void setNazwa_dzial(String nazwa_dzial) {
        this.nazwa_dzial = nazwa_dzial;
    }

    public long getId_import() {
        return id_import;
    }

    public void setId_import(long id_import) {
        this.id_import = id_import;
    }
    
    @Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
    
}
