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
public class GrupaLimit {
    private long id_grupa_limit;
    private String nazwa;
    private int id_import;
    
    public GrupaLimit(){
        
    }

    public GrupaLimit(long id_grupa_limit, String nazwa, int id_import) {
        this.id_grupa_limit = id_grupa_limit;
        this.nazwa = nazwa;
        this.id_import = id_import;
    }

    public long getId_grupa_limit() {
        return id_grupa_limit;
    }

    public void setId_grupa_limit(long id_grupa_limit) {
        this.id_grupa_limit = id_grupa_limit;
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
