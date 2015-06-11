/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author michal.krupiarz
 */
public class TypPojazdu {

    private long id_typ_pojazdu;
    private String nazwa;
    private int id_import;

    public TypPojazdu() {

    }

    public TypPojazdu(long id_typ_pojazdu, String nazwa, int id_import) {
        this.id_typ_pojazdu = id_typ_pojazdu;
        this.nazwa = nazwa;
        this.id_import = id_import;
    }

    public long getId_typ_pojazdu() {
        return id_typ_pojazdu;
    }

    public void setId_typ_pojazdu(long id_typ_pojazdu) {
        this.id_typ_pojazdu = id_typ_pojazdu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId_import() {
        return id_import;
    }

    public void setId_import(int id_import) {
        this.id_import = id_import;
    }

    
    
    
    
}
